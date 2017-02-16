package fakeaccount.com.saltedge.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import fakeaccount.com.saltedge.R;
import fakeaccount.com.saltedge.constant.AppConstant;
import fakeaccount.com.saltedge.json.AppJson;
import fakeaccount.com.saltedge.model.Provider;
import fakeaccount.com.saltedge.repository.ProvidersListRepository;
import fakeaccount.com.saltedge.service.CreateCustomerService;
import fakeaccount.com.saltedge.service.CreateLoginService;
import fakeaccount.com.saltedge.service.ProvidersListService;
import io.realm.Realm;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText loginEditTxt, passwordEditTxt;
    private TextInputLayout loginTxtInputLayout, passwordTxtInputLayout;
    private AutoCompleteTextView providerAutoCompleteTxtView;
    private Button connectBtn;
    private  ProvidersListService providersListService;
    private ProvidersListRepository providersListRepository;
    private CreateLoginService createLoginService;
    private SharedPreferences sharedPreferences;
    ArrayList<String> providers = new ArrayList<>();
    private String login, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        intializeViews();

        providersListService = new ProvidersListService();
        providersListRepository = new ProvidersListRepository();
        createLoginService = new CreateLoginService();
        
        createRealm();

    }

    private void createRealm()
    {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("Pref", 0);
        if ( pref.getBoolean("provider",true)) {
            try {
                providersListService.getProvidersList();
                setSharedPreferences();
                initializeAdapter();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else
        {
            initializeAdapter();
        }
    }

    private void intializeViews()
    {
        providerAutoCompleteTxtView = (AutoCompleteTextView)findViewById(R.id.provider);
        loginEditTxt = (EditText)findViewById(R.id.login);
        passwordEditTxt = (EditText)findViewById(R.id.password);
        loginTxtInputLayout = (TextInputLayout) findViewById(R.id.login_input);
        passwordTxtInputLayout = (TextInputLayout) findViewById(R.id.password_input);
        connectBtn = (Button)findViewById(R.id.connect);

        providerAutoCompleteTxtView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                loginTxtInputLayout.setVisibility(View.VISIBLE);
                passwordTxtInputLayout.setVisibility(View.VISIBLE);
                connectBtn.setVisibility(View.VISIBLE);
            }
        });

        connectBtn.setOnClickListener( this );
    }

    private void setSharedPreferences()
    {
        sharedPreferences = getSharedPreferences("Pref", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("provider",false);
        editor.commit();
    }

    private void initializeAdapter()
    {
        for (int i =0; i < providersListRepository.getProviderList().size(); i++) {
            providers.add(providersListRepository.getProviderList().get(i).getName());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this,android.R.layout.select_dialog_item,providers);
        providerAutoCompleteTxtView.setThreshold(1);
        providerAutoCompleteTxtView.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {

        if( v.equals(connectBtn) )
        {

            login = loginEditTxt.getText().toString();
            password = passwordEditTxt.getText().toString();

            if ( login.isEmpty() || password.isEmpty() )
            {
                Toast.makeText(this, "Please enter login and password fields..", Toast.LENGTH_SHORT).show();
            }
            else
            {
                SharedPreferences pref = getApplicationContext().getSharedPreferences("Customer", 0);
                try {
                    createLoginService.createLogin((pref.getInt(AppConstant.Login.CUSTOMER_ID, 0)),
                            AppConstant.Login.FAKE_CODE,
                            AppConstant.Login.FAKE_PROVIDER_CODE,
                            login,
                            password);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }

            }
        }
    }


}

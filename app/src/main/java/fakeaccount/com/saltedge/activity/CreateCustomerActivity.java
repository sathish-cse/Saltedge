package fakeaccount.com.saltedge.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import fakeaccount.com.saltedge.R;
import fakeaccount.com.saltedge.constant.AppConstant;
import fakeaccount.com.saltedge.model.Provider;
import fakeaccount.com.saltedge.service.CreateCustomerService;
import fakeaccount.com.saltedge.utils.UITools;

public class CreateCustomerActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText userNameEditTxt;
    private Button createBtn, loginBtn;
    private SharedPreferences sharedPreferences;
    private CreateCustomerService createCustomerService = new CreateCustomerService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_customer);

        intializeViews();

    }

    private void intializeViews() {
        userNameEditTxt = (EditText) findViewById(R.id.username);
        createBtn = (Button) findViewById(R.id.create);
        loginBtn = (Button) findViewById(R.id.login);

        createBtn.setOnClickListener(this);
        loginBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)  {

        if (v.equals(createBtn)) {
            try {
               // Toast.makeText(this, CreateCustomerService.createCustomer(userNameEditTxt.getText().toString()), Toast.LENGTH_SHORT).show();
               // UITools.showAlertDialog( this, "Success", "Customer Created Successfully..", null );
                setSharedPreference(createCustomerService.createCustomer(userNameEditTxt.getText().toString()));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        if (v.equals(loginBtn))
        {
            goToLoginActivity();
        }
    }

    private void goToLoginActivity()
    {
        Intent nextActivity = new Intent( CreateCustomerActivity.this, LoginActivity.class);
        startActivity(nextActivity);
    }

    private void setSharedPreference(String jsonResult)
    {
        sharedPreferences = getSharedPreferences("Customer", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        try {
            JSONObject jsonObj = new JSONObject(jsonResult);
            JSONObject data = jsonObj.getJSONObject("data");

            editor.putInt(AppConstant.Login.CUSTOMER_ID, data.getInt("id"));
            editor.putString(AppConstant.Login.IDENTIFIER, data.getString("identifier"));
            editor.putString(AppConstant.Login.SECRET, data.getString("secret"));
            editor.commit();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

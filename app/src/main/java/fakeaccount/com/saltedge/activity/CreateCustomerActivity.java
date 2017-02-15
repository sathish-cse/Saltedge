package fakeaccount.com.saltedge.activity;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;

import java.io.IOException;

import fakeaccount.com.saltedge.R;
import fakeaccount.com.saltedge.service.CreateCustomerService;
import fakeaccount.com.saltedge.service.ProvidersListService;
import fakeaccount.com.saltedge.utils.UITools;

public class CreateCustomerActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText userNameEditTxt;
    private Button createBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_customer);

        intializeViews();

    }

    private void intializeViews() {
        userNameEditTxt = (EditText) findViewById(R.id.username);
        createBtn = (Button) findViewById(R.id.create);

        createBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)  {

        if (v.equals(createBtn)) {
            try {
                Toast.makeText(this, CreateCustomerService.createCustomer(userNameEditTxt.getText().toString()), Toast.LENGTH_SHORT).show();
                UITools.showAlertDialog( this, "Success", "Customer Created Successfully..", null );
                Toast.makeText(this, ProvidersListService.providersList(), Toast.LENGTH_SHORT).show();

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

        }
    }
}

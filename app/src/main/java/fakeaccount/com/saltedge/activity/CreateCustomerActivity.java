package fakeaccount.com.saltedge.activity;

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
                Toast.makeText(this, CreateCustomerService.CreateCustomer(userNameEditTxt.getText().toString()), Toast.LENGTH_SHORT).show();
            }
            catch (Exception e)
            {
               if( e instanceof  IOException)
               {
                    Log.e("IOException : ", e.getMessage());
               }
                if( e instanceof  JSONException)
                {
                    Log.e("JSON Exception : ", e.getMessage());
                }
            }

        }
    }
}

package fakeaccount.com.saltedge.service;

import android.app.ProgressDialog;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;

import java.io.IOException;

import fakeaccount.com.saltedge.constant.AppConstant;
import fakeaccount.com.saltedge.json.AppJson;
import fakeaccount.com.saltedge.repository.CreateCustomerRepository;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class CreateCustomerService {

    public static String CreateCustomer( String identifier) throws IOException,JSONException {

        OkHttpClient client = new OkHttpClient();

        return CreateCustomerRepository. createCustomerRequest
                (client,
                        CreateCustomerRepository. getRequestHeader
                        (RequestBody. create
                                (AppConstant. Header. MEDIA_TYPE, AppJson. CreateCustomer (identifier))));
    }

}

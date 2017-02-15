package fakeaccount.com.saltedge.service;

import org.json.JSONException;

import java.io.IOException;

import fakeaccount.com.saltedge.constant.AppConstant;
import fakeaccount.com.saltedge.json.AppJson;
import fakeaccount.com.saltedge.repository.CreateCustomerRepository;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;


public class CreateCustomerService {

    public static String createCustomer(String identifier) throws IOException,JSONException {

        OkHttpClient client = new OkHttpClient();

        return CreateCustomerRepository. createCustomerRequest
                (client,
                        CreateCustomerRepository.postRequestHeader
                        (RequestBody. create
                                (AppConstant. Header. MEDIA_TYPE, AppJson. CreateCustomer (identifier))));
    }

}

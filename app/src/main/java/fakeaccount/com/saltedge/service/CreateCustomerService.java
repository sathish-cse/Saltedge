package fakeaccount.com.saltedge.service;

import org.json.JSONException;

import java.io.IOException;

import fakeaccount.com.saltedge.constant.AppConstant;
import fakeaccount.com.saltedge.json.AppJson;
import fakeaccount.com.saltedge.repository.CreateCustomerRepository;
import fakeaccount.com.saltedge.repository.CreateLoginRepository;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;


public class CreateCustomerService {

    private CreateCustomerRepository createCustomerRepository = new CreateCustomerRepository();

    public String createCustomer(String identifier) throws IOException,JSONException {

        OkHttpClient client = new OkHttpClient();

        return createCustomerRepository.createCustomerRequest
                (client,
                        createCustomerRepository.postRequestHeader
                                (RequestBody. create
                                        (AppConstant. Header. MEDIA_TYPE, AppJson. CreateCustomer (identifier))));
    }

}

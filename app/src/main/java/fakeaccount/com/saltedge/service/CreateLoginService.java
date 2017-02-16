package fakeaccount.com.saltedge.service;

import org.json.JSONException;

import java.io.IOException;

import fakeaccount.com.saltedge.constant.AppConstant;
import fakeaccount.com.saltedge.json.AppJson;
import fakeaccount.com.saltedge.repository.CreateCustomerRepository;
import fakeaccount.com.saltedge.repository.CreateLoginRepository;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;

/**
 * Created by Sathish on 16/02/17.
 */

public class CreateLoginService {

    private CreateLoginRepository createLoginRepository = new CreateLoginRepository();

    public String createLogin(int customerId, String countryCode, String providerCode, String login, String password ) throws IOException,JSONException {

        OkHttpClient client = new OkHttpClient();

        return createLoginRepository.createLoginRequest
                (client,
                        createLoginRepository.postRequestHeader
                                (RequestBody. create
                                        (AppConstant. Header. MEDIA_TYPE, AppJson.CreateLogin (customerId, countryCode, providerCode, login, password))));
    }

}

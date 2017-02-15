package fakeaccount.com.saltedge.service;

import org.json.JSONException;

import java.io.IOException;

import fakeaccount.com.saltedge.constant.AppConstant;
import fakeaccount.com.saltedge.json.AppJson;
import fakeaccount.com.saltedge.repository.CreateCustomerRepository;
import fakeaccount.com.saltedge.repository.ProvidersListRepository;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;



public class ProvidersListService {

    public static String providersList() throws IOException,JSONException {

        OkHttpClient client = new OkHttpClient();
        return ProvidersListRepository.getProvidersList( client, ProvidersListRepository.getRequestHeader() );

    }


}

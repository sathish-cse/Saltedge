package fakeaccount.com.saltedge.service;

import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import fakeaccount.com.saltedge.constant.AppConstant;
import fakeaccount.com.saltedge.model.Provider;
import fakeaccount.com.saltedge.repository.ProvidersListRepository;
import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.exceptions.RealmException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ProvidersListService {

    private ProvidersListRepository providersListRepository = new ProvidersListRepository();

    public void getProvidersList() throws IOException {

        OkHttpClient client = new OkHttpClient();

        client.newCall(getRequestHeader()).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("Failure : ", call.request().body().toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                providersListRepository.createRealm(response.body().string());
            }
        });
    }

    private static Request getRequestHeader()
    {
        return new Request.Builder()
                .url(AppConstant.ProvidersList.PROVIDERS_URL)
                .addHeader(AppConstant.Header.ACCEPT, AppConstant.Header.APP_JSON)
                .addHeader(AppConstant.Header.CONTENT_TYPE, AppConstant.Header.APP_JSON)
                .addHeader(AppConstant.Header.CLIENT_ID, AppConstant.ClientDetails.CLIENT_ID)
                .addHeader(AppConstant.Header.SERVICE_SECRET, AppConstant.ClientDetails.SERVICE_SECRET)
                .build();
    }


}

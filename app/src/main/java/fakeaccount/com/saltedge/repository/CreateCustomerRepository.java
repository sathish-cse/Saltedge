package fakeaccount.com.saltedge.repository;

import android.util.Log;

import java.io.IOException;

import fakeaccount.com.saltedge.constant.AppConstant;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class CreateCustomerRepository {

    private static String result;

    public static String createCustomerRequest( OkHttpClient client, Request request)
    {
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("Failure : ", call.request().body().toString());
                result = call.request().body().toString();
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.e("Success : ", response.body().string());
                result = response.body().string();
            }
        });

        return result;
    }

    public static Request postRequestHeader(RequestBody body)
    {
        return new Request.Builder()
                .url(AppConstant.CreateCustomer.CREATECUSTOMER_URL)
                .post(body)
                .addHeader(AppConstant.Header.ACCEPT, AppConstant.Header.APP_JSON)
                .addHeader(AppConstant.Header.CONTENT_TYPE, AppConstant.Header.APP_JSON)
                .addHeader(AppConstant.Header.CLIENT_ID, AppConstant.ClientDetails.CLIENT_ID)
                .addHeader(AppConstant.Header.SERVICE_SECRET, AppConstant.ClientDetails.SERVICE_SECRET)
                .build();
    }

}

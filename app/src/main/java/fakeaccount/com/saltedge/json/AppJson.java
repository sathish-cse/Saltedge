package fakeaccount.com.saltedge.json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import fakeaccount.com.saltedge.constant.AppConstant;
import fakeaccount.com.saltedge.repository.ProvidersListRepository;

public class AppJson {


    public static String CreateCustomer (String identifier) throws JSONException {
        JSONObject customerJson = new JSONObject().put(AppConstant.ClientDetails.DATA, new JSONObject()
                .put(AppConstant.ClientDetails.IDENTIFIER, identifier)) ;
        return customerJson.toString();
    }

    public static String CreateLogin (int customerId, String countryCode, String providerCode, String login, String password ) throws JSONException {
        JSONObject customerJson = new JSONObject().put(AppConstant.ClientDetails.DATA, new JSONObject()
                .put(AppConstant.Login.CUSTOMER_ID, customerId)
                .put(AppConstant.Login.COUNTRY_CODE, countryCode)
                .put(AppConstant.Login.PROVIDER_CODE, providerCode)
                .put(AppConstant.Login.FETCH_TYPE, AppConstant.Login.RECENT)
                .put(AppConstant.Login.CREDENTIALS, new JSONObject()
                    .put(AppConstant.Login.LOGIN, login)
                    .put(AppConstant.Login.PASSWORD, password)));
        return customerJson.toString();
    }
}

package fakeaccount.com.saltedge.json;

import org.json.JSONException;
import org.json.JSONObject;

import fakeaccount.com.saltedge.constant.AppConstant;

public class AppJson {

    public static String CreateCustomer (String identifier) throws JSONException {
        JSONObject customerJson = new JSONObject().put(AppConstant.ClientDetails.DATA, new JSONObject()
                .put(AppConstant.ClientDetails.IDENTIFIER, identifier)) ;
        return customerJson.toString();
    }
}

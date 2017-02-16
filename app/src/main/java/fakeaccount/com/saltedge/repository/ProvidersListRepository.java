package fakeaccount.com.saltedge.repository;

import android.content.SharedPreferences;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import fakeaccount.com.saltedge.constant.AppConstant;
import fakeaccount.com.saltedge.model.Provider;
import io.realm.Realm;
import io.realm.RealmResults;

import static android.content.Context.MODE_PRIVATE;

public class ProvidersListRepository {

    private Realm realm;
    private RealmResults<Provider> realmResults;

    public void createRealm(String jsonResult) {
        realm = Realm.getDefaultInstance();
        try {
            realm.beginTransaction();

            JSONObject jsonObj = new JSONObject(jsonResult);
            // Getting JSON Array node

            JSONArray data = jsonObj.getJSONArray("data");
            Log.e("Count : ", " = " + data.length());
            for (int i = 0; i < data.length(); i++) {
                realm.createObjectFromJson(Provider.class, data.get(i).toString());
            }
            realm.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Provider> getProviderList() {
        realm = Realm.getDefaultInstance();
        ArrayList<Provider> latestresults = new ArrayList<>();
        realmResults = realm.where(Provider.class).findAll();
        for (Provider i : realmResults) {
            latestresults.add(i);
        }
        return latestresults;
    }

}
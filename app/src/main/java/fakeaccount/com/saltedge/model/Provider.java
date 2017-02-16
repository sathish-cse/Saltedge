package fakeaccount.com.saltedge.model;

import io.realm.RealmObject;
import io.realm.annotations.Required;

/**
 * Created by Sathish on 15/02/17.
 */

public class Provider extends RealmObject{

    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

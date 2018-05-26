package com.midas2018mobile5.mobileapp.main.utils;

import android.content.Context;

import com.midas2018mobile5.mobileapp.model.CartItem;
import com.midas2018mobile5.mobileapp.model.MenuItem;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

/**
 * Created by Ji Hoon on 2018-05-26.
 */

public class RealmManager {
    private static Realm instance = null;

    public static void init(Context context) {
        Realm.init(context);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .schemaVersion(2)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(config);
        if(instance==null) {
            Realm.init(context);
            instance = Realm.getDefaultInstance();
        }
    }

    public static Realm getInstance() {
        return instance;
    }
    public static void clearRealm() {
        instance.beginTransaction();
        RealmResults<CartItem> query = instance.where(CartItem.class).findAll();
        if(!query.isEmpty())
            query.deleteAllFromRealm();
        instance.commitTransaction();
    }

}

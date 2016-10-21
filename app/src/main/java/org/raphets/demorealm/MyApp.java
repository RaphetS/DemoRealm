package org.raphets.demorealm;

import android.app.Application;

import io.realm.Realm;

/**
 * Created by matou0289 on 2016/10/21.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }
}

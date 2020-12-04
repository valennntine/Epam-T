package com.example.lab3;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;


public class MainService extends Service {

    public class MainServiceBinder extends Binder {
        public MainService getService(){
            return MainService.this;
        }
    }
    @Override
    public IBinder onBind(Intent intent) {
        return new MainServiceBinder();
    }

    public String getHelloWorldOnGermany() {
        return "Hallo Welt";
    }

    public String getHelloWorldOnJapanese() {
        return "こんにちは世界";
    }

    public String getHelloWorldOnRussia() {
        return "Привет, мир";
    }

    public String getHelloWorldOnSpain() {
        return "Hola mundo";
    }

    public String getHelloWorldOnChinese() {
        return "鹿茫赂忙陋碌";
    }


}

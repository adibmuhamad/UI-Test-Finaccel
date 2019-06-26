package com.example.finacceluitest;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;

import com.example.finacceluitest.views.MainActivity;

import static com.example.finacceluitest.BaseActivity.initStorage;

public class BaseApplication extends Application {

    private static BaseApplication instance;
    public static BaseApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initStorage();
    }

    public static void backToMain(Context context){
        Intent intent = new Intent(context, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        getInstance().startActivity(intent);
        ((Activity) context).finish();

    }
}

package com.example.finacceluitest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.finacceluitest.models.Storage;

public class BaseActivity extends AppCompatActivity {

    public static Storage storage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (storage == null) {
            storage = new Storage();
        }
    }

    public static void initStorage() {
        storage = new Storage();
    }
}

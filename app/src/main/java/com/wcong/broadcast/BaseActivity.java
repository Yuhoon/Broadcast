package com.wcong.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Arrays;

public class BaseActivity extends AppCompatActivity {

    private BroadcastReceiver receiver;
    private Class registerClass;

    private String action = "finishBroadcast";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        registerClass = this.getClass();
    }

    protected void registerActivity() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(action + registerClass.getName());
        receiver = getReceiver();
        registerReceiver(receiver, intentFilter);
    }

    protected void finishActivity(Class... classes) {
        Intent intent;
        for (Class aClass : Arrays.asList(classes)) {
            intent = new Intent();
            intent.setAction(action + aClass.getName());
            sendBroadcast(intent);
        }
    }

    private BroadcastReceiver getReceiver() {
        return new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                finish();
            }
        };
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (receiver != null)
            unregisterReceiver(receiver);
    }
}

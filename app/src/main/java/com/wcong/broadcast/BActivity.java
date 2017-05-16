package com.wcong.broadcast;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class BActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        registerActivity();
    }

    public void click(View view) {
        startActivity(new Intent(this, CActivity.class));
    }

}

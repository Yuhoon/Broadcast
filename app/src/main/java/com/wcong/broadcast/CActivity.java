package com.wcong.broadcast;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);
    }

    public void click(View view) {
        finishActivity(AActivity.class, BActivity.class);
        startActivity(new Intent(this, DActivity.class));
    }

}

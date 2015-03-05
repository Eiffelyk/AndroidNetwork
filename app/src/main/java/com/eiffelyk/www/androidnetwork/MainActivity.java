package com.eiffelyk.www.androidnetwork;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


/**
 *
 */
public class MainActivity extends Activity {
    private Button buttonWifi;
    private Button button3G;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonWifi = (Button) findViewById(R.id.wifi);
        button3G = (Button) findViewById(R.id.mobile);
        setListener();
    }

    private void setListener() {
        buttonWifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NetUtil.setWIFI(MainActivity.this, !NetUtil.isWIFIEnabled(MainActivity.this));
            }
        });
        button3G.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NetUtil.setMobileDataStatus(MainActivity.this, !NetUtil.isNetEnabled(MainActivity.this));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (NetUtil.isWIFIEnabled(MainActivity.this)) {
            buttonWifi.setText("关闭Wifi");
        } else {
            buttonWifi.setText("开启Wifi");
        }
        if (NetUtil.isNetEnabled(MainActivity.this)) {
            button3G.setText("关闭3G");
        } else {
            button3G.setText("开启3G");
        }
    }
}

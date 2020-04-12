package com.liaozhenhua.broadcast;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MyBroadcastReceiver.DaiLi{
   private MyBroadcastReceiver mbr ;
   private TextView tv ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mbr = new MyBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter("nanchang_1");
        registerReceiver(mbr,intentFilter);
        mbr.chuanSongZiJi(this);
        Button button1 =(Button) findViewById(R.id.button1);
        tv =(TextView) findViewById(R.id.textView);
        //按钮的点击事件
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //发送的逻辑代码
                Intent intent = new Intent();
                intent.setPackage("com.liaozhenhua.broadcast");
                intent.setAction("nanchang_1");
                intent.putExtra("xigua","6.5");
                sendBroadcast(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mbr);
    }

    @Override
    public void xieRu(String str) {
        tv.setText(str);
    }
}

package com.example.lixin.zhoukao1lianxi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MyCustomView.OnClickListener{

    private MyCustomView customView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        customView = (MyCustomView) findViewById(R.id.customview);
        customView.setOnClickListener(this);
    }

    @Override
    public void leftonClickListener(View btn_left) {
        Toast.makeText(this, "点击了,返回", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void rightonClickListener(View btn_right) {
        Toast.makeText(this, "点击了,更多哦", Toast.LENGTH_SHORT).show();
    }
}

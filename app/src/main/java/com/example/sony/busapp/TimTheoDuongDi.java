package com.example.sony.busapp;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.sony.busapp.Util.ConnectivityReceiver;
import com.example.sony.busapp.fragment.Fragment4;
import com.example.sony.busapp.fragment.Fragment5;

public class TimTheoDuongDi extends AppCompatActivity {
    Bundle data = new Bundle();

    public TimTheoDuongDi() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tim_theo_duong_di);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar);

        View view = getSupportActionBar().getCustomView();
        TextView tvTitle = (TextView) findViewById(R.id.tvName);
        tvTitle.setText("Chi Tiết Công Việc");

        ImageButton imageButton = (ImageButton) view.findViewById(R.id.action_bar_back);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectivityReceiver sconn = new ConnectivityReceiver();
                boolean checkconn = sconn.isConnected(TimTheoDuongDi.this);
                data.putBoolean("check", checkconn);
                if (checkconn == true) {
                    Log.d("test", "connected");
                } else {
                    Log.d("test", "not connected");
                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(TimTheoDuongDi.this, MainActivity.class);
                        intent.putExtra("data", data);
                        startActivity(intent);
                        finish();
                    }
                }, 0);
            }
        });

        Fragment4 fr4 = new Fragment4();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.fragmentduong, fr4);
        transaction.commit();


    }

    public void onSelectFragment(View view) {
        Fragment fr;
        if (view == view.findViewById(R.id.btnmap)) {
            fr = new Fragment4();
        } else if (view == view.findViewById(R.id.btnchitiet)) {
            fr = new Fragment5();
        } else {
            fr = new Fragment4();
        }

        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.fragmentduong, fr);
        transaction.addToBackStack(null);
        transaction.commit();

    }
}
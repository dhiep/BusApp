package com.example.sony.busapp;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.example.sony.busapp.fragment.Fragment4;
import com.example.sony.busapp.fragment.Fragment5;

public class TimTheoDuongDi extends AppCompatActivity {

    public TimTheoDuongDi() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tim_theo_duong_di);

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
package com.test.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.os.Bundle;

public class MainActivity extends FragmentActivity implements MyFragment.MyClickListener {
    private FragmentManager fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragment.beginTransaction();
        fragmentTransaction.replace(R.id.container, new MyFragment());
        fragmentTransaction.commit();
    }

    @Override
    public void click(SanPham sanPham) {
        FragmentTransaction fragmentTransaction = fragment.beginTransaction();
        fragmentTransaction.replace(R.id.container, new MyFragmentDetail(sanPham.getDescription()));
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
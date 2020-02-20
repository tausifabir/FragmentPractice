package com.example.fragmentpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.fragmentpractice.Fragment.BlankFragment;
import com.example.fragmentpractice.Fragment.BlankFragment2;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        BlankFragment blankFragment = new BlankFragment();
        ft.add(R.id.fragmentContainer,blankFragment);
        ft.addToBackStack(null);
        ft.commit();



    }
}

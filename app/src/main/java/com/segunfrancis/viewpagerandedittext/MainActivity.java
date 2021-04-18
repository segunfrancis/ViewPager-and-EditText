package com.segunfrancis.viewpagerandedittext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String email = "";
    private String phone = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainViewModel mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        PhoneFieldFragment phoneFieldFragment = new PhoneFieldFragment();
        EmailFieldFragment emailFieldFragment = new EmailFieldFragment();
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(phoneFieldFragment);
        fragmentList.add(emailFieldFragment);
        SwipeAdapter swipeAdapter = new SwipeAdapter(this, fragmentList);
        ViewPager2 viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(swipeAdapter);

        Button button = findViewById(R.id.get_field_button);

        mainViewModel.email.observe(MainActivity.this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                email = s;
            }
        });

        mainViewModel.phone.observe(MainActivity.this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                phone = s;
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Email: " + email + "\nPhone: " + phone, Toast.LENGTH_SHORT).show();
                // Both email and phone number are available here, so you can call your setValue() method here
            }
        });
    }
}

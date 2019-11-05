package com.example.proloy.lifesaver;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.proloy.lifesaver.Fragment.HomeFragment;
import com.example.proloy.lifesaver.Fragment.MessageFragment;
import com.example.proloy.lifesaver.Fragment.ProfileFragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView ;
    private HomeFragment homeFragment;
    private ProfileFragment profileFragment;
    private MessageFragment messageFragment ;
    //private CartFragment cartFragment ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottomBar);

        homeFragment = new HomeFragment();
        profileFragment = new ProfileFragment();
        messageFragment = new MessageFragment();

        setFragment(homeFragment);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home:
                        setFragment(homeFragment);
                        return true;

                    case R.id.profile:
                        setFragment(profileFragment);
                        return true;

                    case R.id.message:
                        setFragment(messageFragment);
                        return true;

                    default:
                        return false;
                }
            }
        });

    }

    public void setFragment(Fragment fragment)
    {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.mainFrame,fragment);
        fragmentTransaction.commit();
    }
}

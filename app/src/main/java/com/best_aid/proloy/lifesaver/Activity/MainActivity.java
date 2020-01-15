package com.best_aid.proloy.lifesaver.Activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.best_aid.proloy.lifesaver.Fragment.HomeFragment;
import com.best_aid.proloy.lifesaver.Fragment.MessageFragment;
import com.best_aid.proloy.lifesaver.Fragment.ProfileFragment;
import com.best_aid.proloy.lifesaver.R;

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

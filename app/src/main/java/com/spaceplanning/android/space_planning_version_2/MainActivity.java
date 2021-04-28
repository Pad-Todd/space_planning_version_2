package com.spaceplanning.android.space_planning_version_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity{

    private static final int RC_SIGN_IN = 1000;
    private static List<AuthUI.IdpConfig> providers = null;

    public static FirebaseUser mUserInfo;
    // Bottom-Bar
    private BottomNavigationView mBottomNV;
    // Menu-Btn & Menu-List
    private static Button mMenuBtn;
    private static LinearLayout mMenuBar;
    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signin();

        //Bottom-Bar Setting
        mBottomNV = findViewById(R.id.nav_view);
        mBottomNV.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                BottomNavigate(item.getItemId());
                return true;
            }
        });
        mBottomNV.setSelectedItemId(R.id.navigation_1);
        mMenuBtn = (Button)findViewById(R.id.menu_btn);
        mMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("text", "text-fuck " + String.valueOf(mMenuBar));
                mMenuBar = (LinearLayout) findViewById(R.id.menu_bar);
                if(mMenuBar.getVisibility() == View.GONE){
                    mMenuBar.setVisibility(View.VISIBLE);
                } else if(mMenuBar.getVisibility() == View.VISIBLE) {
                    mMenuBar.setVisibility(View.GONE);
                }
            }
        });


    }

    private void BottomNavigate(int itemId) {
        String tag = String.valueOf(itemId);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Fragment currentFragment = fragmentManager.getPrimaryNavigationFragment();

        if(currentFragment != null) {
            fragmentTransaction.hide(currentFragment);
        }

        Fragment fragment = fragmentManager.findFragmentByTag(tag);
        if (fragment == null) {
            if (itemId == R.id.navigation_1) {
                fragment = new FragmentPage1();

            } else if (itemId == R.id.navigation_2){
                fragment = new StoreListFragment();


            }else {
                fragment = new FragmentPage3();
            }
            fragmentTransaction.add(R.id.content_layout, fragment, tag);
        } else {
            fragmentTransaction.show(fragment);
        }

        fragmentTransaction.setPrimaryNavigationFragment(fragment);
        fragmentTransaction.setReorderingAllowed(true);
        fragmentTransaction.commitNow();

    }

    private void signin() {
        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setTheme(getSelectedTheme())
                        .setLogo(getSelectedLogo())
                        .setAvailableProviders(getProviders())
                        .build(),
                RC_SIGN_IN);
    }

    private List<AuthUI.IdpConfig> getProviders() {
        providers = Arrays.asList(
                new AuthUI.IdpConfig.EmailBuilder().build(),
                new AuthUI.IdpConfig.GoogleBuilder().build());
        return providers;
    }

    private int getSelectedLogo() {
        return AuthUI.NO_LOGO;
    }

    private int getSelectedTheme() {
        return AuthUI.getDefaultTheme();
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("text", "check onActivityResult");
        if (requestCode == RC_SIGN_IN) {
            IdpResponse response = IdpResponse.fromResultIntent(data);
            if (resultCode == RESULT_OK) {
                // Successfully signed in
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                Log.d("text", user.getDisplayName());
                if(user != null) {
                    changelogInfo(user);
                }
                // ...
            } else {
                // Sign in failed. If response is null the user canceled the
                // sign-in flow using the back button. Otherwise check
                // response.getError().getErrorCode() and handle the error.
                // ...
            }
        }
    }

    private void changelogInfo(FirebaseUser user) {
        Button loginInfo = (Button) findViewById(R.id.log_info);
        loginInfo.setText(user.getDisplayName());
        mUserInfo = user;

    }


}
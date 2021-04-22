package com.spaceplanning.android.space_planning_version_2;

import android.os.Bundle;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

public class StoreActivity extends SingleFragmentActivity {

   @Override
    protected Fragment createFragment(){
       return new StoreFragment();
   }
}
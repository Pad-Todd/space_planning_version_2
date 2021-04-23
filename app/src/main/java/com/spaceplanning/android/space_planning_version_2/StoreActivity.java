package com.spaceplanning.android.space_planning_version_2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import java.util.UUID;

public class StoreActivity extends SingleFragmentActivity {
    private static final String EXTRA_STORE_ID = "com.spaceplannin.android.space_planning_version_2.store_id";

    public static Intent newIntent(Context packgeContext, UUID storeId){
        Intent intent = new Intent(packgeContext, StoreActivity.class);
        intent.putExtra(EXTRA_STORE_ID, storeId);
        return intent;
    }

    @Override
    protected Fragment createFragment(){
        UUID storeId = (UUID) getIntent()
                .getSerializableExtra(EXTRA_STORE_ID);
        return StoreFragment.newInsatnce(storeId);
    }
}
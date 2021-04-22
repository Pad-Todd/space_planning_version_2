package com.spaceplanning.android.space_planning_version_2;

import androidx.fragment.app.Fragment;

public class StoreListActivity extends SingleFragmentActivity{
    @Override
    protected Fragment createFragment() {
        return new StoreListFragment();
    }
}

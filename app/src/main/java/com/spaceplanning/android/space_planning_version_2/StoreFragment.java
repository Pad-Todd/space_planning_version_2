package com.spaceplanning.android.space_planning_version_2;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.UUID;

public class StoreFragment extends Fragment {
    private static final String ARG_Store_ID = "store_id";
    private Store mStore;
    private TextView mStoreName;
    private EditText mStoreReviewTitleField;
    private EditText mStoreReviewDetailField;
    private Button mStoreUsedDateButton;

    public static StoreFragment newInsatnce(UUID storeId){
        Bundle args = new Bundle();
        args.putSerializable(ARG_Store_ID, storeId);

        StoreFragment storeFragment = new StoreFragment();
        storeFragment.setArguments(args);
        return storeFragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID storeId = (UUID) getArguments().getSerializable(ARG_Store_ID);

        mStore = StoreLab.get(getActivity()).getStore(storeId);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_store, container, false);
        mStoreName = (TextView) view.findViewById(R.id.storename);
        mStoreName.setText(mStore.getStoreName());
        mStoreName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mStore.setStoreReviewTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mStoreUsedDateButton = (Button)view.findViewById(R.id.storeuseddate);
        mStoreUsedDateButton.setText(mStore.getDate().toString());
        mStoreUsedDateButton.setEnabled(false);

        return view;
    }
}

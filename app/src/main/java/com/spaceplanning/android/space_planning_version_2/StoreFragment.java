package com.spaceplanning.android.space_planning_version_2;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class StoreFragment extends Fragment {
    private Store mStore;
    private EditText mStoreReviewTitleField;
    private EditText mStoreReviewDetailField;
    private Button mDateButton;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mStore = new Store();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_store, container, false);
        mStoreReviewTitleField = (EditText)view.findViewById(R.id.storereviewtitle);
        mStoreReviewTitleField.addTextChangedListener(new TextWatcher() {
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
        mStoreReviewDetailField = (EditText)view.findViewById(R.id.storereviewdetail);
        mStoreReviewDetailField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mStore.setStoreReviewDetail(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mDateButton = (Button)view.findViewById(R.id.storeuseddate);
        mDateButton.setText(mStore.getDate().toString());
        mDateButton.setEnabled(false);


        return view;
    }
}

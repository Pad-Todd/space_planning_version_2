package com.spaceplanning.android.space_planning_version_2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class FragmentPage3 extends Fragment {

    public TextView mUserName;
    public TextView mUserEmail;
    protected static FirebaseUser mUserInfo;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_page_3, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mUserName = (TextView) view.findViewById(R.id.right_item_user_name);
        mUserEmail = (TextView) view.findViewById(R.id.right_item_user_email);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // 파이어베이스 인증 확인 필수
        mUserInfo = FirebaseAuth.getInstance().getCurrentUser();
        mUserName.setText(mUserInfo.getDisplayName());
        mUserEmail.setText(mUserInfo.getEmail());
    }
}

package com.spaceplanning.android.space_planning_version_2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import static android.view.View.VISIBLE;

public class StoreListFragment extends Fragment {
    private RecyclerView mStoreRecyclerView;
    private StoreAdapter mStoreAdapter;

    // Menu-Btn & Menu-List
    private static Button mMenuBtn;
    private static LinearLayout mMenuBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_store_list, container, false);
        mStoreRecyclerView = (RecyclerView) view
                .findViewById(R.id.crime_recycler_view);
        mStoreRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    private void updateUI(){
        StoreLab storeLab = StoreLab.get(getActivity());
        List<Store> stores = storeLab.getStores();

        if(mStoreAdapter == null){
            mStoreAdapter = new StoreAdapter(stores);
            mStoreRecyclerView.setAdapter(mStoreAdapter);
        }
        else {
            mStoreAdapter.notifyDataSetChanged();
        }
    }

    private class StoreHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView mStoreNameTextView;
        private TextView mStoreNumberTextView;
        private Store mStore;


        public StoreHolder(View itemView){
            super(itemView);
            itemView.setOnClickListener(this);

            mStoreNameTextView = (TextView) itemView.findViewById(R.id.list_item_store_name_text_view);
            mStoreNumberTextView = (TextView) itemView.findViewById(R.id.list_item_store_number_text_view);
        }
        public void bindStore(Store store){
            mStore = store;
            mStoreNameTextView.setText(mStore.getStoreName());
            mStoreNumberTextView.setText(mStore.getStoreNumber());
        }

        @Override
        public void onClick(View v) {
            Intent intent = StoreActivity.newIntent(getActivity(), mStore.getId());
            startActivity(intent);
        }
    }

    private class StoreAdapter extends RecyclerView.Adapter<StoreHolder> {
        private List<Store> mStores;

        public StoreAdapter(List<Store> stores){
            mStores = stores;
        }

        @NonNull
        @Override
        public StoreHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater
                    .inflate(R.layout.list_item_store , parent, false);
            return new StoreHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull StoreHolder holder, int position) {
            Store store = mStores.get(position);
            holder.bindStore(store);
        }

        @Override
        public int getItemCount() {
            return mStores.size();
        }



    }
}

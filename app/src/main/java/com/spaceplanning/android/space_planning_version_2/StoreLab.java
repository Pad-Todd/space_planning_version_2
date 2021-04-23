package com.spaceplanning.android.space_planning_version_2;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class StoreLab {
    private static StoreLab sStoreLab;
    private List<Store> mStores;

    public static StoreLab get(Context context){
        if(sStoreLab == null){
            sStoreLab = new StoreLab(context);
        }
        return sStoreLab;
    }
    private StoreLab(Context context){
        mStores = new ArrayList<>();
        for(int i=0; i< 50; i++){
            Store store = new Store();
            store.setStoreName("가게이름 #"+i);
            mStores.add(store);
        }
    }
    public List<Store> getStores(){
        return mStores;
    }
    public Store getStore(UUID id){
        for (Store store: mStores){
            if(store.getId().equals(id)){
                return store;
            }
        }
        return null;
    }
}

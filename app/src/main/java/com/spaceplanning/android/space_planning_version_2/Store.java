package com.spaceplanning.android.space_planning_version_2;

import java.util.Date;
import java.util.UUID;

public class Store {
    private UUID mId;
    private String mStoreReviewTitle;
    private String mStoreReviewDetail;
    private Date mDate;
    private String mStoreName;
    private String mStoreNumber;

    public Store(){
        mId = UUID.randomUUID();
        mDate = new Date();
    }

    public UUID getId() {
        return mId;
    }

    public String getStoreReviewTitle() {
        return mStoreReviewTitle;
    }

    public void setStoreReviewTitle(String storeReviewTitle) {
        mStoreReviewTitle = storeReviewTitle;
    }

    public String getStoreReviewDetail() {
        return mStoreReviewDetail;
    }

    public void setStoreReviewDetail(String storeReviewDetail) {
        mStoreReviewDetail = storeReviewDetail;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public String getStoreName() {
        return mStoreName;
    }

    public void setStoreName(String storeName) {
        mStoreName = storeName;
    }

    public String getStoreNumber() {
        return mStoreNumber;
    }

    public void setStoreNumber(String storeNumber) {
        mStoreNumber = storeNumber;
    }
}

package com.ciandt.hackathon.sorocaba.util;

/**
 * Created by falvojr on 7/26/2015.
 */
public class BusinessException extends RuntimeException {

    private int mMessageRes;
    private boolean mUnexpected;

    public BusinessException(Throwable throwable) {
        super(throwable);
        mUnexpected = true;
    }

    public BusinessException(int messageRes) {
        super();
        mMessageRes = messageRes;
        mUnexpected = false;
    }

    public boolean isUnexpected() {
        return mUnexpected;
    }

    public int getMessageRes() {
        return mMessageRes;
    }
}

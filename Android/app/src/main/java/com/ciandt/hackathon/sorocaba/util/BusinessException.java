package com.ciandt.hackathon.sorocaba.util;

import com.ciandt.hackathon.sorocaba.R;

/**
 * Created by falvojr on 7/26/2015.
 */
public class BusinessException extends RuntimeException {

    private int mMessageRes;

    public BusinessException(Throwable throwable) {
        super(throwable);
        mMessageRes = R.string.msg_unexpected;
    }

    public BusinessException(int messageRes) {
        super();
        mMessageRes = messageRes;
    }

    public int getMessageRes() {
        return mMessageRes;
    }
}

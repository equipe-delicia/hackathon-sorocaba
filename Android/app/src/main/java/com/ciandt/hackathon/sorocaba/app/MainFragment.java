package com.ciandt.hackathon.sorocaba.app;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ciandt.hackathon.sorocaba.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends BaseFragment<MainActivity> {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }


}

package com.ciandt.hackathon.sorocaba.app;

import android.support.v4.app.Fragment;

import com.ciandt.hackathon.sorocaba.R;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Navigation drawer menu enumeration.
 *
 * @author falvojr
 */
public enum NavigationDrawerMenu {
    SECTION_01(R.string.title_dashboard, MainFragment.class);

    private static final Map<Integer,NavigationDrawerMenu> sLookup = new HashMap<>();

    static {
        for(NavigationDrawerMenu menu : EnumSet.allOf(NavigationDrawerMenu.class)) {
            sLookup.put(menu.ordinal(), menu);
        }
    }

    private int mTitleRes;
    private Class<? extends Fragment>  mFragmentClass;

    private NavigationDrawerMenu(int titleRes, Class<? extends Fragment> fragmentClass) {
        mTitleRes = titleRes;
        mFragmentClass = fragmentClass;
    }

    public int getTitleRes() {
        return mTitleRes;
    }

    public Class<? extends Fragment> getFragmentClass() {
        return mFragmentClass;
    }

    public static NavigationDrawerMenu valueOf(int ordinal) {
        return sLookup.get(ordinal);
    }
}

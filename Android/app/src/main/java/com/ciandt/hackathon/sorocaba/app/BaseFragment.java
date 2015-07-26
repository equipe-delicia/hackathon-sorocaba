package com.ciandt.hackathon.sorocaba.app;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.ciandt.hackathon.sorocaba.util.AppUtil;

/**
 * Base navigation-drawer-based fragment.
 *
 * @author falvojr
 */
public abstract class BaseFragment<T extends AppCompatActivity> extends Fragment {

    public static final String TAG = BaseFragment.class.getSimpleName();

    /**
     * The fragment argument representing the section number for this fragment.
     */
    public static final String ARG_SECTION_NUMBER = "ARG_SECTION_NUMBER";

    public BaseFragment() {
        super();
    }

    protected T getSpecificActivity() {
        return AppUtil.get(super.getActivity());
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof  MainActivity) {
            ((MainActivity) activity).onSectionAttached(getArguments().getInt(ARG_SECTION_NUMBER));
        }
    }

}

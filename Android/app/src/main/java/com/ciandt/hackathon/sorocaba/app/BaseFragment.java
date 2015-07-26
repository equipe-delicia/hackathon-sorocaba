package com.ciandt.hackathon.sorocaba.app;

import android.app.Activity;
import android.app.ProgressDialog;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import com.ciandt.hackathon.sorocaba.R;
import com.ciandt.hackathon.sorocaba.util.AppUtil;

/**
 * Base navigation-drawer-based fragment.
 *
 * @author falvojr
 */
public abstract class BaseFragment<T extends AppCompatActivity> extends Fragment {

    public static final String TAG = BaseFragment.class.getSimpleName();

    protected ProgressDialog mProgressBar;

    /**
     * The fragment argument representing the section number for this fragment.
     */
    public static final String ARG_SECTION_NUMBER = "ARG_SECTION_NUMBER";

    public BaseFragment() {
        super();
    }

    private ProgressDialog getProgressBar() {
        if (mProgressBar == null) {
            mProgressBar = new ProgressDialog(super.getActivity());
            mProgressBar.setIndeterminate(true);
            mProgressBar.setCancelable(false);
            mProgressBar.setMessage(super.getString(R.string.msg_loading));
        }
        return mProgressBar;
    }

    protected void showProgressDialog() {
        getProgressBar().show();
    }

    protected void dismissProgressDialog() {
        getProgressBar().dismiss();
    }

    protected void showDialogAlert(String message) {
        new AlertDialog.Builder(super.getActivity())
                .setTitle(this.getString(R.string.title_alert))
                .setPositiveButton(R.string.ok, null)
                .setMessage(message)
                .show();
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

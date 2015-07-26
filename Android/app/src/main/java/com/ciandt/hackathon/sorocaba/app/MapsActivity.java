package com.ciandt.hackathon.sorocaba.app;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.util.Log;

import com.ciandt.hackathon.sorocaba.R;
import com.ciandt.hackathon.sorocaba.entity.Marker;
import com.ciandt.hackathon.sorocaba.http.HttpService;
import com.ciandt.hackathon.sorocaba.util.BusinessException;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private static final String TAG = MapsActivity.class.getSimpleName();

    protected ProgressDialog mProgressBar;
    private List<Marker> mMarkes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        new ReservoirAsyncTask().execute();

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     */
    @Override
    public void onMapReady(GoogleMap map) {
        do {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Log.i(TAG, "Aguardando Marker's.");
            }
        } while (mMarkes == null);
        if (mMarkes.isEmpty()) {

        } else {
            LatLng lastLatLng = null;
            for (Marker marker : mMarkes) {
                boolean isFine = marker.getCurrentValue() >= marker.getAverage();
                lastLatLng = new LatLng(marker.getLat(), marker.getLon());
                map.addMarker(new MarkerOptions()
                        .position(lastLatLng)
                        .title(marker.getName())
                        .icon(BitmapDescriptorFactory.defaultMarker(isFine ? BitmapDescriptorFactory.HUE_GREEN : BitmapDescriptorFactory.HUE_RED)));
            }
            // Move the camera instantly to hamburg with a zoom of 15.
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(lastLatLng, 15));

            // Zoom in, animating the camera.
            map.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);
        }
    }

    private class ReservoirAsyncTask extends AsyncTask<Void, Void, Void> {

        private String businessMessage;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            MapsActivity.this.showProgressDialog();
        }

        @Override
        protected Void doInBackground(Void... maps) {
            try {
                mMarkes = HttpService.getInstance().getMarkes();
            } catch (BusinessException businessException) {
                businessMessage = getString(businessException.getMessageRes());
                mMarkes = new ArrayList<>();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void voids) {
            super.onPostExecute(voids);
            MapsActivity.this.dismissProgressDialog();
            if (businessMessage != null) {
                showDialogAlert(businessMessage);
            }
        }
    }

    private ProgressDialog getProgressBar() {
        if (mProgressBar == null) {
            mProgressBar = new ProgressDialog(this);
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
        new AlertDialog.Builder(this)
                .setTitle(this.getString(R.string.title_alert))
                .setPositiveButton(R.string.ok, null)
                .setMessage(message)
                .show();
    }
}
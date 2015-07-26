package com.ciandt.hackathon.sorocaba.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by robson on 26/07/15.
 */
public class Marker implements Parcelable {

    @JsonProperty("name")
    private String mName;
    @JsonProperty("average")
    private double mAverage;
    @JsonProperty("currentvalue")
    private double mCurrentvalue;
    @JsonProperty("lat")
    private String mLat;
    @JsonProperty("lon")
    private String mLon;

    public Marker() {}

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public double getAverage() {
        return mAverage;
    }

    public void setAverage(double average) {
        this.mAverage = average;
    }

    public double getCurrentvalue() {
        return mCurrentvalue;
    }

    public void setCurrentvalue(double currentvalue) {
        this.mCurrentvalue = currentvalue;
    }

    public String getLat() {
        return mLat;
    }

    public void setLat(String lat) {
        this.mLat = lat;
    }

    public String getLon() {
        return mLon;
    }

    public void setLon(String lon) {
        this.mLon = lon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Marker)) return false;

        Marker marker = (Marker) o;

        if (Double.compare(marker.mAverage, mAverage) != 0) return false;
        if (Double.compare(marker.mCurrentvalue, mCurrentvalue) != 0) return false;
        if (!mName.equals(marker.mName)) return false;
        if (!mLat.equals(marker.mLat)) return false;
        return mLon.equals(marker.mLon);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = mName.hashCode();
        temp = Double.doubleToLongBits(mAverage);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(mCurrentvalue);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + mLat.hashCode();
        result = 31 * result + mLon.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Marker{" +
                "mName='" + mName + '\'' +
                ", mAverage=" + mAverage +
                ", mCurrentvalue=" + mCurrentvalue +
                ", mLat='" + mLat + '\'' +
                ", mLon='" + mLon + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mName);
        dest.writeDouble(this.mAverage);
        dest.writeDouble(this.mCurrentvalue);
        dest.writeString(this.mLat);
        dest.writeString(this.mLon);
    }

    protected Marker(Parcel in) {
        this.mName = in.readString();
        this.mAverage = in.readDouble();
        this.mCurrentvalue = in.readDouble();
        this.mLat = in.readString();
        this.mLon = in.readString();
    }

    public static final Parcelable.Creator<Marker> CREATOR = new Parcelable.Creator<Marker>() {
        public Marker createFromParcel(Parcel source) {
            return new Marker(source);
        }

        public Marker[] newArray(int size) {
            return new Marker[size];
        }
    };

}

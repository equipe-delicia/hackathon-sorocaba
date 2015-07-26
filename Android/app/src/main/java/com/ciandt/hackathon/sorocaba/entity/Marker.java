package com.ciandt.hackathon.sorocaba.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by robson on 26/07/15.
 */
public class Marker {

    @JsonProperty("name")
    private String mName;
    @JsonProperty("average")
    private double mAverage;
    @JsonProperty("currentvalue")
    private double mCurrentValue;
    @JsonProperty("lat")
    private double mLat;
    @JsonProperty("lon")
    private double mLon;

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

    public double getCurrentValue() {
        return mCurrentValue;
    }

    public void setCurrentValue(double currentValue) {
        this.mCurrentValue = currentValue;
    }

    public double getLat() {
        return mLat;
    }

    public void setLat(double lat) {
        this.mLat = lat;
    }

    public double getLon() {
        return mLon;
    }

    public void setLon(double lon) {
        this.mLon = lon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Marker marker = (Marker) o;

        if (Double.compare(marker.mAverage, mAverage) != 0) return false;
        if (Double.compare(marker.mCurrentValue, mCurrentValue) != 0) return false;
        if (Double.compare(marker.mLat, mLat) != 0) return false;
        if (Double.compare(marker.mLon, mLon) != 0) return false;
        return mName.equals(marker.mName);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = mName.hashCode();
        temp = Double.doubleToLongBits(mAverage);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(mCurrentValue);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(mLat);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(mLon);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

}

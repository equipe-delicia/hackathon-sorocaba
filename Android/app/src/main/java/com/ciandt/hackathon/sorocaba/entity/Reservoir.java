package com.ciandt.hackathon.sorocaba.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by robson on 26/07/15.
 */
public class Reservoir implements Parcelable {

    private String mName;
    private String mStoredVolume;
    private String mRainfallDday;
    private String mRainfallMonth;
    private String mHistoricalAverageMonth;

    public Reservoir(String name) {}

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getStoredVolume() {
        return mStoredVolume;
    }

    public void setStoredVolume(String storedVolume) {
        this.mStoredVolume = storedVolume;
    }

    public String getRainfallDday() {
        return mRainfallDday;
    }

    public void setRainfallDday(String rainfallDday) {
        this.mRainfallDday = rainfallDday;
    }

    public String getRainfallMonth() {
        return mRainfallMonth;
    }

    public void setRainfallMonth(String rainfallMonth) {
        this.mRainfallMonth = rainfallMonth;
    }

    public String getHistoricalAverageMonth() {
        return mHistoricalAverageMonth;
    }

    public void setHistoricalAverageMonth(String historicalAverageMonth) {
        this.mHistoricalAverageMonth = historicalAverageMonth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reservoir)) return false;

        Reservoir reservoir = (Reservoir) o;

        if (!mName.equals(reservoir.mName)) return false;
        if (!mStoredVolume.equals(reservoir.mStoredVolume)) return false;
        if (!mRainfallDday.equals(reservoir.mRainfallDday)) return false;
        if (!mRainfallMonth.equals(reservoir.mRainfallMonth)) return false;
        return mHistoricalAverageMonth.equals(reservoir.mHistoricalAverageMonth);

    }

    @Override
    public int hashCode() {
        int result = mName.hashCode();
        result = 31 * result + mStoredVolume.hashCode();
        result = 31 * result + mRainfallDday.hashCode();
        result = 31 * result + mRainfallMonth.hashCode();
        result = 31 * result + mHistoricalAverageMonth.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Reservoir{" +
                "mName='" + mName + '\'' +
                ", mStoredVolume='" + mStoredVolume + '\'' +
                ", mRainfallDday='" + mRainfallDday + '\'' +
                ", mRainfallMonth='" + mRainfallMonth + '\'' +
                ", mHistoricalAverageMonth='" + mHistoricalAverageMonth + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mName);
        dest.writeString(this.mStoredVolume);
        dest.writeString(this.mRainfallDday);
        dest.writeString(this.mRainfallMonth);
        dest.writeString(this.mHistoricalAverageMonth);
    }

    protected Reservoir(Parcel in) {
        this.mName = in.readString();
        this.mStoredVolume = in.readString();
        this.mRainfallDday = in.readString();
        this.mRainfallMonth = in.readString();
        this.mHistoricalAverageMonth = in.readString();
    }

    public static final Parcelable.Creator<Reservoir> CREATOR = new Parcelable.Creator<Reservoir>() {
        public Reservoir createFromParcel(Parcel source) {
            return new Reservoir(source);
        }

        public Reservoir[] newArray(int size) {
            return new Reservoir[size];
        }
    };

}
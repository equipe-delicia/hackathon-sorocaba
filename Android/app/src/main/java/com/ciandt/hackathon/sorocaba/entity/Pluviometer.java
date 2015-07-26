package com.ciandt.hackathon.sorocaba.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by robson on 26/07/15.
 */
public class Pluviometer implements Parcelable {

    private long mId;
    private String mCity;
    private Date mRefDate;
    private double nMm;
    private String mKind;

    public Pluviometer() {}

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        this.mId = id;
    }

    public String getCity() {
        return mCity;
    }

    public void setCity(String city) {
        this.mCity = city;
    }

    public Date getRefDate() {
        return mRefDate;
    }

    public void setRefDate(Date refDate) {
        this.mRefDate = refDate;
    }

    public double getMm() {
        return nMm;
    }

    public void setMm(double mm) {
        this.nMm = mm;
    }

    public String getKind() {
        return mKind;
    }

    public void setKind(String kind) {
        this.mKind = kind;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pluviometer)) return false;

        Pluviometer pluviometer = (Pluviometer) o;

        if (mId != pluviometer.mId) return false;
        if (Double.compare(pluviometer.nMm, nMm) != 0) return false;
        if (!mCity.equals(pluviometer.mCity)) return false;
        if (!mRefDate.equals(pluviometer.mRefDate)) return false;
        return mKind.equals(pluviometer.mKind);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (mId ^ (mId >>> 32));
        result = 31 * result + mCity.hashCode();
        result = 31 * result + mRefDate.hashCode();
        temp = Double.doubleToLongBits(nMm);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + mKind.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Reservoir{" +
                "mId=" + mId +
                ", mCity='" + mCity + '\'' +
                ", mRefDate=" + mRefDate +
                ", nMm=" + nMm +
                ", mKind='" + mKind + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.mId);
        dest.writeString(this.mCity);
        dest.writeLong(mRefDate != null ? mRefDate.getTime() : -1);
        dest.writeDouble(this.nMm);
        dest.writeString(this.mKind);
    }

    protected Pluviometer(Parcel in) {
        this.mId = in.readLong();
        this.mCity = in.readString();
        long tmpMRefDate = in.readLong();
        this.mRefDate = tmpMRefDate == -1 ? null : new Date(tmpMRefDate);
        this.nMm = in.readDouble();
        this.mKind = in.readString();
    }

    public static final Parcelable.Creator<Pluviometer> CREATOR = new Parcelable.Creator<Pluviometer>() {
        public Pluviometer createFromParcel(Parcel source) {
            return new Pluviometer(source);
        }

        public Pluviometer[] newArray(int size) {
            return new Pluviometer[size];
        }
    };

}

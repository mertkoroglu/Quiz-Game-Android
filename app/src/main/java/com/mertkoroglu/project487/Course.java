package com.mertkoroglu.project487;

import android.os.Parcel;
import android.os.Parcelable;

public class Course implements Parcelable {
    private String courseName, description, details;
    private int imgId, highscore, id;



    public Course(String courseName, String description, String details, int imgId, int highscore, int id) {
        this.courseName = courseName;
        this.imgId = imgId;
        this.highscore = highscore;
        this.description = description;
        this.id=id;
        this.details = details;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDetails() {
        return details;
    }

    protected Course(Parcel in) {
        courseName = in.readString();
        description = in.readString();
        details = in.readString();
        imgId = in.readInt();
        highscore = in.readInt();
        id = in.readInt();
    }

    public static final Creator<Course> CREATOR = new Creator<Course>() {
        @Override
        public Course createFromParcel(Parcel in) {
            return new Course(in);
        }

        @Override
        public Course[] newArray(int size) {
            return new Course[size];
        }
    };

    public String getCourseName() {
        return courseName;
    }

    public int getImgId() {
        return imgId;
    }

    public String getDescription() {
        return description;
    }

    public int getHighscore() {
        return highscore;
    }

    public void setHighscore(int highscore) {
        this.highscore = highscore;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(courseName);
        dest.writeString(description);
        dest.writeString(details);
        dest.writeInt(imgId);
        dest.writeInt(highscore);
        dest.writeInt(id);
    }
}

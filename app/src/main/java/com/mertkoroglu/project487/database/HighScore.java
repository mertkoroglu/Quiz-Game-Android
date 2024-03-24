package com.mertkoroglu.project487.database;

public class HighScore {
    private int courseId;
    private int highscore;

    public HighScore(int courseId, int highscore) {
        this.courseId = courseId;
        this.highscore = highscore;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getHighscore() {
        return highscore;
    }

    public void setHighscore(int highscore) {
        this.highscore = highscore;
    }
}

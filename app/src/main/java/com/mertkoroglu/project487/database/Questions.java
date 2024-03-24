package com.mertkoroglu.project487.database;

public class Questions {
    private int id;
    private int courseId;
    private int questionId;
    private String question;

    public Questions(int id, int courseId, int questionId, String question) {
        this.id = id;
        this.courseId = courseId;
        this.questionId = questionId;
        this.question = question;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}

package com.mertkoroglu.project487.database;

public class Answers {
    private int id;
    private int courseId;
    private int questionId;
    private int correct;
    private String description;

    public Answers(int id, int qid, int qno, int correct, String description) {
        this.id = id;
        this.courseId = qid;
        this.questionId = qno;
        this.correct = correct;
        this.description=description;
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

    public int getCorrect() {
        return correct;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

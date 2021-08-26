package com.levanov.model;

public class Statement {
    private int id;
    private int averageScore;
    private int enrolled;

    public Statement() {
    }

    public Statement(int averageScore, int enrolled) {
        this.averageScore = averageScore;
        this.enrolled = enrolled;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(int averageScore) {
        this.averageScore = averageScore;
    }

    public int getEnrolled() {
        return enrolled;
    }

    public void setEnrolled(int enrolled) {
        this.enrolled = enrolled;
    }


    @Override
    public String toString() {
        return "Statement{" +
                "id=" + id +
                ", averageScore=" + averageScore +
                ", enrolled=" + enrolled +
                '}';
    }


}

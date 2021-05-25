package com.levanov.model;

public class Statement {
    private int id;
    private int averageScore;
    private boolean enrolled;

    public Statement() {
    }

    public Statement(int averageScore, boolean enrolled) {
        this.averageScore = averageScore;
        this.enrolled = enrolled;
    }

    public int getId() {
        return id;
    }

    public int getAverageScore() {
        return averageScore;
    }

    public boolean isEnrolled() {
        return enrolled;
    }

    public void setAverageScore(int averageScore) {
        this.averageScore = averageScore;
    }

    @Override
    public String toString() {
        return "Statement{" +
                "id=" + id +
                ", averageScore=" + averageScore +
                ", enrolled=" + enrolled +
                '}';
    }

    public void setEnrolled(boolean enrolled) {
        this.enrolled = enrolled;
    }
}

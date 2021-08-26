package com.levanov.model;


public class SchoolCertificate {
    private int id;
    private int averageScore;
    private int UserAccountID;

    public SchoolCertificate() {
    }

    public SchoolCertificate(int averageScore, int userAccountID) {
        this.averageScore = averageScore;
        UserAccountID = userAccountID;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getAverageScore() {
        return averageScore;
    }

    public int getUserAccountID() {
        return UserAccountID;
    }

    public void setAverageScore(int averageScore) {
        this.averageScore = averageScore;
    }

    public void setUserAccountID(int userAccountID) {
        UserAccountID = userAccountID;
    }

    @Override
    public String toString() {
        return "SchoolCertificate{" +
                "id=" + id +
                ", averageScore=" + averageScore +
                ", UserAccountID=" + UserAccountID +
                '}';
    }
}

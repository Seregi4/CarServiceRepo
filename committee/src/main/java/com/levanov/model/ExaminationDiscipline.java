package com.levanov.model;

public class ExaminationDiscipline {

private int id;
private String name;
private int specialtyID;

    public ExaminationDiscipline() {
    }

    public ExaminationDiscipline(String name, int specialtyID) {
        this.name = name;
        this.specialtyID = specialtyID;
    }

    public ExaminationDiscipline(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSpecialtyID() {
        return specialtyID;
    }

    public void setSpecialtyID(int specialtyID) {
        this.specialtyID = specialtyID;
    }

    @Override
    public String toString() {
        return "ExaminationDiscipline{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", specialtyID=" + specialtyID +
                '}';
    }
}

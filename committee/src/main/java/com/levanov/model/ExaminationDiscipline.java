package com.levanov.model;

public class ExaminationDiscipline {
    private int id ;
    private String name;
    private int SpecialityID;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpecialityID() {
        return SpecialityID;
    }

    public void setSpecialityID(int specialityID) {
        SpecialityID = specialityID;
    }

    public ExaminationDiscipline(String name, int specialityID) {
        this.name = name;
        SpecialityID = specialityID;
    }

    public ExaminationDiscipline(String name) {
        this.id = id;
        this.name = name;

    }

    public ExaminationDiscipline() {
    }
}

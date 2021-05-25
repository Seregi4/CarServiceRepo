package com.levanov.model;

public class User {
    private int id;
    private String name;
    private String password;
    private String email;
    private int roleID;

    public User() {
    }

    public User(int id, String name, String password, String email, int roleID) {
        super();
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.roleID = roleID;
    }

    public User(String name, String password, String email) {
        super();
        this.name = name;
        this.password = password;
        this.email = email;
        this.roleID = 2;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", roleID=" + roleID +
                '}';
    }
}

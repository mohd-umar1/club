package org.example;

import static org.example.util.authentication1.hash_password;

public class user {

    private String name;

    private String password;

    private String hash_pass;

    private String department;

    private String year;

    private String email;

    private Long phone_num;


    public user(){

    }

    public user(String name1,String password1,String department1, String year1, String email1, Long phone_num1) {
        this.name =name1;
        this.password = password1;
        this.hash_pass=hash_password(password1);
        this.department = department1;
        this.year = year1;
        this.email = email1;
        this.phone_num = phone_num1;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(long phone_num) {
        this.phone_num = phone_num;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone_num(Long phone_num) {
        this.phone_num = phone_num;
    }

    public String getHash_pass() {
        return hash_pass;
    }

    public void setHash_pass(String hash_pass) {
        this.hash_pass = hash_pass;
    }
}


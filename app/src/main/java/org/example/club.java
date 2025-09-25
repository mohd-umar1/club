package org.example;

import java.net.URL;

public class club {

    private String clubname;

    private String department;

    private String date;

    private String form2;

    public club(){

    }

    public club(String clubname1, String department1, String date1,String form1 ){
        this.clubname = clubname1;
        this.department =  department1;
        this.date= date1;
        this.form2 = form1;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getClubname() {
        return clubname;
    }

    public void setClubname(String clubname) {
        this.clubname = clubname;
    }

   public void setForm(String form3){
        this.form2= form3;
   }

   public String getForm(){
        return form2;
   }

}




package com.example.ohda499;

public class helper {

    String fname, email, phone,password;

    public helper(String email) {
        this.email = email;
    }
    public helper(String phone,int g) {
        this.phone = phone;
    }



    public helper(String fname, String email,String phone ,String password) {
        this.fname = fname;
        this.email = email;
        this.phone = phone;
        this.password = password;

    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean valid_Email(String f){
        String a;
        a=this.email;
        if (a.equals(f)){
            return true;
        }else {
            return false;
        }

    }
    public boolean valid_Phone (String f){
        String a;
        a=this.phone;
        if (a.equals(f)){
            return true;
        }else {
            return false;
        }

    }


}

package com.example.ohda499;

public class helper {

    String fname, email, phone,password;

    public helper() {

    }

    public helper(String fname, String email,String phone ,String password) {
        this.fname = fname;
        this.email = email;

        this.password = password;
        this.phone = phone;
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
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


}

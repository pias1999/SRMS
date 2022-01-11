package com.example.srms;

public class FlSignup {

    public String flfullname;
    public String flemail;
    public String flpassword;

    public FlSignup() {
    }

    public FlSignup(String flfullname, String flemail, String flpassword) {
        this.flfullname = flfullname;
        this.flemail = flemail;
        this.flpassword = flpassword;
    }

    public String getFlfullname() {
        return flfullname;
    }

    public void setFlfullname(String flfullname) {
        this.flfullname = flfullname;
    }

    public String getFlemail() {
        return flemail;
    }

    public void setFlemail(String flemail) {
        this.flemail = flemail;
    }

    public String getFlpassword() {
        return flpassword;
    }

    public void setFlpassword(String flpassword) {
        this.flpassword = flpassword;
    }
}


package com.example.srms;

public class FlSignup {

    public String flid;
    public String flfullname;
    public String flemail;
    public String flpassword;

    public FlSignup() {
    }

    public FlSignup(String flid, String flfullname, String flemail, String flpassword) {
        this.flid = flid;
        this.flfullname = flfullname;
        this.flemail = flemail;
        this.flpassword = flpassword;
    }

    public String getFlid() {
        return flid;
    }

    public void setFlid(String flid) {
        this.flid = flid;
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
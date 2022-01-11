package com.example.srms;

public class StSignup {

    public String stid;
    public String stemail;
    public String stpassword;

    public StSignup() {
    }

    public StSignup(String stid, String stemail, String stpassword) {
        this.stid = stid;
        this.stemail = stemail;
        this.stpassword = stpassword;
    }

    public String getStid() {
        return stid;
    }

    public void setStid(String stid) {
        this.stid = stid;
    }

    public String getStemail() {
        return stemail;
    }

    public void setStemail(String stemail) {
        this.stemail = stemail;
    }

    public String getStpassword() {
        return stpassword;
    }

    public void setStpassword(String stpassword) {
        this.stpassword = stpassword;
    }
}


package com.example.srms;

public class StBasicInfo {

    public String stid;
    public String fullname;
    public String dept;
    public String fathersname;
    public String mothersname;
    public String guardcont;
    public String studcont;


    public StBasicInfo(String stid, String fullname, String dept, String fathersname, String mothersname, String guardcont, String studcont) {
        this.stid = stid;
        this.fullname = fullname;
        this.dept = dept;
        this.fathersname = fathersname;
        this.mothersname = mothersname;
        this.guardcont = guardcont;
        this.studcont = studcont;
    }

    public String getStid() {
        return stid;
    }

    public void setStid(String stid) {
        this.stid = stid;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getFathersname() {
        return fathersname;
    }

    public void setFathersname(String fathersname) {
        this.fathersname = fathersname;
    }

    public String getMothersname() {
        return mothersname;
    }

    public void setMothersname(String mothersname) {
        this.mothersname = mothersname;
    }

    public String getGuardcont() {
        return guardcont;
    }

    public void setGuardcont(String guardcont) {
        this.guardcont = guardcont;
    }

    public String getStudcont() {
        return studcont;
    }

    public void setStudcont(String studcont) {
        this.studcont = studcont;
    }
}
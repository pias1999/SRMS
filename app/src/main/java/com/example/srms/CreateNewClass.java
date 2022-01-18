package com.example.srms;

public class CreateNewClass {

    public String coursetitle;
    public String coursecode;
    public String section;
    public String instructor;

    public CreateNewClass() {
    }

    public CreateNewClass(String coursetitle, String coursecode, String section, String instructor) {
        this.coursetitle = coursetitle;
        this.coursecode = coursecode;
        this.section = section;
        this.instructor = instructor;
    }

    public String getCoursetitle() {
        return coursetitle;
    }

    public void setCoursetitle(String coursetitle) {
        this.coursetitle = coursetitle;
    }

    public String getCoursecode() {
        return coursecode;
    }

    public void setCoursecode(String coursecode) {
        this.coursecode = coursecode;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "CreateNewClass{" +
                "coursecode='" + coursecode + '\'' +
                ", section='" + section + '\'' +
                ", instructor='" + instructor + '\'' +
                '}';
    }
}




package com.developersstack.lms.view.tm;

import javafx.scene.control.Button;

public class StudentTm {
    private String studentId;
    private String studentName;
    private String contactNumber;
    private Button Options;

    public StudentTm() {
    }

    public StudentTm(String studentId, String studentName, String contactNumber, Button options) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.contactNumber = contactNumber;
        Options = options;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Button getOptions() {
        return Options;
    }

    public void setOptions(Button options) {
        Options = options;
    }
}

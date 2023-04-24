package com.developersstack.lms.view.tm;

import javafx.scene.control.Button;

public class StudentTm {
    private long studentId;
    private String studentName;
    private String contactNumber;
    private Button deleteBtn;
    private Button seeMoreBtn;

    public StudentTm() {
    }

    public StudentTm(long studentId, String studentName, String contactNumber, Button deleteBtn, Button seeMoreBtn) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.contactNumber = contactNumber;
        this.deleteBtn = deleteBtn;
        this.seeMoreBtn = seeMoreBtn;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
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

    public Button getDeleteBtn() {
        return deleteBtn;
    }

    public void setDeleteBtn(Button deleteBtn) {
        this.deleteBtn = deleteBtn;
    }

    public Button getSeeMoreBtn() {
        return seeMoreBtn;
    }

    public void setSeeMoreBtn(Button seeMoreBtn) {
        this.seeMoreBtn = seeMoreBtn;
    }
}

package com.developersstack.lms.controller;

import com.developersstack.lms.bo.BoFactory;
import com.developersstack.lms.bo.custom.StudentBo;
import com.developersstack.lms.dto.StudentDto;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class MainFormController {

    public TextField txtName;
    public TextField txtContact;

    private final StudentBo studentBo = BoFactory.getInstance().getBo(BoFactory.BoType.STUDENT);

    public void btnSaveStudentOnAction(ActionEvent actionEvent) {
        StudentDto dto = new StudentDto();
        dto.setName(txtName.getText());
        dto.setContact(txtContact.getText());
        try {
            studentBo.saveStudent(dto);
            new Alert(Alert.AlertType.INFORMATION, "Student Saved").show();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Try Again").show();
        }

    }
}

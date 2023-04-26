package com.developersstack.lms.controller;

import com.developersstack.lms.bo.BoFactory;
import com.developersstack.lms.bo.custom.LaptopBo;
import com.developersstack.lms.bo.custom.StudentBo;
import com.developersstack.lms.dto.CreateLaptopDto;
import com.developersstack.lms.dto.StudentDto;
import com.developersstack.lms.view.tm.StudentTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;
import java.util.Observable;
import java.util.Optional;

public class MainFormController {

    public TextField txtName;
    public TextField txtContact;

    private final StudentBo studentBo = BoFactory.getInstance().getBo(BoFactory.BoType.STUDENT);
    private final LaptopBo laptopBo = BoFactory.getInstance().getBo(BoFactory.BoType.LAPTOP);
    public TableView<StudentTm> tblStudent;
    public TableColumn colStuId;
    public TableColumn colStuName;
    public TableColumn colContact;
    public TableColumn colSeeMore;
    public TableColumn colDelete;

    public Button btnStudentSave;
    public TextField txtLaptop;
    public TextField txtSearch;
    public TableView tblLaptop;
    public TableColumn colLapId;
    public TableColumn colBrand;
    public TableColumn colLapDelete;
    public ComboBox<Long> cmbStudent;

    public void initialize() throws SQLException, ClassNotFoundException {
        colStuId.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        colStuName.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contactNumber"));
        colSeeMore.setCellValueFactory(new PropertyValueFactory<>("seeMoreBtn"));
        colDelete.setCellValueFactory(new PropertyValueFactory<>("deleteBtn"));
        loadAllStudents();
        loadAllStudentsForLaptopSection();

        //------------------------Listener---------------------
        tblStudent.getSelectionModel()
                .selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> {
                    if (newValue != null) {
                        selectedStudentTm = newValue;
                        txtName.setText(newValue.getStudentName());
                        txtContact.setText(newValue.getContactNumber());
                        btnStudentSave.setText("Update Student");
                    }
                });
        //------------------------Listener---------------------
    }

    private void loadAllStudentsForLaptopSection() throws SQLException, ClassNotFoundException {
        ObservableList<Long> obList = FXCollections.observableArrayList();
        for (StudentDto dto:studentBo.findAll()
        ) {
            obList.add(dto.getId());
        }
        cmbStudent.setItems(obList);
    }


    private StudentTm selectedStudentTm = null;

    private void loadAllStudents() throws SQLException, ClassNotFoundException {
        ObservableList<StudentTm> tmList = FXCollections.observableArrayList();
        for (StudentDto dto: studentBo.findAll()) {
            Button deleteButton = new Button("Delete");
            deleteButton.setStyle("-fx-background-color: #c0392b ");
            Button seeMoreButton = new Button("See More");
            seeMoreButton.setStyle("-fx-background-color: #2980b9");

            StudentTm tm = new StudentTm(dto.getId(), dto.getName(), dto.getContact(),
                    deleteButton, seeMoreButton);
            tmList.add(tm);

            deleteButton.setOnAction(e -> {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                        "Are you sure?", ButtonType.YES, ButtonType.NO);
                Optional<ButtonType> selectedButtonData = alert.showAndWait();
                if (selectedButtonData.get().equals(ButtonType.YES)) {
                    try {
                        studentBo.deleteStudentById(tm.getStudentId());
                        new Alert(Alert.AlertType.INFORMATION, "Student Deleted").show();
                        loadAllStudents();
                    } catch (Exception exception) {
                        new Alert(Alert.AlertType.ERROR, "Try Again").show();
                    }
                }
            });
        }
        tblStudent.setItems(tmList);
        tblStudent.refresh();
    }

    public void btnSaveStudentOnAction(ActionEvent actionEvent) {
        StudentDto dto = new StudentDto();
        dto.setName(txtName.getText());
        dto.setContact(txtContact.getText());


        if (btnStudentSave.getText().equals("Update Student")) {

            if (selectedStudentTm == null) {
                new Alert(Alert.AlertType.ERROR, "Try Again").show();
                return;
            }
            try {
                dto.setId(selectedStudentTm.getStudentId());
                studentBo.updateStudent(dto);
                new Alert(Alert.AlertType.INFORMATION, "Student Updated").show();
                selectedStudentTm = null;
                btnStudentSave.setText("Save Student");
                loadAllStudents();
            } catch (Exception e) {
                new Alert(Alert.AlertType.ERROR, "Try Again").show();
            }
        } else {
            try {
                studentBo.saveStudent(dto);
                new Alert(Alert.AlertType.INFORMATION, "Student Saved").show();
                loadAllStudents();
            } catch (Exception e) {
                new Alert(Alert.AlertType.ERROR, "Try Again").show();
            }
        }
    }

    public void btnSaveLaptopOnAction(ActionEvent actionEvent) {
        try {
            laptopBo.saveLaptop(
                    new CreateLaptopDto(
                            cmbStudent.getValue(),
                            txtLaptop.getText()
                    )
            );
            new Alert(Alert.AlertType.INFORMATION, "Laptop Saved").show();
            loadAllLaptops();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Try Again").show();
        }
    }

    private void loadAllLaptops() {
    }
}

package lk.ijse.BookWorm_library.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.BookWorm_library.TM.BranchTM;
import lk.ijse.BookWorm_library.dto.BranchDTO;
import lk.ijse.BookWorm_library.entity.Branchs;
import lk.ijse.BookWorm_library.service.ServiceFactory;
import lk.ijse.BookWorm_library.service.custom.BranchService;

import java.util.ArrayList;
import java.util.List;

public class BookBranchManageFormController {
    @FXML
    private TableColumn<?, ?> colBranchClose;

    @FXML
    private TableColumn<?, ?> colBranchContact;

    @FXML
    private TableColumn<?, ?> colBranchID;

    @FXML
    private TableColumn<?, ?> colBranchName;

    @FXML
    private TableColumn<?, ?> colBranchOpen;

    @FXML
    private TableView<BranchTM> tblBranch;

    @FXML
    private TextField txtBranchCloseTime;

    @FXML
    private TextField txtBranchContact;

    @FXML
    private TextField txtBranchId;

    @FXML
    private TextField txtBranchLocation;

    @FXML
    private TextField txtBranchOpenTime;

    @FXML
    private JFXButton btnBranchAdd;

    @FXML
    private JFXButton btnBranchDelete;

    BranchService branchService = (BranchService) ServiceFactory.getBoFactory().getService(ServiceFactory.ServiceTypes.Branch);

    public void initialize(){
            setCellValueFactory();


            tblBranch.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                btnBranchDelete.setDisable(newValue == null);
                btnBranchAdd.setText(newValue != null ? "Update" : "Add branch");
                btnBranchAdd.setDisable(newValue == null);

                if (newValue != null){
                    txtBranchId.setText(newValue.getBranchId());
                    txtBranchLocation.setText(newValue.getBranchLocation());
                    txtBranchOpenTime.setText(newValue.getBranchOpenTime());
                    txtBranchCloseTime.setText(newValue.getBranchCloseTime());
                    txtBranchContact.setText(newValue.getBranchContact());
                }
            });

            loadAllBranches();

    }

    private void setCellValueFactory() {
        colBranchID.setCellValueFactory(new PropertyValueFactory<>("branchId"));
        colBranchName.setCellValueFactory(new PropertyValueFactory<>("branchLocation"));
        colBranchOpen.setCellValueFactory(new PropertyValueFactory<>("branchOpenTime"));
        colBranchClose.setCellValueFactory(new PropertyValueFactory<>("branchCloseTime"));
        colBranchContact.setCellValueFactory(new PropertyValueFactory<>("branchContact"));
    }

    private void loadAllBranches() {

        tblBranch.getItems().clear();

        try {
            List<Branchs> allBranches = branchService.getAllBranches();
            System.out.println(allBranches+"    ccdc");
            for (Branchs branchs : allBranches) {
                tblBranch.getItems().add(new BranchTM(
                        branchs.getBranchId(),
                        branchs.getBranchLocation(),
                        branchs.getBranchOpenTime(),
                        branchs.getBranchCloseTime(),
                        branchs.getBranchContact()
                ));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }






    @FXML
    void btnAddBranchOnAction(ActionEvent event) {


       // long branchId = Long.parseLong(txtBranchId.getText());
        String branchId = txtBranchId.getText();
        String branchLocation = txtBranchLocation.getText();
        String branchOpenTime = txtBranchOpenTime.getText();
        String branchCloseTime = txtBranchCloseTime.getText();
        String branchContact = txtBranchContact.getText();

        if (btnBranchAdd.getText().equalsIgnoreCase("Add branch")) {

           //Branch Save
            String s = branchService.saveBranch(new BranchDTO(branchId, branchLocation, branchOpenTime, branchCloseTime, branchContact));


            if (s != null) {
                new Alert(Alert.AlertType.CONFIRMATION, "Save Branch").show();

            }
        }else {
            //Branch Update
            BranchDTO branchDTO = checkBranch(branchId);
            if (branchDTO != null){


                BranchDTO branchDTO1 = new BranchDTO(branchId,branchLocation,branchOpenTime,branchCloseTime,branchContact);
                boolean isBranchUpdate = branchService.updateBranch(branchDTO1);

                if (isBranchUpdate){
                    new Alert(Alert.AlertType.CONFIRMATION,"Branch Update success").show();
                }

            }



        }
    }

    @FXML
    void btnBranchDeleteOnAction(ActionEvent event) {
        String branchId = txtBranchId.getText();

        BranchDTO existingBranch = checkBranch(branchId);
        branchService.deleteBranch(existingBranch);
    }

    private BranchDTO checkBranch(String branchId) {
        return branchService.getBranch(branchId);
    }
}

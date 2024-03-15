package lk.ijse.BookWorm_library.dto;

import lk.ijse.BookWorm_library.entity.Branchs;

public class BranchDTO {

    String  branchId;

    String branchLocation;
    String branchOpenTime;
    String branchCloseTime;
    String branchContact;

    public BranchDTO() {
    }

    public BranchDTO(String  branchId, String branchLocation, String branchOpenTime, String branchCloseTime, String branchContact) {
        this.branchId = branchId;
        this.branchLocation = branchLocation;
        this.branchOpenTime = branchOpenTime;
        this.branchCloseTime = branchCloseTime;
        this.branchContact = branchContact;
    }

    public String  getBranchId() {
        return branchId;
    }

    public void setBranchId(String  branchId) {
        this.branchId = branchId;
    }

    public String getBranchLocation() {
        return branchLocation;
    }

    public void setBranchLocation(String branchLocation) {
        this.branchLocation = branchLocation;
    }

    public String getBranchOpenTime() {
        return branchOpenTime;
    }

    public void setBranchOpenTime(String branchOpenTime) {
        this.branchOpenTime = branchOpenTime;
    }

    public String getBranchCloseTime() {
        return branchCloseTime;
    }

    public void setBranchCloseTime(String branchCloseTime) {
        this.branchCloseTime = branchCloseTime;
    }

    public String getBranchContact() {
        return branchContact;
    }

    public void setBranchContact(String branchContact) {
        this.branchContact = branchContact;
    }

    @Override
    public String toString() {
        return "BranchDTO{" +
                "branchId=" + branchId +
                ", branchLocation='" + branchLocation + '\'' +
                ", branchOpenTime='" + branchOpenTime + '\'' +
                ", branchCloseTime='" + branchCloseTime + '\'' +
                ", branchContact='" + branchContact + '\'' +
                '}';
    }

    public Branchs toEntity() {
        Branchs branch = new Branchs();
        branch.setBranchId(this.branchId);
        branch.setBranchLocation(this.branchLocation);
        branch.setBranchOpenTime(this.branchOpenTime);
        branch.setBranchCloseTime(this.branchCloseTime);
        branch.setBranchContact(this.branchContact);
        return branch;
    }
}

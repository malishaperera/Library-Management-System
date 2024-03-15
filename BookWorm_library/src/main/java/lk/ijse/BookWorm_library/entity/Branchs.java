package lk.ijse.BookWorm_library.entity;


import lk.ijse.BookWorm_library.dto.BranchDTO;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;

@Entity
@Table(name = "branchs")
public class Branchs {
    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "branch_id")*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "custom-id")
    @GenericGenerator(name = "custom-id", strategy = "lk.ijse.BookWorm_library.entity.id.BranchIdGenerator")//lk.ijse.BookWorm_library.entity.CustomIdGenerator  //lk.ijse.BookWorm_library.entity.CustomIdGenerator
    @Column(name = "branch_id")
    private String  branchId;//

    @Column(name = "branch_location")
    private String branchLocation;

    @Column(name = "branch_openTime")
    private String branchOpenTime;

    @Column(name = "branch_closeTime")
    private String branchCloseTime;

    @Column(name = "branch_contact")
    private String branchContact;


    public Branchs() {
    }

    public Branchs(String  branchId, String branchLocation, String branchOpenTime, String branchCloseTime, String branchContact) {
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
        return "Branch{" +
                "branchId=" + branchId +
                ", branchLocation='" + branchLocation + '\'' +
                ", branchOpenTime='" + branchOpenTime + '\'' +
                ", branchCloseTime='" + branchCloseTime + '\'' +
                ", branchContact='" + branchContact + '\'' +
                '}';
    }

    public BranchDTO toDto() {
        BranchDTO branchDTO = new BranchDTO();
        branchDTO.setBranchId(this.branchId);
        branchDTO.setBranchLocation(this.branchLocation);
        branchDTO.setBranchOpenTime(this.branchOpenTime);
        branchDTO.setBranchCloseTime(this.branchCloseTime);
        branchDTO.setBranchContact(this.branchContact);

        return branchDTO;
    }


}

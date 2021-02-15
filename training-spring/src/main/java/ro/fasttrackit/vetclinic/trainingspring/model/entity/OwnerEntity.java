package ro.fasttrackit.vetclinic.trainingspring.model.entity;

import javax.persistence.*;

@Entity(name = "owner")
public class OwnerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String firstname;
    @Column
    private String lastname;
    @Column
    private String CNP;
    @Column
    private String phoneNumber;
    @Column
    private String email;

    public OwnerEntity(Long id,String firstname,String lastname,
                       String CNP,String phoneNumber,String email){
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.CNP = CNP;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public OwnerEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "OwnerEntity{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", CNP='" + CNP + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

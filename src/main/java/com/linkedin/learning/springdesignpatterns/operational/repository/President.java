package com.linkedin.learning.springdesignpatterns.operational.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRESIDENT")
public class President {
    
    @Id
    @GeneratedValue
    @Column(name = "PRESIDENT_ID")
    private long id;
    
    private String firstName;
    
    private String middleName;
    
    private String lastName;
    
    private String emailAddress;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "President{" + "id=" + id + ", firstName='" + firstName + '\'' + ", middleName='" + middleName + '\'' + ", lastName='" + lastName + '\'' + ", emailAddress='"
                + emailAddress + '\'' + '}';
    }
}

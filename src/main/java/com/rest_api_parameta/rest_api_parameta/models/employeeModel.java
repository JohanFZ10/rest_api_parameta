package com.rest_api_parameta.rest_api_parameta.models;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class employeeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String names;
    private String lastNames;
    private String documentType;
    private String documentNumber;
    private Date dateBirth;
    private Date dateAdmission;
    private String positionCompany;
    private Double salary;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNames() {
        return names;
    }
    public void setNames(String names) {
        this.names = names;
    }
    public String getLastNames() {
        return lastNames;
    }
    public void setLastNames(String lastNames) {
        this.lastNames = lastNames;
    }
    public String getDocumentType() {
        return documentType;
    }
    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }
    public String getDocumentNumber() {
        return documentNumber;
    }
    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }
    public Date getDateBirth() {
        return dateBirth;
    }
    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }
    public Date getDateAdmission() {
        return dateAdmission;
    }
    public void setDateAdmission(Date dateAdmission) {
        this.dateAdmission = dateAdmission;
    }
    public String getPositionCompany() {
        return positionCompany;
    }
    public void setPositionCompany(String positionCompany) {
        this.positionCompany = positionCompany;
    }
    public Double getSalary() {
        return salary;
    }
    public void setSalary(Double salary) {
        this.salary = salary;
    }

       
 
}
package com.searchjob.servicejob.repository.model;

import lombok.Generated;

import javax.persistence.*;

@Entity
@Table(name = "vacancies")
public final class Vacancy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String typeOfEmployment;
    private String responsibilities;
    private String skills;
    private String employer;
    private String email;


    public Vacancy(){

    }

    public Vacancy(String title, String typeOfEmployment,
               String responsibilities, String skills,
               String employer, String email){
        this.title = title;
        this.typeOfEmployment = typeOfEmployment;
        this.responsibilities = responsibilities;
        this.skills = skills;
        this.employer = employer;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTypeOfEmployment() {
        return typeOfEmployment;
    }

    public void setTypeOfEmployment(String typeOfEmployment) {
        this.typeOfEmployment = typeOfEmployment;
    }

    public String getResponsibilities() {
        return responsibilities;
    }

    public void setResponsibilities(String responsibilities) {
        this.responsibilities = responsibilities;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

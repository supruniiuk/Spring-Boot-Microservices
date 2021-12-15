package com.searchjob.servicefeedback.repository.model;

import javax.persistence.*;

@Entity
@Table(name = "feedbacks")
public final class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long userId;
    private String title;
    private long vacancyId;
    private String description;

    public Feedback(){}

    public Feedback(long userId, String title,
                    long vacancyId, String description){
        this.userId = userId;
        this.title = title;
        this.vacancyId = vacancyId;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getVacancyId() {
        return vacancyId;
    }

    public void setVacancyId(long vacancyId) {
        this.vacancyId = vacancyId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

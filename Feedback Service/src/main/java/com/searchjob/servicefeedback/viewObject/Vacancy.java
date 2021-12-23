package com.searchjob.servicefeedback.viewObject;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public final class Vacancy {
    private String title;
    private String typeOfEmployment;
    private String responsibilities;
    private String skills;
    private String employer;
    private String email;
}
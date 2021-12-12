package com.searchjob.servicejob.api.dto; //data-transfer-object

import lombok.Data;
import lombok.NoArgsConstructor;

@Data //get set toString...
@NoArgsConstructor
public final class Vacancy {
    private String title;
    private String typeOfEmployment;
    private String responsibilities;
    private String skills;
    private String employer;
    private String email;
}

package com.searchjob.servicefeedback.viewObject;

import com.searchjob.servicefeedback.repository.model.Feedback;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public final class ResponseTemplate {
    private Feedback feedback;
    private Vacancy vacancy;
    private User user;

}
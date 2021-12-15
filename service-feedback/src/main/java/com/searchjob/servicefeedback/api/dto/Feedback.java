package com.searchjob.servicefeedback.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public final class Feedback {
    private long userId;
    private String title;
    private long vacancyId;
    private String description;
}
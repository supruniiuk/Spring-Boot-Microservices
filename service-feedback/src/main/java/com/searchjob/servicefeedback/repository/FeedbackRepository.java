package com.searchjob.servicefeedback.repository;

import com.searchjob.servicefeedback.repository.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository  extends JpaRepository<Feedback, Long> {
}

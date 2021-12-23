package com.searchjob.servicefeedback.api;

import com.searchjob.servicefeedback.viewObject.ResponseTemplate;
import com.searchjob.servicefeedback.repository.model.Feedback;
import com.searchjob.servicefeedback.service.FeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/feedbacks")
public class FeedbackController {

    private  final FeedbackService feedbackService;

    @GetMapping
    public ResponseEntity<List<com.searchjob.servicefeedback.repository.model.Feedback>> index (){
        final List<com.searchjob.servicefeedback.repository.model.Feedback> feedbacks =  feedbackService.fetchAll();
        return ResponseEntity.ok(feedbacks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<com.searchjob.servicefeedback.repository.model.Feedback> show(@PathVariable long id){
        try{
            final Feedback feedback = feedbackService.fetchById(id);
            return ResponseEntity.ok(feedback);
        } catch(IllegalArgumentException error) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody com.searchjob.servicefeedback.api.dto.Feedback feedback){
        final long userId = feedback.getUserId();
        final String title = feedback.getTitle();
        final long vacancyId = feedback.getVacancyId();
        final String description = feedback.getDescription();
        final long id = feedbackService.create(userId, title, vacancyId, description);

        final String location = String.format("/feedbacks/%d", id);

        return ResponseEntity.created(URI.create(location)).build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable long id, @RequestBody com.searchjob.servicefeedback.api.dto.Feedback feedback){
        final long userId = feedback.getUserId();
        final String title = feedback.getTitle();
        final long vacancyId = feedback.getVacancyId();
        final String description = feedback.getDescription();
        try{
            feedbackService.update(id, userId, title, vacancyId, description);
            return ResponseEntity.noContent().build();
        }catch (IllegalArgumentException error){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        feedbackService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/view/{id}")
    public ResponseTemplate getFeedbackWithVacancyAndUser(@PathVariable long id){
        return feedbackService.getFeedbackWithVacancyAndUser(id);
    }
}

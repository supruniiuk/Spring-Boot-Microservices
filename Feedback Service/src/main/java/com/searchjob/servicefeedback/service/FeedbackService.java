package com.searchjob.servicefeedback.service;

import com.searchjob.servicefeedback.viewObject.ResponseTemplate;
import com.searchjob.servicefeedback.viewObject.User;
import com.searchjob.servicefeedback.viewObject.Vacancy;
import com.searchjob.servicefeedback.repository.FeedbackRepository;
import com.searchjob.servicefeedback.repository.model.Feedback;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public final class FeedbackService {
    private final FeedbackRepository feedbackRepository;
    private final RestTemplate restTemplate;


    public List<Feedback> fetchAll() {
        return feedbackRepository.findAll();
    }

    public Feedback fetchById(long id) throws IllegalArgumentException {
        final Optional<Feedback> maybeFeedback = feedbackRepository.findById(id);

        if(maybeFeedback.isEmpty()) throw new IllegalArgumentException("Feedback not found");
        else return maybeFeedback.get();
    }

    public long create(long userId, String title,
                       long vacancyId, String description){
        final Feedback feedback = new Feedback(userId, title, vacancyId, description);
        final Feedback savedFeedback = feedbackRepository.save(feedback);

        return savedFeedback.getId();
    }

    public void update(long id, long userId, String title,
                       long vacancyId, String description) throws IllegalArgumentException {

        final Optional<Feedback> maybeFeedback = feedbackRepository.findById(id);
        if(maybeFeedback.isEmpty()) throw new IllegalArgumentException("Feedback not found");

        final Feedback feedback = maybeFeedback.get();
        feedback.setUserId(userId);
        if(title != null && !title.isBlank()) feedback.setTitle(title);
        feedback.setVacancyId(vacancyId);
        if(description != null && !description.isBlank()) feedback.setDescription(description);

        feedbackRepository.save(feedback);
    }

    public void delete(long id){
        feedbackRepository.deleteById(id);
    }

    public ResponseTemplate getFeedbackWithVacancyAndUser(Long id){
        ResponseTemplate viewObject = new ResponseTemplate();
        final Feedback feedback;
        final Optional<Feedback> maybeFeedback = feedbackRepository.findById(id);
        if(maybeFeedback.isEmpty()) throw new IllegalArgumentException("Feedback not found");
        else {
            feedback = maybeFeedback.get();

            String userURL = "http://service-users:8082/users/";
            final User user = restTemplate.getForObject(userURL + feedback.getUserId(), User.class);

            String vacancyURL = "http://service-vacancy:8081/vacancies/";
            final Vacancy vacancy = restTemplate.getForObject(vacancyURL + feedback.getVacancyId(), Vacancy.class);

            viewObject.setUser(user);
            viewObject.setVacancy(vacancy);
            viewObject.setFeedback(feedback);
            return viewObject;
        }
    }
}

package com.searchjob.servicevacancy.api;
//already can get requests and send responses
import com.searchjob.servicevacancy.repository.model.Vacancy;
import com.searchjob.servicevacancy.service.VacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/vacancies")
public class VacancyController {

    private  final VacancyService vacancyService;

    @GetMapping
    public ResponseEntity<List<com.searchjob.servicevacancy.repository.model.Vacancy>> index (){
        final List<com.searchjob.servicevacancy.repository.model.Vacancy> vacancies =  vacancyService.fetchAll();
        return ResponseEntity.ok(vacancies);
}
    @GetMapping("/{id}")
    public ResponseEntity<com.searchjob.servicevacancy.repository.model.Vacancy> show(@PathVariable long id){
       try{
            final Vacancy vacancy = vacancyService.fetchById(id);
            return ResponseEntity.ok(vacancy);
        } catch(IllegalArgumentException error) {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody com.searchjob.servicevacancy.api.dto.Vacancy vacancy){
        final String title = vacancy.getTitle();
        final String typeOfEmployment = vacancy.getTypeOfEmployment();
        final String responsibilities = vacancy.getResponsibilities();
        final String skills = vacancy.getSkills();
        final String employer = vacancy.getEmployer();
        final String email = vacancy.getEmail();
        final long id = vacancyService.create(title, typeOfEmployment, responsibilities, skills, employer, email);

        final String location = String.format("/vacancy/%d", id);

        return ResponseEntity.created(URI.create(location)).build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable long id, @RequestBody com.searchjob.servicevacancy.api.dto.Vacancy vacancy){
        final String title = vacancy.getTitle();
        final String typeOfEmployment = vacancy.getTypeOfEmployment();
        final String responsibilities = vacancy.getResponsibilities();
        final String skills = vacancy.getSkills();
        final String employer = vacancy.getEmployer();
        final String email = vacancy.getEmail();
        try{
            vacancyService.update(id, title, typeOfEmployment, responsibilities, skills, employer, email);

            return ResponseEntity.noContent().build();
        }catch (IllegalArgumentException error){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        vacancyService.delete(id);
        return ResponseEntity.ok().build();
    }
}

package com.searchjob.servicevacancy.service;

import com.searchjob.servicevacancy.repository.VacancyRepository;
import com.searchjob.servicevacancy.repository.model.Vacancy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public final class VacancyService {
    private final VacancyRepository vacancyRepository;

    public List<Vacancy> fetchAll() {
        return vacancyRepository.findAll();
    }

    public Vacancy fetchById(long id) throws IllegalArgumentException {
        final Optional<Vacancy> maybeVacancy = vacancyRepository.findById(id);

        if(maybeVacancy.isEmpty()) throw new IllegalArgumentException("Vacancy not found");
        else return maybeVacancy.get();
    }

    public long create(String title, String typeOfEmployment,
                       String responsibilities, String skills,
                       String employer, String email){
        final Vacancy vacancy = new Vacancy(title, typeOfEmployment, responsibilities, skills, employer, email);
        final Vacancy savedVacancy = vacancyRepository.save(vacancy);

        return savedVacancy.getId();
    }

    public void update(long id, String title,  String typeOfEmployment,
                       String responsibilities, String skills,
                       String employer, String email) throws IllegalArgumentException {

        final Optional<Vacancy> maybeVacancy = vacancyRepository.findById(id);
        if(maybeVacancy.isEmpty()) throw new IllegalArgumentException("Vacancy not found");

        final Vacancy vacancy = maybeVacancy.get();
        if(title != null && !title.isBlank()) vacancy.setTitle(title);
        if(typeOfEmployment != null && !typeOfEmployment.isBlank()) vacancy.setTypeOfEmployment(typeOfEmployment);
        if(responsibilities != null && !responsibilities.isBlank()) vacancy.setResponsibilities(responsibilities);
        if(skills != null && !skills.isBlank()) vacancy.setSkills(skills);
        if(employer != null && !employer.isBlank()) vacancy.setEmployer(employer);
        if(email != null && !email.isBlank()) vacancy.setEmail(email);

        vacancyRepository.save(vacancy);
    }

    public void delete(long id){
        vacancyRepository.deleteById(id);
    }
}

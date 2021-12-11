package com.searchjob.servicejob.service;

import com.searchjob.servicejob.repository.VacancyRepository;
import com.searchjob.servicejob.repository.model.Vacancy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public final class VacancyService {
    private final VacancyRepository vacancyRepository;

    public List<Vacancy> fetchAll() {
        return List.of();
    }

    public Vacancy fetchById(long id) throws IllegalArgumentException {
        throw new RuntimeException("Not implemented");
    }

    public long create(String typeOfEmployment,
                       String responsibilities, String skills,
                       String employer, String email){
        throw new RuntimeException("Not implemented");
    }

    public void update(long id, String typeOfEmployment,
                       String responsibilities, String skills,
                       String employer, String email) throws IllegalArgumentException {
        throw new RuntimeException("Not implemented");
    }

    public void delete(long id){
        throw new RuntimeException("Not implemented");
    }

}

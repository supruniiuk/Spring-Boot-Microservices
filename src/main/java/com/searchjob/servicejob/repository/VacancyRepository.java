package com.searchjob.servicejob.repository;
import com.searchjob.servicejob.repository.model.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;

//JpaRepository works with entities of class Vacancy with unique identifier
public interface VacancyRepository extends JpaRepository<Vacancy, Long>{
}

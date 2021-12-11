package com.searchjob.servicejob.repository;
import com.searchjob.servicejob.repository.model.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//JpaRepository works with entities of class Vacancy with unique identifier
public interface VacancyRepository extends JpaRepository<Vacancy, Long>{
}

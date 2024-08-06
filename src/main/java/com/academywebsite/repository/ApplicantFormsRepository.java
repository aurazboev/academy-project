package com.academywebsite.repository;

import com.academywebsite.documents.ApplicantForms;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantFormsRepository extends MongoRepository<ApplicantForms, String> {
    long countByInterestedCoursesTitle(String title);
}

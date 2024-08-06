package com.academywebsite.repository;

import com.academywebsite.documents.Students;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentsRepository extends MongoRepository<Students, String> {
    long countByEnrolledCoursesTitle(String title);
}

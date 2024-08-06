package com.academywebsite.repository;

import com.academywebsite.documents.Mentors;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentorsRepository extends MongoRepository<Mentors, String> {

}

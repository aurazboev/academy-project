package com.academywebsite.service;

import com.academywebsite.documents.Mentors;
import com.academywebsite.repository.CoursesRepository;
import com.academywebsite.repository.MentorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MentorsService {

    @Autowired
    MentorsRepository mentorsRepository;
    @Autowired
    CoursesRepository coursesRepository;

    public Mentors createMentor(Mentors mentors) {
        long createdTime = System.currentTimeMillis();
        Date dateToSave = new Date(createdTime);
        mentors.setCreatedAt(dateToSave);
        return mentorsRepository.save(mentors);
    }

    public Mentors getMentorById(String id) {
        return mentorsRepository.findById(id).get();
    }

    public List<Mentors> getAllMentors() {
        return mentorsRepository.findAll();
    }

    public Mentors updateMentor(String id, Mentors newMentor) {
        newMentor.setId(id);
        return mentorsRepository.save(newMentor);
    }

    public void deleteMentor(String id) {
        mentorsRepository.deleteById(id);
    }

    public List<Mentors> getAllWithPagination(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber -1,pageSize);
        return mentorsRepository.findAll(pageable).getContent();
    }

    public List<Mentors> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.ASC,"firstName");
        return mentorsRepository.findAll(sort);
    }
}

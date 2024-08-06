package com.academywebsite.service;

import com.academywebsite.documents.Courses;
import com.academywebsite.repository.ApplicantFormsRepository;
import com.academywebsite.repository.CoursesRepository;
import com.academywebsite.repository.StudentsRepository;
import com.academywebsite.models.CourseStatisticsResponseModel;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoursesService {
    @Autowired
    CoursesRepository coursesRepository;

    @Autowired
    ApplicantFormsRepository applicantFormRepository;

    @Autowired
    StudentsRepository studentsRepository;

    public List<CourseStatisticsResponseModel> getStatisticsByCourses() {
        ModelMapper modelMapper = new ModelMapper();
        List<Courses> coursesEntity = coursesRepository.findAll();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<CourseStatisticsResponseModel> responseModel = coursesEntity.stream().map(courses -> modelMapper.map(courses, CourseStatisticsResponseModel.class)).collect(Collectors.toList());
        responseModel.forEach(courseStatisticsResponseModel -> {
            courseStatisticsResponseModel.setNumberOfApplications(applicantFormRepository.countByInterestedCoursesTitle(courseStatisticsResponseModel.getTitle()));
            courseStatisticsResponseModel.setNumberOfStudents(studentsRepository.countByEnrolledCoursesTitle(courseStatisticsResponseModel.getTitle()));
        });
        return responseModel;
    }

    public List<Courses> getAllCourses() {
        return coursesRepository.findAll();
    }

    public Courses createCourse(Courses newCourse) {
        long createdTime = System.currentTimeMillis();
        Date dateToSave = new Date(createdTime);
        newCourse.setCreatedAt(dateToSave);
        return coursesRepository.save(newCourse);
    }
    public Courses updateCourse(String id, Courses updatedCourse){
        updatedCourse.setId(id);

        return coursesRepository.save(updatedCourse);
    }

    public void deleteCourse(String id) {
        coursesRepository.deleteById(id);
    }

    public Courses getCourseById(String id) {
        return coursesRepository.findById(id).get();
    }
}

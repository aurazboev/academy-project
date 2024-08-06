package com.academywebsite.controller;

import com.academywebsite.documents.Courses;
import com.academywebsite.models.CourseStatisticsResponseModel;
import com.academywebsite.service.CoursesService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Documentation of the Courses of the IT academy", tags = {"Courses"})
@RestController
@RequestMapping("/api")
public class CoursesController {

    @Autowired
    CoursesService coursesService;

    @GetMapping("/courses")
    public List<Courses> getAllCourses(){
        return coursesService.getAllCourses();
    }
    @GetMapping({"/courses/{id}"})
    public Courses getCourseById(@PathVariable String id){
        return coursesService.getCourseById(id);
    }

    @GetMapping("/courses/statistics")
    public List<CourseStatisticsResponseModel> getStatisticsByCourses(){
        return coursesService.getStatisticsByCourses();
    }

    @PostMapping("/courses")
    public Courses createCourse(@RequestBody Courses newCourse){
        return coursesService.createCourse(newCourse);
    }

    @PutMapping("/courses/{id}")
    public Courses updateCourse(@PathVariable String id, @RequestBody Courses updatedCourse){
        return coursesService.updateCourse(id, updatedCourse);
    }
    @DeleteMapping("/courses/{id}")
    public void deleteCourse(@PathVariable String id){
        coursesService.deleteCourse(id);
    }
}

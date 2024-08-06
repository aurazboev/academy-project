package com.academywebsite.controller;

import com.academywebsite.documents.Mentors;
import com.academywebsite.service.MentorsService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Documentation of the Mentors of the IT academy", tags = {"Mentors"})
@RestController
@RequestMapping("/api")
public class MentorsController {

    @Autowired
    MentorsService mentorsService;

    @PostMapping("/mentors")
    public Mentors createMentor(@RequestBody Mentors mentor){
        return mentorsService.createMentor(mentor);
    }

    @GetMapping("/mentors/{id}")
    public Mentors getMentorById(@PathVariable String id){
        return mentorsService.getMentorById(id);
    }

    @GetMapping("/mentors")
    public List<Mentors> getAllMentors(){
        return mentorsService.getAllMentors();
    }
    @PutMapping("/mentors/{id}")
    public Mentors updateMentor(@PathVariable String id, @RequestBody Mentors newMentor){
        return mentorsService.updateMentor(id, newMentor);
    }
    @DeleteMapping("/mentors/{id}")
    public void deleteMentor(@PathVariable String id){
        mentorsService.deleteMentor(id);
    }

}

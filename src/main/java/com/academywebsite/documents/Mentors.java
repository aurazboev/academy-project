package com.academywebsite.documents;

import com.academywebsite.documents.subdocuments.CoursesOfMentor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

@Data
@Document(collection = "mentors")
public class Mentors {
    @Id
    private String id;

    private String name;
    private String title;
    private String description;
    private String experience;
    @Field(name = "created_at")
    private Date createdAt;

    private List<CoursesOfMentor> courses;

    private String image;
}

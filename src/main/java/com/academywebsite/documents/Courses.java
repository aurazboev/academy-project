package com.academywebsite.documents;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Data
@Document(collection = "courses")
public class Courses {
    @Id
    private String id;

    private String title;
    private String description;
    private String duration;
    private int tuition;
    @Field(name = "minimum_skill")
    private String minimumSkill;
    private String photo;
    @Field(name = "created_at")
    private Date createdAt;
    private String slug;

}

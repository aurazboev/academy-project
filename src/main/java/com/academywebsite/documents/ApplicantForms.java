package com.academywebsite.documents;

import com.academywebsite.documents.subdocuments.InterestedCourses;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

@Data
@Document(collection = "applicant_forms")
public class ApplicantForms {
    @Id
    private String id;

    @Field(name = "first_name")
    private String firstName;
    @Field(name = "last_name")
    private String lastName;
    private String phone;
    private String email;
    @Field(name = "interested_courses")
    private List<InterestedCourses> interestedCourses;
    @Field(name = "available_time")
    private Date availableTime;
    private String comments;
    @Field(name = "created_at")
    private Date createdAt;
}

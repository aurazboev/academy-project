package com.academywebsite.documents.subdocuments;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class InterestedCourses {
    @Id
    private String id;
    private String title;
}

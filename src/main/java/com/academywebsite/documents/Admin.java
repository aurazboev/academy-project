package com.academywebsite.documents;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "admin")
public class Admin {
    @Id
    private String id;
    private String username;
    @Field(name = "encrypted_password")
    private String encryptedPassword;

}

package com.example.hrms.module;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    private String id;

    private String empCode;
    private String empRef;
    private String name;
    private String email;   // ✅ ADD THIS

    private boolean active;
    private String photoPath;
    private String documentPath;
    private String photoId;
}

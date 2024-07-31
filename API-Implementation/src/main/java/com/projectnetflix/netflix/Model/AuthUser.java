package com.projectnetflix.netflix.Model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document("guser")
public class AuthUser {

    @Id
    private Long id;
    @Indexed
    private String username;
    private String password;
    private boolean active;


}

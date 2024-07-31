package com.projectnetflix.netflix.Model;


import com.mongodb.connection.ProxySettings;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String name;
    private String email;
    private String password;


    public static ProxySettings.Builder withDeaultPasswordEncoder() {

    }
}

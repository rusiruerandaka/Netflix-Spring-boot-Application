package com.projectnetflix.netflix.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@EqualsAndHashCode
@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Admin extends User{

    @Transient
    public static final String SEQUENCE_NAME="admin_sequence";

    @Id
    private long admin_id;

}

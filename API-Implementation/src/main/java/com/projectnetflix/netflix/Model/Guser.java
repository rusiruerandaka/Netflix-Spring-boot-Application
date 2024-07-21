package com.projectnetflix.netflix.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@EqualsAndHashCode(callSuper = true)
@Document(collection = "guser")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Guser extends User{

    @Transient
    public static final String SEQUENCE_NAME="guser_sequence";

    @Id
    private long guser_id;

}

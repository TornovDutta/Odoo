package org.example.inventory.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.annotation.Documented;

@Document(collection= "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    @Id
    private String id;
}

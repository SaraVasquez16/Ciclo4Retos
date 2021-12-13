package com.tienda.tienda.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="usuarios") 
public class Usuarios {

    public Usuarios(String email,String password,String name ){
            this.email = email;
            this.password = password;
            this.name = name;
    }

    @Id
    private String id;
    private String identification;
    private String name;
    private String address;
    private String cellPhone;
    private String email;
    private String password;
    private String zone;
    private String type;
}
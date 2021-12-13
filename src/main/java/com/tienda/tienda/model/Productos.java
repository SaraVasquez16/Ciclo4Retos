package com.tienda.tienda.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="productos") 
public class Productos {
    @Id
    private String id;
    private String categoria;
    private String nombre;
    private String descripcion;
    private Long precio;
    private String disponibilidad;
    private Integer stock;   
    
}

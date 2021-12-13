package com.tienda.tienda.repository.crud;


import java.util.Optional;

import com.tienda.tienda.model.Usuarios;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuariosCrudRepositorio extends MongoRepository<Usuarios,String> {
    //Consultar todos los usuarios por su email
    Optional <Usuarios> findByEmail(String email);

    //Consultar todos los usuarios por su email y contraseña
    Optional <Usuarios> findByEmailAndPassword(String email, String password);
}

package com.tienda.tienda.repository;

import java.util.List;
import java.util.Optional;

import com.tienda.tienda.model.Usuarios;
import com.tienda.tienda.repository.crud.UsuariosCrudRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class UsuariosRepositorio {

    @Autowired
    UsuariosCrudRepositorio usuariosCrudRepositorio;

    public Usuarios save(Usuarios usuarios){
        return usuariosCrudRepositorio.save(usuarios);
    }

    public List<Usuarios>getAll(){
        return (List<Usuarios>)usuariosCrudRepositorio.findAll();
    }

    public Optional<Usuarios>getUsuarios(String id){
        return usuariosCrudRepositorio.findById(id);
    }

    public void delete(Usuarios usuarios){
        usuariosCrudRepositorio.delete(usuarios);
    }

    public boolean existeEmail (String email){
        Optional <Usuarios> usuario = usuariosCrudRepositorio.findByEmail(email);
        return !usuario.isEmpty();
    }
    public Optional <Usuarios> autenticarUsuario (String email, String password){
        return usuariosCrudRepositorio.findByEmailAndPassword(email, password);
    }
}

package com.tienda.tienda.service;

import java.util.List;
import java.util.Optional;

import com.tienda.tienda.model.Usuarios;
import com.tienda.tienda.repository.UsuariosRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuariosServicio {
    @Autowired
    private UsuariosRepositorio usuariosrepositorio;

    public Usuarios save(Usuarios usuarios){
        if (usuarios.getId()==null) {
            return usuariosrepositorio.save(usuarios);
            
        } else {
            Optional<Usuarios> consulta=usuariosrepositorio.getUsuarios(usuarios.getId());
            if (consulta.isEmpty()) {
                return usuariosrepositorio.save(usuarios);
                
            } else {
                return usuarios;                
            }
            
        }
    }

    public List<Usuarios>getAll(){
        return usuariosrepositorio.getAll();
    }

    public Optional<Usuarios>getUsuarios(String id){
        return usuariosrepositorio.getUsuarios(id);
    }

    public boolean deleteUsuarios(String id){
        Optional<Usuarios> consulta=usuariosrepositorio.getUsuarios(id);
        if (!consulta.isEmpty()) {
            usuariosrepositorio.delete(consulta.get());
            return true;
            
        }
        return false;
    }

    public boolean existeEmail (String email){
        return usuariosrepositorio.existeEmail(email);
    }
    
    // public Usuarios autenticarUsusario(String id, String identification, String name, String address, String cellPhone, String email, String password, String zone, String type){
    //     Optional<Usuarios> usuario = usuariosrepositorio.autenticarUsuario(email, password);
        
    //     if (usuario.isEmpty()){
    //         return new Usuarios(identification, "NO DEFINIDO", address, cellPhone, email, password, zone, type);
    //     }
    //     else {
    //         return usuario.get();
    //     }
    // }

    public Usuarios autenticarUsusario(String email, String password){
        Optional<Usuarios> usuario = usuariosrepositorio.autenticarUsuario(email, password);
        
        if (usuario.isEmpty()){
            return new Usuarios(email, password, "NO DEFINIDO");
//            return new Usuarios();
        }
        else {
            return usuario.get();
        }
    }

    public Usuarios update(Usuarios usuarios){
        if (usuarios.getId()!=null) {
            Optional<Usuarios> consulta=usuariosrepositorio.getUsuarios(usuarios.getId());
            if (!consulta.isEmpty()) {
                if (usuarios.getIdentification()!=null) {
                    consulta.get().setIdentification(usuarios.getIdentification());                    
                }
                if(usuarios.getName()!=null){
                    consulta.get().setName(usuarios.getName());
                }
                if(usuarios.getAddress()!=null){
                    consulta.get().setAddress(usuarios.getAddress());
                }
                if (usuarios.getCellPhone()!=null) {
                    consulta.get().setCellPhone(usuarios.getCellPhone());
                    
                }
                if (usuarios.getEmail()!=null) {
                    consulta.get().setEmail(usuarios.getEmail());                   
                }
                if (usuarios.getPassword()!=null) {
                    consulta.get().setPassword(usuarios.getPassword());                    
                }
                if (usuarios.getZone()!=null) {
                    consulta.get().setZone(usuarios.getZone());                    
                }
                if (usuarios.getType()!=null) {
                    consulta.get().setType(usuarios.getType());                    
                }
                return usuariosrepositorio.save(consulta.get());
            }            
        }
        return usuarios;

    }


    




    
}

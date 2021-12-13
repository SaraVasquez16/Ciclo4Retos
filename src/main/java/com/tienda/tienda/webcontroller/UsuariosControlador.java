package com.tienda.tienda.webcontroller;

import java.util.List;
import java.util.Optional;

import com.tienda.tienda.model.Usuarios;
import com.tienda.tienda.service.UsuariosServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UsuariosControlador {

    @Autowired
    private UsuariosServicio usuariosServicio;

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Usuarios usuarios){
        usuariosServicio.save(usuarios);
    }

    @GetMapping("/all")
    public List<Usuarios>getUsuarios(){
        return usuariosServicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Usuarios>getUsuarios(@PathVariable("id") String id){
        return usuariosServicio.getUsuarios(id);
    }

    @GetMapping("/{email}/{password}")
    public Usuarios autenticarUsuario(@PathVariable("email")String email, @PathVariable("password")String password){
        return usuariosServicio.autenticarUsusario(email, password);
    }
    
    @GetMapping("/emailexist/{email}")
    public boolean existeEmail(@PathVariable("email")String email){
        return usuariosServicio.existeEmail(email);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteUsuarios(@PathVariable("id") String id){
        return usuariosServicio.deleteUsuarios(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuarios update(@RequestBody Usuarios usuarios){
        return usuariosServicio.update(usuarios);
    }


    
}

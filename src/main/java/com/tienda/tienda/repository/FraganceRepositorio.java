package com.tienda.tienda.repository;

import java.util.List;
import java.util.Optional;

import com.tienda.tienda.model.Fragance;
import com.tienda.tienda.repository.crud.FraganceCrudRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class FraganceRepositorio {

    @Autowired
    FraganceCrudRepositorio fraganceCrudRepositorio;

    public Fragance save(Fragance fragance){
        return fraganceCrudRepositorio.save(fragance);
    }

    public List<Fragance>getAll(){
        return (List<Fragance>)fraganceCrudRepositorio.findAll();
    }

    public Optional<Fragance>getFragance(String reference){
        return fraganceCrudRepositorio.findById(reference);
    }

    public void delete(Fragance fragance){
        fraganceCrudRepositorio.delete(fragance);
    }

}

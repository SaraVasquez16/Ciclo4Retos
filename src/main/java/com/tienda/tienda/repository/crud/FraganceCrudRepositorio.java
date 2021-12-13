package com.tienda.tienda.repository.crud;

import com.tienda.tienda.model.Fragance;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FraganceCrudRepositorio extends MongoRepository<Fragance,String> {
    
}

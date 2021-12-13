package com.tienda.tienda.service;

import java.util.List;
import java.util.Optional;

import com.tienda.tienda.model.Fragance;
import com.tienda.tienda.repository.FraganceRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FraganceServicio {
    @Autowired
    private FraganceRepositorio fragancerepositorio;

    public Fragance save(Fragance fragance){
        if (fragance.getReference()==null) {
            return fragancerepositorio.save(fragance);
            
        } else {
            Optional<Fragance> consulta=fragancerepositorio.getFragance(fragance.getReference());
            if (consulta.isEmpty()) {
                return fragancerepositorio.save(fragance);
                
            } else {
                return fragance;                
            }
            
        }
    }

    public List<Fragance>getAll(){
        return fragancerepositorio.getAll();
    }

    public Optional<Fragance>getFragance(String reference){
        return fragancerepositorio.getFragance(reference);
    }

    public boolean deleteFragance(String reference){
        Optional<Fragance> consulta=fragancerepositorio.getFragance(reference);
        if (!consulta.isEmpty()) {
            fragancerepositorio.delete(consulta.get());
            return true;
            
        }
        return false;
    }

    public Fragance update(Fragance fragance){
        if (fragance.getReference()!=null) {
            Optional<Fragance> consulta=fragancerepositorio.getFragance(fragance.getReference());
            if (!consulta.isEmpty()) {
                if (fragance.getBrand()!=null) {
                    consulta.get().setBrand(fragance.getBrand());                    
                }
                if(fragance.getPresentation()!=null){
                    consulta.get().setPresentation(fragance.getPresentation());
                }
                if(fragance.getDescription()!=null){
                    consulta.get().setDescription(fragance.getDescription());
                }
                if (fragance.getPrice()!=null) {
                    consulta.get().setPrice(fragance.getPrice()); 
                }
                if (fragance.getAvailability()!=null) {
                    consulta.get().setAvailability(fragance.getAvailability()); 
                }
                if (fragance.getQuantity()!=null) {
                    consulta.get().setQuantity(fragance.getQuantity());                   
                }
                if (fragance.getPhotography()!=null) {
                    consulta.get().setPhotography(fragance.getPhotography());                    
                }
                return fragancerepositorio.save(consulta.get());
            }            
        }
        return fragance;

    }

}

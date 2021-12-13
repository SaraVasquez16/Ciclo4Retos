package com.tienda.tienda.webcontroller;

import java.util.List;
import java.util.Optional;

import com.tienda.tienda.model.Fragance;
import com.tienda.tienda.service.FraganceServicio;

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
@RequestMapping("/api/fragance")
public class FraganceControlador {

    @Autowired
    private FraganceServicio fraganceServicio;

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Fragance fragance){
        fraganceServicio.save(fragance);
    }

    @GetMapping("/all")
    public List<Fragance>getFragance(){
        return fraganceServicio.getAll();
    }

    @GetMapping("/{reference}")
    public Optional<Fragance>getFragance(@PathVariable("reference") String reference){
        return fraganceServicio.getFragance(reference);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteFragance(@PathVariable("reference") String reference){
        return fraganceServicio.deleteFragance(reference);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Fragance update(@RequestBody Fragance fragance){
        return fraganceServicio.update(fragance);
    }
}

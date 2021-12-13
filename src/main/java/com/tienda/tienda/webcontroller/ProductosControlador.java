package com.tienda.tienda.webcontroller;

import java.util.List;
import java.util.Optional;

import com.tienda.tienda.model.Productos;
import com.tienda.tienda.service.ProductosServicio;

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
@RequestMapping("/api/productos")
public class ProductosControlador {

    @Autowired
    private ProductosServicio productosServicio;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Productos productos){
        productosServicio.save(productos);
    }

    @GetMapping("/all")
    public List<Productos>getProductos(){
        return productosServicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Productos>getProductos(@PathVariable("id") String id){
        return productosServicio.getProductos(id);
    }

    @GetMapping("/reporteprecio/{precio}")
    public List<Productos> getProductosPorPrecio(@PathVariable("precio") Long precio){
        return productosServicio.getProductosPorPrecio(precio);
    }

    @GetMapping("/reportepreciomdb/{precio}")
    public List<Productos> getProductosPorPrecioMdb(@PathVariable("precio") Long precio){
        return productosServicio.getProductosPorPrecioMdb(precio);
    }

    @GetMapping("/reportepreciomdb/{precio}/{stock}")
    public List<Productos> getProductosPorPrecioStockMdb(@PathVariable("precio") Long precio, @PathVariable("stock") Integer stock ){
        return productosServicio.getProductosPorPrecioStockMdb(precio, stock);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteProductos(@PathVariable("id") String id){
        return productosServicio.deleteProductos(id);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Productos update(@RequestBody Productos productos){
        return productosServicio.update(productos);
    }


    
}

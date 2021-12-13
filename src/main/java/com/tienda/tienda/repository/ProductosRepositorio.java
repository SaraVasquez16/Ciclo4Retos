package com.tienda.tienda.repository;

import java.util.List;
import java.util.Optional;

import com.tienda.tienda.model.Productos;
import com.tienda.tienda.repository.crud.ProductosCrudRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class ProductosRepositorio {

    @Autowired
    ProductosCrudRepositorio productosCrudRepositorio;

    public Productos save(Productos productos){
        return productosCrudRepositorio.save(productos);
    }

    public List<Productos>getAll(){
        return (List<Productos>)productosCrudRepositorio.findAll();
    }

    public Optional<Productos>getProductos(String id){
        return productosCrudRepositorio.findById(id);
    }

    public List<Productos> getProductosPorPrecio(Long precio){
        return productosCrudRepositorio.findAllByPrecioLessThanEqual(precio);
    }

    public List<Productos> getproductosPorPrecioMdb(Long precio){
        return productosCrudRepositorio.getProductosByPrecio(precio);
    }

    public List<Productos> getProductosPorpPrecioStockMdb(Long precio, Integer stock){
        return productosCrudRepositorio.getProductosByPrecioStock(precio, stock);
    }

    public void delete(Productos productos){
        productosCrudRepositorio.delete(productos);
    }




    
}

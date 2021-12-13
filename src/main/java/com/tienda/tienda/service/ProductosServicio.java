package com.tienda.tienda.service;

import java.util.List;
import java.util.Optional;

import com.tienda.tienda.model.Productos;
import com.tienda.tienda.repository.ProductosRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductosServicio {
    @Autowired
    private ProductosRepositorio productosrepositorio;

    public Productos save(Productos productos){
        if (productos.getId()==null) {
            return productosrepositorio.save(productos);
            
        } else {
            Optional<Productos> consulta=productosrepositorio.getProductos(productos.getId());
            if (consulta.isEmpty()) {
                return productosrepositorio.save(productos);
                
            } else {
                return productos;                
            }
            
        }
    }

    public List<Productos>getAll(){
        return productosrepositorio.getAll();
    }

    public Optional<Productos>getProductos(String id){
        return productosrepositorio.getProductos(id);
    }

    public List<Productos> getProductosPorPrecio(Long precio){
        return productosrepositorio.getProductosPorPrecio(precio);
    }

    public List<Productos>getProductosPorPrecioMdb(Long precio){
        return productosrepositorio.getproductosPorPrecioMdb(precio);
    }

    public List<Productos>getProductosPorPrecioStockMdb(Long precio, Integer stock){
        return productosrepositorio.getProductosPorpPrecioStockMdb(precio, stock);
    } 

    public boolean deleteProductos(String id){
        Optional<Productos> consulta=productosrepositorio.getProductos(id);
        if (!consulta.isEmpty()) {
            productosrepositorio.delete(consulta.get());
            return true;
            
        }
        return false;
    }

    public Productos update(Productos productos){
        if (productos.getId()!=null) {
            Optional<Productos> consulta=productosrepositorio.getProductos(productos.getId());
            if (!consulta.isEmpty()) {
                if (productos.getCategoria()!=null) {
                    consulta.get().setCategoria(productos.getCategoria());                    
                }
                if(productos.getNombre()!=null){
                    consulta.get().setNombre(productos.getNombre());
                }
                if(productos.getDescripcion()!=null){
                    consulta.get().setDescripcion(productos.getDescripcion());
                }
                if (productos.getPrecio()!=null) {
                    consulta.get().setPrecio(productos.getPrecio());
                    
                }
                if (productos.getDisponibilidad()!=null) {
                    consulta.get().setDisponibilidad(productos.getDisponibilidad());                   
                }
                if (productos.getStock()!=null) {
                    consulta.get().setStock(productos.getStock());                    
                }
                return productosrepositorio.save(consulta.get());
            }            
        }
        return productos;

    }


    




    
}

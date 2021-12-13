package com.tienda.tienda.repository.crud;

import java.util.List;

import com.tienda.tienda.model.Productos;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ProductosCrudRepositorio extends MongoRepository<Productos,String> {
    //Consultar todos los productos cuyo precio es menor o igual a un precio dado

    public List<Productos> findAllByPrecioLessThanEqual(Long precio);

    //Consultar todos los productos cuyo precio es menor o igual a un precio dado. Utlizando @Query

    
    @Query("{precio:{$lte:?0}}")
    public List<Productos> getProductosByPrecio(Long precio);

    //{precio:{$lte:330}, stock:{$gte:300}}

    @Query("{precio:{$lte:?0}, stock:{$gte:?1}}")
    public List<Productos> getProductosByPrecioStock(Long precio, Integer stock);




    
}

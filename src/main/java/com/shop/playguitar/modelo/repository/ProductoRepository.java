package com.shop.playguitar.modelo.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shop.playguitar.modelo.bean.Producto;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{
	
	
	@Query("SELECT p FROM Producto p WHERE p.nombre = :nombre")
	List<Producto> buscarPorNombre(@Param("nombre") String nombre);
	
	//Producto findByNombre(String nombre);
	
	//Producto findById(int id);
	/*
	@Modifying
    @Query("UPDATE Producto p SET p.idProducto = :idProducto, p.nombre = :nombre, p.precio = :precio, p.descripcion = :descripcion, p.stock = :stock")
    int actualizarTodosLosProductos(@Param("idProducto") int idProducto, @Param("nombre") String nombre, @Param("precio") double precio, 
    		@Param("descripcion") String descripcion, @Param("stock") int stock);
*/
	
	 @Query("SELECT p.stock FROM Producto p WHERE p.idProducto = ?1")
	 int verStock(int IdProducto);
	 

}

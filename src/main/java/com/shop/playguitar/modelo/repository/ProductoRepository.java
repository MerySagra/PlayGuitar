package com.shop.playguitar.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shop.playguitar.modelo.bean.Producto;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{
	
	//Saca la lista de productos por su nombre
	@Query("SELECT p FROM Producto p WHERE p.nombre = :nombre")
	List<Producto> buscarPorNombre(@Param("nombre") String nombre);

	//Saca el stock de un producto por su id
	 @Query("SELECT p.stock FROM Producto p WHERE p.idProducto = ?1")
	 int verStock(int IdProducto);
	 

}

package com.shop.playguitar.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shop.playguitar.modelo.bean.Usuario;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	@Query("SELECT u FROM Usuario u JOIN UsuarioDirecciones ud ON u.id = ud.usuario JOIN ud.direccion d WHERE d.localidad = :localidad")
	List<Usuario> buscarPorCiudad(@Param("localidad") String localidad);

	List<Usuario> findAll();

	Usuario findByEmail(String email);

	@Query("SELECT DISTINCT u FROM Usuario u JOIN FETCH u.direcciones WHERE u.id = :id")
	Usuario findByIdWithAddress(int id);
	
	
	
	


}

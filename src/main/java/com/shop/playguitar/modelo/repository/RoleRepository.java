package com.shop.playguitar.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.playguitar.modelo.bean.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{
	
	//Role findById(int id);

}

package com.web.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.spring.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
	//save, findById, findAll, delete, deleteById...
}

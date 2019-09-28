package com.ma.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ma.app.model.Usuario;

public interface UsuarioRepository  extends JpaRepository<Usuario, Integer>{

}

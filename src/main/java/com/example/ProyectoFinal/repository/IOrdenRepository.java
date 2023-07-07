package com.example.ProyectoFinal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ProyectoFinal.model.Orden;
import com.example.ProyectoFinal.model.Usuario;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface IOrdenRepository extends JpaRepository<Orden, Integer> {

    List<Orden> findByUsuario(Usuario usuario);
    //Query que nos ayudara en el filtrado de informacion de las ordenes que visualizara el administrador
    @Query(value = "SELECT * FROM `ordenes` where ordenes.numero like %?1%", nativeQuery = true)
    //Lista orden que contendra el parametro con el cual haremos el filtrado de la informacion
    List<Orden> findOrdenBuscar(String numero);
}

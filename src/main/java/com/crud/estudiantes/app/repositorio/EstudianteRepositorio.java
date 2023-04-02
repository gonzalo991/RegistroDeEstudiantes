package com.crud.estudiantes.app.repositorio;

import com.crud.estudiantes.app.entidades.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Indicamos con la anotación Repository que este es un repositorio de jpa
// y hacemos que herede de JpaRepository<Clase, tipo de dato de id>
@Repository
public interface EstudianteRepositorio extends JpaRepository<Estudiante, Long> {
    
}

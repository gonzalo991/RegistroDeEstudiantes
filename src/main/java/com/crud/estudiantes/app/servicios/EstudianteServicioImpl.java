package com.crud.estudiantes.app.servicios;

import com.crud.estudiantes.app.entidades.Estudiante;
import com.crud.estudiantes.app.repositorio.EstudianteRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Con la anotación de service, indicamos que la clase es un servicio de 
//Spring boot y le indicamos que implemente la interfaz de IEstudianteServicio
@Service
public class EstudianteServicioImpl implements IEstudianteServicio {

    //Con la anotación @Autowired indicamos que la variable se inicializa automáticamente
    @Autowired
    private EstudianteRepositorio estudianteRepositorio;

    @Override
    public List<Estudiante> listarTodosLosEstudiantes() {
        //Usamos el método findAll() del repositorio para traer la lista 
        //de estudiantes
        return estudianteRepositorio.findAll();
    }

    @Override
    public Estudiante guardarEstudiante(Estudiante estudiante) {
        return estudianteRepositorio.save(estudiante);
    }

    @Override
    public Estudiante obtenerEstudiantePorId(Long id) {
        return estudianteRepositorio.findById(id).orElse(null);
    }

    @Override
    public Estudiante actualizarEstudiante(Estudiante estudiante) {
        return estudianteRepositorio.save(estudiante);
    }

    @Override
    public void eliminarEstudiante(Long id) {
        estudianteRepositorio.deleteById(id);
    }

}

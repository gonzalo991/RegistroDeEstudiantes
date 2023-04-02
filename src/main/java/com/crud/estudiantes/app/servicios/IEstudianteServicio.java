package com.crud.estudiantes.app.servicios;

import com.crud.estudiantes.app.entidades.Estudiante;
import java.util.List;

//Se crea la interfaz enargada de los métodos abstractos que
//se van a utilizar en nuestra aplicación
public interface IEstudianteServicio {
    
    public List<Estudiante> listarTodosLosEstudiantes();
    
}

package com.crud.estudiantes.app.controlador;

import com.crud.estudiantes.app.servicios.IEstudianteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//Indicamos a spring que esta clase es un controlador con la anotacion Controller
@Controller
public class EstudianteControlador {

    //Hacemos la inyección de dependencia, en este caso del servicio
    //Se inyecta la interfaz ya que spring automaticamente
    //al ver el método listarTodosLosEstudiantes, lo buscará en el servicio
    @Autowired
    private IEstudianteServicio estudianteServicio;

    //Inicamos que haremos una petición GET con la anotación GetMapping
    // y declaramos la ruta
    @GetMapping({"/estudiantes", "/"})
    public String listarEstudiantes(Model model) {
        //Agregamos el modelo y le brindamos atributos para poder acceder desde las plantillas html
        model.addAttribute("estudiantes", estudianteServicio.listarTodosLosEstudiantes());
        return "estudiantes"; //nos retorna al archivo estudiantes con thymeleaf
    }

}

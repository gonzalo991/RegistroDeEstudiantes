package com.crud.estudiantes.app.controlador;

import com.crud.estudiantes.app.entidades.Estudiante;
import com.crud.estudiantes.app.servicios.IEstudianteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    //Creamos una ruta que nos lleve al formulario para crear un nuevo estudiante
    @GetMapping("/estudiantes/nuevo")
    public String mostrarRegistrarEstudianteFormulario(Model modelo) {
        //Pasamos un objeto al modelo para que en el formulario podamos
        //cargarle los atributos
        Estudiante estudiante = new Estudiante();
        modelo.addAttribute("estudiante", estudiante);
        return "crear_estudiante";
    }

    //Creamos la ruta para crear el registro de un nuevo estudiante
    @PostMapping("/estudiantes")
    public String guardarEstudiante(@ModelAttribute("estudiante") Estudiante estudiante) {
        estudianteServicio.guardarEstudiante(estudiante);
        return "redirect:/estudiantes";
    }

    //Mostrar un formulario para editar el estudiante y a la vez envía el id del estudiante
    @GetMapping("/estudiantes/editar/{id}")
    public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("estudiante", estudianteServicio.obtenerEstudiantePorId(id));
        return "editar_estudiante";
    }

    //Creamos la ruta para editar el estudiante con el mètodo post
    //le enviamos el id como variable mediante la ruta
    @PostMapping("/estudiantes/{id}")
    public String actualizarEstudiante(@PathVariable Long id, @ModelAttribute("estudiante") Estudiante estudiante, Model modelo) {
        //mediante el id que recibimos creamos un nuevo objeto estudiante y utilizamos
        //el mètodo del servicio para buscar un estudiante por id
        Estudiante estudianteExistente = estudianteServicio.obtenerEstudiantePorId(id);
        //Empezamos a settear los atributos que recibimos del modelo del objeto estudiante
        estudianteExistente.setId(id);
        estudianteExistente.setNombre(estudiante.getNombre());
        estudianteExistente.setApellido(estudiante.getApellido());
        estudianteExistente.setEmail(estudiante.getEmail());
        estudianteServicio.actualizarEstudiante(estudianteExistente);

        return "redirect:/estudiantes";
    }

    @GetMapping("/estudiantes/{id}")
    public String eliminarEstudiante(@PathVariable Long id) {
        estudianteServicio.eliminarEstudiante(id);
        return "redirect:/estudiantes";
    }

}

package com.crud.estudiantes.app.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//La anotación entity indica que la clase Estudiantes es una Entidad
@Entity
//La anotación Table indica el nombre de la tabla en la que se guardaran los estudiantes
@Table(name = "estudiantes")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Con @Column indicamos el nombre de la columna y con su atributo nullable
    //indicamos que no puede ser nulo dandole el valor de false
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    //atributp length indica la cantidad máxima de caracteres
    @Column(name = "apellido", nullable = false, length = 50)
    private String apellido;

    //Con el atributo unique indicamos que el email no se puede repetir en la base de datos
    @Column(name = "email", nullable = false, length = 50, unique = true)
    private String email;

    public Estudiante() {

    }

    public Estudiante(Long id, String nombre,
            String apellido, String email) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + '}';
    }
    
    

}

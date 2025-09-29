package es.alumnos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Clase modelo para representar un alumno
 * Usamos Lombok para generar automáticamente getters, setters, toString, etc.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Alumno {

    // datos alumno
    private Integer id;
    private String nombre;
    private String apellidos;
    private int edad;
    
    // constructor para crear alumno sin ID (para insertar en la BD)
    public Alumno(final String nombre, final String apellidos, final int edad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }
}

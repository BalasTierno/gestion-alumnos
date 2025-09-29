package es.alumnos;

import java.util.List;

public interface AlumnoDao {
    void insert(Alumno alumno);
    List<Alumno> findAll();
    void deleteById(int id);
}

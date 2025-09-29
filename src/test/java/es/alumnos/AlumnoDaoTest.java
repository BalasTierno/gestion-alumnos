package es.alumnos;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AlumnoDaoTest {

    // test insertar
    @Test
    void insertar_llama_dao() {
        // mock dao
        final AlumnoDao dao = Mockito.mock(AlumnoDao.class);
        // nuevo alumno
        final Alumno a = new Alumno("Alvaro", "Balas Jimenez", 19);

        // insertar alumno
        dao.insert(a);
        // verificar inserción
        Mockito.verify(dao, Mockito.times(1)).insert(a);
    }

    // test listar
    @Test
    void listar_devuelve_lista() {
        // mock dao
        final AlumnoDao dao = Mockito.mock(AlumnoDao.class);
        // simular lista
        Mockito.when(dao.findAll()).thenReturn(List.of(new Alumno("Alvaro", "Balas Jimenez", 19)));

        // obtener lista
        final List<Alumno> lista = dao.findAll();
        // comprobar tamaño
        Assertions.assertEquals(1, lista.size());
    }
    // fin test
}

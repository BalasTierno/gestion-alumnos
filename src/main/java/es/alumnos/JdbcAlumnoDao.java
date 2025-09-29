package es.alumnos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcAlumnoDao implements AlumnoDao {

    // crear tabla
    public JdbcAlumnoDao() {
        try (Connection c = H2ConnectionFactory.get();
            Statement st = c.createStatement()) {
            st.execute("""
                CREATE TABLE IF NOT EXISTS alumnos (
                    id IDENTITY PRIMARY KEY,
                    nombre VARCHAR(100) NOT NULL,
                    apellidos VARCHAR(150) NOT NULL,
                    edad INT NOT NULL
                )
            """);
        } catch (final SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // insertar alumno
    @Override
    public void insert(final Alumno a) {
        final String sql = "INSERT INTO alumnos(nombre, apellidos, edad) VALUES(?,?,?)";
        try (Connection c = H2ConnectionFactory.get();
            PreparedStatement ps = c.prepareStatement(sql)) {
                ps.setString(1, a.getNombre());
                ps.setString(2, a.getApellidos());
                ps.setInt(3, a.getEdad());
                ps.executeUpdate();
        } catch (final SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // listar alumnos
    @Override
    public List<Alumno> findAll() {
        final String sql = "SELECT id, nombre, apellidos, edad FROM alumnos ORDER BY apellidos, nombre";
        try (Connection c = H2ConnectionFactory.get();
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {
            final List<Alumno> out = new ArrayList<>();
            while (rs.next()) {
                final Alumno alumno = new Alumno(rs.getString(2), rs.getString(3), rs.getInt(4));
                alumno.setId(rs.getInt(1));
                out.add(alumno);
            }
            return out;
        } catch (final SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // borrar por id
    @Override
    public void deleteById(final int id) {
        final String sql = "DELETE FROM alumnos WHERE id = ?";
        try (Connection c = H2ConnectionFactory.get();
            PreparedStatement ps = c.prepareStatement(sql)) {
                ps.setInt(1, id);
                ps.executeUpdate(); // si no existe, simplemente no borra filas
        } catch (final SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "JdbcAlumnoDao []";
    }
}

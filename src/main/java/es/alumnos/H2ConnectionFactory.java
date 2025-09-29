package es.alumnos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class H2ConnectionFactory {
    private static final String URL  = "jdbc:h2:./alumnos.db";
    private static final String USER = "sa";
    private static final String PASS = "";

    static {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("No se encontró el driver H2", e);
        }
    }

    private H2ConnectionFactory() {}

    public static Connection get() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}

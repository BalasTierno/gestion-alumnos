package es.alumnos;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        AlumnoDao dao = new JdbcAlumnoDao();

        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.println("1) Insertar  2) Listar  3) Borrar por ID  0) Salir");
                System.out.print("> ");
                String op = sc.nextLine().trim();

                switch (op) {
                    case "1" -> {
                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();
                        System.out.print("Apellidos: ");
                        String apellidos = sc.nextLine();
                        System.out.print("Edad: ");
                        int edad = Integer.parseInt(sc.nextLine());
                        dao.insert(new Alumno(nombre, apellidos, edad));
                        System.out.println("Alumno guardado.");
                    }
                    case "2" -> dao.findAll().forEach(System.out::println);
                    case "3" -> {
                        System.out.print("ID a borrar: ");
                        int id = Integer.parseInt(sc.nextLine());
                        dao.deleteById(id); // método void: solo ejecuta
                        System.out.println("Si existía, el alumno con ID " + id + " ha sido borrado.");
                    }
                    case "0" -> { return; }
                    default -> System.out.println("Opción inválida.");
                }
            }
        }
    }
}

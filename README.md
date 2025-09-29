# Sistema de Gestión de Alumnos

## Descripción
Proyecto de DAM 2 - Sistema para gestionar información básica de alumnos utilizando Java 17, Maven, Lombok y base de datos H2.

## Características
- ✅ Insertar nuevos alumnos
- ✅ Listar todos los alumnos
- ✅ Eliminar alumnos por ID
- ✅ Base de datos H2 embebida
- ✅ Patrón DAO para acceso a datos
- ✅ Uso de Lombok para reducir código repetitivo
- ✅ Pruebas unitarias con JUnit 5 y Mockito

## Tecnologías utilizadas
- Java 17
- Maven 3.9+
- Lombok 1.18.32
- Base de datos H2 2.2.224
- JUnit 5.10.2
- Mockito 5.12.0

## Cómo ejecutar el proyecto

### Prerequisitos
- Java 17 o superior
- Maven 3.6 o superior

### Compilar y ejecutar
```bash
# Compilar el proyecto
mvn clean compile

# Ejecutar las pruebas
mvn test

# Crear el JAR
mvn package

# Ejecutar la aplicación
mvn exec:java -Dexec.mainClass="es.alumnos.App"
```

## Estructura del proyecto
```
src/
├── main/java/es/alumnos/
│   ├── Alumno.java          # Clase modelo
│   ├── AlumnoDao.java       # Interfaz DAO
│   ├── JdbcAlumnoDao.java   # Implementación DAO
│   ├── H2ConnectionFactory.java # Factory de conexiones
│   └── App.java             # Aplicación principal
└── test/java/es/alumnos/
    ├── AlumnoDaoTest.java   # Pruebas DAO
    └── AppTest.java         # Pruebas aplicación
```

## Autor
Estudiante de DAM 2 - Desarrollo de Aplicaciones Multiplataforma

## Estado del proyecto
✅ **LISTO PARA PRESENTAR**
- Compila sin errores
- Todas las pruebas pasan
- Funcionalidad completa implementada

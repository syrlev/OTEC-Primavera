# MVP OTEC Primavera - Sistema de Gestión Académica

## Descripción del Proyecto
Este es un Producto Mínimo Viable (MVP) desarrollado para modernizar la gestión administrativa de la OTEC Primavera. La plataforma centraliza el registro de cursos y permite el seguimiento del progreso académico de los estudiantes en tiempo real.

## Stack Tecnológico
* **Lenguaje:** Java 17
* **Framework:** Spring Boot 3.x (MVC)
* **Seguridad:** Spring Security con cifrado BCrypt.
* **Base de Datos:** MySQL / MariaDB (vía Spring Data JPA).
* **Vistas:** Thymeleaf con tema Sandstone.
* **Gestión de Dependencias:** Maven.

## Estructura de Carpetas
El proyecto respeta la separación de responsabilidades:
* `controlador`: Manejo de rutas web y API REST.
* `modelo`: Entidades y persistencia.
* `servicio`: Lógica de negocio.
* `repositorio`: Interfaces de acceso a datos.
* `seguridad`: Configuración de acceso y roles.

## Credenciales de Acceso (Prueba)
El sistema cuenta con los siguientes usuarios cargados mediante `DataInitializer`:

| Rol | Usuario | Contraseña |
| :--- | :--- | :--- |
| **Administrador** | admin | admin123 |
| **Estudiante** | estudiante | alumno123 |

## Interoperabilidad (API REST)
Para futuras integraciones (como una App Móvil), se ha habilitado un endpoint que expone los cursos en formato JSON:
* **URL:** `http://localhost:8081/api/cursos`

## Instrucciones de Instalación
1. **Clonar este repositorio.**
2. **Preparar la Base de Datos:**
   Cree la base de datos en su servidor local:
   ```sql
   CREATE DATABASE otec_primavera;
3. Configuración: Revisar las credenciales en src/main/resources/application.properties.
4. Ejecución: Ejecutar el proyecto desde su IDE o con mvn spring-boot:run.
5. Acceso: Ingrese en el navegador a http://localhost:8081/

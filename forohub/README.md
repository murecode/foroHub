
---

# Foro API REST

## Descripción

Esta es una API REST para un foro de tecnología donde las personas pueden crear tópicos con sus dudas o sugerencias y otras personas pueden responder e interactuar. El propósito de este proyecto es facilitar la creación de una comunidad de intercambio de conocimientos y apoyo mutuo.

## Características

- **Usuarios**: Registro y autenticación de usuarios.
- **Tópicos**: Creación, edición y eliminación de tópicos.
- **Respuestas**: Respuestas a los tópicos, permitiendo la interacción entre usuarios.

## Tecnologías

- **Lenguaje**: Java
- **Framework**: Spring Boot
- **Base de Datos**: PostgreSQL
- **Seguridad**: Spring Security con JWT
- **Documentación de la API**: Swagger

## Instalación

### Prerrequisitos

- Java 11 o superior
- Maven 3.6.0 o superior
- PostgreSQL

### Pasos

1. Clona el repositorio:
    ```bash
    git clone https://github.com/tu-usuario/foro-api.git
    cd foro-api
    ```

2. Configura la base de datos en el archivo `application.properties`:
    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/foro
    spring.datasource.username=tu-usuario
    spring.datasource.password=tu-contraseña
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    ```

3. Ejecuta la aplicación:
    ```bash
    mvn spring-boot:run
    ```

## Uso

### Endpoints principales

- **Usuarios**
    - `POST auth/register`:  Registro de nuevos usuarios. *pendiente*
    - `POST auth/login`:     Autenticación de usuarios.

- **Tópicos**
    - `GET    /topics`: Listado de todos los tópicos.
    - `GET    /topics/{id}`: Obtener un tópico por ID.
    - `POST   /topics`: Crear un nuevo tópico.
    - `POST   /topics/{id}/answer`: Dar respuesta a un tópico.
    - `PATCH  /topics/{id}`: Actualizar un tópico existente.
    - `DELETE /topics/{id}`: Eliminar un tópico.

- **Respuestas**
    - `GET    /answers/{id}`: Listado respuesta por usuario ID.
    - `PATCH  /answers/{id}`: Actualizar respuesta.
    - `DELETE /answers/{id}`: Eliminar repuesta.


### Autenticación

La API utiliza JWT para la autenticación. Después de registrarse o iniciar sesión, los usuarios reciben un token JWT que debe ser incluido en el encabezado de las solicitudes posteriores:

```http
Authorization: Bearer <token>
```

### Documentación de la API

La documentación de la API está disponible en [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html).

---

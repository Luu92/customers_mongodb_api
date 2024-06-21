# App Demo Customers con MongoDB

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.0-green)
![MongoDB](https://img.shields.io/badge/MongoDB-7.0.11-green)
![Java](https://img.shields.io/badge/Java-17-blue)

Este proyecto es una aplicación de ejemplo desarrollada con Spring Boot que utiliza MongoDB como base de datos. Implementa operaciones básicas de un CRUD para gestionar entidades de usuarios (Customers).

## Configuración de la Base de Datos MongoDB

- Asegúrate de tener MongoDB instalado y ejecutándose en tu máquina local.
- Configura la conexión a MongoDB en el archivo `application.properties` de Spring Boot:

    ```properties
    spring.data.mongodb.host=localhost
    spring.data.mongodb.port=27017
    spring.data.mongodb.database="nombre_db_mongo"
    ```
 Ajusta `spring.data.mongodb.database` según el nombre de tu base de datos.
 
## Operaciones del CRUD

La aplicación implementa las siguientes operaciones básicas del CRUD para la entidad Customer:

- **Leer Todos**: `GET /users/allCustomers`
  - Obtiene todos los customers.

- **Crear**: `POST /users/save`
  - Crea un nuevo customer con los datos proporcionados en el cuerpo de la solicitud.

- **Leer**: `GET /users/{id}`
  - Obtiene un customer por su ID.

- **Actualizar**: `PUT /users/update`
  - Actualiza los datos de un customer existente con los datos proporcionados.

- **Eliminar**: `DELETE /users/delete/{id}`
  - Elimina un customer por su ID.
  
## Contribuciones y Problemas

Si encuentras algún problema o deseas contribuir al proyecto, por favor abre un issue o envía un pull request. ¡Tus contribuciones son bienvenidas! 


  
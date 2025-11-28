📦 CrudTalentoTech2025Final-JavaSpringBoot

Backend CRUD completo con Java • Spring Boot • MySQL (XAMPP) • Postman

Este proyecto implementa un CRUD de artículos utilizando Java con Spring Boot, conectado a una base de datos MySQL/MariaDB.
El backend es completamente funcional y puede probarse tanto con Postman como a través del frontend asociado.

🔗 Frontend del proyecto (opcional)

El frontend fue desarrollado solo para comprobar las operaciones CRUD del backend de forma visual, sin diseño avanzado.
⬇️ Podés verlo acá:

👉 Front (simple para pruebas):
https://github.com/Matt8421/FrontTalentoTechFinal2025

🚀 Tecnologías utilizadas
Backend

Java 17

Spring Boot 3+

Spring Web

Spring Data JPA

MySQL Connector/J

Maven

XAMPP + phpMyAdmin

MySQL Workbench 8.0

Postman para pruebas de API

🧱 Arquitectura del proyecto
src/
 └─ main/
     └─ java/com/talento/crud/
         ├─ model/            → Entidad JPA (Articulo)
         ├─ repository/       → JpaRepository
         ├─ service/          → Lógica de negocio (interfaz + implementación)
         └─ controller/       → Endpoints REST


Patrones utilizados:

MVC 

Inversión de dependencias (@Autowired constructor)

DTO implícito mediante entidad

ResponseEntity para manejo de estados HTTP

🗄️ Base de datos
Base: articulos_db

Tabla: articulo

CREATE TABLE `articulo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `precio` double NOT NULL,
  `imagen` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);


Incluye datos iniciales:

INSERT INTO `articulo` (`nombre`, `precio`) VALUES
('Cuaderno Nuevo Tapa Roja', 900),
('Coca Cola', 4500);

🧩 Modelo (Entidad JPA)

Representa la tabla articulo, incluyendo campos:

id

nombre

precio

imagen

@Entity
@Table(name="articulo")
public class Articulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Double precio;
    private String imagen;

🔗 Capa Repository
public interface ArticuloRepository extends JpaRepository<Articulo, Long> { }


Spring genera automáticamente los métodos CRUD.

⚙️ Capa Servicio

Define la lógica de negocio separada del controlador.

Interfaz:
public interface ArticuloService {
    List<Articulo> listarArticulos();
    Optional<Articulo> obtenerArticuloPorId(Long id);
    Articulo guardarArticulo(Articulo articulo);
    Articulo actualizarArticulo(Long id, Articulo articulo);
    void eliminarArticulo(Long id);
}

Implementación:
@Service
public class ArticuloServiceImpl implements ArticuloService {
    public Articulo actualizarArticulo(Long id, Articulo articulo){
        articulo.setId(id);
        return articuloRepository.save(articulo);
    }
}

🌐 Controlador REST

Ruta base:

/api/articulos


Incluye manejo de:

💬 GET (listar y por ID)

➕ POST (crear)

✏️ PUT (actualizar)

❌ DELETE (eliminar)

🛡️ CORS habilitado

Ejemplo:

@GetMapping("/{id}")
public ResponseEntity<Articulo> obtenerPorId(@PathVariable Long id) {
    return articuloService.obtenerArticuloPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
}

📮 Endpoints del CRUD
🔹 GET — Listar todos
GET http://localhost:8080/api/articulos

🔹 GET — Obtener por ID
GET http://localhost:8080/api/articulos/{id}

🔹 POST — Crear artículo

Body JSON:

{
  "nombre": "Cuaderno",
  "precio": 550,
  "imagen": "url-opcional"
}

🔹 PUT — Actualizar
PUT http://localhost:8080/api/articulos/{id}

🔹 DELETE — Eliminar
DELETE http://localhost:8080/api/articulos/{id}

🧪 Cómo probar el backend con Postman

Asegurate de tener el servidor en localhost:8080.

Importá tu colección (incluida en este repo).

Probá cada endpoint con JSON.

Si trabajás con front → CORS ya habilitado con:

@CrossOrigin(origins = "*")

🛠️ Cómo ejecutar el proyecto
1️⃣ Clonar el repo
git clone https://github.com/Matt8421/CrudTalentoTech2025Final  

2️⃣ Configurar application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/articulos_db
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update

3️⃣ Iniciar XAMPP (MySQL)
4️⃣ Iniciar Spring Boot

Desde VSCode o:

mvn spring-boot:run

🧩 Integración con Frontend (opcional)

Este backend está preparado para conectarse con el siguiente frontend:

👉 Frontend CRUD:
https://github.com/Matt8421/FrontTalentoTechFinal2025

El front permite:

Mostrar lista de artículos

Crear nuevos

Editar

Eliminar

Usar imágenes

Todo consumiendo la API REST creada en este backend.

🏁 Estado del proyecto

✔ Completamente funcional
✔ Preparado para producción
✔ Código ordenado, comentado y ampliable

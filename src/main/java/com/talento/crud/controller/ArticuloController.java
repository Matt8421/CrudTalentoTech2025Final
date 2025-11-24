// ------------------------------
// PAQUETE DEL CONTROLADOR
// ------------------------------
package com.talento.crud.controller;

// ------------------------------
// IMPORTS NECESARIOS
// ------------------------------

// Importa la clase Articulo (el modelo que representa la entidad)
import com.talento.crud.model.Articulo;

// Importa el servicio que contiene la lógica de negocio
import com.talento.crud.service.ArticuloService;

// Importaciones agrupadas para las anotaciones de Spring Web
// Esto incluye: @GetMapping, @PostMapping, @PutMapping,
// @DeleteMapping, @RequestBody, @PathVariable, @RestController, etc.
import org.springframework.web.bind.annotation.*;

// Permite devolver respuestas HTTP personalizadas (200, 404, etc)
import org.springframework.http.ResponseEntity;

// Lista para devolver colecciones de artículos
import java.util.List;

// ------------------------------
// CONTROLADOR REST
// ------------------------------
@CrossOrigin(origins = "*") 
// Permite que cualquier frontend (o Postman) haga peticiones a este controlador.
// Evita errores CORS cuando el front está en otro puerto (ej: 5500, 3000, etc.)

@RestController  
// Le dice a Spring que esta clase expone endpoints REST
// y convierte automáticamente los objetos en JSON para responder.

@RequestMapping("/api/articulos")
// Ruta base de todos los endpoints de este controlador.
// Todas las rutas empezarán con: http://localhost:8080/api/articulos

public class ArticuloController {

    // ------------------------------
    // INYECCIÓN DEL SERVICIO
    // ------------------------------
    private final ArticuloService articuloService;

    @Autowired
    // Inyección por constructor: Spring te da automáticamente una instancia de ArticuloService.
    // Esto respeta el principio de inversión de dependencias (el controlador NO crea el servicio).
    public ArticuloController(ArticuloService articuloService) {
        this.articuloService = articuloService;
    }

    // ------------------------------
    // GET - LISTAR TODOS LOS ARTÍCULOS
    // ------------------------------
    @GetMapping
    public List<Articulo> listar() {
        // Devuelve la lista completa de artículos
        return articuloService.listarArticulos();
    }

    // ------------------------------
    // GET - BUSCAR ARTÍCULO POR ID
    // ------------------------------
    @GetMapping("/{id}")
    public ResponseEntity<Articulo> obtenerPorId(@PathVariable Long id) {

        // Busca el artículo y devuelve:
        // - 200 OK con el articulo si existe
        // - 404 NOT FOUND si no está
        return articuloService.obtenerArticuloPorId(id)
                .map(ResponseEntity::ok)                   // Si lo encuentra
                .orElse(ResponseEntity.notFound().build()); // Si no está → 404
    }

    // ------------------------------
    // POST - CREAR UN ARTÍCULO
    // ------------------------------
    @PostMapping
    public Articulo crear(@RequestBody Articulo articulo) {

        // @RequestBody → toma el JSON que mandás en Postman y lo transforma en un objeto Articulo
        return articuloService.guardarArticulo(articulo);
    }

    // ------------------------------
    // PUT - ACTUALIZAR ARTÍCULO EXISTENTE
    // ------------------------------
    @PutMapping("/{id}")
    public ResponseEntity<Articulo> actualizar(@PathVariable Long id, @RequestBody Articulo articulo) {

        // Si no existe → devolver 404
        if (articuloService.obtenerArticuloPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        // Si existe → actualizar y devolver 200 OK
        return ResponseEntity.ok(articuloService.actualizarArticulo(id, articulo));
    }

    // ------------------------------
    // DELETE - BORRAR ARTÍCULO POR ID
    // ------------------------------
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        // Si el artículo no existe → 404
        if (articuloService.obtenerArticuloPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        articuloService.eliminarArticulo(id);

        // 204 NO CONTENT → operación exitosa pero sin contenido para devolver
        return ResponseEntity.noContent().build();
    }
}

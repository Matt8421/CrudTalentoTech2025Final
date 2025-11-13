//Paquete del controlador
package com.talento.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.talento.crud.service.ArticuloService;

//Controlador REST que maneja todas las peticiones HTTP - GET(id), POST, PUT, DELETE, - PATCH - OPTIONS
@RestController
//@RequestMapping define la ruta base para todas las peticiones de este controlador
//En este caso, todas las peticiones a este controlador comenzaran con api/articulos
//http://localhost:8080/api/articulos

@RequestMapping("api/articulos")
public class ArticuloController {

    //Inyeccion del servicio
    private final ArticuloService articuloService;

    //Constructor con inyeccion
    //para que Spring pueda inyectar el servicio automaticamente
    //cdo se crea una instancia de este controlador
    //Esto permite seguir el circuito de inversion de dependencias
    //el articulo service se inyecta en el controlador
    //y no se crea una instancia directamente dentro del controlador
    //Que significa q el controlador no cree una instancia dentro del servicio?
    //Esto permite q el servicio pueda ser reemplazado por otro
    //Xej. un servicio de prueba, sin modificar el controlador

    //El constructor del controlador recibe un ArticuloService
    //y lo asigna a la variable articuloService.
    @Autowired
    public ArticuloController(ArticuloService articuloService){
        this.articuloService = articuloService;
    }

    //GET /api/articulos -> lista todos los articulos
    @GetMapping
    public List<Articulo> listar(){
        //Llama al servicio para pedir la lista de articulos
        return articuloService.listarArticulos();
    }

    //GET /api/articulos/{id} -> busca un articulo por ID
    @GetMapping("/{id}")
    //Que es responseEntity? Es una clase que
    //representa una respuesta HTTP completa,
    //incluyendo el cuerpo , los encabezados y el codigo de estado.
    //Permite personalizar la respuesta q se envia al cliente
    //En este caso devuelve un articulo si lo encuentra , o un 404 sino
    //XQ usar responseEntity?   
    //Permite devolver diferentes codigos de estado HTTP y personalizar la respuesta.
    //Xej si el articulo no se encuentra, se puede devolver un 404 Not Found
    //Si se encuentra devuelve un 200 OK con el articulo
    
    //PathVariable se usa para extraer el ID del articulo de la URL
    public ResponseEntity<Articulo> obtenerPorId(@PathVariable Long id){
        //.map(ResponseEntity::ok) convierte el articulo encontrado en una respuesta 200 OK.
        //.OrElse(ResponseEntity.notFound().build()) devuelve 404 Not Found sino se encuentra el articulo
        //articuloService.obtenerArticuloPorId(id) busca el articulo por ID
        // y devuelve un Optional<Articulo>.
        //SI el articulo existe devuelve un responseEntity con el articulo y un codigo 200 OK
        //Sino existe devuelve un ResponseEntity con un codigo 404 Not Found
        //Esto permite manejar de manera elegante los casos en q el recurso no se encuentra, 
        //sin lanzar excepciones innecesarias
        //Esto es util para APIs REST, donde es comun q los recursos no existan.
        return articuloService.obtenerArticuloPorId(id)
            .map(ResponseEntity::ok)   //Devuelve 200  si lo encuentra
            .orElse(ResponseEntity.notFound().build());   //Devuelve 404 sino 

    }
    

}

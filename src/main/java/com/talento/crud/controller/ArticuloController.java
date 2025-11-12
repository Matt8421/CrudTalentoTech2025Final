//Paquete del controlador
package com.talento.crud.controller;

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
}

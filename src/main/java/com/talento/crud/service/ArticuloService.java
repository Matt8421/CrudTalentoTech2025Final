package com.talento.crud.service;


import com.talento.crud.model.Articulo;
import java.util.List;
import java.util.Optional;

//Interfaz que define el contrato del servicio
public interface ArticuloService {
    List<Articulo>listaArticulos();
    Optional<Articulo>obtenerArticulosPorId(Long id);
    Articulo guardArticulo(Articulo articulo);
    Articulo actualizarArticulo (Long id, Articulo articulo);
    void eliminarArticulo(Long id);
    

}

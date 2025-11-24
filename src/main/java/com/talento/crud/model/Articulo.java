package com.talento.crud.model;

import jakarta.annotation.Generated;
//Importa anotaciones de JPA para mapear la clase a la base de datos
import jakarta.persistence.*;

@Entity              //Indica que esta clase es una tabla en la base de datos(entidad JPA)

@Table(name= "articulo")        //Nombre de la tabla real en MySQL

public class Articulo {

    @Id                //Marca este campo como clave primaria
    @GeneratedValue(Strategy = GenerationType.IDENTITY)   //El ID se genera automaticamente ( AUTO_INCREMENT en MySQL)

    private Long id; 
    //Estos atributos van a ser columnas en la tabla "articulo"
    private String nombre;
    private Double precio;
    private String imagen;

    //Constructor vacio -> requerido por JPA
    public Articulo() {}

    //Constructor con parametros -> util al crear objetos manualmente
    public Articulo(Long id, String nombre, Double precio, String imagen){
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.imagen = imagen;
    }
    //   ------- GETTERS & SETTERS --------
    //Sirven para acceder y modificar los atributos
    public Long getId(){return id;}
    public void setId (Long id) { this.id = id;}

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public Double getPrecio(){return precio;}
    public void setPrecio(Double precio) { this.precio  = precio;}

    public String getImagen() {return imagen;}
    public void setImagen(String imagen) { this.imagen = imagen;}
}

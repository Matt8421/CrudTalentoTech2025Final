// -------------------------------------------------------------------------
// 📝 Archivo: EjemplosRelaciones.java
//
// IMPORTANTE:
// Esta clase NO forma parte del CRUD real del proyecto.
// Es SOLO educativo para entender relaciones JPA (OneToOne, ManyToMany, etc.)
//
// Para evitar errores de compilación en VS Code (porque no tengo JPA en pom.xml),
// se comenta TODO el contenido.
// -------------------------------------------------------------------------

package com.talento.crud.model;

/*
public class EjemplosRelaciones {
    
    // ------------------------------------------------------------
    // 🔵 OneToMany y ManyToOne (Relación bidireccional)
    // ------------------------------------------------------------
    //
    // Relación:
    //   ➤ Una CATEGORIA puede tener muchos ARTICULOS   → OneToMany
    //   ➤ Un ARTICULO pertenece a una CATEGORIA        → ManyToOne
    //
    // Explicación:
    // - "mappedBy" indica cuál entidad tiene la Foreign Key (FK)
    // - En este caso, ARTICULO tiene la FK "categoria_id"
    

    @jakarta.persistence.Entity
    @jakarta.persistence.Table(name = "categorias")
    public static class Categoria {

        @jakarta.persistence.Id
        @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
        private Long id;
        private String nombre;

        @jakarta.persistence.OneToMany(mappedBy = "categoria")
        // La FK está en Articulo (campo "categoria")
        private java.util.List<Articulo> articulos;

        // Getters y setters...
    }

    @jakarta.persistence.Entity
    @jakarta.persistence.Table(name = "articulos")
    public static class Articulo {

        @jakarta.persistence.Id
        @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
        private Long id;
        private String titulo;
        private String descripcion;

        // ManyToOne → un artículo pertenece a una categoría
        @jakarta.persistence.ManyToOne
        @jakarta.persistence.JoinColumn(name = "categoria_id", nullable = false)
        private Categoria categoria;

        // ---------------------------------------------------------
        // 🔵 OneToOne → un artículo tiene UNA imagen
        // ---------------------------------------------------------
        @jakarta.persistence.OneToOne(mappedBy = "articulo")
        // "mappedBy" → la FK está en IMAGEN
        private Imagen imagen;

        // ---------------------------------------------------------
        // 🔵 ManyToMany → muchos artículos con muchos proveedores
        // ---------------------------------------------------------
        @jakarta.persistence.ManyToMany
        @jakarta.persistence.JoinTable(
            name = "articulos_proveedores",
            joinColumns = @jakarta.persistence.JoinColumn(name = "articulo_id"),
            inverseJoinColumns = @jakarta.persistence.JoinColumn(name = "proveedor_id")
        )
        private java.util.List<Proveedor> proveedores;

        @jakarta.persistence.ManyToMany
        @jakarta.persistence.JoinTable(
            name = "articulos_etiquetas",
            joinColumns = @jakarta.persistence.JoinColumn(name = "articulo_id"),
            inverseJoinColumns = @jakarta.persistence.JoinColumn(name = "etiqueta_id")
        )
        private java.util.List<Etiqueta> etiquetas;

        // Getters y setters...
    }

    // ------------------------------------------------------------
    // 🔵 OneToOne (Relación 1 a 1)
    // ------------------------------------------------------------

    @jakarta.persistence.Entity
    @jakarta.persistence.Table(name = "imagenes")
    public static class Imagen {

        @jakarta.persistence.Id
        @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
        private Long id;
        private String url;

        @jakarta.persistence.OneToOne
        @jakarta.persistence.JoinColumn(name = "articulo_id")
        // Esta tabla tiene la Foreign Key
        private Articulo articulo;

        // Getters y setters...
    }

    // ------------------------------------------------------------
    // 🔵 ManyToMany (proveedores/artículos)
    // ------------------------------------------------------------

    @jakarta.persistence.Entity
    @jakarta.persistence.Table(name = "proveedores")
    public static class Proveedor {

        @jakarta.persistence.Id
        @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
        private Long id;
        private String nombre;

        @jakarta.persistence.ManyToMany(mappedBy = "proveedores")
        // Articulo es quien administra la relación
        private java.util.List<Articulo> articulos;

        // Getters y setters...
    }

    @jakarta.persistence.Entity
    @jakarta.persistence.Table(name = "etiquetas")
    public static class Etiqueta {

        @jakarta.persistence.Id
        @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
        private Long id;
        private String nombre;

        @jakarta.persistence.ManyToMany(mappedBy = "etiquetas")
        private java.util.List<Articulo> articulos;

        // Getters y setters...
    }

}
*/

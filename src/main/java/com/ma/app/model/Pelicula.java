package com.ma.app.model;

import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Pelicula {

    private int id;
    private String titulo;
    private int duracion;
    private String clasificacion;
    private String genero;
    private String imagen;
    private Date fechaEstreno;
    private String estatus;

    public Pelicula() {}

    public Pelicula(int id, String titulo, int duracion, String clasificacion, String genero, Date fechaEstreno) {
        this.id = id;
        this.titulo = titulo;
        this.duracion = duracion;
        this.clasificacion = clasificacion;
        this.genero = genero;
        this.fechaEstreno = fechaEstreno;
    }

    public static class Builder {
        private int id;
        private String titulo;
        private int duracion;
        private String clasificacion;
        private String genero;
        private String imagen = "cinema.png";
        private Date fechaEstreno;
        private String estatus = "Activa";

        public Builder id(int val) {
            id = val;
            return this;
        }

        public Builder titulo(String val) {
            titulo = val;
            return this;
        }

        public Builder duracion(int val) {
            duracion = val;
            return this;
        }

        public Builder clasificacion(String val) {
            clasificacion = val;
            return this;
        }

        public Builder genero(String val) {
            genero = val;
            return this;
        }

        public Builder imagen(String val) {
            imagen = val;
            return this;
        }

        public Builder fechaEstreno(Date val) {
            fechaEstreno = val;
            return this;
        }

        public Builder estatus(String val) {
            estatus = val;
            return this;
        }

        public Pelicula build() {
            return new Pelicula(this);
        }

    }

    private Pelicula(Builder builder) {
        id = builder.id;
        titulo = builder.titulo;
        duracion = builder.duracion;
        clasificacion = builder.clasificacion;
        genero = builder.genero;
        imagen = builder.imagen;
        fechaEstreno = builder.fechaEstreno;
        estatus = builder.estatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Date getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(Date fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, true);
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public String toString() {
        return "Pelicula [id=" + id + ", titulo=" + titulo + ", duracion=" + duracion + ", clasificacion="
                + clasificacion + ", genero=" + genero + ", imagen=" + imagen + ", fechaEstreno=" + fechaEstreno
                + ", estatus=" + estatus + "]";
    }

}

package com.ma.app.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Detalle {

    private int id;
    private String director;
    private String actores;
    private String sinopsis;
    private String trailer;

    public Detalle() {}

    public Detalle(int id, String director, String actores, String sinopsis, String trailer) {
        this.id = id;
        this.director = director;
        this.actores = actores;
        this.sinopsis = sinopsis;
        this.trailer = trailer;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    }
    public String getActores() {
        return actores;
    }
    public void setActores(String actores) {
        this.actores = actores;
    }
    public String getSinopsis() {
        return sinopsis;
    }
    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }
    public String getTrailer() {
        return trailer;
    }
    public void setTrailer(String trailer) {
        this.trailer = trailer;
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
        return "Detalle [director=" + director + ", actores=" + actores + ", sinopsis=" + sinopsis + ", trailer="
                + trailer + "]";
    }
}

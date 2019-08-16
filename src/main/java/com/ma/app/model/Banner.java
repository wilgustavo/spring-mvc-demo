package com.ma.app.model;

import java.util.Date;
import java.util.Objects;

public class Banner {

    public static final String ESTATUS_ACTIVO = "Activo";

    private int id;
    private String titulo;
    private Date fecha;
    private String archivo;
    private String estatus;

    public Banner() {
        this.fecha = new Date();
        this.estatus = ESTATUS_ACTIVO;
    }

    public Banner(int id, String titulo, Date fecha, String archivo, String estatus) {
        this.id = id;
        this.titulo = titulo;
        this.fecha = fecha;
        this.archivo = archivo;
        this.estatus = estatus;
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
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public String getArchivo() {
        return archivo;
    }
    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }
    public String getEstatus() {
        return estatus;
    }
    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
    @Override
    public int hashCode() {
        return Objects.hash(archivo, estatus, fecha, id, titulo);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Banner)) {
            return false;
        }
        Banner other = (Banner) obj;
        return Objects.equals(archivo, other.archivo) && Objects.equals(estatus, other.estatus)
                && Objects.equals(fecha, other.fecha) && id == other.id && Objects.equals(titulo, other.titulo);
    }
    @Override
    public String toString() {
        return "Bannner [id=" + id + ", titulo=" + titulo + ", fecha=" + fecha + ", archivo=" + archivo + ", estatus="
                + estatus + "]";
    }
}

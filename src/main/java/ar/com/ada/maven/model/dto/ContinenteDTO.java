package ar.com.ada.maven.model.dto;

import java.util.Objects;

public class ContinenteDTO {
    private int id;
    private String nombre;

    public ContinenteDTO() { }

    public ContinenteDTO(String nombre) {
        this.nombre = nombre;
    }

    public ContinenteDTO(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "ContinenteDTO { id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContinenteDTO that = (ContinenteDTO) o;
        return id == that.id &&
                nombre.equals(that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre);
    }
}




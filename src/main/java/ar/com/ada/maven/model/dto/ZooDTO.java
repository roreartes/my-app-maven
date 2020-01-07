package ar.com.ada.maven.model.dto;

import java.util.Objects;

public class ZooDTO {
    private int id;
    private String nombre;
    private int tamañom2;
    private int presupuesto;
    private CiudadDTO ciudadId;

    public ZooDTO() {
    }

    public ZooDTO(String nombre, int tamañom2, int presupuesto, CiudadDTO ciudadId) {
        this.nombre = nombre;
        this.tamañom2 = tamañom2;
        this.presupuesto = presupuesto;
        this.ciudadId = ciudadId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTamañom2() {
        return tamañom2;
    }

    public void setTamañom2(int tamañom2) {
        this.tamañom2 = tamañom2;
    }

    public int getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(int presupuesto) {
        this.presupuesto = presupuesto;
    }

    @Override
    public String toString() {
        return "ZooDTO{" +"id=" + id +", nombre='" + nombre + '\''
                + ", tamañom2=" + tamañom2 +
                ", presupuesto=" + presupuesto +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ZooDTO zooDTO = (ZooDTO) o;
        return id == zooDTO.id &&
                tamañom2 == zooDTO.tamañom2 &&
                presupuesto == zooDTO.presupuesto &&
                nombre.equals(zooDTO.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, tamañom2, presupuesto);
    }
}

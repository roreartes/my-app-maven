package ar.com.ada.maven.model.dto;

import java.util.Objects;

public class PaisDTO {

    private int id;
    private int iso_cod;
    private String nombre;
    // Continente_id
    private ContinenteDTO continenteDto;

    public PaisDTO() {
    }

    public PaisDTO(String nombre) {
        this.nombre = nombre;
    }

    public PaisDTO(int id, int iso_cod, String nombre, ContinenteDTO continenteDto) {
        this.id = id;
        this.iso_cod = iso_cod;
        this.nombre = nombre;
        this.continenteDto = continenteDto;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIso_cod() {
        return iso_cod;
    }

    public void setIso_cod(int iso_cod) {
        this.iso_cod = iso_cod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ContinenteDTO getContinenteDto() {
        return continenteDto;
    }

    public void setContinenteDto(ContinenteDTO continenteDto) {
        this.continenteDto = continenteDto;
    }

    @Override
    public String toString() {
        return "El país es " + id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaisDTO paisDTO = (PaisDTO) o;
        return id == paisDTO.id &&
                iso_cod == paisDTO.iso_cod &&
                Objects.equals(nombre, paisDTO.nombre) &&
                Objects.equals(continenteDto, paisDTO.continenteDto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, iso_cod, nombre, continenteDto);
    }
}


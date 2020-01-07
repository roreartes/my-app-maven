package ar.com.ada.maven.model.dto;

import java.util.Date;
import java.util.Objects;

public class AnimalDTO {
    private int id;
    private String sexo;
    private Date fecha_nacimiento;
    private AnimalDTO especieID;
    private AnimalDTO paisID;

    public AnimalDTO() {
    }

    public AnimalDTO(int id, String sexo, Date fecha_nacimiento, AnimalDTO especieID, AnimalDTO paisID) {
        this.id = id;
        this.sexo = sexo;
        this.fecha_nacimiento = fecha_nacimiento;
        this.especieID = especieID;
        this.paisID = paisID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public AnimalDTO getEspecieID() {
        return especieID;
    }

    public void setEspecieID(AnimalDTO especieID) {
        this.especieID = especieID;
    }

    public AnimalDTO getPaisID() {
        return paisID;
    }

    public void setPaisID(AnimalDTO paisID) {
        this.paisID = paisID;
    }

    @Override
    public String toString() {
        return "AnimalDTO{" + "id=" + id +", sexo='" + sexo + '\'' +
                ", fecha_nacimiento=" + fecha_nacimiento +
                ", especieID=" + especieID +
                ", paisID=" + paisID +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnimalDTO animalDTO = (AnimalDTO) o;
        return id == animalDTO.id &&
                especieID == animalDTO.especieID &&
                paisID == animalDTO.paisID &&
                Objects.equals(sexo, animalDTO.sexo) &&
                Objects.equals(fecha_nacimiento, animalDTO.fecha_nacimiento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sexo, fecha_nacimiento, especieID, paisID);
    }
}

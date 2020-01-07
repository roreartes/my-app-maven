package ar.com.ada.maven.model.dto;

import java.util.Objects;

public class EspecieDTO {
    private int id;
    private String nombreVulgar;
    private String nombreCientifico;
    private boolean extinto;
    private EspecieDTO familiaId;

    public EspecieDTO() {
    }

    public EspecieDTO(int id, String nombreVulgar, String nombreCientifico, boolean extinto, EspecieDTO familia_id) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreVulgar() {
        return nombreVulgar;
    }

    public void setNombreVulgar(String nombreVulgar) {
        this.nombreVulgar = nombreVulgar;
    }

    public String getNombreCientifico() {
        return nombreCientifico;
    }

    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    public boolean isExtinto() {
        return extinto;
    }

    public void setExtinto(boolean extinto) {
        this.extinto = extinto;
    }

    public EspecieDTO getFamiliaId() {
        return familiaId;
    }

    public void setFamiliaId(EspecieDTO familiaId) {
        this.familiaId = familiaId;
    }

    @Override
    public String toString() {
        return "EspecieDTO{" + "id=" + id +
                ", nombreVulgar='" + nombreVulgar + '\'' +
                ", nombreCientifico='" + nombreCientifico + '\'' +
                ", extinto=" + extinto +
                ", familiaId=" + familiaId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EspecieDTO that = (EspecieDTO) o;
        return id == that.id &&
                extinto == that.extinto &&
                nombreVulgar.equals(that.nombreVulgar) &&
                nombreCientifico.equals(that.nombreCientifico) &&
                familiaId.equals(that.familiaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombreVulgar, nombreCientifico, extinto, familiaId);
    }

    public String getNombre() {
    }
}

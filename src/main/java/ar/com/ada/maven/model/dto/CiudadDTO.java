package ar.com.ada.maven.model.dto;

public class CiudadDTO {
    private int id;
    private String nombre;
    private PaisDTO paisId;
    private ZooDTO zooId;

    public CiudadDTO() {    }

    public CiudadDTO(String nombre, PaisDTO paisId) {
        this.nombre = nombre;
        this.paisId = paisId;
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

    public PaisDTO getPaisId() {
        return paisId;
    }

    public void setPaisId(PaisDTO paisId) {
        this.paisId = paisId;
    }

    public ZooDTO getZooId() {
        return zooId;
    }

    public void setZooId(ZooDTO zooId) {
        this.zooId = zooId;
    }

    @Override
    public String toString() {
        return "La ciudad es " + id;
    }

    @Override

    public boolean equals(Object obj2) {
        if (this == obj2) return true;


        if (obj2 == null || this.getClass() != obj2.getClass()) {
            return false;
        }
        CiudadDTO that = (CiudadDTO) obj2;
        boolean tmp = this.nombre.equals(that.nombre);
        return tmp;

    }

}

package ar.com.ada.maven.model.dto;

import java.util.Objects;

public class AnimalxZoo {
    private int id;
    private ZooDTO zooId;
    private AnimalDTO animalId;

    public AnimalxZoo() {
    }

    public AnimalxZoo(int id, AnimalxZoo zooId, AnimalxZoo animalID) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ZooDTO getZooId() {
        return zooId;
    }

    public void setZooId(ZooDTO zooId) {
        this.zooId = zooId;
    }

    public AnimalDTO getAnimalId() {
        return animalId;
    }

    public void setAnimalId(AnimalDTO animalId) {
        this.animalId = animalId;
    }

    @Override
    public String toString() {
        return "AnimalxZoo{" +
                "id=" + id +
                ", zooId=" + zooId +
                ", animalId=" + animalId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnimalxZoo that = (AnimalxZoo) o;
        return id == that.id &&
                zooId.equals(that.zooId) &&
                animalId.equals(that.animalId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, zooId, animalId);
    }
}

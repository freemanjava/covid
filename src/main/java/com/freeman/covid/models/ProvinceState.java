package com.freeman.covid.models;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

//@Entity
@Document
public class ProvinceState {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name;

    public ProvinceState() {
    }

    public ProvinceState(String name) {
        this.name = name;
    }

    public ProvinceState(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProvinceState)) return false;
        ProvinceState that = (ProvinceState) o;
        return id.equals(that.id) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "ProvinceState{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

package org.example;

import javax.persistence.*;

@Entity
@Table(name = "pais")
public class Pais {
    private int id;
    private String nombre;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column (name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

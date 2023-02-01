package org.example;

import javax.persistence.*;
@Entity
@Table (name = "provincia")
public class Provincia {
    private int id;
    private String nombre;
    private int idPais;

    @Id
    @Column (name = "id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
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
    @Column(name = "idPais")
    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }
}



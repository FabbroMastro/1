package com.eriofabbri.meli.app.user.models;

import javax.persistence.*;
import java.io.Serializable;
/*En este archivo declaramos la entidad que se va a inizializar y crear la tabla donde se identfica nuestro target */

@Entity
@Table(name = "Users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;

    private Long target_id;

    public User() {

    }
    public User(Long target_id) {
        this.target_id = target_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Long getTarget_id() {
        return target_id;
    }

    public void setTarget_id(Long target_id) {
        this.target_id = target_id;
    }

    private static final long serialVersionUID = 1285454306356845809L;
}

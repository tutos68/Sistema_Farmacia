/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.farmacia.modelo;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

/**
 *
 * @author Adrian
 */
@Entity
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String contrasenia;
    private Rol rol;
    private Empleado empleado;
    private Administrador administrador;
    private Cliente cliente;
    @Transient
    private boolean editable;//se añade este atribtuo editable el cual me va a permitir 
    //activar o desactivar la tabla para que esten cajas de texto en formato input o output
    //Sin embargo este atributo no necesito guardarlo en la BD por ello pongo la anotacion Transient

    public Usuario() {
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public Usuario(int id, String contrasenia, Rol rol, Empleado empleado) {
        this.id = id;
        this.contrasenia = contrasenia;
        this.rol = rol;
        this.empleado = empleado;
    }

    public Usuario(int id, String contrasenia, Rol rol, Administrador administrador) {
        this.id = id;
        this.contrasenia = contrasenia;
        this.rol = rol;
        this.administrador = administrador;
    }

    public Usuario(int id, String contrasenia, Rol rol, Cliente cliente) {
        this.id = id;
        this.contrasenia = contrasenia;
        this.rol = rol;
        this.cliente = cliente;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", contrasenia=" + contrasenia + ", rol=" + rol + ", empleado=" + empleado + ", administrador=" + administrador + ", cliente=" + cliente + '}';
    }

    
    

    
}

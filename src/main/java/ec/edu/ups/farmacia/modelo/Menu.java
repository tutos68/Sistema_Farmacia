/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.farmacia.modelo;

import jakarta.persistence.Column;
import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.Objects;

/**
 *
 * @author edwin
 */
@Entity
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nombre;
    private String tipo;
     @Column(name = "tipo_usuario")
    private String tipoUsuario;
    private String url;
    @ManyToOne
    @JoinColumn(name = "codigo_submenu")
    private Menu codigo_submenu;
    private boolean estado;

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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Menu getCodigo_submenu() {
        return codigo_submenu;
    }

    public void setCodigo_submenu(Menu codigo_submenu) {
        this.codigo_submenu = codigo_submenu;
    }

    public Menu() {
    }

    public Menu(int id, String nombre, String tipo, String tipoUsuario, String url, Menu codigo_submenu) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.tipoUsuario = tipoUsuario;
        this.url = url;
        this.codigo_submenu = codigo_submenu;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Menu other = (Menu) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Menu{" + "id=" + id + ", nombre=" + nombre + ", tipo=" + tipo + ", tipoUsuario=" + tipoUsuario + ", url=" + url + ", codigo_submenu=" + codigo_submenu + ", estado=" + estado + '}';
    }

}

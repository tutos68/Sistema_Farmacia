/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.farmacia.modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

/**
 *
 * @author ASUS_GAMING
 */
@Entity
public class Proveedor extends Entidad implements Serializable {

    @Column(name = "sitio_web")
    private String sitioWeb;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "proveedor")
    private CabeceraCompra cabeceraCompra;

    public Proveedor() {
    }

    public Proveedor(String sitioWeb, int id, String identificador, String nombre, String correo, String direccion, String telefono) {
        super(id, identificador, nombre, correo, direccion, telefono);
        this.sitioWeb = sitioWeb;
    }

    public String getSitioWeb() {
        return sitioWeb;
    }

    public void setSitioWeb(String sitioWeb) {
        this.sitioWeb = sitioWeb;
    }

}

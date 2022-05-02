/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.farmacia.modelo;

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
    
    @OneToOne
    @JoinColumn(name = "categoria_id", nullable = false, referencedColumnName = "id")
    private Categoria categoria;

    public Proveedor() {
    }

    public Proveedor(Categoria categoria, int id, String identificador, String nombre, String correo, String direccion, String telefono) {
        super(id, identificador, nombre, correo, direccion, telefono);
        this.categoria = categoria;
    }
    
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.farmacia.modelo;

import jakarta.persistence.CascadeType;
import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author Adrian
 */
@Entity
@Table(name = "compra")
public class CabeceraCompra  extends FacturaCabecera implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cabeceraCompra")
    private List<Detalle> detalles;
    @OneToOne
    @JoinColumn
    private Proveedor proveedor;

    public CabeceraCompra() {
    }

    public CabeceraCompra(Proveedor proveedor, int id, GregorianCalendar fecha, double subtotal, double total, boolean estado) {
        super(id, fecha, subtotal, total, estado);
        this.proveedor = proveedor;
    }

    public List<Detalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<Detalle> detalles) {
        this.detalles = detalles;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
    
    
    
    
   
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.farmacia.modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Table;
import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import java.util.GregorianCalendar;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pcuser
 */
@Entity
@Table(name = "venta")
public class CabeceraVenta extends FacturaCabecera implements Serializable {
     
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cabeceraVenta")
    private List<Detalle> detalles;
    @OneToOne
    @JoinColumn
    private Cliente cliente;

    public CabeceraVenta(Cliente cliente, int id, GregorianCalendar fecha, double subtotal, double total, boolean estado) {
        super(id, fecha, subtotal, total, estado);
        this.cliente = cliente;
    }

    
    
    
    public CabeceraVenta(List<Detalle> detalles, int id, GregorianCalendar fecha, double subtotal, double total, boolean estado) {
        super(id, fecha, subtotal, total, estado);
        this.detalles = detalles;
    }

    public CabeceraVenta(int id, GregorianCalendar fecha, double subtotal, double total, boolean estado) {
        super(id, fecha, subtotal, total, estado);
        
        this.detalles = new ArrayList<>();
        
    }

    public CabeceraVenta(List<Detalle> detalles, Cliente cliente, int id, GregorianCalendar fecha, double subtotal, double total, boolean estado) {
        super(id, fecha, subtotal, total, estado);
        this.detalles = detalles;
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    
    
    public CabeceraVenta() {
    }
    
    public List<Detalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<Detalle> detalles) {
        this.detalles = detalles;
    }

    public void addDetalle(Detalle d){
        this.detalles.add(d);
    }
    
}

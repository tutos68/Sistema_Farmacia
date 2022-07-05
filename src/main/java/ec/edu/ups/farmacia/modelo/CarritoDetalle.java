/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.farmacia.modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author pcuser
 */
@Entity
@Table(name = "carrito_detalle")
public class CarritoDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @OneToOne
    @JoinColumn(name = "producto_sucursal")
    private ProductoSucursal productoSucursal;
    private int cantidad;
    private double precio;
    private double subtotal;
    @ManyToOne 
    @JoinColumn(name="carrito_cabecera")
    private CarritoCabecera carritoCabecera;
    public CarritoDetalle() {
    }

    public CarritoDetalle(ProductoSucursal productoSucursal, int cantidad, double precio, double subtotal) {
        this.productoSucursal = productoSucursal;
        this.cantidad = cantidad;
        this.precio = precio;
        this.subtotal = subtotal;
    }

    public CarritoCabecera getCarritoCabecera() {
        return carritoCabecera;
    }

    public void setCarritoCabecera(CarritoCabecera carritoCabecera) {
        this.carritoCabecera = carritoCabecera;
    }

    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   

    public ProductoSucursal getProductoSucursal() {
        return productoSucursal;
    }

    public void setProductoSucursal(ProductoSucursal productoSucursal) {
        this.productoSucursal = productoSucursal;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id;
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
        final CarritoDetalle other = (CarritoDetalle) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "CarritoDetalle{" + "id=" + id + ", productoSucursal=" + productoSucursal + ", cantidad=" + cantidad + ", precio=" + precio + ", subtotal=" + subtotal + '}';
    }
    
    

}

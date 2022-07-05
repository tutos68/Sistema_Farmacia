/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.farmacia.modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

/**
 *
 * @author Adrian
 */
@Entity
public class Detalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    @JoinColumn
    private ProductoSucursal productoSucursal;
    private int cantidad;
    private double precio;
    private double subtotal;
    @ManyToOne
    @JoinColumn(name = "cabecera_venta")
    private CabeceraVenta cabeceraVenta;
    @ManyToOne
    @JoinColumn(name = "cabecera_compra")
    private CabeceraCompra cabeceraCompra;
    @OneToOne(cascade =CascadeType.ALL ,mappedBy ="detalle" )
    private Kardex kardex;

    public Detalle() {
    }

    public Detalle(ProductoSucursal productoSucursal, int cantidad, double precio, double subtotal, CabeceraVenta cabeceraVenta) {
        this.productoSucursal = productoSucursal;
        this.cantidad = cantidad;
        this.precio = precio;
        this.subtotal = subtotal;
        this.cabeceraVenta = cabeceraVenta;
    }

    public Detalle(ProductoSucursal productoSucursal, int cantidad, double precio, double subtotal, CabeceraCompra cabeceraCompra) {
        this.productoSucursal = productoSucursal;
        this.cantidad = cantidad;
        this.precio = precio;
        this.subtotal = subtotal;
        this.cabeceraCompra = cabeceraCompra;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CabeceraVenta getCabeceraVenta() {
        return cabeceraVenta;
    }

    public void setCabeceraVenta(CabeceraVenta cabeceraVenta) {
        this.cabeceraVenta = cabeceraVenta;
    }

    public CabeceraCompra getCabeceraCompra() {
        return cabeceraCompra;
    }

    public void setCabeceraCompra(CabeceraCompra cabeceraCompra) {
        this.cabeceraCompra = cabeceraCompra;
    }

    public Kardex getKardex() {
        return kardex;
    }

    public void setKardex(Kardex kardex) {
        this.kardex = kardex;
    }

    public ProductoSucursal getProductoSucursal() {
        return productoSucursal;
    }

    public void setProductoSucursal(ProductoSucursal productoSucursal) {
        this.productoSucursal = productoSucursal;
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
        if (!(object instanceof Detalle)) {
            return false;
        }
        Detalle other = (Detalle) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    

}

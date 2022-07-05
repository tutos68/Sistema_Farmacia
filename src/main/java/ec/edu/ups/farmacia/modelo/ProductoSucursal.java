/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.farmacia.modelo;

import jakarta.persistence.OneToOne;
import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

/**
 *
 * @author pcuser
 */
@Entity
@Table(name = "producto_sucursal")
public class ProductoSucursal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    @JoinColumn
    private Sucursal sucursal;
    @OneToOne
    @JoinColumn
    private Producto producto;
    private int stock;

    public ProductoSucursal() {
    }

    public ProductoSucursal(Sucursal sucursal, Producto producto, int stock) {
        this.sucursal = sucursal;
        this.producto = producto;
        this.stock = stock;
    }

    public ProductoSucursal(int id, Sucursal sucursal, Producto producto, int stock) {
        this.id = id;
        this.sucursal = sucursal;
        this.producto = producto;
        this.stock = stock;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
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
        if (!(object instanceof ProductoSucursal)) {
            return false;
        }
        ProductoSucursal other = (ProductoSucursal) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.ups.farmacia.modelo.NewEntity[ id=" + id + " ]";
    }
    
}

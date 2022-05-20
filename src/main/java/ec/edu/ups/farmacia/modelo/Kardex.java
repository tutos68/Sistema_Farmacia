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

/**
 *
 * @author Adrian
 */
@Entity
public class Kardex implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private CabeceraCompra compra;
    private CabeceraVenta venta;
    private double PrecioPonderado;

    public Kardex() {
    }

    public Kardex(int id, CabeceraCompra compra, CabeceraVenta venta, double PrecioPonderado) {
        this.id = id;
        this.compra = compra;
        this.venta = venta;
        this.PrecioPonderado = PrecioPonderado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CabeceraCompra getCompra() {
        return compra;
    }

    public void setCompra(CabeceraCompra compra) {
        this.compra = compra;
    }

    public CabeceraVenta getVenta() {
        return venta;
    }

    public void setVenta(CabeceraVenta venta) {
        this.venta = venta;
    }

    public double getPrecioPonderado() {
        return PrecioPonderado;
    }

    public void setPrecioPonderado(double PrecioPonderado) {
        this.PrecioPonderado = PrecioPonderado;
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
        if (!(object instanceof Kardex)) {
            return false;
        }
        Kardex other = (Kardex) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Kardex{" + "id=" + id + ", compra=" + compra + ", venta=" + venta + ", PrecioPonderado=" + PrecioPonderado + '}';
    }

 
}

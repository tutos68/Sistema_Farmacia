/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.farmacia.modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToOne;
import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

/**
 *
 * @author pcuser
 */
@Entity
@Table(name = "carrito_cabecera")
public class CarritoCabecera implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @OneToOne
    @JoinColumn
    private Usuario usuario;
    
    private double subtotal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carritoCabecera")
    private List<CarritoDetalle> listaDetalle;

    public CarritoCabecera() {
    }

    
    
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

   
    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    public List<CarritoDetalle> getListaDetalle() {
        return listaDetalle;
    }

    public void setListaDetalle(List<CarritoDetalle> listaDetalle) {
        this.listaDetalle = listaDetalle;
    }

  
  
}

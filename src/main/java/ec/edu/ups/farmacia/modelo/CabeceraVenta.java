/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.farmacia.modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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
    @OneToOne
    @JoinColumn
    private Usuario usuario;
    private String identificador;
    private String nombre;
    private String apellido;
    @Column(name = "correo")
    private String correo;
    private String direccion;
    private String telefono;

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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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

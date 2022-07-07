/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.farmacia.modelo;

import jakarta.persistence.Column;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

/**
 *
 * @author Adrian
 */
@Entity
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    @JoinColumn
    private Usuario usuario;
    private double latitud;
    private double longitud;
    @Enumerated
    private EstadoPedido estado;
    @Column(name = "tiempo_espera")
    private Date tiempoEspera;
    @Column(name = "costo_envio")
    private double costoEnvio;
    @OneToMany
    @JoinColumn(name="pedido_detalle")
    private List<PedidoDetalle> detalles;
    @OneToOne
    @JoinColumn(name="forma_pago_id")
    private FormaPago formaPago;
    private String identificador;
    private String nombre;
    private String apellido;
    @Column(name = "correo")
    private String correo;
    private String direccion;
    private String telefono;
    
    private  double total;

    public Pedido() {
    }

    public Pedido(int id, Usuario usuario, double latitud, double longitud, EstadoPedido estado, Date tiempoEspera, double costoEnvio, List<PedidoDetalle> detalles, FormaPago formaPago) {
        this.id = id;
        this.usuario = usuario;
        this.latitud = latitud;
        this.longitud = longitud;
        this.estado = estado;
        this.tiempoEspera = tiempoEspera;
        this.costoEnvio = costoEnvio;
        this.detalles = detalles;
        this.formaPago = formaPago;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
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

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

  
    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public Date getTiempoEspera() {
        return tiempoEspera;
    }

    public void setTiempoEspera(Date tiempoEspera) {
        this.tiempoEspera = tiempoEspera;
    }

    public double getCostoEnvio() {
        return costoEnvio;
    }

    public void setCostoEnvio(double costoEnvio) {
        this.costoEnvio = costoEnvio;
    }

    public List<PedidoDetalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<PedidoDetalle> detalles) {
        this.detalles = detalles;
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

    

    

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.id;
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
        final Pedido other = (Pedido) obj;
        return this.id == other.id;
    }

   
}

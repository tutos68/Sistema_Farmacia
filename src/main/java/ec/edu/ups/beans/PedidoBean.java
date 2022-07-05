/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.beans;

import ec.edu.ups.farmacia.controlador.PedidoFacade;
import ec.edu.ups.farmacia.modelo.Entidad;
import ec.edu.ups.farmacia.modelo.EstadoPedido;
import ec.edu.ups.farmacia.modelo.FormaPago;
import ec.edu.ups.farmacia.modelo.Pedido;
import ec.edu.ups.farmacia.modelo.PedidoDetalle;
import ec.edu.ups.farmacia.modelo.Usuario;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Adrian
 */
@Named
@SessionScoped
public class PedidoBean implements Serializable {

    private static final long serialVersionUID = 1L;
    @EJB
    private PedidoFacade pedidoFacade;
    private List<Pedido> listaPedidos = new ArrayList<>();
    private int id;
    private Usuario usuario;
    private double latitud;
    private double longitud;
    private EstadoPedido estado;
    private Date tiempoEspera;
    private double costoEnvio;
    private List<PedidoDetalle> detalles;
    private FormaPago formaPago;
    private Entidad entidad;

    @PostConstruct
    public void init() {
        listaPedidos = pedidoFacade.findAll();
    }

    public String add() {
        pedidoFacade.create(new Pedido(id, usuario, latitud, longitud, estado, tiempoEspera, costoEnvio, detalles, formaPago));
        listaPedidos = pedidoFacade.findAll();
        return null;
    }

    public String delete(Pedido p) {
        pedidoFacade.remove(p);
        listaPedidos = pedidoFacade.findAll();
        return null;
    }
    
    public void edit(Pedido p){
        pedidoFacade.edit(p);
        listaPedidos=pedidoFacade.findAll();
    }
    
    public String save(Pedido p){
        pedidoFacade.edit(p);
        listaPedidos = pedidoFacade.findAll();
        return null;
        
    }

    public PedidoFacade getPedidoFacade() {
        return pedidoFacade;
    }

    public void setPedidoFacade(PedidoFacade pedidoFacade) {
        this.pedidoFacade = pedidoFacade;
    }

    public List<Pedido> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(List<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
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

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    public Entidad getEntidad() {
        return entidad;
    }

    public void setEntidad(Entidad entidad) {
        this.entidad = entidad;
    }
    

}

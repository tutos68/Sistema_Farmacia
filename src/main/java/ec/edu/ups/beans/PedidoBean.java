/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.beans;

import ec.edu.ups.farmacia.controlador.PedidoFacade;
import ec.edu.ups.farmacia.controlador.PedidoDetalleFacade;
import ec.edu.ups.farmacia.controlador.FacturaVentaFacade;
import ec.edu.ups.farmacia.controlador.DetalleFacade;
import ec.edu.ups.farmacia.controlador.ProductoSucursalFacade;

import ec.edu.ups.farmacia.modelo.CabeceraVenta;
import ec.edu.ups.farmacia.modelo.Detalle;
import ec.edu.ups.farmacia.modelo.Entidad;
import ec.edu.ups.farmacia.modelo.EstadoPedido;
import ec.edu.ups.farmacia.modelo.FormaPago;
import ec.edu.ups.farmacia.modelo.Kardex;
import ec.edu.ups.farmacia.modelo.Pedido;
import ec.edu.ups.farmacia.modelo.PedidoDetalle;
import ec.edu.ups.farmacia.modelo.ProductoSucursal;
import ec.edu.ups.farmacia.modelo.Usuario;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
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
    @EJB
    private FacturaVentaFacade facturaVentaFacade;
    @EJB
    private DetalleFacade detalleFacade;
    @EJB
    private PedidoDetalleFacade pedidoDetalleFacade;
    @EJB
    private ProductoSucursalFacade productoSucursalFacade;
    
    private List<Pedido> listaPedidos = new ArrayList<>();
    private List<PedidoDetalle> listaPedidosDetalles = new ArrayList<>();
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
        listaPedidosDetalles= pedidoDetalleFacade.findAll();
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
    
    public void aceptar(Pedido p){
        p.setEstado(EstadoPedido.ACEPTADO);
        pedidoFacade.edit(p);
        listaPedidos=pedidoFacade.findAll();
    }
    
     public void cancelar(Pedido p){
        p.setEstado(EstadoPedido.CANCELADO);
        pedidoFacade.edit(p);
        listaPedidos=pedidoFacade.findAll();
    }
     
       public void finalizar(Pedido p){
        p.setEstado(EstadoPedido.FINALIZADO);
        pedidoFacade.edit(p);
        generarFactura(p);
        listaPedidos=pedidoFacade.findAll();
    }
       
       
    public  void  generarFactura(Pedido p){
        CabeceraVenta cabeceraVenta = new CabeceraVenta();
        cabeceraVenta.setApellido(p.getApellido());
        cabeceraVenta.setUsuario(p.getUsuario());
        cabeceraVenta.setCorreo(p.getCorreo());
        cabeceraVenta.setDireccion(p.getDireccion());
        cabeceraVenta.setEstado(true);
        cabeceraVenta.setFecha(new GregorianCalendar());
        cabeceraVenta.setIdentificador(p.getIdentificador());
        cabeceraVenta.setSubtotal(p.getTotal());
        cabeceraVenta.setTelefono(p.getTelefono());
        cabeceraVenta.setTotal(p.getCostoEnvio()+p.getTotal());
        facturaVentaFacade.create(cabeceraVenta);
        List<Detalle> list= new ArrayList<>();
        for (PedidoDetalle pedidoDetalle : listaPedidosDetalles) {
            if (pedidoDetalle.getPedido().equals(p)) {
                  Detalle d = new Detalle(pedidoDetalle.getProductoSucursal(), pedidoDetalle.getCantidad(), pedidoDetalle.getPrecio(), pedidoDetalle.getSubtotal(), cabeceraVenta);
                ProductoSucursal productoSucursal = pedidoDetalle.getProductoSucursal();
                  productoSucursal.setStock(productoSucursal.getStock()-pedidoDetalle.getCantidad());
                  productoSucursalFacade.edit(productoSucursal);
            list.add(d);
            }
            
          
            
        }

       
        for (Detalle detalle : list) {
            // detalleFacade.create(new Detalle(id, detalle.getProducto(), detalle.getCantidad(), detalle.getProducto().getPrecio(), detalle.getSubtotal(), cabeceraVenta));
            detalleFacade.create(detalle);
            detalle.setCabeceraVenta(cabeceraVenta);
            detalleFacade.edit(detalle);

          //  kardexFacade.create(new Kardex(id, detalle, "+", detalle.getSubtotal() + calcularTotalKardex()));
        }
        cabeceraVenta.setDetalles(list);
        facturaVentaFacade.edit(cabeceraVenta);
        list = new ArrayList<>();
//        actualizarStock(cabeceraVenta);
        
        
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

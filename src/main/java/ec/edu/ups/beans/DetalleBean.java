/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.beans;

import ec.edu.ups.farmacia.controlador.DetalleFacade;
import ec.edu.ups.farmacia.modelo.CabeceraVenta;
import ec.edu.ups.farmacia.controlador.ProductoFacade;
import ec.edu.ups.farmacia.modelo.Producto;
import ec.edu.ups.farmacia.controlador.ClienteFacade;
import ec.edu.ups.farmacia.modelo.Cliente;
import ec.edu.ups.farmacia.controlador.FacturaVentaFacade;
import ec.edu.ups.farmacia.modelo.CabeceraVenta;
import ec.edu.ups.farmacia.modelo.Detalle;
import ec.edu.ups.farmacia.modelo.Producto;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 *
 * @author pcuser
 */
@Named
@SessionScoped
public class DetalleBean implements Serializable {

    private static final long serialVersionUID = 1L;
    @EJB
    private DetalleFacade detalleFacade;
    @EJB
    private ProductoFacade productoFacade;
    @EJB
    private FacturaVentaFacade facturaVentaFacade;
    @EJB
    private ClienteFacade clienteFacade;
    
    //Inicializamos las listas
    private List<Detalle> list = new ArrayList<>();
    private List<Producto> listaProductos = new ArrayList<>();
    private List<Cliente> listaClientes = new ArrayList<>();
    private int id;
    private int idProducto;
    private Producto producto;
    private int cantidad;
    private double precio;
    private double subtotal;
    private CabeceraVenta cabeceraVenta;
    private double total=0;
    private Cliente cliente;
    private String cedula;
    private String mensaje="";
    private String datosCliente="";
    private String autocompletado;
    private GregorianCalendar g;

    @PostConstruct
    public void init() {
        list = new ArrayList<>();
        listaProductos = productoFacade.findAll();
        listaClientes= clienteFacade.findAll();
        
    }

    public String add() {
        Producto p = new Producto(1, "producto", 1, 2.3, null, null, null);
        productoFacade.create(p);
        producto=p;
        // this.precio=p.getPrecio();
        //this.idProducto=p.getId();
        //this.subtotal=(cantidad * p.getPrecio());
        //  productoFacade.create(p);
        list.add(new Detalle(1, p, cantidad, p.getPrecio(), (cantidad * p.getPrecio())));
        // Detalle d= new  Detalle(1, p, cantidad, p.getPrecio(), (cantidad * p.getPrecio()));
        //detalleFacade.create(new Detalle(id, producto, cantidad, precio, subtotal));
        //list = detalleFacade.findAll();//llamo al findall para que se me actualice la lista
        this.limpiar();
        // detalleFacade.create(d);
        //cabeceraVenta= new CabeceraVenta( null, id, null, subtotal, subtotal, true);
        //cabeceraVenta.addDetalle(d);
        // facturaVentaFacade.create(cabeceraVenta);

        return null;
    }

    public void edit(Detalle s) {

        for (Detalle detalle : list) {
            if (s.equals(detalle)) {
                list.set(0, detalle);
            }
        }
    }

    public String delete(Detalle s) {
        list.remove(s);
// detalleFacade.remove(s);
        //list = detalleFacade.findAll();//llamo al findall para que se me actualice la lista
        return null;
    }

    public String save(Detalle s) {
        int c = 0;
        for (Detalle detalle : list) {
            if (s.equals(detalle)) {
                list.set(id - 1, detalle);
            }
        }
        // detalleFacade.edit(s);
        //list = detalleFacade.findAll();//actualizo la lista
        //   s.setEditable(false);//desabilita la caja
        return null;
    }

    public void limpiar() {
        this.cantidad = 0;
        this.precio = 0.0;

    }

    public List<Detalle> getList() {
        return list;
    }

    public Detalle[] getList1() {//este metodo tambien se lo modifica
        return list.toArray(new Detalle[0]);// Lo que necesita el JSF dentro del table es un
    }                                        //un arreglo de usuarios        

    public List<String> sucursalNombre() {
        List<String> listaNombres = new ArrayList<>();
        String n;
        for (Detalle s : list) {
            n = s.toString();
            listaNombres.add(n);
        }
        return listaNombres;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DetalleFacade getDetalleFacade() {
        return detalleFacade;
    }

    public void setDetalleFacade(DetalleFacade detalleFacade) {
        this.detalleFacade = detalleFacade;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
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

    public CabeceraVenta getCabeceraVenta() {
        return cabeceraVenta;
    }

    public void setCabeceraVenta(CabeceraVenta cabeceraVenta) {
        this.cabeceraVenta = cabeceraVenta;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public ProductoFacade getProductoFacade() {
        return productoFacade;
    }

    public void setProductoFacade(ProductoFacade productoFacade) {
        this.productoFacade = productoFacade;
    }

    public FacturaVentaFacade getFacturaVentaFacade() {
        return facturaVentaFacade;
    }

    public void setFacturaVentaFacade(FacturaVentaFacade facturaVentaFacade) {
        this.facturaVentaFacade = facturaVentaFacade;
    }

    public ClienteFacade getClienteFacade() {
        return clienteFacade;
    }

    public void setClienteFacade(ClienteFacade clienteFacade) {
        this.clienteFacade = clienteFacade;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public double getTotal() {
        this.total=0;
        for (Detalle detalle : list) {
            total=total+detalle.getSubtotal();
        }
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String clienteBusqueda(){
        mensaje="";
        for (Cliente cliente : listaClientes) {
            if (this.cedula.equals(cliente.getIdentificador())){
                mensaje="Cliente Encontrado";
                datosCliente=cliente.toString();
                this.cliente=cliente;
            }
            
        }
        return null;
    }
    
    
    public String guardarFactura(){
        //GregorianCalendar calendar= new GregorianCalendar();
        //System.out.println(calendar.getTime());
        
        //Calendar c1 = GregorianCalendar.getInstance();

        //System.out.println("Fecha actual: "+c1.getTime().toLocaleString());
        CabeceraVenta cabeceraVenta=new CabeceraVenta(cliente,id, new GregorianCalendar(), subtotal, total, true);
        facturaVentaFacade.create(cabeceraVenta);
        
        for (Detalle detalle : list) {
            detalleFacade.create(new Detalle(id, detalle.getProducto(), detalle.getCantidad(), detalle.getProducto().getPrecio(), detalle.getSubtotal(), cabeceraVenta));
           
        }
        cabeceraVenta.setDetalles(list);
        facturaVentaFacade.edit(cabeceraVenta);
        list= new ArrayList<>();
        
        System.out.println("=========================================");
      
        System.out.println("fecha="+cabeceraVenta.getFecha().toString());
        System.out.println("=========================================");
        return null;
    }
    public GregorianCalendar mostrarFecha(){
        return new GregorianCalendar();
    }

    public GregorianCalendar getG() {
        return new GregorianCalendar();
    }

    public void setG(GregorianCalendar g) {
        this.g = g;
    }

    public String getDatosCliente() {
        return datosCliente;
    }

    public void setDatosCliente(String datosCliente) {
        this.datosCliente = datosCliente;
    }
    
    
    
    
     public List<String> completeText(String query) {
        String queryLowerCase = query.toLowerCase();
        List<String> countryList = new ArrayList<>();
        List<Producto> producto =productoFacade.findAll();
        for (Producto country : producto) {
            countryList.add(country.getNombreProducto());
        }

        return countryList.stream().filter(t -> t.toLowerCase().startsWith(queryLowerCase)).collect(Collectors.toList());
    }

    public String getAutocompletado() {
        return autocompletado;
    }

    public void setAutocompletado(String autocompletado) {
        this.autocompletado = autocompletado;
    }
     
     
    
}

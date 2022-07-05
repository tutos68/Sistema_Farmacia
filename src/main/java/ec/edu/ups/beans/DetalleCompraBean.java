/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.beans;
import ec.edu.ups.farmacia.controlador.DetalleFacade;
import ec.edu.ups.farmacia.modelo.CabeceraCompra;
import ec.edu.ups.farmacia.controlador.ProductoFacade;
import ec.edu.ups.farmacia.modelo.Producto;
import ec.edu.ups.farmacia.controlador.ProveedorFacade;
import ec.edu.ups.farmacia.modelo.Proveedor;
import ec.edu.ups.farmacia.controlador.CabeceraCompraFacade;
import ec.edu.ups.farmacia.modelo.Detalle;
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
public class DetalleCompraBean implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @EJB
    private DetalleFacade detalleFacade;
    @EJB
    private ProductoFacade productoFacade;
    @EJB
    private CabeceraCompraFacade facturaVentaFacade;
    @EJB
    private ProveedorFacade clienteFacade;
    
    //Inicializamos las listas
    private List<Detalle> list = new ArrayList<>();
    private List<Producto> listaProductos = new ArrayList<>();
    private List<Proveedor> listaClientes = new ArrayList<>();
    private int id;
    private int idProducto;
    private Producto producto;
    private int cantidad;
    private double precio;
    private double subtotal;
    private CabeceraCompra cabeceraVenta;
    private double total=0;
    private Proveedor cliente;
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

//    public String add() {
//       // Producto p = new Producto(1, "producto", 1, 2.3, null, null, null);
//       // productoFacade.create(p);
//        //producto=p;
//        for (Producto producto1 : listaProductos) {
//            if(producto1.getNombre().equals(autocompletado)){
//                this.producto=producto1;
//            }
//        }
//        list.add(new Detalle(1, producto, cantidad, producto.getPrecio(), (cantidad * producto.getPrecio())));
//        this.limpiar();
//        return null;
//    }
//
//    public void edit(Detalle s) {
//
//        for (Detalle detalle : list) {
//            if (s.equals(detalle)) {
//                list.set(0, detalle);
//            }
//        }
//    }
//
//    public String delete(Detalle s) {
//        list.remove(s);
//        return null;
//    }
//
//    public String save(Detalle s) {
//        int c = 0;
//        for (Detalle detalle : list) {
//            if (s.equals(detalle)) {
//                Detalle d = new Detalle(detalle.getId(), detalle.getProducto(), detalle.getCantidad(), detalle.getPrecio(), detalle.getCantidad()*detalle.getPrecio());
//                list.set(id - 1, detalle);
//            }
//        }
//        
//        return null;
//    }
//
//    public void limpiar() {
//        this.cantidad = 0;
//        this.precio = 0.0;
//
//    }
//
//    public List<Detalle> getList() {
//        return list;
//    }
//
//    public Detalle[] getList1() {//este metodo tambien se lo modifica
//        return list.toArray(new Detalle[0]);// Lo que necesita el JSF dentro del table es un
//    }                                        //un arreglo de usuarios        
//
//    public List<String> sucursalNombre() {
//        List<String> listaNombres = new ArrayList<>();
//        String n;
//        for (Detalle s : list) {
//            n = s.toString();
//            listaNombres.add(n);
//        }
//        return listaNombres;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public DetalleFacade getDetalleFacade() {
//        return detalleFacade;
//    }
//
//    public void setDetalleFacade(DetalleFacade detalleFacade) {
//        this.detalleFacade = detalleFacade;
//    }
//
//    public Producto getProducto() {
//        return producto;
//    }
//
//    public void setProducto(Producto producto) {
//        this.producto = producto;
//    }
//
//    public int getCantidad() {
//        return cantidad;
//    }
//
//    public void setCantidad(int cantidad) {
//        this.cantidad = cantidad;
//    }
//
//    public double getPrecio() {
//        return precio;
//    }
//
//    public void setPrecio(double precio) {
//        this.precio = precio;
//    }
//
//    public double getSubtotal() {
//        return subtotal;
//    }
//
//    public void setSubtotal(double subtotal) {
//        this.subtotal = subtotal;
//    }
//
//    public CabeceraCompra getCabeceraVenta() {
//        return cabeceraVenta;
//    }
//
//    public void setCabeceraVenta(CabeceraCompra cabeceraVenta) {
//        this.cabeceraVenta = cabeceraVenta;
//    }
//
//    public int getIdProducto() {
//        return idProducto;
//    }
//
//    public void setIdProducto(int idProducto) {
//        this.idProducto = idProducto;
//    }
//
//    public ProductoFacade getProductoFacade() {
//        return productoFacade;
//    }
//
//    public void setProductoFacade(ProductoFacade productoFacade) {
//        this.productoFacade = productoFacade;
//    }
//
//    public CabeceraCompraFacade getFacturaVentaFacade() {
//        return facturaVentaFacade;
//    }
//
//    public void setFacturaVentaFacade(CabeceraCompraFacade facturaVentaFacade) {
//        this.facturaVentaFacade = facturaVentaFacade;
//    }
//
//    public ProveedorFacade getClienteFacade() {
//        return clienteFacade;
//    }
//
//    public void setClienteFacade(ProveedorFacade clienteFacade) {
//        this.clienteFacade = clienteFacade;
//    }
//
//    public List<Producto> getListaProductos() {
//        return listaProductos;
//    }
//
//    public void setListaProductos(List<Producto> listaProductos) {
//        this.listaProductos = listaProductos;
//    }
//
//    public double getTotal() {
//        this.total=0;
//        for (Detalle detalle : list) {
//            total=total+detalle.getSubtotal();
//        }
//        return total;
//    }
//
//    public void setTotal(double total) {
//        this.total = total;
//    }
//
//    public List<Proveedor> getListaClientes() {
//        return listaClientes;
//    }
//
//    public void setListaClientes(List<Proveedor> listaClientes) {
//        this.listaClientes = listaClientes;
//    }
//
//    public Proveedor getCliente() {
//        return cliente;
//    }
//
//    public void setCliente(Proveedor cliente) {
//        this.cliente = cliente;
//    }
//
//    public String getCedula() {
//        return cedula;
//    }
//
//    public void setCedula(String cedula) {
//        this.cedula = cedula;
//    }
//
//    public String getMensaje() {
//        return mensaje;
//    }
//
//    public void setMensaje(String mensaje) {
//        this.mensaje = mensaje;
//    }
//
//    public String clienteBusqueda(){
//        mensaje="";
//        for (Proveedor Proveedor : listaClientes) {
//            if (this.cedula.equals(cliente.getIdentificador())){
//                mensaje="Cliente Encontrado";
//                datosCliente=cliente.toString();
//                this.cliente=cliente;
//            }
//            
//        }
//        return null;
//    }
//    
//    
//    public String guardarFactura(){
//        CabeceraCompra cabeceraCompra=new CabeceraCompra(cliente,id, new GregorianCalendar(), subtotal, total, true);
//        facturaVentaFacade.create(cabeceraCompra);
//        
//        for (Detalle detalle : list) {
////            detalleFacade.create(new Detalle(id, detalle.getProducto(), detalle.getCantidad(), detalle.getProducto().getPrecio(), detalle.getSubtotal(), cabeceraCompra));
//           
//        }
//        cabeceraCompra.setDetalles(list);
//        facturaVentaFacade.edit(cabeceraCompra);
//        list= new ArrayList<>();
//        actualizarStock(cabeceraCompra);
//        System.out.println("=========================================");
//      
//        System.out.println("fecha="+cabeceraCompra.getFecha().toString());
//        System.out.println("=========================================");
//        return null;
//    }
//    
//    
//    public void actualizarStock(CabeceraCompra cabeceraVenta){
//        for (Detalle detalle : cabeceraVenta.getDetalles()) {
//            producto=detalle.getProducto();
////            producto.setStock(producto.getStock()+detalle.getCantidad());
//            productoFacade.edit(producto);
//        }
//    }
//    public GregorianCalendar mostrarFecha(){
//        return new GregorianCalendar();
//    }
//
//    public GregorianCalendar getG() {
//        return new GregorianCalendar();
//    }
//
//    public void setG(GregorianCalendar g) {
//        this.g = g;
//    }
//
//    public String getDatosCliente() {
//        return datosCliente;
//    }
//
//    public void setDatosCliente(String datosCliente) {
//        this.datosCliente = datosCliente;
//    }
//    
//    
//    
//    
//     public List<String> completeText(String query) {
//        String queryLowerCase = query.toLowerCase();
//        List<String> countryList = new ArrayList<>();
//        List<Producto> producto =productoFacade.findAll();
//        for (Producto country : producto) {
//            countryList.add(country.getNombre());
//        }
//
//        return countryList.stream().filter(t -> t.toLowerCase().startsWith(queryLowerCase)).collect(Collectors.toList());
//    }
//
//    public String getAutocompletado() {
//        return autocompletado;
//    }
//
//    public void setAutocompletado(String autocompletado) {
//        this.autocompletado = autocompletado;
//    }
//     
    
}

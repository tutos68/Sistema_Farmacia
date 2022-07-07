/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.beans;

import ec.edu.ups.farmacia.controlador.CabeceraVentaFacade;
import ec.edu.ups.farmacia.controlador.DetalleFacade;
import ec.edu.ups.farmacia.controlador.ProductoSucursalFacade;
import ec.edu.ups.farmacia.controlador.ClienteFacade;
import ec.edu.ups.farmacia.modelo.Cliente;
import ec.edu.ups.farmacia.controlador.FacturaVentaFacade;
import ec.edu.ups.farmacia.controlador.KardexFacade;
import ec.edu.ups.farmacia.modelo.CabeceraVenta;
import ec.edu.ups.farmacia.modelo.Detalle;
import ec.edu.ups.farmacia.modelo.Kardex;
import ec.edu.ups.farmacia.modelo.ProductoSucursal;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author pcuser
 */
@Named
@SessionScoped
public class DetalleVentaBean implements Serializable {

    private static final long serialVersionUID = 1L;
    @EJB
    private DetalleFacade detalleFacade;
    @EJB
    private ProductoSucursalFacade productoFacade;
    @EJB
    private FacturaVentaFacade facturaVentaFacade;
    @EJB
    private ClienteFacade clienteFacade;
    @EJB
    private KardexFacade kardexFacade;
    @EJB
    private CabeceraVentaFacade ventaFacade;//mando mi fachada

    //Inicializamos las listas
    private List<Detalle> list = new ArrayList<>();
    private List<ProductoSucursal> listaProductos = new ArrayList<>();
    private List<Cliente> listaClientes = new ArrayList<>();
    private List<Kardex> listaKardex = new ArrayList<>();
    private List<CabeceraVenta> listCabecera = new ArrayList<>();
    private int id;
    private int idProducto;
    private ProductoSucursal producto;
    private int cantidad;
    private double precio;
    private double subtotal;
    private CabeceraVenta cabeceraVenta;
    private double total = 0;
    private Cliente cliente;
    private String cedula;
    private String mensaje = "";
    private String nombreCliente = "";
    private String apellidoCliente = "";
    private String correoCliente = "";
    private String direccionCliente = "";
    private String telefonoCliente = "";
    private String autocompletado = "";
    private GregorianCalendar g;
    private double totalDinero = 0;

    @PostConstruct
    public void init() {
        list = new ArrayList<>();
        listaProductos = productoFacade.findAll();
        listaClientes = clienteFacade.findAll();
        listaKardex = kardexFacade.findAll();

    }

    public String add() {
        // Producto p = new Producto(1, "producto", 1, 2.3, null, null, null);
        // productoFacade.create(p);
        //producto=p;
        for (ProductoSucursal producto1 : listaProductos) {
            if (producto1.getProducto().getNombre().equals(autocompletado)) {
                this.producto = producto1;
            }
        }
        Detalle d = new Detalle(producto, cantidad, precio, subtotal, cabeceraVenta);
        list.add(d);
        this.limpiar();
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
        return null;
    }

    public String save(Detalle s) {
        int c = 0;
        for (Detalle detalle : list) {
            if (s.equals(detalle)) {
                //               Detalle d = new Detalle(detalle.getId(), detalle.get(), detalle.getCantidad(), detalle.getPrecio(), detalle.getCantidad() * detalle.getPrecio());
                list.set(id - 1, detalle);
            }
        }

        return null;
    }

    public void limpiar() {
        this.cantidad = 0;
        this.precio = 0.0;
        this.autocompletado = "";
        this.cedula = "";
        this.nombreCliente = "";

        this.apellidoCliente = "";
        this.direccionCliente = "";
        this.correoCliente = "";
        this.telefonoCliente = "";

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

    public ProductoSucursalFacade getProductoFacade() {
        return productoFacade;
    }

    public void setProductoFacade(ProductoSucursalFacade productoFacade) {
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

    public List<ProductoSucursal> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<ProductoSucursal> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public double getTotal() {
        this.total = 0;
        for (Detalle detalle : list) {
            total = total + detalle.getSubtotal();
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

    public String clienteBusqueda() {
        mensaje = "";
        System.out.println(cedula);
        for (Cliente cliente : listaClientes) {
            if (this.cedula.equals(cliente.getIdentificador())) {
                mensaje = "Cliente Encontrado";
                nombreCliente = cliente.getNombre();
                apellidoCliente = cliente.getApellido();
                direccionCliente = cliente.getDireccion();
                correoCliente = cliente.getCorreo();
                telefonoCliente = cliente.getTelefono();
                this.cliente = cliente;
            }

        }
        return null;
    }

    public String guardarFactura() {
        CabeceraVenta cabeceraVenta = new CabeceraVenta(cliente, id, new GregorianCalendar(), subtotal, total, true);
        facturaVentaFacade.create(cabeceraVenta);

        for (Detalle detalle : list) {
            // detalleFacade.create(new Detalle(id, detalle.getProducto(), detalle.getCantidad(), detalle.getProducto().getPrecio(), detalle.getSubtotal(), cabeceraVenta));
            detalleFacade.create(detalle);
            detalle.setCabeceraVenta(cabeceraVenta);
            detalleFacade.edit(detalle);

            kardexFacade.create(new Kardex(id, detalle, "+", detalle.getSubtotal() + calcularTotalKardex()));
        }
        cabeceraVenta.setDetalles(list);
        facturaVentaFacade.edit(cabeceraVenta);
        list = new ArrayList<>();
//        actualizarStock(cabeceraVenta);
        listCabecera = ventaFacade.findAll();
        listaProductos = productoFacade.findAll();
        limpiar();
        return null;
    }

    public double calcularTotalKardex() {
        listaKardex = kardexFacade.findAll();
        double valor = 0;
        for (Kardex kardex : listaKardex) {
            valor = kardex.getPrecioPonderado();
        }
        listaKardex = kardexFacade.findAll();
        return valor;
    }

//    public void actualizarStock(CabeceraVenta cabeceraVenta) {
//        for (Detalle detalle : cabeceraVenta.getDetalles()) {
//            producto = detalle.getProducto();
//            producto.setStock(producto.getStock() - detalle.getCantidad());
//            productoFacade.edit(producto);
//        }
//    }
    public GregorianCalendar mostrarFecha() {
        return new GregorianCalendar();
    }

    public GregorianCalendar getG() {
        return new GregorianCalendar();
    }

    public void setG(GregorianCalendar g) {
        this.g = g;
    }

    public String getDatosCliente() {
        return nombreCliente;
    }

    public void setDatosCliente(String datosCliente) {
        this.nombreCliente = datosCliente;
    }

    public List<String> completeText(String query) {
        String queryLowerCase = query.toLowerCase();
        List<String> countryList = new ArrayList<>();
        List<ProductoSucursal> producto = productoFacade.findAll();
        for (ProductoSucursal country : producto) {
            countryList.add(country.getProducto().getNombre());
        }

        return countryList.stream().filter(t -> t.toLowerCase().startsWith(queryLowerCase)).collect(Collectors.toList());
    }

    public String getAutocompletado() {
        return autocompletado;
    }

    public void setAutocompletado(String autocompletado) {
        this.autocompletado = autocompletado;
    }

    public List<Kardex> getListaKardex() {
        return listaKardex;
    }

    public void setListaKardex(List<Kardex> listaKardex) {
        this.listaKardex = listaKardex;
    }

    public double getTotalDinero() {
        return totalDinero;
    }

    public void setTotalDinero(double totalDinero) {
        this.totalDinero = totalDinero;
    }

    public KardexFacade getKardexFacade() {
        return kardexFacade;
    }

    public void setKardexFacade(KardexFacade kardexFacade) {
        this.kardexFacade = kardexFacade;
    }

    public CabeceraVentaFacade getVentaFacade() {
        return ventaFacade;
    }

    public void setVentaFacade(CabeceraVentaFacade ventaFacade) {
        this.ventaFacade = ventaFacade;
    }

    public List<CabeceraVenta> getListCabecera() {
        return listCabecera;
    }

    public void setListCabecera(List<CabeceraVenta> listCabecera) {
        this.listCabecera = listCabecera;
    }

    public ProductoSucursal getProducto() {
        return producto;
    }

    public void setProducto(ProductoSucursal producto) {
        this.producto = producto;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getCorreoCliente() {
        return correoCliente;
    }

    public void setCorreoCliente(String correoCliente) {
        this.correoCliente = correoCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

   

}

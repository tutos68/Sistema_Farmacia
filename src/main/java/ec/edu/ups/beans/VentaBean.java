/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.beans;

import ec.edu.ups.farmacia.controlador.CabeceraVentaFacade;
import ec.edu.ups.farmacia.modelo.CabeceraVenta;
import ec.edu.ups.farmacia.modelo.Cliente;
import ec.edu.ups.farmacia.modelo.Detalle;
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
 * @author pcuser
 */
@Named
@SessionScoped
public class VentaBean implements Serializable {

    private static final long serialVersionUID = 1L;
    @EJB
    private CabeceraVentaFacade ventaFacade;//mando mi fachada
    private List<CabeceraVenta> list = new ArrayList<>();// lista de Sucursales , se usa el List por el findAll()
    private int id;
    private GregorianCalendar fecha;
    private double subtotal;
    private double total;
    private boolean estado;
    private List<Detalle> detalles;
    private Cliente cliente;
    private CabeceraVenta cabeceraVenta;

    @PostConstruct//Esto es una notacion de EJB que nos dice que
    public void init() {
        detalles = new ArrayList<>();
        list = ventaFacade.findAll();//de que se ha creado o visualizado el JSF o el bean
        
    }                                   
    public void edit(CabeceraVenta s) {
        System.out.println(s);
        ventaFacade.edit(s);
        // s.setEditable(true); //habilita la caja
        list = ventaFacade.findAll();
    }

    public String delete(CabeceraVenta s) {
        ventaFacade.remove(s);
        list = ventaFacade.findAll();//llamo al findall para que se me actualice la lista
        return null;
    }

    public String save(CabeceraVenta s) {
        ventaFacade.edit(s);
        list = ventaFacade.findAll();//actualizo la lista

        return null;
    }

    public void limpiar() {
//        this.direccion = "";
//        this.latitud = 0;
//        this.longitud = 0;
//        this.nombreClave = "";
//        this.telefono = "";
    }

    public CabeceraVentaFacade getSucursalFacade() {
        return ventaFacade;
    }

    public void setSucursalFacade(CabeceraVentaFacade sucursalFacade) {
        this.ventaFacade = sucursalFacade;
    }

    public List<CabeceraVenta> getList() {
        return list;
    }

    public CabeceraVenta[] getList1() {//este metodo tambien se lo modifica
        return list.toArray(new CabeceraVenta[0]);// Lo que necesita el JSF dentro del table es un
    }                                        //un arreglo de usuarios        

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CabeceraVentaFacade getVentaFacade() {
        return ventaFacade;
    }

    public void setVentaFacade(CabeceraVentaFacade ventaFacade) {
        this.ventaFacade = ventaFacade;
    }

    public GregorianCalendar getFecha() {
        return fecha;
    }

    public void setFecha(GregorianCalendar fecha) {
        this.fecha = fecha;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public List<Detalle> getDetalles() {
        System.out.println("===============hols=================");
        for (Detalle detalle : this.detalles) {
            System.out.println("===============hols=================");
            System.out.println(detalle.toString());
            System.out.println("================================");
        }
        return detalles;
    }

    public void setDetalles(List<Detalle> detalles) {
        this.detalles = detalles;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String asignar(CabeceraVenta c) {

        this.detalles = c.getDetalles();

        return null;
    }

    public Date fecha(CabeceraVenta d) {
        Date a = d.getFecha().getTime();

        return a;
    }
}

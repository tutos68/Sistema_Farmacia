/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.beans;

import ec.edu.ups.farmacia.controlador.EmpleadoFacade;
import ec.edu.ups.farmacia.controlador.SucursalFacade;
import ec.edu.ups.farmacia.modelo.Empleado;
import ec.edu.ups.farmacia.modelo.Sucursal;
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
 * @author edwin
 */
@Named
@SessionScoped
public class EmpleadoBean implements Serializable {

    @EJB
    private EmpleadoFacade empleadoFacade;
    @EJB
    private SucursalFacade EJBSucursalFacade;
    private List<Empleado> listaEmpleado = new ArrayList<>();
    private List<Sucursal> listaSucursals = new ArrayList<>();
    private Sucursal sucursal;
    private Empleado empleado;
    private int id;
    private String identificador;
    private String nombre;
    private String apellido;
    private String correo;
    private String direccion;
    private String telefono;
    private String cargo = "EMPLEADO";
    private double sueldo;
    private Date fechaIngreso;

    @PostConstruct
    public void init() {
        this.empleado = new Empleado();
        this.sucursal = new Sucursal();
        listaEmpleado = empleadoFacade.findAll();
        listaSucursals = EJBSucursalFacade.findAll();
    }

    public void registrar() {
        try {
            //empleado.setSucursal(sucursal);
            empleadoFacade.create(new Empleado(fechaIngreso, cargo, sueldo, sucursal, id, identificador, nombre, apellido, correo, direccion, telefono));
        } catch (Exception e) {
            System.out.println("No ingreso" + e);
        }
    }

    public void add() {
        try {
            empleadoFacade.create(new Empleado(fechaIngreso, cargo, sueldo, sucursal, id, identificador, nombre, apellido, correo, direccion, telefono));
            listaEmpleado = empleadoFacade.findAll();//llamo al findall para que se me actualice la lista
        } catch (Exception e) {
            System.out.println("No ingreso" + e);
        }
    }

    public List<Empleado> getListaEmpleado() {
        return listaEmpleado;
    }

    public void setListaEmpleado(List<Empleado> listaEmpleado) {
        this.listaEmpleado = listaEmpleado;
    }

    public List<Sucursal> getListaSucursals() {
        return listaSucursals;
    }

    public void setListaSucursals(List<Sucursal> listaSucursals) {
        this.listaSucursals = listaSucursals;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

}

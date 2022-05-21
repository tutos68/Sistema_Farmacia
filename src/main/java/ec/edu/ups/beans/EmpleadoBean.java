/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.beans;

import ec.edu.ups.farmacia.controlador.EmpleadoFacade;
import ec.edu.ups.farmacia.modelo.Empleado;
import ec.edu.ups.farmacia.modelo.Sucursal;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author edwin
 */
@Named
@SessionScoped
public class EmpleadoBean implements Serializable {

    private static final long serialVersionUID = 1L;
    @EJB
    private EmpleadoFacade empleadoFacade;
    private List<Empleado> list = new ArrayList<>();// lista de Clientes , se usa el List por el findAll()
    private int id;
    private String identificador;
    private String nombre;
    private String apellido;
    private String correo;
    private String direccion;
    private String telefono;
    private GregorianCalendar fechaIngreso;
    private String cargo;
    private double sueldo;
    private Sucursal sucursal;

    @PostConstruct
    public void init() {//este metodo init se va a ejecutar despues 
        list = empleadoFacade.findAll();//de que se ha creado o visualizado el JSF o el bean
    }

    public String add() {
        empleadoFacade.create(new Empleado(fechaIngreso, cargo, sueldo, sucursal, id, identificador, nombre, apellido, correo, direccion, telefono));
        list = empleadoFacade.findAll();
        return null;
    }

    public String delete(Empleado e) {
        empleadoFacade.remove(e);
        list = empleadoFacade.findAll();
        return null;
    }

    public String edit(Empleado e) {
        e.setEditable(true);
        return null;
    }

    public String save(Empleado e) {
        empleadoFacade.edit(e);
        list = empleadoFacade.findAll();
        e.setEditable(false);
        return null;
    }

    public EmpleadoFacade getEmpleadoFacade() {
        return empleadoFacade;
    }

    public void setEmpleadoFacade(EmpleadoFacade empleadoFacade) {
        this.empleadoFacade = empleadoFacade;
    }

    public List<Empleado> getList() {
        return list;
    }

    public void setList(List<Empleado> list) {
        this.list = list;
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

    public GregorianCalendar getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(GregorianCalendar fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

}

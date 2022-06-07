/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.beans;

import ec.edu.ups.farmacia.controlador.EmpleadoFacade;
import ec.edu.ups.farmacia.controlador.SucursalFacade;
import ec.edu.ups.farmacia.controlador.UsuarioFacade;
import ec.edu.ups.farmacia.modelo.Empleado;
import ec.edu.ups.farmacia.modelo.Sucursal;
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
 * @author edwin
 */
@Named
@SessionScoped
public class EmpleadoBean implements Serializable {

    @EJB
    private EmpleadoFacade empleadoFacade;
    @EJB
    private SucursalFacade EJBSucursalFacade;
    @EJB
    private UsuarioFacade usuarioFacade;
    private List<Empleado> listaEmpleado = new ArrayList<>();
    private List<Usuario> listUsuario = new ArrayList<>(); // lista de Usuarios , se usa el List por el findAll()
    private List<Sucursal> listaSucursals = new ArrayList<>();
    private Sucursal sucursal;
    private Empleado empleado;
    private int id;
    private String usuario;
    private String contrasenia;
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
        listUsuario = usuarioFacade.findAll();
        //listaEmpleados();
    }

    public String delete(Empleado e) { //el empleado se borra por el usuario ya que dentro de usuario esta la entidad y la misma hereda a usuario
        empleadoFacade.remove(e);
        listaEmpleado = empleadoFacade.findAll();
        return null;
    }

    public void edit(Usuario u) {
        Empleado e = (Empleado) u.getEntidad();
        empleadoFacade.edit(e);
        listUsuario = usuarioFacade.findAll();
    }

    public String add() {
        Empleado empleado = new Empleado(id, identificador, nombre, apellido, correo, direccion, telefono, fechaIngreso, cargo, sueldo, sucursal);
        if (empleado != null) {
            Usuario usuarios = new Usuario(id, usuario, contrasenia, cargo, empleado);
            if (usuarios != null) {
                usuarioFacade.create(usuarios);
                //empleadoFacade.create(empleado);
                listaEmpleado = empleadoFacade.findAll();
                listUsuario = usuarioFacade.findAll();

            } else {
                System.out.println("No sirve 1");
            }
        } else {
            System.out.println("No sirve 2");
        }
        this.limpiar();
        return null;
    }

    public List<Usuario> listaEmpleados() {
        List<Usuario> listasUuU = new ArrayList<>();//listar usu
        for (Usuario usuario1 : listUsuario) {
            if (usuario1.getEntidad()instanceof Empleado) {
                listasUuU.add(usuario1);
            }
        }
        return listasUuU;
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

    public EmpleadoFacade getEmpleadoFacade() {
        return empleadoFacade;
    }

    public void setEmpleadoFacade(EmpleadoFacade empleadoFacade) {
        this.empleadoFacade = empleadoFacade;
    }

    public SucursalFacade getEJBSucursalFacade() {
        return EJBSucursalFacade;
    }

    public void setEJBSucursalFacade(SucursalFacade EJBSucursalFacade) {
        this.EJBSucursalFacade = EJBSucursalFacade;
    }

    public UsuarioFacade getUsuarioFacade() {
        return usuarioFacade;
    }

    public void setUsuarioFacade(UsuarioFacade usuarioFacade) {
        this.usuarioFacade = usuarioFacade;
    }

    public List<Usuario> getListUsuario() {
        return listUsuario;
    }

    public void setListUsuario(List<Usuario> listUsuario) {
        this.listUsuario = listUsuario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public void limpiar() {
        this.apellido = "";
        this.nombre = "";
        this.correo = "";
        this.direccion = "";
        this.fechaIngreso = null;
        this.telefono = "";
        this.identificador = "";
        this.usuario = "";
        this.contrasenia = "";
        this.sueldo = 0;
        this.sucursal=new Sucursal();

    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.beans;

import ec.edu.ups.farmacia.controlador.AdministradorFacade;
import ec.edu.ups.farmacia.controlador.UsuarioFacade;
import ec.edu.ups.farmacia.modelo.Administrador;
import ec.edu.ups.farmacia.modelo.Usuario;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author edwin
 */
//Hola
@Named
@SessionScoped
public class AdministradorBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private AdministradorFacade administradorFacade;//mando mi fachada
    @EJB
    private UsuarioFacade usuarioFacade; //mando mi fachada
    private List<Usuario> listu = new ArrayList<>(); // lista de Usuarios , se usa el List por el findAll()
    private List<Administrador> list = new ArrayList<>();// lista de Clientes , se usa el List por el findAll()
    private int id;
    private String usuario;
    private String contrasenia;
    private String rol = "ADMINISTRADOR";
    private String identificador;
    private String nombre;
    private String apellido;
    private String correo;
    private String direccion;
    private String telefono;

    @PostConstruct
    public void init() {
        list = administradorFacade.findAll();
        listu = usuarioFacade.findAll();

    }

    public String add() {
        Administrador administrador = new Administrador(identificador, nombre, apellido, correo, direccion, telefono);
        if (administrador != null) {
            Usuario usuarios = new Usuario(usuario, contrasenia, rol, administrador);
            if (usuarios != null) {
                usuarioFacade.create(usuarios);
                // administradorFacade.create(administrador);
                list = administradorFacade.findAll();
                listu = usuarioFacade.findAll();
            } else {
                System.out.println("No sirve 1");
            }
        } else {
            System.out.println("No sirve 2");
        }
        this.limpiar();
        return null;
    }

    public List<Usuario> listaAdmin() {
        List<Usuario> listasUuU = new ArrayList<>();
        for (Usuario usuario1 : listu) {

            if (usuario1.getRol().equals("ADMINISTRADOR")) {

                listasUuU.add(usuario1);

            }
        }
        return listasUuU;
    }

    public String delete(Usuario u) {
        usuarioFacade.remove(u);
        listu = usuarioFacade.findAll();//actualizo la lista
        return null;
    }

    public String edit(Usuario u) {
        Administrador a = (Administrador) u.getEntidad();//hago un casteo
        administradorFacade.edit(a);
        listu = usuarioFacade.findAll();//actualizo la lista
        return null;
    }

    public AdministradorFacade getAdministradorFacade() {
        return administradorFacade;
    }

    public void setAdministradorFacade(AdministradorFacade administradorFacade) {
        this.administradorFacade = administradorFacade;
    }

    public UsuarioFacade getUsuarioFacade() {
        return usuarioFacade;
    }

    public void setUsuarioFacade(UsuarioFacade usuarioFacade) {
        this.usuarioFacade = usuarioFacade;
    }

    public List<Usuario> getListu() {
        return listu;
    }

    public void setListu(List<Usuario> listu) {
        this.listu = listu;
    }

    public List<Administrador> getList() {
        return list;
    }

    public void setList(List<Administrador> list) {
        this.list = list;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
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

    public void limpiar() {
        this.apellido = "";
        this.nombre = "";
        this.correo = "";
        this.direccion = "";
        this.telefono = "";
        this.identificador = "";
        this.usuario = "";
        this.contrasenia = "";

    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.beans;

import ec.edu.ups.farmacia.controlador.UsuarioFacade;
import ec.edu.ups.farmacia.modelo.Entidad;

import ec.edu.ups.farmacia.modelo.Usuario;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import ec.edu.ups.farmacia.modelo.Administrador;

/**
 *
 * @author Adrian
 */
@Named
@SessionScoped
public class UsuarioBean implements Serializable {

    private static final long serialVersionUID = 1L;
    @EJB
    private UsuarioFacade usuarioFacade; //mando mi fachada
    private List<Usuario> list = new ArrayList<>(); // lista de Usuarios , se usa el List por el findAll()
    private int id;
    private Usuario u;
    private String usuario;
    private String contrasenia;
    private String rol;
    private Entidad entidad;

    @PostConstruct
    public void init() {
        list = usuarioFacade.findAll();
    }

    public String add() { //administrador
        usuarioFacade.create(new Usuario(id, usuario, contrasenia, rol, entidad));
        list = usuarioFacade.findAll();//llamo al findall para que se me actualice la lista
        return null;
    }
    
    
    public String addAdminisrador(String identificador, String nombre, String apellido, String correo, String direccion, String telefono,String usuario, String contrasenia) { //administrador
        
        Administrador administrador = new Administrador(identificador, nombre, apellido, correo, direccion, telefono);
        String rol="ADMINISTRADOR";
        
        usuarioFacade.create(new Usuario(usuario, contrasenia, rol, administrador));
        list = usuarioFacade.findAll();//llamo al findall para que se me actualice la lista
        return null;
    }

    public String delete(Usuario u) {
        usuarioFacade.remove(u);
        list = usuarioFacade.findAll();
        return null;
    }

    public String edit(Usuario u) {
        u.setEditable(true); //habilita la caja
        return null;
    }

    public String save(Usuario u) {
        usuarioFacade.edit(u);
        list = usuarioFacade.findAll(); //actualizo la lista
        u.setEditable(false); //desabilita la caja
        return null;
    }

    public Usuario[] getList() { //este metodo tambien se lo modifica
        return list.toArray(new Usuario[0]);// Lo que necesita el JSF dentro del table es un
        //arreglo no una lista por lo que convierto de lista a arreglo
    }                                    //un arreglo de usuarios

    public void setList(List<Usuario> list) {
        this.list = list;
    }

    public UsuarioFacade getUsuarioFacade() {
        return usuarioFacade;
    }

    public void setUsuarioFacade(UsuarioFacade usuarioFacade) {
        this.usuarioFacade = usuarioFacade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Entidad getEntidad() {
        return entidad;
    }

    public void setEntidad(Entidad entidad) {
        this.entidad = entidad;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String iniciarSesion() {
        String redireccion = null;
        try {
            usuarioFacade.iniciarUsuario(u);
            redireccion = "/administrador/Administrador.xhtml";
        } catch (Exception e) {
        }
        return redireccion;
    }

}

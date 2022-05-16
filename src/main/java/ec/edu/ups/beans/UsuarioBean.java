/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.beans;

import ec.edu.ups.farmacia.controlador.UsuarioFacade;
import ec.edu.ups.farmacia.modelo.Administrador;
import ec.edu.ups.farmacia.modelo.Cliente;
import ec.edu.ups.farmacia.modelo.Empleado;
import ec.edu.ups.farmacia.modelo.Rol;
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
    private String contrasenia;
    private Rol rol;
    private Empleado empleado;
    private Administrador administrador;
    private Cliente cliente;

    @PostConstruct
    public void init() {
        list = usuarioFacade.findAll();
    }

    public String add() { //administrador
        usuarioFacade.create(new Usuario(id, contrasenia, rol, administrador));
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

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}

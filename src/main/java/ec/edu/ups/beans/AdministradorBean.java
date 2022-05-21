/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.beans;

import ec.edu.ups.farmacia.controlador.AdministradorFacade;
import ec.edu.ups.farmacia.modelo.Administrador;
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
@Named
@SessionScoped
public class AdministradorBean implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @EJB
    private AdministradorFacade administradorFacade;//mando mi fachada
    private List<Administrador> list = new ArrayList<>();// lista de Clientes , se usa el List por el findAll()
    private int id;
    private String identificador;
    private String nombre;
    private String apellido;
    private String correo;
    private String direccion;
    private String telefono;
    
    @PostConstruct
    public void init() {        
        list = administradorFacade.findAll();
    }
    
    public String add() {        
        administradorFacade.create(new Administrador(id, identificador, nombre, apellido, correo, direccion, telefono));
        list = administradorFacade.findAll();
        return null;
    }
    
    public String delete(Administrador a) {
        administradorFacade.remove(a);
        list = administradorFacade.findAll();
        return null;
    }
    
    public String edit(Administrador a) {
        a.setEditable(true);
        return null;
    }
    
    public String save(Administrador a) {
        administradorFacade.edit(a);
        list = administradorFacade.findAll();
        a.setEditable(false);
        return null;
    }

    public AdministradorFacade getAdministradorFacade() {
        return administradorFacade;
    }

    public void setAdministradorFacade(AdministradorFacade administradorFacade) {
        this.administradorFacade = administradorFacade;
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
    
    
}

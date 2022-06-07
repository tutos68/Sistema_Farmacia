/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.beans;

import ec.edu.ups.farmacia.controlador.ProveedorFacade;
import ec.edu.ups.farmacia.modelo.Categoria;
import ec.edu.ups.farmacia.modelo.Proveedor;
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
public class ProveedorBean implements Serializable {

    private static final long serialVersionUID = 1L;
    @EJB
    private ProveedorFacade proveedorFacade;
    private List<Proveedor> list = new ArrayList<>();// lista de Clientes , se usa el List por el findAll()
    private int id;
    private String identificador;
    private String nombre;
    private String correo;
    private String direccion;
    private String telefono;
    private String sitioWeb;

    @PostConstruct
    public void init() {//este metodo init se va a ejecutar despues 
        list = proveedorFacade.findAll();//de que se ha creado o visualizado el JSF o el bean
    }

    public String add() {
        proveedorFacade.create(new Proveedor(sitioWeb, id, identificador, nombre, correo, direccion, telefono));
        list = proveedorFacade.findAll();
        this.limpiar();
        return null;
    }

    public String delete(Proveedor p) {
        proveedorFacade.remove(p);
        list = proveedorFacade.findAll();
        return null;
    }

    public void edit(Proveedor p) {
        proveedorFacade.edit(p);
        list = proveedorFacade.findAll();
    }

    public void limpiar() {
        this.identificador = "";
        this.nombre = "";
        this.correo = "";
        this.direccion = "";
        this.telefono = "";
        this.sitioWeb = "";
    }

    public ProveedorFacade getProveedorFacade() {
        return proveedorFacade;
    }

    public void setProveedorFacade(ProveedorFacade proveedorFacade) {
        this.proveedorFacade = proveedorFacade;
    }

    public List<Proveedor> getList() {
        return list;
    }

    public void setList(List<Proveedor> list) {
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

    public String getSitioWeb() {
        return sitioWeb;
    }

    public void setSitioWeb(String sitioWeb) {
        this.sitioWeb = sitioWeb;
    }

}

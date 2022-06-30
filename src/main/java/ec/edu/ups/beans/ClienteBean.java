/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.beans;

import ec.edu.ups.farmacia.controlador.ClienteFacade;
import ec.edu.ups.farmacia.modelo.Cliente;
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
public class ClienteBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private ClienteFacade clienteFacade;//mando mi fachada
    private List<Cliente> list = new ArrayList<>();// lista de Clientes , se usa el List por el findAll()
    private int id;
    private String identificador;
    private String nombre;
    private String apellido;
    private String correo;
    private String direccion;
    private String telefono;
    private Date fechaNacimiento;

    @PostConstruct//Esto es una notacion de EJB que nos dice que
    public void init() {//este metodo init se va a ejecutar despues 
        list = clienteFacade.findAll();//de que se ha creado o visualizado el JSF o el bean
    }                                  // esto se lo hace ya que puede que no se haya renderizado toda la vista y ya quiera llamar a buscar la info//lo cual puede arrojar un error  

    public String add() {
        clienteFacade.create(new Cliente(fechaNacimiento, id, identificador, nombre, apellido, correo, direccion, telefono));
        list = clienteFacade.findAll();
        this.limpiar();
        return null;
    }

    public String delete(Cliente c) {
        clienteFacade.remove(c);
        list = clienteFacade.findAll();
        return null;
    }

    public String edit(Cliente c) {
      clienteFacade.edit(c);
        return null;
    }

    public String save(Cliente c) {
        clienteFacade.edit(c);
        list = clienteFacade.findAll(); //actualizo la lista
        c.setEditable(false); //desabilita la caja
        return null;
    }

    public Cliente[] getList() { //este metodo tambien se lo modifica
        return list.toArray(new Cliente[0]);// Lo que necesita el JSF dentro del table es un
        //arreglo no una lista por lo que convierto de lista a arreglo
    }                                         //un arreglo de clientes 

    public void setList(List<Cliente> list) {
        this.list = list;
    }

    public ClienteFacade getClienteFacade() {
        return clienteFacade;
    }

    public void setClienteFacade(ClienteFacade clienteFacade) {
        this.clienteFacade = clienteFacade;
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

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void limpiar() {
        this.apellido = "";
        this.nombre = "";
        this.correo = "";
        this.direccion = "";
        this.fechaNacimiento = null;
        this.telefono = "";
        this.identificador="";
    }
}

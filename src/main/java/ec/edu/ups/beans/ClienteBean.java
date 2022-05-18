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
import java.util.GregorianCalendar;
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
    private ClienteFacade clienteFacade;
    private List<Cliente> list = new ArrayList<>();
    private int id;
    private String identificador;
    private String nombre;
    private String apellido;
    private String correo;
    private String direccion;
    private String telefono;
    private GregorianCalendar fechaNacimiento;

    @PostConstruct
    public void init() {
        list = clienteFacade.findAll();
    }

    public String add() {
        clienteFacade.create(new Cliente(fechaNacimiento, id, identificador, nombre, apellido, correo, direccion, telefono));
        list = clienteFacade.findAll();
        return null;
    }
    
    
     public String delete(Cliente c) {
	clienteFacade.remove(c);
        list = clienteFacade.findAll();
	return null;
    }

}

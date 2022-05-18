/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.beans;

import ec.edu.ups.farmacia.controlador.SucursalFacade;
import ec.edu.ups.farmacia.modelo.Sucursal;
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
public class SucursalBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @EJB
    private SucursalFacade sucursalFacade;
    private List<Sucursal> list = new ArrayList<>();
    private int id;
    private String direccion;
    private String nombreClave;
    private String telefono;
    private double latitud;
    private double longitud;

    @PostConstruct
    public void init() {
        list = sucursalFacade.findAll();
    }
    
    public String add() {
        sucursalFacade.create(new Sucursal(id, direccion, nombreClave, telefono, latitud, longitud));
        list = sucursalFacade.findAll();
        return null;
    }
    
    public String delete(Sucursal s) {
        sucursalFacade.remove(s);
        list = sucursalFacade.findAll();
        return null;
    }
}

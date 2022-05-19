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

    public SucursalFacade getSucursalFacade() {
        return sucursalFacade;
    }

    public void setSucursalFacade(SucursalFacade sucursalFacade) {
        this.sucursalFacade = sucursalFacade;
    }

    public List<Sucursal> getList() {
        return list;
    }
    
    
    public List<String> sucursalNombre() {
        List<String> listaNombres = new ArrayList<>();
        String n;
        for (Sucursal s : list) {
            n = s.getNombreClave();
            listaNombres.add(n);
        }
        return listaNombres;
    }


    public void setList(List<Sucursal> list) {
        this.list = list;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombreClave() {
        return nombreClave;
    }

    public void setNombreClave(String nombreClave) {
        this.nombreClave = nombreClave;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }
    
}

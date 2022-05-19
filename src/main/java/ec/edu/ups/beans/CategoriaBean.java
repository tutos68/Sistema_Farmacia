/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.beans;

import ec.edu.ups.farmacia.controlador.CategoriaFacade;
import ec.edu.ups.farmacia.modelo.Categoria;
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
public class CategoriaBean implements Serializable {

    private static final long serialVersionUID = 1L;
    @EJB
    private CategoriaFacade categoriaFacade;
    private List<Categoria> list = new ArrayList<>();
    private int id;
    private String nombre;
    
    
    @PostConstruct
    public void init(){
        list = categoriaFacade.findAll();
    }
    
    public String add(){
        categoriaFacade.create(new Categoria(id, nombre));
        list = categoriaFacade.findAll();
        return null;
    }
     public String delete(Categoria c) {
        categoriaFacade.remove(c);
        list = categoriaFacade.findAll();
        return null;
    }

    public CategoriaFacade getCategoriaFacade() {
        return categoriaFacade;
    }

    public void setCategoriaFacade(CategoriaFacade categoriaFacade) {
        this.categoriaFacade = categoriaFacade;
    }

    public List<Categoria> getList() {
        return list;
    }

    public void setList(List<Categoria> list) {
        this.list = list;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
     
     
}

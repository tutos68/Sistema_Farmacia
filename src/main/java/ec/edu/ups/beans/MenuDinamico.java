/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.beans;

import ec.edu.ups.farmacia.controlador.MenuFacade;
import ec.edu.ups.farmacia.modelo.Menu;
import ec.edu.ups.farmacia.modelo.Usuario;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author ASUS_GAMING
 */
@Named
//@RequestScoped
@SessionScoped
public class MenuDinamico implements Serializable {

    @EJB
    private MenuFacade menuFacade;
    private List<Menu> list = new ArrayList<>();
    private MenuModel model;

    @PostConstruct
    public void init() {
        this.listarMenus();
        model = new DefaultMenuModel();
        this.establecerPermisos();
    }

    public void listarMenus() {
        try {
            list = menuFacade.findAll();
        } catch (Exception e) {
        }
    }

    public void establecerPermisos() {
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        for (Menu m : list) {
            if (m.getTipo().equals("S") && m.getTipoUsuario().equals(us.getRol())) {
                DefaultSubMenu firstSubmenu = DefaultSubMenu.builder()
                        .label(m.getNombre())
                        .build();
                for (Menu i : list) {
                    Menu subMenu = i.getCodigo_submenu();
                    if (subMenu != null) {
                        if (subMenu.getId() == m.getId()) {
                            DefaultMenuItem item = DefaultMenuItem.builder()
                                    .value(i.getNombre())
                                    .url(i.getUrl())
                                    .ajax(false)
                                    .build();
                            firstSubmenu.getElements().add(item);
                        }
                    }
                }
                model.getElements().add(firstSubmenu);
            } else {
                if (m.getCodigo_submenu() == null && m.getTipoUsuario().equals(us.getRol())) {
                    DefaultMenuItem item = DefaultMenuItem.builder()
                            .value(m.getNombre())
                            .url(m.getUrl())
                            .ajax(false)
                            .build();
                    model.getElements().add(item);
                }

            }
        }
    }

    public MenuModel getModel() {
        return model;
    }

    public void setModel(MenuModel model) {
        this.model = model;
    }

    public void cerrarSesion() {  
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }
}

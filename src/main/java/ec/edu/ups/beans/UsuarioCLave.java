/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.beans;

import ec.edu.ups.farmacia.controlador.UsuarioFacade;
import ec.edu.ups.farmacia.modelo.Usuario;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.Serializable;

/**
 *
 * @author ASUS_GAMING
 */
@Named
@RequestScoped
public class UsuarioCLave implements Serializable{
    @EJB
    private UsuarioFacade usuarioFacade;
    private Usuario usuario;
    
    @PostConstruct
    public void init() {
        this.usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String iniciarSesion() {
        Usuario us;
        String redireccion = null;
        System.out.println(this.usuario.getUsuario());
        try {
            us = usuarioFacade.iniciarUsuario(usuario);
            if (us !=null) {
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", us);
                redireccion = "administrador/Administrador?faces-redirect=true";
                //return "http://localhost:8080/Sistema_Farmacia/vista/cliente/Cliente.xhtml";
            } else {
                System.out.println("Entro mal");
            }
            
        } catch (Exception e) {
        }
        return redireccion;
    }
     
}

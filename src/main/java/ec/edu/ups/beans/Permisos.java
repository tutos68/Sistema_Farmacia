/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.beans;

import ec.edu.ups.farmacia.modelo.Usuario;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;

/**
 *
 * @author ASUS_GAMING
 */
@Named
@RequestScoped
public class Permisos implements Serializable{

    public void verificarSesion(){
         try {
            Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            
            if(us == null){
                FacesContext.getCurrentInstance().getExternalContext().redirect("../administrador/permisos.xhtml");
            }
         } catch (Exception e) {
             System.out.println("No entro");
         }
     }
    

}

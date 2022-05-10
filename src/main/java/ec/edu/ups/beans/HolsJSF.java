/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.annotation.FacesConfig;
import jakarta.inject.Named;
import java.io.Serializable;

/**
 *
 * @author pcuser
 */

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@RequestScoped
public class HolsJSF implements Serializable{
    private static final long serialVersionUID = 1L;
    private String saludo = "Hola desde JSF 2.3";
    
    
    public String getSaludo(){
        return saludo;
    }
}

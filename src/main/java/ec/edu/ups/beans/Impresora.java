/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.annotation.FacesConfig;
import jakarta.inject.Inject;
import jakarta.inject.Named;

/**
 *
 * @author pcuser
 */

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@RequestScoped
public class Impresora {
    public static final long serialVersionUID=1L;
    @Inject
    private MiSaludo miSaludo;

    public Impresora() {
    }

    public MiSaludo getMiSaludo() {
        return miSaludo;
    }
    
}

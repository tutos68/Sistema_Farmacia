/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

/**
 *
 * @author pcuser
 */
@Named
@RequestScoped

public class MiSaludo {
    public String saludar(String nombre){
        return "Hola, "+nombre+".";
    }
}

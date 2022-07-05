/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.farmacia.modelo;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 *
 * @author edwin
 */
@Entity
@Table(name = "administrador")
public class Administrador extends Entidad implements Serializable {

    public Administrador(int id, String identificador, String nombre, String apellido, String correo, String direccion, String telefono) {
        super(id, identificador, nombre, apellido, correo, direccion, telefono);
    }

    public Administrador() {
    }
    
    
    public Administrador(String identificador, String nombre, String apellido, String correo, String direccion, String telefono) {
       
    }
    
    

   
    
}

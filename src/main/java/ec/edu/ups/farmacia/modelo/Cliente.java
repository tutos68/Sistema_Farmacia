/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.farmacia.modelo;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.GregorianCalendar;

/**
 *
 * @author edwin
 */
@NamedQuery(name="getByLevel",
            query = "SELECT c FROM Cliente c WHERE c.id >= :level")
@Entity
@Table(name = "cliente")

public class Cliente extends Entidad implements Serializable {
    
    @Temporal(TemporalType.DATE)
    private GregorianCalendar fechaNacimiento;

    public Cliente() {
    }
    
    public Cliente(GregorianCalendar fechaNacimiento, int id, String identificador, String nombre, String apellido, String correo, String direccion, String telefono) {
        super(id, identificador, nombre, apellido, correo, direccion, telefono);
        this.fechaNacimiento = fechaNacimiento;
    }

    public GregorianCalendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(GregorianCalendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
  
    
    
}

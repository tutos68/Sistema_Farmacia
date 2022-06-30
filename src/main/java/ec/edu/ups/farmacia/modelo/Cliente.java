/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.farmacia.modelo;


import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;

/**
 *
 * @author edwin
 */
@NamedQuery(name = "getByLevel",
        query = "SELECT c FROM Cliente c WHERE c.id >= :level")
@Entity
@Table(name = "cliente")

public class Cliente extends Entidad implements Serializable {

    
    @Column(name = "fecha_Nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "cliente")
    private CabeceraVenta cabeceraVenta;
    public Cliente() {
    }

    public Cliente(Date fechaNacimiento, int id, String identificador, String nombre, String apellido, String correo, String direccion, String telefono) {
        super(id, identificador, nombre, apellido, correo, direccion, telefono);
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Nombre: "+getNombre()+" Apellido: "+getApellido()+" Cedula: "+getIdentificador()+ " Direccion= " + getDireccion() + '}';
    }

}

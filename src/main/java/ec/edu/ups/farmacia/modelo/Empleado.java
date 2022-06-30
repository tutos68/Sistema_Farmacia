/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.farmacia.modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import java.util.Date;

/**
 *
 * @author edwin
 */
@Entity
@Table(name = "empleado")
public class Empleado extends Entidad implements Serializable {

    @Temporal(TemporalType.DATE)
     @Column(name = "fecha_ingreso")
    private Date fechaIngreso;
    private String cargo;
    private double sueldo;
//    @OneToOne(cascade = CascadeType.PERSIST)
    @OneToOne
    @JoinColumn(name = "sucursal_id", referencedColumnName = "id")
    private Sucursal sucursal;

    public Empleado() {
    }

    public Empleado( int id, String identificador, String nombre, String apellido,String correo, String direccion, String telefono,Date fechaIngreso, String cargo, double sueldo, Sucursal sucursal) {
        super(id, identificador, nombre, apellido, correo, direccion, telefono);
        this.fechaIngreso = fechaIngreso;
        this.cargo = cargo;
        this.sueldo = sueldo;
        this.sucursal = sucursal;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    @Override
    public String toString() {
        return "Empleado{" + "fechaIngreso=" + fechaIngreso + ", cargo=" + cargo + ", sueldo=" + sueldo + ", sucursal=" + sucursal + '}';
    }
    
}

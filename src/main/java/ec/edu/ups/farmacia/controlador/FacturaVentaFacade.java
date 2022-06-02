/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.farmacia.controlador;

import ec.edu.ups.farmacia.modelo.CabeceraVenta;
import ec.edu.ups.farmacia.modelo.Empleado;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author pcuser
 */

@Stateless
public class FacturaVentaFacade extends AbstractFacade<CabeceraVenta>{
     @PersistenceContext(name = "Farmacia")
    private EntityManager em;
    
    public FacturaVentaFacade() {
        super(CabeceraVenta.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.farmacia.controlador;

import ec.edu.ups.farmacia.modelo.CabeceraCompra;
import ec.edu.ups.farmacia.modelo.CabeceraVenta;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author pcuser
 */
@Stateless
public class CabeceraCompraFacade extends AbstractFacade<CabeceraCompra>{
    
     
    @PersistenceContext()
    private EntityManager em;

    public CabeceraCompraFacade() {
        super(CabeceraCompra.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}

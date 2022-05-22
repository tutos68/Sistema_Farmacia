/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.farmacia.controlador;

import ec.edu.ups.farmacia.modelo.Sucursal;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author edwin
 */
@Stateless
public class SucursalFacade  extends AbstractFacade<Sucursal> {
    @PersistenceContext()
    private EntityManager em;
    
    public SucursalFacade() {
        super(Sucursal.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}

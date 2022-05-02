/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.farmacia.controlador;

import ec.edu.ups.farmacia.modelo.Proveedor;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author ASUS_GAMING
 */
@Stateless
public class ProveedorFacade extends AbstractFacade<Proveedor>{
    
    @PersistenceContext()
    private EntityManager em;
    
    public ProveedorFacade() {
        super(Proveedor.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}

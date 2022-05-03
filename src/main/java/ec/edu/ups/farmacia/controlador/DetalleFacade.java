/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.farmacia.controlador;

import ec.edu.ups.farmacia.modelo.Cliente;
import ec.edu.ups.farmacia.modelo.Detalle;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author pcuser
 */
@Stateless
public class DetalleFacade extends AbstractFacade<Detalle>{
    @PersistenceContext(name = "Farmacia")
    private EntityManager em;

    public DetalleFacade() {
        super(Detalle.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}

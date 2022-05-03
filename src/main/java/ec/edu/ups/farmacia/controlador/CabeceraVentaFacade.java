/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.farmacia.controlador;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import ec.edu.ups.farmacia.modelo.CabeceraVenta;
/**
 *
 * @author pcuser
 */
@Stateless
public class CabeceraVentaFacade extends AbstractFacade<CabeceraVenta>{
    
    @PersistenceContext()
    private EntityManager em;

    public CabeceraVentaFacade() {
        super(CabeceraVenta.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}

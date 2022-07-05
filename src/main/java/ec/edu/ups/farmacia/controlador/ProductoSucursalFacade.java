/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.farmacia.controlador;

import ec.edu.ups.farmacia.modelo.ProductoSucursal;
import ec.edu.ups.farmacia.modelo.Sucursal;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

/**
 *
 * @author pcuser
 */
@Stateless
public class ProductoSucursalFacade extends AbstractFacade<ProductoSucursal>{
    @PersistenceContext(name = "Farmacia")
    private EntityManager em;

    public ProductoSucursalFacade() {
        super(ProductoSucursal.class);
    }
    
    
    
    public List<ProductoSucursal> getClienteIds(Sucursal sucursal) {
        String jpql1 = "SELECT ps FROM ProductoSucursal ps where ps.sucursal.id="+sucursal.getId();
        List<ProductoSucursal> res = em.createQuery(jpql1).getResultList();
        return res;
    }
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}

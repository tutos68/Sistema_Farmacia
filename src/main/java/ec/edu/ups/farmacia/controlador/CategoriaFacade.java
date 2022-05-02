/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.farmacia.controlador;

import ec.edu.ups.farmacia.modelo.Categoria;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author ASUS_GAMING
 */
@Stateless
public class CategoriaFacade extends AbstractFacade<Categoria>{
    
    @PersistenceContext()
    private EntityManager em;
    
    public CategoriaFacade() {
        super(Categoria.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}

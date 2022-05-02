/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.farmacia.controlador;

import ec.edu.ups.farmacia.modelo.Usuario;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author ASUS_GAMING
 */
@Stateless
public class UsuarioFacade extends  AbstractFacade<Usuario>{
        
    @PersistenceContext()
    private EntityManager em;
    
    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}

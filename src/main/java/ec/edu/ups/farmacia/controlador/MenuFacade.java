/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.farmacia.controlador;

import ec.edu.ups.farmacia.modelo.Menu;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author edwin
 */
@Stateless
public class MenuFacade extends AbstractFacade<Menu> {

    @PersistenceContext(name = "Farmacia")
    private EntityManager em;

    public MenuFacade() {
        super(Menu.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}

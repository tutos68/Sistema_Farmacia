/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.farmacia.controlador;

import ec.edu.ups.farmacia.modelo.Kardex;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author Adrian
 */
@Stateless
public class KardexFacade extends AbstractFacade<Kardex> {

    @PersistenceContext(name = "Farmacia")
    private EntityManager em;

    public KardexFacade() {
        super(Kardex.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}

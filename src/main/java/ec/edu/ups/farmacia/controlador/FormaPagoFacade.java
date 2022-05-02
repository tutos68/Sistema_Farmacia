/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.farmacia.controlador;

import ec.edu.ups.farmacia.modelo.FormaPago;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author Adrian
 */
@Stateless
public class FormaPagoFacade extends AbstractFacade<FormaPago> {

    @PersistenceContext(name = "Farmacia")
    private EntityManager em;

    public FormaPagoFacade() {
        super(FormaPago.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}

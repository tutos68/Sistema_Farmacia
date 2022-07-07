/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.farmacia.controlador;

import ec.edu.ups.farmacia.modelo.Pedido;
import ec.edu.ups.farmacia.modelo.PedidoDetalle;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author pcuser
 */
@Stateless
public class PedidoDetalleFacade  extends  AbstractFacade<PedidoDetalle> {
    @PersistenceContext(name="Farmacia")
    private EntityManager em;

    public PedidoDetalleFacade() {
        super(PedidoDetalle.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}

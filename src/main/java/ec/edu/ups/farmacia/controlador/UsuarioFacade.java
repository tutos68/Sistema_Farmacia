/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.farmacia.controlador;

import ec.edu.ups.farmacia.modelo.Usuario;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.List;

/**
 *
 * @author ASUS_GAMING
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext()
    private EntityManager em;

    public UsuarioFacade() {
        super(Usuario.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Usuario iniciarUsuario(Usuario usuario) {
        Usuario u = null;
       // try {
            String consulta = "SELECT u FROM Usuario u WHERE u.usuario = ?1 AND u.contrasenia = ?2";
            Query query = em.createQuery(consulta);
            query.setParameter(1, u.getUsuario());
            query.setParameter(2, u.getContrasenia());

            List<Usuario> lista = query.getResultList();
            System.out.println(lista + " Ya valio maso" );
           // if (!lista.isEmpty()) {

             //   u = lista.get(0);
            //}
        //} catch (Exception e) {
           // System.out.println("Ya valio maso " + e);
        //}
        return u;
    }
}

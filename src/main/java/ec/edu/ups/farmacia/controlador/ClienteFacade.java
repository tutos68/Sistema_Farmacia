/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.farmacia.controlador;

import ec.edu.ups.farmacia.modelo.Cliente;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;


import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.List;
/**
 *
 * @author edwin
 */
@Stateless
public class ClienteFacade extends AbstractFacade<Cliente> {
    @PersistenceContext(name = "Farmacia")
    private EntityManager em;

    public ClienteFacade() {
        super(Cliente.class);
    }
    
    public List<Integer> getClienteIds() {
        String jpql1 = "SELECT c.id FROM Cliente c";
        List<Integer> res = em.createQuery(jpql1).getResultList();
        return res;
    }
    
    
    public Cliente getClienteById(int id){
        String jpql = "SELECT c FROM Cliente c WHERE c.id =" + id;
        Cliente cliente = (Cliente) em.createQuery(jpql).getSingleResult();
        return cliente;
    }
    
    
     public List<Cliente>  getClientesByLevel(int level){
            Query query = em.createNamedQuery("getByLevel");
            query.setParameter("level", level);
            List<Cliente> cli = query.getResultList();
            return cli;
        }
     
     
     public List<Cliente> consuntaDos(String nombre, int id){
        CriteriaBuilder cb = this.em.getCriteriaBuilder();
        CriteriaQuery<Cliente> cq= cb.createQuery(Cliente.class);
        Root root = cq.from(Cliente.class);
        cq.select(root);
        Predicate p1=cb.like(root.get("nombre").as(String.class),"Miguel");
        Predicate p2=cb.greaterThanOrEqualTo(root.get("id").as(Integer.class), id);
        Predicate predicado = cb.and(p1,p2);
        cq.where(predicado);
        
        Query consulta = em.createQuery(cq);
        return consulta.getResultList();
    }
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    
    
}

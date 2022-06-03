package ec.edu.ups.beans;

import ec.edu.ups.farmacia.controlador.CabeceraVentaFacade;
import ec.edu.ups.farmacia.controlador.DetalleFacade;
import ec.edu.ups.farmacia.controlador.KardexFacade;
import ec.edu.ups.farmacia.modelo.CabeceraCompra;
import ec.edu.ups.farmacia.modelo.CabeceraVenta;
import ec.edu.ups.farmacia.modelo.Detalle;
import ec.edu.ups.farmacia.modelo.Kardex;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adrian
 */
@Named
@SessionScoped
public class KardexBean implements Serializable {

    @EJB
    private KardexFacade kardexFacade;
    @EJB
    private CabeceraVentaFacade cabeceraVentaFacade;
    @EJB
    private DetalleFacade detalleFacade;
    private List<Detalle> listDetalle;
    private List<Kardex> list = new ArrayList<>();
    private int id;
    private CabeceraCompra compra;
    private CabeceraVenta venta;
    private double precioPonderado;
    

    @PostConstruct
    public void init() {
        listDetalle=detalleFacade.findAll();
    }
     public String add() {
        kardexFacade.create(new Kardex(id, compra,venta,precioPonderado));
        list = kardexFacade.findAll();//llamo al findall para que se me actualice la lista
        return null;
    }

    public String delete(Kardex k) {
        kardexFacade.remove(k);
        list = kardexFacade.findAll();
        return null;
    }

    public void edit(Kardex k) {
        kardexFacade.edit(k);
        
        list = kardexFacade.findAll();//actualizo la lista
    }

    public String save(Kardex k) {
        kardexFacade.edit(k);
        list = kardexFacade.findAll(); //actualizo la lista
        return null;
    }

    public Kardex[] getList() {
        return list.toArray(new Kardex[0]);
    }

    public void setList(List<Kardex> list) {
        this.list = list;
    }

    
    
    public KardexFacade getKardexFacade() {
        return kardexFacade;
    }

    public void setKardexFacade(KardexFacade kardexFacade) {
        this.kardexFacade = kardexFacade;
    }

    public CabeceraVentaFacade getCabeceraVentaFacade() {
        return cabeceraVentaFacade;
    }

    public void setCabeceraVentaFacade(CabeceraVentaFacade cabeceraVentaFacade) {
        this.cabeceraVentaFacade = cabeceraVentaFacade;
    }

    public DetalleFacade getDetalleFacade() {
        return detalleFacade;
    }

    public void setDetalleFacade(DetalleFacade detalleFacade) {
        this.detalleFacade = detalleFacade;
    }

    public List<Detalle> getListDetalle() {
        return listDetalle;
    }

    public void setListDetalle(List<Detalle> listDetalle) {
        this.listDetalle = listDetalle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CabeceraCompra getCompra() {
        return compra;
    }

    public void setCompra(CabeceraCompra compra) {
        this.compra = compra;
    }

    public CabeceraVenta getVenta() {
        return venta;
    }

    public void setVenta(CabeceraVenta venta) {
        this.venta = venta;
    }

    public double getPrecioPonderado() {
        return precioPonderado;
    }

    public void setPrecioPonderado(double precioPonderado) {
        this.precioPonderado = precioPonderado;
    }
    
    

}
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
import java.util.Date;
import java.util.GregorianCalendar;
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
    private DetalleFacade detallefacade;
    @EJB
    private DetalleFacade detalleFacade;
    private List<Detalle> listDetalle;
    private List<Kardex> list = new ArrayList<>();
    private int id;
    private Detalle detalle;
    private String signo;
    private double precioPonderado;
    private GregorianCalendar fecha;

    @PostConstruct
    public void init() {
        listDetalle = detalleFacade.findAll();
        list = kardexFacade.findAll();
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

    public double getPrecioPonderado() {
        return precioPonderado;
    }

    public void setPrecioPonderado(double precioPonderado) {
        this.precioPonderado = precioPonderado;
    }

    public DetalleFacade getDetallefacade() {
        return detallefacade;
    }

    public void setDetallefacade(DetalleFacade detallefacade) {
        this.detallefacade = detallefacade;
    }

    public Detalle getDetalle() {
        return detalle;
    }

    public void setDetalle(Detalle detalle) {
        this.detalle = detalle;
    }

    public String getSigno() {
        return signo;
    }

    public void setSigno(String signo) {
        this.signo = signo;
    }

    public GregorianCalendar getFecha() {
        return fecha;
    }

    public void setFecha(GregorianCalendar fecha) {
        this.fecha = fecha;
    }

    public Date asignarFecha(Kardex k){
        Date a=new Date();
        if(k.getDetalle().getCabeceraCompra()==null){
            a=  k.getDetalle().getCabeceraVenta().getFecha().getTime();
        }else{
            a =  k.getDetalle().getCabeceraCompra().getFecha().getTime();
        }
        return a;
    }
    
    
    public Date fecha(CabeceraVenta d) {
        Date a = d.getFecha().getTime();

        return a;
    }
}

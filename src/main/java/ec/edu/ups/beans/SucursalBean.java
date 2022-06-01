package ec.edu.ups.beans;

import ec.edu.ups.farmacia.controlador.SucursalFacade;
import ec.edu.ups.farmacia.modelo.Sucursal;
import jakarta.annotation.PostConstruct;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author edwin
 */
@Named
@SessionScoped
public class SucursalBean implements Serializable {

    private static final long serialVersionUID = 1L;
    @EJB
    private SucursalFacade sucursalFacade;//mando mi fachada
    private List<Sucursal> list = new ArrayList<>();// lista de Sucursales , se usa el List por el findAll()
    private int id;
    private String direccion;
    private String nombreClave;
    private String telefono;
    private double latitud;
    private double longitud;

    @PostConstruct//Esto es una notacion de EJB que nos dice que
    public void init() {//este metodo init se va a ejecutar despues 
        list = sucursalFacade.findAll();//de que se ha creado o visualizado el JSF o el bean
    }                                   // esto se lo hace ya que puede que no se haya renderizado toda la vista y ya quiera llamar a buscar la info
    //lo cual puede arrojar un error    

    public String add() {

        sucursalFacade.create(new Sucursal(id, direccion, nombreClave, telefono, latitud, longitud));
        list = sucursalFacade.findAll();//llamo al findall para que se me actualice la lista
        this.limpiar();
        return null;
    }

    public void edit(Sucursal s) {
        System.out.println(s);
        sucursalFacade.edit(s);
       // s.setEditable(true); //habilita la caja
        list = sucursalFacade.findAll();
    }

    public String delete(Sucursal s) {
        sucursalFacade.remove(s);
        list = sucursalFacade.findAll();//llamo al findall para que se me actualice la lista
        return null;
    }



    public void limpiar() {
        this.direccion = "";
        this.latitud = 0;
        this.longitud = 0;
        this.nombreClave = "";
        this.telefono = "";
    }

    public SucursalFacade getSucursalFacade() {
        return sucursalFacade;
    }

    public void setSucursalFacade(SucursalFacade sucursalFacade) {
        this.sucursalFacade = sucursalFacade;
    }

    public List<Sucursal> getList() {
        return list;
    }

    public Sucursal[] getList1() {//este metodo tambien se lo modifica
        return list.toArray(new Sucursal[0]);// Lo que necesita el JSF dentro del table es un
    }                                        //un arreglo de usuarios        

    public List<String> sucursalNombre() {
        List<String> listaNombres = new ArrayList<>();
        String n;
        for (Sucursal s : list) {
            n = s.getNombreClave();
            listaNombres.add(n);
        }
        return listaNombres;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombreClave() {
        return nombreClave;
    }

    public void setNombreClave(String nombreClave) {
        this.nombreClave = nombreClave;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

}

package ec.edu.ups.beans;

import ec.edu.ups.farmacia.controlador.CategoriaFacade;
import ec.edu.ups.farmacia.controlador.ProductoFacade;
import ec.edu.ups.farmacia.controlador.SucursalFacade;
import ec.edu.ups.farmacia.modelo.Categoria;
import ec.edu.ups.farmacia.modelo.Empleado;
import ec.edu.ups.farmacia.modelo.Producto;
import ec.edu.ups.farmacia.modelo.Sucursal;
import ec.edu.ups.farmacia.modelo.Usuario;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adrian
 */
@Named
@SessionScoped
public class ProductoBean implements Serializable {

    private static final long serialVersionUID = 1L;
    @EJB
    private ProductoFacade productoFacade;
    @EJB
    private CategoriaFacade categoriaFacade;
    @EJB
    private SucursalFacade sucursalFacade;
    private Usuario usuario;
    private Categoria categoria;
    private Sucursal sucursal;
    private Producto producto;
    private List<Producto> list = new ArrayList<>();
    private List<Categoria> listCategoria = new ArrayList<>();
    private int id;
    private String nombre;
    private int stock;
    private double precio;
    private String descripcion;

    @PostConstruct
    public void init() {
        this.categoria = new Categoria();
        this.producto = new Producto();
        listCategoria = categoriaFacade.findAll();
        list = productoFacade.findAll();
    }

    public String add() {
        Usuario u = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");//
       // Empleado e = (Empleado) u.getEntidad();
       // System.out.println(e.getSucursal().getNombreClave());
        productoFacade.create(new Producto(nombre, precio, descripcion, categoria));

        //Sucursal s = (Sucursal) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        list = productoFacade.findAll();//llamo al findall para que se me actualice la lista
        this.limpiar();
        return null;
    }

    public String delete(Producto p) {
        productoFacade.remove(p);
        list = productoFacade.findAll();//llamo al findall para que se me actualice la lista
        return null;
    }

   

    public String save(Producto p) {
        productoFacade.edit(p);
        list = productoFacade.findAll(); //actualizo la lista
     //   p.setEditable(false); //desabilita la caja
        return null;
    }

    public void limpiar() {
        this.nombre = "";
        this.stock = 0;
        this.precio = 0.0;
        this.descripcion = "";
        this.categoria = new Categoria();
    }

    public Producto[] getList() { //este metodo tambien se lo modifica
        return list.toArray(new Producto[0]);// Lo que necesita el JSF dentro del table es un
        //arreglo no una lista por lo que convierto de lista a arreglo
    }                                        //un arreglo de productos

    public CategoriaFacade getCategoriaFacade() {
        return categoriaFacade;
    }

    public void setCategoriaFacade(CategoriaFacade categoriaFacade) {
        this.categoriaFacade = categoriaFacade;
    }

    public List<Categoria> getListCategoria() {
        return listCategoria;
    }

    public void setListCategoria(List<Categoria> listCategoria) {
        this.listCategoria = listCategoria;
    }

    public ProductoFacade getProductoFacade() {
        return productoFacade;
    }

    public void setProductoFacade(ProductoFacade productoFacade) {
        this.productoFacade = productoFacade;
    }

    public void setList(List<Producto> list) {
        this.list = list;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public SucursalFacade getSucursalFacade() {
        return sucursalFacade;
    }

    public void setSucursalFacade(SucursalFacade sucursalFacade) {
        this.sucursalFacade = sucursalFacade;
    }

  
}

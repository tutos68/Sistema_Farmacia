package ec.edu.ups.beans;

import ec.edu.ups.farmacia.controlador.CategoriaFacade;
import ec.edu.ups.farmacia.controlador.ProductoFacade;
import ec.edu.ups.farmacia.controlador.SucursalFacade;
import ec.edu.ups.farmacia.modelo.Categoria;
import ec.edu.ups.farmacia.modelo.Producto;
import ec.edu.ups.farmacia.modelo.Sucursal;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
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
    private List<Producto> list = new ArrayList<>();
    private int id;
    private String nombreProducto;
    private int stock;
    private double precio;
    private String descripcion;
    private Categoria categoria;

    private Sucursal sucursal;
    private CategoriaBean ct;
    private String nombreCategoria;
    private SucursalBean sb;
    private String nombreSucursal;

    @PostConstruct
    public void init() {
        list = productoFacade.findAll();
    }

    public String add() {
        productoFacade.create(new Producto(id, nombreProducto, stock, precio, descripcion, categoria, sucursal));
        list = productoFacade.findAll();//llamo al findall para que se me actualice la lista
        return null;
    }

    public String add2(String sucursal, String categoria) {
        Categoria c = obtenerCategoriaporNombre(nombreCategoria);
        System.out.println(c.toString());
        Sucursal s = obtenerSucursalporNombre(nombreSucursal);
        System.out.println(s.toString());
        productoFacade.create(new Producto(id, nombreProducto, stock, precio, descripcion, c, s));
        list = productoFacade.findAll();
        return null;
    }

    public String delete(Producto p) {
        productoFacade.remove(p);
        list = productoFacade.findAll();//llamo al findall para que se me actualice la lista
        return null;
    }

    public String edit(Producto p) {
        p.setEditable(true); //habilita la caja
        return null;
    }

    public String save(Producto p) {
        productoFacade.edit(p);
        list = productoFacade.findAll(); //actualizo la lista
        p.setEditable(false); //desabilita la caja
        return null;
    }

    public Producto[] getList() { //este metodo tambien se lo modifica
        return list.toArray(new Producto[0]);// Lo que necesita el JSF dentro del table es un
        //arreglo no una lista por lo que convierto de lista a arreglo
    }                                        //un arreglo de productos

    public Categoria obtenerCategoriaporNombre(String nombreCategoria) {
        List<Categoria> lista = new ArrayList<>();
        lista = categoriaFacade.findAll();

        for (Categoria c : lista) {
            if (c.getNombre().equals(nombreCategoria)) {
                System.out.println("nombre categoria " + c.getNombre());
                return c;

            } else {
                System.out.println("sfdsdfsd" + c.toString());
            }
        }
        System.out.println("==== " + nombreCategoria);
        return null;

    }

    public Sucursal obtenerSucursalporNombre(String nombreSucursal) {
        List<Sucursal> lista = new ArrayList<>();
        lista = sucursalFacade.findAll();

        for (Sucursal s : lista) {
            if (s.getNombreClave().equals(nombreSucursal)) {
                System.out.println("nombre sucursal " + s.getNombreClave());
                return s;

            } else {
                System.out.println("sfdsdfsd" + s.toString());
            }
        }
        System.out.println("==== " + nombreSucursal);
        return null;
    }

    public CategoriaFacade getCategoriaFacade() {
        return categoriaFacade;
    }

    public void setCategoriaFacade(CategoriaFacade categoriaFacade) {
        this.categoriaFacade = categoriaFacade;
    }

    public CategoriaBean getCt() {
        return ct;
    }

    public void setCt(CategoriaBean ct) {
        this.ct = ct;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
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

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
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

    public SucursalBean getSb() {
        return sb;
    }

    public void setSb(SucursalBean sb) {
        this.sb = sb;
    }

    public String getNombreSucursal() {
        return nombreSucursal;
    }

    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }

    public SucursalFacade getSucursalFacade() {
        return sucursalFacade;
    }

    public void setSucursalFacade(SucursalFacade sucursalFacade) {
        this.sucursalFacade = sucursalFacade;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.beans;

import ec.edu.ups.farmacia.controlador.AdministradorFacade;
import ec.edu.ups.farmacia.controlador.CategoriaFacade;
import ec.edu.ups.farmacia.controlador.MenuFacade;
import ec.edu.ups.farmacia.controlador.SucursalFacade;
import ec.edu.ups.farmacia.controlador.UsuarioFacade;
import ec.edu.ups.farmacia.modelo.Administrador;
import ec.edu.ups.farmacia.modelo.Categoria;
import ec.edu.ups.farmacia.modelo.Empleado;
import ec.edu.ups.farmacia.modelo.Entidad;
import ec.edu.ups.farmacia.modelo.Menu;
import ec.edu.ups.farmacia.modelo.Sucursal;
import ec.edu.ups.farmacia.modelo.Usuario;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ASUS_GAMING
 */
@Named
@RequestScoped
public class UsuarioCLave implements Serializable {

    @EJB
    private UsuarioFacade usuarioFacade;
    @EJB
    private SucursalFacade sucursalFacade;
    @EJB
    private CategoriaFacade categoriaFacade;
    @EJB
    private MenuFacade menuFacade;
    @EJB
    private AdministradorFacade administradorFacade;
    private Menu menu;
    private List<Menu> list = new ArrayList<>();
    //  private UsuarioBean usuarioBean = new UsuarioBean();
    //private AdministradorBean administradorBean = new AdministradorBean();
    private Usuario usuario;

    @PostConstruct
    public void init() {
        this.usuario = new Usuario();
        //  this.usuarioBean= new UsuarioBean();
        list = menuFacade.findAll();
        if (list.isEmpty()) {
            Menu m1 = new Menu(1, "Cliente", "S", "ADMINISTRADOR", "/", null);
            menuFacade.create(m1);
            menuFacade.create(new Menu(2, "Nuevo Cliente", "I", "ADMINISTRADOR", "/Sistema_Farmacia/vista/cliente/cliente.xhtml", m1));
            menuFacade.create(new Menu(3, "Listar Cliente", "I", "ADMINISTRADOR", "/Sistema_Farmacia/vista/cliente/listCliente.xhtml", m1));
            Menu m4 = new Menu(4, "Empleado", "S", "ADMINISTRADOR", "/", null);
            menuFacade.create(m4);
            menuFacade.create(new Menu(5, "Nuevo Empleado", "I", "ADMINISTRADOR", "/Sistema_Farmacia/vista/empleado/empleado.xhtml", m4));
            menuFacade.create(new Menu(6, "Listar Empleado", "I", "ADMINISTRADOR", "/Sistema_Farmacia/vista/empleado/listEmpleado.xhtml", m4));
            Menu m7 = new Menu(7, "Sucursal", "S", "ADMINISTRADOR", "/", null);
            menuFacade.create(m7);
            menuFacade.create(new Menu(8, "Nuevo Sucursal", "I", "ADMINISTRADOR", "/Sistema_Farmacia/vista/sucursal/sucursal.xhtml", m7));
            menuFacade.create(new Menu(9, "Listar Sucursal", "I", "ADMINISTRADOR", "/Sistema_Farmacia/vista/sucursal/listSucursal.xhtml", m7));
            Menu m10 = new Menu(10, "Productos", "S", "ADMINISTRADOR", "/", null);
            menuFacade.create(m10);
            menuFacade.create(new Menu(11, "Nuevo Producto", "I", "ADMINISTRADOR", "/Sistema_Farmacia/vista/producto/producto.xhtml", m10));
            menuFacade.create(new Menu(12, "Nueva Categoria", "I", "ADMINISTRADOR", "/Sistema_Farmacia/vista/categoria/categoria.xhtml", m10));
            menuFacade.create(new Menu(13, "Listar Producto", "I", "ADMINISTRADOR", "/Sistema_Farmacia/vista/producto/listProducto.xhtml", m10));
            menuFacade.create(new Menu(14, "Listar Categoria", "I", "ADMINISTRADOR", "/Sistema_Farmacia/vista/categoria/listCategoria.xhtml", m10));
            menuFacade.create(new Menu(42, "Ver Kardex", "I", "ADMINISTRADOR", "/Sistema_Farmacia/vista/kardex/listKardex.xhtml", m10));
            Menu m15 = new Menu(15, "Facturas", "S", "ADMINISTRADOR", "/", null);
            menuFacade.create(m15);
            menuFacade.create(new Menu(16, "Nueva Factura de Compra", "I", "ADMINISTRADOR", "/Sistema_Farmacia/vista/factura/facturaCompra.xhtml", m15));
            menuFacade.create(new Menu(17, "Listar Facturas  de Compra", "I", "ADMINISTRADOR", "/Sistema_Farmacia/vista/factura/listFactura.xhtml", m15));
            menuFacade.create(new Menu(18, "Nueva  Factura de Venta", "I", "ADMINISTRADOR", "/Sistema_Farmacia/vista/factura/facturaVenta.xhtml", m15));
            menuFacade.create(new Menu(19, "Listar Factura de Venta", "I", "ADMINISTRADOR", "/Sistema_Farmacia/vista/factura/listFactura.xhtml", m15));
            Menu m20 = new Menu(20, "Administrador", "S", "ADMINISTRADOR", "/", null);
            menuFacade.create(m20);
            menuFacade.create(new Menu(21, "Nuevo Administrador", "I", "ADMINISTRADOR", "/Sistema_Farmacia/vista/administrador/administrador.xhtml", m20));
            menuFacade.create(new Menu(22, "Listar Administrador", "I", "ADMINISTRADOR", "/Sistema_Farmacia/vista/administrador/listAdministrador.xhtml", m20));

            Menu m2 = new Menu(23, "Cliente", "S", "EMPLEADO", "/", null);
            menuFacade.create(m2);
            menuFacade.create(new Menu(24, "Nuevo Cliente", "I", "EMPLEADO", "/Sistema_Farmacia/vista/cliente/cliente.xhtml", m2));
            menuFacade.create(new Menu(25, "Listar Cliente", "I", "EMPLEADO", "/Sistema_Farmacia/vista/cliente/listCliente.xhtml", m2));
            Menu m6 = new Menu(26, "Productos", "S", "EMPLEADO", "/", null);
            menuFacade.create(m6);
            menuFacade.create(new Menu(27, "Nuevo Producto", "I", "EMPLEADO", "/Sistema_Farmacia/vista/producto/producto.xhtml", m6));
            menuFacade.create(new Menu(28, "Nueva Categoria", "I", "EMPLEADO", "/Sistema_Farmacia/vista/categoria/categoria.xhtml", m6));
            menuFacade.create(new Menu(29, "Listar Producto", "I", "EMPLEADO", "/Sistema_Farmacia/vista/producto/listProductos.xhtml", m6));
            menuFacade.create(new Menu(30, "Listar Categoria", "I", "EMPLEADO", "/Sistema_Farmacia/vista/categoria/listCategoria.xhtml", m6));
            menuFacade.create(new Menu(43, "Ver Kardex", "I", "EMPLEADO", "/Sistema_Farmacia/vista/kardex/listKardex.xhtml", m6));
            Menu m8 = new Menu(31, "Facturas", "S", "EMPLEADO", "/", null);
            menuFacade.create(m8);
            menuFacade.create(new Menu(32, "Nueva Factura  de Compra", "I", "EMPLEADO", "/Sistema_Farmacia/vista/factura/facturaCompra.xhtml", m8));
            menuFacade.create(new Menu(33, "Listar Facturas  de Compra", "I", "EMPLEADO", "/Sistema_Farmacia/vista/factura/listFactura.xhtml", m8));
            menuFacade.create(new Menu(34, "Nueva  Factura de  Venta", "I", "EMPLEADO", "/Sistema_Farmacia/vista/factura/facturaVenta.xhtml", m8));
            menuFacade.create(new Menu(35, "Listar Facturas deVenta", "I", "EMPLEADO", "/Sistema_Farmacia/vista/factura/listFactura.xhtml", m8));

            Menu m9 = new Menu(36, "Proveedor", "S", "ADMINISTRADOR", "/", null);
            menuFacade.create(m9);
            menuFacade.create(new Menu(37, "Nuevo Proveedor", "I", "ADMINISTRADOR", "/Sistema_Farmacia/vista/proveedor/proveedor.xhtml", m9));
            menuFacade.create(new Menu(38, "Listar Proveedor", "I", "ADMINISTRADOR", "/Sistema_Farmacia/vista/proveedor/listProveedor.xhtml", m9));
            Menu m11 = new Menu(39, "Proveedor", "S", "EMPLEADO", "/", null);
            menuFacade.create(m11);
            menuFacade.create(new Menu(40, "Nuevo Proveedor", "I", "EMPLEADO", "/Sistema_Farmacia/vista/proveedor/proveedor.xhtml", m11));
            menuFacade.create(new Menu(41, "Listar Proveedor", "I", "EMPLEADO", "/Sistema_Farmacia/vista/proveedor/listProveedor.xhtml", m11));

            Menu m12 = new Menu(50, "Pedidos", "S", "EMPLEADO", "/", null);
            menuFacade.create(m12);
            menuFacade.create(new Menu(51, "Listar Pedidos", "I", "EMPLEADO", "/Sistema_Farmacia/vista/pedido/listPedido.xhtml", m12));
            Menu m13 = new Menu(52, "Pedidos", "S", "ADMINISTRADOR", "/", null);
            menuFacade.create(m13);
            menuFacade.create(new Menu(53, "Listar Pedidos", "I", "ADMINISTRADOR", "/Sistema_Farmacia/vista/pedido/listPedido.xhtml", m13));

            // usuarioBean.addAdminisrador("1400", "NOMBRE", "APELLIDO", "m@gmail.com", "direccion 1", "1234567890", "ADMIN", "1");
            usuarioFacade.create(new Usuario(0, "TUTU", "1592", "ADMINISTRADOR", new Administrador(0, "0106256027", "Edwin", "Angamarca", "eangamarcaz@est.ups.edu.ec", "Gualaceo", "0999862100")));

            usuarioFacade.create(new Usuario(0, "TONNY", "4050", "ADMINISTRADOR", new Administrador(0, "0105723605", "Tonny", "Lema", "tlemaj1@est.ups.edu.ec", "Cuenca", "0969417469")));
            usuarioFacade.create(new Usuario(0, "ADRY", "ADRY", "ADMINISTRADOR", new Administrador(0, "0106487846", "Adrian", "Cabrera", "lcabrerab@est.ups.edu.ec", "Cuenca", "099338001")));
            categoriaFacade.create(new Categoria(0, "Higiene bucal"));
            categoriaFacade.create(new Categoria(1, "Dermocosmética"));
            categoriaFacade.create(new Categoria(2, "Cuidado corporal"));
            categoriaFacade.create(new Categoria(3, "Cuidados 3º edad y vitaminas"));
            categoriaFacade.create(new Categoria(4, "Medicamentos"));
            categoriaFacade.create(new Categoria(5, "Dietéticos y edulcorantes"));
            sucursalFacade.create(new Sucursal(0, "Av Gil Ramirez Davalos", "Matriz", "18924025", -2.891158, -78.984039));
            sucursalFacade.create(new Sucursal(1, "Adolfo Torres", "Bodega 27 de Febrero", "07592451", -2.913790, -79.022245));
            sucursalFacade.create(new Sucursal(2, "Calle Vieja y Ellia Liut", "FarmaUPS", "07982412", -2.879141, -78.989935));

//            Date fecha = new Date(122, 4, 1);
//            Date fecha2 = new Date(115, 9, 20);
// 
//            usuarioFacade.create(new Usuario(4, "elliot", "elliot", "EMPLEADO", new Empleado(1, "404", "Elliot", "Wellick", "elliot@hotmail.com", "Cuenca", "40451", fecha, "Despachador", 1550, new Sucursal(1, "Av. de las Américas", "Matriz Feria Libre", "2945172", 1925, 5224))));
//            usuarioFacade.create(new Usuario(5, "gabo", "gabo", "EMPLEADO", new Empleado(2, "985442", "Gabriel", "Leon", "gleon@hotmail.com", "Cuenca", "5574122495", fecha2, "Inspector", 3550, new Sucursal(2, "Av. Solano", "Sucursal Solano", "452122", 1920, 5220))));
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String iniciarSesion() {
        Usuario us;
        String redireccion = null;
        System.out.println(this.usuario.getUsuario());
        try {
            us = usuarioFacade.iniciarUsuario(usuario);
            if (us != null) {
                //Almacenar en la sesion de JSF
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", us);// (put) con esto hago un seguimiento de la sesion iniciada
                redireccion = "cliente/cliente?faces-redirect=true";
                //return "http://localhost:8080/Sistema_Farmacia/vista/cliente/Cliente.xhtml";
            } else {
                System.out.println("Entro mal");
            }

        } catch (Exception e) {
        }
        return redireccion;
    }

}

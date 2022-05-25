/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.beans;

import ec.edu.ups.farmacia.controlador.MenuFacade;
import ec.edu.ups.farmacia.controlador.UsuarioFacade;
import ec.edu.ups.farmacia.modelo.Menu;
import ec.edu.ups.farmacia.modelo.Usuario;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
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
    private MenuFacade menuFacade;
    private Menu menu;
    private List<Menu> list = new ArrayList<>();
    private Usuario usuario;

    @PostConstruct
    public void init() {
        this.usuario = new Usuario();
        list = menuFacade.findAll();
        if (list.isEmpty()) {
            Menu m1 = new Menu(1, "Cliente", "S", "ADMINISTRADOR", "/", null);
            menuFacade.create(m1);
            menuFacade.create(new Menu(2, "Nuevo Cliente", "I", "ADMINISTRADOR", "/Sistema_Farmacia/vista/cliente/Cliente.xhtml", m1));
            menuFacade.create(new Menu(3, "Lista Cliente", "I", "ADMINISTRADOR", "/Sistema_Farmacia/vista/cliente/listCliente.xhtmll", m1));
            Menu m4 = new Menu(4, "Empleado", "S", "ADMINISTRADOR", "/", null);
            menuFacade.create(m4);
            menuFacade.create(new Menu(5, "Nuevo Empleado", "I", "ADMINISTRADOR", "/Sistema_Farmacia/vista/empleado/empleado.xhtml", m4));
            menuFacade.create(new Menu(6, "Listar Empleado", "I", "ADMINISTRADOR", "/Sistema_Farmacia/vista/empleado/listEmpleado.xhtml", m4));
            Menu m7 = new Menu(7, "Sucursal", "S", "ADMINISTRADOR", "/", null);
            menuFacade.create(m7);
            menuFacade.create(new Menu(8, "Nuevo Sucursal", "I", "ADMINISTRADOR", "/Sistema_Farmacia/vista/sucursal/Sucursal.xhtml", m7));
            menuFacade.create(new Menu(9, "Listar Sucursal", "I", "ADMINISTRADOR", "/Sistema_Farmacia/vista/sucursal/listSucursal.xhtml", m7));
            Menu m10 = new Menu(10, "Productos", "S", "ADMINISTRADOR", "/", null);
            menuFacade.create(m10);
            menuFacade.create(new Menu(11, "Nuevo Producto", "I", "ADMINISTRADOR", "/Sistema_Farmacia/vista/producto/producto.xhtml", m10));
            menuFacade.create(new Menu(12, "Nueva Categoria", "I", "ADMINISTRADOR", "/Sistema_Farmacia/vista/categoria/categoria.xhtml", m10));
            menuFacade.create(new Menu(13, "Listar Producto", "I", "ADMINISTRADOR", "//Sistema_Farmacia/vista/producto/listProducto.xhtml", m10));
            menuFacade.create(new Menu(14, "Listar Categoria", "I", "ADMINISTRADOR", "/Sistema_Farmacia/vista/categoria/listCategoria.xhtml", m10));
            Menu m15 = new Menu(15, "Facturas", "S", "ADMINISTRADOR", "/", null);
            menuFacade.create(m15);
            menuFacade.create(new Menu(16, "Nuevo Factura Compra", "I", "ADMINISTRADOR", "/", m15));
            menuFacade.create(new Menu(17, "Listar Facturas Compra", "I", "ADMINISTRADOR", "/", m15));
            menuFacade.create(new Menu(18, "Nuevo Factura Venta", "I", "ADMINISTRADOR", "/", m15));
            menuFacade.create(new Menu(19, "Listar Factura Venta", "I", "ADMINISTRADOR", "/", m15));
            Menu m20 = new Menu(20, "Administrador", "S", "ADMINISTRADOR", "/", null);
            menuFacade.create(m20);
            menuFacade.create(new Menu(21, "Nuevo Administrador", "I", "ADMINISTRADOR", "/Sistema_Farmacia/vista/administrador/Administrador.xhtml", m20));
            menuFacade.create(new Menu(22, "Listar Administrador", "I", "ADMINISTRADOR", "/Sistema_Farmacia/vista/administrador/listAdministrador.xhtml", m20));

            Menu m2 = new Menu(23, "Cliente", "S", "EMPLEADO", "/", null);
            menuFacade.create(m2);
            menuFacade.create(new Menu(24, "Nuevo Cliente", "I", "EMPLEADO", "/Sistema_Farmacia/vista/cliente/Cliente.xhtml", m2));
            menuFacade.create(new Menu(25, "Lista Cliente", "I", "EMPLEADO", "/Sistema_Farmacia/vista/cliente/listCliente.xhtmll", m2));
            Menu m6 = new Menu(26, "Productos", "S", "EMPLEADO", "/", null);
            menuFacade.create(m6);
            menuFacade.create(new Menu(27, "Nuevo Producto", "I", "EMPLEADO", "/Sistema_Farmacia/vista/producto/producto.xhtml", m6));
            menuFacade.create(new Menu(28, "Nueva Categoria", "I", "EMPLEADO", "/Sistema_Farmacia/vista/categoria/categoria.xhtml", m6));
            menuFacade.create(new Menu(29, "Listar Producto", "I", "EMPLEADO", "//Sistema_Farmacia/vista/producto/listProducto.xhtml", m6));
            menuFacade.create(new Menu(30, "Listar Categoria", "I", "EMPLEADO", "/Sistema_Farmacia/vista/categoria/listCategoria.xhtml", m6));
            Menu m8 = new Menu(31, "Facturas", "S", "EMPLEADO", "/", null);
            menuFacade.create(m8);
            menuFacade.create(new Menu(32, "Nuevo Factura Compra", "I", "EMPLEADO", "/", m8));
            menuFacade.create(new Menu(33, "Listar Facturas Compra", "I", "EMPLEADO", "/", m8));
            menuFacade.create(new Menu(34, "Nuevo Factura Venta", "I", "EMPLEADO", "/", m8));
            menuFacade.create(new Menu(35, "Listar Factura Venta", "I", "EMPLEADO", "/", m8));

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
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", us);
                redireccion = "administrador/Administrador?faces-redirect=true";
                //return "http://localhost:8080/Sistema_Farmacia/vista/cliente/Cliente.xhtml";
            } else {
                System.out.println("Entro mal");
            }

        } catch (Exception e) {
        }
        return redireccion;
    }

}

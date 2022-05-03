package ec.edu.ups.farmacia.resources;

import ec.edu.ups.farmacia.controlador.AdministradorFacade;
import ec.edu.ups.farmacia.controlador.CabeceraVentaFacade;
import ec.edu.ups.farmacia.controlador.CategoriaFacade;
import ec.edu.ups.farmacia.controlador.ClienteFacade;
import ec.edu.ups.farmacia.controlador.DetalleFacade;
import ec.edu.ups.farmacia.controlador.EmpleadoFacade;
import ec.edu.ups.farmacia.controlador.FormaPagoFacade;
import ec.edu.ups.farmacia.controlador.KardexFacade;
import ec.edu.ups.farmacia.controlador.PedidoFacade;
import ec.edu.ups.farmacia.controlador.ProductoFacade;
import ec.edu.ups.farmacia.controlador.ProveedorFacade;
import ec.edu.ups.farmacia.controlador.SucursalFacade;
import ec.edu.ups.farmacia.controlador.UsuarioFacade;
import ec.edu.ups.farmacia.modelo.Administrador;
import ec.edu.ups.farmacia.modelo.CabeceraVenta;
import ec.edu.ups.farmacia.modelo.Categoria;
import ec.edu.ups.farmacia.modelo.Cliente;
import ec.edu.ups.farmacia.modelo.Detalle;
import ec.edu.ups.farmacia.modelo.Empleado;
import ec.edu.ups.farmacia.modelo.EstadoPedido;
import ec.edu.ups.farmacia.modelo.FormaPago;
import ec.edu.ups.farmacia.modelo.Kardex;
import ec.edu.ups.farmacia.modelo.Pedido;
import ec.edu.ups.farmacia.modelo.Producto;
import ec.edu.ups.farmacia.modelo.Proveedor;
import ec.edu.ups.farmacia.modelo.Rol;
import ec.edu.ups.farmacia.modelo.Sucursal;
import ec.edu.ups.farmacia.modelo.TipoPago;
import ec.edu.ups.farmacia.modelo.Usuario;
import jakarta.ejb.EJB;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author
 */
@Path("jakartaee9")
public class JakartaEE9Resource {

    @EJB
    private ClienteFacade ejbCliente;
    @EJB
    private SucursalFacade ejbSucusal;
    @EJB
    private AdministradorFacade ejbAdministrador;
    @EJB
    private EmpleadoFacade ejbEmpleado;
    @EJB
    private CategoriaFacade ejbCategoria;
    @EJB
    private ProductoFacade ejbProducto;
    @EJB
    private ProveedorFacade ejbProveedor;
    @EJB
    private PedidoFacade ejbPedidoFacade;
    @EJB
    private UsuarioFacade ejbUsuario;
    @EJB
    private FormaPagoFacade ejFormaPagoFacade;
    @EJB
    private KardexFacade ejKardexFacade;
    @EJB
    private DetalleFacade ejbDetalle;
    @EJB
    private CabeceraVentaFacade ejbCabeceraVenta;

    //
    @GET
    public Response ping() {

        Administrador a = new Administrador(0, "0106256027", "Adrian", "Angamarca", "edwinz-2@outtlook.com", "Gualacceo", "099862100");
        ejbAdministrador.create(a);
        Sucursal s = new Sucursal(0, "Cuenca", "Principal", "2255485", 1920, 300);
        ejbSucusal.create(s);
        Cliente c = new Cliente(new GregorianCalendar(1987, 0, 31), 0, "0106256035", "Edward", "Angamarca", "e@hotmail.com", "Gualaceo", "0987654321");
        Cliente c1 = new Cliente(new GregorianCalendar(1993, 6, 7), 0, "14007897221", "Miguel", "Samaniego", "m@gmail.com", "Sucua", "0986832324");
        ejbCliente.create(c);
        ejbCliente.create(c1);
        Empleado e = new Empleado(new GregorianCalendar(1987, 0, 31), "1", 500, s, 0, "0101967016", "Luis", "P", "lp@gmail.com", "Gualaceo", "0987644321");
        ejbEmpleado.create(e);
        Categoria ca = new Categoria(1, "Cola");
        ejbCategoria.create(ca);
        Proveedor po = new Proveedor(ca, 0, "010000", "123", "pepito@", "Tecnico 123", "123456789");
        ejbProveedor.create(po);
        Producto pr = new Producto(1, "COLA 50", 5, 10.0, "50 ML", ca, s);
        ejbProducto.create(pr);
        Usuario u = new Usuario(1, "123", Rol.ADMINISTRADOR, a);
        ejbUsuario.create(u);
        Pedido p = new Pedido(1, null, 10.0, 15.0, EstadoPedido.ACEPTADO, null, 15.0, null, null);
        ejbPedidoFacade.create(p);
        FormaPago f = new FormaPago(1, TipoPago.TARJETA_DEBITO, "Adrian Cabrera", "8978923", 15.0, 5);
        ejFormaPagoFacade.create(f);
        Kardex k = new Kardex(1, null, null, 25.0);
        ejKardexFacade.create(k);
        CabeceraVenta cv = new CabeceraVenta(1, new GregorianCalendar(2022, 0, 20), 0, 0, true);
        ejbCabeceraVenta.create(cv);
        Detalle d1 = new Detalle(1, null, 0, 2.2, 6.6, null);
        ejbDetalle.create(d1);
        Cliente c2 = ejbCliente.getClienteById(3);
        System.out.println(c2);

        List<Cliente> cli = ejbCliente.getClientesByLevel(1);
        for (Cliente cliente : cli) {
            System.out.println(cliente);
        }
        
        
         System.out.println("Üsuarios consulta dificil");
        List<Cliente> dif = ejbCliente.consuntaDos("Miguel", 0);
        for (Cliente re : dif) {
           System.out.println("Lista: "+re);
        }
        return Response
                .ok("ping Jakarta EE Farmacia FarmaSama")
                .build();
    }
}

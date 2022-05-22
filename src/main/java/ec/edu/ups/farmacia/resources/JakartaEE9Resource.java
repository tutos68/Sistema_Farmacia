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
import ec.edu.ups.farmacia.modelo.Sucursal;
import jakarta.ejb.EJB;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

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

        Sucursal s = new Sucursal(0, "Cuenca", "Principal", "2255485", 1920, 300);
        ejbSucusal.create(s);

        return Response
                .ok("ping Jakarta EE Farmacia FarmaSama")
                .build();
    }
}

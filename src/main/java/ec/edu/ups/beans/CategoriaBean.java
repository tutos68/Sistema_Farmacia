package ec.edu.ups.beans;

import ec.edu.ups.farmacia.controlador.CategoriaFacade;
import ec.edu.ups.farmacia.modelo.Categoria;
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
public class CategoriaBean implements Serializable {

    private static final long serialVersionUID = 1L;
    @EJB
    private CategoriaFacade categoriaFacade;//mando mi fachada
    private List<Categoria> list = new ArrayList<>();// lista de Categorias , se usa el List por el findAll()
    private int id;
    private String nombre;

    @PostConstruct//Esto es una notacion de EJB que nos dice que
    public void init() {//este metodo init se va a ejecutar despues 
        list = categoriaFacade.findAll();//de que se ha creado o visualizado el JSF o el bean
    }                                    // esto se lo hace ya que puede que no se haya renderizado toda la vista y ya quiera llamar a buscar la info

    public String add() {
        categoriaFacade.create(new Categoria(id, nombre));
        list = categoriaFacade.findAll();//llamo al findall para que se me actualice la lista
        this.limpiar();
        return null;
    }

    public String delete(Categoria c) {
        categoriaFacade.remove(c);
        list = categoriaFacade.findAll();
        return null;
    }

    public void edit(Categoria c) {
        categoriaFacade.edit(c);
        c.setEditable(true); //habilita la caja
        list = categoriaFacade.findAll();//actualizo la lista
      
    }

    public String save(Categoria c) {
        categoriaFacade.edit(c);
        list = categoriaFacade.findAll(); //actualizo la lista
        c.setEditable(false); //desabilita la caja
        return null;
    }

    public void limpiar() {
        this.nombre = "";
    }

    public CategoriaFacade getCategoriaFacade() {
        return categoriaFacade;
    }

    public void setCategoriaFacade(CategoriaFacade categoriaFacade) {
        this.categoriaFacade = categoriaFacade;
    }

    public List<Categoria> getList() {
        return list;
    }

//    public Categoria[] getList() { //este metodo tambien se lo modifica
//        return list.toArray(new Categoria[0]);// Lo que necesita el JSF dentro del table es un
//                                              //arreglo no una lista por lo que convierto de lista a arreglo
//    }                                         //un arreglo de categorias //un arreglo de categorias 
    public List<String> categoriaNombre() {
        List<String> listaNombres = new ArrayList<>();
        String n;
        for (Categoria c : list) {
            n = c.getNombre();
            listaNombres.add(n);
        }

        return listaNombres;
    }

    public void setList(List<Categoria> list) {
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

}


package estructura.enlazada;

/**
 *
 * @author guardati
 */
public class ExcepcionColeccionVacia extends RuntimeException{
    
    public ExcepcionColeccionVacia(){
        super("¡Colección vacía!");
    }
    
    public ExcepcionColeccionVacia(String mensaje){
        super(mensaje);
    }
    
}

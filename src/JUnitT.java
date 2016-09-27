import static org.junit.Assert.*;

import org.junit.Test;


/**
 * @author Hugo Elvira 15249, Andrea Pena 15127, Jose Tzoc 13322
 * @descripcion: implementacion del un arbol binario
 * @ codigo tomado de ejemplos del libro
 */

public class JUnitT  {
	Traductor t=new Traductor();
    @Test
    public void testInsertarNodo() {
    	t.Anadir_a_Diccionario(); //Aqui se prueba la insercion de nodo porque el metodo anadir_a_dicccionario llama al mismo y le manda los parametros requeridos
    }

    /**
     * Test of traducirPalabra method, of class Diccionario.
     */
    @Test
    public void testTraducirPalabra() {
    	String x=t.OracionTraducida();
    	
}
}

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
    	
    	t.Anadir_a_Diccionario();
        System.out.println("insertarNodo");
        ArbolBinario<Asociacion<String, String>> padre = null;
        Asociacion<String, String> dato = null;
        Traductor instance = new Traductor();
        instance.insertarNodo(padre, dato);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of traducirPalabra method, of class Diccionario.
     */
    @Test
    public void testTraducirPalabra() {
    	t.Anadir_a_Diccionario();
        System.out.println("traducirPalabra");
        ArbolBinario<Asociacion<String, String>> padre = null;
        String palabra = " ";
        Traductor instance = new Traductor();
        String expResult = "";
        String result = instance.traducirPalabra(padre, palabra);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
	
	
}

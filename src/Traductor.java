import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Hugo Elvira 15249, Andrea Pena 15127, Jose Tzoc 13322
 * @descripcion: contiene los metodos que ayudan a leer oraciones en ingles y traducirlas al español
 */
public class Traductor {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        ArbolBinario<Asociacion<String,String>>raiz;
        ArrayList <String> oracion = new ArrayList<String>();
    
     // constructor
    public Traductor(){
        raiz=new ArbolBinario<Asociacion<String,String>>(null, null, null, null);
        Anadir_a_Diccionario();
    }
    
   //Se añaden todas las palabras en la quasi base de datos DB_Palabras las cuales serviran para poder traducior la oracion contenida en Oracion.txt
    public void Anadir_a_Diccionario(){
        ArrayList<String> palabra= new ArrayList<String>();
        ArrayList<Asociacion<String,String> >asociaciones= new ArrayList<Asociacion<String,String>>();
        try {
        	//Codigo tomado de hoja 4 donde se utilizo el leer archivo para la implemtacion de Postfix
           archivo = new File ("Diccionario.txt");
           fr = new FileReader (archivo);
           br = new BufferedReader(fr);

           String linea;
           
           while((linea=br.readLine())!=null){
              palabra.add(linea);
           }
        }
        catch(Exception e){
           e.printStackTrace();
        }finally{

           try{                    
              if( null != fr ){   
                 fr.close();     
              }                  
           }catch (Exception e2){ 
              e2.printStackTrace();
           }
        }

        
        
        for(int i=0; i<palabra.size()-1;i++){
               int posicion=palabra.get(i).indexOf(',');
               String palabra_en_ingles=palabra.get(i).substring(0,posicion);
               String palabra_en_espanol=palabra.get(i).substring(posicion+1,palabra.get(i).length());
               asociaciones.add(new Asociacion(palabra_en_ingles, palabra_en_espanol));
        }
        
        raiz.setValue(asociaciones.get(0)); //se insertan segun orden correcto
        for (int i=1; i<asociaciones.size(); i++){
            insertarNodo(raiz, asociaciones.get(i));
        }
     }
    
    
    
    //Ejemplo de insertar tomado de internet con fines educativos
    public void insertarNodo(ArbolBinario<Asociacion<String,String>> padre, Asociacion<String,String> dato){
       
    	Asociacion<String,String> asociacion=padre.value();
        String llavePadre=asociacion.getKey();
        String llaveDato=dato.getKey();
        int num=llavePadre.compareToIgnoreCase(llaveDato);
        if(num>0 && padre.left()==null){
            
            padre.setLeft(new ArbolBinario<Asociacion<String,String>>(null, null, null,null));
            padre.left().setValue(dato);
        }else if(padre.left()!=null){
            
            insertarNodo(padre.left(),dato);
        }
        
        if(num<0 && padre.right()==null){
            
            padre.setRight(new ArbolBinario<Asociacion<String,String>>(null, null, null,null));
            padre.right().setValue(dato);
        }else if(padre.right()!=null){
            
            insertarNodo(padre.right(),dato);
        }
    }
    //fin del ejemplo  
    
    
    //compara cada palabra del texto con las almacenadas en el arbol y la traduce
    //devuelve:
    //*palabra* si no encuentra la palabra en el diccionario
    //palabra traducida si encontro coincidencias
    public String traducirPalabra(ArbolBinario<Asociacion<String,String>> padre, String palabra){
    	
	String traduccion = "";
	Asociacion<String,String> asociacion=padre.value();
       	String KeyPadre=asociacion.getKey();

	int num=KeyPadre.compareToIgnoreCase(palabra);
	if(num==0){
		traduccion=padre.value().getValue();
	}
	if(num<0){
            if(padre.right()!=null){
            	traduccion=traducirPalabra(padre.right(),palabra);
            }else{
                return ("*"+palabra+"*");
            }
	}
	if(num>0){
            if(padre.left()!=null){
            	traduccion=traducirPalabra(padre.left(),palabra);
            }else{
                    return ("*"+palabra+"*"); // las palabras que no esten en la base de datos no prodran ser traducidas y apareceran encerradas entre asteriscos
            }
		
	}

	return traduccion;
    }

     //Codigo tomado de hoja 4 donde se utilizo el leer archivo para la implemtacion de Postfix
     private void leerOracion(){
	String palabras="";
        try {
           archivo = new File ("texto.txt");
           fr = new FileReader (archivo);
           br = new BufferedReader(fr);
           String linea;
           
           while((linea=br.readLine())!=null){
              	palabras=linea;
           }
        }
        catch(Exception e){
           e.printStackTrace();
        }finally{
        	
           try{                    
              if( null != fr ){   
                 fr.close();     
              }                  
           }catch (Exception e2){ 
              e2.printStackTrace();
           }
        }


    // permite quitar los espacios del archivo de texto y asi leer cada palabra
	while(palabras.compareTo("")!=0){
	int lugar=palabras.indexOf(' ');
            if(lugar!=-1){
                    oracion.add(palabras.substring(0,lugar));
                    palabras=palabras.substring(lugar+1);
            }else{
                    oracion.add(palabras);
                    palabras="";
            }
        }
     }
     
     
     
     
     //concatena cada palabra traducida hasta formar la oracion completa y la retorna para imprimirla en el main
    public String OracionTraducida(){
        leerOracion();
        String oracion_traducida="";
        for(int i=0; i<oracion.size(); i++){
        	oracion_traducida+=traducirPalabra(raiz, oracion.get(i).trim())+" ";
        }
        return oracion_traducida;
    }



}


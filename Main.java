import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	
	public static void main(String[] args)
	{
		
	}

	public static String LeerArchivo(String direccion) {
        // Leer una linea a la vez 
        String line = null;

        try {
            // FileReader lee el texto 
            FileReader fileReader = new FileReader(direccion);

            BufferedReader bufferedReader =  new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                return line;
            }   

            // Cerrar el texto 
            bufferedReader.close();         
        }
        //Si no logra abir el archivo mandar un mensaje 
        catch(IOException ex) {
            System.out.println("No se pudo leer el archivo '" + direccion + "'");                  
        
        }
        return line;
       
    }
}

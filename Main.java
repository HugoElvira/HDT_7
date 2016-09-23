import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args)
	{
		Diccionario diccionario= new Diccionario();
		Palabra<String, String> palabra= new Palabra<String,String>();
		String vector= readFile("diccionario.txt");
		System.out.println(vector);
		String wordS="";
		String wordE="";
		char[] cadena= vector.toCharArray();
		int r=0;
		for (char i: cadena)
		{
			if (i!='(')
			{
				if (i!=','&& r==0)
				{
					wordE= wordE+i;
					System.out.println("WordE:"+ wordE);
				}
				if (i==',')
				{
					palabra.setKey(wordE);
					//wordE="";
					r=1;
				}
				if (i!=','&& r==1)
				{
					if(i!= ')')
					{
						wordS=wordS+i;
						System.out.println("WordS:"+ wordS);
					}
				}
				if (i==')')
				{
					palabra.setValue(wordS);
					diccionario.addPalabra(palabra);
					System.out.println(palabra.toString());
					wordS="";
					wordE="";
					r=0;
				} 
				/*if (i=='\n')
				{
					diccionario.addPalabra(palabra);
					System.out.println("Añadida a diccionario"+palabra.toString());
				}*/
			}
				
		}
		
	}
	
	public static String leerArchivo(String direccionx) {
		String operaciones=null;
		try {
			FileInputStream dirtxt;
			String path = new java.io.File(".").getCanonicalPath();
			path = path + "\\"+ direccionx;
			dirtxt = new FileInputStream(path);
			DataInputStream lineas = new DataInputStream(dirtxt);
			BufferedReader memoriabuf = new BufferedReader(new InputStreamReader(lineas));
			operaciones=memoriabuf.readLine();
			lineas.close();
		}catch(Exception e){
			System.err.println("Error Fatal");
			
		}
		return operaciones;
		
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
	
	private static String readFile(String fileName) {
		String str="";
	       try {
	         File file = new File(fileName);
	         Scanner scanner = new Scanner(file);
	         while (scanner.hasNextLine()) {
	        	 str=str+scanner.nextLine();
	           //System.out.println(scanner.nextLine());
	         }
	         scanner.close();
	       } catch (FileNotFoundException e) {
	         e.printStackTrace();
	       }
	      return str;
	     }
}

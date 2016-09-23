import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class Diccionario extends BinarySearchTree<String>{
	
	BinarySearchTree<Palabra> tree= new BinarySearchTree<Palabra>();
	
	/*public Diccionario(String palabras)
	{
		tree=null;
	}*/
	
	public void addPalabra(Palabra p)
	{
		tree.add(p);
	}
	
	
	public String toString()
	{
		String s="";
		return s;
	}
}

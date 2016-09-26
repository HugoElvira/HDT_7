import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class Diccionario extends BST<Palabra<String,String>>/*BinarySearchTree<String>*/{
	
	//BinarySearchTree<Palabra> tree= new BinarySearchTree<Palabra>();
	BST<Palabra<String,String>> tree= new BST<Palabra<String,String>>();
	int cantPalabras=0;
	
	/*public Diccionario(String palabras)
	{
		tree=null;
	}*/
	
	public void addPalabra(Palabra<String,String> p)
	{
		cantPalabras++;
		tree.insert(p);
	}
	
	
	public String toString()
	{
		return tree.toString();
	}


	public BST<Palabra<String, String>> getTree() {
		return tree;
	}


	public void setTree(BST<Palabra<String, String>> tree) {
		this.tree = tree;
	}
	
	
}

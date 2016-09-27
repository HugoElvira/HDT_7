/**
 * 
 */

/**
 * @author Hugo Elvira 15249, Andrea Pena 15127, Jose Tzoc  13322
 * @descripcion: implementacion del un arbol binario
 * @ codigo tomado de ejemplos del libro
 */
public class ArbolBinario<E>
{
    protected E val; // value associated with node
    protected ArbolBinario<E> parent; // parent of node
    protected ArbolBinario<E> left, right; // children of node
    
    public ArbolBinario(E value, ArbolBinario<E> left, ArbolBinario<E> right, ArbolBinario<E> parent){
        val=value;
        this.left=left;
        this.right=right;
        this.parent=parent;
    }
    
    public ArbolBinario<E> left()
    // post: returns reference to (possibly empty) left subtree
    // post: returns reference to (possibly empty) left subtree
    {
            return left;
    }

    public ArbolBinario<E> right()
    // post: returns reference to (possibly empty) left subtree
    // post: returns reference to (possibly empty) left subtree
    {
            return right;
    }

    public ArbolBinario<E> parent()
    // post: returns reference to parent node, or null
    {
        return parent;
    }
    
    public void setLeft(ArbolBinario<E> newLeft){
        this.left=newLeft;
    }
    
    public void setRight(ArbolBinario<E> newRight){
        this.right=newRight;
    }
    
    public void setParent(ArbolBinario<E> newParent){
        this.left=newParent;
    }
    
    public E value()
	// post: returns value associated with this node
	{
		return val;
	}
	
	public void setValue(E value)
	// post: sets the value associated with this node
	{
		val = value;
	}
    
}

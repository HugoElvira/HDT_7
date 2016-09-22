//import structure5.*;
import java.util.Comparator;
import java.util.Iterator;
import java.lang.Object;

public class BinarySearchTree<E> {
	
	protected BinaryTree<E> root;
	protected final BinaryTree<E> EMPTY= new BinaryTree<E>();
	protected int count;
	protected Comparator<E> ordering;
	
	public BinarySearchTree()
	{ 
		this(new NaturalComparator<E>());
	}
	public BinarySearchTree(Comparator<E> alternateOrder)
	{
		root= EMPTY;
		count= 0;
		ordering= alternateOrder;
	}
	protected BinaryTree<E> locate(BinaryTree<E> root, E value)
	{
		E rootValue= root.value();
		BinaryTree<E> child;
		
		if (rootValue.equals(value)) 
			return root;
		if (ordering.compare(rootValue,value)<0)
		{
			child= root.right();
		}
		else
		{
			child = root.left();
		}
		if (child.isEmpty())
		{
			return root;
		}
		else
		{
			return locate(child, value);
		}
	}
	
	public boolean contains(E value)
	{
		if(root.isEmpty())
			return false;
		
		BinaryTree<E> possibleLocation= locate(root,value);
		return value.equals(possibleLocation.value());
	}
	
	public void add(E value)
	{
		BinaryTree<E> newNode= new BinaryTree<E>(value, EMPTY, EMPTY);
		
		if(root.isEmpty())
		{
			root= newNode;
		}
		else
		{
			BinaryTree<E> insertLocation= locate(root,value);
			E nodeValue= insertLocation.value();
			if (ordering.compare(nodeValue, value)<0)
			{
				insertLocation.setRight(newNode);
			}
			else
			{
				if(!insertLocation.left().isEmpty())
				{
					predecessor(insertLocation).setRight(newNode);
				}
				else
				{
					insertLocation.setLeft(newNode);
				}
			}
		}
	}
	protected BinaryTree<E> predecessor(BinaryTree<E> root)
	{
		//Assert.pre(!root.isEmpty(), "No predecessor to middle value.");
		//Assert.pre(!root.left().isEmpty(), "Root has left child");
		BinaryTree<E> result= root.left();
		while (!result.right().isEmpty())
		{
			result= result.right();
		}
		return result;
	}
	protected BinaryTree<E> removeTop(BinaryTree<E> topNode)
	{
		BinaryTree<E> left= topNode.left();
		BinaryTree<E> right= topNode.right();
		
		topNode.setLeft(EMPTY);
		topNode.setRight(EMPTY);
		
		if(left.isEmpty())
			return right;
		
		if(right.isEmpty())
			return left;
		
		BinaryTree<E> predecessor= left.right();
		if(predecessor.isEmpty())
		{
			left.setRight(right);
			return left;
		}
		
		BinaryTree<E> parent= left;
		while(!predecessor.right().isEmpty())
		{
			parent= predecessor;
			predecessor= predecessor.right();
		}
		parent.setRight(predecessor.left());
		predecessor.setLeft(left);
		predecessor.setRight(right);
		return predecessor;
		
		/*public Iterator<E> iterator()
		{
			return root.inorderIterator();
		}*/
		
		
	}
}

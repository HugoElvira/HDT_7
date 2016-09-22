import java.util.Comparator;

public class NaturalComparator<T> implements Comparable<T>, Comparator<T> { 
	public int compare(T a, T b) 
	// pre: a, b non-null, and b is same type as a 
	// post: returns value <, ==, > 0 if a <, ==, > b 
	{ return ((Comparable<T>) a).compareTo(b); }
	
	public boolean equals(Object b) 
	// post: returns true if b is a NaturalComparator 
	{ return (b != null) && (b instanceof NaturalComparator); }
	
	protected Comparator<T> base; // comparator whose ordering is reversed

	@Override
	public int compareTo(T arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
}

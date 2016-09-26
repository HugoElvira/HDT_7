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

/*public final class NaturalComparator<E> implements Comparable<T>, Comparator<T> {

	//private static final Comparator<? extends Comparable<?>> instance = new Comparator<Comparable<Object>>(){
		public int compare(Comparable<Object> o1, Comparable<Object> o2) {
			if( o1==null || o2==null ){
				throw new NullPointerException("Comparing null values is not supported!");
			}
			return o1.compareTo(o2);
		}
	}
	
	/*@SuppressWarnings("unchecked")
	public static <T extends Comparable<?>> Comparator<T> getInstance(){
		return (Comparator<T>) instance;
	}*/


public class Palabra<K, V> extends Association<K,V>{
	
	public Palabra()
	{
		new Association<String,String>();
	}
	
	public Palabra(String en, String sp)
	{
		new Association<String, String>(en,sp);
	}

}

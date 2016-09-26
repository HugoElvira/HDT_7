
public class Palabra<K, V> extends Association<K,V> implements Comparable<Palabra<K,V>>{
	
	private String en;
	private String sp;
	
	public Palabra()
	{
		new Association<String,String>(en,sp);
	}
	
	public Palabra(String e, String s)
	{
		new Association<String, String>(e,s);
		en=e;
		sp=s;
	}

	@Override
	public int compareTo(Palabra<K,V> a) {
		// TODO Auto-generated method stub
		/*System.out.println("Metodo compareTo");
		System.out.println(this.getEn());
		System.out.println(a.getEn());*/
		//System.out.println(Integer.compare(this.getEn().hashCode(), a.getEn().hashCode()));
		return Integer.compare(this.getEn().hashCode(), a.getEn().hashCode());
	}

	public String getEn() {
		return en;
	}

	public void setEn(String en) {
		this.en = en;
	}

	public String getSp() {
		return sp;
	}

	public void setSp(String sp) {
		this.sp = sp;
	}
	
}

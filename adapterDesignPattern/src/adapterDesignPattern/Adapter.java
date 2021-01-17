package adapterDesignPattern;

public class Adapter implements Animal {
	
	Sparrow  sparrowName;
	public Adapter(Sparrow  sparrowName)
	{
		this.sparrowName=sparrowName;
	}

	public void runs() {
		sparrowName.flies();
	}

	@Override
	public void size() {
		sparrowName.size();
	}

}

package adapterDesignPattern;

public class Main {

	public static void main(String[] args) {
		System.out.println("The Lion");
		Lion lion=new Lion();
		lion.size();
		lion.runs();
		
		
		System.out.println("The Sparrow");
		Sparrow sparrow=new Sparrow();
		sparrow.size();
		sparrow.flies();
		
		
		System.out.println("The Lion adapted to Sparrow");
		Adapter sparrowLion= new Adapter(sparrow);
		sparrowLion.size();
		sparrowLion.runs();
	}

}

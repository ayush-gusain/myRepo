package hello;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

interface Calculate{
	void func(String s);
}

class Convert implements Runnable
{
	int i;
	ArrayList<String> arr;
	
	public Convert(int i, ArrayList<String> arr)
	{
		this.i=i;
		this.arr=arr;
	}
	
	public void run()
	{
		try
		{
			
			for(int cnt=0;cnt<5;cnt++)
			{
				String s1=arr.get(i+cnt);
				Calculate x=(String s)->{
					int corrInteger=Integer.parseInt(s);
					String hexString=Integer.toHexString(corrInteger);
					
					File newfile=new File("hxxMapFile.txt");
					try {
						FileWriter fr=new FileWriter(newfile,true);
						BufferedWriter br= new BufferedWriter(fr);
						br.write(corrInteger+" = "+hexString);
						br.newLine();
						br.close();
						fr.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					System.out.println("Hex value of "+corrInteger+ " is "+hexString+ " done by "+Thread.currentThread().getName());
				};
				x.func(s1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

public class SampleProblem {
	static final int MAX_T=5;
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		File file=new File("C:\\Users\\ayush.gusain\\Downloads\\prob1.txt");
		
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(file);
		ArrayList<String> arr= new ArrayList<String>();
		while(sc.hasNextLine())
		{
			
			String fromFile=sc.nextLine();
			String trimmedString=fromFile.replaceAll("\\s","");
	
			arr.add(trimmedString);
		}
		int i=0;
		
		ExecutorService pool=Executors.newFixedThreadPool(MAX_T);
		
		while(i<arr.size())
		{
			Runnable r=new Convert(i,arr);
			pool.execute(r);
			i+=5;
		}
		
		pool.shutdown();
		
		
	}

}





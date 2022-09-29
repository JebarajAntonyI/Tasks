package task9;

public class ThreadTask6 extends Thread
{
	private int value = 77;
	public void setValue(int value) 
	{
		this.value = value;
	}
	public void run()
	{
		while(value != 0)
		{
			System.out.println("ExtendedThread is Running.....");
			try 
			{
				Thread.sleep(4000);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			value--;
		}
	}
}

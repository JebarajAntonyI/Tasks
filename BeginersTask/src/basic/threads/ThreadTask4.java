package basic.threads;

public class ThreadTask4 extends Thread
{
	private int sleepTime;
	public ThreadTask4()
	{
		
	}
	
	public ThreadTask4 (String name, int sleepTime)
	{
		this.sleepTime = sleepTime;
		this.setName(name);
	}
	
	public void run()
	{
		System.out.println("Going to Sleep: " + this.getName());
		try
		{
			sleeping(sleepTime);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		System.out.println("After Sleeping: " + this.getName());
	}
	
	public void sleeping (int number) throws InterruptedException
	{
		Thread.sleep(number);
	}
	
}

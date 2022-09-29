package task9;

public class RunnableThread4 implements Runnable
{
	private int sleepTime;
	private String name;
	public RunnableThread4()
	{
		
	}
	
	public RunnableThread4 (String name, int sleepTime)
	{
		this.sleepTime = sleepTime;
		this.name = name;
	}
	
	public void run()
	{
		Thread.currentThread().setName(name);
		System.out.println("Going to Sleep: " + Thread.currentThread().getName());
		try
		{
			sleeping(sleepTime);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		System.out.println("After Sleeping: " + Thread.currentThread().getName());
	}
	
	public void sleeping (int number) throws InterruptedException
	{
		Thread.sleep(number);
	}
}

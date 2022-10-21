package basic.threads;

public class RunnableThread7 implements Runnable
{
	private boolean value = true;
	private int sleepTime = 1000;
	private String name;
	static RunnableThread7 Obj = new RunnableThread7();
	
	public RunnableThread7 ()
	{
	}
	
	public RunnableThread7 (String name)
	{
		this.name = name;
	}
	
	public void setValue(boolean value) 
	{
		this.value = value;
	}
	
	public void setSleepTime(int sleepTime)
	{
		this.sleepTime = sleepTime;
	}
	
	public void run()
	{
		while (value)
		{
			Thread.currentThread().setName(name);
			System.out.println("Runnable Thread: " + Thread.currentThread().getName() + " Running\n");
			try
			{
					Thread.sleep(sleepTime);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		System.out.println("..........Runnable Thread: " + Thread.currentThread().getName() + " Stopped..........\n\n");

	}

}

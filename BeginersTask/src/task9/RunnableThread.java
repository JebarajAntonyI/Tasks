package task9;

public class RunnableThread implements Runnable
{
	public RunnableThread()
	{
		
	}
	
	public void run()
	{
		System.out.println(".....Started.....");
		System.out.println(Thread.currentThread().getName());
		System.out.println(Thread.currentThread().getPriority());
		System.out.println(Thread.currentThread().getState());
	}
	
	
}

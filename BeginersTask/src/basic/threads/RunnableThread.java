package basic.threads;

public class RunnableThread implements Runnable
{
	public RunnableThread()
	{
		
	}
	
	public void run()
	{
		System.out.println(".....Started.....  Name-" + Thread.currentThread().getName() + "  Priority-" + Thread.currentThread().getPriority() + "  State-" + Thread.currentThread().getState() + "\n");
	}
	
	
}

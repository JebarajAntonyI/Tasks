package basic.threads;

public class ThreadTask extends Thread
{
	
	public ThreadTask()
	{
		
	}
	
	public ThreadTask (String name)
	{
		this.setName(name);
	}
	
	public void run()
	{
		System.out.println(".....Started.....  Name-" + this.getName() + "  Priority-" + this.getPriority() + "  State-" + this.getState() + "\n");
	}
	
}

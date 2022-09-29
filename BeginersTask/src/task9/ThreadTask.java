package task9;

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
		System.out.println(".....Started.....");
		System.out.println(this.getName());
		System.out.println(this.getPriority());
		System.out.println(this.getState());
	}
		
//	public void nameSet(ThreadTask obj, String name)
//	{
//		obj.setName(name);
//	}
	
	
}

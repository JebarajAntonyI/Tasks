package task9;

public class ThreadTask7 extends Thread
{
		private boolean value = true;
		private int sleepTime = 1000;
		static ThreadTask7 Obj = new ThreadTask7();
		
		public ThreadTask7 (String name)
		{
			this.setName(name);
		}
		
		public ThreadTask7 ()
		{
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
			while(value)
			{
				System.out.println("Extended Thread: " + this.getName() + " Running\n");
				try
				{
					Thread.sleep(sleepTime);
				} 
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
			System.out.println("..........Extended Thread: " + this.getName() + " Stopped..........\n\n");
		}
		
		public void stoped()
		{
		}

}

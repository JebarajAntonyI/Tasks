package task9;

import java.util.ArrayList;

import java.util.List;

import java.util.Scanner;

public class ThreadRunner 
{
	Scanner scan = new Scanner (System.in);
		
		public int getInt()
		{
			int number = 0;
			boolean value = true;
			while (value)
			{
				if (scan.hasNextInt())
				{
					number = scan.nextInt();
					value = false;
				}
				else
				{
					scan.next();
					System.out.print("Enter value in integer");
					System.out.println();
				}
			}
			return number;
		}
		
		public void printThread(Thread obj)
		{
			System.out.println(obj.getName());
			System.out.println(obj.getPriority());
			System.out.println(obj.getState());
		}

	public static void main(String[] args) throws InterruptedException 
	{
		ThreadRunner get = new ThreadRunner();
//		ThreadTask task = new ThreadTask();
//		RunnableThread runnable = new RunnableThread();
		System.out.println("Enter which number of exercise you want to perform: ");
		int exerciseNo = get.getInt();
		while (exerciseNo != 0)
		{
			try
			{
				switch (exerciseNo)
				{
				case 1:
					Thread thread = new ThreadTask();
					System.out.println(".....Before Start.....");
					get.printThread(thread);
					thread.start();
					thread.join();
					System.out.println(".....After Start.....");
					get.printThread(thread);
					break;
					
				case 2:
					Runnable create2 = new RunnableThread();
					Thread thread2 = new Thread(create2);
					System.out.println(".....Before Start.....");
					get.printThread(thread2);
					thread2.start();
					thread2.join();
					get.printThread(thread2);
					break;
					
				case 3:
					ThreadTask thread3 = new ThreadTask("ExtendedThread");
					System.out.println(".....Before Start.....");
					get.printThread(thread3);
					thread3.start();
					thread3.join();
					System.out.println(".....After Start.....");
					thread3.join();
					get.printThread(thread3);
					Runnable create33 = new RunnableThread();
					Thread thread33 = new Thread(create33);
					thread33.setName("RunnableThread");
//					create33 = new RunnableThread("RunnableThread");
					System.out.println(".....Before Start.....");
					get.printThread(thread33);
					thread33.start();
					thread33.join();
					System.out.println(".....After Start.....");
					thread33.join();
					get.printThread(thread33);
					break;
					
				case 4:
					System.out.println("Enter how mant ExtendedThreads and RunnableThreads you want to add: ");
					int number = get.getInt();
					for (int i = 1; i<=number; i++)
					{
						System.out.println("Enter name of ExtendedThread-" + i);
						String name = get.scan.next();
						ThreadTask4 nThreads = new ThreadTask4(name, 10000);
						nThreads.start();
						System.out.println("Enter name of RunnableThread-" + i);
						name = get.scan.next();
						Runnable createNew = new RunnableThread4 (name, 5000);
						Thread runThread = new Thread(createNew);
						runThread.start();
					}
					break;
					
				case 5:
					System.out.println("Enter how many ExtendedThreads and RunnableThreads you want to add: ");
					number = get.getInt();
					String[] extendedThreadName = new String[number];
					int[] extendedTime = new int[number];
					String[] runnableThreadName = new String[number];
					int[] runnableTime = new int[number];
					for (int i = 1; i<=number; i++)
					{
						System.out.println("Enter name of ExtendedThread-" + i);
						extendedThreadName[i-1] = get.scan.next();
						System.out.println("Enter Sleep time of ExtendedThread-" + i);
						extendedTime[i-1] = get.getInt();
						System.out.println("Enter name of RunnableThread-" + i);
						runnableThreadName[i-1] = get.scan.next();
						System.out.println("Enter Sleep time of RunnableThread-" + i);
						runnableTime[i-1] = get.getInt();
					}
					for (int i = 1; i<=number; i++)
					{
						ThreadTask4 nThreads = new ThreadTask4(extendedThreadName[i-1], extendedTime[i-1]*1000);
						nThreads.start();
						Runnable createNew = new RunnableThread4 (runnableThreadName[i-1], runnableTime[i-1]*1000);
						Thread runThread = new Thread(createNew);
						runThread.start();
						runThread.join();
					}
					break;
					
				case 6:
					System.out.println("Enter how many times thread will run");
					int stopTime = get.getInt();
					ThreadTask6 thread6 = new ThreadTask6();
					thread6.setValue(stopTime);
					thread6.start();
					RunnableThread6 create6 = new RunnableThread6();
					create6.setValue(stopTime);
					Thread thread66 = new Thread(create6);
					thread66.start();
					thread66.join();
					break;
					
				case 7:
					ThreadTask7 nThreads;
					RunnableThread7 createNew;
					Thread runThread;
					List<ThreadTask7> extendedList = new ArrayList<>();
					List<RunnableThread7> runnableList = new ArrayList<>();
					List<Thread> runnableThreadList = new ArrayList<>();

					System.out.println("Enter how many ExtendedThreads and RunnableThreads you want to add: ");
					number = get.getInt();
					extendedThreadName = new String[number];
					runnableThreadName = new String[number];
					for (int i = 1; i<=number; i++)
					{
						System.out.println("Enter name of ExtendedThread-" + i);
						extendedThreadName[i-1] = get.scan.next();
						System.out.println("Enter name of RunnableThread-" + i);
						runnableThreadName[i-1] = get.scan.next();
					}
					for (int i = 1; i<=number; i++)
					{
						nThreads = new ThreadTask7(extendedThreadName[i-1]);
						extendedList.add(nThreads);
						nThreads.start();
						createNew = new RunnableThread7 (runnableThreadName[i-1]);
						runThread = new Thread(createNew);
						runnableList.add(createNew);
						runnableThreadList.add(runThread);
						runThread.start();
					}
					int count = 0;
					int size = extendedList.size();
					for (int i=0; i < size; i++)
					{
						ThreadTask7 stop = extendedList.get(i);
						RunnableThread7 stop2 = runnableList.get(i);
						ThreadTask7.sleep(15000);
						stop.setValue(false);
						stop.join();
						Thread.sleep(10000);
						stop2.setValue(false);
						runnableThreadList.get(i).join();
						if (!stop.isAlive() && !runnableThreadList.get(i).isAlive())
						{
							count++;
						}
					}
					if (count == number)
					System.out.println("........Task Completed........");
					break;
				}
			}
			catch (InterruptedException ie)
			{
				System.out.println(ie);
			}
				System.out.println("Enter 0 to close the program");
				System.out.println("Enter which number of exercise you want to perform: ");
				exerciseNo = get.getInt();
		}
		
	}

}

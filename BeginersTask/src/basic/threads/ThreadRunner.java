package basic.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import myException.UserDefinedException;

public class ThreadRunner 
{
	private Scanner scan = new Scanner (System.in);
		
	private int getInt()
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
				System.out.print("Enter value in integer: ");
			}
		}
		return number;
	}
		
	private String printThread(Thread obj)
	{
		return "Name-" + obj.getName() + "  Priority-" + obj.getPriority() + "  State-" + obj.getState() + "\n";
	}

	public static void main(String[] args) throws InterruptedException, UserDefinedException
	{
		ThreadRunner get = new ThreadRunner();
		System.out.println("Enter which number of exercise you want to perform: ");
		int exerciseNo = get.getInt();
		while (exerciseNo != 0)
		{
			try
			{
				switch (exerciseNo)
				{
				case 1:
				{
					Thread thread = new ThreadTask();
					System.out.println(".....Before Start....." + get.printThread(thread));
					
					thread.start();
					System.out.println(".....After Start....." + get.printThread(thread));
					
					break;
				}
					
				case 2:
				{
					Runnable rThread = new RunnableThread();
					Thread runThread = new Thread(rThread);
					System.out.println(".....Before Start....." + get.printThread(runThread));
					
					runThread.start();
					System.out.println(".....After Start....." + get.printThread(runThread));
					
					break;
				}
					
				case 3:
				{
					ThreadTask thread = new ThreadTask("ExtendedThread");
					System.out.println(".....Before Start....." + get.printThread(thread));
					
					thread.start();
					System.out.println(".....After Start....." + get.printThread(thread));
					
					Runnable rThread = new RunnableThread();
					Thread runThread = new Thread(rThread);
					runThread.setName("RunnableThread");
					System.out.println(".....Before Start....." + get.printThread(runThread));
					
					runThread.start();
					System.out.println(".....After Start....." + get.printThread(runThread));
					
					break;
				}
					
				case 4:
				{
					System.out.println("Enter how many ExtendedThreads and RunnableThreads you want to add: ");
					int number = get.getInt();
					for (int i = 1; i<=number; i++)
					{
						System.out.println("Enter name of ExtendedThread-" + i);
						String name = get.scan.next();
						ThreadTask4 thread = new ThreadTask4(name, 60000);
						thread.start();
						System.out.println("Enter name of RunnableThread-" + i);
						name = get.scan.next();
						Runnable rThread = new RunnableThread4 (name, 45000);
						Thread runThread = new Thread(rThread);
						runThread.start();
					}
					break;
				}
					
				case 5:
				{
					System.out.println("Enter how many ExtendedThreads and RunnableThreads you want to add: ");
					int number = get.getInt();
					String[] extendedThreadName = new String[number];
					int[] extendedTime = new int[number];
					String[] runnableThreadName = new String[number];
					int[] runnableTime = new int[number];
					for (int i = 1; i<=number; i++)
					{
						System.out.println("Enter name of ExtendedThread-" + i);
						extendedThreadName[i-1] = get.scan.next();
						System.out.println("Enter Sleep time of ExtendedThread-" + i + " in Seconds");
						extendedTime[i-1] = get.getInt();
						System.out.println("Enter name of RunnableThread-" + i);
						runnableThreadName[i-1] = get.scan.next();
						System.out.println("Enter Sleep time of RunnableThread-" + i + " in Seconds");
						runnableTime[i-1] = get.getInt();
					}
					for (int i = 0; i<number; i++)
					{
						ThreadTask4 thread = new ThreadTask4(extendedThreadName[i], extendedTime[i]*1000);
						thread.start();
						Runnable rThread = new RunnableThread4 (runnableThreadName[i], runnableTime[i]*1000);
						Thread runThread = new Thread(rThread);
						runThread.start();
					}
					break;
				}
				
				case 6:
				{
					System.out.println("Enter how many ExtendedThreads and RunnableThreads you want to add: ");
					int number = get.getInt();
					String[] extendedThreadName = new String[number];
					String[] runnableThreadName = new String[number];
					for (int i = 1; i<=number; i++)
					{
						System.out.println("Enter name of ExtendedThread-" + i);
						extendedThreadName[i-1] = get.scan.next();
						System.out.println("Enter name of RunnableThread-" + i);
						runnableThreadName[i-1] = get.scan.next();
					}
					System.out.println("Enter how many times thread will run");
					int stopTime = get.getInt();
					for (int i = 0; i<number; i++)
					{
						ThreadTask6 thread = new ThreadTask6(extendedThreadName[i]);
						thread.setValue(stopTime);
						thread.start();
						RunnableThread6 rThread = new RunnableThread6 (runnableThreadName[i]);
						rThread.setValue(stopTime);
						Thread runThread = new Thread(rThread);
						runThread.start();
					}
					break;
				}
					
				case 7:
				{
					ThreadTask7 threads;
					RunnableThread7 rThread;
					Thread runThread;
					List<ThreadTask7> extendedList = new ArrayList<>();
					List<RunnableThread7> runnableList = new ArrayList<>();
					List<Thread> runnableThreadList = new ArrayList<>();

					System.out.println("Enter how many ExtendedThreads and RunnableThreads you want to add: ");
					int number = get.getInt();
					String[] extendedThreadName = new String[number];
					String[] runnableThreadName = new String[number];
					for (int i = 1; i<=number; i++)
					{
						System.out.println("Enter name of ExtendedThread-" + i);
						extendedThreadName[i-1] = get.scan.next();
						System.out.println("Enter name of RunnableThread-" + i);
						runnableThreadName[i-1] = get.scan.next();
					}
					for (int i = 0; i<number; i++)
					{
						threads = new ThreadTask7(extendedThreadName[i]);
						extendedList.add(threads);
						threads.start();
						rThread = new RunnableThread7 (runnableThreadName[i]);
						runThread = new Thread(rThread);
						runnableList.add(rThread);
						runnableThreadList.add(runThread);
						runThread.start();
					}
					int size = extendedList.size();
					for (int i=0; i < size; i++)
					{
						ThreadTask7 stopThread = extendedList.get(i);
						RunnableThread7 stopThread2 = runnableList.get(i);
						Thread.sleep(60000);
						stopThread.setValue(false);
						Thread.sleep(60000);
						stopThread2.setValue(false);
					}
					while(extendedList.get(size-1).isAlive() || runnableThreadList.get(size-1).isAlive())
					{
						Thread.sleep(1000);
						if (!extendedList.get(size-1).isAlive() && !runnableThreadList.get(size-1).isAlive())
						{
							System.out.println("........Task Completed........");
						}
					}
					break;
				}
				}
			}
			catch (InterruptedException ie)
			{
				System.out.println(ie);
			}
			catch (Exception e)
			{
				System.out.println(e);
			}
				System.out.println("Enter 0 to close the program");
				System.out.println("Enter which number of exercise you want to perform: ");
				exerciseNo = get.getInt();
		}
		
	}

}

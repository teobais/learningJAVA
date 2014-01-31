import java.util.Random;

public class PrintTask implements Runnable {
	private final int sleepTime;
	private final String taskName;
	private final static Random generator = new Random();
	
	public PrintTask(String name)
	{
		taskName = name;
		
		//tuxaia epilogi diarkeias narkis 0-5 secs
		sleepTime = generator.nextInt(5000);	//ms
	}
	
	//code that will execute
	public void run() {
		try
		{
			System.out.printf("%s is going to sleep for %d ms.\n",taskName,sleepTime);
			Thread.sleep(sleepTime);
		}catch(InterruptedException exception)
		{
			System.out.printf("%s %s\n",taskName,"terminated prematurely due to interruption");
		}
		
		//displaying thread name
		System.out.printf("%s done sleeping\n", taskName);
	}
}


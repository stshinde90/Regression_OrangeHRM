package test_Components;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StopDocker {
	
	
	public void stopBatFile() throws IOException, InterruptedException
	{
		
		boolean flag = false;
		Runtime rntm = Runtime.getRuntime();
		rntm.exec("cmd /c start dockerDown.bat");
		Thread.sleep(5000);
		String f = "output.txt";
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.SECOND, 45);
		Long stopNow = cal.getTimeInMillis();
		
		while(System.currentTimeMillis()<stopNow)
		{
			if(flag) {
				break;
			}
			BufferedReader reader = new BufferedReader(new FileReader(f));
			String currentLine = reader.readLine();
		while(currentLine!=null && !flag)
		{
			if(currentLine.contains("exited with code 143"))
			{
				System.out.println("Found my Text");
				Thread.sleep(5000);
				flag=true;
				break;
				
			}
			currentLine = reader.readLine();
		}
		reader.close();
		}
		
		Assert.assertTrue(flag);
		Thread.sleep(2000);
		
		
		
		
	}

}

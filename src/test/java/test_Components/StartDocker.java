package test_Components;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StartDocker {

	public void startBatFile() throws IOException, InterruptedException {

		boolean flag = false;
		Runtime rntm = Runtime.getRuntime();
		rntm.exec("cmd /c start dockerUp.bat");
		Thread.sleep(5000);
		String f = "output.txt";
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.SECOND, 45);
		Long stopNow = cal.getTimeInMillis();

		while (System.currentTimeMillis() < stopNow) {
			if (flag) {
				break;
			}
			BufferedReader reader = new BufferedReader(new FileReader(f));
			String currentLine = reader.readLine();
			while (currentLine != null && !flag) {
				if (currentLine.contains("Node has been added")) {
					System.out.println("Found my Text");
					flag = true;
					break;

				}
				currentLine = reader.readLine();
			}
			reader.close();
		}

		Assert.assertTrue(flag);
		Thread.sleep(5000);
		rntm.exec("cmd /c start scale.bat");
		Thread.sleep(15000);
	}

}

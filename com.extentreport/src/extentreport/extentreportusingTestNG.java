package extentreport;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class extentreportusingTestNG
{
	WebDriver driver=new ChromeDriver();
	ExtentReports extent;
	ExtentHtmlReporter htmlReporter;
	ExtentTest TestCases;
	long StartTime;
	long EndTime;

	@BeforeSuite
	public void launchbrowser() throws InterruptedException
	{
		extent=new ExtentReports();
		htmlReporter=new ExtentHtmlReporter("ExtentReport.html");
		extent.attachReporter(htmlReporter);
		StartTime=System.currentTimeMillis();
		driver.get("http://leafground.com/");
		String title=driver.getTitle();
		System.out.println(title);
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.navigate().to("http://leafground.com/pages/checkbox.html");
	}
	
	@Test(priority=1)
	public void languages() throws InterruptedException
	{
		//1. Select the languages that you know?
		TestCases=extent.createTest("Clicking language 1 and language 2");
		TestCases.log(Status.INFO, "Starts from the 1st field which is 'Select the languages that you know?' ");
		TestCases.log(Status.INFO, "Selected the two languages");
		WebElement Language1=driver.findElement(By.xpath("	//*[@id=\"contentblock\"]/section/div[1]/input[1]"));
		Language1.click();
		Thread.sleep(1000);
		WebElement Language2=driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[1]/input[2]"));
		Language2.click();
	}
	
	@Test(priority=2)
	public void confirm() throws InterruptedException
	{
		//2. Confirm Selenium is checked
		TestCases=extent.createTest("Confirming checkbox is selected or not");
		TestCases.log(Status.INFO, "Move to the 2nd field which is 'Confirm Selenium is checked' ");
		TestCases.log(Status.INFO, "Confirmed, the checkbox is already selected");
		driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[2]/input"));
		Boolean value=driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[2]/input")).isEnabled();
		System.out.println(value);
		Thread.sleep(2000);

	}
	
	@Test(priority=3)
	public void deselect()
	{
		//3. DeSelect only checked
		TestCases=extent.createTest("Deselect the checkbox");
		TestCases.log(Status.INFO, "Go to the 3rd field which is 'DeSelect only checked' ");
		TestCases.log(Status.INFO, "It's checked the deselected checkbox");
		WebElement deselect=driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[3]/input[2]"));
		deselect.click();
	}

	@Test(priority=4)
	public void selenium() throws InterruptedException
	{
		//4. DeSelect only checked-Not Selected field
		TestCases=extent.createTest("DeSelect only checked-Not Selected field");
		TestCases.log(Status.INFO, "Go to the 4th field which is 'DeSelect only checked-Not Selected field' ");
		TestCases.log(Status.INFO, "It's confirmed the deselcted checkbox is selected or not");
		driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[3]/input[1]"));
		Boolean value1=driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[3]/input[1]")).isSelected();
		System.out.println(value1);
		Thread.sleep(1000);
	}

	@Test(priority=5)
	public void alloptions() throws InterruptedException
	{
		//5. Select all below checkboxes
		TestCases=extent.createTest("Select all below checkboxes");
		TestCases.log(Status.INFO, "Move to the last field which is 'Select all below checkboxes' ");
		TestCases.log(Status.INFO, "It's selected all the checkboxes");
		WebElement Option1=driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[4]/input[1]"));
		Option1.click();
		Thread.sleep(1000);
		WebElement Option2=driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[4]/input[2]"));
		Option2.click();
		Thread.sleep(1000);
		WebElement Option3=driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[4]/input[3]"));
		Option3.click();
		Thread.sleep(1000);
		WebElement Option4=driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[4]/input[4]"));
		Option4.click();
		Thread.sleep(1000);
		WebElement Option5=driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[4]/input[5]"));
		Option5.click();
		Thread.sleep(1000);
		WebElement Option6=driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[4]/input[6]"));
		Option6.click();
		Thread.sleep(1000);
	}

	@AfterSuite
	public void closebrowser()
	{
		EndTime=System.currentTimeMillis();
		long totaltime=EndTime-StartTime;
		System.out.println("Total Time Taken " +totaltime);
		driver.close();
		extent.flush();
	}

}

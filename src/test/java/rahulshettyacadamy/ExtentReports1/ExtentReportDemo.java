package rahulshettyacadamy.ExtentReports1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo {
	
	ExtentReports extent;
	ExtentSparkReporter reporter;
	@BeforeTest
	public void config()
	{
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Result");		
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Mahesh Holkar");
		
	}
	
@Test
public void initialDemo() {
	
	ExtentTest test = extent.createTest("Initial Demo ");
	System.setProperty("webdriver.chrome.driver","G:\\Drivers\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://rahulshettyacademy.com/#/index");
	System.out.println(driver.getTitle());
	//test.addScreenCaptureFromBase64String(s);
	driver.close();
	//test.fail("Result Dont Match");
	extent.flush();
	
}
}

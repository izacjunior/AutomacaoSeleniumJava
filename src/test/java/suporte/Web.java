package suporte;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Web {

	public static WebDriver createChrome() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\f799396\\Desktop\\Estudos\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("http://www.juliodelima.com.br/taskit");

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		return driver;
	}
	
}

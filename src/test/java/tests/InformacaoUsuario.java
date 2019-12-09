package tests;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InformacaoUsuario {

	WebDriver driver;

	@Before
	public void setup() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\f799396\\Desktop\\Estudos\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("http://www.juliodelima.com.br/taskit");

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@Test
	public void adicionarInformacaoUsuario() {

		// CLICAR LINK SIGN IN
		driver.findElement(By.linkText("Sign in")).click();

		WebElement formulario = driver.findElement(By.id("signinbox"));
		formulario.findElement(By.name("login")).sendKeys("julio0001");

		formulario.findElement(By.name("password")).sendKeys("123456");

		driver.findElement(By.linkText("SIGN IN")).click();

		WebElement me = driver.findElement(By.className("me"));
		String texto = me.getText();
		assertEquals("Hi, Julio", texto);

	}

	@After
	public void tearDown() {
		driver.quit();
	}

}

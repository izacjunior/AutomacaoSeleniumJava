package tests;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import suporte.Generator;
import suporte.Screenshot;
import suporte.Web;


@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "src/test/resources/informacaoUsuario.csv")
public class InformacaoUsuario {

	WebDriver driver;

	@Rule
	public TestName test = new TestName();
	
	
	@Before
	public void setup() {

		driver = Web.createChrome();
		
		// CLICAR LINK SIGN IN
		driver.findElement(By.linkText("Sign in")).click();

		WebElement formulario = driver.findElement(By.id("signinbox"));
		formulario.findElement(By.name("login")).sendKeys("julio0001");

		formulario.findElement(By.name("password")).sendKeys("123456");

		driver.findElement(By.linkText("SIGN IN")).click();

		WebElement me = driver.findElement(By.className("me"));
		String texto = me.getText();
		assertEquals("Hi, Julio", texto);

		driver.findElement(By.className("me")).click();

		driver.findElement(By.linkText("MORE DATA ABOUT YOU")).click();

	}

	@Test
	public void adicionarInformacaoUsuario(@Param(name="tipo")String tipo, @Param(name="contato")String contato,@Param(name="mensagem")String mensagem) {

		driver.findElement(By.xpath("//button[@data-target ='addmoredata']")).click();

		WebElement tela = driver.findElement(By.id("addmoredata"));

		WebElement campoType = tela.findElement(By.name("type"));
		new Select(campoType).selectByVisibleText(tipo);

		tela.findElement(By.name("contact")).sendKeys(contato);

		tela.findElement(By.linkText("SAVE")).click();

		WebElement mensagemEsperada = driver.findElement(By.id("toast-container"));
		String texto1 = mensagemEsperada.getText();
		assertEquals(mensagem, texto1);

	}

	@Test
	public void removerContatoUsuario() {

		driver.findElement(By.xpath("//span[text()='+5511999999999']/following-sibling::a")).click();
		
		driver.switchTo().alert().accept();
		
		WebElement mensagem = driver.findElement(By.id("toast-container"));
		String texto1 = mensagem.getText();
		assertEquals("Rest in peace, dear phone!", texto1);
		
		Screenshot.tirar(driver, "C:\\Users\\f799396\\Desktop\\Estudos\\AutomacaoSeleniumJava\\Evidencias" + Generator.dataHoraArquivo() + test.getMethodName() + ".png");
		
		WebDriverWait aguardar = new WebDriverWait(driver, 10);
		aguardar.until(ExpectedConditions.stalenessOf(mensagem));
		
		driver.findElement(By.linkText("Logout")).click();
	}

	@After
	public void tearDown() {
		driver.quit();
	}

}

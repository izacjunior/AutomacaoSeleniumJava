package pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

	protected WebDriver navegador;
	
	
	public BasePage(WebDriver navegador) {
		this.navegador = navegador;
	}

	public String capturarTexto() {
		
		return navegador.findElement(By.id("toast-container")).getText();
	
		
	}
}

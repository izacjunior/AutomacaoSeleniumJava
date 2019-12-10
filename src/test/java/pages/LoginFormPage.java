package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFormPage extends BasePage {

	
	public LoginFormPage(WebDriver navegador) {
		super(navegador);
		// TODO Auto-generated constructor stub
	}

	public LoginFormPage digitarLogin(String login) {

		navegador.findElement(By.id("signinbox")).findElement(By.name("login")).sendKeys(login);
		return this;
	}

	public LoginFormPage digitarSenha(String password) {

		navegador.findElement(By.id("signinbox")).findElement(By.name("password")).sendKeys(password);
		return this;

	}
	
	public SecretaPage clicarSign() {
		navegador.findElement(By.linkText("SIGN IN")).click();
		
		return new SecretaPage(navegador);
	}
	
	
	public SecretaPage realizarLogin(String login, String password) {
		
		digitarLogin(login);
		digitarSenha(password);
		clicarSign();
		
		return new SecretaPage(navegador);
	}
	
	
	
	
	
	
}
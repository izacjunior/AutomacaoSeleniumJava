package tests;

import static org.junit.Assert.assertEquals;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import pages.LoginPage;
import suporte.Web;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "src/test/resources/informacaoUsuarioPage.csv")
public class InformacaoUsuarioPageObject {

	private WebDriver navegador;

	@Before
	public void setup() {

		navegador = Web.createChrome();
	}

	@Test
	public void adicionarInformacaoUsuarioPage(@Param(name = "login") String login, @Param(name = "senha") String senha,
			@Param(name = "tipo") String tipo, @Param(name = "contato") String contato,
			@Param(name = "mensagem") String mensagem) {

		String texto = new LoginPage(navegador).clickSign().realizarLogin(login, senha).clicaMe().clicarAboutData()
				.clicarBotaoAboutData().adicionarConato(tipo, contato).capturarTexto();

		assertEquals(mensagem, texto);
	}

	@After
	public void tearDown() {

		navegador.quit();
	}
}

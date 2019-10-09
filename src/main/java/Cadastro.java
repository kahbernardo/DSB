import static kbernardo.autotestes.DriverFactory.getDriver;
import static kbernardo.autotestes.DriverFactory.killDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Cadastro {
	
	//private WebDriver driver;
	//private DSL dsl;
	private CampoTreinamentoPage page;

	@Before
	public void inicializa(){
		//System.setProperty("webdriver.chrome.driver","/Users/devell39/chromedriver_win32 (1)/chromedriver.exe");
		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		page = new CampoTreinamentoPage();
	}
	
	@After
	public void finaliza(){
		killDriver();
	}

	@Test
	public void deveRealizarCadastroComSucesso(){
		page.setNome("Kaique");
		page.setSobrenome("Bernardo");
		page.setSexoMasculino();
		page.setComidaPizza();
		page.setEscolaridade("Mestrado");
		page.setEsporte("Natacao");
		page.cadastrar();
		
		Assert.assertEquals("Cadastrado!", page.obterResultadoCadastro());
		Assert.assertEquals("Wagner", page.obterNomeCadastro());
		Assert.assertEquals("Costa", page.obterSobrenomeCadastro());
		Assert.assertEquals("Masculino", page.obterSexoCadastro());
		Assert.assertEquals("Pizza", page.obterComidaCadastro());
		Assert.assertEquals("mestrado", page.obterEscolaridadeCadastro());
		Assert.assertEquals("Natacao", page.obterEsportesCadastro());
	}
}
	
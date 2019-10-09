import static kbernardo.autotestes.DriverFactory.getDriver;
import static kbernardo.autotestes.DriverFactory.killDriver;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import  org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class CadastroSac {
	
	
	//private DSL dsl;
	private SacAvPage page;

	@Before
	public void inicializa(){
		//System.setProperty("webgetDriver().chrome.driver","/Users/devell39/chromedriver_win32 (1)/chromegetDriver().exe");
		getDriver().get("https://qa.sac-avenida.com.br/login");
		//getDriver().get("https://d12dj9ikpu9m3h.cloudfront.net");
		page = new SacAvPage();
		getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		page.setUser("Kaique.Bernardo");
		page.setSenha("teste12345");
		page.logar();
	}
	
	@After
	public void finaliza(){
		//killDriver();
	}
	/*
	@Test
	public void Login(){
		
		page.setUser("Kaique.Bernardo");
		page.setSenha("teste12345");
		page.logar();
		//getDriver().findElement(By.xpath("//div[@id=\'login\']/div/div/form/button")).click();
		
	}
	
	*/
	////*[@id="root"]/div/div/header/nav/div/button
	@Test
	public void LoginX()throws InterruptedException{
		page.logarX();
		page.setCPFX("43066300803");
		page.logarXNegocie();
		Thread.sleep(10000);
		page.logarX();
		
	}
	@Test
	public void LoginAlternativo(){
		
		page.setUser("loginErrado");
		page.setSenha("teste12");
		page.logar();
		Assert.assertEquals("×",page.obterErro("//*[@id='login']//*/form/div[3]"));
	}
	
	@Test
	public void cadastroSucesso(){
		page.setCPF("573.629.460-58");
		//page.ValidarAlerta("Erro ao consultar CPF. Tente novamente mais tarde!");
		//page.ValidarAlerta("Erro ao consultar adimplï¿½ncia. Tente novamente mais tarde!");
		page.setNomeCliente("Jose da Silva");
		page.setNascimento("01/01/2000");
		//page.ValidarAlerta("Erro ao consultar CPF. Tente novamente mais tarde!");
		page.passaAlerta();
		page.setEmail("abc@abc.com");
		page.ValidarAlerta("Erro ao consultar CPF. Tente novamente mais tarde!");
	}
	
	@Test
	public void preencheCPF(){
		page.setCPF("573.629.460-58");
		page.ValidarAlerta("Erro ao consultar CPF. Tente novamente mais tarde!");
		page.ValidarAlerta("Erro ao consultar adimplï¿½ncia. Tente novamente mais tarde!");
	}
}

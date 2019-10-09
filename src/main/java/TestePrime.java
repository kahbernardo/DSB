import static kbernardo.autotestes.DriverFactory.getDriver;
import static kbernardo.autotestes.DriverFactory.killDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import kbernardo.autotestes.DSL;

public class TestePrime {
	

	private DSL dsl;

	@Before
	public void inicializa(){

		getDriver().manage().window().setSize(new Dimension(1200, 765));
		//getDriver().get("https://www.primefaces.org/showcase/ui/input/oneRadio.xhtml");
		getDriver().get("https://www.primefaces.org/showcase/ui/input/oneMenu.xhtml");
		dsl = new DSL();
	}
	
	@After
	public void finaliza(){
		//killDriver();
	}

	@Test
	public void deveInteragirComRadioPrime(){
		//dsl.clicarRadio(By.xpath("//input[@id='j_idt701:console']/tbody/tr/td[1]/div/div[2]/span"));
		dsl.clicarRadio(By.xpath("//label[.='Xbox One']/..//span"));
		Assert.assertTrue(dsl.isRadioMarcado("j_idt701:console:0"));
		dsl.clicarRadio(By.xpath("//label[.='PS4']/..//span"));
		Assert.assertTrue(dsl.isRadioMarcado("j_idt701:console:1"));
		
	}
	@Test
	public void deveInteragirComSelectPrime(){
		getDriver().get("https://www.primefaces.org/showcase/ui/input/oneMenu.xhtml");
		dsl.selecionarComboPrime("j_idt701:console", "Xbox One");
		Assert.assertEquals("Xbox One", dsl.obterTexto("j_idt701:console_label"));
	}
}


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class DesafioRegraNegocio {

	private WebDriver driver;
	
	@Before
	public void inicializa(){
			//System.setProperty("webdriver.chrome.driver","/Users/devell39/chromedriver_win32 (1)/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().setSize(new Dimension(1200, 765));
			driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	}
	
	@After
	public void finaliza(){
		driver.quit();
	}
	
	@Test
	public void TesteRegraNome(){
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Kaique");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alerta = driver.switchTo().alert();
		Assert.assertEquals("Sobrenome eh obrigatorio", alerta.getText());
		
	}
	@Test
	public void TesteRegraSobrenome(){
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Kaique");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Bernardo");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alerta = driver.switchTo().alert();
		Assert.assertEquals("Sexo eh obrigatorio", alerta.getText());
		
		}
	
	@Test
	public void TesteRegraSexo(){
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Kaique");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Bernardo");
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Assert.assertTrue(driver.findElement(By.id("resultado")).getText().startsWith("Cadastrado!"));
	}
	
	@Test
	public void TesteRegraVegetariano(){
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Kaique");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Bernardo");
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alerta = driver.switchTo().alert();
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", alerta.getText());
		
	}
	
	
	@Test
	public void TesteRegraEsporte(){
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Kaique");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Bernardo");
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		new Select(driver.findElement(By.id("elementosForm:esportes")))
		.selectByVisibleText("Corrida");
		new Select(driver.findElement(By.id("elementosForm:esportes")))
		.selectByVisibleText("O que eh esporte?");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alerta = driver.switchTo().alert();
		Assert.assertEquals("Voce faz esporte ou nao?", alerta.getText());		
	}
}

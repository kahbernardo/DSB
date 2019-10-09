import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestAlert {
	
private WebDriver driver;
	
	@Before
	public void inicializa(){
			System.setProperty("webdriver.chrome.driver","/Users/devell39/chromedriver_win32 (1)/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().setSize(new Dimension(1200, 765));
			driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	}
	
	@After
	public void finaliza(){
		driver.quit();
	}
	
	@Test
	public void deveInteragirComAlertSimples(){
		
		driver.findElement(By.id("alert")).click();
		Alert alert = driver.switchTo().alert();
		String texto = alert.getText();
		Assert.assertEquals("Alert Simples", texto);
		alert.accept();
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);
		
	}
	
	/*@Test minha vers�o
	public void deveInteragirConfirmExercicio(){
	
		driver.findElement(By.id("confirm")).click();
		Alert alert = driver.switchTo().alert();
		String texto = alert.getText();
		Assert.assertEquals("Confirm Simples", texto);
		alert.accept();
		String texto1 = alert.getText();
		Assert.assertEquals("Confirmado", texto1);
		alert.accept();
		
		
	}
	
	@Test
	public void deveInteragirComNegativeExercicio(){
	
		driver.findElement(By.id("confirm")).click();
		Alert alert = driver.switchTo().alert();
		String texto = alert.getText();
		Assert.assertEquals("Confirm Simples", texto);
		alert.dismiss();
		String texto1 = alert.getText();
		Assert.assertEquals("Negado", texto1);
		alert.dismiss();
		
		
		
	}*/
	
	@Test
	public void deveInteragirComAlertConfirm(){
	
		driver.findElement(By.id("confirm")).click();
		Alert alerta = driver.switchTo().alert();
		Assert.assertEquals("Confirm Simples", alerta.getText());
		alerta.accept();
		Assert.assertEquals("Confirmado", alerta.getText());
		alerta.accept();
		
		driver.findElement(By.id("confirm")).click();
		alerta = driver.switchTo().alert();
		Assert.assertEquals("Confirm Simples", alerta.getText());
		alerta.dismiss();
		Assert.assertEquals("Negado", alerta.getText());
		alerta.dismiss();
		
	}

}

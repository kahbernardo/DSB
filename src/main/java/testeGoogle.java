import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class testeGoogle {
	
	
private WebDriver driver;
	
	@Before
	public void inicializa(){
		//System.setProperty("webdriver.chrome.driver","/Users/kbern/workspace/Driver_chrome/chromedriver.exe");			
			driver = new ChromeDriver();
			driver.manage().window().setSize(new Dimension(1200, 765));
	}
	
	@After
	public void finaliza(){
		driver.quit();
	}
	@Test
	public void test() {
		
		//System.out.println(driver.getTitle());
		driver.get("https://qa.sac-avenida.com.br/");
		driver.manage().window().maximize();
		Assert.assertEquals("SAC Lojas Avenida", driver.getTitle());
		System.out.println(driver.getTitle());
		
		
		
	}
	
	

}

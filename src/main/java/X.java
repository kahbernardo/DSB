import static kbernardo.autotestes.DriverFactory.getDriver;
import static kbernardo.autotestes.DriverFactory.killDriver;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import  org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class X {
	private SacAvPage page;
	
	@Before
	public void inicializa(){
	getDriver().get("https://d12dj9ikpu9m3h.cloudfront.net");
	page = new SacAvPage();
	getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	}
}

package site;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BuscaSeleniumPuro {
    String url = "https://www.iterasys.com.br";
    WebDriver driver;

    @Before
    public void iniciar(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void finalizar(){
        driver.quit();
    }

    @Test
    public void buscaCurso(){
        driver.get(url);
        driver.findElement(By.id("searchtext")).sendKeys("TestLink" + Keys.ENTER);
        driver.findElement(By.cssSelector("span.comprar")).click();
        Assert.assertEquals("TestLink", driver.findElement(By.cssSelector("span.item-title")).getText());
        Assert.assertEquals("R$ 79,99", driver.findElement(By.cssSelector("span.new-price")).getText());
    }
}
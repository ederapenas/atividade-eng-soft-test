import org.asynchttpclient.util.Assertions;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;
public class Testes {


    @Test
    public void abrirYoutube(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver_win32/chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.get("https://www.youtube.com/");
        assertEquals("https://www.youtube.com/", webDriver.getCurrentUrl());
        webDriver.close();
    }

    @Test
    public void inserirInputPesquisa(){
        /* Inicialmente  esse teste seria de uma pesquisa, mas por algum motivo o botão do youtube nao estava
        * sendo reconhecido nem mesmo quando eu pegava id, classname ou qualquer coisa, as unicas vezes que
        * consegui fazer a pesquisa foi usando pesquisa.sendKeys("test" + Keys.ENTER) mas nem quando eu fazia isso
        * funcionava 100%, ocorria em algumas vezes apenas, então decidi deixar apenas um teste usando sendKeys,
        * já que ja usei um teste que utilizava do JUnit.*/
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver_win32/chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        
        webDriver.get("https://www.youtube.com");
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement pesquisa = webDriver.findElement(By.name("search_query"));
        pesquisa.sendKeys("test");
    }

    @Test
    public void abrirMenuEsquerdo(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver_win32/chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        webDriver.get("https://www.youtube.com/");
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement botaoGuia = webDriver.findElement(By.id("guide-button"));
        botaoGuia.click();
        webDriver.close();
    }

}

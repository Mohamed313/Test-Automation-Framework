package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: rrt
 * Date: 8/10/14
 * Time: 11:55 AM
 * To change this template use File | Settings | File Templates.
 */
public class CommonApi {

    public WebDriver driver = null;
    @BeforeMethod
    public void setUp(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.navigate().to("http://www.cnn.com");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void doomTheDriver(){
        driver.quit();
    }

    //helper methods
    public void type(String locator, String value){
        driver.findElement(By.cssSelector(locator)).sendKeys(value);
    }
    public void clickByXpath(String locator){
        driver.findElement(By.xpath(locator)).click();
    }
    public void sleep(int seconds)throws InterruptedException{
        Thread.sleep(1000*seconds);
    }
    public List<WebElement> getWebElements(String locator){
        List<WebElement> elementList = new ArrayList<WebElement>();
        elementList = driver.findElements(By.cssSelector(locator));
        return elementList;
    }
    public void navigateBack(){
        driver.navigate().back();
    }
}

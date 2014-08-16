package common;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.net.URL;
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

    //Implement remote client and local client
    @Parameters({"url", "useSauceLabs","OS","browserName","browserVersion","userName","key"})
    @BeforeMethod
    public void setUp(@Optional("http://www.cnn.com")String url,@Optional("false") boolean useSauceLabs, @Optional("Windows 7")
    String OS,@Optional("firefox")String browserName,@Optional("30")String browserVersion,@Optional("rahmanww") String userName,@Optional("e45ab198-cbcb-4f8f-89b9-639b0894e0bf")String key)throws IOException{

        if(useSauceLabs==true)   {
            //run on SauceLabs
            getSauceLabDriver(OS,browserName,browserVersion,userName,key);

        }else{
            //Run on local
            getLocalDriver(browserName);
        }
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.navigate().to(url);
        driver.manage().window().maximize();
    }

    public WebDriver getLocalDriver(String browser){
          if(browser.equalsIgnoreCase("firefox")) {
              driver = new FirefoxDriver();
          }else if(browser.equalsIgnoreCase("chrome")){
              System.setProperty("webdriver.chrome.driver","Generic/selenium-driver/chromedriver.exe");
              driver = new ChromeDriver();
          }else if(browser.equalsIgnoreCase("safari")){
              driver = new SafariDriver();
          }else if(browser.equalsIgnoreCase("iexplore")){
              System.setProperty("webdriver.ie.driver","Generic/selenium-driver/IEDRiverServer.exe");
              driver = new InternetExplorerDriver();
          }
       return driver;
    }
    public WebDriver getSauceLabDriver(String OS, String browserName,
        String browserVersion, String userName, String key)throws IOException {

        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setCapability("platform", OS);
        capability.setBrowserName(browserName);
        capability.setVersion(browserVersion);
        this.driver = new RemoteWebDriver(new URL("http://"+userName+":"+key+"@ondemand.saucelabs.com:80/wd/hub"), capability);
        return driver;
    }

    //@BeforeMethod
    public void setUp(String url){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.navigate().to(url);
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void doomTheDriver(){
        driver.quit();
    }

    //helper methods

    //type
    public void typeByCss(String locator, String value){
        driver.findElement(By.cssSelector(locator)).sendKeys(value);
    }
    public void typeByXpath(String locator, String value){
        driver.findElement(By.xpath(locator)).sendKeys(value);
    }
    public void enterKeys(String locator){
        driver.findElement(By.cssSelector(locator)).sendKeys(Keys.ENTER);
    }

    //click
    public void clickByXpath(String locator){
        driver.findElement(By.xpath(locator)).click();
    }
    public void clickByCss(String locator){
        driver.findElement(By.cssSelector(locator)).click();
    }

    //get web elements
    public List<WebElement> getWebElements(String locator){
        List<WebElement> elementList = new ArrayList<WebElement>();
        elementList = driver.findElements(By.cssSelector(locator));
        return elementList;
    }
    //get Text
    public String getText(String locator){
        String st;
        st = driver.findElement(By.cssSelector(locator)).getText();
        return st;
    }
    public List<String> getTextList(String locator){
        List<String> list = new ArrayList<String>();
        List<WebElement> element = new ArrayList<WebElement>();
        element = getWebElements(locator);
        for(WebElement st:element){
           list.add(st.getText());
        }
        return list;
    }
    //navigation
    public void navigateBack(){
        driver.navigate().back();
    }
    //handling alert
    public void okAlert(){
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    public void cancelAlert(){
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    //handling cookie

    //handling pop up window

    //mouse hover
    public void mouseHover(String locator){
        WebElement element = driver.findElement(By.cssSelector(locator));
        Actions build = new Actions(driver);
        Actions hover = build.moveToElement(element);
    }

    //sleep
    public void sleep(int seconds)throws InterruptedException{
        Thread.sleep(1000*seconds);
    }
   //Synchronization (dynamic wait)
    public void waitUntilVisible(By locator){
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void waitUntilClickAble(By locator){
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public void waitUntilSelectAble(By locator){
        WebDriverWait wait = new WebDriverWait(driver,10);
        boolean element = wait.until(ExpectedConditions.elementToBeSelected(locator));
    }


}































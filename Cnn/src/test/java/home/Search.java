package home;

import common.CommonApi;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * User: rrt
 * Date: 8/10/14
 * Time: 12:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class Search extends CommonApi {

    @Test
    public void searchBox(){
        driver.findElement(By.cssSelector("#hdr-search-box")).sendKeys("politics", Keys.ENTER);
    }
}

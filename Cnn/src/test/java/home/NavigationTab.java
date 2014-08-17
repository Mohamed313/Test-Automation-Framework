package home;

import common.CommonApi;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: rrt
 * Date: 8/10/14
 * Time: 1:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class NavigationTab extends CommonApi{

   // @Test
    public void test1() throws InterruptedException {
        List<WebElement> tab = getWebElements("#cnn_hdr-nav li");
        for(int i=0; i<tab.size(); i++){
            if(i==1||i==14||i==15){

                tab.get(i).findElement(By.tagName("a")).click();
                navigateBack();
                sleep(2);
            }else{
                tab.get(i).findElement(By.tagName("a")).click();
                sleep(2);
            }

            tab =getWebElements("#cnn_hdr-nav li");
        }

    }
}

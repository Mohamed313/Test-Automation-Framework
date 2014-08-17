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

    //@Test
    public void searchBox()throws InterruptedException{
        typeByCss("#hdr-search-box", "politics");
        clickByXpath(".//*[@id='hdr-search']/form/div/div[2]/input");
        sleep(3);
    }
}

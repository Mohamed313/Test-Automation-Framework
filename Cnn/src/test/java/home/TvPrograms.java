package home;

import common.CommonApi;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: rrt
 * Date: 8/23/14
 * Time: 10:28 AM
 * To change this template use File | Settings | File Templates.
 */
public class TvPrograms extends CommonApi {
    @Test
    public void dropDownMenuTvProgram(){
      // List<WebElement> list = getWebElements(".tvPrograms select option");
       // WebElement element = getWebElement(".tvPrograms>select");
        WebElement element = getWebElement(".tvPrograms>select option");
        List<String> listOfMenuText = getTextList(".tvPrograms>select option");
        for(int i=0; i<listOfMenuText.size(); i++){
            if(i==1||i==3){
                continue;
          //  if(element.isEnabled()) {
            }else{
                selectElementByOption(element,listOfMenuText.get(i));
            }
            navigateBack();
            element = getWebElement(".tvPrograms>select option");
        }
    }
}

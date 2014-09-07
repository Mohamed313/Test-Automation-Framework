package Home;

import common.CommonApi;
import org.testng.annotations.Test;


/**
 * Created by muneer on 9/7/2014.
 */
public class DropDown extends CommonApi {

    @Test
    public void DropDownSearch()throws InterruptedException{

        clickByXpath(".//*[@id='searchDropdownBox']");

        typeByXpath(".//*[@id='twotabsearchtextbox']", "Computer");

        clickByCss(".nav-submit-input");




        sleep(3);
    }
}

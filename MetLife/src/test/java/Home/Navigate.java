package Home;

import common.CommonApi;
import org.testng.annotations.Test;


/**
 * Created by muneer on 9/7/2014.
 */
public class Navigate extends CommonApi{

    @Test
    public void searchBox()throws InterruptedException{
        clickByXpath(".//*[@id='hdMenuDiv']/ul/li[2]/a");
        sleep(3);
        clickByXpath(".//*[@id='lifeInsurance']/h2/a");
        sleep(5);





    }

}

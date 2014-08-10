package fbhome;

import common.CommonApi;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * User: rrt
 * Date: 8/10/14
 * Time: 1:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class FBHome extends CommonApi {

    @Test
    public void signIn()throws InterruptedException{
        typeByCss("#email", "magnumopium@yahoo.com");
        typeByCss("#pass", "selenium");
        enterKeys("#pass");
        sleep(3);
    }

}

package home;

import common.CommonApi;
import org.testng.annotations.Test;
import utility.DataReader;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: rrt
 * Date: 8/17/14
 * Time: 11:06 AM
 * To change this template use File | Settings | File Templates.
 */
public class ReadExcel extends CommonApi  {
    DataReader dataReader = new DataReader();
    String [][] locators;
    @Test
    public void topNav() throws IOException {
        String path = "C:\\Users\\rrt\\IdeaProjects\\Test-Automation-Framework\\excelfile.xls";
        locators = dataReader.fileReader(path);
        for(int i=0; i<locators.length; i++){
            for(int j=1; j<2; j++){
                String locator = locators[i][j];
                clickByCss(locator);
            }
        }
    }
}
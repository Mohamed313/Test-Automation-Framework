package db;

import com.mongodb.*;
import org.xml.sax.SAXException;
import utility.Student;
import utility.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: rrt
 * Date: 8/23/14
 * Time: 12:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class ConnectMongoDB {

    public static void main(String [] args) throws IOException, SAXException, ParserConfigurationException {
        String pathSelenium  = "C:\\Users\\rrt\\IdeaProjects\\Test-Automation-Framework\\Generic\\data.xml";
        String pathQtp = "C:\\Users\\rrt\\IdeaProjects\\Test-Automation-Framework\\Generic\\qtp.xml";
        String tag = "id";
        Map<String, List<Student>> map = new LinkedHashMap<String, List<Student>>();
        List<Student> listSelenium = new ArrayList<Student>();
        List<Student> listQtp = new ArrayList<Student>();
        XMLReader reader = new XMLReader();
        listSelenium = reader.parseData(tag,pathSelenium);
        listQtp = reader.parseData(tag,pathQtp);
        map.put("Selenium", listSelenium);
        map.put("QTP", listQtp);

        //Data Base start here
        MongoClient mc = new MongoClient();
        DB db = mc.getDB("myDB");
        Set<String> collectionOfDataBase = db.getCollectionNames();
        if(collectionOfDataBase.size()<1){
            db.createCollection("connection", new BasicDBObject("sample", true).append("size",1048576));
        }

        DBCollection collection = db.getCollection("testCollection");
        BasicDBList doc = new BasicDBList();

        doc.putAll(map);
        collection.insert(doc);
        //search to find data
        DBObject dbObject = collection.findOne();
        System.out.println(dbObject);

    }






}

package utility;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: rrt
 * Date: 8/23/14
 * Time: 1:13 PM
 * To change this template use File | Settings | File Templates.
 */

public class XMLReader {

    public List<Student> parseData(String tagName,String path) throws ParserConfigurationException, SAXException, IOException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        File file = new File(path);
        Document doc = builder.parse(file);
        NodeList nodeList = doc.getDocumentElement().getChildNodes();
        List<Student> list = new ArrayList<>();
        for(int i=0;i<nodeList.getLength(); i++){
            Node node = nodeList.item(i);
            if(node instanceof Element){
                Student student = new Student();
                student.id = node.getAttributes().getNamedItem(tagName).getNodeValue();
                NodeList childNodes = node.getChildNodes();
                for(int j=0;j<childNodes.getLength();j++){
                    Node cNode = childNodes.item(j);
                    if(cNode instanceof Element){
                        String content = cNode.getLastChild().getTextContent().trim();
                        String data = cNode.getNodeName();
                        switch(data){
                            case "firstName":
                                student.firstName = content;
                                break;
                            case "lastName":
                                student.lastName = content;
                                break;
                            case "score":
                                student.score = convertIntToChar(content);
                                break;
                        }
                    }
                }
                list.add(student);
            }

        }
        return list;
    }
    public String convertIntToChar(String score){
        String grade = "";
        int value = Integer.parseInt(score);
        if(value>=90){
            grade="A";
        }else if(value>=80){
            grade="B";
        }else if(value>=70){
            grade="C";
        }
        return grade;
    }

}

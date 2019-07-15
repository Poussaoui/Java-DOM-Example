package javadomexample;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ParseXML {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, Exception {
        List<Student> students = parseStudentsXML();
        System.out.println(students);
        createXmlDoc();
    }

    private static List<Student> parseStudentsXML() throws ParserConfigurationException, SAXException, IOException, Exception {
        //Initialize a list of students
        List<Student> students = new ArrayList<Student>();
        Student student = null;

//        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//        DocumentBuilder builder = factory.newDocumentBuilder();
//        Document document = builder.parse(new File("students.xml"));
//        document.getDocumentElement().normalize();
//        NodeList nList = document.getElementsByTagName("student");
//        for (int temp = 0; temp < nList.getLength(); temp++) {
//            Node node = nList.item(temp);
//            if (node.getNodeType() == Node.ELEMENT_NODE) {
//                Element eElement = (Element) node;
//                //Create new Student Object
//                student = new Student();
//                student.setId(Integer.parseInt(eElement.getAttribute("id")));
//                student.setFirstName(eElement.getElementsByTagName("firstName").item(0).getTextContent());
//                student.setLastName(eElement.getElementsByTagName("lastName").item(0).getTextContent());
//                student.setMail(eElement.getElementsByTagName("mail").item(0).getTextContent());
//
//                //Add Student to list
//                students.add(student);
//            }
//        }
        // Parse the given document
        XmlDomDocument doc = new XmlDomDocument("students.xml");
        int count = doc.getChildCount("students", 0, "student");
        for (int i = 0; i < count; i++) {

            //Create new Student Object
            student = new Student();
            
            student.setId(Integer.parseInt(doc.getChildAttribute("students", 0, "student", i, "id")));
            student.setFirstName(doc.getChildValue("student", i, "firstName", 0));
            student.setLastName(doc.getChildValue("student", i, "lastName", 0));
            student.setMail(doc.getChildValue("student", i, "mail", 0));

            //Add Student to list
            students.add(student);
        }

        return students;
    }

    private static void createXmlDoc() throws Exception {
        // Build the same document programmatically
        XmlDomDocument newdoc = new XmlDomDocument();
        newdoc.addChildElement(null, 0, "students", null);
        newdoc.addChildElement("students", 0, "student", null);
        newdoc.setAttributeValue("student", 0, "id", "444");
        newdoc.addChildElement("student", 0, "firstName", "Giada");
        newdoc.addChildElement("student", 0, "lastName", "Laurentis");
        newdoc.addChildElement("student", 0, "mail", "Giada.Laurentis@gmail.com");
        newdoc.addChildElement("students", 0, "student", null);
        newdoc.setAttributeValue("student", 1, "id", "555");
        newdoc.addChildElement("student", 1, "firstName", "Joe");
        newdoc.addChildElement("student", 1, "lastName", "Rowling");
        newdoc.addChildElement("student", 1, "mail", "Joe.Rowling@gmail.com");
        System.out.println(newdoc.renderXml());
    }
}

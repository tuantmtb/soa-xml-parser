/**
 * Created by tuantmtb on 3/31/17.
 */

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import model.Book;
import org.apache.commons.io.IOUtils;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class DomParser {
    public static void main(String[] args) throws Exception {

        try {
            List<Book> lstBook = new ArrayList<Book>();
            File inputFile = new File("data_xml/book.xml");

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("book");

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    // extract data book
                    String id = eElement.getAttribute("id");
                    String title = eElement.getElementsByTagName("title").item(0).getTextContent();
                    String genre = eElement.getElementsByTagName("genre").item(0).getTextContent();
                    float price = new Float(eElement.getElementsByTagName("price").item(0).getTextContent());
                    String publish_date = eElement.getElementsByTagName("publish_date").item(0).getTextContent();
                    String description = eElement.getElementsByTagName("description").item(0).getTextContent();
                    String author = eElement.getElementsByTagName("author").item(0).getTextContent();
                    Book book = new Book(id, title, author, genre, price, publish_date, description);
                    lstBook.add(book);
                }
            }

            // get list by order price
            lstBook.sort(Comparator.comparing(Book::getPrice));
            lstBook.forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

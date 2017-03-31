

import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by tuantmtb on 3/31/17.
 */
public class SaxParserDemo {

    public static void main(String argv[]) {

        try {

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {

                boolean bId;
                boolean bTitle;
                boolean bAuthor;
                boolean bGenre;
                boolean bPrice;
                boolean bPublish_date;
                boolean bDescription;

                public void startElement(String uri, String localName, String qName,
                                         Attributes attributes) throws SAXException {

//                    System.out.println("Start Element :" + qName);

                    if (qName.equalsIgnoreCase("id")) {
                        bId = true;
                    }

                    if (qName.equalsIgnoreCase("title")) {
                        bTitle = true;
                    }

                    if (qName.equalsIgnoreCase("author")) {
                        bAuthor = true;
                    }
                    if (qName.equalsIgnoreCase("genre")) {
                        bGenre = true;
                    }
                    if (qName.equalsIgnoreCase("price")) {
                        bPrice = true;
                    }
                    if (qName.equalsIgnoreCase("publish_date")) {
                        bPublish_date = true;
                    }
                    if (qName.equalsIgnoreCase("description")) {
                        bDescription = true;
                    }


                }

                public void endElement(String uri, String localName,
                                       String qName) throws SAXException {

//                    System.out.println("End Element :" + qName);

                }

                public void characters(char ch[], int start, int length) throws SAXException {

                    if (bId) {
                        String id  = new String(ch, start, length);
                        System.out.println(id);
                        bId =false;
                    }
                    if (bTitle) {
                        String title  = new String(ch, start, length);
                        System.out.println(title);
                        bTitle=false;
                    }


                }

            };

            saxParser.parse("/Volumes/DATA/tuantm/STUDY/SOA/xml-parser/data_xml/book.xml", handler);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
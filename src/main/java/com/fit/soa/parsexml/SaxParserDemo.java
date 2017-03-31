package com.fit.soa.parsexml;

import java.util.Comparator;
import java.util.List;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


/**
 * Created by tuantmtb on 3/31/17.
 */
public class SaxParserDemo {

    public void parser(){
        try {

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            BookHandler handler = new BookHandler();

            saxParser.parse("data_xml/book.xml", handler);
            List<Book> lstBook = handler.getLstBook();
            lstBook.sort(Comparator.comparing(Book::getPrice));
            lstBook.forEach(book -> System.out.println(book.getTitle() + ", - price: " + book.getPrice()));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String argv[]) {

        new SaxParserDemo().parser();
    }

}
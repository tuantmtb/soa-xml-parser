package com.fit.soa.parsexml;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


/**
 * Created by tuantmtb on 3/31/17.
 */
public class BookHandler extends DefaultHandler {

    Book book = null;
    List<Book> lstBook = null;
    boolean bId;
    boolean bTitle;
    boolean bAuthor;
    boolean bGenre;
    boolean bPrice;
    boolean bPublish_date;
    boolean bDescription;

    public List<Book> getLstBook() {
        return lstBook;
    }

    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {


        if (qName.equalsIgnoreCase("book")) {
            bId = true;
            String id = attributes.getValue("id");
            book = new Book();
            book.setId(id);
            if (lstBook == null) {
                lstBook = new ArrayList<>();
            }
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

        if (qName.equalsIgnoreCase("book")) {
            lstBook.add(book);
        }

    }

    public void characters(char ch[], int start, int length) throws SAXException {

        if (bTitle) {
            String title = new String(ch, start, length);
            book.setTitle(title);
            bTitle = false;
        }
        if (bAuthor) {
            String author = new String(ch, start, length);
            book.setAuthor(author);
            bAuthor = false;
        }

        if (bGenre) {
            String genre = new String(ch, start, length);
            book.setGenre(genre);
            bGenre = false;
        }

        if (bPrice) {
            float price = new Float(new String(ch, start, length));
            book.setPrice(price);
            bPrice = false;
        }

        if (bPublish_date) {
            String publish_date = new String(ch, start, length);
            book.setPublish_date(publish_date);
            bPublish_date= false;
        }
        if (bDescription) {
            String description = new String(ch, start, length);
            book.setDescription(description);
            bDescription= false;
        }

    }

}
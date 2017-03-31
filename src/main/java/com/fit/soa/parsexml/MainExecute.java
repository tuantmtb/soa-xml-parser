package com.fit.soa.parsexml;

/**
 * Created by tuantmtb on 3/31/17.
 */
public class MainExecute {

    public static void main(String[] args) throws Exception {
        System.out.println("Parser by DOM");
        System.out.println("=======");
        new DomParser().parser();
        System.out.println("=======\n");
        System.out.println("Parser by SAX");
        System.out.println("=======");
        new SaxParserDemo().parser();
        System.out.println("=======");

    }
}

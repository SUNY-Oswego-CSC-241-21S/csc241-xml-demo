package csc241;

import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            MyHandler handler = new MyHandler();
            File input = new File("holidays.xml");
            saxParser.parse(input, handler);

            // Get list of holidays
            for (Holiday h: handler.getHolidayList()) {
                System.out.println(h);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

package csc241;

import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;

import java.util.ArrayList;

public class MyHandler extends DefaultHandler {

    private String currentMonth;
    private Holiday currentHoliday;
    private ArrayList<Holiday> holidayList = new ArrayList<>();

    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {

        //System.out.println("URI: " + uri);
        //System.out.println("LOCALNAME: " + localName);
        //System.out.println("QNAME: " + qName);
        //System.out.println("ATTRIBUTES: " + attributes);

        if (qName.equals("month")) {
            // Get name attribute
            String name = attributes.getValue("name");
            currentMonth = name;
            //System.out.println("\tNAME: " + name);
        } else if (qName.equals("holiday")) {
            // Get day and name attributes
            String day = attributes.getValue("day");
            String name = attributes.getValue("name");
            currentHoliday = new Holiday(currentMonth, Integer.parseInt(day), name);

            //System.out.println("\tDAY: " + day);
            //System.out.println("\tNAME: " + name);
        } else if (qName.equals("federal")) {
            String federal = attributes.getValue("value");
            currentHoliday.setFederal(federal.equals("yes"));
            //System.out.println("\tFEDERAL: " + federal);
        } else if (qName.equals("oswego")){
            String oswego = attributes.getValue("value");
            currentHoliday.setOswego(oswego.equals("yes"));
            //System.out.println("\tOSWEGO: " + oswego);
        }
    }

    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if (qName.equals("holiday")){
            holidayList.add(currentHoliday);
            //System.out.println(currentHoliday);
        }
    }

    public ArrayList<Holiday> getHolidayList() {
        return holidayList;
    }
}

package handler;

import entity.Candy;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class Handler {
    private Reader reader;
    private XMLStreamReader xmlStreamReader;

    public Handler() throws FileNotFoundException, XMLStreamException {
        XMLInputFactory factory = XMLInputFactory.newFactory();

        reader = new FileReader("src/main/java/xml/candies.xml");
        xmlStreamReader = factory.createXMLStreamReader(reader);

    }

    public List<Candy> getAll() throws XMLStreamException {
        List<Candy> candies = new ArrayList<>();
        Candy candy = new Candy();

        while (xmlStreamReader.hasNext()) {

            switch (xmlStreamReader.next()) {
                case XMLStreamReader.START_ELEMENT:

                    String elem = xmlStreamReader.getName().toString();

                    switch (elem) {
                        case "name": {
                            candy.setName(xmlStreamReader.getElementText());
                            System.out.println("name: " + candy.getName());
                            break;
                        }

                        case "type": {
                            candy.setType(xmlStreamReader.getElementText());
                            System.out.println("type: " + candy.getType());
                            break;
                        }
                        case "manufacturer": {
                            candy.setManufacturer(xmlStreamReader.getElementText());
                            System.out.println("manufacturer: " + candy.getManufacturer());
                            break;
                        }
                        case "weight": {
                            candy.setWeight(Integer.parseInt(xmlStreamReader.getElementText()));
                            System.out.println("weight: " + candy.getWeight());
                            break;
                        }

                        case "price": {
                            candy.setPrice(Double.parseDouble(xmlStreamReader.getElementText()));
                            System.out.println("price: " + candy.getPrice());
                            break;
                        }
                    }
                    break;

                case XMLStreamReader.END_ELEMENT: {
                    String s = String.valueOf(xmlStreamReader.getName());
                    if (s.equals("candy")) {
                        candies.add(candy);
                        candy = new Candy();
                        System.out.println();
                    }
                    break;
                }
            }
        }
        return candies;
    }
}

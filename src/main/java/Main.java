import entity.Candy;
import handler.Handler;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * Создать xml-документ candies.xml, с корневым элементом, который будет в себе содержать несколько, c характеристиками конфеты.
 * Используя StAX-парсер получить коллекцию Candy из xml-файла.
 */

public class Main {
    public static void main(String[] args) throws XMLStreamException, FileNotFoundException {
        Handler handler = new Handler();
        List<Candy> candies = handler.getAll();
        System.out.println((char) 27 + "[34m" + "\nAll candies: " + (char) 27 + "[38m");
        for (Candy candy : candies) {
            System.out.println(candy.getName() + " " + candy.getType() + " "
                    + candy.getManufacturer() + " " + candy.getWeight() + " "
                    + candy.getPrice()
            );
        }
    }
}

package ua.com.alevel.task2;

import java.io.File;
import java.util.Map;


public class App {
    public static void main(String[] args) {
        JsonBuilder jsonBuilder = new JsonBuilder();

        String [] colors = {"red", "black", "grey" };
        Car car = new Car("Toyota", "Land Cruiser", colors,
                "km/hour", 250, 2.3,
                2100, "11.8:1", 4);

        File jsonFile = new File("src//main//resources//car.json");
        Map<String, Object> map = jsonBuilder.createMapToWrite(car);
        jsonBuilder.createJsonFile(jsonFile, map);
    }


}

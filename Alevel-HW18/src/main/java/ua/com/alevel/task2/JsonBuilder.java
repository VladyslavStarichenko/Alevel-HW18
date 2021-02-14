package ua.com.alevel.task2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class JsonBuilder {


    public static final String ENTER = "\n";
    public static final String COMMA = ",";
    public static final String Tabulation = "\t";
    public static final String curlyBracesRight = "{";
    public static final String curlyBracesLeft = "}";
    public static final String DOUBLEPOINTS = ":";
    public static final String QUOTES = "\"";
    public static final String squareBraceRight = "[";
    public static final String squareBraceLeft = "]";

    void createJsonFile(File file, Map<String, Object> map) {
        try (FileWriter fileWriter = new FileWriter(file)) {
            startWrite(fileWriter);
            writeMainObj(map, fileWriter);
            endWrite(fileWriter);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void startWrite(FileWriter writer) throws IOException {
        writer.write(Tabulation + curlyBracesRight + ENTER);
    }

    private void endWrite(FileWriter writer) throws IOException {
        writer.write( Tabulation + curlyBracesLeft);
    }

    public static Map<String, Object> createMapToWrite(Car car) {
        Map<String, Object> carCharacteristics = new TreeMap<>();
        Map<String, Object> speedCharacteristics = new TreeMap<>();
        Map<String, Object> engineCharacteristics = new TreeMap<>();


        engineCharacteristics.put("volume", car.getVolume());
        engineCharacteristics.put("rpm", car.getRpm());
        engineCharacteristics.put("compressionRatio", car.getCompressionRatio());
        speedCharacteristics.put("unit", car.getSpeedUnit());
        speedCharacteristics.put("value", car.getSpeedValue());
        carCharacteristics.put("brand", car.getBrand());
        carCharacteristics.put("model", car.getModel());
        carCharacteristics.put("colors", car.getColors());
        carCharacteristics.put("maxSpeed", speedCharacteristics);
        carCharacteristics.put("engine", engineCharacteristics);
        carCharacteristics.put("seatingCapacity", car.getSeatingCapacity());

        return carCharacteristics;
    }


    private void writeMainObj(Map<String, Object> map, FileWriter writer) throws IOException {
        int counter = 0;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            StringBuilder valueToWrite = new StringBuilder();
            StringBuilder keyToWrite = formation(entry.getKey());
            if (entry.getValue() instanceof Map) {
                writer.write(Tabulation + keyToWrite + DOUBLEPOINTS + curlyBracesRight + ENTER);
                writeMainObj((Map<String, Object>) entry.getValue(), writer);
                writer.append(Tabulation + curlyBracesLeft);
            } else {
                StringBuilder value = formation(entry.getValue());
                valueToWrite.append(Tabulation).append(keyToWrite).append(DOUBLEPOINTS).append(value);
                writer.write(valueToWrite.toString());
            }
            counter++;
            if (counter < map.size()) {
                writer.append(COMMA + ENTER);
            } else {
                writer.append(ENTER);
            }
        }
    }


    private StringBuilder formation(Object object) {
        Integer counter = 0;
        StringBuilder stringBuilder = new StringBuilder();
        if (object.getClass().isArray()) {
            String[] array = ((String[]) object);
            stringBuilder.append(squareBraceRight + ENTER);
            for (String arrSub : array) {
                counter++;
                stringBuilder.append(  Tabulation+ QUOTES + arrSub + QUOTES );

                if (counter <= array.length -1) {
                    stringBuilder.append(COMMA + ENTER);

                }


            }
            stringBuilder.append(ENTER + Tabulation + squareBraceLeft);
        } else if (object instanceof Integer || object instanceof Double) {
            stringBuilder.append(object);
        } else {
            stringBuilder.append(QUOTES).append(object).append(QUOTES);
        }
        return stringBuilder;
    }



}

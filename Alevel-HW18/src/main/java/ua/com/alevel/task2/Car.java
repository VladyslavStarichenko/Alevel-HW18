package ua.com.alevel.task2;

import java.util.Arrays;

public class Car {
    private String brand;
    private String model;
    private String[] colors;
    private String speedUnit;
    private Integer speedValue;
    private Double volume;
    private Integer rpm;
    private String compressionRatio;
    private Integer seatingCapacity;

    public Car(String brand, String model, String[] colors, String speedUnit, Integer speedValue, Double volume, Integer rpm, String compressionRatio, Integer seatingCapacity) {
        this.brand = brand;
        this.model = model;
        this.colors = colors;
        this.speedUnit = speedUnit;
        this.speedValue = speedValue;
        this.volume = volume;
        this.rpm = rpm;
        this.compressionRatio = compressionRatio;
        this.seatingCapacity = seatingCapacity;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", colors=" + Arrays.toString(colors) +
                ", speedUnit='" + speedUnit + '\'' +
                ", speedValue=" + speedValue +
                ", volume=" + volume +
                ", rpm=" + rpm +
                ", compressionRatio='" + compressionRatio + '\'' +
                ", seatingCapacity=" + seatingCapacity +
                '}';
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String[] getColors() {
        return colors;
    }

    public String getSpeedUnit() {
        return speedUnit;
    }

    public Integer getSpeedValue() {
        return speedValue;
    }

    public Double getVolume() {
        return volume;
    }

    public Integer getRpm() {
        return rpm;
    }

    public String getCompressionRatio() {
        return compressionRatio;
    }

    public Integer getSeatingCapacity() {
        return seatingCapacity;
    }


}
public class Laptop {
    private String model;
    private int RAM; // В гигабайтах
    private int HDDSize; // В гигабайтах
    private String operatingSystem;
    private String color;
    private double price;


    public Laptop(String model, int RAM, int HDDSize, String operatingSystem, String color, double price) {
        this.model = model;
        this.RAM = RAM;
        this.HDDSize = HDDSize;
        this.operatingSystem = operatingSystem;
        this.color = color;
        this.price = price;

    }

    public String getModel() {
        return model;
    }

    public int getRAM() {
        return RAM;
    }

    public int getHDDSize() {
        return HDDSize;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

}

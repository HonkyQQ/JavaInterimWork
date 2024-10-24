import java.util.*;

public class LaptopMarket {
    public static void main(String[] args) {

        List<Laptop> laptops = new ArrayList<>();
        laptops.add(new Laptop("Acer Aspire 5", 8, 512, "Windows 11", "Black", 50000));
        laptops.add(new Laptop("Lenovo IdeaPad 3", 16, 1000, "Windows 10", "Gray", 65000));
        laptops.add(new Laptop("HP Envy x360", 12, 256, "Windows 11", "Silver", 70000));
        laptops.add(new Laptop("Asus ZenBook 13", 8, 512, "Windows 11", "Blue", 80000));
        laptops.add(new Laptop("Dell XPS 13", 16, 1000, "Windows 11", "Gold", 100000));
    }
}

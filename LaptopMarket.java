import java.util.*;

public class LaptopMarket {
    public static void main(String[] args) {

        List<Laptop> laptops = new ArrayList<>();
        laptops.add(new Laptop("Acer Aspire 5", 8, 512, "Windows 11", "Black", 50000));
        laptops.add(new Laptop("Lenovo IdeaPad 3", 16, 1000, "Windows 10", "Gray", 65000));
        laptops.add(new Laptop("HP Envy x360", 12, 256, "Windows 11", "Silver", 70000));
        laptops.add(new Laptop("Asus ZenBook 13", 8, 512, "Windows 11", "Blue", 80000));
        laptops.add(new Laptop("Dell XPS 13", 16, 1000, "Windows 11", "Gold", 100000));

        Scanner scanner = new Scanner(System.in);
        Map<String, String> filterCriteria = new HashMap<>();

        System.out.println("Введите цифру, выбрав вариант для фильтрации: ");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объем ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                filterCriteria.put("RAM", "greaterThan");
                break;
            case 2:
                filterCriteria.put("HDDSize", "greaterThan");
                break;
            case 3:
                filterCriteria.put("operatingSystem", "equals");
                break;
            case 4:
                filterCriteria.put("color", "equals");
                break;
            default:
                System.out.println("Неверный  ввод. ");
                return;
        }

        System.out.print("Введите минимальное значение для " + filterCriteria.keySet().iterator().next() + ": ");
        String minValue = scanner.nextLine();

        List<Laptop> filteredLaptops = filterLaptops(laptops, filterCriteria, minValue);

        System.out.println("Отфильтрованные ноутбуки:");
        for (Laptop laptop : filteredLaptops) {
            laptop.printInfo();
        }


    }
}

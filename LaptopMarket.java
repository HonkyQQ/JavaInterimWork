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

        System.out.println("Чтобы отфильтровать ноутбук по цвету или версии Windows, напишите его на английском языке.");
        System.out.println("Введите минимальное значение для " + filterCriteria.keySet().iterator().next() + ": ");
        String minValue = scanner.nextLine();

        List<Laptop> filteredLaptops = filterLaptops(laptops, filterCriteria, minValue);

        System.out.println("Отфильтрованные ноутбуки:");
        for (Laptop laptop : filteredLaptops) {
            laptop.printInfo();
        }

    }

    public static List<Laptop> filterLaptops(List<Laptop> laptops, Map<String, String> filterCriteria, String minValue) {
        List<Laptop> filteredLaptops = new ArrayList<>();
        for (Laptop laptop : laptops) {
            boolean matches = true;
            for (Map.Entry<String, String> entry : filterCriteria.entrySet()) {
                String criterion = entry.getKey();
                String operator = entry.getValue();
                switch (criterion) {
                    case "RAM":
                        if (operator.equals("greaterThan") && laptop.getRAM() < Integer.parseInt(minValue)) {
                            matches = false;
                        } else if (operator.equals("equals") && laptop.getRAM() != Integer.parseInt(minValue)) {
                            matches = false;
                        }
                        break;
                    case "HDDSize":
                        if (operator.equals("greaterThan") && laptop.getHDDSize() < Integer.parseInt(minValue)) {
                            matches = false;
                        } else if (operator.equals("equals") && laptop.getHDDSize() != Integer.parseInt(minValue)) {
                            matches = false;
                        }
                        break;
                    case "operatingSystem":
                        if (operator.equals("equals") && !laptop.getOperatingSystem().equals(minValue)) {
                            matches = false;
                        }
                        break;
                    case "color":
                        if (operator.equals("equals") && !laptop.getColor().equals(minValue)) {
                            matches = false;
                        }
                        break;
                }
            }
            if (matches) {
                filteredLaptops.add(laptop);
            }
        }
        return filteredLaptops;
    }
}

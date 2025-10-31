package domashka.module1_2;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Main {
    static String name = "Ilona";
    static int age = 23;
    static double height = 1.68;
    static boolean isQA = true;

    public static void main(String[] args) {
        securityCheckBuyAge();
        actionWithDifferentDayOfWeek();
        Numbers1to5();
        printVariables();
        printHelloWorld();
        linearSearch();
        checkTemperature();
        userCalculator();
        printStudents();
        showStudentNames();
        showCities();
        divideNumbers(10, 2);
        divideNumbers(5, 0);
        checkLoginTest();
        Product.demo();
        safeDivide(18, 2);
        safeDivide(7, 0);

        User admin = new Admin();
        User customer = new Customer();

        User[] users = {admin, customer};

        for (User u : users) {
            String role = u.getRole();
            System.out.println("Роль: " + role);

            if ("domashka.module1_2.Admin".equals(role)) {
                System.out.println("Доступ: керування товарами та користувачами");
            } else if ("domashka.module1_2.Customer".equals(role)) {
                System.out.println("Доступ: перегляд і покупка товарів");
            } else {
                System.out.println("Доступ: невідома роль");
            }
        }

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        System.out.println("Title: " + driver.getTitle());
        driver.quit();

        Product p1 = new Product("Ноутбук", 32000.50, true);
        Product p2 = new Product("Смартфон", -5000.00, true);

        try {
            p1.validatePrice();
            System.out.println("Перевірка пройдена: ціна валідна");
        } catch (InvalidPriceException e) {
            System.out.println("Помилка: " + e.getMessage());
        }

        try {
            p2.validatePrice(); // тут буде виняток
            System.out.println("Перевірка пройдена: ціна валідна");
        } catch (InvalidPriceException e) {
            System.out.println("Помилка: " + e.getMessage());
        }


        HashMap<String, Double> products = new HashMap<>();

        products.put("Ноутбук", 32000.50);
        products.put("Смартфон", 18000.00);
        products.put("Навушники", 2500.99);

        System.out.println("Список продуктів і цін:");
        for (Map.Entry<String, Double> entry : products.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue() + " грн");
        }

        DiscountedProduct discountedPhone = new DiscountedProduct("Телефон", 10699.99, true, 50.0);

        System.out.println("\nТовар зі знижкою:");
        discountedPhone.printProductInfo();
        System.out.println("Ціна зі знижкою: " + discountedPhone.priceWithDiscount() + " грн");


        HashSet<String> categories = new HashSet<>();

        categories.add("Електроніка");
        categories.add("Одяг");
        categories.add("Побутова техніка");

        System.out.println("Список категорій:");
        for (String category : categories) {
            System.out.println(category);
        }

        String searchCategory = "Одяг";
        if (categories.contains(searchCategory)) {
            System.out.println("Категорія \"" + searchCategory + "\" є в наборі.");
        } else {
            System.out.println("Категорії \"" + searchCategory + "\" немає в наборі.");
        }

        ArrayList<Product> productList = new ArrayList<>();

        productList.add(new Product("Ноутбук", 32000.50, true));
        productList.add(new Product("Смартфон", 18000.00, true));
        productList.add(new Product("Навушники", 2500.99, false));

        for (Product product : productList) {
            product.printProductInfo();
        }
    }

    public static void safeDivide(int a, int b) {
        try {
            int result = a / b;
            System.out.println("Результат: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Помилка: ділення на нуль неможливе!");
        } finally {
            System.out.println("Операція завершена");
        }
    }

    public static void checkLoginTest() {
        String expected = "Login successful";
        String actual = "Login successful";

        if (expected.equals(actual)) {
            System.out.println("Тест пройдено");
        } else {
            System.out.println("Тест не пройдено");
        }
    }

    public static void divideNumbers(int a, int b) {
        try {
            int result = a / b;
            System.out.println("Результат: " + result);
        } catch (ArithmeticException e) {
            System.out.println("На нуль ділити не можна");
        }
    }

    public static void showCities() {
        ArrayList<String> cities = new ArrayList<>();

        cities.add("Тернопіль");
        cities.add("Бровари");
        cities.add("Яремче");
        cities.add("Львів");

        System.out.println(cities);
    }


    public static void printStudents() {
        String[] students = {"Ілона", "Cлавік", "Інеса", "Лєра", "Марійка"};

        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i]);
        }
    }

    public static void showStudentNames() {
        String[] students = {"Олег", "Андрій", "Софія", "Катерина", "Дмитро"};

        for (String student : students) {
            System.out.println(student);
        }
    }

    public static void userCalculator() {
        int result = Calculator.add(16, 4);
        System.out.println("Результат: " + result);
    }

    public static void checkTemperature() {
        int temperature = 8;
        String result = (temperature > 0) ? "плюс" : "мінус";
        System.out.println("Температура: " + result);
    }

    public static void linearSearch() {
        int[] numbers = {10, 20, 30, 40, 50};
        int target = 40;

        int result = linearSearch(numbers, target);

        if (result != -1) {
            System.out.println("Елемент знайдено, індекс: " + result);
        } else {
            System.out.println("Елемент не знайдено");
        }
    }

    public static void printHelloWorld() {
        System.out.println("Hello, World!");
    }

    public static void printVariables() {
        System.out.println(name);
        System.out.println(age);
        System.out.println(height);
        System.out.println(isQA);
    }

    public static void securityCheckBuyAge() {
        if (age < 18) {
            System.out.println("Доступ заборонено");
        } else {
            System.out.println("Доступ дозволено");
        }
    }

    public static void Numbers1to5() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
        }
    }

    public static void actionWithDifferentDayOfWeek() {
        String day = "Saturday";

        switch (day) {
            case "Monday":
            case "Tuesday":
            case "Wednesday":
            case "Thursday":
            case "Friday":
                System.out.println("Робочий день");
                break;

            case "Saturday":
            case "Sunday":
                System.out.println("Вихідний день");
                break;

            default:
                System.out.println("Невідомий день");

        }
    }

    public static int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }
}

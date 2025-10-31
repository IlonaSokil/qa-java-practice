package domashka.module1_2;

public class HashCodeExample {
    public static void main(String[] args) {
        String name = "Ilona";

        int hash = name.hashCode();

        System.out.println("Рядок: " + name);
        System.out.println("hashCode: " + hash);
    }
}

package hashmapsandhashfunctions.customhashmap;

public class Main {
    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();
        map.put("Alice", 25);
        map.put("Bob", 30);
        map.put("Charlie", 35);
        map.put("Alice", 28);

        System.out.println("Alice's Age: " + map.get("Alice"));
        System.out.println("Bob's Age: " + map.get("Bob"));

        map.remove("Bob");
        System.out.println("Bob's Age after removal: " + map.get("Bob"));

        map.printMap();
    }
}
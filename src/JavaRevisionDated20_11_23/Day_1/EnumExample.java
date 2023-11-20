package JavaRevisionDated20_11_23.Day_1;

public class EnumExample {
    enum Level {
        HIGH,
        LOW,
        MEDIUM
    }

    public static void main(String[] args) {
        Level level = Level.LOW;
//        System.out.println(level);

        switch (level) {
            case MEDIUM -> System.out.println("Level is MEDIUM");
            case HIGH -> System.out.println("Level is HIGH");
            case LOW -> System.out.println("Level is LOW");
        }
        for (Level s : Level.values()) {
            System.out.println(s);
        }
    }
}


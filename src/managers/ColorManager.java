package managers;

public enum ColorManager {
    DEFAULT("\033[0m"),GRAY("\033[37m"),
    GREEN("\033[32m"), YELLOW("\033[33m");

    final String color;

    ColorManager(String color) {
        this.color = color;
    }
}

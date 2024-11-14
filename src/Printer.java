public class Printer {
    String print;

    private Printer(String print) {
        this.print = print;
    }

    public static Printer ZERO = new Printer("""
            -------------------------
              |            |
              |
              |
              |
              |
              |
              |
              |
            """);

    public static Printer ONE = new Printer("""
            -------------------------
              |            |
              |            O
              |
              |
              |
              |
              |
              |
            """);
    public static Printer TWO = new Printer("""
            -------------------------
              |            |
              |            O
              |          -----
              |          |   |
              |          |   |
              |          -----
              |
              |
            """);

    public static Printer THREE = new Printer("""
            -------------------------
              |            |
              |            O
              |          -----
              |         /|   |
              |        / |   |
              |          -----
              |
              |
            """);
    public static Printer FOUR = new Printer("""
            -------------------------
              |            |
              |            O
              |          -----
              |         /|   |\\
              |        / |   | \\
              |          -----
              |
              |
            """);
    public static Printer FIVE = new Printer("""
            -------------------------
              |            |
              |            O
              |          -----
              |         /|   |\\
              |        / |   | \\
              |          -----
              |         /
              |        /
            """);
    public static Printer SIX = new Printer("""
            -------------------------
              |            |
              |            O
              |          -----
              |         /|   |\\
              |        / |   | \\
              |          -----
              |         /     \\
              |        /       \\
            """);

    @Override
    public String toString() {
        return print;
    }
}

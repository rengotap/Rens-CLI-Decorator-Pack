import java.util.concurrent.TimeUnit;

/**
 * A collection of functions that will help make your
 * Command Line Interfaces more visually engaging.
 * Note: Will not work on WIN32 consoles.
 * @author rengotap
 */
public class Decor {
    private static Decor instance;


    //ANSI RESET
    public static final String RESET = "\u001B[0m";

    // ANSI STANDARD COLORS
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001b[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String MAGENTA = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    // ANSI BACKGROUNDS
    public static final String BG_BLACK = "\u001b[40m";
    public static final String BG_RED = "\u001b[41m";
    public static final String BG_GREEN = "\u001B[42m";
    public static final String BG_YELLOW = "\u001B[43m";
    public static final String BG_BLUE = "\u001B[44m";
    public static final String BG_MAGENTA = "\u001B[45m";
    public static final String BG_CYAN = "\u001B[46m";
    public static final String BG_WHITE = "\u001B[47m";

    // ANSI FONT
    public static final String BOLD = "\u001b[1m";
    public static final String UNDERLINE = "\u001b[4m";

    // ANSI FUNCTIONAL (Moves the cursor)
    public static final String UP = "\u001b[{n}A";
    public static final String DOWN = "\\u001b[{n}B";
    public static final String LEFT = "\u001b[{n}C";
    public static final String RIGHT = "\u001b[{n}D";

    /**
     * Singleton constructor for Decor.
     * Creates a new instance of the class if it does not exist.
     * @return instance of Decor
     */
    public static Decor getInstance() {
        if (instance == null)
            instance = new Decor();
        return instance;
    } private Decor() {}

    /**
     * Clears the console screen using escape code
     * "\033[H\033[2J"
     */
    public void clr() {
        System.out.print("\033[H\033[2J");
    }

    /**
     * Generates an ANSI Escape Code out of rgb values
     * @param r red
     * @param g green
     * @param b blue
     * @return ANSI Escape Code
     */
    public String customColor(int r, int g, int b) {
        return "\033[38;2;"+r+";"+g+";"+b+"m";
    }

    /**
     * Pads the area around a string with spaces.
     * @param str Sting to pad
     * @param width Desired width
     * @return Padded String
     */
    public String pad(String str, int width) {
        int wStart = str.length() + (width - str.length()) / 2;
        str = String.format("%" + wStart + "s", str); // pad left
        return String.format("%" + (-width) + "s", str); // pad right
    }
    
    /**
     * Pauses the program until the user hits the enter key.
     * A very good way to break up your program
     */
    public void awaitEnter() {
        System.out.println('\n' + BG_WHITE + BLACK + "   PRESS ENTER TO CONTINUE   " + RESET);
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * A cute little "progress" bar that makes it look like you're busy
     */
    public void loadingBar() {
        String l = "🏠";  // What appears on the left side of the bar
        String r = "🏝️";  // What appears on the right side of the bar
        String body = "═";  // What the bar is made of
        String head = "✈";  // What sits at the end of the bar

        try {
            for (int i = 0; i < 100; i++) {
                TimeUnit.MILLISECONDS.sleep(70);
                int width = (i + 1);
                String bar = l + new String(new char[width]).replace("\0", body) + head
                        + new String(new char[36 - (width + 1)]).replace("\0", " ") + r + "  ";
                System.out.print("\33[2K\r" + bar);
                System.out.flush();
            }
        } catch (Exception e) {System.out.println('\n');}
    }
}
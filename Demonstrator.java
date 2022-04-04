import java.util.Scanner;

/**
 * A short tutorial that introduces users to the magic of 
 * ANSI Escape Codes
 * @author rengotap
 */
public class Demonstrator {

    private static Decor decor;
    private static Scanner input;

    /**
     * Tutorial.
     * @param args
     */
    public static void main(String[]args) {
        decor = Decor.getInstance();
        input = new Scanner(System.in);
        decor.clr();
        System.out.println("Do you know what " + Decor.RED + "ANSI Escape Codes" + Decor.RESET + " are?" + '\n' +
                            "If you don't, there's no reason to worry."+'\n'+
                            "After this short tutorial you'll be formatting text like a pro!");
        decor.awaitEnter();
        decor.clr();

        System.out.println("ANSI Escape Codes look like this: ＂⧹u001b[41m＂." + '\n' +
                            "You can use them almost like HTML tags to create " + Decor.BOLD + "rich text" + Decor.RESET + "!");
        System.out.println("Just like in HTML, you can use ANSI Escape Codes to highlight your point using " +
                            Decor.BOLD + "bold " + Decor.RESET + 
                            "and " + 
                            Decor.UNDERLINE + "underline" + Decor.RESET + " tags.");
        decor.awaitEnter();
        decor.clr();

        System.out.println("Formatting text is simple." + '\n' +
                            "Just put the ANSI code you want to use, your string, and the reset code." + '\n' + Decor.BOLD +
                            "Any text between the selected code and the reset code will have the desired properties applied to it."+ Decor.RESET + '\n' +
                            "Lets say we want to make some text red using the escape code ＂⧹u001b[41m＂." + '\n' + '\n' +
                            "The statement: ＂⧹u001b[31m＂ + ＂this text is red.＂ + ＂⧹u001B[0m＂ + ＂ this text is not.＂" + '\n' +
                            "Results in: "+"\u001b[31m"+"this text is red."+"\u001B[0m" + " this text is not." + '\n' + '\n' +
                            Decor.BOLD+"Notice that the text returns to normal after the reset code ＂⧹u001B[0m＂."+Decor.RESET);
        decor.awaitEnter();
        decor.clr();

        System.out.println("To make life a little easier, simply move the Decor class into your project," + 
                            " or assign the escape codes to static variables." + '\n' +
                            "It's a lot easier and readable than using the raw ANSI codes themselves." + '\n'+ '\n' +
                            "For Example..." + '\n' +
                            "The statement: Decor.RED + ＂hello＂ + Decor.RESET + ＂ world＂" + '\n' +
                            "Results in: "+Decor.RED + "hello"+Decor.RESET + " world" + '\n' +
                            "Much better.");
        decor.awaitEnter();
        decor.clr();

        System.out.println("Its really that easy!"+'\n'+
                            "Now that you know the basic format, let's see some of the cool things you can do with ANSI.");
        decor.awaitEnter();
        decor.clr();

        System.out.println("Most terminals have at least " + Decor.GREEN 
                            + "eight"+Decor.RESET + " text colors to choose from" + '\n');

        System.out.println(
                            Decor.WHITE + "White " + Decor.RESET +
                            Decor.RED + "Red " + Decor.RESET +
                            Decor.YELLOW + "Yellow " + Decor.RESET +
                            Decor.GREEN + "Green " + Decor.RESET +
                            Decor.CYAN + "Cyan " + Decor.RESET +
                            Decor.BLUE + "Blue " + Decor.RESET +
                            Decor.MAGENTA + "Magenta " + Decor.RESET +
                            Decor.BLACK + "Black " + Decor.RESET
                            );
        decor.awaitEnter();
        decor.clr();
        System.out.println("These colors can also be used as " + Decor.BG_MAGENTA 
                            + "backgrounds" + Decor.RESET + '\n');

        System.out.println(
                            Decor.BG_WHITE + "White" + Decor.RESET + " " +
                            Decor.BG_RED + "Red" + Decor.RESET + " " +
                            Decor.BG_YELLOW + "Yellow" + Decor.RESET + " " +
                            Decor.BG_GREEN + "Green" + Decor.RESET + " " +
                            Decor.BG_CYAN + "Cyan" + Decor.RESET + " " +
                            Decor.BG_BLUE + "Blue" + Decor.RESET + " " +
                            Decor.BG_MAGENTA + "Magenta" + Decor.RESET + " " +
                            Decor.BG_BLACK + "Black" + Decor.RESET
                            );
        decor.awaitEnter();
        decor.clr();

        System.out.println("You can use " + Decor.BG_RED + Decor.BOLD + Decor.BLACK + "multiple tags" + Decor.RESET
                            + " at once! Don't be afraid to " + Decor.BG_CYAN + Decor.MAGENTA + "mix" + Decor.RESET 
                            + " and " 
                            + Decor.BLUE + Decor.UNDERLINE + "match" + Decor.RESET);
        decor.awaitEnter();
        decor.clr();

        System.out.println("Did you know you can make "+Decor.BOLD+"custom colors"+Decor.RESET+" too?" +
                            '\n' + "The Decor class has a method for that, so don't worry about implementation." + '\n');
        customColorMenu();
        decor.clr();

        System.out.println("ANSI Escape Codes can do more than just text format." + '\n'+
                            "Did you know that the code ＂⧹033[H⧹033[2J＂ has been clearing the screen this entire time?" + '\n' +
                            "Find it in Decor's clr() method!");
        decor.awaitEnter();
        decor.clr();

        System.out.println("These basic escape codes should help add a little visual flare to your project. " + '\n' +
                            "Of course, this is only scratching the surface. With a little creativity, you could make things like...");
        decor.awaitEnter();
        System.out.println(decor.pad("This Progress Bar!",43));
        decor.loadingBar();
        System.out.println("Take a look at the decor class to see some of the ANSI Codes and my favorite UI methods from when I was doing this project." + '\n' +
                            "May they serve your UI as well as they served mine" + '\n' +
                            Decor.CYAN+Decor.BOLD+"Good Luck!"+Decor.RESET);
    }

    /**
     * A small menu that lets the user generate custom colors
     */
    private static void customColorMenu() {
        while (true) {
            int r = prompt256("Enter a value for red");
            int g = prompt256("Enter a value for green");
            int b = prompt256("Enter a value for blue");
            decor.clr();
            System.out.println('\n' + decor.customColor(r, g, b) + "Your color ("
                                + r + ", " + g + ", " + b + ")" +Decor.RESET);

            if (!promptYN("Generate another color?"))
                return;
            decor.clr();
        }
    }

    /**
     * Prompts the user to enter a value from 0 - 255
     * @param prompt query
     * @return value
     */
    private static int prompt256(String prompt) {
        System.out.println(prompt + " (0-255)");
        String response;
        while (true) {
            System.out.print("> ");
            response = input.nextLine();
            try {
                int value = Integer.parseInt(response);
                if (value < 0 || value >= 256) {
                    throw new Exception();
                }
                return value;
            } catch (Exception e) {
                System.out.println("Invalid number.");
            }
        }
    }

    /**
     * Prompts the user to answer yes or no
     * @param prompt query
     * @return True if yes, False if no
     */
    private static boolean promptYN(String prompt) {
        System.out.println(prompt + " (y/n)");
        String response;
        while (true) {
            System.out.print("> ");
            response = input.nextLine();
            if (response.equals("y"))
                return true;
            else if (response.equals("n"))
                return false;
            else
                System.out.println("Invalid option");
        }
    }
}

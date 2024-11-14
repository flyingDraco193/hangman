import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Main {

    private static final String PROPERTY_NAME = "user.dir";
    private static final String FILE_NAME = "\\russian_surnames.txt";
    private static final int NUM_ERR_FOR_LOSE = 6;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        List<String> listOfWords = new ArrayList<>();
        Path path = readFileOfWords();
        fillListOfWOrds(listOfWords, path);
        String secretWord = getRandomWord(listOfWords);
        Set<String> enteredLettersSet = new HashSet<>();

        String[] secretWordArray = new String[secretWord.length()];
        Arrays.fill(secretWordArray, "_");

        System.out.println("Welcome!");

        while (true) {
            printGreetings();
            int errorCounter = 0;
            int numOfVariantGame = scanner.nextInt();
            scanner.nextLine();
            switch (numOfVariantGame) {
                case 1:
                    boolean findLetterFlag = true;
                    while (findLetterFlag) {
                        System.out.println("Please, Enter your letter");
                        String expectedLetterString = scanner.nextLine();

                        if (!isValidExpectedLetterString(expectedLetterString)) {
                            System.out.println("Incorrect input");
                            System.out.println("Please, enter only 1 lowercase letter");
                        } else {
                            if (hasEntered(enteredLettersSet, expectedLetterString)) {
                                System.out.println("You have already entered this letter: " + expectedLetterString);
                                System.out.println("Please, enter another letter");
                                continue;
                            }
                            enteredLettersSet.add(expectedLetterString);
                            int indexOfExpectedString = secretWord.indexOf(expectedLetterString);
                            if (indexOfExpectedString == -1) {
                                System.out.println("This word don't have such letter.");
                                errorCounter++;
                            } else {
                                addNewLetter(expectedLetterString, secretWordArray, secretWord);
                            }
                        }

                        System.out.println(Arrays.toString(secretWordArray));
                        printHangman(errorCounter);

                        if (isWin(secretWord, secretWordArray)) {
                            System.out.println("You Win!!!");
                            findLetterFlag = false;
                        }

                        if (isLose(errorCounter)) {
                            System.out.println("You lose!");
                            System.out.println("Correct word: " + secretWord);
                            findLetterFlag = false;
                        }
                    }
                    break;
                case 2:
                    System.out.println("Game ended!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("You entered incorrect number! Try again!");
                    break;
            }
        }
    }

    private static boolean hasEntered(Set<String> enteredLettersSet, String enteredLetter) {
        return enteredLettersSet.contains(enteredLetter);
    }
    private static boolean isValidExpectedLetterString(String expectedLetterString) {
        return expectedLetterString.length() == 1
                && Character.isLetter(expectedLetterString.charAt(0))
                && Character.isLowerCase(expectedLetterString.charAt(0));
    }

    private static boolean isWin(String secretWord, String[] secretWordArray) {
        return String.join("", secretWordArray).equals(secretWord);
    }

    private static boolean isLose(int errorCounter) {
        return errorCounter == NUM_ERR_FOR_LOSE;
    }

    private static void addNewLetter(String expectedLetterString, String[] secretWordArray, String secretWord) {
        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == expectedLetterString.charAt(0)) {
                secretWordArray[i] = expectedLetterString;
            }
        }
    }

    private static void printGreetings() {
        System.out.println("Please, Enter the number!");
        System.out.println("1. Start the game.");
        System.out.println("2. End the game.");
    }

    private static Path readFileOfWords() {
        String path = System.getProperty(PROPERTY_NAME);
        String fileName = path + FILE_NAME; // Кодировка: windows-1251
        return Paths.get(fileName);
    }

    private static void fillListOfWOrds(List<String> listOfWords, Path path) throws IOException {
        Scanner scanner = new Scanner(path);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            listOfWords.add(line);
        }
    }

    private static String getRandomWord(List<String> listOfRussianWords) {
        return listOfRussianWords.get(new Random().nextInt(listOfRussianWords.size()));
    }

    private static void printHangman(int errorCounter) {
        System.out.println("Errors: " + errorCounter);
        switch (errorCounter) {
            case 0:
                Printer zeroErrorPrinter = Printer.ZERO;
                System.out.println(zeroErrorPrinter);
                break;
            case 1:
                Printer oneErrorPrinter = Printer.ONE;
                System.out.println(oneErrorPrinter);
                break;
            case 2:
                Printer twoErrorPrinter = Printer.TWO;
                System.out.println(twoErrorPrinter);
                break;
            case 3:
                Printer threeErrorPrinter = Printer.THREE;
                System.out.println(threeErrorPrinter);
                break;
            case 4:
                Printer fourErrorPrinter = Printer.FOUR;
                System.out.println(fourErrorPrinter);
                break;
            case 5:
                Printer fiveErrorPrinter = Printer.FIVE;
                System.out.println(fiveErrorPrinter);
                break;
            case 6:
                Printer sixErrorPrinter = Printer.SIX;
                System.out.println(sixErrorPrinter);
                break;
        }
    }
}
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Citim textul de la utilizator
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduceți textul: ");
        String userText = scanner.nextLine();

        // Crearea și inițializarea obiectului pentru prelucrarea șirurilor
        StringProcessor stringProcessor = new StringProcessor(userText);

        // Obținerea primului subșir cu lungime maximă, care nu conține litere, spații și semne de punctuație
        String result = stringProcessor.extractMaxNonLetterSubString();

        // Afișarea rezultatului
        System.out.println("Primul subșir cu lungime maximă, care nu conține litere, spații și semne de punctuație: " + result);

        // Închidem scanner-ul
        scanner.close();
    }
}

class StringProcessor {
    private String text;

    // Constructor care primește textul la inițializare
    public StringProcessor(String text) {
        this.text = text;
    }

    // Metoda pentru extragerea primului subșir cu lungime maximă, care nu conține litere, spații și semne de punctuație
    public String extractMaxNonLetterSubString() {
        String[] words = text.split("[a-zA-Z]+"); // corectăm regex pentru a exclude literele
        String maxNonLetterSubString = "";

        for (String word : words) {
            // Eliminăm spațiile și semnele de punctuație
            String cleanedWord = word.replaceAll("[\\s\\p{Punct}]", "");

            if (cleanedWord.length() > maxNonLetterSubString.length()) {
                maxNonLetterSubString = cleanedWord;
            }
        }

        return maxNonLetterSubString;
    }
}
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Simple_Quiz_With_JAVA
{
    public static void main(String[] args) {
        // Erstellen der Map mit Fragen und Antworten
        Map<String, String> questions = new HashMap<>();
        questions.put("Frage 1: Was ist die Hauptstadt von Deutschland? A) Berlin B) München C) Hamburg D) Köln", "A");
        questions.put("Frage 2: Wie viele Kontinente gibt es? A) 5 B) 6 C) 7 D) 8", "C");
        // Weitere Fragen können hier hinzugefügt werden

        Scanner scanner = new Scanner(System.in);
        int correctAnswers = 0;
        Map<String, String> wrongAnswers = new HashMap<>();

        for (Map.Entry<String, String> entry : questions.entrySet()) {
            System.out.println(entry.getKey());
            String userAnswer = scanner.nextLine().toUpperCase();

            if (userAnswer.equals(entry.getValue())) {
                correctAnswers++;
            } else {
                wrongAnswers.put(entry.getKey(), entry.getValue());
            }
        }

        // Prozentuale Anzahl der richtigen Antworten ausgeben
        double percentageCorrect = 100.0 * correctAnswers / questions.size();
        System.out.println("Richtige Antworten: " + percentageCorrect + "%");

        // Falsch beantwortete Fragen anzeigen
        if (!wrongAnswers.isEmpty()) {
            System.out.println("Falsch beantwortete Fragen:");
            for (Map.Entry<String, String> entry : wrongAnswers.entrySet()) {
                System.out.println(entry.getKey() + " Richtig wäre: " + entry.getValue());
            }
        } else {
            System.out.println("Alle Fragen richtig beantwortet!");
        }
    }
}

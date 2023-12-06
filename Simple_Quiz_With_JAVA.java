import java.util.*;

//This code should provide a simple way to study with single-choice-questions
//Python would have probably worked better, but I wanted a quick-fix for my exam prep without teaching myself a new language
//you simply enter the letter for your answer in the console and hit enter
//after you're done with all the questions you get the percentage of right answers and the questions and right answers to all your wrong answers

public class Simple_Quiz_With_JAVA
{
    public static void main(String[] args) {
        // Creates a map wehre the key is the questions and the value is the right answer
        Map<String, String> questions = new HashMap<>();
        questions.put("Question 1: What is the capital of Germany? A) Berlin B) Munich C) Hamburg D) Cologne", "A");
        questions.put("Question 2: What is the capital of England? A) London B) Manchester C) Liverpool D) Bristol", "A");
        // you could add new questions here


        // turns the map into a List
        List<Map.Entry<String, String>> questionList = new ArrayList<>(questions.entrySet());
        // shuffles the questions in the list
        Collections.shuffle(questionList);

        //This method checks your input
        Scanner scanner = new Scanner(System.in);
        int correctAnswers = 0;
        Map<String, String> wrongAnswers = new HashMap<>();

        for (Map.Entry<String, String> entry : questionList) {
            System.out.println(entry.getKey());
            String userAnswer = scanner.nextLine().toUpperCase();

            if (userAnswer.equals(entry.getValue())) {
                correctAnswers++;
            } else {
                wrongAnswers.put(entry.getKey(), entry.getValue());
            }
        }

        // percentage of right answers
        double percentageCorrect = 100.0 * correctAnswers / questions.size();
        System.out.println("***** QUIZ-FINNISHED ***** \n Correct Answers: " + percentageCorrect + "%");


        // shows the wrong answered questions with the right answer
        if (!wrongAnswers.isEmpty()) {
            System.out.println("\n" + "Incorrectly answered questions:");
            for (Map.Entry<String, String> entry : wrongAnswers.entrySet()) {
                System.out.println(entry.getKey() + " Correct would be: " + entry.getValue());
            }
        } else {
            System.out.println("All questions answered correctly!");
        }
    }
}

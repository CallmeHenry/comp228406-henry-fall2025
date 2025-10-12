package exercise1;

import javax.swing.JOptionPane;
import java.util.Random;

public class Test {

    private final String[][][] questions = {
            {
                    {"1. What is an array?\n"},
                    {"1. Methods of the same name can be declared in the same class, as long as they have different sets of parameters.",
                            "2. A collection of data structures, all of the same type, in which each item's position is uniquely designated by an integer.",
                            "3. A uniquely named, reusable group of related packages, as well as resources.",
                            "4. The portion of the program that can refer to the declared entity by its name, such as an entity is said to be in scope for that portion of the program."},
                    {"2"}
            },
            {
                    {"2. What is method overloading?\n"},
                    {"1. Methods of the same name can be declared in the same class, as long as they have different sets of parameters.",
                            "2. A collection of data structures, all of the same type, in which each item's position is uniquely designated by an integer.",
                            "3. A uniquely named, reusable group of related packages, as well as resources.",
                            "4. The portion of the program that can refer to the declared entity by its name, such as an entity is said to be in scope for that portion of the program."},
                    {"1"}
            },
            {
                    {"3. What is scope of declarations?\n"},
                    {"1. Methods of the same name can be declared in the same class, as long as they have different sets of parameters.",
                            "2. A collection of data structures, all of the same type, in which each item's position is uniquely designated by an integer.",
                            "3. A uniquely named, reusable group of related packages, as well as resources.",
                            "4. The portion of the program that can refer to the declared entity by its name, such as an entity is said to be in scope for that portion of the program."},
                    {"4"}
            },
            {
                    {"4. What is a static method?\n"},
                    {"1. A collection of data structures, all of the same type, in which each item's position is uniquely designated by an integer.",
                            "2. A uniquely named, reusable group of related packages, as well as resources.",
                            "3. The portion of the program that can refer to the declared entity by its name, such as an entity is said to be in scope for that portion of the program.",
                            "4. A method that is associated with the class in which it is defined rather than with any object."},
                    {"4"}
            },
            {
                    {"5. What is a module?\n"},
                    {"1. A collection of data structures, all of the same type, in which each item's position is uniquely designated by an integer.",
                            "2. A uniquely named, reusable group of related packages, as well as resources.",
                            "3. The portion of the program that can refer to the declared entity by its name, such as an entity is said to be in scope for that portion of the program.",
                            "4. A method that is associated with the class in which it is defined rather than with any object."},
                    {"3"}

            }
    };

    private final String[] correct = {
            "Excellent!", "Good!", "Keep up the good work!", "Nice work!"
    };

    private final String[] incorrect = {
            "No. Please try again.", "Wrong. Try once more", "Don't give up!", "No. Keep trying..."
    };

    private final Random rand = new Random();

    public Test() {

    }

    private String simulateQuestion(int i) {
            String question = questions[i][0][0] + '\n';
            for (int j = 0; j < 4; j++) {
                question += '\t' + questions[i][1][j] + '\n';
            }
            String input = JOptionPane.showInputDialog(null, question);
            return input;
    }

    private void checkAnswer(int input, int i) {
        int answer = Integer.parseInt(questions[i][2][0]);
        if (input == answer) {
            generateMessage(true);
        }
        else {
            generateMessage(false);
        }
    }

    private void generateMessage(boolean flag) {
        if (flag) {
            JOptionPane.showMessageDialog(null, correct[rand.nextInt(4)]);
        } else {
            JOptionPane.showMessageDialog(null, incorrect[rand.nextInt(4)]);
        }
    }

    public void inputAnswer() {
        for (int i = 0; i < questions.length; i++) {
            String inputString = simulateQuestion(i);
            int input = Integer.parseInt(inputString);
            checkAnswer(input, i);
        }
    }

}

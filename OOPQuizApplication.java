import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

// Abstract Quiz Question Class
abstract class QuizQuestion {
    private String questionText; //Encapsulation
    private List<String> options;
    private String correctAnswer;

    public QuizQuestion(String questionText, List<String> options, String correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public abstract boolean checkAnswer(String userAnswer); //Abstraction

    public String getQuestionText() { return questionText; }
    public List<String> getOptions() { return options; }
    public String getCorrectAnswer() { return correctAnswer; }
}

// Subject-Specific Question Classes
class PythonQuestion extends QuizQuestion {
    public PythonQuestion(String questionText, List<String> options, String correctAnswer) {
        super(questionText, options, correctAnswer);
    }

    @Override
    public boolean checkAnswer(String userAnswer) { //Inheritance
        return userAnswer.equalsIgnoreCase(getCorrectAnswer());
    }
}

class JavaQuestion extends QuizQuestion {
    public JavaQuestion(String questionText, List<String> options, String correctAnswer) {
        super(questionText, options, correctAnswer);
    }

    @Override
    public boolean checkAnswer(String userAnswer) {
        return userAnswer.equalsIgnoreCase(getCorrectAnswer());
    }
}

class CPlusPlusQuestion extends QuizQuestion {
    public CPlusPlusQuestion(String questionText, List<String> options, String correctAnswer) {
        super(questionText, options, correctAnswer);
    }

    @Override
    public boolean checkAnswer(String userAnswer) {
        return userAnswer.equalsIgnoreCase(getCorrectAnswer());
    }
}

// Quiz Manager Interface
interface QuizManager {
    void startQuiz();
    int getScore();
}

// Student Information Class
class Student {
    private String name; //Encapsulation
    private String section;

    public void setName(String name) { this.name = name; }
    public void setSection(String section) { this.section = section; }
    public String getName() { return name; }
    public String getSection() { return section; }
}

// Main Quiz Application
public class OOPQuizApplication { // Polymorphism
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {
        while (true) {
            // Student Registration
            Student student = registerStudent();

            // Subject Selection
            String subject = selectSubject();

            // Quiz Initialization
            QuizManager quiz = createQuiz(subject);

            // Start Quiz
            quiz.startQuiz();

            // Show Results
            displayResults(student, quiz);

            // Ask to continue or exit
            if (!askToContinue()) break;
        }
    }

    private static Student registerStudent() {
        Student student = new Student();
        System.out.println("============================");
        System.out.println("=== Student Registration ===");
        System.out.println("============================");
        
        while (true) {
            System.out.print("Enter Name: ");
            student.setName(scanner.nextLine());
            
            System.out.print("Enter Section: ");
            student.setSection(scanner.nextLine());
            
            System.out.println("\n=========================");
            System.out.println("===  confirm Details  ===");
            System.out.println("=========================");
            System.out.println("Name: " + student.getName());
            System.out.println("Section: " + student.getSection());
            
            System.out.print("Confirm? (Y/N): ");
            String confirm = scanner.nextLine();
            
            if (confirm.equalsIgnoreCase("Y")) break;
        }
        
        return student;
    }

    private static String selectSubject() {
        while (true) {
            System.out.println("\n=========================");
            System.out.println("=== Subject Selection ===");
            System.out.println("=========================");
            System.out.println("1. Python");
            System.out.println("2. Java");
            System.out.println("3. C++");
            System.out.print("Choose a subject (1-3): ");
            
            String choice = scanner.nextLine();
            switch (choice) {
                case "1": return "Python";
                case "2": return "Java";
                case "3": return "C++";
                default: System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static QuizManager createQuiz(String subject) {
        List<QuizQuestion> questions = new ArrayList<>();
        
        switch (subject) {
            case "Python":
                questions.add(new PythonQuestion(
                    "Python is a:",
                    List.of("A. Low-level programming language",
                            "B. High-level, interpreted programming language",
                            "C. Hardware programming language",
                            "D. Assembler language"),
                    "B"
                ));
                questions.add(new PythonQuestion(
                    "Which of the following is a correct way to define a function in Python?",
                    List.of("A. function myFunction()", 
                            "B. def myFunction():", 
                            "C. define myFunction()", 
                            "D. func myFunction()"),
                    "B"
                ));
                questions.add(new PythonQuestion(
                    "What is the output of: print(type(42))?",
                    List.of("A. <class 'integer'>", 
                            "B. <type 'int'>", 
                            "C. <class 'int'>", 
                            "D. <type 'integer'>"),
                    "C"
                ));
                questions.add(new PythonQuestion(
                    "Which operator is used for exponentiation in Python?",
                    List.of("A. ^", 
                            "B. **", 
                            "C. ^^", 
                            "D. pow"),
                    "B"
                ));
                questions.add(new PythonQuestion(
                    "Which of the following is NOT a valid Python data type?",
                    List.of("A. float", 
                            "B. dict", 
                            "C. int", 
                            "D. double"),
                    "D"
                ));
                questions.add(new PythonQuestion(
                    "How can you add an element to a Python list?",
                    List.of("A. append()", 
                            "B. add()", 
                            "C. insert()", 
                            "D. push()"),
                    "A"
                ));
                questions.add(new PythonQuestion(
                    "What does the `len()` function do in Python?",
                    List.of("A. Returns the length of an object",
                            "B. Calculates the size of an object",
                            "C. Checks the memory usage of an object",
                            "D. Finds the width of an object"),
                    "A"
                ));
                questions.add(new PythonQuestion(
                    "What is the correct way to create a Python dictionary?",
                    List.of("A. dict = [1: 'one', 2: 'two']",
                            "B. dict = {1: 'one', 2: 'two'}",
                            "C. dict = (1: 'one', 2: 'two')",
                            "D. dict = <1: 'one', 2: 'two'>"),
                    "B"
                ));
                questions.add(new PythonQuestion(
                    "Which of these is used to handle exceptions in Python?",
                    List.of("A. try-catch",
                            "B. try-except",
                            "C. try-error",
                            "D. try-handle"),
                    "B"
                ));
                questions.add(new PythonQuestion(
                    "What is the correct syntax to import a module in Python?",
                    List.of("A. import module_name",
                            "B. include module_name",
                            "C. use module_name",
                            "D. require module_name"),
                    "A"
                ));
                break;
            case "Java":
                questions.add(new JavaQuestion(
                    "Java is primarily used for:",
                    List.of("A. Database management", 
                            "B. Web browser", 
                            "C. Enterprise and mobile applications", 
                            "D. Operating system"),
                    "C"
                ));
                questions.add(new JavaQuestion(
                    "Which of the following is a correct way to define a class in Java?",
                    List.of("A. class MyClass {}", 
                            "B. class MyClass[]", 
                            "C. MyClass class {}", 
                            "D. class: MyClass {}"),
                    "A"
                ));
                questions.add(new JavaQuestion(
                    "What is the correct way to create an object in Java?",
                    List.of("A. MyClass obj = new MyClass();", 
                            "B. new MyClass();", 
                            "C. MyClass obj = MyClass();", 
                            "D. object MyClass = new MyClass();"),
                    "A"
                ));
                questions.add(new JavaQuestion(
                    "What does the 'public' keyword mean in Java?",
                    List.of("A. The class is accessible only within its own package", 
                            "B. The class is accessible from any other class", 
                            "C. The class is private", 
                            "D. The class is protected"),
                    "B"
                ));
                questions.add(new JavaQuestion(
                    "Which of these is used to handle exceptions in Java?",
                    List.of("A. try-catch", 
                            "B. catch-try", 
                            "C. try-except", 
                            "D. try-finally"),
                    "A"
                ));
                questions.add(new JavaQuestion(
                    "What is the default value of a boolean in Java?",
                    List.of("A. true", 
                            "B. false", 
                            "C. null", 
                            "D. 0"),
                    "B"
                ));
                questions.add(new JavaQuestion(
                    "Which of the following is the correct method signature for the main method in Java?",
                    List.of("A. public static void main(String args[])", 
                            "B. public void main(String args[])", 
                            "C. static void main(String[] args)", 
                            "D. void main(String args[])"),
                    "A"
                ));
                questions.add(new JavaQuestion(
                    "Which collection type in Java stores elements in key-value pairs?",
                    List.of("A. List", 
                            "B. Map", 
                            "C. Set", 
                            "D. Queue"),
                    "B"
                ));
                questions.add(new JavaQuestion(
                    "What is the purpose of the 'super' keyword in Java?",
                    List.of("A. To call a superclass constructor", 
                            "B. To call a subclass constructor", 
                            "C. To stop method overriding", 
                            "D. To define variables in the superclass"),
                    "A"
                ));
                questions.add(new JavaQuestion(
                    "Which of these is used to create a thread in Java?",
                    List.of("A. Thread.start()", 
                            "B. Thread.run()", 
                            "C. Thread.create()", 
                            "D. new Thread()"),
                    "A"
                ));
                break;

            case "C++":
                questions.add(new CPlusPlusQuestion(
                    "C++ was developed by:",
                    List.of("A. Bill Gates", 
                            "B. Bjarne Stroustrup", 
                            "C. Steve Jobs", 
                            "D. Dennis Ritchie"),
                    "B" //correct answer
                ));
                questions.add(new CPlusPlusQuestion(
                    "Which of the following is the correct way to define a function in C++?",
                    List.of("A. function myFunction() {}", 
                            "B. def myFunction() {}", 
                            "C. void myFunction() {}", 
                            "D. function void myFunction() {}"),
                    "C"
                ));
                questions.add(new CPlusPlusQuestion(
                    "What is the purpose of the 'virtual' keyword in C++?",
                    List.of("A. To define a virtual machine", 
                            "B. To allow dynamic method dispatch", 
                            "C. To declare a virtual class", 
                            "D. To prevent inheritance"),
                    "B"
                ));
                questions.add(new CPlusPlusQuestion(
                    "Which of the following is a feature of C++ that distinguishes it from C?",
                    List.of("A. Pointers", 
                            "B. Object-Oriented Programming", 
                            "C. Memory management", 
                            "D. All of the above"),
                    "B"
                ));
                questions.add(new CPlusPlusQuestion(
                    "Which of the following operators is used for dynamic memory allocation in C++?",
                    List.of("A. malloc()", 
                            "B. new", 
                            "C. alloc()", 
                            "D. calloc()"),
                    "B"
                ));
                questions.add(new CPlusPlusQuestion(
                    "Which of these C++ features is used to protect data from unauthorized access?",
                    List.of("A. Data hiding", 
                            "B. Encapsulation", 
                            "C. Inheritance", 
                            "D. Polymorphism"),
                    "B"
                ));
                questions.add(new CPlusPlusQuestion(
                    "Which header file is required for input-output operations in C++?",
                    List.of("A. iostream.h", 
                            "B. stdio.h", 
                            "C. io.h", 
                            "D. inputoutput.h"),
                    "A"
                ));
                questions.add(new CPlusPlusQuestion(
                    "Which of these is the correct way to declare a pointer in C++?",
                    List.of("A. int *p;", 
                            "B. pointer int p;", 
                            "C. int p*;", 
                            "D. pointer *p int;"),
                    "A"
                ));
                questions.add(new CPlusPlusQuestion(
                    "What is the correct syntax for a for loop in C++?",
                    List.of("A. for (int i = 0; i < 10; i++) {}", 
                            "B. for (int i = 0, i < 10, i++) {}", 
                            "C. for (i = 0; i < 10; i++) {}", 
                            "D. for i = 0; i < 10; i++ {}"),
                    "A"
                ));
                questions.add(new CPlusPlusQuestion(
                    "What is a constructor in C++?",
                    List.of("A. A function that returns an object", 
                            "B. A function that initializes objects", 
                            "C. A function used for inheritance", 
                            "D. A function for dynamic memory allocation"),
                    "B"
                ));
                break;
        }        

        // Populate the rest of the questions for a total of 10
        while (questions.size() < 10) {
            questions.add(questions.get(0));  // Duplicate questions for demonstration
        }

        return new SubjectQuiz(questions);
    }

    private static void displayResults(Student student, QuizManager quiz) {
        int score = quiz.getScore();
        System.out.println("\n===================");
        System.out.println("=== Quiz Results ==");
        System.out.println("===================");
        System.out.println("Name: " + student.getName());
        System.out.println("Section: " + student.getSection());
        System.out.println("Your score: " + score + "/10");

        if (score >= 6) {
            System.out.println("Excellent! You've passed the quiz.");
        } else {
            System.out.println("Good attempt! Keep practicing for a better score.");
        }        
    }

    private static boolean askToContinue() {
        System.out.print("\nDo you want to take another quiz? (Y/N): ");
        return scanner.nextLine().equalsIgnoreCase("Y");
    }
}

// Concrete Quiz Implementation
class SubjectQuiz implements QuizManager {
    private List<QuizQuestion> questions;
    private int score;

    public SubjectQuiz(List<QuizQuestion> questions) {
        this.questions = questions;
        this.score = 0;
    }

    @Override 
    public void startQuiz() { //Polymorphism
        Scanner scanner = new Scanner(System.in);
        
        for (QuizQuestion question : questions) {
            System.out.println("\n" + question.getQuestionText());
            for (String option : question.getOptions()) {
                System.out.println(option);
            }
            
            System.out.print("Your answer (A/B/C/D): ");
            String userAnswer = scanner.nextLine();
            
            if (question.checkAnswer(userAnswer)) { 
                score++;
            }
        }
    }

    @Override
    public int getScore() {
        return score;
    }
}

I. A brief project overview

My "Quiz and Seat" method's objective is to determine who requires attention and learning support. By using
my system, it will be able to take the test I created. Anyone willing to test their skills can use it. When
the test is over, those who scored five or higher will sit at the back of the seat, and the students who
scored four or lower will sit in the front. Due to their lack of familiarity with the previously studied
material, they will be more attentive.

II. Explanation of how OOP principles were applied

Encapsulation: The class uses encapsulation to protect its internal data. The private keyword ensure
s that certain fields, like questionText, options, and correctAnswer, can only be accessed or modified
within the class itself or its subclasses. This helps maintain data integrity and prevents accidental
changes from outside the class.

Inheritance: The PythonQuestion and JavaQuestion classes inherit from the QuizQuestion class. This means
they automatically get all the properties and methods of the parent class, like questionText, options,
and correctAnswer. This shows how different types of questions (such as Python and Java) can be created
from a general QuizQuestion class.

Polymorphism: The OOPQuizApplication class manages the flow of the entire application. First, it registers
a student and allows them to choose a subject. Based on the selection, it creates a QuizManager object, which
takes care of handling the quiz questions. The startQuiz method then starts the quiz, asking questions and
checking answers. Polymorphism is used here to handle different types of quizzes, and the QuizManager class
likely uses polymorphism to create and manage different types of questions.

Abstraction: The checkAnswer method is defined as abstract, which means its exact implementation is left to
the subclasses. This allows for abstraction because the general idea of checking an answer is set, but how
it is done for each specific question type is determined by the subclasses.

III. Details of the chosen SDG and its integration into the project

My program contributes to SDG 4: Quality Education by fostering an inclusive and motivational learning
environment through a strategic seating arrangement. Students who score below 4/10 are seated in th
front, allowing them to receive closer attention and guidance from the teacher to address their learning
gaps effectively. Meanwhile, students who achieve a passing score of 5/10 or higher are seated in the
back, serving as a reward that motivates others to strive for better performance. This arrangement also
fosters collaboration and focus, as students with higher scores create opportunities for their peers to
receive the support they need. By providing targeted assistance and encouraging self-improvement, the
program helps all students prepare more effectively for future exams, contributing to a more equitable
and high-quality educational experience.

IV. Instructions for running the program

1.First, you need to input your name and course. A confirmation will appear displaying your details.
If everything is correct, click "Yes" to proceed; if not, click "No" to reset and re-enter your name and course.

2.After confirming your details, you will be presented with a selection of three subjects. If you
choose "1," it will correspond to the Python subject, and you will begin answering the first question.

3.Continue answering the questions until you reach the end. Once you've completed the quiz, the
"Quiz Results" will appear, showing your name, course, and the number of correct answers.

4.The last question will ask, "Do you want to take another quiz?" You can answer "Y" (Yes) or "N" (No).

	  •If you choose "Y" (Yes), the system will reset. You will need to input your name, course, and
      confirm your details again. After completing the quiz, your results will show, and you will 
       asked if you want to take another quiz.

  	•If you choose "N" (No), the system will exit.


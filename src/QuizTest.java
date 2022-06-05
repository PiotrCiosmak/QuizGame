import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuizTest
{
    @Test
    void checkWidthOfButtonA()
    {
        Quiz quiz = new Quiz();
        assertEquals(100, quiz.buttonA.getWidth());
    }

    @Test
    void checkHeightOfButtonA()
    {
        Quiz quiz = new Quiz();
        assertEquals(100, quiz.buttonA.getHeight());
    }

    @Test
    void checkTextOfButtonA()
    {
        Quiz quiz = new Quiz();
        assertEquals("A", quiz.buttonA.getText());
    }

    @Test
    void checkWidthOfButtonB()
    {
        Quiz quiz = new Quiz();
        assertEquals(100, quiz.buttonB.getWidth());
    }

    @Test
    void checkHeightOfButtonB()
    {
        Quiz quiz = new Quiz();
        assertEquals(100, quiz.buttonB.getHeight());
    }

    @Test
    void checkTextOfButtonB()
    {
        Quiz quiz = new Quiz();
        assertEquals("B", quiz.buttonB.getText());
    }

    @Test
    void checkWidthOfButtonC()
    {
        Quiz quiz = new Quiz();
        assertEquals(100, quiz.buttonC.getWidth());
    }

    @Test
    void checkHeightOfButtonC()
    {
        Quiz quiz = new Quiz();
        assertEquals(100, quiz.buttonC.getHeight());
    }

    @Test
    void checkTextOfButtonC()
    {
        Quiz quiz = new Quiz();
        assertEquals("C", quiz.buttonC.getText());
    }

    @Test
    void checkWidthOfButtonD()
    {
        Quiz quiz = new Quiz();
        assertEquals(100, quiz.buttonD.getWidth());
    }

    @Test
    void checkHeightOfButtonD()
    {
        Quiz quiz = new Quiz();
        assertEquals(100, quiz.buttonD.getHeight());
    }

    @Test
    void checkTextOfButtonD()
    {
        Quiz quiz = new Quiz();
        assertEquals("D", quiz.buttonD.getText());
    }

    @Test
    void checkIfSecondEqualsTen()
    {
        Quiz quiz = new Quiz();
        assertEquals(30, quiz.seconds);
    }

    @Test
    void checkIfPercentageIs100WhenAllAnswersCorrect()
    {
        Quiz quiz = new Quiz();
        if (quiz.correct_guesses == quiz.total_questions)
        {
            assertEquals("100", quiz.percentage.getText());
        }
    }

    @Test
    void checkIfTotalAnswerNumberIsCorrect()
    {
        Quiz quiz = new Quiz();
        assertNotEquals(quiz.index+1, quiz.total_questions);
    }
}
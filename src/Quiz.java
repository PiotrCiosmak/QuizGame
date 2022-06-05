import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Quiz implements ActionListener
{
    ArrayList<String> questions = new ArrayList<>();

    ArrayList<ArrayList<String>> options = new ArrayList();

    ArrayList<Character> answers = new ArrayList<>();

    char answer;
    int index;
    int correct_guesses = 0;
    int total_questions;
    int result;
    int seconds = 30;

    JFrame frame = new JFrame();
    JTextField textField = new JTextField();
    JTextArea textArea = new JTextArea();
    JButton buttonA = new JButton();
    JButton buttonB = new JButton();
    JButton buttonC = new JButton();
    JButton buttonD = new JButton();
    JLabel answer_labelA = new JLabel();
    JLabel answer_labelB = new JLabel();
    JLabel answer_labelC = new JLabel();
    JLabel answer_labelD = new JLabel();
    JLabel time_label = new JLabel();
    JLabel seconds_left = new JLabel();
    JTextField number_right = new JTextField();
    JTextField percentage = new JTextField();

    Timer timer = new Timer(1000, e ->
    {
        seconds--;
        seconds_left.setText(String.valueOf(seconds));
        if (seconds <= 0)
        {
            dispalyAnswer();
        }
    });

    public Quiz()
    {
        getQuestions();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(950, 650);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(null);
        frame.setResizable(false);

        textField.setBounds(0, 0, 950, 50);
        textField.setBackground(new Color(25, 25, 25));
        textField.setForeground(new Color(25, 255, 0));
        textField.setFont(new Font("Ariel", Font.BOLD, 30));
        textField.setBorder(BorderFactory.createBevelBorder(1));
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setEditable(false);

        textArea.setBounds(0, 50, 950, 100);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBackground(new Color(25, 25, 25));
        textArea.setForeground(new Color(25, 255, 0));
        textArea.setFont(new Font("Ariel", Font.BOLD, 25));
        textArea.setBorder(BorderFactory.createBevelBorder(1));
        textArea.setEditable(false);

        buttonA.setBounds(0, 150, 100, 100);
        buttonA.setFont(new Font("Ariel", Font.BOLD, 35));
        buttonA.setFocusable(false);
        buttonA.addActionListener(this);
        buttonA.setText("A");

        buttonB.setBounds(0, 250, 100, 100);
        buttonB.setFont(new Font("Ariel", Font.BOLD, 35));
        buttonB.setFocusable(false);
        buttonB.addActionListener(this);
        buttonB.setText("B");

        buttonC.setBounds(0, 350, 100, 100);
        buttonC.setFont(new Font("Ariel", Font.BOLD, 35));
        buttonC.setFocusable(false);
        buttonC.addActionListener(this);
        buttonC.setText("C");

        buttonD.setBounds(0, 450, 100, 100);
        buttonD.setFont(new Font("Ariel", Font.BOLD, 35));
        buttonD.setFocusable(false);
        buttonD.addActionListener(this);
        buttonD.setText("D");

        answer_labelA.setBounds(125, 150, 500, 100);
        answer_labelA.setBackground(new Color(50, 50, 50));
        answer_labelA.setForeground(new Color(25, 255, 0));
        answer_labelA.setFont(new Font("Ariel", Font.PLAIN, 35));

        answer_labelB.setBounds(125, 250, 500, 100);
        answer_labelB.setBackground(new Color(50, 50, 50));
        answer_labelB.setForeground(new Color(25, 255, 0));
        answer_labelB.setFont(new Font("Ariel", Font.PLAIN, 35));

        answer_labelC.setBounds(125, 350, 500, 100);
        answer_labelC.setBackground(new Color(50, 50, 50));
        answer_labelC.setForeground(new Color(25, 255, 0));
        answer_labelC.setFont(new Font("Ariel", Font.PLAIN, 35));

        answer_labelD.setBounds(125, 450, 500, 100);
        answer_labelD.setBackground(new Color(50, 50, 50));
        answer_labelD.setForeground(new Color(25, 255, 0));
        answer_labelD.setFont(new Font("Ariel", Font.PLAIN, 35));

        seconds_left.setBounds(835, 510, 100, 100);
        seconds_left.setBackground(new Color(25, 25, 25));
        seconds_left.setForeground(new Color(255, 0, 0));
        seconds_left.setFont(new Font("Ariel", Font.BOLD, 60));
        seconds_left.setBorder(BorderFactory.createBevelBorder(1));
        seconds_left.setOpaque(true);
        seconds_left.setHorizontalAlignment(JTextField.CENTER);
        seconds_left.setText(String.valueOf(seconds));

        time_label.setBounds(835, 475, 100, 16);
        time_label.setBackground(new Color(50, 50, 50));
        time_label.setForeground(new Color(255, 0, 0));
        time_label.setFont(new Font("Ariel", Font.PLAIN, 20));
        time_label.setHorizontalAlignment(JTextField.CENTER);
        time_label.setText("timer");

        number_right.setBounds(225, 225, 200, 100);
        number_right.setBackground(new Color(25, 25, 25));
        number_right.setForeground(new Color(25, 255, 0));
        number_right.setFont(new Font("Ariel", Font.BOLD, 50));
        number_right.setBorder(BorderFactory.createBevelBorder(1));
        number_right.setHorizontalAlignment(JTextField.CENTER);
        number_right.setEditable(false);

        percentage.setBounds(225, 325, 200, 100);
        percentage.setBackground(new Color(25, 25, 25));
        percentage.setForeground(new Color(25, 255, 0));
        percentage.setFont(new Font("Ariel", Font.BOLD, 50));
        percentage.setBorder(BorderFactory.createBevelBorder(1));
        percentage.setHorizontalAlignment(JTextField.CENTER);
        percentage.setEditable(false);

        frame.add(time_label);
        frame.add(seconds_left);
        frame.add(answer_labelA);
        frame.add(answer_labelB);
        frame.add(answer_labelC);
        frame.add(answer_labelD);
        frame.add(buttonA);
        frame.add(buttonB);
        frame.add(buttonC);
        frame.add(buttonD);
        frame.add(textArea);
        frame.add(textField);
        frame.setVisible(true);

        nextQuestion();
    }

    public void getQuestions()
    {
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("files\\questions.txt"));
            String line;

            while ((line = br.readLine()) != null)
            {

                questions.add(line);
            }
            br.close();
        } catch (Exception ex)
        {
            System.exit(1);
        }
        total_questions = questions.size();

        try
        {
            BufferedReader br = new BufferedReader(new FileReader("files\\options.txt"));
            String line;
            while ((line = br.readLine()) != null)
            {
                options.add(new ArrayList<>(Arrays.asList(line.split(","))));
            }
            br.close();
        } catch (Exception ex)
        {
            System.exit(1);
        }

        try
        {
            BufferedReader br = new BufferedReader(new FileReader("files\\answers.txt"));
            String line;
            while ((line = br.readLine()) != null)
            {
                answers.add(line.charAt(0));
            }
            br.close();
        } catch (Exception ex)
        {
            System.exit(1);
        }
    }

    public void nextQuestion()
    {
        if (index >= total_questions)
        {
            results();
        } else
        {
            textField.setText("Question " + (index + 1));
            textArea.setText(questions.get(index));
            answer_labelA.setText(options.get(index).get(0));
            answer_labelB.setText(options.get(index).get(1));
            answer_labelC.setText(options.get(index).get(2));
            answer_labelD.setText(options.get(index).get(3));
            timer.start();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if (e.getSource() == buttonA)
        {
            answer = 'A';
        }
        if (e.getSource() == buttonB)
        {
            answer = 'B';
        }
        if (e.getSource() == buttonC)
        {
            answer = 'C';
        }
        if (e.getSource() == buttonD)
        {
            answer = 'D';
        }

        if (answer == answers.get(index))
        {
            correct_guesses++;
        }
        dispalyAnswer();
    }

    public void dispalyAnswer()
    {
        timer.stop();
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if (answers.get(index) != 'A')
        {
            answer_labelA.setForeground(new Color(255, 0, 0));
        }
        if (answers.get(index) != 'B')
        {
            answer_labelB.setForeground(new Color(255, 0, 0));
        }
        if (answers.get(index) != 'C')
        {
            answer_labelC.setForeground(new Color(255, 0, 0));
        }
        if (answers.get(index) != 'D')
        {
            answer_labelD.setForeground(new Color(255, 0, 0));
        }

        Timer pause = new Timer(2000, e ->
        {
            answer_labelA.setForeground(new Color(25, 255, 0));
            answer_labelB.setForeground(new Color(25, 255, 0));
            answer_labelC.setForeground(new Color(25, 255, 0));
            answer_labelD.setForeground(new Color(25, 255, 0));

            answer = ' ';
            seconds = 30;
            seconds_left.setText(String.valueOf(seconds));
            buttonA.setEnabled(true);
            buttonB.setEnabled(true);
            buttonC.setEnabled(true);
            buttonD.setEnabled(true);
            index++;
            nextQuestion();
        });

        pause.setRepeats(false);
        pause.start();
    }

    public void results()
    {
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        textArea.setVisible(false);
        buttonA.setVisible(false);
        buttonB.setVisible(false);
        buttonC.setVisible(false);
        buttonD.setVisible(false);

        result = (int) ((correct_guesses / (double) total_questions) * 100);

        textField.setText("RESULTS!");
        textArea.setText("");
        answer_labelA.setText("");
        answer_labelB.setText("");
        answer_labelC.setText("");
        answer_labelD.setText("");

        number_right.setText("(" + correct_guesses + "/" + total_questions + ")");
        percentage.setText(result + "%");

        frame.add(number_right);
        frame.add(percentage);
    }
}

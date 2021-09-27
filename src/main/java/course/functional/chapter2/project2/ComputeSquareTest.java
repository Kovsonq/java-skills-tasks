package course.functional.chapter2.project2;

import javax.swing.*;
import java.awt.*;

public class ComputeSquareTest extends JFrame{
    static JButton submit = new JButton("Submit");
    static JTextField number = new JTextField(10);
    static JTextField square = new JTextField(10);
    static JPanel panel = new JPanel();

    public ComputeSquareTest() throws HeadlessException {
        submit.addActionListener(x->{
            try {
                int num = Integer.parseInt(number.getText());
                square.setText(Integer.toString(num*num));
            } catch (NumberFormatException e){
                System.out.println(number.getText() + " is not a number.");
            }
        });

        setSize(200,130);
        panel.add(number);
        panel.add(square);
        panel.add(submit);
        add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ComputeSquareTest();
    }
}

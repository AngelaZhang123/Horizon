import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.FileWriter; import java.io.PrintWriter;
import java.io.File; import java.io.FileNotFoundException;
import java.io.IOException;import java.util.Scanner;

public class Quiz extends JPanel implements ActionListener{
    CardLayout lay;
    JPanel cards;
    boolean topic;

    public Quiz(CardLayout x, JPanel y)
    {
        lay =x;
        cards=y;

        JTextField txtInput = new JTextField("Which topic would you like to explore?");
        add(txtInput);
        JButton one = new JButton("Economy");
        JButton two = new JButton("Education");
        JButton submit = new JButton("Submit");

        one.addActionListener(this);
        one.setFont(new Font("Monospaced", Font.PLAIN, 30));
        add(one);
        two.addActionListener(this);
        two.setFont(new Font("Monospaced", Font.PLAIN, 30));
        add(two);
        submit.addActionListener(this);
        submit.setFont(new Font("Monospaced", Font.PLAIN, 30));
        add(submit);
    }
    public void paintComponent(Graphics g) //the graphics for Main menu (the background pic)
    {
        super.paintComponent(g);

    }
    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
        if(command.equals("Economy"))
            topic=true;
        if(command.equals("Education"))
            topic=false;
        if(command.equals("Submit"))
        {
            if(topic)lay.show(cards,"EconomyP");
            else lay.show(cards,"EducationP");
        }
    }
}

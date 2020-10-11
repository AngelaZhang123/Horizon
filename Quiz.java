import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.FileWriter; import java.io.PrintWriter;
import java.io.File; import java.io.FileNotFoundException;
import java.io.IOException;import java.util.Scanner;

public class Quiz extends JPanel{
    public Quiz()
    {
        JTextField txtInput = new JTextField("Quiz");
        add(txtInput);
        JButton one = new JButton("Option 1");
        JButton two = new JButton("Option 2");
        JButton three = new JButton("Option 3");
        JButton four = new JButton("Option 4");


        OneHandler oH = new OneHandler();
        one.addActionListener(oH);
        one.setFont(new Font("Monospaced", Font.PLAIN, 30));
        add(one);
        TwoHandler tH = new TwoHandler();
        two.addActionListener(tH);
        two.setFont(new Font("Monospaced", Font.PLAIN, 30));
        add(two);
        ThreeHandler threeH = new ThreeHandler();
        three.addActionListener(threeH);
        three.setFont(new Font("Monospaced", Font.PLAIN, 30));
        add(three);
        FourHandler fH = new FourHandler();
        four.addActionListener(fH);
        four.setFont(new Font("Monospaced", Font.PLAIN, 30));
        add(four);
    }
    public void paintComponent(Graphics g) //the graphics for Main menu (the background pic)
    {
        super.paintComponent(g);
    }
}

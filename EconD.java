import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.FileWriter; import java.io.PrintWriter;
import java.io.File; import java.io.FileNotFoundException;
import java.io.IOException;import java.util.Scanner;

public class EconD extends JPanel implements ActionListener{
    CardLayout lay;
    JPanel cards;

    public EconD(CardLayout x, JPanel y)
    {
        lay =x;
        cards=y;
        JButton back = new JButton("Back to main menu");
        back.setFont(new Font("Monospaced", Font.PLAIN, 30));
        back.addActionListener(this);
        setLayout(new BorderLayout());
        add(back,BorderLayout.SOUTH);

        JPanel top = new JPanel();
        add(top, BorderLayout.NORTH);

        JLabel title = new JLabel("ECONOMY");
        title.setFont(new Font("Monospaced",Font.BOLD,50));
        top.add(title);

        JLabel sub = new JLabel("Learn more about a different perspective!");
        sub.setFont(new Font("Monospaced",Font.PLAIN,10));
        top.add(sub);

        String text = "Rely more heavily on government intervention to influence \n the economy's direction and keep the profit motive of businesses \n more at bay – subscribing to a belief that businesses \n are more willing to cut corners in terms of protecting the overall \n social good. Higher regulation comes with increased costs, supported \n through higher taxation. Often described as tax and spend.\n";
        text+= "\n";
        text+="Belief in economic policies that benefit low-income \n and middle-income families. Belief that reducing \n income inequality is the best way to foster economic \n growth because low-income families spend any extra \n money they have on food, medicine, and shelter. \n This increases more demand than policies that benefit businesses \n or wealthy families that are more likely to invest extra income. \n";
        text+= "\n";
        JTextArea text2 = new JTextArea(text);
        text2.setFont(new Font("Monospaced",Font.PLAIN,10));
        add(text2, BorderLayout.CENTER);
    }
    public void paintComponent(Graphics g) //the graphics for Main menu (the background pic)
    {
        super.paintComponent(g);

    }
    public void actionPerformed(ActionEvent e)
    {
        lay.show(cards,"MainMenu");
    }
}


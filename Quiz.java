import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.io.FileWriter; import java.io.PrintWriter;
import java.io.File; import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;
import java.lang.Object;

public class Quiz extends JPanel implements ActionListener{
    CardLayout lay;
    JPanel cards;
    int topic;

    JButton agree;
    JButton disagree;
    JLabel q2;
    JLabel q2a;

    public Quiz(CardLayout x, JPanel y)
    {
        lay =x;
        cards=y;
        topic =0;

        Font font = new Font("Monospaced", Font.PLAIN, 30);
        Font smallF = new Font("Monospaced", Font.PLAIN, 20);
        Font bigF = new Font("Monospaced", Font.PLAIN, 25);

        GridLayout grid = new GridLayout(2,0);
        setLayout(grid);
        JPanel top = new JPanel();
        JPanel bottom = new JPanel();
        add(top);
        add(bottom);

        JLabel filler = new JLabel("             ");
        filler.setFont(bigF);
        top.add(filler);

        JLabel q1 = new JLabel("Which topic would you like to explore?");
        q1.setFont(smallF);
        top.add(q1);
        JButton one = new JButton("Economy");
        JButton two = new JButton("Education");

        one.addActionListener(this);
        one.setFont(font);
        top.add(one);
        two.addActionListener(this);
        two.setFont(font);
        top.add(two);

        q2 = new JLabel("");
        q2.setFont(smallF);
        bottom.add(q2);
        q2.setVisible(false);

        q2a = new JLabel("");
        q2a.setFont(smallF);
        bottom.add(q2a);
        q2a.setVisible(false);

        agree = new JButton("Agree");
        disagree = new JButton("Disagree");

        agree.addActionListener(this);
        disagree.addActionListener(this);
        bottom.add(agree);
        bottom.add(disagree);
        agree.setFont(font);
        disagree.setFont(font);
        agree.setVisible(false);
        disagree.setVisible(false);

        top.setBackground(new Color(255,204,51));
        bottom.setBackground(new Color(255,204,51));
    }
    public void paintComponent(Graphics g) //the graphics for Main menu (the background pic)
    {
        super.paintComponent(g);

    }
    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
        if(command.equals("Economy")) {
            topic = 1;
            q2.setText("There should be more government regulations");
            q2a.setText("put on larger businesses and corporations.");
            q2.setVisible(true);
            q2a.setVisible(true);
            agree.setVisible(true);
            disagree.setVisible(true);
            repaint();
        }
        if(command.equals("Education")) {
            topic = 2;
            q2.setFont(new Font("Monospaced", Font.PLAIN, 25));
            q2a.setFont(new Font("Monospaced", Font.PLAIN, 25));
            q2.setText("The public education system is ");
            q2a.setText("flawed and should be defunded.");
            q2.setVisible(true);
            q2a.setVisible(true);
            agree.setVisible(true);
            disagree.setVisible(true);
            repaint();
        }
        if(command.equals("Agree"))
        {
            System.out.println("HOHO");
            if(topic==1)lay.show(cards,"EconomyA");
            else lay.show(cards,"EducationA");
        }
        if(command.equals("Disagree"))
        {
            if(topic==1)lay.show(cards,"EconomyD");
            else lay.show(cards,"EducationD");
        }
    }
}

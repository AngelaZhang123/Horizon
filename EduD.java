import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.FileWriter; import java.io.PrintWriter;
import java.io.File; import java.io.FileNotFoundException;
import java.io.IOException;import java.util.Scanner;

public class EduD extends JPanel implements ActionListener{
    CardLayout lay;
    JPanel cards;

    public EduD(CardLayout x, JPanel y)
    {
        lay =x;
        cards=y;
        JLabel title = new JLabel("EDUCATION");
        title.setFont(new Font("Monospaced",Font.BOLD,80));
        add(title);

        JLabel sub = new JLabel("-learn more about a different perspective!-");
        sub.setFont(new Font("Monospaced",Font.PLAIN,20));
        add(sub);

        JTextArea filler = new JTextArea("Republicans note what they consider to be high federal \n funding on public education and assert that it has resulted \n in “little substantial improvement in \n academic achievement or high school graduation rates.” \n");
        filler.setFont(new Font("Monospaced",Font.PLAIN,10));
        add(filler);
        JTextArea text1 = new JTextArea("Republicans support school choice and privatization. \n They believe choice is the “the most important driving force \n for renewing education” and “especially \n support the innovative financing mechanisms,” such as vouchers, \n education savings accounts (ESAs), and tuition tax credits. \n They also highlight support for choice options such as “home-schooling, \n career and technical education, private or parochial schools, \n magnet schools, charter schools, online learning, and early-college high schools.”\n");
        text1.setFont(new Font("Monospaced",Font.PLAIN,10));
        add(text1);

    }
    public void paintComponent(Graphics g) //the graphics for Main menu (the background pic)
    {
        super.paintComponent(g);
        setBackground(new Color(255,204,51));
        setBackground(new Color(255,204,51));
    }
    public void actionPerformed(ActionEvent e)
    {
    }
}

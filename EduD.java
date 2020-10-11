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
        JButton back = new JButton("Back to main menu");
        back.setFont(new Font("Monospaced", Font.PLAIN, 30));
        back.addActionListener(this);
        setLayout(new BorderLayout());
        add(back,BorderLayout.SOUTH);

        JPanel top = new JPanel();
        add(top, BorderLayout.NORTH);

        JLabel title = new JLabel("EDUCATION");
        title.setFont(new Font("Monospaced",Font.BOLD,50));
        top.add(title);

        JLabel sub = new JLabel("Learn more about a different perspective!");
        sub.setFont(new Font("Monospaced",Font.PLAIN,10));
        top.add(sub);

        String text = "Republicans note what they consider to be high federal \n funding on public education and assert that it has resulted \n in “little substantial improvement in \n academic achievement or high school graduation rates.” \n";
        text+= "\n";
        text+="Belief in school choice and privatization. Choice is the \n “the most important driving force for renewing education” \n and “especially support the innovative financing \n mechanisms,” such as vouchers, education \n savings accounts (ESAs), and tuition tax credits. They also \n highlight support for choice options such as “home-schooling, career and technical \n education, private or parochial schools, magnet schools, \n charter schools, online learning, and early-college high schools.”\n";
        JTextArea text2 = new JTextArea(text);
        text2.setFont(new Font("Monospaced",Font.PLAIN,10));
        add(text2, BorderLayout.CENTER);

    }
    public void paintComponent(Graphics g) //the graphics for Main menu (the background pic)
    {
        super.paintComponent(g);
        setBackground(new Color(255,204,51));
        setBackground(new Color(255,204,51));
    }
    public void actionPerformed(ActionEvent e)
    {
        lay.show(cards,"MainMenu");
    }
}



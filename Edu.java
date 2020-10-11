import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.FileWriter; import java.io.PrintWriter;
import java.io.File; import java.io.FileNotFoundException;
import java.io.IOException;import java.util.Scanner;

public class Edu extends JPanel implements ActionListener{
    CardLayout lay;
    JPanel cards;

    public Edu(CardLayout x, JPanel y)
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

        JLabel sub = new JLabel("-learn more about a different perspective!-");
        sub.setFont(new Font("Monospaced",Font.PLAIN,10));
        top.add(sub);

        String text = "Public schools also provide students with crucial exposure to \n people of different backgrounds and perspectives. Americans have \n a closer relationship with the public-school system than with \n any other shared institution. Ravitch writes that \n “one of the greatest glories of the public \n school was its success in Americanizing immigrants.” \n At their best, public schools did even more than that, \n integrating both immigrants and American-born students \n from a range of backgrounds into one citizenry.\n";
        text+="Already, some experts have noted a conspicuous link between \n the decline of civics education and young adults’ dismal voting rates. \n Civics knowledge is in an alarming state: Three-quarters of \n Americans can’t identify the three branches of government. \n Public-opinion polls, meanwhile, show a \n new tolerance for authoritarianism, and rising levels of \n antidemocratic and illiberal thinking.";
        text+="Reduce opportunity gaps through efforts like creating \n laws that ensure parents in poverty have time \n to spend time with their children, raising household incomes \n for low-income families, creating access to health care for needy families, \n enriching early \n childhood education for all kids, and \n supporting equitable and adequate state school funding.";
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


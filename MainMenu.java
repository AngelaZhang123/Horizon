import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.FileWriter; import java.io.PrintWriter;
import java.io.File; import java.io.FileNotFoundException;
import java.io.IOException;import java.util.Scanner;

public class MainMenu extends JPanel implements ActionListener{

    CardLayout lay;
    JPanel cards;
    public MainMenu(CardLayout x, JPanel y)
    {
        lay=x;
        cards=y;

        JButton quizB = new JButton("Start");
        quizB.addActionListener(this);
        quizB.setFont(new Font("Monospaced", Font.PLAIN, 30));

        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        quizB.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createRigidArea(new Dimension(0,400)));
        add(quizB);
    }
    public void paintComponent(Graphics g) //the graphics for Main menu (the background pic)
    {
        super.paintComponent(g);
        Image nature = new ImageIcon("horizon1.jpg").getImage();
        g.drawImage(nature,0,0,600,600,null);

        g.setColor(Color.WHITE);//name of program
        g.setFont(new Font("Monospaced",Font.BOLD,80));
        g.drawString("Horizon",145,225);
        g.setFont(new Font("Monospaced",Font.PLAIN,20));
        g.drawString("going beyond the horizon",145,305);
        g.setFont(new Font("Monospaced",Font.PLAIN,20));
        g.drawString("learning about the other side",135,325);

    }
    public void actionPerformed(ActionEvent e)
    {
        System.out.println("Showing STARTPANEL");

        lay.show(cards, "QuizPanel");
        System.out.println("YOYO");
    }

}

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

        JButton quizB = new JButton("Learn more");
        quizB.addActionListener(this);
        quizB.setFont(new Font("Monospaced", Font.PLAIN, 30));

        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        quizB.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createRigidArea(new Dimension(0,350)));
        add(quizB);

        JButton write = new JButton("Discussion");
        write.addActionListener(this);
        write.setAlignmentX(Component.CENTER_ALIGNMENT);
        write.setFont(new Font("Monospaced", Font.PLAIN, 30));
        add(write);
    }
    public void paintComponent(Graphics g) //the graphics for Main menu (the background pic)
    {
        super.paintComponent(g);
        Image nature = new ImageIcon("horizon1.jpg").getImage();
        g.drawImage(nature,0,0,600,600,null);

        g.setColor(Color.WHITE);//name of program
        g.setFont(new Font("Monospaced",Font.BOLD,80));
        g.drawString("Horizon",145,225);
        g.setFont(new Font("Monospaced",Font.PLAIN,30));
        g.drawString("brief desc",145,305);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Learn more"))
            lay.show(cards, "QuizPanel");
        if(e.getActionCommand().equals("Discussion")) {
            lay.show(cards, "FirstPost");
        }
    }

}
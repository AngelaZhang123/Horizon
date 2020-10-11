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


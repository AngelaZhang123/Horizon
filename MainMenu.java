import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.FileWriter; import java.io.PrintWriter;
import java.io.File; import java.io.FileNotFoundException;
import java.io.IOException;import java.util.Scanner;

public class MainMenu extends JPanel{

    public MainMenu()
    {
        JButton quizB = new JButton("Take the quiz");
        MainMenuHandler mmH = new MainMenuHandler();
        quizB.addActionListener(mmH);
        quizB.setFont(new Font("Monospaced", Font.PLAIN, 30));

        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        quizB.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createRigidArea(new Dimension(0,200)));
        add(quizB);
    }
    public void paintComponent(Graphics g) //the graphics for Main menu (the background pic)
    {
        super.paintComponent(g);

    }


}

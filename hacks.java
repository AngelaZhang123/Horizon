import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.FileWriter; import java.io.PrintWriter;
import java.io.File; import java.io.FileNotFoundException;
import java.io.IOException;import java.util.Scanner;

public class hacks extends JFrame //the class with the main
{
    public static void main(String[] args) //the main
    {
        hacks uwu = new hacks();
        uwu.createAndShowGUI();
    }
    public void createAndShowGUI() //creates the frame
    {
        JFrame frame = new JFrame("hacks.java");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.gray);

        Panels demo = new Panels();
        demo.addComponentToPane(frame.getContentPane());

        frame.setVisible(true);
    }
}

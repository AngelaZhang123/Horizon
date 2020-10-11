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

    JButton sagree;
    JButton neutral;
    JButton agree;
    JButton disagree;
    JButton sdis;
    public Quiz(CardLayout x, JPanel y)
    {
        lay =x;
        cards=y;
        topic =0;

        JTextField txtInput = new JTextField("Which topic would you like to explore?");
        add(txtInput);
        JButton one = new JButton("Economy");
        JButton two = new JButton("Immigration");
        JButton submit = new JButton("Submit");

        one.addActionListener(this);
        one.setFont(new Font("Monospaced", Font.PLAIN, 30));
        add(one);
        two.addActionListener(this);
        two.setFont(new Font("Monospaced", Font.PLAIN, 30));
        add(two);
        submit.addActionListener(this);
        submit.setFont(new Font("Monospaced", Font.PLAIN, 30));
        add(submit);

        /*sagree = new JButton("Strongly agree");
        agree = new JButton("Agree");
        neutral = new JButton("Neutral");
        disagree = new JButton("Disagree");
        sdis = new JButton("Strongly Disagree");

        add(sagree);
        add(agree);
        add(neutral);
        add(disagree);
        add(sdis);*/

        JSlider opinion=new JSlider(JSlider.HORIZONTAL, 5);
        Hashtable hashTable = new Hashtable(4);

        hashTable.put(new Integer( 0 ), new JLabel("Strongly Agree") );
        hashTable.put(new Integer( 1 ), new JLabel("Agree") );
        hashTable.put(new Integer( 2 ), new JLabel("Neutral") );
        hashTable.put(new Integer( 3 ), new JLabel("Diagree") );
        hashTable.put(new Integer( 4 ), new JLabel("Strongly Disagree") );

        OpListener lst = new OpListener();

        opinion.setLabelTable(hashTable);
        opinion.setPaintLabels(true);
        opinion.setMajorTickSpacing(1);
        opinion.setPaintTicks(true);
        opinion.addChangeListener(lst);
        add(opinion);
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
            repaint();
        }
        if(command.equals("Immigration")) {
            topic = 2;
            repaint();
        }
        if(command.equals("Submit"))
        {
            if(topic==1)lay.show(cards,"EconomyP");
            else lay.show(cards,"ImmigrationP");
        }
    }
    class OpListener implements ChangeListener
    {
        public void stateChanged(ChangeEvent e) {

        }
    }
}

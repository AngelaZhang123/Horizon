import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Post extends JPanel implements ActionListener //Panel for entering your name
{
    CardLayout lay;
    JPanel cards;
    PrintWriter pw;
    Scanner input;
    JTextArea whole;
    public Post(CardLayout x, JPanel y)//initialize stuff here
    {
        lay=x;
        cards=y;
        input=null;
        pw=null;
        setLayout(new BorderLayout());

        JPanel south = new JPanel();
        south.setBackground(Color.BLACK);
        add(south, BorderLayout.SOUTH);

        Font mono= new Font("Monospaced",Font.PLAIN,15);
        Font monoSmall = new Font("Monospaced",Font.PLAIN,20);
        Font monoBold = new Font("Monospaced",Font.BOLD, 20);

        JButton mainB = new JButton("Post");
        mainB.addActionListener( this );
        mainB.setFont(monoSmall);
        south.add(mainB);

        JLabel title = new JLabel(" Discussion Thread--Topic of the Day:Economy");
        title.setFont(monoBold);
        add(title,BorderLayout.NORTH);

        whole = new JTextArea(runIt(""));
        whole.setFont(mono);
        whole.setBackground(new Color(255,204,51));

        add(whole, BorderLayout.CENTER);

        JScrollPane scrollBar = new JScrollPane(whole,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scrollBar, BorderLayout.CENTER);
    }
    public void paintComponent(Graphics g)//create the graphics (just the words)
    {
        super.paintComponent(g);
    }
    public void actionPerformed(ActionEvent event)
    {
        lay.show(cards,"WritePanel");
    }
    public String runIt(String currI)//reading/writing to the textfile and returning the string with all the leaderboard info
    {
        String all="";
        String app="";
        tryCatchRead();

        while(input.hasNextLine())
        {
            boolean go=true;
            while(go)
            {
                String line = input.nextLine();
                if(line.equals("END"))go=false;
                else {
                    all += ("Anonymous: "+line + "\n\n");
                    app += (line + "\nEND\n");
                }
            }
        }
        tryCatchWrite();
        if(!currI.equals("")) {
            app += currI + "\nEND\n";
            all += ("Anonymous: " + currI + "\n");
        }

        pw.print(app);
        pw.close();
        input.close();
        return all;
    }
    public void tryCatchWrite()//tryCatch for overwriting the text file
    {
        File outFile=new File ("Board.txt");
        try
        {
            pw = new PrintWriter(outFile);
        }
        catch ( IOException e)
        {
            System.err.println("Cannot write to " +  outFile);
            System.exit(1);
        }
    }
    public void tryCatchRead()//trycatch for reading the text file
    {
        File inFile = new File ("Board.txt");
        String inFileName = "Board.txt";
        try
        {
            input = new Scanner( inFile );
        }
        catch ( FileNotFoundException e )
        {
            System.err.println("Cannot find " + inFileName + " file.");
            System.exit(1);
        }
    }
}


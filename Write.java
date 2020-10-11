import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Write extends JPanel implements ActionListener //Panel for entering your name
{
    JPanel post;
    JTextField txtInput;
    CardLayout lay;
    JPanel cards;
    PrintWriter pw;
    Scanner input;
    JTextArea whole;
    public Write(CardLayout x, JPanel y)//initialize stuff here
    {
        input=null;
        pw=null;

        post = new JPanel();
        lay=x;
        cards=y;
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        txtInput = new JTextField("");
        txtInput.setAlignmentX(Component.CENTER_ALIGNMENT);
        txtInput.setFont(new Font("Monospaced",Font.PLAIN,20));
        txtInput.setColumns(5);

        Font font = new Font("Monospaced",Font.BOLD,30);

        JButton done = new JButton("Done");
        done.setFont(font);
        done.addActionListener(this);
        done.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createRigidArea(new Dimension(0,200)));
        add(txtInput);

        add(done);
        add(Box.createRigidArea(new Dimension(0,200)));
    }
    public void paintComponent(Graphics g)//create the graphics (just the words)
    {
        super.paintComponent(g);
        setBackground(new Color(255,204,51));
        g.setFont(new Font("Monospaced",Font.PLAIN,30));
        g.drawString("Add a post to the discussion!",40,100);
    }
    public void actionPerformed(ActionEvent event)
    {
        if(event.getActionCommand().equals("Done"))
        {
            run();
            lay.show(cards,"PostBoard");
        }
        if(event.getActionCommand().equals("Back to main menu"))
        {
            lay.show(cards,"MainMenu");
        }
    }
    public String getInput()
    {
        return txtInput.getText();
    }
    public void run()
    {
        post.setLayout(new BorderLayout());

        JPanel south = new JPanel();
        south.setBackground(Color.BLACK);
        post.add(south, BorderLayout.SOUTH);

        Font mono= new Font("Monospaced",Font.PLAIN,50);
        Font monoSmall = new Font("Monospaced",Font.PLAIN,20);
        Font monoBold = new Font("Monospaced",Font.BOLD, 20);

        JButton mainB = new JButton("Back to main menu");
        mainB.addActionListener( this );
        mainB.setFont(monoSmall);
        south.add(mainB);

        JLabel title = new JLabel(" Discussion Thread--Topic of the Day:Economy");
        title.setFont(monoBold);
        post.add(title,BorderLayout.NORTH);
        whole = new JTextArea(runIt(txtInput.getText()));
        whole.setFont(monoSmall);
        whole.setBackground(new Color(255,204,51));

        post.add(whole, BorderLayout.CENTER);

        JScrollPane scrollBar = new JScrollPane(whole,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        post.add(scrollBar, BorderLayout.CENTER);
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
        app+= currI+"\nEND\n";
        all+= ("Anonymous: "+currI+"\n");

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

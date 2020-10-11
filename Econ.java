import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.FileWriter; import java.io.PrintWriter;
import java.io.File; import java.io.FileNotFoundException;
import java.io.IOException;import java.util.Scanner;

public class Econ extends JPanel implements ActionListener{
    CardLayout lay;
    JPanel cards;

    public Econ(CardLayout x, JPanel y)
    {
        lay =x;
        cards=y;
        JButton back = new JButton("Back to main menu");
        back.setFont(new Font("Monospaced", Font.PLAIN, 30));
        back.addActionListener(this);
        setLayout(new BorderLayout());
        add(back,BorderLayout.SOUTH);

        JLabel title = new JLabel("ECONOMY");
        title.setFont(new Font("Monospaced", Font.PLAIN, 80));
        add(title,BorderLayout.NORTH);

        String info = "Supply-side economics: increased production drives economic growth. \nThe factors of production are capital, labor, entrepreneurship, and land";
        info+="\nTax cuts on businesses/corps and deregulation (lower minimum wage, \nless regulation on workers’ benefits, anti-workers union(?)\n";
        info+="\nThat says what's good for the wealthy will trickle down to everyone \nin the society. Proponents believe that investors, savers, \nand company owners are the real drivers of growth.\n";
        info+="\nAdvocates of trickle-down economics promise that businesses will use \nthe extra cash from tax cuts to expand. Investors will use \ntheir tax-cut windfall to buy more companies or \nstocks. Owners will invest in their operations and hire workers.4\n";
        info+="\nSupply-siders claim that this greater growth will always make up for \n the lost tax revenue.";

        JTextArea body = new JTextArea(info);
        body.setFont(new Font("Monospaced", Font.PLAIN, 10));
        add(body,BorderLayout.CENTER);
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


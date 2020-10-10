import javax.swing.*;
import java.awt.*;

class Panels extends JPanel //where all the panels are created
{
    JPanel cards;
    CardLayout lay;

    public Panels() //things are initialized here
    {
        lay = new CardLayout();
        cards = new JPanel(lay);
    }

    public void addComponentToPane(Container pane) //the cards are added to the pane
    {
        create();
        pane.add(cards, BorderLayout.CENTER);
    }

    public void create() //the instances of the cards/panels are created and added to the cards
    {

    }
}

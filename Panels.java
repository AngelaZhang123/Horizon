import javax.swing.*;
import java.awt.*;

class Panels extends JPanel //where all the panels are created
{
    JPanel cards;
    CardLayout lay;

    final static String MMPANEL = "MainMenu";
    final static String QPANEL = "QuizPanel";
    final static String EPANEL = "EconomyP";
    final static String IPANEL = "ImmigrationP";

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
        MainMenu mm = new MainMenu(lay,cards);
        Quiz qq = new Quiz(lay,cards);
        Econ ee = new Econ(lay,cards);
        Imm ii = new Imm(lay,cards);

        cards.add(mm,MMPANEL);
        cards.add(qq,QPANEL);
        cards.add(ee,EPANEL);
        cards.add(ii,IPANEL);
    }
}

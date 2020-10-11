import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuHandler implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
        System.out.println("Showing STARTPANEL");
        Panels x = new Panels();
        x.create();
        x.lay.show(x.cards, x.MMPANEL);
        System.out.println("YOYO");
    }
}

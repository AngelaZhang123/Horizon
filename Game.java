package com.company;//Angela Zhang
//P5 4-22-2020
//Game.java

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.FileWriter; import java.io.PrintWriter;
import java.io.File; import java.io.FileNotFoundException; 
import java.io.IOException;import java.util.Scanner; 

public class Game extends JFrame //the class with the main
{
  public static void main(String[] args) //the main
  {
    Game uwu = new Game();
    uwu.createAndShowGUI();
  }
  public void createAndShowGUI() //creates the frame
  {
    JFrame frame = new JFrame("Game.java");
    frame.setSize(600, 600);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setBackground(Color.gray);
  
    Panels demo = new Panels();
    demo.addComponentToPane(frame.getContentPane());
    
    frame.setVisible(true);
  }
}
class Panels extends JPanel //where all the panels are created
{
  JPanel cards; 
  final static String STARTPANEL = "Starting card";
  final static String INSTRUCTIONSPANEL = "Instructions card";
  final static String NAMEPANEL = "Name card";
  final static String LEVEL1PANEL = "Level1 card";
  final static String LEVEL2PANEL = "Level2 card";
  final static String LEVEL3PANEL = "Level3 card";
  final static String ENDPANEL = "End card";
  //final static String LEADERBOARD = "Leaderboard card";
  CardLayout lay;
  PlayBHandler playH;
  InstBHandler instH;
  MainMenuHandler mainH;
  MainMenu mm;
  Instructions ins;
  Image doorClose;
  Image doorOpen;
  Timer speed;
  int clockTime;
  JLabel clock1,clock2,clock3;
  String passed;
  String name;
  int min, sec;
  //String all;
  int go2;
  JPanel end;
  int card;
  JButton resB;

  public Panels() //things are initialized here
  {
    lay = new CardLayout();
    cards = new JPanel(lay);

    playH = new PlayBHandler();
    instH = new InstBHandler();
    mainH = new MainMenuHandler();

    doorClose = new ImageIcon("door_close.png").getImage();
    doorOpen = new ImageIcon("door_open.png").getImage();

    Timing time = new Timing();
    speed = new Timer(1000, time);
    clockTime=0;
    passed="";
    clock1 = new JLabel();
    clock2 = new JLabel();
    clock3 = new JLabel();

    name="";

    card=0;
  }
  public void addComponentToPane(Container pane) //the cards are added to the pane
  {
    create();
    pane.add(cards, BorderLayout.CENTER);
  }
  public void create() //the instances of the cards/panels are created and added to the cards
  {
    name="";

    mm = new MainMenu();
    ins = new Instructions(card);
    ChooseName nameC = new ChooseName();
    LevelOne lv1 = new LevelOne();
    LevelTwo lv2 = new LevelTwo();
    LevelThree lv3 = new LevelThree();
    end = new JPanel();
    //Leaderboard ld = new Leaderboard();
    cards.add(mm, STARTPANEL);
    cards.add(ins, INSTRUCTIONSPANEL);
    cards.add(nameC,NAMEPANEL);
    cards.add(lv1, LEVEL1PANEL);
    cards.add(lv2, LEVEL2PANEL);
    cards.add(lv3, LEVEL3PANEL);
    cards.add(end, ENDPANEL);
    //cards.add(ld, LEADERBOARD);
    //start=false;
  }
  class PlayBHandler implements ActionListener //handler of the play button
  {
    public void actionPerformed(ActionEvent e)//show the level1 card when you press play
    {
      //System.out.println("PlayBHandler showing level1!!!");
      create();
      lay.show(cards,NAMEPANEL);
    }
  }
  class InstBHandler implements ActionListener //handler of the button to go to instructions
  {
    public void actionPerformed(ActionEvent e)//show instructions card when you press instructions
    {
      //System.out.println("InstBHandler showing instructions!!!");
      speed.stop();
      if(card==0) 
      {
        resB.setText("Play");
      }
      else resB.setText("Resume");
      lay.show(cards,INSTRUCTIONSPANEL);
    }
  }
  class MainMenuHandler implements ActionListener//handler of button to go back to main menu
  {
    public void actionPerformed(ActionEvent e)//show the starting card (mm)
    {
      //System.out.println("Showing STARTPANEL");
      card=0;
      lay.show(cards,STARTPANEL);
    }
  }
  class Timing implements ActionListener //timer for how fast you go through the game
  {
    public void actionPerformed(ActionEvent e)//increase the time by 1 sec every 1 sec
    {
      clockTime++;
      min = clockTime/60;
      sec = clockTime%60;
      if(min<10)
      {
        if(sec<10) passed ="0"+min+":"+"0"+sec;
        else passed="0"+min+":"+sec;
      }
      else 
      {
        if(sec<10) passed=min+":"+"0"+sec;
        else passed=min+":"+sec;
      }
      clock1.setFont(new Font("Monospaced",Font.BOLD,15));
      clock2.setFont(new Font("Monospaced",Font.BOLD,15));
      clock3.setFont(new Font("Monospaced",Font.BOLD,15));

      clock3.setForeground(Color.WHITE);

      clock1.setText(passed);
      clock2.setText(passed);
      clock3.setText(passed);
     }
    }
  class MainMenu extends JPanel //main menu panel
  {
    int count;
    public MainMenu()//make the starting panel
    {
      //setBackground(Color.pink);
      count=1;

      Animation ani = new Animation();
      Timer animate = new Timer(200,ani);
      animate.start();
      
      JButton playB = new JButton("Play");
      playB.addActionListener( playH );
      playB.setFont(new Font("Monospaced", Font.PLAIN, 30));

      JButton instB = new JButton("Instructions");
      instB.addActionListener(instH);
      instB.setFont(new Font("Monospaced", Font.PLAIN, 30));

      setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
      playB.setAlignmentX(Component.CENTER_ALIGNMENT);
      instB.setAlignmentX(Component.CENTER_ALIGNMENT);
      add(Box.createRigidArea(new Dimension(0,200)));
      add(playB);
      add(Box.createRigidArea(new Dimension(0,100)));
      add(instB);
    }
    public void paintComponent(Graphics g) //the graphics for Main menu (the background pic)
    {
      super.paintComponent(g);
      //setBackground(Color.PINK);
      Image nature = new ImageIcon("nature.jpg").getImage();
      g.drawImage(nature,0,0,600,600,null);

      Image pic11 = new ImageIcon("NinjaAnimation/Pic1.1.png").getImage();
      Image pic12 = new ImageIcon("NinjaAnimation/Pic1.2.png").getImage();
      Image pic13 = new ImageIcon("NinjaAnimation/Pic1.3.png").getImage();
      Image pic21 = new ImageIcon("NinjaAnimation/Pic2.1.png").getImage();
      Image pic22 = new ImageIcon("NinjaAnimation/Pic2.2.png").getImage();
      Image pic23 = new ImageIcon("NinjaAnimation/Pic2.3.png").getImage();
      Image pic31 = new ImageIcon("NinjaAnimation/Pic3.1.png").getImage();
      Image pic32 = new ImageIcon("NinjaAnimation/Pic3.2.png").getImage();
      Image pic33 = new ImageIcon("NinjaAnimation/Pic3.3.png").getImage();
      Image pic41 = new ImageIcon("NinjaAnimation/Pic4.1.png").getImage();
      Image pic42 = new ImageIcon("NinjaAnimation/Pic4.2.png").getImage();
      Image pic43 = new ImageIcon("NinjaAnimation/Pic4.3.png").getImage();
      Image pic51 = new ImageIcon("NinjaAnimation/Pic5.1.png").getImage();
      Image pic52 = new ImageIcon("NinjaAnimation/Pic5.2.png").getImage();
      Image pic53 = new ImageIcon("NinjaAnimation/Pic5.3.png").getImage();
      Image pic61 = new ImageIcon("NinjaAnimation/Pic6.1.png").getImage();
      Image pic62 = new ImageIcon("NinjaAnimation/Pic6.2.png").getImage();
      Image pic63 = new ImageIcon("NinjaAnimation/Pic6.3.png").getImage();

      if(count==1)
      {
        g.drawImage(pic11, 30,50,100,100,null);
        g.drawImage(pic21, 30,400,100,100,null);
        g.drawImage(pic31, 420,50,100,100,null);
        g.drawImage(pic41, 420,400,100,100,null);
        g.drawImage(pic51, 30,225,100,100,null);
        g.drawImage(pic61, 420,225,100,100,null);
      }
      if(count==2)
      {
        g.drawImage(pic12, 30,50,100,100,null);
        g.drawImage(pic22, 30,400,100,100,null);
        g.drawImage(pic32, 420,50,100,100,null);
        g.drawImage(pic42, 420,400,100,100,null);
        g.drawImage(pic52, 30,225,100,100,null);
        g.drawImage(pic62, 420,225,100,100,null);
      }
      if(count==3)
      {
        g.drawImage(pic13, 30,50,100,100,null);
        g.drawImage(pic23, 30,400,100,100,null);
        g.drawImage(pic33, 420,50,100,100,null);
        g.drawImage(pic43, 420,400,100,100,null);
        g.drawImage(pic53, 30,225,100,100,null);
        g.drawImage(pic63, 420,225,100,100,null);
      }
      g.setColor(Color.WHITE);//name of program
      g.setFont(new Font("Monospaced",Font.BOLD,80));
      g.drawString("Ninja",165,125);
    }
    class Animation implements ActionListener //animating the little ninjas
    {
      public void actionPerformed(ActionEvent e)//change count to change the picture of the ninja shown
      {
        count++;
        if(count==4)count=1;
        repaint();
      }
    }
  } 
  class Instructions extends JPanel //the instructions panel
  {
    JButton mainB;
    JPanel buttons;
    public Instructions(int cardNum)//make instructions panel
    {
      setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
      JLabel title = new JLabel("Instructions");
      title.setFont(new Font("Monospaced",Font.BOLD,35));

      Font fontS = new Font("Monospaced",Font.BOLD,18);

      JLabel text1 = new JLabel("Use the arrow keys to maneuver");
      text1.setFont(fontS);

      JLabel text11 = new JLabel("to the end door.");
      text11.setFont(fontS);

      JLabel text2 = new JLabel("In Level 1, avoid the bullets.");
      text2.setFont(fontS);

      JLabel text3 = new JLabel("In Level 2, avoid the explosives,");
      text3.setFont(fontS);

      JLabel text35 = new JLabel("which will flicker on and off.");
      text35.setFont(fontS);

      JLabel text4 = new JLabel("In Level 3, get past the river by");
      text4.setFont(fontS);
      add(text4);

      JLabel text45 = new JLabel("hopping on logs using the shift key");
      text45.setFont(fontS);

      JLabel text5 = new JLabel("If you get hit, you will die");
      text5.setFont(fontS);

      JLabel text51 = new JLabel("and be reincarcenated at the start.");
      text51.setFont(fontS);

      JLabel text6 = new JLabel("Avoid the red ninjas");
      text6.setFont(fontS);

      title.setAlignmentX(Component.LEFT_ALIGNMENT);
      add(title);
      add(Box.createRigidArea(new Dimension(0,40)));
      text1.setAlignmentX(Component.LEFT_ALIGNMENT);
      text11.setAlignmentX(Component.LEFT_ALIGNMENT);
      add(text1);
      add(text11);
      add(Box.createRigidArea(new Dimension(0,30)));
      text2.setAlignmentX(Component.LEFT_ALIGNMENT);
      add(text2);
      add(Box.createRigidArea(new Dimension(0,30)));
      text3.setAlignmentX(Component.LEFT_ALIGNMENT);
      add(text3);
      text35.setAlignmentX(Component.LEFT_ALIGNMENT);
      add(text35);
      add(Box.createRigidArea(new Dimension(0,30)));
      text4.setAlignmentX(Component.LEFT_ALIGNMENT);
      add(text4);
      text45.setAlignmentX(Component.LEFT_ALIGNMENT);
      add(text45);
      add(Box.createRigidArea(new Dimension(0,30)));
      text5.setAlignmentX(Component.LEFT_ALIGNMENT);
      text51.setAlignmentX(Component.LEFT_ALIGNMENT);
      add(text5);
      add(text51);
      text6.setAlignmentX(Component.LEFT_ALIGNMENT);
      add(Box.createRigidArea(new Dimension(0,30)));
      add(text6);
      add(Box.createRigidArea(new Dimension(0,20)));

      buttons = new JPanel();
      add(buttons);
      buttons.setBackground(Color.CYAN);

      Font font = new Font("Monospaced",Font.PLAIN,20);

      resB = new JButton("Resume");
      Resume resH = new Resume();
      resB.addActionListener( resH );
      resB.setFont(font);

      mainB = new JButton("Back to Main Menu");
      mainB.addActionListener(mainH);
      mainB.setFont(font);
      
      buttons.add(mainB);
      buttons.add(resB);

      buttons.setAlignmentX(Component.CENTER_ALIGNMENT);
    }
    public void paintComponent(Graphics g) //the graphics for instructions (the background pic)
    {
      super.paintComponent(g);

      Instructions inst = new Instructions(card);

      //System.out.print("in paint");
      Image sky = new ImageIcon("sky.jpg").getImage();
      g.drawImage(sky,0,0,600,600,null);
      //setBackground(Color.GREEN);
      Image arrows = new ImageIcon("arrows.png").getImage();
      g.drawImage(arrows, 10, 75, 70, 50, null);

      g.setColor(Color.RED);
      g.fillOval(10,170,10,10);
      g.fillOval(30,170,10,10);
      g.fillOval(50,170,10,10);

      Image tnt = new ImageIcon("tnt.png").getImage();
      g.drawImage(tnt,10,230,40,50,null);

      Image log = new ImageIcon("log.png").getImage();
      g.drawImage(log,10,300,20,50,null);

      Image deadNinja = new ImageIcon("dead_ninja.png").getImage();
      g.drawImage(deadNinja,10,380,70,50,null);

      Image evilNinja = new ImageIcon("evilNinja.png").getImage();
      g.drawImage(evilNinja,10,450,50,50,null);
    }
    class Resume implements ActionListener //resuming the game when in instructions panel
    {
      public void actionPerformed(ActionEvent e)//show the correct panel
      {
        speed.start();
        if(card==0)
          {
            create();
            lay.show(cards, NAMEPANEL);
          }
        if(card==1)lay.show(cards,LEVEL1PANEL);
        if(card==2)lay.show(cards,LEVEL2PANEL);
        if(card==3)lay.show(cards,LEVEL3PANEL);
      }
    }
  }
  class ChooseName extends JPanel //Panel for entering your name
  {
    JTextField txtInput;
    public ChooseName()//initialize stuff here
    {
      setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
      txtInput = new JTextField("");
      txtInput.setAlignmentX(Component.CENTER_ALIGNMENT);
      txtInput.setFont(new Font("Monospaced",Font.PLAIN,20));
      txtInput.setColumns(5);

      Font font = new Font("Monospaced",Font.BOLD,30);

      JButton done = new JButton("Done");
      done.setFont(font);
      InputListener txtHandler = new InputListener();
      done.addActionListener(txtHandler);
      done.setAlignmentX(Component.CENTER_ALIGNMENT);
      add(Box.createRigidArea(new Dimension(0,200)));
      add(txtInput);

      add(done);
      add(Box.createRigidArea(new Dimension(0,200)));
    }
    public void paintComponent(Graphics g)//create the graphics (just the words)
    {
      super.paintComponent(g);
      Image daisy = new ImageIcon("flowerMeadow.jpeg").getImage();
      g.drawImage(daisy,0,0,1000,610,null);
      g.setColor(Color.BLACK);
      g.setFont(new Font("Monospaced",Font.PLAIN,50));
      g.drawString("Enter your name:",60,100);
    }
    class InputListener implements ActionListener//the listener for the done button to get the name from the textarea
    {
        public void actionPerformed(ActionEvent event)
        {
            clockTime=0;
            passed="";

            name = txtInput.getText();
            speed.start();
            card=1;
            lay.show(cards,LEVEL1PANEL);
        }
    }
  }
class LevelOne extends JPanel implements KeyListener //The panel for Level1
{
  int x,y;
  int shootX,shootY;
  boolean way, open, dead, dead2;
  Image ninja, deadNinja;
  DoorOpen door;
  Timer doorTimer,shootTimer,deadTimer;
  boolean stop;
  JButton pause;
  public LevelOne() //initialize stuff for Level1 
  {
    addKeyListener(this);
    setLayout(new BorderLayout());

    Font font = new Font("Monospaced",Font.PLAIN,15);
    x=0;
    y=0;

    shootX=200;
    shootY=30;
    way=true;
    open=false;
    dead=false;
    dead2=true;
    stop=false;

    ShootMover shooter = new ShootMover();
    shootTimer = new Timer(2, shooter);
    shootTimer.start();

    door = new DoorOpen();
    doorTimer = new Timer(1000, door);

    DeadShow deadS = new DeadShow();
    deadTimer = new Timer(2000,deadS);

    JButton mainB = new JButton("Back to main menu");
    mainB.setFont(font);
    mainB.addActionListener( mainH );

    JButton instB = new JButton("Instructions");
    instB.addActionListener(instH);
    instB.setFont(font);

    pause = new JButton("Pause");
    Pause ps = new Pause();
    pause.addActionListener(ps);
    pause.setFont(font);

    JPanel panel = new JPanel();
    panel.setBackground(Color.GREEN);
    add(panel,BorderLayout.SOUTH);

    panel.add(pause);
    panel.add(mainB);
    panel.add(instB);
    panel.add(clock1);

    ninja = new ImageIcon("ninja_front.png").getImage();
    deadNinja = new ImageIcon("dead_ninja.png").getImage();
  }
  public void paintComponent(Graphics g) //the graphics for Level1
  {
    super.paintComponent (g);
    grabFocus();
    Image grassBack = new ImageIcon("grass2.jpg").getImage();
    g.drawImage(grassBack, 0, 0, 800, 600, null); 

    g.drawImage(doorClose,500,400,70,100,null);
    if(x>450&&y>400){
      //System.out.println("hi!");
      g.drawImage(doorOpen,500,400,70,120,null);
      doorTimer.start();
      shootTimer.stop();
    }
    if(open)
      {
        card=2;
        lay.show(cards,LEVEL2PANEL);        
      }

    if(!dead)g.drawImage(ninja, x, y, 50, 50, null);

    if(dead && dead2)
    {
      g.drawImage(deadNinja,x,y,70,50,null);
    }
    else if(dead && !dead2)
    {
      x=0;
      y=0;
      dead=false;
      dead2=true;
      deadTimer.stop();
    }
    g.setColor(Color.RED);
    //grabFocus();
    //boolean haha=true;
    for(int i=0;i<1000;i+=50)
    {
        g.fillOval(shootX,shootY-i,10,10);
        //i+=50;
    }
    for(int j=0;j<1000;j+=50)
    {
      g.fillOval(shootX,shootY+j,10,10);
    }

    Image evil = new ImageIcon("evilNinja.png").getImage();
    g.drawImage(evil,shootX-15,0,50,50,null);

    g.setColor(Color.BLACK);
    g.setFont(new Font("Monospaced",Font.BOLD,150));
    if(stop)g.drawString("PAUSED",0,300);
  }
  public void keyTyped(KeyEvent e) {} //empty method
  public void keyPressed(KeyEvent e) //to move ur action figure
  {
      //System.out.print("hi");
      if(e.getKeyCode()==KeyEvent.VK_RIGHT)
      {
        if(!dead && !stop)
        {
          x+=10;
          ninja = new ImageIcon("ninja_right.png").getImage();
        }
        //System.out.print("HI");
      }
      if(e.getKeyCode()==KeyEvent.VK_LEFT)
      {
        if(!dead&& !stop)
        {
          x-=10;
          ninja = new ImageIcon("ninja_left.png").getImage();
        }
      }
      if(e.getKeyCode()==KeyEvent.VK_UP)
      {
        if(!dead && !stop)
        {
          y-=10;
          ninja = new ImageIcon("ninja_back.png").getImage();
        }
      }
      if(e.getKeyCode()==KeyEvent.VK_DOWN)
      {
        if(!dead && !stop)
        {
          y+=10;
          ninja = new ImageIcon("ninja_front.png").getImage();
        }
      }
      repaint();
  }
  public void keyReleased(KeyEvent e) {}//empty method
  class ShootMover implements ActionListener //to animate the shooter
  {
    public void actionPerformed(ActionEvent e) //animating the shooter using timer 
    {
        if(shootX>=600)way=false;
        if(shootX<=200)way=true;
        if(way)shootX++;
        if(!way)shootX--;
        shootY++;
        if (shootY > 450) shootY = 200;
        if(x<shootX+10 && x>shootX-10)
        {
          dead=true;
          deadTimer.start();
        }
        repaint();
    }
  }
  class DeadShow implements ActionListener //show the dead person
  {
    public void actionPerformed(ActionEvent e) ////so that the dead ninja shows before regenerating
    {
      dead2=!dead2;
      repaint();
    }
  }
  class DoorOpen implements ActionListener //timer for making the door open
  {
    public void actionPerformed(ActionEvent e) //make the door open and then switch panels
    {
      open=true;
      repaint();
    }
  }
  class Pause implements ActionListener//pausing the game
    {
      public void actionPerformed(ActionEvent e) //stop all the timers
      {
        stop=!stop;
        if(stop)
        {
          speed.stop();
          shootTimer.stop();
          pause.setText("Resume");
        }
        if(!stop)
        {
          speed.start();
          shootTimer.start();
          pause.setText("Pause");
        }
        repaint();
      }
    }
  }
  class LevelTwo extends JPanel implements KeyListener //Level2 panel
  {
    int x,y;
    boolean on, on2, on3, dead, dead2;
    Image ninja, deadNinja;
    Timer doorTimer, deadTimer; 
    boolean open;
    JButton pause;
    boolean stop;
    Timer trapTimer1,trapTimer2, trapTimer3;
    public LevelTwo() //initializing stuff for Level2
    {
      addKeyListener(this);

      Font font = new Font("Monospaced",Font.PLAIN,15);

      x=0;
      y=0;
      on=false;
      on2=false;
      open=false;
      dead=false;
      dead2=true;
      stop=false;

      BoobyTrap1 trap = new BoobyTrap1();
      trapTimer1 = new Timer(2000, trap);
      trapTimer1.start();

      BoobyTrap2 trap2 = new BoobyTrap2();
      trapTimer2 = new Timer(1500,trap2);
      trapTimer2.start();

      BoobyTrap3 trap3 = new BoobyTrap3();
      trapTimer3 = new Timer(1000,trap3);
      trapTimer3.start();

      DoorOpen door = new DoorOpen();
      doorTimer = new Timer(1000,door);

      JButton mainB = new JButton("Back to main menu");
      mainB.addActionListener( mainH );
      mainB.setFont(font);

      JButton instB = new JButton("Instructions");
      instB.addActionListener(instH);
      instB.setFont(font);

      pause = new JButton("Pause");
      Pause ps = new Pause();
      pause.addActionListener(ps);
      pause.setFont(font);

      DeadShow deadS = new DeadShow();
      deadTimer = new Timer(2000,deadS);

      ninja = new ImageIcon("ninja_front.png").getImage();
      deadNinja = new ImageIcon("dead_ninja.png").getImage();

      add(pause);
      add(mainB);
      add(instB);
      clock2.setForeground(Color.WHITE);
      add(clock2);
    }
    public void paintComponent(Graphics g) //the graphics for Level2
    {
      super.paintComponent (g);
      Image stoneBack = new ImageIcon("stone.jpg").getImage();
      g.drawImage(stoneBack, 0, 0, 800, 600, null);
      
      g.drawImage(doorClose,500,450,70,100,null);
      if(x>450&&y>400){
        //System.out.println("hi!");
        g.drawImage(doorOpen,500,450,70,120,null);
        doorTimer.start();
        //shootTimer.stop();
      }
      if(open)
        {
          card=3;
          lay.show(cards,LEVEL3PANEL);
        }

      if(!dead)g.drawImage(ninja, x, y, 50, 50, null);

      if(dead && dead2)
      {
        g.drawImage(deadNinja,x,y,70,50,null);
      }
      else if(dead && !dead2)
      {
        x=0;
        y=0;
        dead=false;
        dead2=true;
        deadTimer.stop();
      }

      g.setColor(Color.RED);
      g.setFont(new Font("Arial",Font.BOLD,60));
      Image tnt = new ImageIcon("tnt.png").getImage();
      if(on)
      {
        g.drawImage(tnt,80,50,40,50,null);
        g.drawImage(tnt,40,50,40,50,null);
        g.drawImage(tnt,80,0,40,50,null);
        g.drawImage(tnt,0,50,40,50,null);
        if((x>=0 && x<=60 && y>=45 && y<=100)|| (y>=0 && y<=100 && x>=70 && x<=90 ))
        {
          dead=true;
          deadTimer.start();
        }
      }
      if(on2)
      {
        for(int i=0; i<320;i+=40)
        {
          g.drawImage(tnt,i,250,40,50,null);
        }
        if(x>=0 && x<=280 && y<=280 && y>=220)
        {
          dead=true;
          deadTimer.start();
        }
      }
      if(on3)
      {
        for(int i=0; i<600; i+=50)
        {
          g.drawImage(tnt,320,i-50,40,50,null);
        }
        if(x>=300 && x<=340)
        {
          dead=true;
          deadTimer.start();
        }
      }
      g.setColor(Color.BLACK);
      g.setFont(new Font("Monospaced",Font.BOLD,150));
      if(stop)g.drawString("PAUSED",0,300);

      grabFocus();
    }
    public void keyTyped(KeyEvent e) {} //empty method
    public void keyPressed(KeyEvent e) //to move ur action figure
    {
      //System.out.print("hi");
        if(e.getKeyCode()==KeyEvent.VK_RIGHT)
      {
        if(!dead && !stop)
        {
          x+=10;
          ninja = new ImageIcon("ninja_right.png").getImage();
        }
        //System.out.print("HI");
      }
      if(e.getKeyCode()==KeyEvent.VK_LEFT)
      {
        if(!dead&& !stop)
        {
          x-=10;
          ninja = new ImageIcon("ninja_left.png").getImage();
        }
      }
      if(e.getKeyCode()==KeyEvent.VK_UP)
      {
        if(!dead && !stop)
        {
          y-=10;
          ninja = new ImageIcon("ninja_back.png").getImage();
        }
      }
      if(e.getKeyCode()==KeyEvent.VK_DOWN)
      {
        if(!dead && !stop)
        {
          y+=10;
          ninja = new ImageIcon("ninja_front.png").getImage();
        }
      }
        repaint();
    }
    public void keyReleased(KeyEvent e) {}
    class BoobyTrap1 implements ActionListener //booby trap set 1
    {
      public void actionPerformed(ActionEvent e) //make booby traps appear/disappear
      {
        on=!on;
        repaint();
      }
    }
    class BoobyTrap2 implements ActionListener //booby trap set 2
    {
      public void actionPerformed(ActionEvent e) //animating the booby traps
      {
        on2=!on2;
        repaint();
      }
    }
    class BoobyTrap3 implements ActionListener //booby trap set 2
    {
      public void actionPerformed(ActionEvent e) //animating the booby trap
      {
        on3=!on3;
        repaint();
      }
    }
    class DeadShow implements ActionListener //timer for the dead feature
    {
      public void actionPerformed(ActionEvent e) //so that the dead ninja shows before regenerating
      {
        dead2=!dead2;
        repaint();
      }
    }
    class DoorOpen implements ActionListener
    {
      public void actionPerformed(ActionEvent e)
      {
        open=true;
        repaint();
      }
    }
    class Pause implements ActionListener //pausing the game
    {
      public void actionPerformed(ActionEvent e) //stop all the timers
      {
        stop=!stop;
        if(stop)
        {
          speed.stop();
          trapTimer1.stop();
          trapTimer2.stop();
          trapTimer3.stop();
          pause.setText("Resume");
        }
        if(!stop)
        {
          speed.start();
          trapTimer1.start();
          trapTimer2.start();
          trapTimer3.start();
          pause.setText("Pause");
        }
        repaint();
      }
    }
  }
  class LevelThree extends JPanel implements KeyListener //Level3 panel
  {
    int x,y;
    boolean open, dead, dead2, kill1, kill2, kill3, kill4;
    Image ninja, deadNinja;
    Timer doorTimer, deadTimer, logTimer;
    PrintWriter pw;
    Scanner input;
    int log1,log2,log3,log4;
    int villain,villain2,villain3,villain4;
    boolean jump, stop;
    JButton pause;
    public LevelThree()//initialize stuff here
    {
      addKeyListener(this);

      Font font = new Font("Monospaced",Font.PLAIN,15);
      x=0;
      y=0;
      open=false;
      dead=false;
      dead2=true;
      kill1=false;
      kill2=false;
      kill3=false;
      kill4=false;

      jump=false;
      villain=0;
      villain2=300;
      villain3=100;
      villain4=500;

      input=null;
      pw=null;
      log1=0;
      log2=300;
      log3=100;
      log4=500;

      stop=false;
      
      Logs log = new Logs();
      logTimer= new Timer(10,log);
      logTimer.start();
      
      JButton mainB = new JButton("Back to main menu");
      mainB.addActionListener( mainH );
      mainB.setFont(font);

      JButton instB = new JButton("Instructions");
      instB.addActionListener(instH);
      instB.setFont(font);

      pause = new JButton("Pause");
      Pause ps = new Pause();
      pause.addActionListener(ps);
      pause.setFont(font);

      DoorOpen door = new DoorOpen();
      doorTimer = new Timer(1000,door);

      DeadShow deadS = new DeadShow();
      deadTimer = new Timer(2000,deadS);

      ninja = new ImageIcon("ninja_front.png").getImage();
      deadNinja = new ImageIcon("dead_ninja.png").getImage();

      add(pause);
      add(mainB);
      add(instB);
      add(clock3);
    }
    public void paintComponent(Graphics g)//the paintcomponent for level3
    {
      super.paintComponent (g);
      grabFocus();
      Image water = new ImageIcon("water.jpg").getImage();
      Image grass = new ImageIcon("grass.jpg").getImage();
      g.drawImage(water, 80, 0, 400, 600, null);
      g.drawImage(grass,-420,0,500,600,null);
      g.drawImage(grass,480,0,500,600,null);
      //g.setColor(Color.CYAN);
      g.drawImage(doorClose,500,450,70,100,null);
      if(x>450&&y>400){
        //System.out.println("hi!");
        g.drawImage(doorOpen,500,450,70,120,null);
        doorTimer.start();
        //bombTimer.stop();
      }
      Image log = new ImageIcon("log.png").getImage();
      Image logB = new ImageIcon("logB.png").getImage();
      Image evil1, evil2, evil3, evil4;
      if(!kill1) evil1 = new ImageIcon("evilNinja.png").getImage();
      else evil1 = new ImageIcon("evilNinja2.png").getImage();

      if(!kill2) evil2 = new ImageIcon("evilNinja.png").getImage();
      else evil2 = new ImageIcon("evilNinja2.png").getImage();

      if(!kill3) evil3 = new ImageIcon("evilNinja.png").getImage();
      else evil3 = new ImageIcon("evilNinja2.png").getImage();

      if(!kill4) evil4 = new ImageIcon("evilNinja.png").getImage();
      else evil4 = new ImageIcon("evilNinja2.png").getImage();
      //System.out.print(log1);
      for(int i=0; i<=500; i+=250)
      {
        g.drawImage(log,100,log1+i,60,200,null);
        g.drawImage(logB,200,log2+i,60,200,null);
        g.drawImage(log,300,log3+i,60,200,null);
        g.drawImage(logB,400,log4+i,60,200,null);
      }
      for(int i=500; i>=0; i-=250)
      {
        g.drawImage(log,100,log1-i,60,200,null);
        g.drawImage(logB,200,log2-i,60,200,null);
        g.drawImage(log,300,log3-i,60,200,null);
        g.drawImage(logB,400,log4-i,60,200,null);
      }

      g.drawImage(evil1,100,villain,50,50,null);
      g.drawImage(evil2,200,villain2,50,50,null);
      g.drawImage(evil3,300,villain3,50,50,null);
      g.drawImage(evil4,400,villain4,50,50,null);

      if(open)
        {
          speed.stop();
          endCreate();
          lay.show(cards,ENDPANEL);
        }

      if(dead && dead2)
      {
        g.drawImage(deadNinja,x,y,70,50,null);
      }
      else if(dead && !dead2)
      {
        x=0;
        y=0;
        dead=false;
        kill1=false;
        kill2=false;
        kill3=false;
        kill4=false;
        dead2=true;
        deadTimer.stop();
      }
      if(!dead)g.drawImage(ninja, x, y, 50, 50, null);

      g.setColor(Color.BLACK);
      g.setFont(new Font("Monospaced",Font.BOLD,150));
      if(stop)g.drawString("PAUSED",0,300);
    }
    public void keyTyped(KeyEvent e){} //empty method  
    public void keyPressed(KeyEvent e) //to move ur action figure
    {
      //System.out.print("hi");
        if(e.getKeyCode()==KeyEvent.VK_RIGHT)
      {
        if(!dead && !stop)
        {
          x+=10;
          ninja = new ImageIcon("ninja_right.png").getImage();
        }
        //System.out.print("HI");
      }
      if(e.getKeyCode()==KeyEvent.VK_LEFT)
      {
        if(!dead&& !stop)
        {
          x-=10;
          ninja = new ImageIcon("ninja_left.png").getImage();
        }
      }
      if(e.getKeyCode()==KeyEvent.VK_UP)
      {
        if(!dead && !stop)
        {
          y-=10;
          ninja = new ImageIcon("ninja_back.png").getImage();
        }
      }
      if(e.getKeyCode()==KeyEvent.VK_DOWN)
      {
        if(!dead && !stop)
        {
          y+=10;
          ninja = new ImageIcon("ninja_front.png").getImage();
        }
      }
      if(e.getKeyCode() == KeyEvent.VK_SHIFT)
      {
        x+=100;
        ninja = new ImageIcon("ninja_jump.png").getImage();
      }
        repaint();
      }
    public void keyReleased(KeyEvent e){}//empty method
    class DoorOpen implements ActionListener //timer for the door
    {
      public void actionPerformed(ActionEvent e)//make the door open before going to next panel
      {
        open=true;
        repaint();
      }
    }
    class DeadShow implements ActionListener //dead timer
    {
      public void actionPerformed(ActionEvent e)//so that the dead ninja shows before regenerating
      {
        dead2=!dead2;
        repaint();
      }
    }
    class Logs implements ActionListener //Make the logs move
    {
      public void actionPerformed(ActionEvent e)//make the logs move + dead if not on logs
      {
        log1+=1;
        log2-=1;
        log3+=1;
        log4-=1;
        if(log1>=450)log1=200;
        if(log2<=200)log2=450;
        if(log3>=450)log3=200;
        if(log4<=200)log4=450;

        villain+=1;
        villain2-=1;
        villain3+=1;
        villain4-=1;
        if(villain>=600)villain=-150;
        if(villain2<=-150)villain2=600;
        if(villain3>=600)villain3=-150;
        if(villain4<=-150)villain4=600;

          if(x>=100 && x<=170)
          {
            if(y<=(villain+150) && y>=(villain-50))
            {
              dead=true;
              kill1=true;
              deadTimer.start();
            }
            else if(y>=log1-60 && y<=log1+140)y=log1;
            else if(y>=log1-500-60 && y<=log1-500+140)y=log1-500;
            else if(y>=log1-250-60 && y<=log1-250+140)y=log1-250;
            else if(y>=log1+250-60 && y<=log1+250+140)y=log1+250;
            else if(y>=log1+500-60 && y<=log1+500+140)y=log1+500;
            else
            {
              dead=true;
              deadTimer.start();
            }
          }
          //if(run)System.out.println(run);
          else if(x>=200 && x<=270)
          {
            if(y<=(villain2+150) && y>=(villain2-50))
            {
              dead=true;
              kill2=true;
              deadTimer.start();
            }
            else if(y>=log2-60 && y<=log2+140)y=log2;
            else if(y>=log2-500-60 && y<=log2-500+140)y=log2-500;
            else if(y>=log2-250-60 && y<=log2-250+140)y=log2-250;
            else if(y>=log2+250-60 && y<=log2+250+140)y=log2+250;
            else if(y>=log2+500-60 && y<=log2+500+140)y=log2+500;
            else
            {
              dead=true;
              deadTimer.start();
            }
          }
          else if(x>=300 && x<=370)
          {
            if(y<=(villain3+150) && y>=(villain3-50))
            {
              dead=true;
              kill3=true;
              deadTimer.start();
            }
            else if(y>=log3-60 && y<=log3+140)y=log3;
            else if(y>=log3-500-60 && y<=log3-500+140)y=log3-500;
            else if(y>=log3-250-60 && y<=log3-250+140)y=log3-250;
            else if(y>=log3+250-60 && y<=log3+250+140)y=log3+250;
            else if(y>=log3+500-60 && y<=log3+500+140)y=log3+500;
            else
            {
              dead=true;
              deadTimer.start();
            }
          }
          else if(x>=400 && x<=470)
          {
            if(y<=(villain4+150) && y>=(villain4-50))
            {
              dead=true;
              kill4=true;
              deadTimer.start();
            }
            else if(y>=log4-60 && y<=log4+140)y=log4;
            else if(y>=log4-500-60 && y<=log4-500+140)y=log4-500;
            else if(y>=log4-250-60 && y<=log4-250+140)y=log4-250;
            else if(y>=log4+250-60 && y<=log4+250+140)y=log4+250;
            else if(y>=log4+500-60 && y<=log4+500+140)y=log4+500;
            else
            {
              dead=true;
              deadTimer.start();
            }
          }
          else if(x<=90 || x>=480){}
          else 
          {
            dead=true;
            deadTimer.start();
          } 
          if(y<0 || y>600)
          {
            dead=true;
            deadTimer.start();
          }
        repaint();
      }
    }
    class Pause implements ActionListener //pausing the game
    {
      public void actionPerformed(ActionEvent e) //stop all the timers
      {
        stop=!stop;
        if(stop)
        {
          speed.stop();
          logTimer.stop();
          pause.setText("Resume");
        }
        if(!stop)
        {
          speed.start();
          logTimer.start();
          pause.setText("Pause");
        }
        repaint();
      }
    }
    public void endCreate()//create the ending panel
    {
        end.setLayout(new BorderLayout());

        JPanel south = new JPanel();
        south.setBackground(Color.BLACK);
        end.add(south, BorderLayout.SOUTH);

        Font mono= new Font("Monospaced",Font.PLAIN,50);
        Font monoSmall = new Font("Monospaced",Font.PLAIN,20);
        Font monoBold = new Font("Monospaced",Font.BOLD, 20);

        JButton mainB = new JButton("Back to main menu");
        mainB.addActionListener( mainH );
        mainB.setFont(monoSmall);
        south.add(mainB);

        JButton playB = new JButton("Play again");
        playB.addActionListener( playH );
        playB.setFont(monoSmall);
        south.add(playB);

        System.out.print(passed+"yo");
        JLabel good = new JLabel ("Good Job! Your time was "+passed);
        good.setOpaque(true);
        good.setBackground(Color.BLACK);
        good.setForeground(Color.WHITE);
        good.setFont(monoBold);
        end.add(good, BorderLayout.NORTH);

        String all = runIt();
        JTextArea whole = new JTextArea("                  Leaderboard"+all);
        whole.setFont(monoBold);
        whole.setBackground(Color.GREEN);

        end.add(whole, BorderLayout.CENTER);

        JScrollPane scrollBar = new JScrollPane(whole,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        end.add(scrollBar, BorderLayout.CENTER);
    }
    public String runIt()//reading/writing to the textfile and returning the string with all the leaderboard info
    {
        int line=0;
        int line2=0;
        int count=1;
        String timeStr = ""+min+sec;
        double time = Double.parseDouble(timeStr);
        boolean go = true;
        tryCatchRead();
        boolean hi = true;
        String all="";
        while(input.hasNext())
        {
          line++;
          String k = input.nextLine();
          int space = k.indexOf(' ');
          System.out.print(space+"space");
          String min2 = k.substring(space+1,space+3);
          String sec2 = k.substring(space+4,space+6);
          double num = Double.parseDouble(min2+sec2);
          /*System.out.println(min2+sec2);
          System.out.print(num+"num");
          System.out.print(time+"time");*/
          if(num>=time && hi)
            {
              line2=line;
              hi=false;
            //System.out.print("in");
            }
          //System.out.print("hi");
        }
        if(hi)line2=line+1;
        /*System.out.println(line+" = line");
        System.out.println(line2+" = line2");*/
        tryCatchRead();
        String[] strA = new String[line+1];
        for(int i=0; i<=line; i++)
        {
          if(i==line2-1)strA[i]=name+" "+passed;
          else strA[i]=input.nextLine();
        }
        tryCatchWrite();
        for(int i=0; i<=line; i++)
        {
          pw.println(strA[i]);
        }
        for(int i=1; i<=line+1;i++)
        {
          all=all+"\n"+i+". "+strA[i-1];
        }
        pw.close();
        input.close();
        return all;
      }
       public void tryCatchWrite()//tryCatch for overwriting the text file
      {
        File outFile=new File ("Leaderboard2.txt");
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
        File inFile=new File ("Leaderboard2.txt");
        try
        {
        inFile.createNewFile(); 
         }
      catch (Exception e)
      {
        System.err.println("Exception");
        System.exit(1);
      }
      String inFileName = "Leaderboard2.txt"; 
        String  value = ""; 
        try
        { 
          input = new Scanner ( inFile );
        }
        catch ( FileNotFoundException e ) 
        { 
          System.err.println("Cannot find " + inFileName + " file.");  
          System.exit(1);
        }
    }
  }
  }
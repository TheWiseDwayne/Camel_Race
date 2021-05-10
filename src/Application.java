import acm.graphics.GLabel;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.KeyEvent;


public class Application extends GraphicsProgram {
    public static final int WINDOW_WIDTH = 900;
    public static final int WINDOW_HEIGHT = 700;
    public static final int REFRESH = 60;
    public static final double GOAL = WINDOW_WIDTH*0.90;
    public static ArrayList <Camel> players = new ArrayList<Camel>();
    public static ArrayList <Camel> playOFF = new ArrayList<Camel>();

    // Function that assigns camels to the 'players' arrayList
    public void arrayPlayers(FastCamel fastCamel, MarathonCamel marathonCamel, OddCamel oddCamel, DrunkCamel drunkCamel ){
        players.add(fastCamel);
        players.add(marathonCamel);
        players.add(oddCamel);
        players.add(drunkCamel);
    }

    /* Function that assigns and returns in an array the difference between distances of the camels
      to be able to treat them to the function "arrayPlayers" */
    public int [] creationArrayY(){
        int arrayY[] = new int [players.size()];
        arrayY[0] = 380;
        for(int i = 1; i< players.size(); i++){
            arrayY[i]=arrayY[i-1]-100;
        }
        return arrayY;
    }

    // Function that assigns the distance of the Y axis between the camels
    public void positionY(){
        int camelsPositionY[]= creationArrayY();
        int i = 0;
        for(Camel camel: players) {
            camel.setPositionY(camel.getPositionY()+camelsPositionY[i]);
            camel.spacerAssignment();
            i++;
        }
    }

    // Function that creates and returns the GRect of the goal object
    public GRect goalCreation(){
        GRect goal = new GRect(1, players.get(players.size()-1).getSpacer().getY());
        goal.setLocation(GOAL,0);
        goal.setColor(Color.RED);
        return goal;
    }

    //Function that generates a game and adds finalists to the 'playOFF' arrayList
    public void game(){
        boolean finalists=false;
        while(!finalists) {
            for (Camel camel : players) {
                camel.roll();

               /* If any camel has reached the finish line
                 * subtract the length of the image so that the one who gets to the goal first wins
                 */
                camel.getImage().setLocation(camel.getPositionX(), WINDOW_HEIGHT - camel.getPositionY());//Moviment

                if (camel.getPositionX() >= GOAL - players.get(0).getImage().getWidth()) {
                    playOFF.add(camel);
                    finalists = true; //change the state of the variable to determine that there is already a winner
                }
            }
            pause(REFRESH);
        }
    }

    //Function that checks the camels in the 'playOFF' arrayList and returns the winning camel object
    public Camel winner(){
        Camel winner = playOFF.get(0);
        if(playOFF.size()>1){
            for(int i = 0; i< playOFF.size(); i++){
                if(winner.getPositionX()< playOFF.get(i).getPositionX()){
                    winner= playOFF.get(i);
                }
            }
        }
        return winner;
    }

    //Listener for exiting the program
    public void keyPressed(KeyEvent e){
        if(e.getKeyChar()==KeyEvent.VK_ESCAPE){
            System.exit(0);
        }
    }
    public void run(){
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        addKeyListeners();

        //Creating and assigning camels to the 'players' arrayList
        FastCamel fastCamel = new FastCamel("fastCamel");
        MarathonCamel marathonCamel = new MarathonCamel("marathonCamel");
        OddCamel oddCamel = new OddCamel("oddCamel");
        DrunkCamel drunkCamel = new DrunkCamel("drunkCamel");

        arrayPlayers(fastCamel,marathonCamel,oddCamel,drunkCamel);

        //Assignment of the relevant Y axis to each player
        positionY();

        //Insertion of camels and separators in the graphical interface
        for (Camel camel: players) {
            add(camel.getImage());
            add(camel.getSpacer());
        }

        //Creating the visual goal in the program
        add(goalCreation());

        //Game
        game();

        //Creation of the label that shows who the winner is
        String winner = "The winner is: "+ winner().getName();
        GLabel winnerLabel = new GLabel(winner,WINDOW_WIDTH/2, WINDOW_HEIGHT /2);
        add(winnerLabel);
    }
}

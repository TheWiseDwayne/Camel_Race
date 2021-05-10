import acm.graphics.GImage;
import acm.graphics.GRect;
import java.awt.*;
import java.util.Random;


public class Camel {
    public static final int IMG_WIDTH = 40;
    public static final int IMG_HEIGHT = 40;
    public static final double IMG_SCALE = 2;

    String name;
    int positionX;
    double positionY;
    boolean winner;
    GImage image;
    GRect spacer;

    //Builder
    public Camel(String name, String IMGpath) {
        this.name = name;
        this.image = new GImage(IMGpath);
        this.positionX =0;
        this.positionY = Application.WINDOW_HEIGHT*0.45;//a la meitat de la pantalla
        this.winner =false;
        this.spacer = new GRect(0,0);
        this.getImage().setSize(IMG_WIDTH,IMG_HEIGHT);
    }


    //Functions

    //Function that assigns the position of the separator to the corresponding camel
    public void spacerAssignment(){
        this.spacer = new GRect(Application.WINDOW_WIDTH,0);
        this.spacer.setColor(Color.black);

        //The current position of the object plus the height of the image
        this.spacer.setLocation(0,Application.WINDOW_HEIGHT - this.getPositionY()+this.getImage().getHeight());
    }

    //Function that assigns a random value 0-15 to the position of an object
    public void roll(){
        Random rnd = new Random();
        int dice = rnd.nextInt(15);
        this.setPositionX(this.getPositionX()+dice);
    }



    //Getter and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(GImage image) {
        this.image = image;
    }

    public GImage getImage(){ //Te devuelve la imagen para poder hacer add del objeto
        return this.image;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    public void setPositionY(double positionY) {
        this.positionY = positionY;
    }

    public boolean isWinner() {
        return winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    public GRect getSpacer() {
        return spacer;
    }

    public void setSpacer(GRect spacer) {
        this.spacer = spacer;
    }
}

import java.util.Random;

public class MarathonCamel extends Camel {
    public MarathonCamel(String name){
        super(name,"../resources/img/marathonCamel.gif");
        this.getImage().setSize(IMG_WIDTH,IMG_HEIGHT);
        this.getImage().scale(IMG_SCALE);
    }

    //Functions
    public void roll(){
        Random rnd = new Random();
        int dice = rnd.nextInt(5)+5;
        this.setPositionX(this.getPositionX()+dice);
    }
}

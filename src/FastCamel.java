import java.util.Random;

public class FastCamel extends Camel {
    //Builder
    public FastCamel(String name){
        super(name,"../resources/img/fastCamel.gif");
        this.getImage().setSize(IMG_WIDTH,IMG_HEIGHT);
        this.getImage().scale(IMG_SCALE);

    }

    //Functions
    public void roll(){
        Random rnd = new Random();
        int dice = rnd.nextInt(15);
        if(dice == 15){
            dice *= 2;
        }
        this.setPositionX(this.getPositionX()+dice);
    }
}

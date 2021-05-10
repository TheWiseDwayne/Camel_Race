import java.util.Random;

public class OddCamel extends Camel {
    //Builder
    public OddCamel(String name){
        super(name,"../resources/img/oddCamel.gif");
        this.getImage().setSize(IMG_WIDTH,IMG_HEIGHT);
        this.getImage().scale(IMG_SCALE);
    }

    //Functions
    public void roll(){
        Random rnd = new Random();
        int dice = rnd.nextInt(15);

        if(dice%2!=0){
            dice=2;
        }
        this.setPositionX(this.getPositionX()+dice);
    }
}

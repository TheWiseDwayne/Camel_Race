import java.util.Random;

public class DrunkCamel extends Camel {
    private boolean crazy;

    //Builder
    public DrunkCamel(String name){
        super(name,"../resources/img/drunkCamel.gif");
        this.getImage().setSize(IMG_WIDTH,IMG_HEIGHT);
        this.getImage().scale(IMG_SCALE);
        this.crazy = false;
    }

    //Functions
    public void roll(){
        Random rnd = new Random();
        int dice = rnd.nextInt(15);
        if(this.isCrazy()){
            this.setCrazy(false);
            this.getImage().setImage("../resources/img/drunkCamel.gif");
            this.getImage().setSize(IMG_WIDTH,IMG_HEIGHT);
            this.getImage().scale(IMG_SCALE);
            this.setPositionX(this.getPositionX()+dice);
        }else{
            this.setCrazy(true);
            this.getImage().setImage("../resources/img/drunkCamelOFF.gif");
            this.getImage().setSize(IMG_WIDTH,IMG_HEIGHT);
            this.getImage().scale(IMG_SCALE);
            this.setPositionX(this.getPositionX()-dice);
        }
    }

    //Getters and Setters
    public boolean isCrazy() {
        return crazy;
    }

    public void setCrazy(boolean crazy) {
        this.crazy = crazy;
    }

}

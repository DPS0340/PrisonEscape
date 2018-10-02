import java.util.Random;

public abstract class  Charachter{
    //Abstract class for all characters in the game.
    //Provides general properties each character should have.
    private String name;
    private Integer health;
    private Weapon weapon;
    private int accuracy;
    public Charachter(String name,Integer health,Weapon weapon,Integer accuracy){
        this.name=name;
        this.health=health;
        this.weapon=weapon;
        this.accuracy=accuracy;
    }
    @Override
    public String toString(){
        //toString function.
        return this.name;
    }
    public void setHealth(Integer h){
        //Sets character health to a desired value
        this.health=h;
    }
    public Integer getHealth(){
        //Returns the current health of the character.
        return this.health;
    }
    public void setWeapon(Weapon weapon) {
        //Sets the weapon of the character.
        this.weapon = weapon;
    }
    public Weapon getWeapon(){
        //Returns the current weapon of the character.
        return this.weapon;
    }
    public boolean doDamage(Charachter c){
        //Method that carries an attack by the character.
        Weapon weapon=this.weapon;
        Random random=new Random();
        Integer chance=random.nextInt(10);
        if(chance<accuracy){
            weapon.do_damage(c);
            return true;
        }
        else{
            return false;
        }
    }
    public Integer scoreValue(){
        //Returns the score player will get after killing current character.
        return (this.weapon.getDamage()*2)+(this.accuracy*10)+(this.getHealth());
    }
}

public abstract class Enemy extends Charachter{
    //CLass that provides a template for the enemies that the user will face in the game.
    public Enemy(String name, Integer health, Weapon weapon, Integer accuracy){
        super(name, health, weapon, accuracy);
    }
    public abstract String getDescription(); //Description that is displayed when an enemy is encountered.
    public int scoreValue(){
        //Algorithm that returns the score player will get after killing an enemy.
        //Algorithm is based on the weapon, accuracy, and health of the enemy.
        return (this.getWeapon().getDamage()*2)+(this.getAccuracy()*10)+(this.getHealth());
    }
}
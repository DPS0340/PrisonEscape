public class DrugDealer extends Enemy{
    //Class representing an Enemy in the game.
    public DrugDealer(){
        super("DrugDealer",75,new Shiv(),6);
    }
    @Override
    public String getDescription(){
        return "You encounter a drug dealer.\nDRUGDEALER:Don't mess with me.";
    }
}

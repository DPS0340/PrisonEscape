public class PsychoKiller extends Enemy {
    //Class that represents an enemy in the game.
    public PsychoKiller(){
        super("PsychoKiller",220,new Katana(),4);
    }
    @Override
    public String getDescription(){
        return "You encounter a psycho killer.\nPSYCHO KILLER:HAHAHAHAHAHAH.";
    }
}

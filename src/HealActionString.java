public class HealActionString extends ActionString{
    //Class that represents an example of an ActionString object.
    public HealActionString(){
        super("heal");
    }
    @Override
    public String actionBar(){
        return "TYPE HEAL TO USE MEDKIT";
    }
}

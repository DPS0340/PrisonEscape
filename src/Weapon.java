public abstract class Weapon {
    private String name;
    private Integer damage;
    public Weapon(String name,Integer damage){
        this.name=name;
        this.damage=damage;
    }
    @Override
    public String toString(){
        return name;
    }
    public void do_damage(Charachter victim){
        int health=victim.getHealth();
        health=health-damage;
        victim.setHealth(health);
    }
    public Integer getDamage(){return this.damage;}
}

public class Position {
    private Integer x;
    private Integer y;
    public Position(Integer x,Integer y){
        this.x=x;
        this.y=y;
    }
    @Override
    public String toString(){
        return "X:"+x.toString()+",Y:"+y.toString();
    }
    @Override
    public boolean equals(Object o){
        boolean def=false;
        if(o instanceof Position){
            Position obj=(Position)o;
            if(obj.x.equals(this.x)){
                if(obj.y.equals(this.y)){
                    def=true;
                }
            }
        }
        return def;
    }
    public Integer getX(){
        return this.x;
    }
    public Integer getY(){
        return this.y;
    }
}

import java.util.ArrayList;

public class Display {
    private ArrayList<String> textholder;
    private Integer spaces;
    private String endline;
    public Display(){
        this.textholder=new ArrayList<String>();
        this.spaces=1;
        this.endline="-------------------------------------------------------------------------------------------------";
    }
    public void addText(String text){
        textholder.add(text);
    }
    public void removeText(String text){
        textholder.remove(text);
    }
    public void popText(){
        if(!textholder.isEmpty()){
        textholder.remove(-1);}
    }
    public ArrayList<String> getText(){
        return this.textholder;
    }
    public void setSpace(Integer n){
        this.spaces=n;
    }
    public Integer getSpace(){
        return this.spaces;
    }
    public void generate(){
        String result="";
        for(String s:textholder){
            result=result+s;
            for(int i=0;i<this.spaces;i++){
                result=result+"\n";
            }

        }
        result=result+endline;
        System.out.println(result);
    }

}

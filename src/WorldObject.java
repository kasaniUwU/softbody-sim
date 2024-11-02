import bsh.EvalError;
import bsh.Interpreter;
import java.util.ArrayList;
import java.util.List;
public class WorldObject {
    private List<Object> components =new ArrayList<>();
    public WorldObject(){
        Main.worldObjects.add(this);
        addComponent("transform");
    }
    public void addComponent(String comp){
        Interpreter I = new Interpreter();
        try{
            I.eval(comp+" temp =new "+comp+"();");
            if(!(I.get("temp") instanceof component)){
                System.out.println(comp+" is not a component");
                return;
            }
            components.add(I.get("temp"));
        } catch (EvalError e) {
            System.out.println(comp+" is not a class");
            System.out.println(e.getMessage());
        }
    }
    public component getComponent(Class comp){
        for(int i=0; i<components.size(); i++){
            if(comp.isInstance(components.get(i))){
                return (component) components.get(i);
            }
        }
        return null;
    }
}
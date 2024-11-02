import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
public class Main {
    public static List<WorldObject> worldObjects =new ArrayList<>();
    public static JFrame mainFrame=new JFrame();
    public static JPanel mainPanel=new JPanel();
    public static void main(String[] args) {
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        WorldObject cube=new WorldObject();
        cube.addComponent("MeshRender");
        mesh e=new mesh("src/cube.obj");
        MeshRender temp=(MeshRender)cube.getComponent(MeshRender.class);
        temp.setMesh(e);
        //JButton ee=new JButton("hello");
        mainFrame.add(mainPanel);
        //mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //mainFrame.pack();
        mainFrame.setVisible(true);
    }
}
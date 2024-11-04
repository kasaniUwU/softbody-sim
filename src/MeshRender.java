import javax.sound.sampled.Line;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.List;
import javax.swing.JFrame;


public class MeshRender extends JComponent implements component {
    private mesh usedMesh;
    private mesh renderedMesh;
    private WorldObject parent;
    public MeshRender(WorldObject In){
        parent=In;
    }
    public void setMesh(mesh In){
        usedMesh=In;
        renderedMesh=usedMesh;
        Main.mainPanel.add(this);
    }
    public mesh getMesh(){
        return usedMesh;
    }
    //@Override
    public void update() {
        if(parent.getComponent(Physics.class)!=null){
            renderedMesh=((Physics)parent.getComponent(Physics.class)).physMesh;
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        //System.out.println("ran");
        super.paintComponent(g);
        List<Vector2> points=renderedMesh.points;
        List<List<Integer>> faces=renderedMesh.faces;
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        for (List<Integer> face : faces) {
            for (int t = 1; t < face.size(); t++) {
                //g.setColor(line.color);
                //System.out.println(t);
                Vector2 point1 = points.get(face.get(t)-1);
                Vector2 point2 = points.get(face.get(t - 1)-1);
                //System.out.println(point2.x);
                Line2D line = new Line2D.Double(point1.x+200, point1.y+200, point2.x+200, point2.y+200);
                g2d.draw(line);
            }
            //g.drawLine((int) points.get(0).x, (int) points.get(0).y, (int) points.get(usedMesh.points.size() - 1).x, (int) points.get(usedMesh.points.size() - 1).y);
        }
    }
    @Override
    public Dimension getPreferredSize() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        return new Dimension((int) width, (int) height);
    }

}

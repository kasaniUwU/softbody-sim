import javax.sound.sampled.Line;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.List;
import javax.swing.JFrame;


public class MeshRender extends JComponent implements component {
    private mesh usedMesh;
    public MeshRender(){

    }
    public void setMesh(mesh In){
        usedMesh=In;
        Main.mainPanel.add(this);
    }
    //@Override
    public void update() {
    }
    @Override
    protected void paintComponent(Graphics g) {
        //System.out.println("ran");
        super.paintComponent(g);
        List<Vector2> points=usedMesh.points;
        Graphics2D g2d = (Graphics2D) g;
        for (int i=0; i<usedMesh.points.size()-1; i++) {
            //g.setColor(line.color);
            //System.out.println("ran");
            Line2D line = new Line2D.Double(points.get(i).x,points.get(i).y,points.get(i+1).x,points.get(i+1).y);
            g2d.draw(line);
        }
        g.drawLine((int)points.get(0).x,(int)points.get(0).y,(int)points.get(usedMesh.points.size()-1).x,(int)points.get(usedMesh.points.size()-1).y);
    }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(300, 300);
    }

}

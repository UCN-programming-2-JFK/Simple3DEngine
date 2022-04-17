package jfk.simple3d.ui;
import java.awt.*;
import javax.swing.JPanel;
import jfk.simple3d.model.*;

public class RenderPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	PerspectiveProjectionMatrix projectionMatrix = new PerspectiveProjectionMatrix(90, 600/(float)800, 0.1f, 1000);
	Mesh mesh = new Mesh();
	
	public RenderPanel() {
		mesh.triangles.add(new Triangle(new Vertex(0,0,0), new Vertex(0,1,0), new Vertex(1,1,0)));
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		float halfWidth = getWidth()/2;
		float halfHeight = getHeight()/2;
		super.paintComponent(g);
		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(),  getHeight());
		g.setColor(Color.white);
		Triangle projectedTriangle = new Triangle();
		float x, y;
		for(Triangle triangle : mesh.triangles) {
			
			projectionMatrix.project(triangle, projectedTriangle);
			
			projectedTriangle.vertices[0].values[0]+=1;
			projectedTriangle.vertices[0].values[1]+=1;
			projectedTriangle.vertices[1].values[0]+=1;
			projectedTriangle.vertices[1].values[1]+=1;
			projectedTriangle.vertices[2].values[0]+=1;
			projectedTriangle.vertices[2].values[1]+=1;
			
			projectedTriangle.vertices[0].values[0]*=halfWidth;
			projectedTriangle.vertices[0].values[1]*=halfHeight;
			projectedTriangle.vertices[1].values[0]*=halfWidth; 
			projectedTriangle.vertices[1].values[1]*=halfHeight;
			projectedTriangle.vertices[2].values[0]*=halfWidth; 
			projectedTriangle.vertices[2].values[1]*=halfHeight;
						
			g.drawLine((int)projectedTriangle.vertices[0].getX(), (int)projectedTriangle.vertices[0].getY(), 
						(int)projectedTriangle.vertices[1].getX(), (int)projectedTriangle.vertices[1].getY());
			g.drawLine((int)projectedTriangle.vertices[1].getX(), (int)projectedTriangle.vertices[1].getY(), 
					(int)projectedTriangle.vertices[2].getX(), (int)projectedTriangle.vertices[2].getY());
			g.drawLine((int)projectedTriangle.vertices[2].getX(), (int)projectedTriangle.vertices[2].getY(), 
					(int)projectedTriangle.vertices[0].getX(), (int)projectedTriangle.vertices[0].getY());
			
		}
	}
}
package jfk.simple3d.ui;
import java.awt.*;
import javax.swing.JPanel;
import jfk.simple3d.model.*;

public class RenderPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	PerspectiveProjectionMatrix projectionMatrix = new PerspectiveProjectionMatrix(90, 600/800, 0.1f, 1000);
	Mesh mesh = new Mesh();
	
	public RenderPanel() {
		mesh.triangles.add(new Triangle(new Vertex(0,0,0), new Vertex(0,1,0), new Vertex(1,1,0)));
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(),  getHeight());
		g.setColor(Color.white);
		for(Triangle triangle : mesh.triangles) {
			Triangle projectedTriangle = new Triangle();
			
			//projectedTriangle.vertices[0] = projectionMatrix.
			for(int vertexCounter = 0; vertexCounter < 2; vertexCounter++) {
				g.drawLine((int)triangle.vertices[vertexCounter].getX(), (int)triangle.vertices[vertexCounter].getY(), 
						(int)triangle.vertices[vertexCounter+1].getX(), (int)triangle.vertices[vertexCounter+1].getY());
			}
		}
	}
}
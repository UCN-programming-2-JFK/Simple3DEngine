package uitester;

import java.awt.*;
import javax.swing.*;
import jfk.simple3d.model.*;
import jfk.simple3d.ui.RenderPanel;

public class RenderFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		RenderPanel panel = new RenderPanel();
		panel.setPreferredSize(new Dimension(800,600));
		RenderFrame window = new RenderFrame();
		
		window = new RenderFrame();
		window.setTitle("3D visualizer");
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		window.getContentPane().add(panel);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
}
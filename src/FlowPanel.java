import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.image.*;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class FlowPanel extends JPanel implements Runnable {
	Terrain land;
	
	FlowPanel(Terrain terrain) {
		land=terrain;
	}
		
	// responsible for painting the terrain and water
	// as images
	@Override
    protected void paintComponent(Graphics g) {			//this g is responsible for hanging the image on the JPanel
		int width = getWidth();
		int height = getHeight();
		  
		super.paintComponent(g);
		
		// draw the landscape in greyscale as an image
		if (land.getImage() != null){
			g.drawImage(land.getImage(), 0, 0, null);
			g.drawImage(land.waterImage, 0, 0, null);
		}
		/*addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				g.drawImage(land.getImage(), 0, 0, null);
			}
		});*/
	}
	
	public void run() {	
		// display loop here
		// to do: this should be controlled by the GUI
		// to allow stopping and starting
	    repaint();
	}
}

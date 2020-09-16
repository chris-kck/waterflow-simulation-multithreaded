import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.image.*;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.util.*;

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
	public int[] checkNeighbors(int x, int y){
		int [] lowest = new int[2];
		float minimum;
		ArrayList<Float> heights= new ArrayList<Float>();
		heights.add(land.getGrid()[x-1][y-1].getWaterSurface());
		heights.add(land.getGrid()[x][y-1].getWaterSurface());
		heights.add(land.getGrid()[x+1][y-1].getWaterSurface());
		heights.add(land.getGrid()[x-1][y].getWaterSurface());
		heights.add(land.getGrid()[x+1][y].getWaterSurface());
		heights.add(land.getGrid()[x-1][y+1].getWaterSurface());
		heights.add(land.getGrid()[x][y+1].getWaterSurface());
		heights.add(land.getGrid()[x+1][y+1].getWaterSurface());
		
		minimum = Collections.min(heights);
		//System.out.println("Minimum is: " + minimum);

		for(int i = x-1; i <= x+1; i++){
			for(int j = y-1; j <= y+1; j++){
				if(land.getGrid()[i][j].getWaterSurface() == minimum){
					lowest[0] = i;
					lowest[1] = j;
				}
			}
		}
		return lowest;
	}
	public void transfer(int x, int y, int transferToX, int transferToY){
		//System.out.println("Haha");
		float subtracted = land.getGrid()[x][y].getWaterSurface() - 0.01f;
		float added = land.getGrid()[transferToX][transferToY].getWaterSurface() + 0.01f;
		//subtract 1 water unit from the center point
		//land.getGrid()[x][y].setWaterSurface(subtracted);
		if(land.getGrid()[x][y].getWaterDepth() > 0)
		{
			land.getGrid()[x][y].setWaterDepth(land.getGrid()[x][y].getWaterDepth() - 1);
		}
		else
		{
			land.getGrid()[x][y].setWaterDepth(0);
		}
		//add 1 water unit to the target point
		//land.getGrid()[transferToX][transferToY].setWaterSurface(added);
		land.getGrid()[transferToX][transferToY].setWaterDepth(1);

		Color waterColor = new Color(106,195,255,150);
		Color transparent = new Color(106,195,255,0);

		land.getWaterImage().setRGB(x,y,transparent.getRGB());
		land.getWaterImage().setRGB(transferToX,transferToY,waterColor.getRGB());
		repaint();


	}
	
	public void run() {	
		// display loop here
		// to do: this should be controlled by the GUI
		// to allow stopping and starting
		for(int i = 0; i < land.dim();i++)
		{
			int[] position = new int[2];
			int [] location = land.getPermute(i,position);
			int x = location[0];
			int y = location[1];
			int lowestPointX;
			int lowestPointY;
			//System.out.println("Random Location is " + location[0] + " " + location[1]);
			if(land.getGrid()[x][y].getWaterDepth() != 0){
				int [] lowestPoint = checkNeighbors(x,y);
				lowestPointX = lowestPoint[0];
				lowestPointY = lowestPoint[1];

				if(land.getGrid()[x][y].getWaterSurface() > land.getGrid()[lowestPointX][lowestPointY].getWaterSurface()){
					transfer(x,y,lowestPointX,lowestPointY);//this will do both graphical and mathematical transfers
				}
			}

		}
	    repaint();
	    while(true){run();}
	}
}

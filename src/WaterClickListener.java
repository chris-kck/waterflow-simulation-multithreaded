import java.util.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.*;

public class WaterClickListener extends MouseAdapter {
	
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println(e.getX() + "," + e.getY() + " has a height of " + Terrain.getGrid()[e.getX()][e.getY()].getHeight() );
		//System.out.println(Terrain.height[e.getX()][e.getY()].getHeight());
		//System.out.println(Terrain.getGrid(e.getX(),e.getY()).getHeight());
		System.out.println(Terrain.getGrid()[e.getX()][e.getY()].getHeight());

		Terrain.getGrid()[e.getX()][e.getY()].setWaterDepth(3);
		System.out.println(Terrain.getGrid()[e.getX()][e.getY()].getWaterSurface());

		//addWater(getX(), getY());
		Color waterColor = new Color(106,195,255);

		Flow.fp.land.getImage().setRGB(e.getX(), e.getY(), waterColor.getRGB());
		Flow.fp.repaint();
		//Terrain.getImage().setRGB(getX(),getY(),255);
		//Terrain.waterImage.setBackground();
	}
	public void addWater(int x, int y) {
		System.out.println("lol");


		//set row 1 water depth
		Terrain.getGrid()[x-3][y-3].setWaterDepth(3);
		Terrain.getGrid()[x-2][y-3].setWaterDepth(3);
		Terrain.getGrid()[x-1][y-3].setWaterDepth(3);
		Terrain.getGrid()[x][y-3].setWaterDepth(3);
		Terrain.getGrid()[x+1][y-3].setWaterDepth(3);
		Terrain.getGrid()[x+2][y-3].setWaterDepth(3);
		Terrain.getGrid()[x+3][y-3].setWaterDepth(3);

		//set row 2 water depth
		Terrain.getGrid()[x-3][y-2].setWaterDepth(3);
		Terrain.getGrid()[x-2][y-2].setWaterDepth(3);
		Terrain.getGrid()[x-1][y-2].setWaterDepth(3);
		Terrain.getGrid()[x][y-2].setWaterDepth(3);
		Terrain.getGrid()[x+1][y-2].setWaterDepth(3);
		Terrain.getGrid()[x+2][y-2].setWaterDepth(3);
		Terrain.getGrid()[x+3][y-2].setWaterDepth(3);

		//set row 3 water depth
		Terrain.getGrid()[x-3][y-1].setWaterDepth(3);
		Terrain.getGrid()[x-2][y-1].setWaterDepth(3);
		Terrain.getGrid()[x-1][y-1].setWaterDepth(3);
		Terrain.getGrid()[x][y-1].setWaterDepth(3);
		Terrain.getGrid()[x+1][y-1].setWaterDepth(3);
		Terrain.getGrid()[x+2][y-1].setWaterDepth(3);
		Terrain.getGrid()[x+3][y-1].setWaterDepth(3);

		//set row 4 water depth
		Terrain.getGrid()[x-3][y].setWaterDepth(3);
		Terrain.getGrid()[x-2][y].setWaterDepth(3);
		Terrain.getGrid()[x-1][y].setWaterDepth(3);
		Terrain.getGrid()[x][y].setWaterDepth(3);
		Terrain.getGrid()[x+1][y].setWaterDepth(3);
		Terrain.getGrid()[x+2][y].setWaterDepth(3);
		Terrain.getGrid()[x+3][y].setWaterDepth(3);

		//set row 5 water depth
		Terrain.getGrid()[x-3][y+1].setWaterDepth(3);
		Terrain.getGrid()[x-2][y+1].setWaterDepth(3);
		Terrain.getGrid()[x-1][y+1].setWaterDepth(3);
		Terrain.getGrid()[x][y+1].setWaterDepth(3);
		Terrain.getGrid()[x+1][y+1].setWaterDepth(3);
		Terrain.getGrid()[x+2][y+1].setWaterDepth(3);
		Terrain.getGrid()[x+3][y+1].setWaterDepth(3);

		//set row 6 water depth
		Terrain.getGrid()[x-3][y+2].setWaterDepth(3);
		Terrain.getGrid()[x-2][y+2].setWaterDepth(3);
		Terrain.getGrid()[x-1][y+2].setWaterDepth(3);
		Terrain.getGrid()[x][y+2].setWaterDepth(3);
		Terrain.getGrid()[x+1][y+2].setWaterDepth(3);
		Terrain.getGrid()[x+2][y+2].setWaterDepth(3);
		Terrain.getGrid()[x+3][y+2].setWaterDepth(3);

		//set row 7 water depth
		Terrain.getGrid()[x-3][y+3].setWaterDepth(3);
		Terrain.getGrid()[x-2][y+3].setWaterDepth(3);
		Terrain.getGrid()[x-1][y+3].setWaterDepth(3);
		Terrain.getGrid()[x][y+3].setWaterDepth(3);
		Terrain.getGrid()[x+1][y+3].setWaterDepth(3);
		Terrain.getGrid()[x+2][y+3].setWaterDepth(3);
		Terrain.getGrid()[x+3][y+3].setWaterDepth(3);

	}
}

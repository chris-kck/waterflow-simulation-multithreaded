import java.util.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.*;

public class WaterClickListener extends MouseAdapter {
	
	@Override
	public void mouseClicked(MouseEvent e) {
		//System.out.println(e.getX() + "," + e.getY() + " has a height of " + Terrain.getGrid()[e.getX()][e.getY()].getHeight() );

		//System.out.println(e.getX() + "," + e.getY() + " has a water surface of " + Terrain.getGrid()[e.getX()][e.getY()].getWaterSurface());
		//Terrain.getGrid()[e.getX()][e.getY()].setWaterDepth(3);
		//System.out.println(Terrain.getGrid()[e.getX()][e.getY()].getWaterSurface());
		addWater(e.getX(), e.getY());
		//Color waterColor = new Color(106,195,255,150);
		Color waterColor = new Color(21,6,189,150);
		addWaterOnScreen(e.getX(),e.getY(), waterColor);

		//System.out.println(e.getX() + "," + e.getY() + " has a new height of " + Terrain.getGrid()[e.getX()][e.getY()].getHeight() );

		//System.out.println(e.getX() + "," + e.getY() + " has a new water surface of " + Terrain.getGrid()[e.getX()][e.getY()].getWaterSurface());



	}
	public void addWaterOnScreen(int x, int y, Color waterColor){
		for(int i = x - 3; i <= x + 3; i++){
			for(int j = y - 3; j <= y + 3;j++){
				Flow.fp.land.getWaterImage().setRGB(i,j,waterColor.getRGB());
			}
		}
		Flow.fp.repaint();
	}
	public void addWater(int x, int y) {
		//System.out.println("lol");


		for(int i = x - 3; i <= x + 3; i++){
			for(int j = y - 3; j <= y + 3;j++){
				Terrain.getGrid()[i][j].setWaterDepth(3);
			}
		}
	}
}

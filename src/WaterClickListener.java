import java.util.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.*;

public class WaterClickListener extends MouseAdapter {
	
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println(e.getX() + "," + e.getY() + " has a height of " + Terrain.getGrid()[e.getX()][e.getY()].getHeight() );

		//Terrain.getGrid()[e.getX()][e.getY()].setWaterDepth(3);
		//System.out.println(Terrain.getGrid()[e.getX()][e.getY()].getWaterSurface());
		for(int i = e.getX() - 3; i <= e.getX() + 3; i++){
			for(int j = e.getY() -3; j <= e.getY() + 3;j++){
				System.out.println("Coordinates : " + i + "," + j +" WaterDepth Before: " + Terrain.getGrid()[i][j].getWaterDepth()
						+ "\n WaterSurface Before: " + Terrain.getGrid()[i][j].getHeight());
			}
		}
		addWater(e.getX(), e.getY());
		Color waterColor = new Color(106,195,255,150);
		addWaterOnScreen(e.getX(),e.getY(), waterColor);
		for(int i = e.getX() - 3; i <= e.getX() + 3; i++)
		{
			for(int j = e.getY() -3; j <= e.getY() + 3;j++)
			{
				System.out.println("Coordinates : " + i + "," + j +" WaterDepth After: " + Terrain.getGrid()[i][j].getWaterDepth()
                                                + "\n WaterSurface After: " + Terrain.getGrid()[i][j].getWaterSurface());
			}
		}

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
		System.out.println("lol");


		for(int i = x - 3; i <= x + 3; i++){
			for(int j = y - 3; j <= y + 3;j++){
				Terrain.getGrid()[i][j].setWaterDepth(3);
			}
		}
	}
}

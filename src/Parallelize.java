import java.util.concurrent.atomic.*;
import java.awt.Color;
import java.util.*;
public class Parallelize extends java.lang.Thread
{
	volatile int start;
	volatile int finish;
	boolean running;
	volatile boolean loop = true;


	Parallelize(int start, int finish){
		this.start = start;
		this.finish = finish;
	}
	synchronized int[] checkNeighbors(int x, int y){
                int [] lowest = new int[2];
                //AtomicIntegerArray lowest = new AtomicIntegerArray(2);
                float minimum;
                ArrayList<Float> heights= new ArrayList<Float>();
                heights.add(Flow.fp.land.getGrid()[x-1][y-1].getWaterSurface());
                heights.add(Flow.fp.land.getGrid()[x][y-1].getWaterSurface());
                heights.add(Flow.fp.land.getGrid()[x+1][y-1].getWaterSurface());
                heights.add(Flow.fp.land.getGrid()[x-1][y].getWaterSurface());
                heights.add(Flow.fp.land.getGrid()[x+1][y].getWaterSurface());
                heights.add(Flow.fp.land.getGrid()[x-1][y+1].getWaterSurface());
                heights.add(Flow.fp.land.getGrid()[x][y+1].getWaterSurface());
                heights.add(Flow.fp.land.getGrid()[x+1][y+1].getWaterSurface());

                minimum = Collections.min(heights);
                //System.out.println("Minimum is: " + minimum);

                for(int i = x-1; i <= x+1; i++){
                        for(int j = y-1; j <= y+1; j++){
                                if(Flow.fp.land.getGrid()[i][j].getWaterSurface() == minimum){
                                        lowest[0] = i;
                                        lowest[1] = j;
                                        //lowest.set(0,i);
                                        //lowest.set(1,j);
                                }
                        }
                }
                return lowest;
        }
	synchronized void transfer(int x, int y, int transferToX, int transferToY){
                //System.out.println("Haha");
                float subtracted = Flow.fp.land.getGrid()[x][y].getWaterSurface() - 0.01f;
                float added = Flow.fp.land.getGrid()[transferToX][transferToY].getWaterSurface() + 0.01f;
                //subtract 1 water unit from the center point
                //land.getGrid()[x][y].setWaterSurface(subtracted);
                //land.getGrid()[x][y].setWaterDepth(land.getGrid()[x][y].getWaterDepth() - 1);
                if(Flow.fp.land.getGrid()[x][y].getWaterDepth() > 0)
                {
                        Flow.fp.land.getGrid()[x][y].setWaterDepth(Flow.fp.land.getGrid()[x][y].getWaterDepth() - 1);
                }
                else
                {
                        Flow.fp.land.getGrid()[x][y].setWaterDepth(0);
                }
                //add 1 water unit to the target point
                //land.getGrid()[transferToX][transferToY].setWaterSurface(added);
                Flow.fp.land.getGrid()[transferToX][transferToY].setWaterDepth(1);

                Color waterColor = new Color(21,6,189);
                Color transparent = new Color(200,195,255,0);

                Flow.fp.land.getWaterImage().setRGB(x,y,transparent.getRGB());
                Flow.fp.land.getWaterImage().setRGB(transferToX,transferToY,waterColor.getRGB());

                Flow.fp.repaint();


        }

	public void run(){
		//System.out.println("Checking run " + start + " " + Thread.currentThread().getName());
		while(loop){
			if(running){
				for(int i = start; i < finish; i++ ){
					synchronized(this){
					int lowestPointX;
					int lowestPointY;
					//AtomicInteger lowestPointX = new AtomicInteger();
					//AtomicInteger lowestPointY = new AtomicInteger();
					int [] position = new int[2];
					//AtomicIntegerArray position = new AtomicIntegerArray(2);
					int location[] = Flow.fp.land.getPermute(i, position);
					int x = location[0];
					int y = location[1];
					//AtomicInteger x = new AtomicInteger(location[0]);
					//AtomicInteger y = new AtomicInteger(location[1]);

					if(Flow.fp.land.getGrid()[x][y].getWaterDepth() != 0){
						int [] lowestPoint = checkNeighbors(x,y);
						lowestPointX = lowestPoint[0];
						lowestPointY = lowestPoint[1];
						//lowestPointX.set(lowestPoint.get(0));
						//lowestPointY.set(lowestPoint.get(1));
						if((Flow.fp.land.getGrid()[x][y].getWaterSurface() > Flow.fp.land.getGrid()[lowestPointX][lowestPointY].getWaterSurface()) && ((x | y) != 0) && (x|y) != Flow.fp.land.dim()){
							transfer(x,y,lowestPointX,lowestPointY);
						}
					}
				}}
			}
			//System.out.print("");
			try{
				join();
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		
	}
	synchronized void pause(){
		running = false;
		/*try
		{
			Thread.currentThread().wait(1000);
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}*/
	}
	synchronized void play(){
		running = true;
	}
}

public class Parallelize extends FlowPanel
{
	int start;
	int finish;
	boolean running;
	volatile boolean loop = true;


	Parallelize(int start, int finish){
		this.start = start;
		this.finish = finish;
	}
	public void thang()
	{
		//System.out.println("Start " + start + " finish " + finish );
		//suspend();
		System.out.println("Have access to land --> " + Flow.fp.land.dim());
	}
	public void run(){
		//System.out.println("Checking run " + start + " " + Thread.currentThread().getName());
		while(loop){
			if(running){
				for(int i = start; i < finish; i++ ){
					int lowestPointX;
					int lowestPointY;
					int [] position = new int[2];
					int location[] = Flow.fp.land.getPermute(i, position);
					int x = location[0];
					int y = location[1];
					if(Flow.fp.land.getGrid()[x][y].getWaterDepth() != 0){
						int[] lowestPoint = super.checkNeighbors(x,y);
						lowestPointX = lowestPoint[0];
						lowestPointY = lowestPoint[1];

						if(Flow.fp.land.getGrid()[x][y].getWaterSurface() > Flow.fp.land.getGrid()[lowestPointX][lowestPointY].getWaterSurface()){
							super.transfer(x,y,lowestPointX,lowestPointY);
						}
					}
				}
			}
			//System.out.print("");
		}
		
	}
	void suspend(){
		running = false;
		/*try
		{
			Thread.currentThread().wait(1000);
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}*/
	}
	void resume(){
		running = true;
	}
}

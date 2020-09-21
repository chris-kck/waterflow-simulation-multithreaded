public class Parallelize extends FlowPanel
{
	int start;
	int finish;

	Parallelize(int start, int finish){
		this.start = start;
		this.finish = finish;
	}
	public void thang()
	{
		System.out.println("Start " + start + " finish " + finish );
		suspend();
	}
	public void run(){
		System.out.println("Checking run " + start + " " + Thread.currentThread().getName());
		
	}
}

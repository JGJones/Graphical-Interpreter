public class LineLength extends GraphicsScreen{
	
	private int total, runningtotal, curX = 0, curY = 0;

	@Override //this override the GraphicsScreen
	
	public void moveTo(int x, int y)
	{
		super.moveTo(x, y);
		curX = x;
		curY = y;
	}
	
	public void lineTo(int x, int y)
	{
		super.lineTo(x, y); // return to super class to continue with lineTo
		
		// use Pythagorean's theorem to calculate line length between x,y to new x,y
		
		double newX = (double) x, newY = (double) y;
		
		double dCurX = (double) curX, dCurY = (double) curY;
		
		double a = (dCurX - newX), b = (dCurY - newY);
		
		double c = Math.sqrt((a*a) + (b*b));
		
		runningtotal = (int) Math.round(c) + runningtotal;
		
		curX = x;
		curY = y;
		
		super.text(runningtotal); // call to superclass to draw text of total
		
		
	}
	
	public void fillRect(int width, int height)
	{ // calculate the perimeter of the rectangle
		super.fillRect(width, height);
		
		total = (width<<1) + (height<<1); // <<1 is same as *2 but is more effective
		runningtotal = runningtotal + total;
		
		super.text(runningtotal);
		
		
	}
	
	public void Rect(int width, int height)
	{
		super.Rect(width, height);
		
		total = (width<<1) + (height<<1);
		runningtotal = runningtotal + total;
		
		super.text(runningtotal);
		
		
	}
	
	public void fillCircle(int radius)
	{ // calculate the circumference of a circle
		
		super.fillCircle(radius);
		
		int x = (radius<<1);
		double dia = (double)x;
		
		double cir = Math.PI * dia;
		
		runningtotal = (int) Math.round(cir) + runningtotal;
		
		super.text(runningtotal);
	}
	
	public void circle(int radius)
	{
		super.circle(radius);
		
		int x = (radius<<1);
		double dia = (double)x;
		
		double cir = Math.PI * dia;
		
		runningtotal = (int) Math.round(cir) + runningtotal;
		
		super.text(runningtotal);
	}
	
	public void clear() 
	{
		total = 0;
		runningtotal = 0;
		curX = 0;
		curY = 0;
		super.clear();
		super.text(runningtotal);
	}

}

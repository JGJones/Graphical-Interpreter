public class LineLength extends GraphicsScreen{

	private int total, runningtotal, curX = 0, curY = 0, r, g, b;

	//LengthText text = this.new LengthText();

	private void Output(int n)
	{
		// updates the line length number, using protected int variables from superclass
		super.moveTo(0, 0);
		super.penColour(grey, grey, grey);
		super.fillRect(numWidth, numHeight);
		super.penColour(0, 0, 0);
		super.text(n, numX, numY);

		// Now to reset pencolour and current x,y back to original position!
		super.penColour(r, g, b);
		super.moveTo(curX, curY);
	}


	@Override //this override the GraphicsScreen
	public void penColour(int red, int green, int blue)
	{
		// update rgb values so can reset after doing line length update
		super.penColour(red, green, blue);
		r = red;
		g = green;
		b = blue;
	}

	@Override
	public void moveTo(int x, int y)
	{
		// update curX and curY for current x,y position
		super.moveTo(x, y);
		curX = x;
		curY = y;
	}

	@Override
	public void lineTo(int x, int y)
	{
		super.lineTo(x, y); // return to super class to continue with lineTo

		// use Pythagorean's theorem to calculate line length between x,y to new x,y

		double newX = (double) x, newY = (double) y;

		double dCurX = (double) curX, dCurY = (double) curY;

		double a = (dCurX - newX), b = (dCurY - newY);

		double c = Math.sqrt((a*a) + (b*b));
		
		//because of the use of double, we want to round it to nearest whole number and then convert to integer
		runningtotal = (int) Math.round(c) + runningtotal;

		curX = x;
		curY = y;

		Output(runningtotal);
	}

	@Override
	public void fillRect(int width, int height)
	{ // calculate the perimeter of the rectangle
		super.fillRect(width, height);

		total = (width<<1) + (height<<1); // <<1 is same as *2 but is more effective
		runningtotal = runningtotal + total;

		Output(runningtotal);
	}

	@Override
	public void Rect(int width, int height)
	{
		super.Rect(width, height);

		total = (width<<1) + (height<<1);
		runningtotal = runningtotal + total;

		Output(runningtotal);		

	}

	@Override
	public void fillCircle(int radius)
	{ // calculate the circumference of a circle
		// simply just diameter * Pi

		super.fillCircle(radius);

		int x = (radius<<1);
		double dia = (double)x;

		double cir = Math.PI * dia;

		runningtotal = (int) Math.round(cir) + runningtotal;

		Output(runningtotal);
	}

	@Override
	public void circle(int radius)
	{
		super.circle(radius);

		int x = (radius<<1);
		double dia = (double)x;

		double cir = Math.PI * dia;

		runningtotal = (int) Math.round(cir) + runningtotal;

		Output(runningtotal);	
	}

	@Override
	public void clear() 
	{
		// reset line length to zero
		runningtotal = 0;
		curX = 0;
		curY = 0;
		super.clear();
		Output(runningtotal);
	}

}

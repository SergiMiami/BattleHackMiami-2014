import java.awt.*;

import javax.swing.JComponent;

public class BHRectangle extends Rectangle implements BHShape
{
	Color color;
	int width;
	int height;
	int x;
	int y;

	public BHRectangle()
	{

	}
	/**
	public BHRectangle(Color color)
	{
		this.color = color;
	}
	
	public BHRectangle(int width, int height)
	{
		super(width, height);
		this.width = width;
		this.height = height;
	}
	 **/
	public BHRectangle(int x, int y, int width, int height, Color color)
	{
		super(width, height);
		this.color = color;
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
	}

	public Color getColor()
	{
		return color;
	}

	public void paintComponent(Graphics g)
	{
		if(color != null && width != 0 && height != 0)
		{
			Graphics2D g2 = (Graphics2D) g;
			g2.setColor(color);

			g2.draw(this);

			g2.fill(this);	
		}
	}

}

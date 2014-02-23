import java.awt.*;

import javax.swing.JComponent;

import java.awt.geom.Ellipse2D;

public class Circle extends Ellipse2D.Double implements BHShape
{
	Color color;
	double x;
	double y;
	double w;
	double h;

	public Circle()
	{

	}

	/**
	public Circle(Color color)
	{
		this.color = color;
	}

	public Circle(double x, double y, double w, double h)
	{
		super(x,y,w,h);
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	 **/
	public Circle(double x, double y, double w, double h, Color color)
	{
		super(x,y,w,h);
		this.color = color;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}

	public Color getColor()
	{
		return color;
	}

	public void paintComponent(Graphics g)
	{
		if(color != null)
		{
			Graphics2D g2 = (Graphics2D) g;
			g2.setColor(color);

			g2.draw(this);

			g2.fill(this);
		}
	}

}
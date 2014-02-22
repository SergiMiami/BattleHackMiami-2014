import java.awt.*;

import javax.swing.JComponent;

import java.awt.geom.Ellipse2D;

public class Circle extends Ellipse2D.Double implements BHShape
{
	Color color;
	
	public Circle(double x, double y, double w, double h, Color color)
	{
		super(x,y,w,h);
		this.color = color;
	}
	
	public Color getColor()
	{
		return color;
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(color);
		
		g2.draw(this);
		
		g2.fill(this);	
	}

}
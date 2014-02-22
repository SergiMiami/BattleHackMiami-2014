import java.awt.geom.*;
import java.awt.*;
import javax.swing.JComponent;

public class Triangle extends JComponent implements BHShape
{
	Point2D top;
	Line2D[] sides = new Line2D[3];
	Color color;
	Polygon p;
	
	public Triangle(int x1, int y1, Color color)
	{
		
		top = new Point2D.Double(x1, y1);
		Point2D.Double bottomLeft = new Point2D.Double(top.getX()-20, top.getY()+20);
		Point2D.Double bottomRight = new Point2D.Double(top.getX()+20, top.getY()+20);
		
		Line2D.Double side1 = new Line2D.Double(top, bottomRight);
		Line2D.Double side2 = new Line2D.Double(bottomRight, bottomLeft);
		Line2D.Double side3 = new Line2D.Double(bottomLeft, top);
		
		sides[0] = side1;
		sides[1] = side2;
		sides[2] = side3;
		
		this.color = color;
		
		int x[] = {(int)top.getX(), (int)bottomLeft.getX(), (int)bottomRight.getX()};
		int y[] = {(int)top.getY(), (int)bottomLeft.getY(), (int)bottomRight.getY()};
				
		p = new Polygon(x, y, 3);
	}

	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(color);
		
		for(int i = 0; i<sides.length; i++)
		{
			g2.draw(sides[i]);
		}
		
		g2.fill(p);	
	}


	public Line2D getSide1( )  
	{
		return sides[0];
	}

	public Line2D getSide2( )  
	{
		return sides[1];
	}

	public Line2D getSide3( )  
	{
		return sides[2];
	}
	
	public Color getColor()
	{
		return color;
	}

}

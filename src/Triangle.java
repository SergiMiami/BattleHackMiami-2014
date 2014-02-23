import java.awt.geom.*;
import java.awt.*;
import javax.swing.JComponent;

public class Triangle extends JComponent implements BHShape
{
	Point2D top;
	Line2D[] sides = new Line2D[3];
	Point2D[] points = new Point2D[3];
	Color color;
	Polygon p;
	int width = 10;
	
	
	public Triangle()
	{
		
	}
	/**
	public Triangle(Color color)
	{
		this.color = color;
	}
	
	public Triangle(int x1, int y1)
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
		
		int x[] = {(int)top.getX(), (int)bottomLeft.getX(), (int)bottomRight.getX()};
		int y[] = {(int)top.getY(), (int)bottomLeft.getY(), (int)bottomRight.getY()};
				
		p = new Polygon(x, y, 3);
	}**/
	
	public Triangle(int x1, int y1, Color color)
	{
		
		top = new Point2D.Double(x1, y1);
		Point2D.Double bottomLeft = new Point2D.Double(top.getX()-width/2, top.getY()+width/2*Math.tan(Math.PI/3));
		Point2D.Double bottomRight = new Point2D.Double(top.getX()+width/2, top.getY()+width/2*Math.tan(Math.PI/3));
		
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
		
		points[0] = top;
		points[1] = bottomLeft;
		points[2] = bottomRight;
	}

	public void paintComponent(Graphics g)
	{
		if(color != null)
		{
			Graphics2D g2 = (Graphics2D) g;
			g2.setColor(color);

			for(int i = 0; i<sides.length; i++)
			{
				g2.draw(sides[i]);
			}

			g2.fill(p);	
		}
	}
	
	public void increaseWidth(int newWidth)
	{
		width += newWidth;
		points[1] = new Point2D.Double(top.getX()-width/2, top.getY()+width/2*Math.tan(Math.PI/3));
		points[2] = new Point2D.Double(top.getX()+width/2, top.getY()+width/2*Math.tan(Math.PI/3));
		
		sides[0] = new Line2D.Double(top, points[2]);
		sides[1] = new Line2D.Double(points[2], points[1]);
		sides[2] = new Line2D.Double(points[1], top);
		
		int x[] = {(int)top.getX(), (int)points[1].getX(), (int)points[2].getX()};
		int y[] = {(int)top.getY(), (int)points[1].getY(), (int)points[2].getY()};
		
		p = new Polygon(x, y, 3);		
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

import java.awt.Rectangle;
import java.awt.*;
import javax.swing.JComponent;

public class BHRectangle extends Rectangle
{
	Color color;
	
	public BHRectangle(int width, int height, Color color)
	{
		super(width, height);
		this.color = color;
	}
	
	public Color getColor()
	{
		return color;
	}
}

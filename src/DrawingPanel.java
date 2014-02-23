import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class DrawingPanel extends JPanel {
	private JPanel mousepanel;
	private JButton red;
	private JButton yellow;
	private JButton blue;
	private JButton triangleButton;
	private JButton squareButton;
	private JButton circleButton;
	private BHShape shape;
	private Color color;
	private double x1;
	private double x2;
	
	
	public DrawingPanel(){
		
		x1 = x2 = 0;
		
		mousepanel = new JPanel();
		mousepanel.setBackground(Color.WHITE);
		add(mousepanel, BorderLayout.CENTER);
		
		Handlerclass handler = new Handlerclass();
		mousepanel.addMouseListener(handler);
		mousepanel.addMouseMotionListener(handler);
		
		Icon redIcon = new ImageIcon(getClass().getResource("Red.png"));
		Icon blueIcon = new ImageIcon(getClass().getResource("Blue.png"));
		Icon yellowIcon =new ImageIcon(getClass().getResource("Yellow.png"));
		Icon triangleIcon = new ImageIcon(getClass().getResource("Triangle.png"));
		Icon squareIcon = new ImageIcon(getClass().getResource("Square.png"));
		Icon circleIcon = new ImageIcon(getClass().getResource("Circle.png"));
		
		red = new JButton(redIcon);
		blue = new JButton(blueIcon);
		yellow = new JButton(yellowIcon);
		triangleButton = new JButton(triangleIcon);
		squareButton = new JButton(squareIcon);
		circleButton = new JButton(circleIcon);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
		
		buttonPanel.add(red);
		buttonPanel.add(blue);
		buttonPanel.add(yellow);
		buttonPanel.add(triangleButton);
		buttonPanel.add(squareButton);
		buttonPanel.add(circleButton);
		
		add(buttonPanel, BorderLayout.WEST);
		
		ActionClass action = new ActionClass();
		red.addActionListener(action);
		blue.addActionListener(action);
		yellow.addActionListener(action);
		triangleButton.addActionListener(action);
		squareButton.addActionListener(action);
		circleButton.addActionListener(action);
				
		
	}
	
	private class Handlerclass implements MouseListener, MouseMotionListener{

		@Override
		public void mouseDragged(MouseEvent event) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseMoved(MouseEvent event) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseClicked(MouseEvent event) {
			// TODO Auto-generated method stub
			if(shape instanceof Circle)
				shape = new Circle(event.getX(), event.getY(), 10, 10, color);
			
			else if(shape instanceof BHRectangle)
				shape = new BHRectangle(event.getX(), event.getY(), 10, 10, color);
			
			else if(shape instanceof Triangle)
				shape = new Triangle(event.getX(), event.getY(), color);
			
			else
				shape = new Circle(event.getX(), event.getY(), 10, 10, Color.WHITE);
			
		}

		@Override
		public void mouseEntered(MouseEvent event) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent event) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent event) {
			// TODO Auto-generated method stub
			x1 = event.getX();
			if(shape instanceof Circle)
				shape = new Circle(event.getX(), event.getY(), 1, 1, color);
			
			else if(shape instanceof BHRectangle)
				shape = new BHRectangle(event.getX(), event.getY(), 1, 1, color);
			
			else if(shape instanceof Triangle)
				shape = new Triangle(event.getX(), event.getY(), color);
			
			else
				shape = new Circle(event.getX(), event.getY(), 1, 1, Color.WHITE);
			
		}

		@Override
		public void mouseReleased(MouseEvent event) {
			// TODO Auto-generated method stub
			shape.increaseWidth(event.getX() - x1);
			((Component) shape).repaint();
			
		}
		
		
	}
	
	private class ActionClass implements ActionListener{
		public void actionPerformed(ActionEvent event){
			
			JButton source;
			source = (JButton)event.getSource();
			
			if(source.equals(red))
				color = Color.RED;
			
			else if(source.equals(blue))
				color = Color.BLUE;
			
			else if(source.equals(yellow))
				color = Color.YELLOW;
			
			else if(source.equals(circleButton))
				shape = new Circle();
			
			else if(source.equals(triangleButton))
				shape = new Triangle();
			
			else if(source.equals(squareButton))
				shape = new BHRectangle();
			
			
		}
		
	}

}

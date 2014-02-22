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
	
	
	public DrawingPanel(){
		
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
		public void mouseDragged(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseMoved(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		
	}
	
	private class ActionClass implements ActionListener{
		public void actionPerformed(ActionEvent event){
			
			JButton source;
			source = (JButton)event.getSource();
			
			if(source == red)
				color = Color.RED;
			
			else if(source == blue)
				color = Color.BLUE;
			
			else if(source == yellow)
				color = Color.YELLOW;
			
			else if(source == circleButton){}
			
			
		}
		
	}

}

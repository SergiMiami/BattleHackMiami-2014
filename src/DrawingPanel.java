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
	//private BHShape shape;
	private Color color;
	public static int SWITCH;
	public final int SQUARE = 1;
	public final int CIRCLE = 2;
	public final int TRIANGLE = 3;
	public int x1, x2, y1,y2;
	
	
	public DrawingPanel(){
		
		mousepanel = new JPanel();
		mousepanel.setBackground(Color.WHITE);
		add(mousepanel, BorderLayout.CENTER);
		mousepanel.setPreferredSize(new Dimension(600, 600));
		
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
		buttonPanel.setBackground(Color.WHITE);
		buttonPanel.setPreferredSize(new Dimension(600, 100));
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		
		buttonPanel.add(red);
		buttonPanel.add(blue);
		buttonPanel.add(yellow);
		buttonPanel.add(triangleButton);
		buttonPanel.add(squareButton);
		buttonPanel.add(circleButton);
		
		mousepanel.add(buttonPanel, BorderLayout.NORTH);

		red.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				color = Color.RED;
			}
			
		});
		
		blue.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				color = Color.BLUE;
			}
		});
		
		yellow.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				color = Color.YELLOW;
			}
		});
		
		triangleButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				SWITCH = TRIANGLE;
			}
		});
		squareButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				SWITCH = SQUARE;
			}
		});
		circleButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				SWITCH = CIRCLE;
			}
		});
				
		
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
			x1 = event.getX();
			x2 = event.getX() + 60;
			y1 = event.getY();
			y2 = event.getY() + 60;
			repaint();
			
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
			y1 = event.getY();
			repaint();
			
		}

		@Override
		public void mouseReleased(MouseEvent event) {
			// TODO Auto-generated method stub
			x2 = event.getX();
			y2 = event.getY();
			repaint();
			
		}
		
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
		if(SWITCH == SQUARE){
			//g2.fill(color);
			g2.setColor(color);
			g2.drawRect(x1, y1, x2, y2);
			//g2.fill(color);
		}
		
		else if(SWITCH == CIRCLE){
			g2.drawOval(x1, y1, x2, y2);
		}
		
		else{ 
			g2.drawRect(x1, y1, x2, y2);
		}
		
	}

}

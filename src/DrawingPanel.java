import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class DrawingPanel extends JPanel {
	private JPanel mousepanel;
	private JLabel statusbar;
	private JButton red;
	private JButton yellow;
	private JButton blue;
	private JButton triangleButton;
	private JButton squareButton;
	private JButton circleButton;
	private List<MyRectangle> lstShapes;
	private Color color;
	public static int SWITCH;
	public final int SQUARE = 1;
	public final int CIRCLE = 2;
	public final int TRIANGLE = 3;
	public int x1, y1;
	public int height, width;
	
	
	public DrawingPanel(){
		//paintImage = new BufferedImage(1, 1, BufferedImage.TYPE_3BYTE_BGR);
		lstShapes = new ArrayList<MyRectangle>(25);
		
		mousepanel = new JPanel();
		mousepanel.setBackground(Color.WHITE);
		add(mousepanel, BorderLayout.CENTER);
		mousepanel.setPreferredSize(new Dimension(600, 600));
		mousepanel.setOpaque(false);
		
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
		//buttonPanel.setBackground(Color.WHITE);
		buttonPanel.setPreferredSize(new Dimension(600, 100));
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		
		buttonPanel.add(red);
		buttonPanel.add(blue);
		buttonPanel.add(yellow);
		buttonPanel.add(triangleButton);
		buttonPanel.add(squareButton);
		buttonPanel.add(circleButton);
		
		mousepanel.add(buttonPanel, BorderLayout.NORTH);
		
		statusbar = new JLabel("Nothing is happening");
		mousepanel.add(statusbar, BorderLayout.SOUTH);

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
	
	private class Handlerclass extends MouseAdapter{

		@Override
		/*
		public void mouseDragged(MouseEvent event) {
			// TODO Auto-generated method stub
            x2=event.getX();
            y2=event.getY();
            repaint();
            statusbar.setText("Mouse is dragging");
			
		}

		@Override
		*/
		public void mouseMoved(MouseEvent event) {
			// TODO Auto-generated method stub
			
		}

		//@Override
		/*
		public void mouseClicked(MouseEvent event) {
			// TODO Auto-generated method stub
			x1 = event.getX();
			x2 = event.getX() + 20;
			y1 = event.getY();
			y2 = event.getY() + 20;
			repaint();
			statusbar.setText("Mouse has been clicked x-axis: " + event.getX() + "and Y:" + event.getY());
			
		}
		*/

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
			//repaint();
			statusbar.setText("Mouse has been pressed");
			
			
		}

		@Override
		public void mouseReleased(MouseEvent event) {
			// TODO Auto-generated method stub
			width = event.getX() - x1;
			height = event.getY() - y1;
			lstShapes.add(new MyRectangle(x1, y1, width, height, color));
			repaint();			
			statusbar.setText("Mouse has been released with " + width + " " + height);		
		} 
		
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		//g2.drawImage(paintImage, 0, 0, null);
		if(SWITCH == SQUARE){
			
			//g2.setColor(color);
			//MyRectangle box = new MyRectangle(x1, y1, x2-x1, y2-y1, color);
			//g2.fill(box);
		     for (MyRectangle rect : lstShapes) {
		          rect.paint(g2);
		     }
		}
		
		else if(SWITCH == CIRCLE){
			//lstShapes.add(new MyRectangle(x1, y1, width, height, color));
			//g2.setColor(color);
			//MyRectangle box = new MyRectangle(x1, y1, x2-x1, y2-y1, color);
			//g2.fill(box);
		     for (MyRectangle rect : lstShapes) {
		          rect.paint(g2);
		     }
		}
		
		else{
			//lstShapes.add(new MyRectangle(x1, y1, width, height, color));
			//g2.setColor(color);
			//MyRectangle box = new MyRectangle(x1, y1, x2-x1, y2-y1, color);
			//g2.fill(box);
		     for (MyRectangle rect : lstShapes) {
		          rect.paint(g2);
		     }
		}
		
		//paintImage = new BufferedImage(600, 600, BufferedImage.TYPE_3BYTE_BGR);
		
	}
	
	public class MyRectangle extends Rectangle {

        private Color color;

        public MyRectangle(int x, int y, int width, int height, Color color) {
            super(x, y, width, height);
            this.color = color;
        }

        public Color getColor() {
            return color;
        }

        public void paint(Graphics2D g2d) {

            g2d.setColor(getColor());
            g2d.fill(this);

        }
    }

}

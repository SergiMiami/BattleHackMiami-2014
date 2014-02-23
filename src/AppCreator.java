import java.awt.*;
import javax.swing.*;
import java.awt.Event.*;
import javax.swing.*;

public class AppCreator extends JApplet {
	
	public void init(){
		getContentPane().setBackground(Color.BLUE);
		this.setSize(600, 600);
		try{
			SwingUtilities.invokeAndWait(new Runnable(){
				
				public void run(){
					createGUI();
				}
			});
			
		} catch(Exception e){
			System.err.println("createGUI didn't complete successfully");
		}
		
	}
	
	private void createGUI(){
		DrawingPanel newContentPane = new DrawingPanel();
		//newContentPane.setOpaque(true);
		setContentPane(newContentPane);
	}
	
}

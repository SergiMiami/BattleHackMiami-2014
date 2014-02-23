

public class StartClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AppCreator app = new AppCreator();
		app.init();
		app.start();
		javax.swing.JFrame window = new javax.swing.JFrame("Hack For Kids");
		window.setContentPane(app);
		window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		window.pack();
		window.setVisible(true);

	}

}

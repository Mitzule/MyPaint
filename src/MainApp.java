import javax.swing.SwingUtilities;

import ro.uvt.desenare.view.MyPaint;

public class MainApp {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(()->{ new MyPaint();});
	}
}

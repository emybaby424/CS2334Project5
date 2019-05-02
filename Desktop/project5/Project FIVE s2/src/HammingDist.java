import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class HammingDist extends JFrame{

	
	public HammingDist() throws IOException{
		
		setFrame();		// setting initial frame
		
		//setSlider();	// setting slider
		
		//setTextFields();	// setting text fields
		
		//setComboBox();		// setting combo box
		
		//setButtons();	// setting up buttons
		
		// setting initial frame
	}
	
		private void setFrame() {
		setTitle("Hamming Distance");
		setSize(600,800);
		JPanel panel1 = new JPanel(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		}
		
	public static void main(String[] args) throws IOException{
		HammingDist HD = new HammingDist();
		HD.revalidate();
		
	}
}
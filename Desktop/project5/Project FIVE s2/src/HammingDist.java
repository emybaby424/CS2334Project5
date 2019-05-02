import java.io.IOException;

import javax.swing.JFrame;

public class HammingDist extends JFrame{

	
	public HammingDist() throws IOException{
		
		setFrame();		// setting initial frame
		
		setSlider();	// setting slider
		
		setTextFields();	// setting text fields
		
		setComboBox();		// setting combo box
		
		setButtons();	// setting up buttons
		
	public static void main(String[] args) throws IOException{
		HammingDist HD = new HammingDist();
		HD.revalidate();
		
	}
}
import java.awt.Color;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class HammingDist extends JFrame{

	
	private JSlider slider = new JSlider(1,4);
	
	/**
	 * slider value
	 */
	private JLabel sliderValue = new JLabel();

	private Color color;

	public HammingDist() throws IOException{
		
		setFrame();		// setting initial frame
		
		setSlider();	// setting slider
		
		setTextFields();	// setting text fields
		
		//setComboBox();		// setting combo box
		
		//setButtons();	// setting up buttons
		
		// setting initial frame
	}
	private void setTextFields() {
		// default text
		input.setText("ZERO");
		
		// setting bounds for each text and text boxes
		input.setBounds(150,700,100,25);
		
		sliderText.setBounds(15,8,120,15);
		compareText.setBounds(20,415,120,15);
		
		dist0.setBorder(BorderFactory.createLineBorder(only, 1));
		dist0.setBounds(150,495,100,20);
		
		dist1.setBorder(BorderFactory.createLineBorder(only, 1));
		dist1.setBounds(150,535,100,20);
		
		dist2.setBorder(BorderFactory.createLineBorder(only, 1));
		dist2.setBounds(150,585,100,20);
		
		dist3.setBorder(BorderFactory.createLineBorder(only, 1));
		dist3.setBounds(150,625,100,20);
		
		dist4.setBorder(BorderFactory.createLineBorder(only, 1));
		dist4.setBounds(150,660,100,20);

		text0.setBounds(20,500,120,10);
		text1.setBounds(20,545,120,10);
		text2.setBounds(20,585,120,10);
		text3.setBounds(20,625,120,10);
		text4.setBounds(20,665,120,10);
		
		showLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		showLabel.setBackground(Color.WHITE);
		showLabel.setOpaque(true);
		showLabel.setBounds(25,150,200,250);
	
	private void setSlider() { 
		slider.setBounds(10,25,200,50);		// setting the bound, spaces and color for the slider
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(1);
		slider.setPaintLabels(true);
		
		sliderValue.setBorder(BorderFactory.createLineBorder(color, 1));		// setting up the slider value display
		sliderValue.setBounds(140, 5, 100, 20);
		sliderValue.setText(" " + slider.getValue());
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
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class HammingDist extends JFrame{

	
	/**
	 * The only panel that will be used 
	 */
	private JPanel panel1;
	
	/**
	 * A button that will perform the action of showing stations
	 * A button that will calculate Hamming Distance
	 * A button that will add stations
	 */
	private JButton showStation = new JButton("Show Station");
	private JButton calcHD = new JButton("Calculate HD");
	private JButton addStat = new JButton("Add Station");
	
	/**
	 * TextArea will be displayed inside a JScrollPane
	 */
	private JTextArea intext = new JTextArea(24, 12);
	private JScrollPane showLabel = new JScrollPane(intext);
	
	/**
	 * A slider that will decide the Hamming Distance for showing
	 */
	private JSlider slider = new JSlider(1,4);
	
	/**
	 * TextField where user will input stations
	 */
	private JTextField input = new JTextField(10);
	/**
	 * A drop box with all the stations stored in it
	 */
	private JComboBox<String> stationList;
	
	/**
	 * slider value
	 */
	private JLabel sliderValue = new JLabel();
	
	/**
	 * distance texts
	 */
	private JLabel text0 = new JLabel("Distance 0");
	private JLabel text1 = new JLabel("Distance 1");
	private JLabel text2 = new JLabel("Distance 2");
	private JLabel text3 = new JLabel("Distance 3");
	private JLabel text4 = new JLabel("Distance 4");
	private JLabel sliderText = new JLabel("Enter Hamming Dist:");
	private JLabel compareText = new JLabel("Compare with");
	
	/**
	 * Number of stations will the same distance value
	 */
	private JLabel dist0 = new JLabel();
	private JLabel dist1 = new JLabel();
	private JLabel dist2 = new JLabel();
	private JLabel dist3 = new JLabel();
	private JLabel dist4 = new JLabel();
	
	/**
	 * TextBox color
	 */
	private Color color = new Color(50,150,230);

	public HammingDist() throws IOException{
		
		setFrame();		// setting initial frame
		
		setSlider();	// setting slider
		
		setTextFields();	// setting text fields
		
		setComboBox();		// setting combo box
		
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
		
		dist0.setBorder(BorderFactory.createLineBorder(color, 1));
		dist0.setBounds(150,495,100,20);
		
		dist1.setBorder(BorderFactory.createLineBorder(color, 1));
		dist1.setBounds(150,535,100,20);
		
		dist2.setBorder(BorderFactory.createLineBorder(color, 1));
		dist2.setBounds(150,585,100,20);
		
		dist3.setBorder(BorderFactory.createLineBorder(color, 1));
		dist3.setBounds(150,625,100,20);
		
		dist4.setBorder(BorderFactory.createLineBorder(color, 1));
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
	}
	
	private void setComboBox() throws IOException {
		
		// reading in the data from the text file
		BufferedReader br = new BufferedReader(new FileReader("Mesonet.txt"));
		
		// loading the file into the stations list
		List<String> stations = new ArrayList<String>();
		try {
			String line = null;
			while((line = br.readLine()) != null) {
				stations.add(line);
				
			}
		}
		catch(FileNotFoundException e) {	// print error message if the file is not found
			System.err.println("Error, file Mesonet.txt didn't exist.");
		}
		finally {
			br.close();
		}
		
		// setting bound for combo box, and loading stations into combo box
		String[] lines = stations.toArray(new String[] {});
		stationList = new JComboBox<>(lines);
		stationList.setBounds(145,410,70,20);
		}
	
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
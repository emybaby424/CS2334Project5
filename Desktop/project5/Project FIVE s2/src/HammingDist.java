import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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
	
	/**
	 * importing the picture
	 */
	private BufferedImage picture;
	/**
	 * label that will display the picture
	 */
	private JLabel pic;
	
	
	public HammingDist() throws IOException{
		
	setFrame();		// setting initial frame
	
	setSlider();	// setting slider
	
	setTextFields();	// setting text fields
	
	setComboBox();		// setting combo box
	
	setButtons();	// setting up buttons
	
	setImage();		// set image
	
	// adding all the buttons to the panel
	panel1.add(showStation);
	panel1.add(calcHD);
	panel1.add(addStat);
	panel1.add(input);
	panel1.add(slider);
	panel1.add(stationList);
	
	// adding all the texts to the panel
	panel1.add(text0);
	panel1.add(text1);
	panel1.add(text2);
	panel1.add(text3);
	panel1.add(text4);
	panel1.add(sliderText);
	panel1.add(compareText);
	
	// adding all the text boxes to the panel
	panel1.add(dist0);
	panel1.add(dist1);
	panel1.add(dist2);
	panel1.add(dist3);
	panel1.add(dist4);
	
	panel1.add(sliderValue);
	panel1.add(showLabel);
	
	panel1.add(pic);
	// adding the panel to the frame
	this.add(panel1);
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
	private void setSlider() { 
		slider.setBounds(10,25,200,50);		// setting the bound, spaces and color for the slider
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(1);
		slider.setPaintLabels(true);
		
		sliderValue.setBorder(BorderFactory.createLineBorder(color, 1));		// setting up the slider value display
		sliderValue.setBounds(140, 5, 100, 20);
		sliderValue.setText(" " + slider.getValue());
		
		slider.addChangeListener(new ChangeListener() {			// adding action listener to the slider 
			@Override
			public void stateChanged(ChangeEvent e) {
			sliderValue.setText(" " + slider.getValue());		// setting slider Value to the chosen value
		}
		
	});
	}
	
	
	private void setButtons() {
		// setting up the buttons
		showStation.setBounds(17,100,115,25);
		calcHD.setBounds(17, 450, 115, 25);
		addStat.setBounds(17, 700, 115, 25);
		
		// adding action for show station button
		showStation.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				// initialize the text area every time the button is clicked
				intext.setText("");	
				
				// creating Array list for each distance value
				ArrayList<String> dist1 = new ArrayList<String>();
				ArrayList<String> dist2 = new ArrayList<String>();
				ArrayList<String> dist3 = new ArrayList<String>();
				ArrayList<String> dist4 = new ArrayList<String>();

				// getting the selected Item, and splitting it into an array of letters
				String temp = (String)stationList.getSelectedItem();
				String[] wordOne = temp.split("");
				ArrayList<String> stations = new ArrayList<String>();
			
				// adding every station into arraylist stations
				for(int i = 0 ; i < stationList.getItemCount(); ++i) {
					stations.add(stationList.getItemAt(i));
				}
				
				// comparing each stations with the selected station, and separating them into the corresponding distance arraylist
				for(int i = 0; i < stations.size(); ++i) {
					int counter = 0;
					String[] wordTwo = stations.get(i).split("");
					
					for(int j = 0; j < wordTwo.length; ++j) {
						if(!(wordOne[j].equals (wordTwo[j]))){
							counter++;
						}
					}	
					
					if(counter == 1) {
						dist1.add(stations.get(i));			
					}
					else if(counter ==2) {
						dist2.add(stations.get(i));
					}
					else if(counter==3) {
						dist3.add(stations.get(i));
					}
					else if(counter==4) {
						dist4.add(stations.get(i));
					}
					

				}
				
				
				// printing out the stations with the chosen distances
				
					if(slider.getValue() == 1) {  
						for(int here = 0; here < dist1.size(); here++) {
							intext.append(dist1.get(here) + '\n');						}
				}
					else if(slider.getValue()==2) {
						for(int here = 0; here < dist2.size(); here++) {
							intext.append(dist2.get(here) + '\n');						}
				}
					else if(slider.getValue()==3) {
						for(int here = 0; here < dist3.size(); here++) {
							intext.append(dist3.get(here) + '\n');						}
				}
					else if(slider.getValue()==4) {
						for(int here = 0; here < dist4.size(); here++) {
							intext.append(dist4.get(here) + '\n');
						}
				}
				
				
				
				
			}
		});
		
		// adding action for the calculating hamming distance button
		calcHD.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String word = (String)stationList.getSelectedItem();
				String[] wordOne = word.split("");
				ArrayList<String> stations = new ArrayList<String>();
				int[] distCounts = new int[5];
				
				// adding stations into arraylist
				for(int i = 0 ; i < stationList.getItemCount(); ++i) {
					stations.add(stationList.getItemAt(i));
				}
				
				// comparing stations
				for(int i = 0; i < stations.size(); ++i) {
					int counter = 0;
					String[] wordTwo = stations.get(i).split("");
					
					for(int j = 0; j < wordOne.length; ++j) {
						
						if(!(wordOne[j].equals (wordTwo[j]))){
							counter++;
						}
					}	
					distCounts[counter] = distCounts[counter] + 1;
				}
				
				// setting the number of stations to the corresponding text box
				dist0.setText(Integer.toString(distCounts[0]));
				dist1.setText(Integer.toString(distCounts[1]));
				dist2.setText(Integer.toString(distCounts[2]));
				dist3.setText(Integer.toString(distCounts[3]));
				dist4.setText(Integer.toString(distCounts[4]));
				
				
			}
		});
		
		// adding action for adding station button
		addStat.addActionListener(new ActionListener() { 
			@Override 
			public void actionPerformed(ActionEvent e) { 
				stationList.addItem(input.getText());	
			
			} 
		 });
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
	
	
	private void setImage() throws IOException{
		picture = ImageIO.read(new File("project.png"));
		ImageIcon icon = new ImageIcon(picture);
		pic = new JLabel(icon);
		pic.setBounds(270, 100, 300, 500);
	}

	
	// setting initial frame
	private void setFrame() {
	setTitle("Hamming Distance");
	setSize(600,800);
	panel1 = new JPanel(null);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
	
	}
	
	public static void main(String[] args) throws IOException{
		HammingDist HD = new HammingDist();
		
		// making sure everything is visible
		HD.revalidate();
		
	}
}
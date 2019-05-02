# Project 5 Documentation

The purpose of HammingDist is to create an interface for the user to calculate the Hamming Distance between a specific station and a list of stations.
The HammingDist class extends JFrame, and within this Frame, there is one JPanel.
Every component is within this Panel.
The private variables include, the three JButtons, showStation, calcHD and addStat.
JTextArea intext, used to display all the stations, is set in a JScrollPane that allows the user to scroll through the stations. There's also a JSlider to choose the distance value. An input TextField for adding new Station, a JComboBox for a drop down station list, and a sliderValue label that will display the slider value that's chosen.
There's five labels to display the number of stations with the same distance value, seven label for texts, a color for box outline, bufferedImage picture for reading in a PNG file, and a label pic, to display the picture.
In the HammingDist Constructor, six private methods are called, they are:
setFrame(), in the setFreame method, an interface is created with title of "Hamming Distance", Size of (600,800), the panel is also initialized in this method.
setSlider(), in the setSlider method, an slider is created with painted label and ticks, the spacing of the ticks are set to 1, an actionListener is used with a parameter of changeListener to catch a change in the slider. The changed value will be displayed in the sliderValue Label.
setTextField(), in this method, all the JLabels' bound will be set in the correct place, along with colored box outline.
setComboBox(), that will read in the station files and store it inside the comboBox, this will be performed inside a try catch block to catch a FileNotFoundException, if such an exception is catched, the program will print out an error message to alert the user.
setButtons(), in this method, the buttons will be put in the desired place by using .setBound(), and an actionListener will be added for each of the buttons. For showStation, four ArrayList is created for storing stations with the same distance value. The chosen word from the comboBox will be split into individual letters and stored in an array, then each stations from the station arraylist will also be split into individual letter in an array. Then two for loop will be used to compare the two array index by index. The distance of the two station will be counted, and depending on the distance result, the station will be stored in the coresponding arrayList. Finally, the slider.getValue() to the get chosen distance the user wants, and an if statement is used to display the corresponding arraylist to the JTextArea.

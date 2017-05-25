import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class StartWindow extends JFrame {
	
	boolean windowOpened = false;
	
	public static void main(String args[]){
		new StartWindow();
	}
	
	StartWindow(){
		//sets up window
		super("Connecting-US™");
		JTextArea area = new JTextArea("Welcome to Connecting-US™, press on any button to continue");
		JLabel label = new JLabel();
		JPanel panel = new JPanel();
		JButton studyButton = new JButton("Study");
		JButton learnButton = new JButton("Learn");
		JButton infoButton = new JButton("Info");
		
		//window decoration
		area.setBackground(Color.RED);
		area.setEditable(false);
		panel.setLayout(new GridLayout(1,3));
		setLayout(null); //nullifies layout
		Insets insets = this.getInsets();
		label.setBounds(insets.left, insets.top, 500, 170);
		area.setBounds(insets.left, insets.top + 170, 500, 70);
		panel.setBounds(insets.left, insets.top + 240, 500, 50);
		panel.add(studyButton);panel.add(learnButton);panel.add(infoButton);
		
		//put together window
		add(label);add(area);add(panel);
		setVisible(true);
		setSize(500,330); //window size
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		studyButton.addActionListener(
	    		new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						if(windowOpened == true){	//if-else statement only allows one window open at a time
							closeOpenedWindow();
						}else{
							new BrowserWindow();	//window to open (if no other window is opened)
							windowOpened = true;
						}
					}
	    		}
	    	);
		learnButton.addActionListener(
	    		new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						if(windowOpened == true){	//if-else statement only allows one window open at a time
							closeOpenedWindow();
						}else{
							new GameWindow();	//window to open (if no other window is opened)
							windowOpened = true;
						}
					}
	    		}
	    	);
		infoButton.addActionListener(
	    		new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						if(windowOpened == true){	//if-else statement only allows one window open at a time
							closeOpenedWindow();
						}else{
							new InfoWindow();	//window to open (if no other window is opened)
							windowOpened = true;
						}
					}
	    		}
	    	);
	}
	
	//Close Opened Window Method
	public void closeOpenedWindow(){
		System.out.println("Closing window");
	}
	//-----------------------------------------------//
	////////////////BROWSER INNER CLASS////////////////
	public class BrowserWindow { //Study
		
		//sample
		BrowserWindow(){
			JFrame frame = new JFrame("Study State Capitals");
			JButton button = new JButton("Click to go to Game Window"); //closes current window and opens game window
			frame.add(button);
			frame.setSize(780, 510);
			frame.setResizable(false);
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);
			frame.isAlwaysOnTop();
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			button.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					frame.dispose();
					windowOpened = false;
					new GameWindow();
				}
			});
			
			//lets program know that window was closed
			frame.addWindowListener(new java.awt.event.WindowAdapter() {
			    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
			        windowOpened = false;
			    }
			});
		}

	}
	//-----------------------------------------------//
	///////////////GAME INNER CLASS///////////////////
	public class GameWindow { //Learn
		
		//sample
		GameWindow(){
			JFrame frame = new JFrame("Answer State Capitals");
			frame.setSize(780, 510);
			frame.setResizable(false);
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);
			frame.isAlwaysOnTop();
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
			//lets program know that window was closed
			frame.addWindowListener(new java.awt.event.WindowAdapter() {
			    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
			        windowOpened = false;
			    }
			});
		}

	}
	//-----------------------------------------------//
	//////////////INFO INNER CLASS///////////////////
	public class InfoWindow { //Info
		
		//sample
		InfoWindow(){
			JFrame frame = new JFrame("How To Use");
			frame.setSize(500, 300);
			frame.setResizable(false);
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);
			frame.isAlwaysOnTop();
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
			//lets program know that window was closed
			frame.addWindowListener(new java.awt.event.WindowAdapter() {
			    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
			        windowOpened = false;
			    }
			});
		}

	}
}

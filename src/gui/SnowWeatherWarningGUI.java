package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Locale;
import java.util.ResourceBundle;
import logging.AssignmentLogger;
import logging.RegisterComputer;
import internationalization.TranslateSnowWarning;
import internationalization.trans.*;
import warningsystem.NoSnowWarning;
import warningsystem.OrangeSnowWarning;
import warningsystem.RedSnowWarning;
import warningsystem.WeatherWarning;
import warningsystem.YellowSnowWarning;

public class SnowWeatherWarningGUI extends JFrame implements ActionListener, Runnable{
	JFrame frame;
	Locale US = new Locale("en" , "US");
	ResourceBundle transBundleUSA = ResourceBundle.getBundle("internationalization/trans.trans_en",US);
	Locale GER = new Locale("de" , "DE");
	ResourceBundle transBundleGER = ResourceBundle.getBundle("internationalization/trans.trans_ge",GER);
	//create JFrame, locales and resource bundles
	JLabel EnterInstructions = new JLabel(transBundleUSA.getString("EnterInstructions"));
	JTextField InputSnow = new JTextField(5);
	JLabel Centimetre = new JLabel(transBundleUSA.getString("Centimetre"));
	JButton CheckSnowButton = new JButton(transBundleUSA.getString("CheckSnowButton"));
	JButton Translate = new JButton(transBundleUSA.getString("Translate"));
	//created input labels, textfield, buttons and filled paramater using bundle class getString
	JLabel Warning = new JLabel();
	JLabel Limit = new JLabel();
	JLabel Message = new JLabel();
	JLabel ImageLabel = new JLabel();
	//created output labels
	Icon RedWarning = new ImageIcon("images/RedSnow.png");
	Icon YellowWarning = new ImageIcon("images/SnowYellow.png");
	Icon OrangeWarning = new ImageIcon("images/OrangeSnow.png");
	Icon NoWarning = new ImageIcon("images/AllClear.png");
	//create images pathway
	JPanel InputPanel = new JPanel();
	JPanel OutputPanel = new JPanel();
	//create panels
	private Thread delayWarning = new Thread();
	//create thread
	public SnowWeatherWarningGUI() {
		super("WeatherWarning");
		AssignmentLogger.logConstructor(this);
		Container pane = getContentPane();
		InputPanel.setBackground(Color.LIGHT_GRAY);
		OutputPanel.setBackground(Color.LIGHT_GRAY);
		pane.add(InputPanel, BorderLayout.NORTH);
		pane.add(OutputPanel, BorderLayout.CENTER);
		CheckSnowButton.addActionListener(this);
		Translate.addActionListener(this);
		InputPanel.add(EnterInstructions);
		InputPanel.add(InputSnow);
		InputPanel.add(Centimetre);
		InputPanel.add(CheckSnowButton);
		InputPanel.add(Translate, BorderLayout.SOUTH);
		OutputPanel.add(Warning);
		OutputPanel.add(Limit);
		OutputPanel.add(Message);
		OutputPanel.add(ImageLabel);
		setVisible(true);
		setSize(750,450);	
		//building of gui with listeners and border control
	}
	public void start() {
		AssignmentLogger.logMethodEntry(this);
		if(delayWarning==null) {
			delayWarning = new Thread(this);
			delayWarning.start();
		}
		AssignmentLogger.logMethodExit(this);
		//created start method for thread
	}
	@Override
	public void run(){
		// TODO Auto-generated method stub
		AssignmentLogger.logMethodEntry(this);
		Thread myThread = Thread.currentThread();
		while(delayWarning == myThread) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//created run method for thread
		}
		AssignmentLogger.logMethodExit(this);
	}
	public static void main(String[] args) {
		AssignmentLogger.logStaticMethodEntry();
		SnowWeatherWarningGUI Frame = new SnowWeatherWarningGUI();
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		AssignmentLogger.logStaticMethodExit();
		//main method
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		AssignmentLogger.logMethodEntry(this);	
		
		RedSnowWarning Red = new RedSnowWarning();
		OrangeSnowWarning Orange = new OrangeSnowWarning();
		YellowSnowWarning Yellow = new YellowSnowWarning();
		NoSnowWarning Green = new NoSnowWarning();
		//created objects to pull information from polymorphic methods and parent/child classes
		if(e.getSource() == Translate){
			EnterInstructions.setText(transBundleGER.getString("EnterInstructions"));
			Centimetre.setText(transBundleGER.getString("Centimetre"));
			CheckSnowButton.setText(transBundleGER.getString("CheckSnowButton"));
			Translate.setText(transBundleGER.getString("Translate"));
			//translation before checking snow level
		}
		int Input = Integer.parseInt(InputSnow.getText());
		//convert string input to int
		if(e.getSource() == CheckSnowButton){
			if(Input > Red.getLimit()) {
				//check input
			OutputPanel.setBackground(Color.RED);
			Warning.setText(Red.getWarning() + "!");
				//pulled information from polymorphic method
			ImageLabel.setIcon(RedWarning);
			Limit.setText(transBundleUSA.getString("Limit1"));
			Message.setText(transBundleUSA.getString("Message1"));
			//set texts and picture according to input
			Translate.addActionListener(new ActionListener() {
				 public void actionPerformed(ActionEvent e) { 
			if(e.getSource() == Translate) {
				Limit.setText(transBundleGER.getString("Limit1"));
				Message.setText(transBundleGER.getString("Message1"));
					}
				 }
			 });
			//anonymous class created for transalation after snow level checked
			try{
			delayWarning.start();
			delayWarning.run();
			delayWarning.stop();
			Limit.setText(transBundleUSA.getString("Limit1"));
			Message.setText(transBundleUSA.getString("Message1"));
			//delay before text appears
			}
			catch(NullPointerException ex) {
			ex.printStackTrace();
			}
		}
	
		
				if(Input<Red.getLimit()) {
					if(Input>Yellow.getLimit()) {
						//check input
				OutputPanel.setBackground(Color.ORANGE);
				Warning.setText(Orange.getWarning() + "!");
				//pulled information from polymorphic method
				ImageLabel.setIcon(OrangeWarning);
				Limit.setText(transBundleUSA.getString("Limit2"));
				Message.setText(transBundleUSA.getString("Message2"));
				//set texts and picture according to input
				Translate.addActionListener(new ActionListener() {
					 public void actionPerformed(ActionEvent e) { 
				if(e.getSource() == Translate) {
					Limit.setText(transBundleGER.getString("Limit2"));
					Message.setText(transBundleGER.getString("Message2"));
						}
					 }
				 });
				//anonymous class created for transalation after snow level checked
				try {
				delayWarning.start();
				delayWarning.run();
				delayWarning.stop();
				//delay before text appears
				Limit.setText(transBundleUSA.getString("Limit2"));
				Message.setText(transBundleUSA.getString("Message2"));
				}
			catch(NullPointerException ex2) {
				ex2.printStackTrace();
				}
			}
		}
				if(Input<Yellow.getLimit()) {
					if(Input>Green.getLimit()) {
						//check input
				OutputPanel.setBackground(Color.YELLOW);
				Warning.setText(Yellow.getWarning() + "!");
				//pulled information from polymorphic method
				ImageLabel.setIcon(YellowWarning);
				Limit.setText(transBundleUSA.getString("Limit3"));
				Message.setText(transBundleUSA.getString("Message3"));
				//set texts and picture according to input
				Translate.addActionListener(new ActionListener() {
					 public void actionPerformed(ActionEvent e) { 
				if(e.getSource() == Translate) {
					Limit.setText(transBundleGER.getString("Limit3"));
					Message.setText(transBundleGER.getString("Message3"));
						}
					 }
				 });
				//anonymous class created for transalation after snow level checked
				try {
				delayWarning.start();
				delayWarning.run();
				delayWarning.stop();
				//delay before text appears
				Limit.setText(transBundleUSA.getString("Limit3"));
				Message.setText(transBundleUSA.getString("Message3"));
				}
			catch(NullPointerException ex3) {
				ex3.printStackTrace();
				}
			}
		}
				if(Input==Green.getLimit()) {
					//check input
				OutputPanel.setBackground(Color.GREEN);
				Warning.setText(Green.getWarning() + "!");
				//pulled information from polymorphic method
				ImageLabel.setIcon(NoWarning);
				Limit.setText(transBundleUSA.getString("Limit4"));
				Message.setText(transBundleUSA.getString("Message4"));
				//set texts and picture according to input
				try {
				delayWarning.start();
				delayWarning.run();
				delayWarning.stop();
				//delay before text appears
				Limit.setText(transBundleUSA.getString("Limit4"));
				Message.setText(transBundleUSA.getString("Message4"));
				Translate.addActionListener(new ActionListener() {
					 public void actionPerformed(ActionEvent e) { 
				if(e.getSource() == Translate) {
					Limit.setText(transBundleGER.getString("Limit4"));
					Message.setText(transBundleGER.getString("Message4"));
						}
					 }
				 });
				}
				//anonymous class created for transalation after snow level checked
			catch(NullPointerException ex4) {
				ex4.printStackTrace();
				}
			}
		}
		AssignmentLogger.logMethodExit(this);
			}
}
	

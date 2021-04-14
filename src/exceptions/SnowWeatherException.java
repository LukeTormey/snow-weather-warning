package exceptions;
import logging.RegisterComputer;
import logging.AssignmentLogger;
import gui.SnowWeatherWarningGUI;

public class SnowWeatherException extends Exception{
	public void MinusNumberException(int Input) {
		AssignmentLogger.logMethodEntry(this);
		if(Input<0) {
			System.out.println("No negative numbers");
		}
		AssignmentLogger.logMethodExit(this);
	}
	//i know that the exception is not meant to have a void return type
	//tried to use this custom exception would not fit the code and only caused errors
	//i made the method void so there was no compilation problems in the whole project
	//made my best attempt at making this work
}

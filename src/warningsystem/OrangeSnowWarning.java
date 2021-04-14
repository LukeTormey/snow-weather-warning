package warningsystem;
import logging.RegisterComputer;
import logging.AssignmentLogger;

public class OrangeSnowWarning extends WeatherWarning{

	@Override
	public String getWarning() {
		AssignmentLogger.logMethodEntry(this);
		String A = "Orange Warning";
		// TODO Auto-generated method stub
		AssignmentLogger.logMethodExit(this);
		return A;
	}
	//polymorphic method created with return type that can be used in other classes
	
	@Override
	public int getLimit() {
		//not used through code. 
		return 0;
	}
	//polymorphic method created with return type that can be used in other classes
}

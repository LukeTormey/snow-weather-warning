package warningsystem;

import logging.AssignmentLogger;

public class YellowSnowWarning extends WeatherWarning{

	@Override
	public String getWarning() {
		AssignmentLogger.logMethodEntry(this);
		String A = "Yellow Warning";
		// TODO Auto-generated method stub
		AssignmentLogger.logMethodExit(this);
		return A;
	}
	//polymorphic method created with return type that can be used in other classes
	@Override
	public int getLimit() {
		// TODO Auto-generated method stub
		AssignmentLogger.logMethodEntry(this);
		AssignmentLogger.logMethodExit(this);
		return 3;
	}
	//polymorphic method created with return type that can be used in other classes
}

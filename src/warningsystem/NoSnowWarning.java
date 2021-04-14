package warningsystem;

import logging.AssignmentLogger;

public class NoSnowWarning extends WeatherWarning{

	@Override
	public String getWarning() {
		AssignmentLogger.logMethodEntry(this);
		String A = "No Warning";
		// TODO Auto-generated method stub
		AssignmentLogger.logMethodExit(this);
		return A;
	}
	//polymorphic method created with return type that can be used in other classes

	@Override
	public int getLimit() {
		AssignmentLogger.logMethodEntry(this);
		AssignmentLogger.logMethodExit(this);
		return 0;
	}
	//polymorphic method created with return type that can be used in other classes

}

package warningsystem;
import logging.AssignmentLogger;
import logging.RegisterComputer;

public abstract class WeatherWarning {
	public abstract String getWarning();
	public abstract int getLimit();
	//created abstract polymorphic methods that will be used in project
}

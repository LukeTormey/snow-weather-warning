package internationalization;
import logging.AssignmentLogger;
import logging.RegisterComputer;
import java.util.Locale;
import java.util.ResourceBundle;
import gui.SnowWeatherWarningGUI;

public class TranslateSnowWarning {
	Locale US = new Locale("en" , "US");
	ResourceBundle transBundleUSA = ResourceBundle.getBundle("internationalization/trans.trans_en",US);
	//english locale and resource bundle class made
	Locale GER = new Locale("de" , "DE");
	ResourceBundle transBundleGER = ResourceBundle.getBundle("internationalization/trans.trans_ge",GER);
	//german locale and resource bundle class made
}

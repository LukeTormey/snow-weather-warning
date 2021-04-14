package logging;

public class RegisterComputer {
	
	public static void main(String[] args) {
		RegisterComputer reg = new RegisterComputer();
		reg.register();

	}

	/**
	 *  This is the first method to run in each module to register when the work on the module began
	 */
	private void register() {
		AssignmentLogger.register(this);
		
	}
}

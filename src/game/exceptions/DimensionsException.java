package game.exceptions;

public class DimensionsException extends Exception {
	private String errorMsg;

	private static final long serialVersionUID = -5680644394417478341L;

	public DimensionsException() {

	}

	public DimensionsException(String msg) {
		super(msg);
		errorMsg = msg;
	}

	public void setErrorMsg(String msg) {
		errorMsg = msg;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

}

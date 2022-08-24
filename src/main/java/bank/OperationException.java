package bank;

public class OperationException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String messageKey;

	
	public OperationException(String messageKey) {
		super();
		this.messageKey = messageKey;
	}

	public String getMessageKey() {
		return messageKey;
	}

	public void setMessageKey(String messageKey) {
		this.messageKey = messageKey;
	}
	

}

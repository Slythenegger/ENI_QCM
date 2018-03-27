package fr.eni.qcm;

@SuppressWarnings("serial")
public class BusinessException extends Exception {
	
	private BusinessError error;
	
	public BusinessException() {
		super();
	}
	
	public BusinessException(String message) {
		super(message);
	}
	
	public BusinessException(BusinessError error) {
		this.error = error;
	}
	public BusinessException(BusinessError error, String message) {
		super(message);
		this.error = error;
	}
	
	public BusinessError getError() {
		return this.error;
	}
	
	@Override
	public String getMessage() {
		StringBuffer sb = new StringBuffer("Couche BLL: ");
		String message = super.getMessage();
		
		sb.append(this.error);
		if(message != null) sb.append(message);
		
		return sb.toString() ;
	}
}

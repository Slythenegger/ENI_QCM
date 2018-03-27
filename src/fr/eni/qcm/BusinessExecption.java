package fr.eni.qcm;

@SuppressWarnings("serial")
public class BusinessExecption extends Exception {
	
	private BusinessError error;
	
	public BusinessExecption() {
		super();
	}
	
	public BusinessExecption(String message) {
		super(message);
	}
	
	public BusinessExecption(BusinessError error) {
		this.error = error;
	}
	public BusinessExecption(BusinessError error, String message) {
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

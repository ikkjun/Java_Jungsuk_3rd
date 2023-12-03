
public class Exercise8_9 {
	public static void main (String[] args) throws Exception{
		throw new UnsupportedFunctionException("지원하지 않는 기능입니다.",100);
	}	// end of main
}	

class UnsupportedFunctionException extends RuntimeException {
//	private final int ERR_CODE = 100;	// 에러코드를 저장하기 위한 변수
	private int ERR_CODE = 100;	// 에러코드를 저장하기 위한 변수
	
	UnsupportedFunctionException(String message, int err) {
		super(message);
		ERR_CODE = err;
	}
	
	UnsupportedFunctionException(String message) {
		this(message, 100);
	}
	
	public int getErrorCode() {
		return ERR_CODE;
	}
	
	public String getMessage() {
		return "[" + getErrorCode() + "]" + super.getMessage();
	}
}
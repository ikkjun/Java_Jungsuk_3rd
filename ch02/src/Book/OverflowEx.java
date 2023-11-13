public class OverflowEx {

	public static void main(String[] args) {
		short sMin = -32768;
		short sMax = 32767;
		char cMin = 0;
		char cMax = 65535;
		
		// short:	부호있는 정수	표현범위: -8 ~ 7
		// long:	부호없는 정수	표현범위: 0 ~ 15
		
		System.out.println("sMin = " + sMin);
		System.out.println("sMin-1= " + (short)(sMin-1));
		System.out.println("sMax = " + sMax);
		System.out.println("sMin+1= " + (short)(sMax+1));
		System.out.println("sMin = " + sMin);
		System.out.println("cMin = " + (int)cMin);
		System.out.println("cMin-1= " + (int)--cMin);
		System.out.println("cMax = " + (int)cMax);
		System.out.println("cMin+1= " + (int)++cMax);
	}

}

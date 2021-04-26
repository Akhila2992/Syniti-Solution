package test;

public class RecordHelper {

	@SuppressWarnings("finally")
	public static boolean isNumeric(String value) {
		try {
			Integer num = Integer.parseInt(value);
			return true;
		}catch(Exception e) {
			//System.out.println("Not a number");
			return false;
		}
		
	}
	
	
}

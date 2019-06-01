
public class Validation {
	public static boolean idCheck(String id) {
		String rule = "[0-9]{4}";
		if(id.matches(rule)) {
			return true;
		}else
			return false;
	}
	public static boolean psCheck(String ps) {
		String rule = "[a-zA-Z0-9]{3,6}";
		if(ps.matches(rule)) {
			return true;
		}else
			return false;
	}
	public static boolean phnCheck(String pc) {
		String rule = "[0-9]{10}";
		if(pc.matches(rule)) {
			return true;
		}else
			return false;
	}
	public static boolean priceCheck(String ct) {
		String rule = "[0-9]{1,4}";
		if(ct.matches(rule)) {
			return true;
		}else
			return false;
	}
	public static boolean emailCheck(String email) {
		String rule  = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";
		if(email.matches(rule)) {
			return true;
		}else
			return false;
	}
	public static boolean nameCheck(String nm) {
		String rule = "[a-zA-Z]+";
		if(nm.matches(rule)) {
			return true;
		}else
			return false;
	}
	public static boolean addCheck(String add) {
		String rule = "[a-zA-Z0-9]+";
		if(add.matches(rule)) {
			return true;
		}else
			return false;
	}
	public static boolean shelfLifeCheck(String sl) {
		String rule = "[0-9]{1,2}";
		if(sl.matches(rule)) {
			return true;
		}else
			return false;
	}
	public static boolean amnCheck(String am) {
		String rule = "^[1-9][0-9]{1,4}";
		if(am.matches(rule)) {
			return true;
		}else
			return false;
	}
}

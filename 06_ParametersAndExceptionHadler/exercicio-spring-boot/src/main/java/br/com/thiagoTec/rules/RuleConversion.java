package br.com.thiagoTec.rules;

public class RuleConversion {
	
	public static Double convertToDouble(String strNumber) {
		if (strNumber == null) return 0D;
		
		String number = strNumber.replaceAll(",", ".");
		
		if(RuleIsNumeric.isNumeric(number)) return Double.parseDouble(number);
		return null;
	}

}

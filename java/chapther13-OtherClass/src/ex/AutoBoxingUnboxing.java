package ex;

import java.math.BigDecimal;

public class AutoBoxingUnboxing {

	public static void main(String[] args) {

		Integer iValue = 10; // new Integer(10); Auto Boxing 
		Double dValue = 3.14; // new Double(3.14);
		
		System.out.println(iValue.toString());
		System.out.println(dValue.toString());
		
		int num1 = iValue; // Auto Unboxing
		double num2 = dValue; // Auto Unboxing 
		
		System.out.println(num1);
		System.out.println(num2);
		
	}

}

package com.fit.selmor;

public class ExcelDemo {
	
	
	
	public static void main(String[] args) {
		ExcelUtility excel = new ExcelUtility();

		String username = excel.getText(1, 1);
		String password = excel.getText(1, 2);
		long mobile = (long) excel.getNumber(1, 3);
		double score = excel.getNumber(1, 4);
		excel.writeValue(1, 5, "passed");
		
		System.out.println(username+" "+password+" "+score+" "+mobile);
	}
}

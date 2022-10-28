package com.fit.selmor;

import java.io.*;
import org.apache.poi.xssf.usermodel.*;

public class ExcelUtility {
	public static String FILE_PATH = "src/main/resources/fbtestcase.xlsx";
	XSSFWorkbook workbook = null;
	XSSFSheet sheet = null;
	XSSFRow row = null;
	XSSFCell cell = null;
	FileInputStream fin = null;
	FileOutputStream fout = null;
	
	public Object[][] getLoginData() {
		Object[][] data = new Object[3][2];
		try {
			fin = new FileInputStream(FILE_PATH);
			workbook = new XSSFWorkbook(fin);
			sheet = workbook.getSheet("Sheet2");
			String email,pwd;
			for(int i=1;i<=3;i++) {
				email = sheet.getRow(i).getCell(1).getStringCellValue();
				pwd = sheet.getRow(i).getCell(2).getStringCellValue();
				data[i-1][0]=email;
				data[i-1][1]=pwd;
			}
			workbook.close();
			fin.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		return data;
	}
	
	public String getText(int r,int c) {
		String str = null;
		try {
			fin = new FileInputStream(FILE_PATH);
			workbook = new XSSFWorkbook(fin);
			sheet = workbook.getSheet("Sheet2");
			row = sheet.getRow(r);
			cell = row.getCell(c);
			
			str = cell.getStringCellValue();
			workbook.close();
			fin.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return str;
	}
	
	public double getNumber(int r,int c) {
		double num = 0;
		try {
			fin = new FileInputStream(FILE_PATH);
			workbook = new XSSFWorkbook(fin);
			sheet = workbook.getSheet("Sheet2");
			row = sheet.getRow(r);
			cell = row.getCell(c);
			
			num = cell.getNumericCellValue();
			workbook.close();
			fin.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return num;
	}
	
	public void writeValue(int r,int c,String str) {
		try {
			fin = new FileInputStream(FILE_PATH);
			workbook = new XSSFWorkbook(fin);
			sheet = workbook.getSheet("Sheet2");
			row = sheet.getRow(r);
			cell = row.createCell(c);
			cell.setCellValue(str);
			
			fout = new FileOutputStream(FILE_PATH);
			workbook.write(fout);
			workbook.close();
			fout.close();
			fin.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
}

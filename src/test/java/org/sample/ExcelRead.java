package org.sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	public static void main(String[] args) throws IOException {

		File f = new File("C:\\Users\\User\\eclipse-workspace\\Framework\\src\\test\\resources\\TestData\\Book1.xlsx");

		FileInputStream fin = new FileInputStream(f);

		XSSFWorkbook w = new XSSFWorkbook(fin);

		Sheet s = w.getSheet("Students");

		int p = s.getPhysicalNumberOfRows();

		System.out.println("No. of Rows:" + p);

		Row r = s.getRow(0);

		int pCells = r.getPhysicalNumberOfCells();

		System.out.println("No. of Cells:" + pCells);
	}
}

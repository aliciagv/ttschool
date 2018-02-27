package com.acilia.ttschool.utils;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelUtils {

	
	public static CellStyle setSytleHeaderCell(Workbook workbook) {

		CellStyle styleheader = workbook.createCellStyle();

		Font headerFont = workbook.createFont();
		headerFont.setColor(HSSFColor.WHITE.index);
		headerFont.setFontHeightInPoints((short) 12);
		headerFont.setFontName("Comic Sans MS");
		
		styleheader.setFillForegroundColor(HSSFColor.BLUE_GREY.index);
		styleheader.setFillPattern(CellStyle.SOLID_FOREGROUND);
		styleheader.setFont(headerFont);
		styleheader.setAlignment(CellStyle.ALIGN_CENTER);

		return styleheader;
	}
	
	public static CellStyle setSytleContentCell(Workbook workbook) {

		CellStyle stylecontent = workbook.createCellStyle();
		
		Font contentFont = workbook.createFont();
		contentFont.setColor(HSSFColor.BLACK.index);
		contentFont.setFontHeightInPoints((short) 10);
		contentFont.setFontName("Comic Sans MS");
		
		stylecontent.setFont(contentFont);
		stylecontent.setAlignment(CellStyle.ALIGN_CENTER);

		return stylecontent;
	}
}

package com.acilia.ttschool.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.acilia.ttschool.model.ProfesorModel;

@Component("alumnosListExcel")
public class AlumnosListExcel extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		// change the file name
		Date now = new Date();
        response.setHeader("Content-Disposition", "attachment; filename=\"profesores"+now.toString()+".xls\"");
		
	    @SuppressWarnings("unchecked")
		List<ProfesorModel> listProfesorModel =  (List<ProfesorModel>) model.get("profesores");

	    Sheet sheet=  workbook.createSheet("Profesores");
	   
	    CellStyle styleheader = setSytleHeaderCell(workbook);
	    setExcelHeader(sheet, styleheader);
	    
	    setExcelRows(sheet,listProfesorModel);
	    
	 // create style for header cells
        
        
		Font contentFont =  workbook.createFont();
		contentFont.setColor(HSSFColor.BLACK.index);
		contentFont.setFontHeight((short)10);
        
		
		
	}

	private CellStyle setSytleHeaderCell(Workbook workbook) {

		CellStyle styleheader = workbook.createCellStyle();

		Font headerFont = workbook.createFont();
		headerFont.setFontName("Comic Sans MS");
		headerFont.setColor(HSSFColor.WHITE.index);
		headerFont.setFontHeight((short) 14);

		styleheader.setFont(headerFont);

		return styleheader;
	}

	private void setExcelHeader(Sheet excelSheet, CellStyle styleheader) {
		Row excelHeader = excelSheet.createRow(0);

		excelHeader.createCell(0).setCellValue("Id");
		//excelHeader.getCell(0).setCellStyle(styleheader);

		excelHeader.createCell(1).setCellValue("Nombre");
		//excelHeader.getCell(1).setCellStyle(styleheader);

		excelHeader.createCell(2).setCellValue("Apellidos");
		//excelHeader.getCell(2).setCellStyle(styleheader);

		excelHeader.createCell(3).setCellValue("Nif");
		//excelHeader.getCell(3).setCellStyle(styleheader);

	}

	private void setExcelRows(Sheet excelSheet, List<ProfesorModel> listProfesorModel) {
		int record = 1;
		for (ProfesorModel profesor : listProfesorModel) {
			Row excelRow = excelSheet.createRow(record++);
			excelRow.createCell(0).setCellValue(profesor.getIdPersona().toString());
			excelRow.createCell(1).setCellValue(profesor.getNombre());
			excelRow.createCell(2).setCellValue(profesor.getApellidos());
			excelRow.createCell(3).setCellValue(profesor.getNif());

		}
	}

}

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

import com.acilia.ttschool.model.CursoModel;
import com.acilia.ttschool.model.ProfesorModel;
import com.acilia.ttschool.utils.ExcelUtils;

@Component("cursoListExcel")
public class CursoListExcel extends AbstractXlsView {

	private static final int numfil = 4;
	
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		// change the file name
		Date now = new Date();
        response.setHeader("Content-Disposition", "attachment; filename=\"cursos"+now.toString()+".xls\"");
		
	    @SuppressWarnings("unchecked")
		List<CursoModel> listCursoModel =  (List<CursoModel>) model.get("cursos");

	    Sheet sheet=  workbook.createSheet("Cursos");
	   
	    CellStyle styleheader = ExcelUtils.setSytleHeaderCell(workbook);
	    setExcelHeader(sheet, styleheader);
	    
	    CellStyle stylecontent = ExcelUtils.setSytleContentCell(workbook);
	    setExcelRows(sheet,listCursoModel,stylecontent);

	    for (int i = 0; i < numfil; sheet.autoSizeColumn(i++))
			;
		
		
	}


	private void setExcelHeader(Sheet excelSheet, CellStyle styleheader) {
		Row excelHeader = excelSheet.createRow(0);

		excelHeader.createCell(0).setCellValue("Id");
		excelHeader.getCell(0).setCellStyle(styleheader);

		excelHeader.createCell(1).setCellValue("Nombre");
		excelHeader.getCell(1).setCellStyle(styleheader);

		excelHeader.createCell(2).setCellValue("Letra");
		excelHeader.getCell(2).setCellStyle(styleheader);

		excelHeader.createCell(3).setCellValue("Descripción");
		excelHeader.getCell(3).setCellStyle(styleheader);

	}

	private void setExcelRows(Sheet excelSheet, List<CursoModel> listCursoModel,CellStyle stylecontent) {
		int record = 1;
		for (CursoModel curso : listCursoModel) {
			Row excelRow = excelSheet.createRow(record++);
			excelRow.createCell(0).setCellValue(curso.getIdCurso().toString());
			excelRow.getCell(0).setCellStyle(stylecontent);
			excelRow.createCell(1).setCellValue(curso.getNombre());
			excelRow.getCell(1).setCellStyle(stylecontent);
			excelRow.createCell(2).setCellValue(curso.getLetra());
			excelRow.getCell(2).setCellStyle(stylecontent);
			excelRow.createCell(3).setCellValue(curso.getDescripcion());
			excelRow.getCell(3).setCellStyle(stylecontent);

		}
	}

}

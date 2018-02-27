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
import com.acilia.ttschool.utils.ExcelUtils;

@Component("profesoresListExcel")
public class ProfesoresListExcel extends AbstractXlsView {

	private static final int numfil = 8;

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		// change the file name
		Date now = new Date();
		response.setHeader("Content-Disposition", "attachment; filename=\"profesores" + now.toString() + ".xls\"");

		@SuppressWarnings("unchecked")
		List<ProfesorModel> listProfesorModel = (List<ProfesorModel>) model.get("profesores");

		Sheet sheet = workbook.createSheet("Profesores");

		CellStyle styleheader = ExcelUtils.setSytleHeaderCell(workbook);
		setExcelHeader(sheet, styleheader);

		CellStyle stylecontent = ExcelUtils.setSytleContentCell(workbook);
		setExcelRows(sheet, listProfesorModel, stylecontent);

		for (int i = 0; i < numfil; sheet.autoSizeColumn(i++))
			;

	}

	private void setExcelHeader(Sheet excelSheet, CellStyle styleheader) {
		Row excelHeader = excelSheet.createRow(0);

		excelHeader.createCell(0).setCellValue("Id");
		excelHeader.getCell(0).setCellStyle(styleheader);

		excelHeader.createCell(1).setCellValue("Nombre");
		excelHeader.getCell(1).setCellStyle(styleheader);

		excelHeader.createCell(2).setCellValue("Apellidos");
		excelHeader.getCell(2).setCellStyle(styleheader);

		excelHeader.createCell(3).setCellValue("Nif");
		excelHeader.getCell(3).setCellStyle(styleheader);

		excelHeader.createCell(4).setCellValue("Curso");
		excelHeader.getCell(4).setCellStyle(styleheader);

		excelHeader.createCell(5).setCellValue("Letra");
		excelHeader.getCell(5).setCellStyle(styleheader);

		excelHeader.createCell(6).setCellValue("Teléfonos");
		excelHeader.getCell(6).setCellStyle(styleheader);

		excelHeader.createCell(7).setCellValue("Emails");
		excelHeader.getCell(7).setCellStyle(styleheader);

	}

	private void setExcelRows(Sheet excelSheet, List<ProfesorModel> listProfesorModel, CellStyle stylecontent) {
		int record = 1;
		for (ProfesorModel profesor : listProfesorModel) {
			Row excelRow = excelSheet.createRow(record++);
			excelRow.createCell(0).setCellValue(profesor.getIdPersona().toString());
			excelRow.getCell(0).setCellStyle(stylecontent);
			excelRow.createCell(1).setCellValue(profesor.getNombre());
			excelRow.getCell(1).setCellStyle(stylecontent);
			excelRow.createCell(2).setCellValue(profesor.getApellidos());
			excelRow.getCell(2).setCellStyle(stylecontent);
			excelRow.createCell(3).setCellValue(profesor.getNif());
			excelRow.getCell(3).setCellStyle(stylecontent);
			if (profesor.getCurso() != null && profesor.getCurso().getIdCurso() != null) {
				excelRow.createCell(4).setCellValue(profesor.getCurso().getNombre());
				excelRow.getCell(4).setCellStyle(stylecontent);
				excelRow.createCell(5).setCellValue(profesor.getCurso().getLetra());
				excelRow.getCell(5).setCellStyle(stylecontent);
			}
			
			boolean add = false;
			if (profesor.getTelefonos() != null && profesor.getTelefonos().size() > 0) {
				StringBuilder telefono = new StringBuilder();
				for (int i = 0; i < profesor.getTelefonos().size(); i++) {
					if (profesor.getTelefonos().get(i) != null
							&& !profesor.getTelefonos().get(i).getNumero().equalsIgnoreCase("")) {
						if (telefono.length() > 0)
							telefono.append(",");
						telefono.append(profesor.getTelefonos().get(i).getNumero());
						add = true;
					}

				}
				if (add) {
					excelRow.createCell(6).setCellValue(telefono.toString());
					excelRow.getCell(6).setCellStyle(stylecontent);
				}
			}
			add = false;
			if (profesor.getEmails() != null && profesor.getEmails().size() > 0) {
				StringBuilder email = new StringBuilder();
				for (int i = 0; i < profesor.getEmails().size(); i++) {
					if (profesor.getEmails().get(i) != null
							&& !profesor.getEmails().get(i).getEmail().equalsIgnoreCase("")) {
						if (email.length() > 0)
							email.append(",");
						email.append(profesor.getEmails().get(i).getEmail());
						add = true;
					}
				}
				if (add) {
					excelRow.createCell(7).setCellValue(email.toString());
					excelRow.getCell(7).setCellStyle(stylecontent);
				}
			}
			

		}
	}

}

package com.acilia.ttschool.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.acilia.ttschool.model.AlumnoModel;
import com.acilia.ttschool.utils.ExcelUtils;

@Component("alumnosListExcel")
public class AlumnosListExcel extends AbstractXlsView {

	private static final int numfil = 10;

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		// change the file name
		Date now = new Date();
		response.setHeader("Content-Disposition", "attachment; filename=\"alumnos" + now.toString() + ".xls\"");

		@SuppressWarnings("unchecked")
		List<AlumnoModel> listProfesorModel = (List<AlumnoModel>) model.get("alumnos");

		Sheet sheet = workbook.createSheet("Alumnos");

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

		excelHeader.createCell(6).setCellValue("Dirección");
		excelHeader.getCell(6).setCellStyle(styleheader);

		excelHeader.createCell(7).setCellValue("Fecha de nacimiento");
		excelHeader.getCell(7).setCellStyle(styleheader);

		excelHeader.createCell(8).setCellValue("Teléfonos");
		excelHeader.getCell(8).setCellStyle(styleheader);

		excelHeader.createCell(9).setCellValue("Emails");
		excelHeader.getCell(9).setCellStyle(styleheader);

	}

	private void setExcelRows(Sheet excelSheet, List<AlumnoModel> listAlumnoModel, CellStyle stylecontent) {
		int record = 1;
		for (AlumnoModel alumno : listAlumnoModel) {
			Row excelRow = excelSheet.createRow(record++);
			excelRow.createCell(0).setCellValue(alumno.getIdPersona().toString());
			excelRow.getCell(0).setCellStyle(stylecontent);
			excelRow.createCell(1).setCellValue(alumno.getNombre());
			excelRow.getCell(1).setCellStyle(stylecontent);
			excelRow.createCell(2).setCellValue(alumno.getApellidos());
			excelRow.getCell(2).setCellStyle(stylecontent);
			excelRow.createCell(3).setCellValue(alumno.getNif());
			excelRow.getCell(3).setCellStyle(stylecontent);
			if (alumno.getCurso() != null && alumno.getCurso().getIdCurso() != null) {
				excelRow.createCell(4).setCellValue(alumno.getCurso().getNombre());
				excelRow.getCell(4).setCellStyle(stylecontent);
				excelRow.createCell(5).setCellValue(alumno.getCurso().getLetra());
				excelRow.getCell(5).setCellStyle(stylecontent);
			}
			excelRow.createCell(6).setCellValue(alumno.getDireccion());
			excelRow.getCell(6).setCellStyle(stylecontent);
			if (alumno.getfNacimiento() != null && !alumno.getfNacimiento().equalsIgnoreCase("")) {
				excelRow.createCell(7).setCellValue(alumno.getfNacimiento());
				excelRow.getCell(7).setCellStyle(stylecontent);
			}

			boolean add = false;
			if (alumno.getTelefonos() != null && alumno.getTelefonos().size() > 0) {
				StringBuilder telefono = new StringBuilder();
				for (int i = 0; i < alumno.getTelefonos().size(); i++) {
					if (alumno.getTelefonos().get(i) != null
							&& !alumno.getTelefonos().get(i).getNumero().equalsIgnoreCase("")) {
						if (telefono.length() > 0)
							telefono.append(",");
						telefono.append(alumno.getTelefonos().get(i).getNumero());
						add = true;
					}

				}
				if (add) {
					excelRow.createCell(8).setCellValue(telefono.toString());
					excelRow.getCell(8).setCellStyle(stylecontent);
				}
			}
			add = false;
			if (alumno.getEmails() != null && alumno.getEmails().size() > 0) {
				StringBuilder email = new StringBuilder();
				for (int i = 0; i < alumno.getEmails().size(); i++) {
					if (alumno.getEmails().get(i) != null
							&& !alumno.getEmails().get(i).getEmail().equalsIgnoreCase("")) {
						if (email.length() > 0)
							email.append(",");
						email.append(alumno.getEmails().get(i).getEmail());
						add = true;
					}
				}
				if (add) {
					excelRow.createCell(9).setCellValue(email.toString());
					excelRow.getCell(9).setCellStyle(stylecontent);
				}
			}

		}
	}

}

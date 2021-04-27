package com.india.Spring.Excel;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.india.Spring.Model.Book;

public class ExcelBuilder extends AbstractExcelView 
{
	
	private static final String CONTENT_TYPE_XLSX="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	
	private String name;
	
	public void setName(String name)
	{
		this.name=name;
	}
	public String getName()
	{
		return name;
	}
	
	public void buildExcelDocument(Map<String,Object>model,HSSFWorkbook workbook,HttpServletRequest req,HttpServletResponse res) throws Exception
	{
		
		res.setHeader("content-Disposition","Attachement;filename="+ name +".xls");
		res.setContentType(CONTENT_TYPE_XLSX);
		
		List<Book> listbooks=(List<Book>)model.get("list");
		HSSFSheet sheet=workbook.createSheet("Ebook");
		
		for(int columnindex=0;columnindex < 2000 ;columnindex++)
		{
			sheet.autoSizeColumn(columnindex);
		}
		
		CellStyle style=workbook.createCellStyle();
		Font font=workbook.createFont();
		font.setFontName("Arial");
		style.setFont(font);
		
		HSSFRow header=sheet.createRow(0);
		header.createCell(0).setCellValue("ID");
		header.getCell(0).setCellStyle(style);
		
		header.createCell(1).setCellValue("Title");
		header.getCell(1).setCellStyle(style);
		
		header.createCell(2).setCellValue("Author");
		header.getCell(2).setCellStyle(style);
		
		header.createCell(3).setCellValue("PublishedDate");
		header.getCell(3).setCellStyle(style);
		
		header.createCell(4).setCellValue("Price");
		header.getCell(4).setCellStyle(style);
		
		int count=1;
		
		for (Book b:listbooks)
		{
			HSSFRow row=sheet.createRow(count++);
			row.createCell(0).setCellValue(b.getId());
			row.createCell(1).setCellValue(b.getTitle());
			row.createCell(2).setCellValue(b.getAuthor());
			row.createCell(3).setCellValue(b.getPublishdate());
			row.createCell(4).setCellValue(b.getPrice());
		}	
	}
}

package com.india.Spring.PDF;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.india.Spring.Model.Book;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfBuilder extends AbstractTextPdf
{
	
	
	public void buildPdfDocument(Map<String,Object>model,Document doc,PdfWriter writer,HttpServletRequest req,HttpServletResponse res) throws Exception
	{
		
		List<Book> listbooks=(List<Book>)model.get("list");
		Paragraph title=new Paragraph("List of Books");
		title.setAlignment(Element.ALIGN_CENTER);
		doc.add(title);
		
		PdfPTable table=new PdfPTable(5);
		table.setWidthPercentage(100.00f);
		table.setWidths(new float[] {1.0f,2.0f,2.0f,3.0f,2.0f});
		table.setSpacingBefore(10);
		
		Font font=FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setColor(BaseColor.BLACK);
		
		PdfPCell cell=new PdfPCell();
		cell.setBackgroundColor(BaseColor.CYAN);
		cell.setPadding(5);
		
		cell.setPhrase(new Phrase("ID",font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Title",font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Author",font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("PublishedDate",font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Price",font));
		table.addCell(cell);
		
		
		for(Book b:listbooks)
		{
			table.addCell(String.valueOf(b.getId()));
			table.addCell(b.getTitle());
			table.addCell(b.getAuthor());
			table.addCell(b.getPublishdate());
			table.addCell(String.valueOf(b.getPrice()));
		}
		doc.add(table);
		
	}

}

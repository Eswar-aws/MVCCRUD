package com.india.Spring.PDF;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

public abstract class AbstractTextPdf extends AbstractView
{
	public AbstractTextPdf()
	{
		setContentType("application/pdf");
	}
	 protected boolean generateDownloadContent()
	 {
		 return true;
	 }
	 protected void renderMergedOutputModel(Map<String,Object> model,HttpServletRequest req,HttpServletResponse res) throws Exception
	 {
		 ByteArrayOutputStream bao=createTemporaryOutputStream();
	 
		 //Apply preferences
		 Document doc=newDocument();
		 PdfWriter writer=newWriter(doc,bao);
		 prepareWriter(model,writer,req);
		 buildPdfMetaData(model,doc,req);
		 
		 //Build PDF Document
		 doc.open();
		 buildPdfDocument(model,doc,writer,req,res);
		 doc.close();
		 
		 writeToResponse(res,bao);
	 }
	 protected Document newDocument()
	 {
		 return new Document(PageSize.A4);
	 }
	 protected PdfWriter newWriter(Document doc,OutputStream os) throws DocumentException
	 {
		 return PdfWriter.getInstance(doc,os);	 
	 }
	 public void prepareWriter(Map<String,Object>model,PdfWriter writer,HttpServletRequest req) throws DocumentException
	 {
		 writer.setViewerPreferences(getViewerPreferences());
	 }
	 
	 public int getViewerPreferences()
	 {
		 return PdfWriter.ALLOW_PRINTING | PdfWriter.PageLayoutSinglePage ;
	 }
	 public void buildPdfMetaData(Map<String,Object> model,Document doc,HttpServletRequest req) 
	 {
		 
	 }
	 protected abstract void buildPdfDocument(Map<String,Object> model,Document doc,PdfWriter writer,HttpServletRequest req,HttpServletResponse res) throws Exception ;
	
}

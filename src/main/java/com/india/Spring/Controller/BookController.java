package com.india.Spring.Controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.india.Spring.Model.Book;
import com.india.Spring.Service.BookService;

@Controller
public class BookController {
	@Autowired
	private BookService bookService;
	
	@RequestMapping(value="/home")
	public String home(Model m)
	{
		Book b=new Book();
		m.addAttribute("book",b);
		return "BookForm";
	}
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String sav(@ModelAttribute Book book,BindingResult rs)
	{
		bookService.save(book);
		return "redirect:/viewAll";
	}
	
	@RequestMapping(value="/edit/{sno}")
	public String editf(@PathVariable int sno,Model m)
	{
		m.addAttribute("book",bookService.getId(sno));
		
		return "EditForm";
	}
	
	@RequestMapping(value="/editsave",method=RequestMethod.POST)
	public String editsav(@ModelAttribute("book") Book book)
	{
		bookService.update(book);
		return "redirect:/viewAll";
	}
	
	@RequestMapping(value="/delete/{sno}",method=RequestMethod.GET)	
	public String delet(@PathVariable int sno)
	{
		bookService.delete(sno);
		return "redirect:/viewAll";
	}
	
	@RequestMapping(value="/viewAll")
	public String viewAll(Model m)
	{
		List<Book> list=bookService.getAll();
		m.addAttribute("list",list);
		return "Viewbook";
	}
	
	@RequestMapping(value="/excel",method=RequestMethod.GET)
	public String ExcelView(HttpServletRequest req,HttpServletResponse res,Model m) throws ServletRequestBindingException
	{
		List<Book> list=bookService.getAll();
		m.addAttribute("list",list);
		return "excelView";
	}
	
	@RequestMapping(value="/pdf",method=RequestMethod.GET)
	public String PdfView(HttpServletRequest req,HttpServletResponse res,Model m) throws ServletRequestBindingException
	{
		List<Book> list=bookService.getAll();
		m.addAttribute("list",list);
		return "pdfView";
	}

	@RequestMapping(value="/search")
	public String searcha(@RequestParam String keyword,Model m)
	{
		List<Book> list1=bookService.search(keyword);
		m.addAttribute("list1",list1);
		return "searchform";
	}
	
	}
	


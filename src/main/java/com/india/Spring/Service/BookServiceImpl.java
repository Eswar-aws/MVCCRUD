package com.india.Spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.india.Spring.Dao.BookDao;
import com.india.Spring.Model.Book;

public class BookServiceImpl implements BookService 
{
	
	@Autowired
	private BookDao bookDao;
	
	public void save(Book book)
	{
		bookDao.save(book);
	}
	public void update(Book book)
	{
		bookDao.update(book);
	}
	public Book getId(int sno)
	{
		return bookDao.getId(sno);
	}
	public void delete(int sno)
	{
		bookDao.delete(sno);
	}
	public List<Book> getAll()
	{
		return bookDao.getAll();
	}
	public List<Book> search(String keyword)
	{
		return bookDao.search(keyword);
	}
}

package com.india.Spring.Service;

import java.util.List;

import com.india.Spring.Model.Book;

public interface BookService 
{
	public void save(Book book);
	public Book getId(int sno);
	public List<Book> getAll();
	public void delete(int sno);
	public void update(Book book);
	public List<Book> search(String keyword);
}

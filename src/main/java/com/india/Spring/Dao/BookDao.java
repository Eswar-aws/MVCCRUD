package com.india.Spring.Dao;

import java.util.List;

import com.india.Spring.Model.Book;

public interface BookDao {
	
	public void save(Book book);
	public void update(Book book);
	public Book getId(int sno);
	public void delete(int sno);
	public List<Book> getAll();
	public List<Book> search(String keyword);

}

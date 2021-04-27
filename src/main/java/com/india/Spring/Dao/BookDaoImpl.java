package com.india.Spring.Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.india.Spring.Model.Book;

public class BookDaoImpl implements BookDao
{
	@Autowired
	private SessionFactory sessionFactory;
	
	public BookDaoImpl()
	{
		
	}
	public BookDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public void save(Book book)
	{
		Session session=sessionFactory.getCurrentSession();
		session.save(book);
	}
	
	@Transactional
	public void update(Book book)
	{
		Session session=sessionFactory.getCurrentSession();
		session.update(book);
	}
	
	@Transactional
	public Book getId(int sno)
	{
		Session session=sessionFactory.getCurrentSession();
		Book book=(Book)session.get(Book.class,new Integer(sno));
		return book;
	}
	
	@Transactional
	public void delete(int sno)
	{
		Session session=sessionFactory.getCurrentSession();
		Book book=(Book)session.load(Book.class,new Integer(sno));
		session.delete(book);
	}
	
	@Transactional
	public List<Book> getAll()
	{
		Session session=sessionFactory.getCurrentSession();
		Query qry=session.createQuery("from Book");
		List l=qry.list();
		return l;
	}
	
	@Transactional
	public List<Book> search(String keyword)
	{
		Session session=sessionFactory.getCurrentSession();
		Query qry=session.createQuery("from Book b where b.id LIKE '%"+keyword+"%'"+ "OR b.title LIKE '%"+keyword+"%'"+ "OR b.author LIKE '%"+keyword+"%'"+ "OR b.publishdate LIKE '%"+keyword+"%'"+ "OR b.price LIKE '%"+keyword+"%'");
		List l=qry.list();
		return l;
	}
}

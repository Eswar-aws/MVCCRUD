package com.india.Spring.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bookcsv")
public class Book 
{
	public Book()
	{
		
	}
	public Book(int sno,int id,String title,String author,String publishdate,float price)
	{
		this.sno=sno;
		this.id=id;
		this.title=title;
		this.author=author;
		this.publishdate=publishdate;
		this.price=price;
	}
	
	@Id
	@GeneratedValue
	private int sno;
	
	private int id;
	private String title;
	private String author;
	private String publishdate;
	private float price;
	
	public void setSno(int sno)
	{
		this.sno=sno;
	}
	public int getSno()
	{
		return sno;
	}
	
	public void setId(int id)
	{
		this.id=id;
	}
	public int getId()
	{
		return id;
	}
	public void setTitle(String title)
	{
		this.title=title;
	}
	public String getTitle()
	{
		return this.title=title;
	}
	public void setAuthor(String author)
	{
		this.author=author;
	}
	public String getAuthor()
	{
		return author;
	}
	public void setPublishdate(String publishdate)
	{
		this.publishdate=publishdate;
	}
	public String getPublishdate()
	{
		return publishdate;
	}
	public void setPrice(float price)
	{
		this.price=price;
	}
	public float getPrice()
	{
		return price;
	}
}

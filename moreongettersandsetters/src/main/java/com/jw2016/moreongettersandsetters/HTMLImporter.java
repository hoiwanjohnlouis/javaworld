package com.jw2016.moreongettersandsetters;

import javax.servlet.ServletRequest;

class HTMLImporter implements Employee.Importer
{	ServletRequest request;

	public void open() { /*nothing to do*/ }
	public void close(){ /*nothing to do*/ }

	public HTMLImporter( ServletRequest request )
	{	this.request = request;	
	}
	public String provideName()
	{	return request.getParameter("name");
	}
	public String provideID()
	{	return request.getParameter("id");
	}
	public String provideSalary()
	{	return request.getParameter("salary");
	}
}

/***********************************************************************
 * Stub for debugging. The ServletRequstAdapter (not shown) just
 * implements every method of the {@link javax.servlet.ServletRequest}
 * interface to throw an {@link UnsupportedOperationException}.
 */

class MyServletRequest extends com.holub.servlet.ServletRequestAdapter
{
	String name, id, salary;

	public MyServletRequest( String name, String id, String salary )
	{	this.name   = name;
		this.id	    = id;
		this.salary = salary;
	}

	public String getParameter( String requested )
	{	if( requested.equals("name")		) return name;
		else if( requested.equals("id")		) return id;
		else if( requested.equals("salary") ) return salary;
		else throw new Error("Unexpected Paramether");
	}
}

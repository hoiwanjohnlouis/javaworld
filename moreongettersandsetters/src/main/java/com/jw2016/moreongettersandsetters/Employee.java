package com.jw2016.moreongettersandsetters;

import java.util.Locale;

public class Employee
{	private Name		name;
	private EmployeeId	id;
	private Money		salary;

	public interface Exporter
	{	void addName	( String name   );
		void addID  	( String id     );
		void addSalary	( String salary );
	}

	public interface Importer
	{	String provideName();
		String provideID();
		String provideSalary();
		void   open();
		void   close();
	}

	public Employee( Importer builder )
	{	builder.open();
		this.name   = new Name		( builder.provideName()		);
		this.id		= new EmployeeId( builder.provideID()		);
		this.salary = new Money		( builder.provideSalary(),
								  new Locale("en", "US") );
		builder.close();
	}

	public void export( Exporter builder )
	{	builder.addName	 ( name.toString()   );
		builder.addID  	 ( id.toString()     );
		builder.addSalary( salary.toString() );
	}

	//...
}
//----------------------------------------------------------------------
// Unit-test stuff
//
class Name
{	private String value;
	public Name( String value )
	{	this.value = value;
	}
	public String toString(){ return value; };
}

class EmployeeId
{	private String value;
	public EmployeeId( String value )
	{	this.value = value;
	}
	public String toString(){ return value; }
}

class Money
{	private String value;
	public Money( String value, Locale location )
	{	this.value = value;
	}
	public String toString(){ return value; }
}

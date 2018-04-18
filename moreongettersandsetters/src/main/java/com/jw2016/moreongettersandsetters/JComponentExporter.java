package com.jw2016.moreongettersandsetters;

import com.jw2016.moreongettersandsetters.Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class JComponentExporter implements Employee.Exporter
{	private String name, id, salary;

	public void addName	 ( String name   ){	this.name = name;	  }
	public void addID	 ( String id 	 ){	this.id = id; 		  }
	public void addSalary( String salary ){	this.salary = salary; }

	JComponent getJComponent()
	{	JComponent panel = new JPanel();	
		panel.setLayout( new GridLayout(3,2) );
		panel.add( new JLabel("Name:  ") );
		panel.add( new JLabel( name ) );
		panel.add( new JLabel("Employee ID:  ") );
		panel.add( new JLabel( id ) );
		panel.add( new JLabel("Salary:  ") );
		panel.add( new JLabel( salary ) );
		return panel;
	}
}

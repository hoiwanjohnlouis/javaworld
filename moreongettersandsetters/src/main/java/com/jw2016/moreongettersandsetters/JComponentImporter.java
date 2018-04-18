package com.jw2016.moreongettersandsetters;

import com.jw2016.moreongettersandsetters.Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class JComponentImporter implements Employee.Importer
{
	private	JTextField	name   = new JTextField(20);
	private	JTextField	id     = new JTextField(20);
	private	JTextField	salary = new JTextField(20);
	private JDialog	frame;

	public JComponentImporter( Frame parent )
	{  frame = new JDialog( parent, "Test Input", true );
	}

	public void open()
	{
		Container content = frame.getContentPane();
		content.setLayout( new GridLayout(4,2) );
		content.add( new JLabel("Name:  ") );
		content.add(  name );
		content.add( new JLabel("Employee ID:  ") );
		content.add(  id );
		content.add( new JLabel("Salary:  ") );
		content.add(  salary );

		JButton okay = new JButton("Okay");
		okay.addActionListener
		(	new ActionListener()
			{	public void actionPerformed(ActionEvent e)
				{	frame.dispose();
				}
			}
		);
		content.add(new JLabel(""));	// place holder
		content.add(okay);

		frame.pack();
		frame.show();
	}

	public String provideName()		{	return name.getText(); 	 }
	public String provideID()		{	return id.getText(); 	 }
	public String provideSalary()	{	return salary.getText(); }

	public void close()
	{	name = id = salary = null;
	}
}

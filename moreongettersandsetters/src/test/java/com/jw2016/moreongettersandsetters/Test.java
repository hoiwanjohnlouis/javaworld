package com.jw2016.moreongettersandsetters;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Test
{	public static void main( String[] args )
	{	
		Employee fred = new Employee(
							new HTMLImporter(
								new MyServletRequest("Fred","1","100.00") ));

		HTMLExporter htmlBuilder = new HTMLExporter();
		fred.export( htmlBuilder );
		System.out.println( htmlBuilder.extractHTML() );

		// Create a small frame to use as a parent for the input
		// test.
		JFrame parent = new JFrame("Test-Input Frame");
		parent.getContentPane().add( new JLabel("Empty") );
		parent.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		parent.pack();
		parent.show();
		
		Employee wilma = new Employee( new JComponentImporter(parent) );

		JComponentExporter uiBuilder = new JComponentExporter();
		wilma.export( uiBuilder );

		JFrame outputFrame = new JFrame("First Output");
		outputFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		outputFrame.getContentPane().add( uiBuilder.getJComponent() );
		outputFrame.pack();
		outputFrame.show();

		//-------------------------------------------------------------
		EmployeeUI ui = new EmployeeUI();	
		wilma.export( ui );

		outputFrame = new JFrame("Second Output");
		outputFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		outputFrame.getContentPane().add( ui );
		outputFrame.pack();
		outputFrame.show();
	}
}

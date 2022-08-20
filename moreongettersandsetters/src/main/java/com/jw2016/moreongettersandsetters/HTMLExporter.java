package com.jw2016.moreongettersandsetters;

// import com.jw2016.moreongettersandsetters.Employee;

/** This particular importer creates only that part of the
 *  HTML page that represents attrubutes of the Employee.
 *  The surrounding context (the &lt;html&gt; tags, etc.) is
 *  created elsewhere.
 */

class HTMLExporter implements Employee.Exporter
{	
	private final String 	   HEADER = "<table border=\"0\">\n";
	private final StringBuffer out = new StringBuffer(HEADER);

	public void addName( String name )
	{	out.append( "\t<tr><td>" );
		out.append( "Name:");
		out.append( "</td><td>" );
		out.append( "<input type=\"text\" name=\"name\" value=\"" );
		out.append( name );
		out.append( "\">");
		out.append( "</td></tr>\n" );
	}
	public void addID( String id     )
	{	out.append( "\t<tr><td>" );
		out.append( "Employee ID:");
		out.append( "</td><td>" );
		out.append( "<input type=\"text\" name=\"id\" value=\"" );
		out.append( id );
		out.append( "\">");
		out.append( "</td></tr>\n" );
	}
	public void addSalary( String salary )
	{	out.append( "\t<tr><td>" );
		out.append( "Salary:");
		out.append( "</td><td>" );
		out.append( "<input type=\"text\" name=\"salary\" value=\"" );
		out.append( salary );
		out.append( "\">");
		out.append( "</td></tr>\n" );
	}
	String extractHTML()
	{	out.append("</table>");
		String toReturn = out.toString();
		out.setLength(0);					// erase the buffer
		out.append(HEADER);
		return toReturn;
	}
}

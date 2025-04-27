/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eCA;
import java.sql.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import java.text.*;

public class EmailRepBodyTxtBean  implements java.io.Serializable
 { 

	String editor_content;
	String report_text;
	public EmailRepBodyTxtBean()
	{
		editor_content="";
		report_text="";
	}
	public void setEditorContent(String editor_content)
	{

		this.editor_content = editor_content;
	}
	public String getEditorContent()	
	{

		return this.editor_content;
	}
	
	public void setReportText(String report_text1)
	{

		this.report_text = report_text1;

	}
	public String getReportText()	
	{

		return this.report_text;
	}

	public void clearBean()
	{
		editor_content="";
		report_text="";
	}
}

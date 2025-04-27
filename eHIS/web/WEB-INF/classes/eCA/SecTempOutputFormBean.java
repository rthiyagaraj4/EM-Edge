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

public class SecTempOutputFormBean  implements java.io.Serializable
 { 

	String editor_content;
	public SecTempOutputFormBean()
	{
		editor_content="";
	}
	public void setEditorContent(String editor_content)
	{

		this.editor_content = editor_content;
	}
	public String getEditorContent()	
	{

		return this.editor_content;
	}
	public void clearBean()
	{
		editor_content="";
	}

	
}

/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXH;

import java.io.*;
import java.util.*;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import javax.servlet.http.HttpSession;

import oracle.jdbc.driver.*;
import oracle.sql.*;

/**
 * Class is used to check which symbols are selected and find out the case.
 */
public class XHIdentify 
{

/**
 * Method checks which character is selected.
 */
public static int identify(int simplevalues)
{
	int [] simplevalue={35,36,37,124,94};

	int k;
	int opr=0;
	for(k=0;k<simplevalue.length;k++)
	{
		if(simplevalue[k]==simplevalues)
		{
			opr=k;                
		}	  
	}

   return opr; 
}

/**
 * Method fetches element ids and puts them into the hashmap.
 * These element ids will be used to element name in a tree structure
 */
public static HashMap treeHashMap(Connection conn,String locale)
{
   HashMap treeHash=new HashMap();
   String sql = "SELECT  ELEMENT_ID, ELEMENT_NAME  FROM XH_ELEMENT_CROSSREF_LANG_VW WHERE LANGUAGE_ID='"+locale+"' order by ELEMENT_NAME asc ";
   PreparedStatement pstmt = null;
   ResultSet rset = null;
   try
     { 
	   pstmt = conn.prepareStatement(sql);
	   rset = pstmt.executeQuery();
	   while(rset.next())
	   {
			treeHash.put(rset.getString(1),rset.getString(2)) ;
       } 
	   if(pstmt!=null) pstmt.close();
	   if(rset!=null)rset.close();
     }
	catch(Exception exp)
     {
	   System.out.println("Error in treeHashmap method of xhTreeHashmap :"+exp.toString());
	   exp.printStackTrace(System.err);
	 }
			return treeHash; 
}

public static String returnvalue(Clob c)
{
	String Request_text="";
	if (c == null) 
	{
	} 
	else {
		try 
		{
			String aux;
			BufferedReader br = new BufferedReader(c.getCharacterStream());
			while ((aux=br.readLine())!=null)
			{
				//Changed by prithivi on 10/2/2016
				Request_text=Request_text+aux.toString().trim();
				break;
			}
			br.close();
		} catch (java.sql.SQLException e1) {
			e1.printStackTrace();
		} catch (java.io.IOException e2) {
			e2.printStackTrace();
		}
	}
return Request_text;       
}

public static HashMap treeSegHashMap(Connection conn,String locale)
{
	HashMap treeseghash=new HashMap();
	//String sql = "SELECT  ELEMENT_ID, ELEMENT_NAME  FROM XH_ELEMENT_CROSSREF_LANG_VW WHERE LANGUAGE_ID='"+locale+"' order by ELEMENT_NAME asc ";
	String sql = "SELECT  SEGMENT_TYPE, SEGMENT_NAME  FROM XH_SEGMENT   order by SEGMENT_NAME asc ";
	PreparedStatement pstmt = null;
	ResultSet rset = null;
	try
	{ 
		pstmt = conn.prepareStatement(sql);
		rset = pstmt.executeQuery();
		while(rset.next())
		{
			treeseghash.put(rset.getString(1),rset.getString(2)) ;
		} 
		if(pstmt!=null) pstmt.close();
		if(rset!=null)rset.close();
	}
	catch(Exception exp)
	{
		System.out.println("Error in treeHashmap method of xhTreeHashmap :"+exp.toString());
		exp.printStackTrace(System.err);
	}
	return treeseghash; 
}

public static int getSize(Connection conn,String qry_string)
{
	ArrayList records=new ArrayList();
	int i = 0;
	PreparedStatement pstmt1 = null;
	ResultSet rset1 = null;
	try
	{ 
		pstmt1 = conn.prepareStatement(qry_string);
		rset1 = pstmt1.executeQuery();
		while(rset1.next())
		{
			records.add(i,rset1.getString(1));
			i++;
			//treeseghash.put(rset.getString(1),rset.getString(2)) ;
		} 
		if(pstmt1!=null) pstmt1.close();
		if(rset1!=null)rset1.close();
	}
	catch(Exception exp)
	{
		System.out.println("Error in treeHashmap method of xhTreeHashmap :"+exp.toString());
		exp.printStackTrace(System.err);
	}
	return i; 
}

}//end of class

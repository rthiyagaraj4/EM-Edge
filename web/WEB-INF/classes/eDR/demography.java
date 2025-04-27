/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eDR;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;


public class demography
{
	public String name_age_sex(HttpSession session,String patient_id,Connection con,String locale)
	{   
		
		PreparedStatement pstmt	= null;
		ResultSet rs			= null;

		StringBuffer SqlBuffer	= null;

		String name				= "";
		SqlBuffer				= new StringBuffer();
		
		SqlBuffer.append("select substr(get_patient_line(?,'"+locale+"'),1,length(get_patient_line(?,'"+locale+"'))-6)  Pline FROM dual");
		try
		{
			pstmt = con.prepareStatement(SqlBuffer.toString());
			pstmt.setString(1,patient_id);
			pstmt.setString(2,patient_id);
			rs	= pstmt.executeQuery();
			
			if(rs!=null && rs.next())
			{
				String s = rs.getString("Pline");
				StringTokenizer token = new StringTokenizer(s,"|");
				while(token.hasMoreTokens())
				{
					name = token.nextToken();
					token.nextToken();
				}
			} 
			if((SqlBuffer != null) && (SqlBuffer.length() > 0))
			{
				SqlBuffer.delete(0,SqlBuffer.length());
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();

		 }catch(Exception e){e.printStackTrace();}
		
		return name;
	}
			
	public String getname_age_sex(HttpSession session,String patient_id,Connection con,String locale)
	{
		PreparedStatement pstmt	= null;
		ResultSet rs			= null;

		StringBuffer SqlBuffer	= null;

		String name		= "";
		SqlBuffer		= new StringBuffer();

		SqlBuffer.append("select substr(get_patient_line(?,'"+locale+"'),1,length(get_patient_line(?,'"+locale+"'))-6)  Pline FROM dual");

		try
		{
			pstmt = con.prepareStatement(SqlBuffer.toString());
			pstmt.setString(1,patient_id);
			pstmt.setString(2,patient_id);
			rs = pstmt.executeQuery();

			if(rs != null && rs.next())
			{
				String s = rs.getString("Pline");
				StringTokenizer token = new StringTokenizer(s,"|");
				while(token.hasMoreTokens())
				{
					name = token.nextToken();
					token.nextToken();
				}
			} if(rs != null) rs.close(); pstmt = null;

			if((SqlBuffer != null) && (SqlBuffer.length() > 0))
			{
				SqlBuffer.delete(0,SqlBuffer.length());
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
		}catch(Exception e){e.printStackTrace();}
		
		return name;
	}
}

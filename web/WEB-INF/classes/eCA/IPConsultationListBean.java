/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-----------------------------------------------------------------------------------------------
Date       Edit History   Name        Description
-----------------------------------------------------------------------------------------------
?             100         ?           created
18/11/2011    IN29413    Dinesh T     ARTEMIS - Added the new method
-----------------------------------------------------------------------------------------------
*/
package eCA;
import java.io.*;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.text.*;
import eCommon.Common.*;

public class  IPConsultationListBean implements java.io.Serializable
{	
	ArrayList ConsList =new ArrayList();	
	
	public void addtoConsList(String value)
	{
		ConsList.add(value);
	}

	public void remFromConsList(String remVal)
	{  
		if((ConsList.contains(remVal)))
			ConsList.remove(remVal);		
	}

	public ArrayList returnConsList()
	{
		return ConsList;
	}
	
	public void clearBean()
	{		
	   ConsList = new ArrayList();
	}

	public String Bill_yn(String facility_id,String order_id,String order_line_num) throws Exception 
	{
		Connection connection 		= null;
		CallableStatement cstmt 	= null;
		String bill_charge_yn="";
		String error_code="";
		String sys_message_id="";
		String error_text="";
		try
		{ 				
			connection = ConnectionManager.getConnection();
			cstmt = connection.prepareCall("{ CALL BL_PROC_FOR_EXT_SERVICE_MP.CHECK_ORDERABLE_BILLED( ? ,? ,?, ?, ?, ?, ?, ?)}");
			cstmt.setString(1,facility_id.trim());
			cstmt.setString(2,"OR");
			cstmt.setString(3, order_id);
			cstmt.setString(4, order_line_num);
			cstmt.registerOutParameter( 5,  Types.VARCHAR ) ;
			cstmt.registerOutParameter( 6,  Types.VARCHAR ) ;
			cstmt.registerOutParameter( 7,  Types.VARCHAR ) ;
			cstmt.registerOutParameter( 8,  Types.VARCHAR ) ;
			cstmt.execute();
			bill_charge_yn=cstmt.getString(5);
			error_code=cstmt.getString(6);
			sys_message_id=cstmt.getString(7);
			error_text=cstmt.getString(8);			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			if(cstmt != null) 
				cstmt.close();
			ConnectionManager.returnConnection(connection);	
		}
		return bill_charge_yn;
	}
	//IN29413
	public String getPatientIDLength()
	{
		Connection connection 		= null;
		Statement patIdLenStmt 	= null;
		ResultSet patIdLenRs = null;
		String patientLength="";
		try
		{
			connection = ConnectionManager.getConnection();
			patIdLenStmt = connection.createStatement();
			patIdLenRs = patIdLenStmt.executeQuery(" SELECT PATIENT_ID_LENGTH FROM MP_PARAM ");
			while(patIdLenRs.next())
			{
				patientLength = patIdLenRs.getString("PATIENT_ID_LENGTH");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(patIdLenRs!=null)
					patIdLenRs.close();
				if(patIdLenStmt != null) 
					patIdLenStmt.close();
				ConnectionManager.returnConnection(connection);		
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		return patientLength;
	}
}

/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import eXH.XHUtil;
import webbeans.eCommon.ConnectionManager;

public class SSMonDPHelper
{
	public SSMonDPHelper()
	{
	}

	public List<HashMap> checkErrors(String processIDList)
	{
		Connection connection = null;
		Statement pstmt = null;
		ResultSet rs = null;
		HashMap<String,String> errData = null;
		List<HashMap> errList = null;

		String errorChkQry = "SELECT facility_id, national_id_no, patient_id, error_msg, process_id, to_char(process_date_time,'dd/mm/yyyy HH24:MI:SS') process_date_time FROM xf_ss_int_error_log WHERE process_id IN ('PROCESSMAIN','PROCESS_ACTIVE_SS','PROCESS_NEW_SS','SSUPLOAD_DATA')";

		try
		{
			if(connection == null) connection = ConnectionManager.getConnection();
			pstmt = connection.createStatement();
			
			rs = pstmt.executeQuery(errorChkQry);
			
			while(rs.next())
			{
				if(errList == null) errList = new ArrayList<HashMap>();
				errData = new HashMap<String,String>();
				String errMsg = rs.getString("error_msg");
				errMsg = errMsg.replaceAll("\"","");
				errMsg = errMsg.replaceAll("\\r|\\n", ";");
				errData.put("errMsg", errMsg);
				errData.put("facilityID", rs.getString("facility_id"));
				errData.put("natID", rs.getString("national_id_no"));
				errData.put("patID", rs.getString("patient_id"));
				errData.put("processID", rs.getString("process_id"));
				errData.put("processDate", rs.getString("process_date_time"));

				errList.add(errData);
			}
		}
		catch(Exception exp)
		{
			exp.printStackTrace(System.err);		
		}
		finally
		{
			try
			{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(connection != null) ConnectionManager.returnConnection(connection);
			}
			catch(Exception fexp)
			{
				fexp.printStackTrace(System.err);
			}
		}
		return errList;
	}
}

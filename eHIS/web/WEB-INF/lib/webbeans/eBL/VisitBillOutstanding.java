/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package blopin;
import java.io.* ;
import java.sql.* ;
import javax.rmi.*;
import java.util.*;
import java.sql.* ;

import webbeans.eCommon.*;

public class VisitBillOutstanding
{
	Connection conn;
	Hashtable hashData = new Hashtable();
	public java.util.Hashtable billPatientService( Connection con, Hashtable tabdata)
	{
		Hashtable returnTable = new Hashtable();	
		conn = con;
		hashData = tabdata;
		Double doubleOutStanding = new Double(outstandingBalance());
		returnTable.put("outstanding_amt",doubleOutStanding);
		returnTable.put("warning_or_error",actionOnVisitBill());
		return (returnTable);
	}

	
	private double outstandingBalance()
	{
		CallableStatement cs = null ;
		double balance=0.0d;
		try
		{
			String sql = "{call BL_VISIT_OUTST_AMT(?,?,?,?,?,?)}";			

			String episode_id=(String) hashData.get("episode_id");
			String visit_id=(String) hashData.get("visit_id");
			String facilityId = (String) hashData.get("facilityid");
			String p_patient_id = (String) hashData.get("patientid");
			String episode_type = (String) hashData.get("episode_type");

			if ( (episode_type == null)||(episode_type.equals("")) ) 
			      episode_type = "O";
			
			cs = conn.prepareCall(sql) ;
			cs.setString(1,facilityId) ;
			cs.setString(2,p_patient_id) ;
			//cs.setString(3,"O");   // Episode Type ENH
			cs.setString(3,episode_type);
			
			cs.setInt(4,Integer.parseInt(episode_id)) ;
			cs.setInt(5,Integer.parseInt(visit_id)) ;
			cs.registerOutParameter( 6,java.sql.Types.INTEGER);
			cs.execute();
			cs.close();
			balance = cs.getInt(6) ;
			
		}
		catch(Exception e1)
		{
				
		}
		finally
		{
		try{
			if(cs != null)  cs.close() ;
			}
			catch(Exception e){
			}
		}
	
		return balance;
	}
	public String actionOnVisitBill()
	{
		String action_on_visit_bill="W";
		try
		{

			PreparedStatement pstmt1 = conn.prepareStatement("select ACTION_ON_VISIT_BILL from op_param where OPERATING_FACILITY_ID='"+(String)hashData.get("facilityid")+"'");
			ResultSet rsOne = pstmt1.executeQuery();
			if(rsOne!=null && rsOne.next())
			{
				action_on_visit_bill = rsOne.getString("ACTION_ON_VISIT_BILL");
			}
		
			if (rsOne != null) rsOne.close();
			if (pstmt1 != null) pstmt1.close();
		}	
		catch(Exception e)
		{
		}
	
		return action_on_visit_bill;	
	}
}

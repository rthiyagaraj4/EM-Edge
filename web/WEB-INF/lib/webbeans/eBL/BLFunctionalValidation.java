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


public class BLFunctionalValidation
{

	public java.util.Hashtable billPatientService( Properties propertiesBill,Connection con, Hashtable tabdata)
	{
		Hashtable returnTable = new Hashtable();	
	try
	{
		CallableStatement cstmt;
//		String strVisitMessage = "";
//		String strBillGenYN = "";
//		String strBillMessage = "";
//		String strFinalMessage ="";


		if ( ((String)tabdata.get("bl_install_yn")).equals("Y"))
		{
			cstmt = con.prepareCall("{call bl_calculate_outst_amt(?, ?, ?)}");
			cstmt.setString(1,(String) tabdata.get("patient"));
			cstmt.setString(2, (String)tabdata.get("facilityid"));
			cstmt.registerOutParameter(3, java.sql.Types.FLOAT);
			cstmt.executeQuery();
	        float outst_amt = cstmt.getFloat(3);	
			cstmt.close();
			returnTable.put("outst_amt",new Float(outst_amt));

			
		}
	}

	catch(Exception exceptionS)
	{

	}
	return (returnTable);
}



public java.util.Hashtable billingOperational( Properties propertiesBill,Connection con, Hashtable tabdata)
	{
		Hashtable returnTable = new Hashtable();	
		
	try
	{
		CallableStatement cstmt;
		String strOperationalModules  = "";
		String strBLOperYN = "";
	
	
			cstmt = con.prepareCall("{call GET_OPERATIONAL_MODULES(?, ?)}");
			
			cstmt.setString(1, (String)tabdata.get("facility_id"));
			cstmt.registerOutParameter(2, java.sql.Types.VARCHAR);
			cstmt.executeQuery();
			strOperationalModules = cstmt.getString(2);
			cstmt.close();

			if (strOperationalModules.indexOf("BL|") > 0 )
			{
				strBLOperYN = "Y";
			}
			else
			{
				strBLOperYN = "N";
			}
			returnTable.put("opermodule",strOperationalModules);
			returnTable.put("bloper",strBLOperYN);

	}

	catch(Exception exceptionS)
	{

	}
	return (returnTable);
}


public java.util.Hashtable billPatientVisitOutstAmt( Properties propertiesBill,Connection con, Hashtable tabdata)
	{
		Hashtable returnTable = new Hashtable();	
	try
	{
		CallableStatement cstmt;	


		if ( ((String)tabdata.get("bl_install_yn")).equals("Y"))
		{
			String episode_id = (String)tabdata.get("episode_id");
			String visit_id	  = (String)tabdata.get("visit_id");

			cstmt = con.prepareCall("{call bl_visit_outst_amt(?,?,?,?,?,?)}");
			cstmt.setString(1,(String) tabdata.get("facility_id"));
			cstmt.setString(2, (String)tabdata.get("patient_id"));
			cstmt.setString(3, (String)tabdata.get("episode_type"));
			cstmt.setLong(4,Long.parseLong(episode_id)); 			
			cstmt.setInt(5,Integer.parseInt(visit_id));

			cstmt.registerOutParameter(6, java.sql.Types.FLOAT);
			cstmt.executeQuery();
	        float visit_outst_amt = cstmt.getFloat(6);	
			cstmt.close();
			returnTable.put("visit_outst_amt",new Float(visit_outst_amt));			
		}
	}

	catch(Exception exceptionS)
	{

	}
	return (returnTable);
}


}

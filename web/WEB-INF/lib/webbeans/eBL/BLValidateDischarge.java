/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package blipin;
import java.sql.* ;
import java.util.*;
public class BLValidateDischarge
{
	public Hashtable billPatientService(java.util.Properties properties,Connection connection,java.util.Hashtable hashtableBL)
	{
		String facility_id = (String)hashtableBL.get("facility_id");
//		String patient_id =  (String)hashtableBL.get("patient_id");
		String episode_id = (String)hashtableBL.get("episode_id");
		String episode_type =  (String)hashtableBL.get("episode_type");
//		String call_function = (String)hashtableBL.get("call_function");
//		String encid = (String)hashtableBL.get("encid");

		Hashtable returnHashtableBL = new Hashtable();
		boolean result = false;
		
		String strError ="0";

		if ( (episode_type == null)||(episode_type.equals("")) ) 
			  episode_type = "I";

		try
		{
//			String s10 = "I";
			CallableStatement callablestatement = connection.prepareCall("{call bl_ip_interface.BL_DISCHARGE_BILL_GEN_NO(?,?,?,?)}");
			callablestatement.setString(1, episode_id);
			//callablestatement.setString(2, "I");   // EPI TYPE ENH			
			callablestatement.setString(2, episode_type);
			callablestatement.setString(3, facility_id);
			callablestatement.registerOutParameter(4, java.sql.Types.VARCHAR);
			callablestatement.execute();
			strError = callablestatement.getString(4);
			if ((strError == null) || (strError.equalsIgnoreCase("null")) )
			{

				strError ="0";
				result = true;
			}

			callablestatement.close();
		}
		catch(Exception exception4)
		{
			strError = exception4+"";
		}
			
		returnHashtableBL.put("status",new Boolean(result));
		returnHashtableBL.put("error",strError);
		return (returnHashtableBL);
	}
}

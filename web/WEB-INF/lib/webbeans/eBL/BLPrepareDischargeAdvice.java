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
import webbeans.eCommon.*;
public class BLPrepareDischargeAdvice
{
	public Hashtable billPatientService(java.util.Properties properties,Connection connection,java.util.Hashtable hashtableBL)
	{
//		CallableStatement statement = null;
//		Statement stmt = null;
//		ResultSet rs = null;

//		System.err.println("Inside BLPrepareDischargeAdvice:"+hashtableBL);
		String facility_id = (String)hashtableBL.get("facility_id");
		if(facility_id == null) facility_id="";
//		String patient_id =  (String)hashtableBL.get("patient_id");
		String episode_id = (String)hashtableBL.get("episode_id");
		if(episode_id == null) episode_id="";
		String episode_type =  (String)hashtableBL.get("episode_type");
		if(episode_type == null) episode_type="";
		String calling_function_id = (String)hashtableBL.get("calling_function_id");
		if(calling_function_id == null) calling_function_id="";
//		String encid = (String)hashtableBL.get("encid");

		Hashtable returnHashtableBL = new Hashtable();
		StringBuffer sb = new StringBuffer(" ");
		boolean result = true;
		Hashtable messageHashtable=new Hashtable();

		String strError ="0";

//		String disc_bill_exists="",sys_message_id="";
//		System.err.println("episode_type in Discharge Advice before:"+episode_type);
		if ( (episode_type == null)||(episode_type.equals("")) ) 
		      episode_type = "I";
//		System.err.println("episode_type in Discharge Advice after:"+episode_type);
		String locale			= (String)hashtableBL.get("locale");
		if(locale==null) locale="en";
		
		try
		{
//			String s10 = "I";
			CallableStatement callablestatement = connection.prepareCall("{call bl_ip_interface.bl_discharge_bill_gen_yes(?,?,?,?)}");
			callablestatement.setString(1, episode_id);
			//callablestatement.setString(2, "I");
			callablestatement.setString(2, episode_type);
			callablestatement.setString(3, facility_id);
			callablestatement.registerOutParameter(4, java.sql.Types.VARCHAR);
			callablestatement.execute();
			strError = callablestatement.getString(4);
//			System.err.println("strError:"+strError);
			if ((strError == null) || (strError.equalsIgnoreCase("null")) )
			{
				strError ="0";
				result = true;
			}
			
			if(!strError.equals("0"))
			{
				if((strError.substring(0,2)).equals("BL"))
				{
					result = false;
					messageHashtable=MessageManager.getMessage(locale,strError,"BL");
					sb.append((String)messageHashtable.get("message"));
				}
				else
				{
					sb.append(strError);
				}
			}
			else
			{
				result = true;
			}
			callablestatement.close();
		}
		catch(Exception exception4)
		{
			result = false;
			strError = exception4+"";
			sb.append("Error in calling bl_discharge_bill_gen_yes:"+exception4);
		}
//		System.err.println("In BLPrepareDischargeAdvice --> new Boolean(result):"+new Boolean(result));
//		System.err.println("In BLPrepareDischargeAdvice -- > sb.toString():"+sb.toString());
			
		returnHashtableBL.put("status",new Boolean(result));
		returnHashtableBL.put("error",sb.toString());
		return (returnHashtableBL);
	}
}

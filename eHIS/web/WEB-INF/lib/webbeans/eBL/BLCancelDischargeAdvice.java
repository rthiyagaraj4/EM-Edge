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
public class BLCancelDischargeAdvice
{
	public Hashtable billPatientService(java.util.Properties properties,Connection connection,java.util.Hashtable hashtableBL)
	{
		CallableStatement statement = null;
		Statement stmt = null;
		ResultSet rs = null;

//		System.err.println("Inside BLCancelDischargeAdvice:"+hashtableBL);

		String facility_id = (String)hashtableBL.get("facility_id");
		if(facility_id == null) facility_id="";
//		String patient_id =  (String)hashtableBL.get("patient_id");
		String episode_id = (String)hashtableBL.get("episode_id");
		if(episode_id == null) episode_id="";

		String episode_type =  (String)hashtableBL.get("episode_type");
		if(episode_type == null) episode_type="";

		String calling_function_id = (String)hashtableBL.get("function_id");
		if(calling_function_id == null) calling_function_id="";
//		String encid = (String)hashtableBL.get("encid");

		Hashtable returnHashtableBL = new Hashtable();
		StringBuffer sb = new StringBuffer(" ");
		boolean result = true;
		Hashtable messageHashtable=new Hashtable();

//		String strError ="0";

		String disc_bill_exists="",sys_message_id="";

		if ( (episode_type == null)||(episode_type.equals("")) ) 
		      episode_type = "I";

		String locale			= (String)hashtableBL.get("locale");
		if(locale==null) locale="en";
		
		try
		{
			stmt = connection.createStatement();
			rs = stmt.executeQuery("SELECT BL_IP_DETAILS.GET_DISCHARGE_BILL_EXIST('"+facility_id+"',"+episode_id+") disc_bill_exists FROM dual");
			while(rs.next())
			{
				disc_bill_exists = rs.getString("disc_bill_exists");
				if(disc_bill_exists == null) disc_bill_exists = "N";
			}
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();

			if(disc_bill_exists.equals("Y"))
			{
//				System.err.println("Bill exists");
				result=false;
				messageHashtable=MessageManager.getMessage(locale,"BL9311","BL");
				sb.append((String)messageHashtable.get("message"));
//				System.err.println("sb mesage is:"+sb);
			}
		}
		catch(Exception e)
		{
			result = false;		
			sb.append("Error in calling GET_DISCHARGE_BILL_EXIST:"+e);
		}

		if(result)
		{
			try
			{
				String sql = "{call BL_IP_DETAILS.CHECK_FIN_CLEAR_DUR_IP_TRX('"+calling_function_id+"','"+facility_id+"','"+episode_id+"',?)}";
//				System.err.println("The Sql CHECK_FIN_CLEAR_DUR_IP_TRX :"+sql);
				statement=connection.prepareCall(sql);
//				statement.setString( 1, functionId);
//				statement.setString( 2, facilityId);
//				statement.setString( 3, episode_id);	
				statement.registerOutParameter(1,java.sql.Types.VARCHAR);

				statement.execute();

				sys_message_id = statement.getString(1);

				if ((sys_message_id != null))
				{
					if (!(sys_message_id.equals("")) || !(sys_message_id.equalsIgnoreCase("null") ) )
					{
						result=false;
						messageHashtable=MessageManager.getMessage(locale,sys_message_id,"BL");
						sb.append((String)messageHashtable.get("message"));
//						System.err.println("sb mesage is:"+sb);
					}
				}
				sys_message_id ="";
				
				statement.close();
			}
			catch (Exception e)
			{
				result = false;		
				sb.append("Error in calling CHECK_FIN_CLEAR_DUR_IP_TRX:"+e);
			}
		}
			
		returnHashtableBL.put("status",new Boolean(result));
		returnHashtableBL.put("error",sb.toString());
		return (returnHashtableBL);
	}
}

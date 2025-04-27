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
public class BLDischargePatient
{
	public Hashtable billPatientService(java.util.Properties properties,
				Connection con,
				java.util.Hashtable hashtableBL)
	{
		CallableStatement statement = null;
		PreparedStatement pstmt = null ;
		Statement stmt = null;
		ResultSet rs = null;

//		System.err.println("Inside Discharge Patient Bean Call:"+hashtableBL);
		StringBuffer sb = new StringBuffer(" ");
//		String strNull = "";

		String facilityId = (String)hashtableBL.get("facility_id");
		if(facilityId == null) facilityId="";

		String episode_id = (String)hashtableBL.get("episode_id");
		if(episode_id == null) episode_id="";

		String dischargedate =  (String)hashtableBL.get("dischargedate");
		if(dischargedate == null) dischargedate="";

		String functionId = (String)hashtableBL.get("function_id");
		if(functionId == null) functionId="";

		String locale			= (String)hashtableBL.get("locale");
		if(locale==null) locale="en";

		Hashtable returnHashtableBL = new Hashtable();
		boolean result = true;

		Hashtable messageHashtable=new Hashtable();

		String sys_message_id="",disc_blg_stage="",disc_bill_exists="N";
		
		try
		{
			stmt = con.createStatement();
			rs = stmt.executeQuery(" SELECT BL_IP_DETAILS.GET_DISCHARGE_BILLING_STAGE('"+facilityId+"') disc_blg_stage FROM dual ");
			while(rs!=null && rs.next())
			{
				disc_blg_stage = rs.getString("disc_blg_stage");
				if(disc_blg_stage == null) disc_blg_stage = "";

			}
//			System.err.println("disc_blg_stage:"+disc_blg_stage);
			if(rs != null )rs.close();
			if(stmt != null )stmt.close();
		}
		catch (Exception e)
		{
			result = false;		
			sb.append("Error in calling GET_DISCHARGE_BILLING_STAGE:"+e);
		}

		if(result)
		{
			try
			{
				if(disc_blg_stage.equals("1"))
				{
					try
					{
						stmt = con.createStatement();
						rs = stmt.executeQuery(" SELECT BL_IP_DETAILS.GET_DISCHARGE_BILL_EXIST('"+facilityId+"','"+episode_id+"') disc_bill_exists FROM dual ");
						while(rs.next())
						{
							disc_bill_exists = rs.getString("disc_bill_exists");
							if(disc_bill_exists == null) disc_bill_exists = "N";
						}
//						System.err.println("disc_bill_exists:"+disc_bill_exists);
						if(rs != null )rs.close();
						if(stmt != null )stmt.close();
					}
					catch (Exception e)
					{
						result = false;		
						sb.append("Error in calling GET_DISCHARGE_BILL_EXIST:"+e);
					}
				
					if(disc_bill_exists.equals("N") && functionId.equals("DISCHARGE_PATIENT"))
					{
//						System.err.println("Bill doesnt exists");
						result=false;
						messageHashtable=MessageManager.getMessage(locale,"BL9312","BL");
						sb.append((String)messageHashtable.get("message"));
//						System.err.println("sb mesage is:"+sb);
					}
				}
			}
			catch(Exception e)
			{
				result = false;		
				sb.append("Error in calling Bill Check:"+e);
			}
		}
		if(result)
		{
			try
			{
				String sql = "{call BL_IP_DETAILS.CHECK_FIN_CLEAR_DUR_IP_TRX('"+functionId+"','"+facilityId+"','"+episode_id+"',?)}";
//				System.err.println("The Sql CHECK_FIN_CLEAR_DUR_IP_TRX :"+sql);
				statement=con.prepareCall(sql);
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
			catch(Exception e)
			{
				result = false;		
				sb.append("Error in calling CHECK_FIN_CLEAR_DUR_IP_TRX:"+e);
			}
		}

		if(result)
		{
			try
			{
				String sql5 =  " UPDATE BL_EPISODE_FIN_DTLS SET DISCHARGE_DATE_TIME = to_date('"+dischargedate+"','dd/mm/yyyy hh24:mi'), DISCHARGED_YN = 'Y', EPISODE_STATUS = '1' WHERE EPISODE_ID = '"+episode_id+"' AND EPISODE_TYPE IN ('D','I') AND OPERATING_FACILITY_ID='"+facilityId+"'";
				pstmt = con.prepareStatement(sql5);
				int res6 = pstmt.executeUpdate();
				if(res6 != 0) 
				{
					result = true;
				}
				else
				{
					result = false;
				}
				pstmt.close();
			}
			catch(Exception e)
			{
				result = false;		
				sb.append("Error in updating bl_episode_fin_dtls for discharge details:"+e);
			}
		}
		returnHashtableBL.put("status",new Boolean(result));
		returnHashtableBL.put("error",sb.toString());
		return (returnHashtableBL);
	}
}

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
public class BLCancelDischargePatient
{
	public Hashtable cancelDischarge(java.util.Properties properties,
				Connection con,
				java.util.Hashtable hashtableBL)
	{
//		System.err.println("In cancelDischarge Bean:"+hashtableBL);

		String facilityId = (String)hashtableBL.get("facility_id");
		if(facilityId == null) facilityId="";
//		String patientid =  (String)hashtableBL.get("patientid");
		String episode_id = (String)hashtableBL.get("episode_id");
		if(episode_id == null) episode_id="";

		String locale			= (String)hashtableBL.get("locale");
		if(locale == null) locale="en";
	
		Hashtable returnHashtableBL = new Hashtable();
		boolean result = true;
		StringBuffer sb = new StringBuffer(" ");
		Hashtable messageHashtable=new Hashtable();

		String strUnderChargeExist = "N";
		String strDischargeBillStage="1";
		ResultSet res = null;
		PreparedStatement pstmt = null ;
		String strDischargeBillExist="N";
		String can_cancel_discharge = "Y";
		String strErrorText = " ";
		
		if(result)
		{
			try
			{
				String sql3  = "SELECT BL_IP_DETAILS.GET_DISCHARGE_BILLING_STAGE(?) FROM DUAL";
				pstmt = con.prepareStatement(sql3);
				pstmt.setString(1,facilityId);
				 res = pstmt.executeQuery();
				if (res.next())
				{
					strDischargeBillStage = res.getString(1);
				}
				res.close();
				pstmt.close();
//				System.err.println("	strDischargeBillStage:"+strDischargeBillStage);	
				if (strDischargeBillStage.equals("2"))
				{
					String sql6  = "SELECT BL_IP_DETAILS.GET_DISCHARGE_BILL_EXIST(?,?) FROM DUAL";
					pstmt = con.prepareStatement(sql6);
					pstmt.setString(1,facilityId);
					pstmt.setInt(2,Integer.parseInt(episode_id));

					res = pstmt.executeQuery();
					if (res.next())
					{
						strDischargeBillExist = res.getString(1);
					}
					res.close();
					pstmt.close();
				}
				else
				{
					strDischargeBillExist ="N";
				}	
//				System.err.println("	strDischargeBillExist:"+strDischargeBillExist);	
					
				String sql5 =  " SELECT BL_IP_DETAILS.GET_UNDERCHARGE_TRX_EXIST(?,?) FROM DUAL ";
				pstmt = con.prepareStatement(sql5);
				pstmt.setString(1,facilityId);
				pstmt.setInt(2,Integer.parseInt(episode_id));
				res = pstmt.executeQuery();
				if(res.next()) 
				{
					strUnderChargeExist = res.getString(1);
					result = true;
				}
				else
				{
					result = false;
				}
				res.close();
				pstmt.close();
//				System.err.println("	strUnderChargeExist:"+strUnderChargeExist);	
				if (strUnderChargeExist.equalsIgnoreCase("Y") )
				{
					result = false;
					strErrorText = "Undercharge Service Exists. Cannot Cancel the Discharge";//BL9314
					can_cancel_discharge = "N";
					messageHashtable=MessageManager.getMessage(locale,"BL9314","BL");
					sb.append((String)messageHashtable.get("message"));
				}
				if ( (strDischargeBillStage.equals("2"))&& (strDischargeBillExist.equals("Y") )  )
				{
					result = false;
					strErrorText = "Discharge Bill Exists. Cannot Cancel the Discharge";//BL7283
					can_cancel_discharge = "N";
					messageHashtable=MessageManager.getMessage(locale,"9315","BL");
					sb.append((String)messageHashtable.get("message"));
				}
//				System.err.println("	strErrorText:"+strErrorText);	
			}
			catch(Exception e)
			{
				result = false;
				sb.append("Error while calling cancelDischarge Bean:"+e);
			}
		}

		if(result)
		{
//			System.err.println("Updating The BL_EPISODE_FIN_DTLS");
			try
			{
				String sql5 =  " UPDATE BL_EPISODE_FIN_DTLS SET DISCHARGE_DATE_TIME = NULL, DISCHARGED_YN = 'N', EPISODE_STATUS = '0' WHERE EPISODE_ID = '"+episode_id+"' AND EPISODE_TYPE IN ('I','D') AND OPERATING_FACILITY_ID='"+facilityId+"'";
					
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
//			System.err.println("Updating The BL_EPISODE_FIN_DTLS Done");
			}
			catch(Exception e)
			{
				result = false;	
				sb.append("Error while updating BL_EPISODE_FIN_DTLS:"+e);
			}
		}

		returnHashtableBL.put("status",new Boolean(result));
		returnHashtableBL.put("can_cancel_discharge",can_cancel_discharge);
		returnHashtableBL.put("discharge_bill_exist",strDischargeBillExist);
		returnHashtableBL.put("undercharge_service_exist",strUnderChargeExist);
		returnHashtableBL.put("discharge_billing_stage",strDischargeBillStage );
		returnHashtableBL.put("error",sb.toString());
//		System.err.println("Returned Hashtable:"+returnHashtableBL);
		return (returnHashtableBL);
/*
		returnHashtableBL.put("status",new Boolean(result));
		return (returnHashtableBL);
*/
	}
	public Hashtable canCancelDischarge(java.util.Properties properties,
				Connection con,
				java.util.Hashtable hashtableBL)
	{
		String facilityId = (String)hashtableBL.get("facility_id");
//		String patientid =  (String)hashtableBL.get("patient_id");
		String episode_id = (String)hashtableBL.get("episode_id");
		Hashtable returnHashtableBL = new Hashtable();
		boolean result = true;
		String strUnderChargeExist = "N";
		String strDischargeBillStage="1";
		ResultSet res = null;
		PreparedStatement pstmt = null ;
		String strDischargeBillExist="N";
		String can_cancel_discharge = "Y";
		String strErrorText = " ";
		try
		{
				

				String sql3  = "SELECT BL_IP_DETAILS.GET_DISCHARGE_BILLING_STAGE(?) FROM DUAL";
				pstmt = con.prepareStatement(sql3);
				pstmt.setString(1,facilityId);
				 res = pstmt.executeQuery();
				if (res.next())
				{
					strDischargeBillStage = res.getString(1);
				}
				res.close();
				pstmt.close();
							
				if (strDischargeBillStage.equals("2"))
				{
					String sql6  = "SELECT BL_IP_DETAILS.GET_DISCHARGE_BILL_EXIST(?,?) FROM DUAL";
					pstmt = con.prepareStatement(sql6);
					pstmt.setString(1,facilityId);
					pstmt.setInt(2,Integer.parseInt(episode_id));

					res = pstmt.executeQuery();
					if (res.next())
					{
						strDischargeBillExist = res.getString(1);
					}
					res.close();
					pstmt.close();
				}
				else
				{
					strDischargeBillExist ="N";
				}				
				
				String sql5 =  " SELECT BL_IP_DETAILS.GET_UNDERCHARGE_TRX_EXIST(?,?) FROM DUAL ";
				pstmt = con.prepareStatement(sql5);
				pstmt.setString(1,facilityId);
				pstmt.setInt(2,Integer.parseInt(episode_id));
				res = pstmt.executeQuery();
				if(res.next()) 
				{
					strUnderChargeExist = res.getString(1);

					result = true;
				}
				else
				{
						result = false;
				}
				res.close();
				pstmt.close();

			if (strUnderChargeExist.equalsIgnoreCase("Y") )
			{
				strErrorText = "Undercharge Service Exists. Cannot Cancel the Discharge";
				can_cancel_discharge = "N";
			}
			if ( (strDischargeBillStage.equals("2"))&& (strDischargeBillExist.equals("Y") )  )
			{
				strErrorText = "Discharge Bill Exists. Cannot Cancel the Discharge";
				can_cancel_discharge = "N";
			}


		}
		catch(Exception e)
		{
			result = false;
			strErrorText = "BL CancelDischarge"+e;
			
		}
		returnHashtableBL.put("status",new Boolean(result));
		returnHashtableBL.put("can_cancel_discharge",can_cancel_discharge);
		returnHashtableBL.put("discharge_bill_exist",strDischargeBillExist);
		returnHashtableBL.put("undercharge_service_exist",strUnderChargeExist);
		returnHashtableBL.put("discharge_billing_stage",strDischargeBillStage );
		returnHashtableBL.put("error_text",strErrorText);

		return (returnHashtableBL);
	}

}

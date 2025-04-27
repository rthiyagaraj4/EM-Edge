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
public class BLCancelTransfer
{
	public Hashtable canCancelTransfer(java.util.Properties properties,
				Connection con,
				java.util.Hashtable hashtableBL)
	{
		String facilityId = (String)hashtableBL.get("facility_id");
//		String patientid =  (String)hashtableBL.get("patient_id");
		String episode_id = (String)hashtableBL.get("episode_id");
		String transfer_num = (String)hashtableBL.get("transfer_num");

		Hashtable returnHashtableBL = new Hashtable();
		boolean result = true;
		ResultSet res = null;
		PreparedStatement pstmt = null ;
		String strChargesAfterTransfer = "N";
		String can_cancel_transfer = "Y";
		String strErrorText = " ";
		try
		{
				
		
				String sql5 =  " SELECT BL_IP_DETAILS.GET_CHARGE_EXISTS_AFTER_TFR(?,?,?) FROM DUAL ";
				pstmt = con.prepareStatement(sql5);
				pstmt.setString(1,facilityId);
				pstmt.setInt(2,Integer.parseInt(episode_id));
				pstmt.setInt(3,Integer.parseInt(transfer_num));
				res = pstmt.executeQuery();
				if(res.next()) 
				{
					strChargesAfterTransfer = res.getString(1);
					result = true;
				}
				else
				{
						result = false;
				}
				res.close();
				pstmt.close();

			if (strChargesAfterTransfer.equalsIgnoreCase("Y") )
			{
				strErrorText = "Charges Exists after the Transfer. Cannot Cancel the Transfer";
				can_cancel_transfer = "N";
			}
		}
		catch(Exception e)
		{
			result = false;
			strErrorText = "BL CancelTransfer"+e;
			
		}
		returnHashtableBL.put("status",new Boolean(result));
		returnHashtableBL.put("can_cancel_transfer",can_cancel_transfer);
		returnHashtableBL.put("error_text",strErrorText);

		return (returnHashtableBL);
	}

}

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
public class BLGetChargeDetails
{
	public Hashtable getDetail
				(
				java.util.Properties properties,
				Connection con,
				java.util.Hashtable hashtableBL
			)

	{
		
		Hashtable returnHashtableBL = new Hashtable();

		String patient_id = (String)hashtableBL.get("patient_id");
		String episode_id = (String)hashtableBL.get("episode_id");
		String facility_id = (String)hashtableBL.get("facility_id");
		String encounter_id = (String)hashtableBL.get("encounter_id");
		String todailyrate = "";
		String trndep = "";
		double unadjdepamt = 0;
		double unadjpreamt = 0;		

		if (patient_id == null)
		{
			patient_id = "";
		} 
		if (episode_id == null)
		{
			episode_id = "";
		}
		if (facility_id == null)
		{
			facility_id = "";
		}
		boolean boolCancelAllowed = false;
		int intCnt = 0;
		try
		{
			PreparedStatement stmt = con.prepareStatement(" select count(*) from bl_patient_charges_folio where episode_type IN ('I','D') and patient_id='"+patient_id+"' and episode_id='"+episode_id+"' and "
									+ "	 operating_facility_id = '"+facility_id+"' and nvl(trx_status,'N') != 'C'");


			ResultSet rset = stmt.executeQuery();
			if (rset.next())
			{
				intCnt = rset.getInt(1);
			}
			rset.close();
			stmt.close();

			
			stmt = con.prepareStatement(" select nvl(tot_unadj_dep_amt,0),nvl(tot_unadj_prep_amt,0) from bl_episode_fin_dtls where operating_facility_id='"+facility_id+"' and  " + 
									 " patient_id = '"+patient_id+"' and episode_id = '" +episode_id + "' and nvl(episode_status,'X') != '9'");
			rset = stmt.executeQuery();
			if (rset.next())
			{
				unadjdepamt = rset.getDouble(1);
				unadjpreamt = rset.getDouble(2);
			}
			rset.close();
			stmt.close();
			

			if (intCnt >0 || unadjdepamt>0 || unadjpreamt>0 )
			{
				boolCancelAllowed = false;
			}
			else
			{
				boolCancelAllowed  = true;
			}

			PreparedStatement stmt2 = con.prepareStatement("select to_daily_rate, trn_dep from ip_adt_trn where facility_id='"+facility_id+"' and encounter_id='"+encounter_id+"'"	
									+ " and trn_type='A'");
            //out.println("query_bill_dtl :"+query_bill_dtl);
            
            ResultSet rset2 = stmt2.executeQuery();


            if(rset2.next())
            {
                todailyrate = rset2.getString("to_daily_rate");
                trndep = rset2.getString("trn_dep");
            }
        
			rset2.close();
			stmt2.close();

			
 
			
		}
		catch(Exception e)
		{
			returnHashtableBL.put("message","BLGetChargeDetails.Error "+e);	
		}
		returnHashtableBL.put("cancel_allowed",new Boolean(boolCancelAllowed));
		returnHashtableBL.put("todailyrate",todailyrate);
		returnHashtableBL.put("trndep",trndep);
		returnHashtableBL.put("unadjdep",unadjdepamt+"");
		returnHashtableBL.put("unadjprepay",unadjpreamt+"");

		return (returnHashtableBL);
	}
}

/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eBL;
import java.io.*;
import java.util.*;
import java.sql.*;
import eBL.Common.*;
import webbeans.eCommon.*;
import eCommon.Common.CommonAdapter;

public class BLAddlSurgeryReturnValuesBean extends BlAdapter implements Serializable
{
	
	HashMap hashAddlSurgeryReturnValues			= new HashMap();

	public BLAddlSurgeryReturnValuesBean()
	{	
		System.out.println("Bean Initialized");
	}

	public HashMap validate() throws Exception
	{
		HashMap map = new HashMap();
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "success.." );
		return map;
	}	
   
	public void setAddSurgeryValues(String facility_id,String patient_id,String episode_type,String episode_id,String visit_id,String str_order_cat_code,String str_serv_panel_ind,String str_blng_serv_code,String str_trx_date_time,String str_serv_qty,String charging_stage,String str_charge_based_amt,String str_pract_id,String str_overridden_excl_incl_ind,String strloggeduser,String strclientip,String str_dep_blng_serv_code,String str_dep_serv_charge_eff_perc,String str_disc_seq_num,String str_multi_surg_disc_eff_perc,String str_ref_sec_module_id,String str_ref_sec_key_main,String str_ref_sec_key_line_num,String str_ref_oper_num ,String str_ref_module_id)
	{		
		hashAddlSurgeryReturnValues.clear();	
		hashAddlSurgeryReturnValues.put("facility_id",checkNull(facility_id));
		hashAddlSurgeryReturnValues.put("patient_id",checkNull(patient_id));
		hashAddlSurgeryReturnValues.put("episode_type",checkNull(episode_type));
		hashAddlSurgeryReturnValues.put("episode_id",checkNull(episode_id));
		hashAddlSurgeryReturnValues.put("visit_id",checkNull(visit_id));
		hashAddlSurgeryReturnValues.put("str_order_cat_code",checkNull(str_order_cat_code));
		hashAddlSurgeryReturnValues.put("str_serv_panel_ind",checkNull(str_serv_panel_ind));
		hashAddlSurgeryReturnValues.put("str_blng_serv_code",checkNull(str_blng_serv_code));
		hashAddlSurgeryReturnValues.put("str_trx_date_time",checkNull(str_trx_date_time));
		hashAddlSurgeryReturnValues.put("str_serv_qty",checkNull(str_serv_qty));
		hashAddlSurgeryReturnValues.put("charging_stage",checkNull(charging_stage));
		hashAddlSurgeryReturnValues.put("str_charge_based_amt",checkNull(str_charge_based_amt));
		hashAddlSurgeryReturnValues.put("str_pract_id",checkNull(str_pract_id));
		hashAddlSurgeryReturnValues.put("str_overridden_excl_incl_ind",checkNull(str_overridden_excl_incl_ind));
		hashAddlSurgeryReturnValues.put("strloggeduser",checkNull(strloggeduser));
		hashAddlSurgeryReturnValues.put("strclientip",checkNull(strclientip));
		hashAddlSurgeryReturnValues.put("str_dep_blng_serv_code",checkNull(str_dep_blng_serv_code));
		hashAddlSurgeryReturnValues.put("str_dep_serv_charge_eff_perc",checkNull(str_dep_serv_charge_eff_perc));
		hashAddlSurgeryReturnValues.put("str_disc_seq_num",checkNull(str_disc_seq_num));
		hashAddlSurgeryReturnValues.put("str_multi_surg_disc_eff_perc",checkNull(str_multi_surg_disc_eff_perc));
		hashAddlSurgeryReturnValues.put("str_ref_sec_module_id",checkNull(str_ref_sec_module_id));
		hashAddlSurgeryReturnValues.put("str_ref_sec_key_main",checkNull(str_ref_sec_key_main));
		hashAddlSurgeryReturnValues.put("str_ref_sec_key_line_num",checkNull(str_ref_sec_key_line_num));	
		hashAddlSurgeryReturnValues.put("str_ref_oper_num",checkNull(str_ref_oper_num));	
		hashAddlSurgeryReturnValues.put("str_ref_module_id",checkNull(str_ref_module_id));	

//		System.out.println("Bean Initialized hashAddlSurgeryReturnValues"+hashAddlSurgeryReturnValues);
		
	 }

	public HashMap getAddSurgeryValues()
	{
//			System.out.println("Bean Initialized hashAddlSurgeryReturnValues get"+hashAddlSurgeryReturnValues);
		return hashAddlSurgeryReturnValues;
		
	}

	

	public void clearBean()
	{
		if( hashAddlSurgeryReturnValues != null )
	 	{
	 		hashAddlSurgeryReturnValues.clear();
	 	}
		else
		{
			hashAddlSurgeryReturnValues	= new java.util.HashMap();
		}
	
	}
	private String checkNull(String inputString)
	{
		if(inputString == null || inputString.equals("") ||  inputString.equalsIgnoreCase("null") )
			inputString = "";
		return inputString;
	}
}

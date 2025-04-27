/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package blbkin;
import java.net.*;
import java.io.* ;

import java.sql.* ;
import javax.rmi.*;
import java.util.*;
import java.sql.* ;

import webbeans.eCommon.*;

public class BLCancelBooking
{
//	public java.util.Hashtable insert( Properties p,Connection con, String appt_status,String episodeno,Hashtable tabdata,Hashtable prencounter,Hashtable prencounterdetail)
    public java.util.Hashtable billPatientService(Properties p,Connection con, Hashtable tabdata)
	{
//		System.out.println("Entered the billPatientBooking Method");
		CallableStatement statement = null;
		Hashtable results = new Hashtable();
		Hashtable messageHashtable=new Hashtable();
		StringBuffer sb = new StringBuffer();

		Hashtable insert_values = tabdata;

		String strFunctionId = "";
		String strFacilityId= "";
		boolean insertable = true;
		sb.append("");
		String locale			= "";		

		String err_level = "";
		String sys_message_id = "";
		String err_text = "";
		
		String str_appt_bkng_ref_no="",str_appt_bkng_ref_date="";
		
		try
		{
			locale			= (String)insert_values.get("locale");
			if(locale==null) locale="";
			
			strFunctionId  = (String)tabdata.get("function_id");
			if (strFunctionId  == null) strFunctionId  = "";
//			System.out.println("strFunctionId" +strFunctionId);
			
			strFacilityId=(String)tabdata.get("facilityId");
			if(strFacilityId==null) strFacilityId="";
//			System.out.println("strFacilityId" +strFacilityId);

			String episode_type = (String) tabdata.get("P_EPISODE_TYPE");
//			System.out.println("episode_type" +episode_type);
			if ( (episode_type == null)||(episode_type.equals("")) ) 
				
				episode_type = "";

				if(episode_type.equals("I") || episode_type.equals("D"))
				{
					episode_type="B";
				}
				else if(episode_type.equals("O"))
				{
					episode_type="A";
				}

			str_appt_bkng_ref_no=(String) tabdata.get("bookingrefno");
			if(str_appt_bkng_ref_no == null) str_appt_bkng_ref_no="";
//			System.out.println("str_appt_bkng_ref_no" +str_appt_bkng_ref_no);

			str_appt_bkng_ref_date=(String) tabdata.get("admissiondate");
			if(str_appt_bkng_ref_date == null) str_appt_bkng_ref_date="";
//			System.out.println("str_appt_bkng_ref_date" +str_appt_bkng_ref_date);				

			String sql = "{call blcommon.bl_cancel_bkng_fin_dtls('"+strFacilityId+"','"+episode_type+"','"+str_appt_bkng_ref_no+"' ,?,?,?)}";

//				System.out.println("The Sql is:"+sql);					
				statement = con.prepareCall(sql);				
				statement.registerOutParameter( 1,java.sql.Types.VARCHAR);
				statement.registerOutParameter( 2,java.sql.Types.VARCHAR);
				statement.registerOutParameter( 3,java.sql.Types.VARCHAR);				
				statement.execute();
				
//				System.out.println("The Sql is after e");				
				insertable = true;							
				sys_message_id=statement.getString(1);
				err_level=statement.getString(2);
				err_text=statement.getString(3);

				if(err_level==null) err_level="";
				if(sys_message_id==null) sys_message_id="";
				if(err_text==null) err_text="";

//				System.out.println("err_level:"+err_level);
//				System.out.println("sys_message_id:"+sys_message_id);
//				System.out.println("err_text:"+err_text);

				if(  (!sys_message_id.equals(""))  || (err_level.equals("10") && !err_text.equals("") ) )
				{
					insertable=false;

					if((err_level.equals("10") && !err_text.equals("") ))
					{
						sb.append("<br>"+err_text+"<br> ") ;
//						System.out.println("sb mesage is:"+sb);
					}
					else
					{
						messageHashtable=MessageManager.getMessage(locale,sys_message_id,"BL");
						sb.append((String)messageHashtable.get("message"));
//						System.out.println("sb mesage is:"+sb);
					}
					statement.close();
				}
				
				sys_message_id="";
				err_level="";
				err_text="";

		}		
		catch(Exception ebl1)
		{  
			try
			{
				if (statement != null)
				{
					statement.close();
				}
			}
			catch(Exception exc)
			{
			}
			insertable=false;
			sb.append("Exception while calling procedure BL :"+ebl1);  
//			System.out.println("Exception in Procedure:"+ebl1);
		}
		results.put("status",new Boolean(insertable));
		results.put("error",sb.toString());
		return results ;
	}
}	
	

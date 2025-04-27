/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package blipin;
import java.io.*;
import java.rmi.* ;
import javax.ejb.* ;
import java.util.* ;
import java.sql.* ;
import javax.naming.*;
import javax.transaction.*;
import webbeans.eCommon.*;
public class BLIPBedAssgn
{
	public Hashtable billPatientService(Properties p, Connection con,Hashtable hashtableBL)
	{
		CallableStatement cstmt1 = null;
		String strErrorText = "";
		String strMessage = "";

		String p_mode ="";
		String p_function_id = "";
		String p_facility_id = "";
		String p_module_id = "";
		String 	p_patient_id = "";
		String p_episode_type = "";
		long p_episode_id  = 0;
		long p_encounter_id = 0;
		String p_nursing_unit = "";
		String p_bed_class = "";
		String p_bed_no = "";
		String p_bed_type="";
		String p_user = "";
		String p_ws_no = "";
		String locale="";
	
		StringBuffer sb = new StringBuffer(" ");
		Hashtable messageHashtable=new Hashtable();

//Unused Var's
//		int p_dly_charge =0;
//		int P_DEP_AMT      =0;
//		int P_TOT_DEP_AMT   = 0 ;

		p_patient_id = (String) hashtableBL.get("patient_id");
		p_mode = "V";
		p_module_id = "IP";
		p_encounter_id = Long.parseLong(((String) hashtableBL.get("encounterId")));
		p_episode_id = Long.parseLong(((String) hashtableBL.get("episode_id"))); 
		p_episode_type = (String) hashtableBL.get("episode_type");
		p_bed_class = (String) hashtableBL.get("bed_class_code");
		p_bed_no = (String) hashtableBL.get("bed_no");
//		System.out.println("p_bed_no:"+p_bed_no);
		p_bed_type=(String) hashtableBL.get("bed_type_code");
//		System.out.println("p_bed_type:"+p_bed_type);
		p_facility_id = (String) hashtableBL.get("facilityId");
		p_ws_no = (String) hashtableBL.get("client_ip_address");
		p_function_id = (String) hashtableBL.get("function_id");
		p_user	= p.getProperty("login_user");
		p_nursing_unit = (String) hashtableBL.get("nursing_unit_code");
		locale=(String)hashtableBL.get("locale");
		if(locale==null) locale="en";

		boolean status = false;

//Unused Var's
/*		String str = " p_patient_id	="+	p_patient_id      +
					" p_mode     	="+	p_mode            +
					" p_module_id 	="+	p_module_id       +
					" p_encounter_id ="+		p_encounter_id    +
					" p_episode_id 	="+	p_episode_id      +
					" p_bed_class 	="+	p_bed_class       +
					" p_bed_no 	="+	p_bed_no          +
					" p_facility_id ="+		p_facility_id     +
					" p_ws_no = 	"+	p_ws_no          +
					" p_function_id ="+		p_function_id     +
					" p_user	="+		p_user	          ;
*/
		try
		{
//			cstmt1 = con.prepareCall("{call BL_IP_INTERFACE.PROC_BED_ASSIGN(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");
			String sql_proc_bed_assign = "{call BL_IP_INTERFACE.PROC_BED_ASSIGN('"+p_mode+"','"+p_function_id+"','"+p_facility_id+"','"+p_module_id+"','"+p_patient_id+"','"+p_episode_type+"',"+p_episode_id+","+p_encounter_id+",'"+p_nursing_unit+"','"+p_bed_class+"','"+p_bed_type+"','"+p_user+"','"+p_ws_no+"','"+locale+"',?,?,?,?,?,?,?)}";

//			System.out.println("The Sql PROC_BED_ASSIGN :"+sql_proc_bed_assign);

			cstmt1 = con.prepareCall(sql_proc_bed_assign);
/*
			cstmt1.setString(1,p_mode );
			cstmt1.setString(2,p_function_id );
			cstmt1.setString(3,p_facility_id );
			cstmt1.setString(4,p_module_id );
			cstmt1.setString(5,p_patient_id );
			cstmt1.setString(6,p_episode_type );
			cstmt1.setLong(7,p_episode_id    );
			cstmt1.setLong(8,p_encounter_id );
			cstmt1.setString(9,p_nursing_unit );
			cstmt1.setString(10,p_bed_class );
			cstmt1.setString(11,p_bed_type );//p_bed_no
			cstmt1.setString(12,p_user );
			cstmt1.setString(13,p_ws_no );
			cstmt1.setString(14,locale);	
*/
			cstmt1.registerOutParameter(1,java.sql.Types.NUMERIC);
			cstmt1.registerOutParameter(2,java.sql.Types.NUMERIC);
			cstmt1.registerOutParameter(3,java.sql.Types.NUMERIC);
			cstmt1.registerOutParameter(4,java.sql.Types.VARCHAR);
			cstmt1.registerOutParameter(5,java.sql.Types.VARCHAR);
			cstmt1.registerOutParameter(6,java.sql.Types.VARCHAR);
			cstmt1.registerOutParameter(7,java.sql.Types.VARCHAR);

			cstmt1.execute();

//			strErrorText = cstmt1.getString(18);
			String err_level=cstmt1.getString(4);
			if(err_level==null) err_level="";

			String sys_message_id=cstmt1.getString(5);
			if(sys_message_id==null) sys_message_id="";

			String err_text=cstmt1.getString(7);
			if(err_text==null) err_text="";

//			System.out.println("err_level:"+err_level);
//			System.out.println("sys_message_id:"+sys_message_id);
//			System.out.println("err_text:"+err_text);

			strMessage = cstmt1.getString(6);

/*
			if (strErrorText != null)
			{
				strErrorText = strErrorText.trim();
				if (!(strErrorText.equalsIgnoreCase("null") ) )
				{
					status = false;
				}
				else
				{
					status = true;
				}
			}
			else
			{
				status = true;
			}
*/
			if(  (!sys_message_id.equals(""))  || (err_level.equals("10") && !err_text.equals("") ) )
		    {
				status=false;

				if((err_level.equals("10") && !err_text.equals("") ))
				{
					sb.append("<br>"+err_text+"<br> ") ;
//					System.out.println("sb mesage is:"+sb);
				}
	            else
		        {
					messageHashtable=MessageManager.getMessage(locale,sys_message_id,"BL");
					sb.append((String)messageHashtable.get("message"));
//					System.out.println("sb mesage is:"+sb);
				}
				cstmt1.close();
			}
			else
			{
				status=true;
			}	
		
			cstmt1.close();
		}
		catch( Exception ee)
		{
			status = false;
			strErrorText = "BL Bed Assign"+ee+"";
			System.out.println("Exception while running procedure BL_IP_INTERFACE.PROC_BED_ASSIGN:"+ee);
		}
	
		Hashtable resultBL =  new Hashtable();
		if (strMessage == null)
		{
			strMessage = " ";
		}
//		System.out.println("strMessage:"+strMessage);
		resultBL.put("status",new Boolean(status));
		resultBL.put("error",sb.toString()+"");
		resultBL.put("message",strMessage+"");

//		System.out.println("resultBL:"+resultBL);

		return(resultBL);
	}
}

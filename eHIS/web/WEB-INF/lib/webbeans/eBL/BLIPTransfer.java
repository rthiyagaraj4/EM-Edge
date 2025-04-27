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
public class BLIPTransfer
{
	public Hashtable billPatientService(Properties p, Connection con,Hashtable hashtableBill)
	{
		boolean insertable = true;
		String strNull = "", transfer_date="";

		//Billing related
		CallableStatement cstmt = null;
		Hashtable messageHashtable=new Hashtable();
		String strAddlDepYN ="";
		double p_trn_dep_amt = 0;
		String  p_charge_yn   ="";
		double  p_charge_amt  =0;
		double p_dly_charge_amt =0;

		String locale="";
		String strMessage  ="";  
		String strSpecialMessage = "";
		String error_level="";
		String error_text ="";
		String sys_message_id="";
		StringBuffer sb = new StringBuffer(" ");
		String strmoduleid = (String) hashtableBill.get("module_id");
		if ( (strmoduleid == null)||(strmoduleid.equals("")) ) 
			      strmoduleid = "IP";
		String strepisodetype = (String) hashtableBill.get("episode_type");
		if ( (strepisodetype == null)||(strepisodetype.equals("")) ) 
			      strepisodetype = "I";

		if(strmoduleid.equals("IP")) strepisodetype="I";
		else if(strmoduleid.equals("DC")) strepisodetype="D";


		locale=(String) hashtableBill.get("locale");
		if(locale==null) locale="";
		if(locale.equals(""))
		{
			locale = p.getProperty("LOCALE");
		}
		if(locale==null) locale="";

//		System.err.println("Start of BL IP Transfer");
//		System.err.println("locale:"+locale);
		//System.err.println("bl_interface_yn"+bl_interface_yn);
		transfer_date = (String) hashtableBill.get("transferdate");
		if(transfer_date == null) transfer_date="";
		if(( (String)hashtableBill.get("bl_interface_yn") ).equals("Y"))
		{
			// Charge Part
			try
			{
//				System.err.println("--------Before call BL_IP_INTERFACE.PROC_TRANSFER_MAIN...Values Printing from Here----------");
//				System.err.println("BL Interface YN::"+(String) hashtableBill.get("bl_interface_yn"));
//				System.err.println("Facility ID::"+(String) hashtableBill.get("facilityId"));
//				System.err.println("strmoduleid::"+strmoduleid);
//				System.err.println("patientid::"+(String) hashtableBill.get("patientid"));
//				System.err.println("episode_id::"+Long.parseLong((String) hashtableBill.get("episode_id")));
//				System.err.println ("encounter_id::"+Long.parseLong((String) hashtableBill.get("encounter_id")));
//				System.err.println ("srlno::"+Integer.parseInt((String)hashtableBill.get("srlno")));
//				System.err.println ("strNull::"+strNull);
//				System.err.println ("topractitionerid::"+(String) hashtableBill.get("topractitionerid"));
//				System.err.println ("frnursingunitcode::"+(String) hashtableBill.get("frnursingunitcode"));
//				System.err.println ("tonursingunitcode::"+(String) hashtableBill.get("tonursingunitcode"));
//				System.err.println ("frbedno::"+(String) hashtableBill.get("frbedno"));
//				System.err.println ("tobedno::"+(String) hashtableBill.get("tobedno"));
//				System.err.println ("frbedtype::"+(String) hashtableBill.get("frbedtype"));
//				System.err.println ("tobedtype::"+(String) hashtableBill.get("tobedtype"));
//				System.err.println ("frbedclass::"+(String) hashtableBill.get("frbedclass"));
//				System.err.println ("tobedclass::"+(String) hashtableBill.get("tobedclass"));
//				System.err.println ("transfertype::"+(String) hashtableBill.get("transfertype"));
//				System.err.println ("transferdate::"+transfer_date);
//				System.err.println ("addedById::"+(String) hashtableBill.get("addedById"));
//				System.err.println ("addedAtWorkstation::"+(String)hashtableBill.get("addedAtWorkstation"));
				
				String sql_proc_trans_bed = "{call BL_IP_INTERFACE.PROC_TRANSFER_MAIN('D','TRANSFER_PATIENT','Y','"+(String) hashtableBill.get("bl_interface_yn")+"','"+(String) hashtableBill.get("facilityId")+"','"+strmoduleid+"','"+(String) hashtableBill.get("patientid")+"','"+strepisodetype+"',"+Long.parseLong((String) hashtableBill.get("episode_id"))+","+Long.parseLong((String) hashtableBill.get("encounter_id"))+","+Integer.parseInt((String)hashtableBill.get("srlno"))+",'"+strNull+"','"+(String) hashtableBill.get("topractitionerid")+"','"+(String) hashtableBill.get("frnursingunitcode")+"','"+(String) hashtableBill.get("tonursingunitcode")+"','"+(String) hashtableBill.get("frbedtype")+"','"+(String) hashtableBill.get("tobedtype")+"','"+(String) hashtableBill.get("frbedclass")+"','"+(String) hashtableBill.get("tobedclass")+"','"+(String) hashtableBill.get("transfertype")+"',to_date('"+transfer_date+"','DD/MM/YYYY HH24:MI'),'"+(String) hashtableBill.get("addedById")+"','"+(String) hashtableBill.get("addedAtWorkstation")+"','"+locale+"',?,?,?,?,?,?,?,?,?,?)}";
	
//				System.err.println("The Sql PROC_TRANSFER_MAIN :"+sql_proc_trans_bed);

//				cstmt = con.prepareCall("{call BL_IP_INTERFACE.PROC_TRANSFER_MAIN( ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");

				cstmt = con.prepareCall(sql_proc_trans_bed);
/*
				cstmt.setString(1,"D");
				cstmt.setString(2,"TRANSFER_PATIENT");
				cstmt.setString(3,"Y");
				cstmt.setString(4,(String) hashtableBill.get("bl_interface_yn"));
				cstmt.setString(5, (String) hashtableBill.get("facilityId"));
				//cstmt.setString(6,"IP");			
				cstmt.setString(6,strmoduleid);
				cstmt.setString(7,(String) hashtableBill.get("patientid"));
				//cstmt.setString(8,"I");	
				cstmt.setString(8,strepisodetype);				
				cstmt.setLong(9,Long.parseLong((String) hashtableBill.get("episode_id")));
				cstmt.setLong(10,Long.parseLong((String) hashtableBill.get("encounter_id")));
				cstmt.setInt(11,Integer.parseInt((String)hashtableBill.get("srlno")));
				cstmt.setString(12,strNull); 
				cstmt.setString(13,(String) hashtableBill.get("topractitionerid"));
				cstmt.setString(14,(String) hashtableBill.get("frnursingunitcode"));
				cstmt.setString(15,(String) hashtableBill.get("tonursingunitcode"));
				cstmt.setString(16,(String) hashtableBill.get("frbedno"));
				cstmt.setString(17,(String) hashtableBill.get("tobedno"));
				cstmt.setString(18,(String) hashtableBill.get("frbedclass"));
				cstmt.setString(19,(String) hashtableBill.get("tobedclass"));
				cstmt.setString(20,(String) hashtableBill.get("transfertype"));
				cstmt.setString(21,(String) hashtableBill.get("addedById"));
				cstmt.setString(22,(String) hashtableBill.get("addedAtWorkstation"));
*/
				cstmt.registerOutParameter(1,java.sql.Types.VARCHAR);   
				cstmt.registerOutParameter(2,java.sql.Types.VARCHAR);  
				cstmt.registerOutParameter(3,java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(4,java.sql.Types.VARCHAR);  
				cstmt.registerOutParameter(5,java.sql.Types.VARCHAR);  
				cstmt.registerOutParameter(6,java.sql.Types.VARCHAR);  
				cstmt.registerOutParameter(7,java.sql.Types.VARCHAR);  
				cstmt.registerOutParameter(8,java.sql.Types.VARCHAR); 
				cstmt.registerOutParameter(9,java.sql.Types.VARCHAR); 
				cstmt.registerOutParameter(10,java.sql.Types.VARCHAR); 
			
//				System.err.println ("Before get All params Before Execute Procedure::");
				cstmt.execute();
//				System.err.println ("ofter Execute Procedure::");

				strAddlDepYN = cstmt.getString(1);
				if(strAddlDepYN == null) strAddlDepYN="N";
//				System.err.println ("strAddlDepYN::"+strAddlDepYN);

				String strTrnDepAmt = cstmt.getString(2);
				if(strTrnDepAmt == null || strTrnDepAmt.equals("")) strTrnDepAmt="0";
				p_trn_dep_amt   =Double.parseDouble(strTrnDepAmt);
//				System.err.println ("p_trn_dep_amt::"+p_trn_dep_amt);

				p_charge_yn    = cstmt.getString(3);
				if(p_charge_yn == null) p_charge_yn="N";
//				System.err.println ("p_charge_yn::"+p_charge_yn);

				String strChargeAmt = cstmt.getString(4);
				if(strChargeAmt == null || strChargeAmt.equals("")) strChargeAmt="0";
				p_charge_amt = Double.parseDouble(strChargeAmt);
//				System.err.println ("p_charge_amt::"+p_charge_amt);

				String strDlyChargeAmt = cstmt.getString(5);
				if(strDlyChargeAmt == null || strDlyChargeAmt.equals("")) strDlyChargeAmt="0";
				p_dly_charge_amt = Double.parseDouble(strDlyChargeAmt);
//				System.err.println ("p_dly_charge_amt::"+p_dly_charge_amt);

				strMessage = cstmt.getString(6);
				if(strMessage == null) strMessage=" ";
//				System.err.println ("strMessage::"+strMessage);

				strSpecialMessage = cstmt.getString(7);
				if(strSpecialMessage == null) strSpecialMessage=" ";
//				System.err.println ("strSpecialMessage::"+strSpecialMessage);

				error_level = cstmt.getString(8);
				if(error_level == null) error_level="";

				sys_message_id = cstmt.getString(9);
				if(sys_message_id == null) sys_message_id="";

				error_text = cstmt.getString(10);
				if(error_text == null) error_text="";

//				System.err.println ("error_level::"+error_level);
//				System.err.println ("error_text::"+error_text);
//				System.err.println ("sys_message_id::"+sys_message_id);

				/*if (error_text != null)
				{
					error_text = error_text.trim();
					if (!(error_text.equalsIgnoreCase("null") ) )
					{
						insertable = false;
						sb.append(error_text);
					}
				}*/

				if(  (!sys_message_id.equals(""))  || (error_level.equals("10") && !error_text.equals("") ) )
				{
					insertable=false;
	
					if((error_level.equals("10") && !error_text.equals("") ))
					{
						sb.append(error_text) ;
//						System.err.println("sb mesage is:"+sb);
					}
					else
					{
						messageHashtable=MessageManager.getMessage(locale,sys_message_id,"BL");
						sb.append((String)messageHashtable.get("message"));
//						System.err.println("sb mesage is:"+sb);
					}
				}
				else
				{
					insertable=true;
				}

				strMessage = "" +strMessage+ "";
//				System.err.println ("strMessage::"+strMessage);
				cstmt.close();
			}
			catch( Exception ee)
			{
				insertable = false;
				sb.append ("BLInterface  "+ee.getMessage());
			}
		}
		Hashtable resultBL =  new Hashtable();
		if (strMessage == null)
		{
			strMessage = " ";
		}
		if (strSpecialMessage == null)
		{
			strSpecialMessage = " ";
		}
		resultBL.put("status",new Boolean(insertable));
		resultBL.put("error",sb.toString());
//		System.err.println ("sb.toString()::"+sb.toString());
		resultBL.put("message",strMessage);
		resultBL.put("bl_special_message",strSpecialMessage);
//		System.err.println ("strSpecialMessage::"+strSpecialMessage);
//		System.err.println ("resultBL::"+resultBL);
		return(resultBL);
	}
}

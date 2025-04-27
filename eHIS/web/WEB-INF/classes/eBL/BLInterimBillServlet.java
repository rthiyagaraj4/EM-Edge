/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eBL;
import ecis.utils.OnlineReport;
import ecis.utils.OnlineReports;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import webbeans.eCommon.*;

public class BLInterimBillServlet extends javax.servlet.http.HttpServlet 
{
	PrintWriter out;
	public void init(ServletConfig config) throws ServletException	{
		
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws javax.servlet.ServletException,IOException
	{
		String facility_id = "";
		java.util.Properties p = null;
		//PreparedStatement pstmt = null;
		Statement stmt = null;
		Connection con=null;
		CallableStatement call = null;
		ResultSet rs = null;
		String error_level = ""; //String err_code = "0";	
		String sys_message_id = "";
		String error_text = ""; String login_user= "",client_ip_address="";
		HttpSession session = req.getSession(false);
		String locale	= (String)session.getAttribute("LOCALE");
		int intTotalrecords=0;
		boolean boolSuccess = true;	
		String strTotalrecords="";
		String strSelectedrow="",strPatientId="",strPatientName="",strEpisodeType="",strEpisodeId="",strAdmDate="",strRoomNo="",strBedNo="";
		String 	strUnbilledAmt="",strOutstandingAmt="",strTotalAmt="";
		String strCashCounterCode="",strShiftId="",strSysMessageId="";
		String strIpInhBillDocTypeCode="",strPayerType="",strAdjustDep_YN="",strPrepayAdj_YN="",sys_date="";
		String str_org_from_doc_type_code="",str_org_from_doc_num="",str_org_to_doc_type_code="",str_org_to_doc_num="",str_bill_mpi_id="",strCustCode="";
		String from_leg="",to_leg="",bill_gen_leg="";
		Hashtable messageHashtable=new Hashtable();
		String msg="";

		facility_id = (String)session.getAttribute("facility_id") ;
		p = (java.util.Properties) session.getAttribute( "jdbc" ) ;
		client_ip_address = p.getProperty("client_ip_address");
//		System.out.println("str_tot_records client_ip_address :"+client_ip_address);
		login_user = p.getProperty( "login_user" ) ;
//		System.out.println("str_tot_records login_user :"+login_user);		
//		System.out.println("inside servlet interim");
		try 
		{
			this.out = res.getWriter();			
			out.println("<html>");
			out.println("<head>");
			con = ConnectionManager.getConnection(req);
			con.setAutoCommit(false);

			java.util.Locale loc = new java.util.Locale(locale);
			java.util.ResourceBundle bl_labels = java.util.ResourceBundle.getBundle("eBL.resources.Labels",loc);
			java.util.ResourceBundle common_labels = java.util.ResourceBundle.getBundle("eCommon.resources.Labels",loc);
			bill_gen_leg = (String)bl_labels.getString("eBL.BILL_GENERATED.label");
			from_leg = (String)common_labels.getString("Common.from.label");
			to_leg = (String)common_labels.getString("Common.to.label");			
//			System.out.println("bill_gen_leg "+bill_gen_leg);
//			System.out.println("from_leg "+from_leg);
//			System.out.println("to_leg "+to_leg);
			
			
			strPayerType=req.getParameter("payer_type");
			if(strPayerType== null || strPayerType.equals("")) strPayerType="";
//			System.out.println("strPayerType :"+strPayerType);			
			
			if(strPayerType.equals("I"))
			strPayerType="";

			if(strPayerType.equals("B"))
			strPayerType="";

			String query_date="select to_char(sysdate,'dd/mm/yyyy hh24:mi:ss') from dual";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query_date) ;
			if( rs != null ) 
			{
				while( rs.next() )
				{  
					sys_date = rs.getString(1);
//					System.out.println("sys_date :"+sys_date);
				
				}
			}

			rs.close();
			stmt.close();
	
		try{
			String sqlcashctr="{ call  Bl_User_Check_For_Cash_Counter('"+facility_id+"','I','"+login_user+"','"+client_ip_address+"',?,?,?)}";
//			System.out.println("sqlcashctr :"+sqlcashctr);
		    call = con.prepareCall(sqlcashctr);

			call.registerOutParameter(1,java.sql.Types.VARCHAR);
		    call.registerOutParameter(2,java.sql.Types.VARCHAR);
		    call.registerOutParameter(3,java.sql.Types.VARCHAR);
			call.execute();

			strCashCounterCode		 = call.getString(1);		
        	strShiftId		 = call.getString(2);		
			strSysMessageId     	 = call.getString(3);				
			if ( strCashCounterCode == null ) strCashCounterCode = "";
			if ( strShiftId == null ) strShiftId ="";
		    if ( strSysMessageId == null ) strSysMessageId ="";
//			System.out.println("strCashCounterCode :"+strCashCounterCode);
//			System.out.println("strShiftId :"+strShiftId);
//			System.out.println("strSysMessageId :"+strSysMessageId);

				if(!strSysMessageId.equals(""))
				{
					boolSuccess = false;
					messageHashtable=MessageManager.getMessage(locale,strSysMessageId,"BL");
					msg=(String)messageHashtable.get("message");
					out.println("<script> alert('"+msg+"');  </script>");
				}
				else
				{
					boolSuccess = true;
				}
				call.close();

	if (boolSuccess)
	{
		String sqldoctype="{ call  BLCOMMON.proc_get_doc_type('"+facility_id+"','"+strCashCounterCode+"',?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
//		System.out.println("sqlcashctr :"+sqldoctype);
		call = con.prepareCall(sqldoctype);
		call.registerOutParameter(1,java.sql.Types.VARCHAR);
		call.registerOutParameter(2,java.sql.Types.VARCHAR);
		call.registerOutParameter(3,java.sql.Types.VARCHAR);
		call.registerOutParameter(4,java.sql.Types.VARCHAR);
		call.registerOutParameter(5,java.sql.Types.VARCHAR);
		call.registerOutParameter(6,java.sql.Types.VARCHAR);
		call.registerOutParameter(7,java.sql.Types.VARCHAR);
		call.registerOutParameter(8,java.sql.Types.VARCHAR);
		call.registerOutParameter(9,java.sql.Types.VARCHAR);
		call.registerOutParameter(10,java.sql.Types.VARCHAR);
		call.registerOutParameter(11,java.sql.Types.VARCHAR);	
		call.registerOutParameter(12,java.sql.Types.VARCHAR);	
		call.registerOutParameter(13,java.sql.Types.VARCHAR);	
		call.registerOutParameter(14,java.sql.Types.VARCHAR);	
		call.registerOutParameter(15,java.sql.Types.VARCHAR);	
		call.registerOutParameter(16,java.sql.Types.VARCHAR);	
		call.registerOutParameter(17,java.sql.Types.VARCHAR);	
		call.registerOutParameter(18,java.sql.Types.VARCHAR);	
		call.registerOutParameter(19,java.sql.Types.VARCHAR);			

		call.execute();
		strIpInhBillDocTypeCode= call.getString(3);
		error_level= call.getString(17);
		sys_message_id= call.getString(18);
		error_text= call.getString(19);

		if ( strIpInhBillDocTypeCode == null ) strIpInhBillDocTypeCode = "";
		if ( error_level == null ) error_level = "";
		if ( sys_message_id == null ) sys_message_id = "";
		if ( error_text == null ) error_text = "";

//		System.out.println("strIpInhBillDocTypeCode :"+strIpInhBillDocTypeCode);
//		System.out.println("error_level :"+error_level);
//		System.out.println("sys_message_id :"+sys_message_id);
//		System.out.println("error_text :"+error_text);

		if (!sys_message_id.equals("")||(error_level.equals("10") && !error_text.equals("")))
							{
								boolSuccess = false;
								if (error_level.equals("10") ||(!error_text.equals("")))
								{
									
									boolSuccess = false;
									out.println("<script> alert('"+error_text+"');  </script>");
								}
								if(!sys_message_id.equals(""))
								{
									boolSuccess = false;
									messageHashtable=MessageManager.getMessage(locale,sys_message_id,"BL");
									msg=(String)messageHashtable.get("message");
									out.println("<script> alert('"+msg+"');  </script>");
								}							
							}
							else
							{
								boolSuccess = true;

							}							
							call.close();			
	}
		}catch(Exception ee)
		{
			System.out.println("cash counter" +ee);
		}		
					
	if (boolSuccess)
	{
		try{
			strTotalrecords=req.getParameter("total_records");
			if(strTotalrecords==null || strTotalrecords.equals("")) strTotalrecords="";
//			System.out.println("str_tot_records interim;"+strTotalrecords);
			intTotalrecords=Integer.parseInt(strTotalrecords);
			
			for(int i=0;i<intTotalrecords;i++)
			{
				strSelectedrow=req.getParameter("selected_row"+i);
				if(strSelectedrow==null || strSelectedrow.equals("")) strSelectedrow="";
				if(strSelectedrow.equals("1"))
				{
//					System.out.println("str_tot_records selected_row;"+strSelectedrow);					
					strPatientId=req.getParameter("patient_id"+i);
					if(strPatientId== null || strPatientId.equals("")) strPatientId="";
//					System.out.println("str_tot_records patient_id;"+ strPatientId);

					strPatientName=req.getParameter("patient_name"+i);
					if(strPatientName== null || strPatientName.equals("")) strPatientName="";
//					System.out.println("str_tot_records strPatientName;"+ strPatientName);

					strEpisodeType=req.getParameter("episode_type"+i);
					if(strEpisodeType== null || strEpisodeType.equals("")) strEpisodeType="";
//					System.out.println("str_tot_records strEpisodeType;"+ strEpisodeType);
					
					strEpisodeId=req.getParameter("episode_id"+i);
					if(strEpisodeId== null || strEpisodeId.equals("")) strEpisodeId="";
//					System.out.println("str_tot_records strEpisodeId;"+ strEpisodeId);
					
					strAdmDate=req.getParameter("adm_date"+i);
					if(strAdmDate== null || strAdmDate.equals("")) strAdmDate="";
//					System.out.println("str_tot_records strAdmDate;"+ strAdmDate);
					if(!locale.equals("en"))
					{
						strAdmDate=com.ehis.util.DateUtils.convertDate(strAdmDate,"DMYHMS",locale,"en");
//						System.out.println("strAdmDate==> "+strAdmDate);
					}


					strRoomNo=req.getParameter("room_no"+i);
					if(strRoomNo== null || strRoomNo.equals("")) strRoomNo="";
//					System.out.println("str_tot_records strRoomNo;"+ strRoomNo);

					strBedNo=req.getParameter("bed_no"+i);
					if(strBedNo== null || strBedNo.equals("")) strBedNo="";
//					System.out.println("str_tot_records strBedNo;"+ strBedNo);

					strUnbilledAmt=req.getParameter("unbill_amt"+i);
					if(strUnbilledAmt== null || strUnbilledAmt.equals("")) strUnbilledAmt="";
//					System.out.println("str_tot_records strUnbilledAmt;"+ strUnbilledAmt);

					strOutstandingAmt=req.getParameter("outstand_amt"+i);
					if(strOutstandingAmt== null || strOutstandingAmt.equals("")) strOutstandingAmt="";
//					System.out.println("str_tot_records strOutstandingAmt;"+ strOutstandingAmt);
					
					strTotalAmt=req.getParameter("total_amt"+i);
					if(strTotalAmt== null || strTotalAmt.equals("")) strTotalAmt="";
//					System.out.println("str_tot_records strTotalAmt;"+ strTotalAmt);
					
					strAdjustDep_YN=req.getParameter("adjust_dep"+i);
					if(strAdjustDep_YN== null || strAdjustDep_YN.equals("")) strAdjustDep_YN="N";
//					System.out.println("str_tot_records strAdjustDep_YN;"+ strAdjustDep_YN);

					strPrepayAdj_YN=req.getParameter("prepay_adj_yn"+i);
					if(strPrepayAdj_YN== null || strPrepayAdj_YN.equals("")) strPrepayAdj_YN="N";
//					System.out.println("str_tot_records strPrepayAdj_YN;"+ strPrepayAdj_YN);
					
					strCustCode=req.getParameter("cust_code"+i);
					if(strCustCode== null || strCustCode.equals("")) strCustCode="";
//					System.out.println("str_tot_records strCustCode;"+ strCustCode);
					//p_bill_trx_type="T"
					String sqlIns="{ call  BLTIPDSC.BL_DISCHARGE_BILL('T','"+strPatientId+"','"+strEpisodeId+"','"+strIpInhBillDocTypeCode+"',TO_DATE('"+sys_date+"','DD/MM/YYYY hh24:mi:ss'),'','','','"+login_user+"','"+strCashCounterCode+"','"+strShiftId+"','"+client_ip_address+"','"+facility_id+"','"+facility_id+"','','','','','','"+strAdjustDep_YN+"','"+strPrepayAdj_YN+"','"+strPayerType+"','"+strCustCode+"',TO_DATE('"+sys_date+"','DD/MM/YYYY hh24:mi:ss'),?,?,?,?,?,?,?,?)}";
//					   System.out.println("sqlIns :"+sqlIns);
					    call = con.prepareCall(sqlIns);
						call.registerOutParameter(1,java.sql.Types.VARCHAR);
						call.registerOutParameter(2,java.sql.Types.VARCHAR);
						call.registerOutParameter(3,java.sql.Types.VARCHAR);
						call.registerOutParameter(4,java.sql.Types.VARCHAR);
						call.registerOutParameter(5,java.sql.Types.VARCHAR);
						call.registerOutParameter(6,java.sql.Types.VARCHAR);
						call.registerOutParameter(7,java.sql.Types.VARCHAR);
						call.registerOutParameter(8,java.sql.Types.VARCHAR);

							call.execute();
							str_org_from_doc_type_code= call.getString(1);   
							str_org_from_doc_num = call.getString(2);   
							str_org_to_doc_type_code = call.getString(3);   
							str_org_to_doc_num= call.getString(4) ;
							str_bill_mpi_id=call.getString(5) ;
							error_level = call.getString(6);   
							sys_message_id = call.getString(7);   
							error_text = call.getString(8);
							if ( str_org_from_doc_type_code == null ) str_org_from_doc_type_code = "";
							if ( str_org_from_doc_num == null ) str_org_from_doc_num = "";
							if ( str_org_to_doc_type_code == null ) str_org_to_doc_type_code = "";
							if ( str_org_to_doc_num == null ) str_org_to_doc_num = "";
							if(str_bill_mpi_id == null) str_bill_mpi_id="";
							if ( error_level == null ) error_level = "";
							if ( sys_message_id == null ) sys_message_id = "";
							if ( error_text == null ) error_text = "";
//							System.out.println("str_org_from_doc_type_code :"+str_org_from_doc_type_code);
//							System.out.println("str_org_from_doc_num :"+str_org_from_doc_num);
//							System.out.println("str_org_to_doc_type_code :"+str_org_to_doc_type_code);
//							System.out.println("str_org_to_doc_num :"+str_org_to_doc_num);
//							System.out.println("str_bill_mpi_id :"+str_bill_mpi_id);
//							System.out.println("error_level :"+error_level);
//							System.out.println("sys_message_id :"+sys_message_id);
//							System.out.println("error_text :"+error_text);

																
							//if ((err_code == null)|| err_code.equalsIgnoreCase("null")) err_code = "0";

							if (!sys_message_id.equals("")||(error_level.equals("10") && !error_text.equals("")))
							{
								con.rollback();
								con.close();
								boolSuccess = false;
								if (error_level.equals("10") ||(!error_text.equals("")))
								{
									
									boolSuccess = false;
									out.println("<script> alert('"+error_text+"');  </script>");
								}
								if(!sys_message_id.equals(""))
								{
									boolSuccess = false;
									messageHashtable=MessageManager.getMessage(locale,sys_message_id,"BL");
									msg=(String)messageHashtable.get("message");
									out.println("<script> alert('"+msg+"');  </script>");
								}								
							
							//out.println("<script>parent.search_hdr.document.forms(0).funRefresh(); parent.parent.interim_main.location.href='../eBL/jsp/BLBillInterimFrame.jsp';</script>");				
							}
							else
							{
								con.commit();


								if(str_org_from_doc_num.equals("0") && str_org_to_doc_num.equals("0"))
								{
									messageHashtable=MessageManager.getMessage(locale,"BL9795","BL");
									msg=(String)messageHashtable.get("message");
									out.println("<script> alert('"+msg+"');  </script>");
								}else{
								String final_message=bill_gen_leg+" "+from_leg+" "+str_org_from_doc_type_code+"/"+str_org_from_doc_num+" "+to_leg+" "+str_org_to_doc_type_code+"/"+str_org_to_doc_num;
								out.println("<script> alert('"+final_message+"'); parent.parent.interim_main.location.href='../eBL/jsp/BLBillInterimFrame.jsp';</script>");
								//out.println("<script> alert('success'); parent.parent.interim_main.location.href='../eBL/jsp/BLBillInterimFrame.jsp';</script>");				
								}
								call.close();
								boolSuccess = true;
							}		
						}
			}
		}catch(Exception e)
		{
			System.out.println("rrr" +e);
		}
		
	}
		out.println("</head>");
		out.println("</html>");

}catch(Exception exp)
		{
			System.out.println("main" +exp);
		}
		finally
		{
			//if(pstmt != null)pstmt.close();
			ConnectionManager.returnConnection(con, req);
		}
	
		
  }
}

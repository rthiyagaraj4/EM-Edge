<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*, java.util.*, eBL.BLReportIdMapper" contentType="text/html;charset=UTF-8" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<HTML>
	<HEAD>
		<TITLE> <fmt:message key="eBL.BILL_SLMT_DTL.label" bundle="${bl_labels}"/> </TITLE>
		<!--<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link>-->
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		boolean amtRoundOff = true;//Added V180123-Aravindh/MMS-JU-SCF-0102
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<!--<script language="javascript" src="../../eCommon/js/messages.js"></script>-->
		<script language="javascript"src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
<%	
		//Added by Manivel Natarajan on 10/Aug/2006
		request.setCharacterEncoding("UTF-8");
System.out.println("BLBillSlmtMain.jsp 24");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; ResultSet rs1 = null;	ResultSet rs2 = null;	
		con	=	ConnectionManager.getConnection(request);
		String strfacilityid	=  (String) session.getValue("facility_id");
		if(strfacilityid == null) strfacilityid="";
		String strloggeduser	=  (String) session.getValue("login_user");			
		if(strloggeduser == null) strloggeduser="";
		HttpSession httpSession = request.getSession(false);
		Properties p = (Properties)httpSession.getValue("jdbc");	
		//int noofdecimal = 2; 
		int noofdecimal = 0; //Added by muthu for 31094 - no.of decimal values on 31-5-12
		String strclientip = p.getProperty("client_ip_address");
		String strblnggrpid	="";String pkg_seq_no="";String pkg_code="";//,str_bl_package_enabled_yn="N";
		//String query_string=request.getQueryString();
		String strdfltcashbillslmtamt = "", ext_acc_interface_yn="";
		String unavail_service_code="";	
		//Added for Bill Maintanence
		String billMaintain = request.getParameter("billMaintain");

		if(billMaintain == null || "null".equals(billMaintain)){
			billMaintain = "";
		}
		//Added for Bill Maintanence
		//KDAH-CRF-0318
		//ML-MMOH-CRF-0753
		String billAlreadyPrinted = request.getParameter("billAlreadyPrinted");
		if(billAlreadyPrinted == null || "null".equals(billAlreadyPrinted)){
			billAlreadyPrinted = "N";
		}
		String addlChargeAmtForBill = "";
		try
		{
			/****************added for package billing refund****************************/
			String call_frm = request.getParameter("call_frm")==null?"": request.getParameter("call_frm");
//			System.out.println("call_frm main :"+call_frm);
			String strbilldoctypecode ="";String strbilldocnum ="";
//Added by muthu for 31094 - no.of decimal values on 31-5-12
	try
		{		
		//pstmt = con.prepareStatement( " select blcommon.get_bill_round_decimal_place ('"+strfacilityid+"') from dual ");
			pstmt = con.prepareStatement("select blcommon.get_decimal_place('"+strfacilityid+"') from dual");
				
				rs = pstmt.executeQuery();	
				if ( rs.next() && rs != null )
				{
					noofdecimal  =  rs.getInt(1);
 				//System.out.println("get_decimal_place @ noofdecimal==> "+noofdecimal);
				}
			}
			catch(Exception e)
			{   e.printStackTrace();
				System.out.println("4="+e.toString());
			}
			finally 
			{
				if (rs != null)   rs.close();
				if (pstmt != null) pstmt.close();		 		
			}
//Added by muthu for 31094 - no.of decimal values on 31-5-12

			//Added V180123-Aravindh/MMS-JU-SCF-0102 try
			try {
				pstmt = con.prepareStatement("select BILL_ROUNDING_IND  from bl_parameters");
				
				rs = pstmt.executeQuery();	
				if ( rs != null && rs.next())
				{
					if(rs.getString("BILL_ROUNDING_IND").trim().equalsIgnoreCase("0")) {
						amtRoundOff = false;
					}
				}
			} catch(Exception e) {   
				e.printStackTrace();
				System.out.println("4="+e.toString());
			} finally {
				if (rs != null)   rs.close();
				if (pstmt != null) pstmt.close();		 		
			}
			//if(str_bl_package_enabled_yn.equals("Y")){
			if(!call_frm.equals("") && call_frm.equals("PKG_RFND"))
			{
				String frmdoctype			= request.getParameter("frmdoctype")==null?"": request.getParameter("frmdoctype");
				String frmdocnum			= request.getParameter("frmdocnum")==null?"": request.getParameter("frmdocnum");
				String todoctype			= request.getParameter("todoctype")==null?"": request.getParameter("todoctype");
				String todocnum				= request.getParameter("todocnum")==null?"": request.getParameter("todocnum");
				pkg_seq_no				= request.getParameter("pkg_seq_no")==null?"": request.getParameter("pkg_seq_no");
				pkg_code				= request.getParameter("pkg_code")==null?"": request.getParameter("pkg_code");

				try
				{		
					pstmt = con.prepareStatement("SELECT DISTINCT bill_DOC_TYPE_CODE, bill_doc_num FROM bl_patient_charges_folio WHERE bill_DOC_TYPE_CODE BETWEEN ? AND ? AND bill_doc_num BETWEEN  ? AND   ? AND SETTLEMENT_IND = 'C' ")	;
					
					pstmt.setString(1,frmdoctype);
					pstmt.setString(2,todoctype);
					pstmt.setString(3,frmdocnum);
					pstmt.setString(4,todocnum);	

					System.err.println("fix 6 in BLBillSlmtMain.jsp");
					rs = pstmt.executeQuery();	
					if ( rs.next() && rs != null ) 
					  {	 	
						strbilldoctypecode  =  rs.getString(1); 
						strbilldocnum     =  rs.getString(2);					
					  }
				}catch(Exception e) 
				{
					e.printStackTrace();
					//out.println(e.toString());	
				}
				finally 
				{
					if (rs != null)   rs.close();
					if (pstmt != null) pstmt.close();		 	
				}	
			}
			//}/************PACKAGE BILLING*****************ENDS**/
			else
			{
				strbilldoctypecode         = request.getParameter("billdoctypecode");
				if(strbilldoctypecode == null || strbilldoctypecode.equals(" ")) strbilldoctypecode="";
				strbilldocnum              = request.getParameter("billdocnum");			
				if(strbilldocnum == null || strbilldocnum.equals(" ")) strbilldocnum="";
			}
			
			String p_patient_id     =  request.getParameter("patient_id");	
			if(p_patient_id == null) p_patient_id="";
			/****************added for package billing refund**********************starts******/
//to get billing group
			if(call_frm.equals("PKG_RFND"))
			{
				String pkg_enc_id="",pkg_visit_id="",pkg_epi_type="";
				try
				{		
					//pstmt = con.prepareStatement("SELECT ENCOUNTER_ID,VISIT_ID,EPISODE_TYPE FROM BL_PACKAGE_ENCOUNTER_DTLS WHERE PATIENT_ID='"+p_patient_id+"' and  PACKAGE_CODE='"+pkg_code+"' and  PACKAGE_SEQ_NO='"+pkg_seq_no+"'");		
					pstmt = con.prepareStatement("SELECT encounter_id, visit_id, episode_type  FROM bl_package_encounter_dtls A  WHERE operating_facility_id = ? AND patient_id = ? AND package_code = ?    AND package_seq_no = ?   AND package_seq_no IN ( SELECT package_seq_no FROM bl_package_sub_hdr     WHERE operating_facility_id = ? AND patient_id = ? AND package_code = ? AND package_seq_no = ?  AND status = 'C')");
					
					pstmt.setString(1,strfacilityid);
					pstmt.setString(2,p_patient_id);
					pstmt.setString(3,pkg_code);
					pstmt.setString(4,pkg_seq_no);	
					pstmt.setString(5,strfacilityid);
					pstmt.setString(6,p_patient_id);
					pstmt.setString(7,pkg_code);
					pstmt.setString(8,pkg_seq_no);	
					rs1 = pstmt.executeQuery();	
					while( rs1.next() && rs1 != null ) 
					{	 	
						pkg_enc_id  =  rs1.getString(1); 
						pkg_visit_id     =  rs1.getString(2);					
						pkg_epi_type     =  rs1.getString(3);					
					}
					rs1.close();
					pstmt.close();
				}
				catch(Exception e) 
				{   
					e.printStackTrace();
					//System.out.println("BL_PACKAGE_ENCOUNTER_DTLS main :"+e);	
					//out.println(e.toString());	
				}
				if(pkg_enc_id == null) pkg_enc_id="";
				if(pkg_visit_id == null) pkg_visit_id="";
				if(pkg_epi_type == null) pkg_epi_type="";
				//System.out.println("pkg_enc_id main :"+pkg_enc_id);			
				//System.out.println("pkg_visit_id main :"+pkg_visit_id);			
				//System.out.println("pkg_epi_type main :"+pkg_epi_type );			
			
				try
				{		
					if(pkg_epi_type.equals("O"))
					{
//						pstmt = con.prepareStatement("SELECT BLNG_GRP_ID FROM bl_visit_fin_dtls WHERE PATIENT_ID='"+p_patient_id+"' and  EPISODE_ID='"+pkg_enc_id+"' and  VISIT_ID='"+pkg_visit_id+"'");		
						pstmt = con.prepareStatement("SELECT BLNG_GRP_ID FROM bl_visit_fin_dtls WHERE PATIENT_ID=? and  EPISODE_ID=? and  VISIT_ID=? and episode_type=? and operating_facility_id=? ");	

						pstmt.setString(1,p_patient_id);
						pstmt.setString(2,pkg_enc_id);
						pstmt.setString(3,pkg_visit_id);
						pstmt.setString(4,pkg_epi_type);
						pstmt.setString(5,strfacilityid);
						rs2 = pstmt.executeQuery();	
						while( rs2.next() && rs2 != null ) 
						  {	 	
							strblnggrpid  =  rs2.getString(1); 										
						  }
					}
					else if(pkg_epi_type.equals("I") || pkg_epi_type.equals("D"))
					{
						pstmt = con.prepareStatement("SELECT BLNG_GRP_ID FROM bl_episode_fin_dtls WHERE PATIENT_ID=? and  EPISODE_ID=? and episode_type=? and operating_facility_id=?");//and  VISIT_ID='"+pkg_visit_id+"'");		
						
						pstmt.setString(1,p_patient_id);
						pstmt.setString(2,pkg_enc_id);
						pstmt.setString(3,pkg_epi_type);
						pstmt.setString(4,strfacilityid);
						
						rs2 = pstmt.executeQuery();	
						while( rs2.next() && rs2 != null ) 
						  {	 	
							strblnggrpid  =  rs2.getString(1); 										
						  }
					}
					rs2.close();
					pstmt.close();
				}
				catch(Exception e) 
				{   
					e.printStackTrace();
					//System.out.println("bl_episode_fin_dtls main :"+e);	
					//out.println(e.toString());	
				}
				if(strblnggrpid == null) strblnggrpid="";
				//System.out.println("strblnggrpid main :"+strblnggrpid);		
			}
			else
			{
/****************added for package billing refund***********************ends*****/
				strblnggrpid		=  request.getParameter("blnggrp");	
				if(strblnggrpid == null) strblnggrpid="";
			}
			String billgenlater     =  request.getParameter("billgenlater");	
			if(billgenlater == null || billgenlater.equals(" ")) billgenlater="N";

			String p_function_id     =  request.getParameter("function_id");	
			if(p_function_id == null) p_function_id="";

			String p_module_id     =  request.getParameter("module_id");	
			if(p_module_id == null) p_module_id="";

			String p_clinic_code     =  request.getParameter("clinic_code");	
			if(p_clinic_code == null) p_clinic_code="";

			String p_visit_type_code     =  request.getParameter("visit_type_code");	
			if(p_visit_type_code == null) p_visit_type_code="";
		

			String p_episode_type     =  request.getParameter("episode_type");	
			if(p_episode_type == null) p_episode_type="";

			String p_encounter_id     =  request.getParameter("p_encounter_id");	
			if(p_encounter_id == null) p_encounter_id="";

			String p_episode_id     =  request.getParameter("p_episode_id");	
			if(p_episode_id == null) p_episode_id="";

			String p_visit_id     =  request.getParameter("p_visit_id");	
			if(p_visit_id == null) p_visit_id="";

			String p_user     =  request.getParameter("p_user");	
			if(p_user == null) p_user="";

			String p_ws_no     =  request.getParameter("p_ws_no");	
			if(p_ws_no == null) p_ws_no="";

			String locale			= (String)session.getAttribute("LOCALE");
			if(locale == null) locale="en";

			String called_frm  =  request.getParameter("function_id");	
			if(called_frm == null) called_frm="";

			String alw_co_wit_bl_slmt_yn = request.getParameter("alw_co_wit_bl_slmt_yn");	
			if(alw_co_wit_bl_slmt_yn == null) alw_co_wit_bl_slmt_yn="";

			if(alw_co_wit_bl_slmt_yn.equals(""))
			{
				alw_co_wit_bl_slmt_yn = request.getParameter("allow_chkout_with_bill_stmt_yn");	
				if(alw_co_wit_bl_slmt_yn == null) alw_co_wit_bl_slmt_yn="N";
			}

			String cal_frm_multi_bil_slmt = request.getParameter("cal_frm_multi_bil_slmt");	
			if(cal_frm_multi_bil_slmt == null) cal_frm_multi_bil_slmt="";

/*			System.err.println("strblnggrpid:"+strblnggrpid);
			System.err.println("strbilldoctypecode:"+strbilldoctypecode);
			System.err.println("strbilldocnum:"+strbilldocnum);
			System.err.println("billgenlater:"+billgenlater);
			System.err.println("p_function_id:"+p_function_id);
			System.err.println("p_module_id:"+p_module_id);
			System.err.println("p_clinic_code:"+p_clinic_code);
			System.err.println("p_visit_type_code:"+p_visit_type_code);
			System.err.println("p_patient_id:"+p_patient_id);
			System.err.println("p_episode_type:"+p_episode_type);
			System.err.println("p_encounter_id:"+p_encounter_id);
			System.err.println("p_episode_id:"+p_episode_id);
			System.err.println("p_visit_id:"+p_visit_id);
			System.err.println("p_user:"+p_user);
			System.err.println("p_ws_no:"+p_ws_no);
			System.err.println("locale:"+locale);
			System.err.println("called_frm:"+called_frm);
			System.err.println("alw_co_wit_bl_slmt_yn:"+alw_co_wit_bl_slmt_yn);
			System.err.println("cal_frm_multi_bil_slmt:"+cal_frm_multi_bil_slmt);			
*/
			String strslmtidno		= "";	String strslmtpayername = "";	String strepitype   = "";
			String strunknownpatientyn = "N";	String strpatid		    = "";	
			if (strbilldoctypecode == null || strbilldoctypecode.equalsIgnoreCase("null")) 
			{	strbilldoctypecode = ""; }
			if (strbilldocnum == null || strbilldocnum.equalsIgnoreCase("null")) 
			{strbilldocnum = "";}		
			//if (strbilldoctypecode.trim().length() == 0 )

			if (strbilldoctypecode.equals(""))
			{			
%>
				<script>			
					/* parent.window.returnValue="N";
					window.close();	 */
					if(parent.window[1] && parent.window[1].document.getElementById('dialog-body'))
					{
						//console.log(parent.window[1]);
						var dialogBody = parent.window[1].document.getElementById('dialog-body');
						dialogBody.contentWindow.returnValue ="N"; 
						var dialogTag = parent.window[1].document.getElementById('dialog_tag');
						dialogTag.close();
						
					}
					else if(parent.document.getElementById('dialog-body'))
					{
						console.log("line 343 BLBillSlmtMain.jsp")
						
						var dialogBody =  parent.document.getElementById('dialog-body');
					
						dialogBody.contentWindow.returnValue ="N"; 
						var dialogTag = parent.document.getElementById('dialog_tag')
						dialogTag.close();
						
					}
					else if(parent.parent.document.getElementById('dialog-body'))
					{
						//console.log("line 349 BLBillSlmtMain.jsp")
						var dialogBody = parent.parent.document.getElementById('dialog-body');
						dialogBody.contentWindow.returnValue ="N"; 
						//console.log(dialogBody)
						var dialogTag = parent.parent.document.getElementById('dialog_tag');
						dialogTag.close();
						
					}
					
					
				</script>
<%
			}
			else
			{	
				String strbillpayableamt = "";	//String strblnggrpid	= "";		
				String strcliniccode = "";		String strwsno = "";
				String strcashcountercode = "";		String strshiftid	= "";
				String strsysmessageid = "";		String strerrortext = "";
				String strpatientid ="";		String strepisodetype = "";
				String strepisodeid = "";		String strvisitid =""; String strencounterid="";
				String strprintvisitbilltype ="";		String strprintzerobillcouponyn = "",strbillnaturecode="";
				String strbillgenyn				= "";		String strzerobillgenyn			= "",strroundingamt="";
				String strslmtyn = "Y"; 		String strerrorlevel = "";		
			
				//unused variable, commented on 09/06/05
				//double billpayableamt = 0;	
			
				//String strclientname = InetAddress.getByName((String) //strclientip).getHostName().toUpperCase();
				if (strblnggrpid == null || strblnggrpid.equalsIgnoreCase("null")) 
				{strblnggrpid = "";}		
				try
				{		
//					pstmt = con.prepareStatement( " select clinic_code, episode_type,patient_id,bill_nature_code from bl_bill_hdr where operating_facility_id = '" + strfacilityid + "' and doc_type_code= '" + strbilldoctypecode + "' and doc_num = '" + strbilldocnum + "'");	
					pstmt = con.prepareStatement( " select clinic_code, episode_type,patient_id,bill_nature_code,nvl(bill_tot_outst_amt,0), patient_id,episode_type,episode_id,visit_id,nvl(BILL_ROUNDING_AMT,0),ENCOUNTER_ID,nvl(addl_charge_amt,0) addl_charge_amt from bl_bill_hdr where operating_facility_id = ? and doc_type_code= ? and doc_num = ? ");
	
					pstmt.setString(1,strfacilityid);
					pstmt.setString(2,strbilldoctypecode);
					pstmt.setString(3,strbilldocnum);

					rs = pstmt.executeQuery();	
					if ( rs.next() && rs != null ) 
					{	 	
						strcliniccode  =  rs.getString(1); 
						strepitype     =  rs.getString(2);
						strpatid       =  rs.getString(3);
						strbillnaturecode = rs.getString(4);
						strbillpayableamt =  rs.getString(5);
						//System.out.println("strbillpayableamt 310 Main.jsp "+strbillpayableamt);
						strpatientid =  rs.getString(6);	
						strepisodetype =  rs.getString(7);			
						strepisodeid =  rs.getString(8);			
						strvisitid =  rs.getString(9);	
						strroundingamt = rs.getString(10);	
						strencounterid = rs.getString(11);
						addlChargeAmtForBill = rs.getString("addl_charge_amt");						
					}
				}
				catch(Exception e) 
				{   
					e.printStackTrace();
					//out.println(e.toString());	
				}
				finally 
				{
					if (rs != null)   rs.close();
					if (pstmt != null) pstmt.close();		 	
				}	

				if ( strcliniccode == null || strcliniccode.equalsIgnoreCase("null")) 
					strcliniccode = "";

				if ( strepitype == null || strepitype.equalsIgnoreCase("null")) 
					 strepitype = "";

				if ( strpatid == null || strpatid.equalsIgnoreCase("null")) 
					 strpatid = "";

				if ( strbillnaturecode == null || strbillnaturecode.equalsIgnoreCase("null")) 
					 strbillnaturecode = "";

//				System.err.println("strbillnaturecode :" +strbillnaturecode);
				/*Added by Karthik for Report Reprint called from Starts*/
				if("Y".equals(billMaintain)){					
				
					String reprint_billdoctypecode=request.getParameter("billdoctypecode");
					String reprint_billdocnum=request.getParameter("billdocnum");
					String reprint_moduleid="";
					
					String sqlReprintReportModule="select distinct module_id from BL_PATIENT_CHARGES_FOLIO where BILL_DOC_TYPE_CODE=? and BILL_DOC_NUM=? and OPERATING_FACILITY_ID=?";
					
					try
					{	
						pstmt = con.prepareStatement(sqlReprintReportModule);
						pstmt.setString(1, reprint_billdoctypecode);
						pstmt.setString(2, reprint_billdocnum);
						pstmt.setString(3, strfacilityid);
						rs = pstmt.executeQuery();	
						if ( rs.next() && rs != null ) 
						{ 	
							reprint_moduleid =  rs.getString(1);							
						}
					}
					catch(Exception e) 
					{   
						e.printStackTrace();
						//out.println(e.toString());	
					}
					finally 
					{
						if (rs != null)   rs.close();
						if (pstmt != null) pstmt.close();		 	
					}	
					
					session.setAttribute("BL_MODULE_CALLED_FROM_REPORT_REPRINT", reprint_moduleid);
					
				}
				//billMaintain added in condition Rajesh V
				if(!strbillnaturecode.equals("C") && !"Y".equals(billMaintain))
				{
%>
						<script>
						
							 parent.window.returnValue="N";
							window.close();	 
						</script>
<%

				}

				try
				{	
					//pstmt = con.prepareStatement( " select nvl(pat_dtls_unknown_yn,'N') from mp_patient where patient_id = '" + strpatid + "'" );
				//	pstmt = con.prepareStatement( " select nvl(pat_dtls_unknown_yn,'N'),NATIONAL_ID_NO, SUBSTR(PATIENT_NAME,1,40) from mp_patient where patient_id = '" + strpatid + "'" );
					pstmt = con.prepareStatement( " select nvl(pat_dtls_unknown_yn,'N'),NATIONAL_ID_NO, PATIENT_NAME from mp_patient where patient_id = '" + strpatid + "'" );
					rs = pstmt.executeQuery();	
					if ( rs.next() && rs != null ) 
					{ 	
						strunknownpatientyn =  rs.getString(1);
						strslmtidno  =   rs.getString(2);			
						strslmtpayername =  rs.getString(3);
					}
				}
				catch(Exception e) 
				{   
					e.printStackTrace();
					//out.println(e.toString());	
				}
				finally 
				{
					if (rs != null)   rs.close();
					if (pstmt != null) pstmt.close();		 	
				}	

				if ( strunknownpatientyn == null || strunknownpatientyn.equalsIgnoreCase("null")) 
					strunknownpatientyn = "";
				if ( strslmtidno == null ) strslmtidno = "";
				if ( strslmtpayername == null ) strslmtpayername = "";

				if (strcliniccode.equals(""))
				{
					try
					{		
						pstmt = con.prepareStatement("select clinic_code from bl_visit_fin_dtls where (operating_facility_id,episode_type,episode_id,visit_id,patient_id) in (select operating_facility_id,episode_type,episode_id,visit_id,patient_id from bl_bill_hdr where operating_facility_id = ? and doc_type_code= ? and doc_num = ?)");
						
						pstmt.setString(1,strfacilityid);
						pstmt.setString(2,strbilldoctypecode);
						pstmt.setString(3,strbilldocnum);
						rs = pstmt.executeQuery();	
						if ( rs.next() && rs != null ) 
						{strcliniccode =  rs.getString(1); }
					}
					catch(Exception e) 
					{   
						e.printStackTrace(); 
						//out.println(e.toString());	
					}
					finally 
					{
						if (rs != null)   rs.close();
						if (pstmt != null) pstmt.close();		 	
					}	
				}

				if ( strcliniccode == null || strcliniccode.equalsIgnoreCase("null")) 
					strcliniccode = "";	
	
				try
				{	
					/*	CallableStatement call = 
						con.prepareCall("{ call BLOPIN.PROC_GET_BILL_PRINT (?,?,?,?)}");			
						call.setString(1,strblnggrpid);
						call.registerOutParameter(2,java.sql.Types.VARCHAR);	
						call.registerOutParameter(3,java.sql.Types.VARCHAR);	
						call.registerOutParameter(4,java.sql.Types.VARCHAR);	
						call.execute();		
						strprintvisitbilltype = call.getString(2);		
						strprintzerobillcouponyn = call.getString(3);		
						strslmtyn	= call.getString(4);		
						call.close();						
						if (strslmtyn == null) strslmtyn = "N";
						if (strprintzerobillcouponyn == null ) strprintzerobillcouponyn = "N";
					*/
					if(!(called_frm.equals("CHECKOUT_VISIT") && alw_co_wit_bl_slmt_yn.equals("Y") && p_episode_type.equals("E")))
					{
						CallableStatement call = 
						con.prepareCall("{ call BLOPIN.GET_BLNG_GRP_CLINIC_BILL_PRINT(?,?,?,?,?,?,?,?,?,?,?)}");			
						call.setString(1,strfacilityid);
						call.setString(2,strblnggrpid);
						call.setString(3,strcliniccode);
						call.registerOutParameter(4,java.sql.Types.VARCHAR);	
						call.registerOutParameter(5,java.sql.Types.VARCHAR);	
						call.registerOutParameter(6,java.sql.Types.VARCHAR);	
						call.registerOutParameter(7,java.sql.Types.VARCHAR);	
						call.registerOutParameter(8,java.sql.Types.VARCHAR);	
						call.registerOutParameter(9,java.sql.Types.VARCHAR);	
						call.registerOutParameter(10,java.sql.Types.VARCHAR);	
						call.registerOutParameter(11,java.sql.Types.VARCHAR);	

						call.execute();		

						strbillgenyn = call.getString(4);		
						strzerobillgenyn = call.getString(5);		
						strprintvisitbilltype = call.getString(6);		
						strprintzerobillcouponyn = call.getString(7);		
						strslmtyn	= call.getString(8);		
						strerrorlevel	= call.getString(9);		
						strsysmessageid	= call.getString(10);		
						strerrortext	= call.getString(11);		

						call.close();	

						if (strbillgenyn == null) strbillgenyn = "N";
						if (strzerobillgenyn == null ) strzerobillgenyn = "N";
						if (strprintvisitbilltype == null ) strprintvisitbilltype = "N";
						if (strslmtyn == null) strslmtyn = "N";
						if (strprintzerobillcouponyn == null ) strprintzerobillcouponyn = "N";
						if (strerrorlevel == null ) strerrorlevel = "";
						if (strsysmessageid == null ) strsysmessageid = "";
						if (strerrortext == null ) strerrortext ="";
						
						//Added for MMS-SCF-501.1
						if("[object]".equals(strblnggrpid) && "BL0195".equals(strsysmessageid)){
							strsysmessageid = "";
						}
						//Added for MMS-SCF-501.1
//						System.err.println("strbillgenynmain :"+ strbillgenyn);
						
						if (strunknownpatientyn.equals("Y") && strepitype.equals("E"))
						{
							//Karthik added to stop settlement window from being closed during Report Reprint
							if("Y".equals(billMaintain)) strslmtyn = "Y";
							else strslmtyn = "N";
						}
					}
					else
					{
						strslmtyn	= "Y";		
					}
				}
				catch(Exception e) 
				{        
					e.printStackTrace();
					//out.println(e.toString());
				}
				if ( !(strsysmessageid.equals("")))
				{	
					/*try
						{			
						CallableStatement call = 
						con.prepareCall("{ ? = call  blcommon.get_error_text(?)}");	
						call.registerOutParameter(1,java.sql.Types.VARCHAR);
						call.setString(2,strsysmessageid);
						call.execute();				
						strerrortext = call.getString(1);			
						call.close();	
						if ( strerrortext == null ) strerrortext = "";
						}catch(Exception e)
						{
						
						e.printStackTrace();
						out.println(e.toString()); }*/
%>						<script>alert(getMessage('<%=strsysmessageid%>','BL'));							
						</script>
<%
				}

				if (!(strerrortext.equals("")))
				{
%>
					<script>
						var strerrormessage = '<%=strerrortext%>';
						alert(strerrormessage);
						
						parent.window.returnValue="N";
						window.close();	 
					</script>
<%
				}
						
//				System.err.println("strslmtyn check:"+strslmtyn);

				if ( strslmtyn.equals("N") ) 
				{
%>
					<script>		
					
						parent.window.returnValue="N";
						window.close();	 
					</script>
<%
				}
				else
				{	
					strwsno = strclientip;
					if (!(strwsno.equals("")))		   
					{
						CallableStatement call =null;
						try 
						{
							System.out.println("{ call BL_USER_CHECK_FOR_CASH_COUNTER (?,?,?,?,?,?,?)}");
							call = con.prepareCall("{ call BL_USER_CHECK_FOR_CASH_COUNTER (?,?,?,?,?,?,?)}");			
							call.setString(1,strfacilityid);
							call.setString(2,strepisodetype);//"O");//Karthikkkkkk
							call.setString(3,strloggeduser);
							call.setString(4,strwsno);
							call.registerOutParameter(5,java.sql.Types.VARCHAR); // Cash Counter
							call.registerOutParameter(6,java.sql.Types.VARCHAR); // shift
							call.registerOutParameter(7,java.sql.Types.VARCHAR); // Error code
							call.execute();				

							strcashcountercode	 = call.getString(5);
							strshiftid		 = call.getString(6);
							strsysmessageid	 = call.getString(7);		
							call.close();	
							if ( strsysmessageid == null ) strsysmessageid = "";
							if ( strcashcountercode == null ) strcashcountercode = "";
							if ( strshiftid == null ) strshiftid = "";
//							System.err.println("strcashcountercode the strcashcountercode check" +strcashcountercode);
						}
						catch(Exception e) 
						{   
							e.printStackTrace();
							//out.println(e.toString()); 
						}
						
						/* Added by Karthik for MMS-MD-SCF-0006 [IN:060039] 4/28/2016 Starts*/
						double billpayableamt = 0;	
						if(strbillpayableamt == null || strbillpayableamt.equals("")) strbillpayableamt="0";
						billpayableamt = Double.parseDouble(strbillpayableamt);
						
						if(strsysmessageid.equals("")){
						try 
						{
							System.out.println("{ call blcommon.get_receipt_refund_check (?,?,?,?,?,?,?,?,?,?)}");
							call = con.prepareCall("{ call blcommon.get_receipt_refund_check (?,?,?,?,?,?,?,?,?,?)}");			
							call.setString(1,strfacilityid);
							call.setString(2,strcashcountercode);
							call.registerOutParameter(3,java.sql.Types.VARCHAR);
							call.registerOutParameter(4,java.sql.Types.VARCHAR);
							call.registerOutParameter(5,java.sql.Types.VARCHAR);
							call.registerOutParameter(6,java.sql.Types.VARCHAR);
							call.registerOutParameter(7,java.sql.Types.VARCHAR);
							call.registerOutParameter(8,java.sql.Types.VARCHAR);
							call.registerOutParameter(9,java.sql.Types.VARCHAR);
							call.registerOutParameter(10,java.sql.Types.VARCHAR);
							call.execute();				

                            String g_rcpt_ip_allowed_yn= call.getString(3);
                            String g_rcpt_op_allowed_yn= call.getString(4);
                            String g_rcpt_ref_allowed_yn= call.getString(5);
                            String g_rfnd_ip_allowed_yn= call.getString(6);
                            String g_rfnd_op_allowed_yn= call.getString(7);
                            String g_rfnd_ref_allowed_yn= call.getString(8);
                            String p_error_id= call.getString(9);
                            String p_error_text= call.getString(10);	
                            
						
                            if(billpayableamt>0){
	                            if(g_rcpt_op_allowed_yn.equals("N") && (strepisodetype.equals("O") || strepisodetype.equals("E"))){
	                            	strsysmessageid="BL9652";
	                            }
	                            if(g_rcpt_ip_allowed_yn.equals("N") && (strepisodetype.equals("I") || strepisodetype.equals("D"))){
	                            	strsysmessageid="BL9653";
	                            }
	                            if(g_rcpt_ref_allowed_yn.equals("N") && strepisodetype.equals("R")){
	                            	strsysmessageid="BL9654";
	                            }
                            }else{
	                            if(g_rfnd_op_allowed_yn.equals("N") && (strepisodetype.equals("O") || strepisodetype.equals("E"))){
	                            	strsysmessageid="BL9655";
	                            }
	                            if(g_rfnd_ip_allowed_yn.equals("N") && (strepisodetype.equals("I") || strepisodetype.equals("D"))) {                 			
	                            	strsysmessageid="BL9656";
	                            }
	                            if(g_rfnd_ref_allowed_yn.equals("N") && strepisodetype.equals("R")){	             			
	                            	strsysmessageid="BL9657";
	                            }
                            }
	

						}
						catch(Exception e) 
						{   
							e.printStackTrace();
							//out.println(e.toString()); 
						}finally{
							call.close();
						}
						}
						
						if(strsysmessageid.equals("")){
							if(billpayableamt<0){
									try 
									{
										System.out.println("{ call blcommon.check_for_refund (?,?,?,?,?,?)}");
										call = con.prepareCall("{ call blcommon.check_for_refund (?,?,?,?,?,?)}");								
										call.setString(1,strloggeduser);
										call.setString(2,strfacilityid);
										call.setString(3,strcashcountercode);
										call.registerOutParameter(4,java.sql.Types.VARCHAR);
										call.registerOutParameter(5,java.sql.Types.VARCHAR);
										call.registerOutParameter(6,java.sql.Types.VARCHAR);
										call.execute();				
			
			                            String cash_counter_refund_allowed_yn = call.getString(4);
			                            String p_error_id= call.getString(5);
			                            String p_error_text= call.getString(6);                            
										
			                                if(cash_counter_refund_allowed_yn.equals("N")){
				                            	strsysmessageid="BL1261";
				                            }
			
									}
									catch(Exception e) 
									{   
										e.printStackTrace();
										//out.println(e.toString()); 
									}finally{
										call.close();
									}
							}
						}
						
						
						if(strsysmessageid.equals("")){
							if(billpayableamt>0){
									try 
									{
										System.out.println("{ call blcommon.check_for_receipt (?,?,?,?,?,?)}");
										call = con.prepareCall("{ call blcommon.check_for_receipt (?,?,?,?,?,?)}");								
										call.setString(1,strloggeduser);
										call.setString(2,strfacilityid);
										call.setString(3,strcashcountercode);
										call.registerOutParameter(4,java.sql.Types.VARCHAR);
										call.registerOutParameter(5,java.sql.Types.VARCHAR);
										call.registerOutParameter(6,java.sql.Types.VARCHAR);
										call.execute();				
			
			                            String cash_counter_receipt_allowed_yn = call.getString(4);
			                            String p_error_id= call.getString(5);
			                            String p_error_text= call.getString(6);                            
										
			                                if(cash_counter_receipt_allowed_yn.equals("N")){
				                            	strsysmessageid="BL1260";
				                            }
			
									}
									catch(Exception e) 
									{   
										e.printStackTrace();
										//out.println(e.toString()); 
									}finally{
										call.close();
									}
							}
						}	
						
						//Added by Gayathri V180702/GHL-SCF-1355
						
						if(strsysmessageid.equals("")){
							if(billpayableamt<0){
									try 
									{
										System.out.println("{ call blcommon.check_opening_balance (?,?,?,?,?,?)}");
										call = con.prepareCall("{ call blcommon.check_opening_balance (?,?,?,?,?,?,?)}");								
										
										call.setString(1,strfacilityid);
										call.setString(2,strcashcountercode);
										call.setString(3,strloggeduser);
										call.setString(4,strbilldoctypecode);
										call.setString(5,strbilldocnum);
										
										call.registerOutParameter(6,java.sql.Types.VARCHAR);
										call.registerOutParameter(7,java.sql.Types.VARCHAR);
										
										call.execute();				
			
			                         
			                            String p_error_id= call.getString(6);
			                            String p_error_text= call.getString(7);                            
										
			                                if(("BL1271").equals(p_error_id)){
				                            	strsysmessageid="BL1271";
				                            }
			
									}
									catch(Exception e) 
									{   
										e.printStackTrace();
										//out.println(e.toString()); 
									}finally{
										call.close();
									}
							}
						}
						
						/* Added by Karthik for MMS-MD-SCF-0006 [IN:060039] 4/28/2016 ends*/
					}
					if ( !(strsysmessageid.equals("")))
					{	
%>	
						<script>
							alert(getMessage('<%=strsysmessageid%>','BL'));
							
							 parent.window.returnValue="N";
							window.close(); 
						</script>
<%
					}
					else if (strerrortext.equals("") && !(strcashcountercode.equals("")))
					{    
						double billpayableamt = 0;	
						try
						{			
							if(strbillpayableamt == null || strbillpayableamt.equals("")) strbillpayableamt="0";
							billpayableamt = Double.parseDouble(strbillpayableamt);
							if ( billpayableamt == 0)
							{	
%>								<script>
									
									 parent.window.returnValue="N";
									window.close(); 
								</script>
<%
							}								
						}	
						catch(Exception e) 
						{   e.printStackTrace();
							System.out.println("smitha1="+e.toString());	
						}
						finally 
						{
							if (rs != null)   rs.close();
							if (pstmt != null) pstmt.close();		 	
						}				
					
						String rfnd_alwd_frm_ext_sys_only_yn="";

						try
						{		
							pstmt = con.prepareStatement( " select NVL(RFND_ALWD_FRM_EXT_SYS_ONLY_YN,'N'),nvl(dflt_cash_bill_slmt_amt,'N'),nvl(ext_account_interface_yn,'N') ext_acc_interface,UNAVAIL_PKG_BLNG_SERV_CODE from BL_PARAMETERS where operating_facility_id = '" + strfacilityid + "' ");
							
							rs = pstmt.executeQuery();	
							if ( rs.next() && rs != null ) 
							{ 	
								 rfnd_alwd_frm_ext_sys_only_yn  =  rs.getString(1);
								 strdfltcashbillslmtamt =  rs.getString(2);
				 				 ext_acc_interface_yn =rs.getString(3);
				  				 unavail_service_code  =  rs.getString(4);
							}
						}
						catch(Exception e) 
						{   
							e.printStackTrace();
							//out.println(e.toString());	
						}
						finally 
						{
							if (rs != null)   rs.close();
							if (pstmt != null) pstmt.close();		 	
						}	

						if ( rfnd_alwd_frm_ext_sys_only_yn == null || rfnd_alwd_frm_ext_sys_only_yn.equalsIgnoreCase("null")) 
						 rfnd_alwd_frm_ext_sys_only_yn = "N";
						if ( strdfltcashbillslmtamt == null) strdfltcashbillslmtamt = "";
						if ( ext_acc_interface_yn == null) ext_acc_interface_yn = "N";
						if(unavail_service_code == null) unavail_service_code="";


						if (rfnd_alwd_frm_ext_sys_only_yn.equals("Y") && billpayableamt < 0)
						{
%>
							<script>
								alert(getMessage("BL6420","BL"));
								parent.window.returnValue="N";
								window.close();	
								
								</script>
<%
						}
		CurrencyFormat cf = new CurrencyFormat();
		//Added V180123-Aravindh/MMS-JU-SCF-0102 if-else condition
		if(amtRoundOff) {
			strbillpayableamt = cf.formatCurrency(strbillpayableamt, noofdecimal);
		} else {
			strbillpayableamt = BLReportIdMapper.truncateUptoTwoDecimal(strbillpayableamt, noofdecimal);
		}
%>	
	</HEAD> 
		
			<IFRAME SRC= "../../eBL/jsp/BLBillSlmtDet.jsp?billdoctypecode=<%=strbilldoctypecode%>&billdocnum=<%=strbilldocnum%>&billpayableamt=<%=strbillpayableamt%>&facilityid=<%=strfacilityid%>&loggeduser=<%=strloggeduser%>&patientid=<%=strpatientid%>&episodetype=<%=strepisodetype%>&episodeid=<%=strepisodeid%>&visitid=<%=strvisitid%>&encounterid=<%=strencounterid%>&moduleid=<%=p_module_id%>&slmtidno=<%=strslmtidno%>&slmtpayername=<%=strslmtpayername%>&cashcounter=<%=strcashcountercode%>&strblnggrpid=<%=strblnggrpid%>&strroundingamt=<%=strroundingamt%>&called_frm=<%=called_frm%>&alw_co_wit_bl_slmt_yn=<%=alw_co_wit_bl_slmt_yn%>&cal_frm_multi_bil_slmt=<%=cal_frm_multi_bil_slmt%>&dfltcashbillslmtamt=<%=strdfltcashbillslmtamt%>&ext_acc_interface_yn=<%=ext_acc_interface_yn%>&unavail_service_code=<%=unavail_service_code%>&addl_charge_amt=<%=addlChargeAmtForBill %>&billAlreadyPrinted=<%=billAlreadyPrinted %>" NAME="BillSlmtEntryFrame" id="BillSlmtEntryFrame" frameborder=0 noresize scrolling='no' style='height:26vh;width:100vw'></IFRAME>
			<IFRAME SRC="../../eCommon/html/blank.html"	  name="BillSlmtServiceFrame" id="BillSlmtServiceFrame" frameborder=0 noresize scrolling='no' style='height:32vh;width:100vw'></IFRAME>			
			<IFRAME SRC="../../eBL/jsp/BLBillSlmtType.jsp?billdoctypecode=<%=strbilldoctypecode%>&billdocnum=<%=strbilldocnum%>&billpayableamt=<%=strbillpayableamt%>&facilityid=<%=strfacilityid%>&loggeduser=<%=strloggeduser%>&patientid=<%=strpatientid%>&episodetype=<%=strepisodetype%>&episodeid=<%=strepisodeid%>&visitid=<%=strvisitid%>&encounterid=<%=strencounterid%>&moduleid=<%=p_module_id%>&slmtidno=<%=strslmtidno%>&slmtpayername=<%=strslmtpayername%>&cashcounter=<%=strcashcountercode%>&strblnggrpid=<%=strblnggrpid%>&strroundingamt=<%=strroundingamt%>&called_frm=<%=called_frm%>&alw_co_wit_bl_slmt_yn=<%=alw_co_wit_bl_slmt_yn%>&cal_frm_multi_bil_slmt=<%=cal_frm_multi_bil_slmt%>&dfltcashbillslmtamt=<%=strdfltcashbillslmtamt%>&ext_acc_interface_yn=<%=ext_acc_interface_yn%>&unavail_service_code=<%=unavail_service_code%>" NAME="BillSlmtTypeFrame" id="BillSlmtTypeFrame" frameborder=0 noresize scrolling='auto' style='height:30vh;width:100vw'></IFRAME>		
			<IFRAME SRC="../../eCommon/html/blank.html"	  name="BillSlmtTypeBtnFrame" id="BillSlmtTypeBtnFrame" frameborder=0 noresize scrolling='no' style='height:7vh;width:100vw'></IFRAME>			
			<IFRAME SRC="../../eCommon/html/blank.html"	  name="BillSlmtSubmitFrame" id="BillSlmtSubmitFrame" frameborder=0 noresize scrolling='no' style='height:0vh;width:100vw'></IFRAME>			
			<IFRAME SRC="../../eCommon/html/blank.html"	  name="BillSlmtConfirmFrame" id="BillSlmtConfirmFrame" frameborder=0 noresize scrolling='no' style='height:5vh;width:100vw'></IFRAME>			
	
	
<%	
					}	
					else
					{
%>
						<script>
							var strerrormessage = '<%=strerrortext%>';
						    alert(strerrormessage);
							parent.window.returnValue="N";
							window.close();	
							
						</script>
<%
					}
				}
				//ConnectionManager.returnConnection(con, request);		
			}	 
		}
		catch(Exception e)
		{   e.printStackTrace();
			System.out.println("main exception in blmain-"+e);
		}
		finally
		{
			if(pstmt != null)		pstmt.close();
			ConnectionManager.returnConnection(con, request);
		}
%>
</HTML>


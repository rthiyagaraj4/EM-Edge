<!DOCTYPE html>
<!-- 
Sr No        Version              TFS              SCF/CRF           		Developer Name
-----------------------------------------------------------------------------------------------
1            V210211           13526         MOHE-CRF-0060 	              Shikha Seth
 -->

	<%@page import="eBL.BLReportIdMapper"%>
	<%@ page import="java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*, java.util.*" contentType="text/html;charset=UTF-8"%>
	<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

	<HTML>
	<HEAD>
	<TITLE> <fmt:message key="eBL.BILL_SLMT_DTL.label" bundle="${bl_labels}"/></TITLE>
	<%
			String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
			<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
			<script language="javascript" src="../../eCommon/js/common.js"></script>
	<!--	<script language="javascript" src="../../eCommon/js/messages.js"></script>-->
			<script language="javascript"src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	

			<script>
				function callAsyncOnlinePrint(){		
		
							var xmlStr="<root><report/></root>";
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest() ;
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","../../eBL/jsp/BLAdhocDiscOnlineReport.jsp",true);
							xmlHttp.send(xmlDoc);	
							}
		</script>

	<%	
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CallableStatement  call  = null;
		int  blprintVal =0;
		HashMap<String,String> asyncPrinterAttrib=new HashMap<String,String> (); 
		Boolean Slysite=false;
		String Slysite_spec ="";
		CallableStatement cstmt = null;//KDAH-CRF-0546		

		try
		{
			request.setCharacterEncoding("UTF-8");
			con	=	ConnectionManager.getConnection(request);

			try
			{
				Slysite = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BILL_PRINT_NOT_REQD");				
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			if(Slysite){
				Slysite_spec="Y";
			}
			else{
				Slysite_spec="N";
			}
			String str_ordering_facility_id = request.getParameter("ordering_facility_id"); //V210211
			String strbilldoctypecode         = request.getParameter("billdoctypecode");
			String strbilldocnum              = request.getParameter("billdocnum");	
			String strstorecode              = request.getParameter("storecode");
			String strmoduleid              = request.getParameter("module_id");	
			String strfunctionid              = request.getParameter("function_id");	
			String bill_print_reqd              ="";	
			if (strmoduleid == null || strmoduleid.equalsIgnoreCase("null")) 
			{	strmoduleid = ""; }
			if (strfunctionid == null || strfunctionid.equalsIgnoreCase("null")) 
			{	strfunctionid = ""; }

			String strslmtidno		= "";
			String strslmtpayername = "";	
	//		String strepitype   = "";
	//		String strpatid		    = "";

			String strdfltcashbillslmtamt = "", ext_acc_interface_yn="";
			String unavail_service_code="";	

			String str_bill_prt_format_vals ="";
			String bill_print_format_enabled_yn ="";
			String strMpiId = "";
			String strBlrblprt = "";	
			
			String billAlreadyPrinted = request.getParameter("billAlreadyPrinted");
			if(billAlreadyPrinted == null) billAlreadyPrinted="N";

			if (strbilldoctypecode == null || strbilldoctypecode.equals(" ") || strbilldoctypecode.equalsIgnoreCase("null")) 
			{	strbilldoctypecode = ""; }
			if (strbilldocnum == null || strbilldocnum.equals(" ") || strbilldocnum.equalsIgnoreCase("null")) 
			{strbilldocnum = "";}		
			if (strstorecode == null || strstorecode.equalsIgnoreCase("null")) 
			{strstorecode = "**";}		

			if (strbilldoctypecode.equals(""))
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
		
				String strfacilityid = ""; 
				String strloggeduser = "";			
				String strbillpayableamt = "";
				String strblnggrpid	= "";		
				String strwsno = "";
				String strcashcountercode = "";
				String strshiftid	= "";
				String strsysmessageid = "";
				String strerrortext = "";
				String strpatientid ="";
				String strepisodetype = "";
				String strepisodeid = "";
				String strvisitid ="";
				String strprintvisitbilltype ="";
				String strprintzerobillcouponyn = "";
				String strbillgenyn				= "";
				String strzerobillgenyn			= "",strroundingamt="";
				String strslmtyn = "Y";
				String strerrorlevel = "";		
				int noofdecimal = 2;

			
				

				strfacilityid	=  (String) session.getValue("facility_id");
				strloggeduser	=  (String) session.getValue("login_user");			
				
				strblnggrpid		=  request.getParameter("blnggrp");	


				HttpSession httpSession = request.getSession(false);
				Properties p = (Properties)httpSession.getValue("jdbc");
				String locale	= (String)session.getAttribute("LOCALE");

				String strclientip = p.getProperty("client_ip_address");		

				if (strblnggrpid == null || strblnggrpid.equalsIgnoreCase("null")) 
				{strblnggrpid = "";}		

			/*
			try
			{		
				pstmt = con.prepareStatement( " select distinct store_code from bl_patient_charges_interface where operating_facility_id = '" + strfacilityid + "' and trx_doc_ref in ( select trx_doc_ref from bl_patient_charges_folio where operating_facility_id = '" + strfacilityid + "' and bill_doc_type_code= '" + strbilldoctypecode + "' and bill_doc_num = '" + strbilldocnum + ")'");
					
				rs = pstmt.executeQuery();	
				if ( rs.next() && rs != null ) 
				{ 	
					 strstorecode  =  rs.getString(1); 				 
				}
			}
			catch(Exception e) 
				{out.println(e.toString());	}

			finally 
			{
				if (rs != null)   rs.close();
				if (pstmt != null) pstmt.close();		 	
			}	

			if ( strstorecode == null || strstorecode.equalsIgnoreCase("null")) 
				 strstorecode = "**";
			 */

		
			try
				{	
					
						 call = 
						con.prepareCall("{ call BLOPIN.GET_BLNG_GRP_STORE_BILL_PRINT(?,?,?,?,?,?,?,?,?,?,?)}");			
						call.setString(1,strfacilityid);
						call.setString(2,strblnggrpid);
						call.setString(3,strstorecode);
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
						
				}	
				catch(Exception e) 
				{
					e.printStackTrace();
					//out.println(e.toString());
				}
			 
				double billpayableamt = 0;	
				double strtotInsamt =0 ;
				//Added for EMER 5320
				String billNatureCode = "";
				try
				{	
					//pstmt = con.prepareStatement( " select nvl(bill_tot_outst_amt,0), nvl(bill_tot_outst_amt,0), patient_id,episode_type,episode_id,visit_id , nvl(BILL_ROUNDING_AMT,0),mpi_id,bill_nature_code from bl_bill_hdr where operating_facility_id = '" + strfacilityid + "' and doc_type_code= '" + strbilldoctypecode + "' and doc_num = '" + strbilldocnum + "'"); //V210211 commented
					pstmt = con.prepareStatement( " select nvl(bill_tot_outst_amt,0), nvl(bill_tot_outst_amt,0), patient_id,episode_type,episode_id,visit_id , nvl(BILL_ROUNDING_AMT,0),mpi_id,bill_nature_code from bl_bill_hdr where operating_facility_id = ? and doc_type_code= ? and doc_num = ? "); //V210211  
					
					pstmt.setString(1,str_ordering_facility_id);
					pstmt.setString(2,strbilldoctypecode);
					pstmt.setString(3,strbilldocnum);
					rs = pstmt.executeQuery();	
					if ( rs.next() && rs != null ) 
					{
						strbillpayableamt =  rs.getString(1);			
						strpatientid =  rs.getString(3);			
						strepisodetype =  rs.getString(4);			
						strepisodeid =  rs.getString(5);			
						strvisitid =  rs.getString(6);			
						strroundingamt = rs.getString(7);
						strMpiId = rs.getString(8);	
						//Added for EMER 5320
						billNatureCode = rs.getString("bill_nature_code");	
								
						if(billNatureCode == null || "null".equals(billNatureCode)){
							billNatureCode = "";
						}
	//					System.err.println("strbillpayableamt in store main:"+strbillpayableamt);
	//					System.err.println("strroundingamt:"+strroundingamt);
						
					}
				}catch(Exception e){
				}finally{
					if(rs !=null) rs.close();
					if(pstmt != null) pstmt.close();
				}

				//Added for EMER 5320
				if(!"C".equals(billNatureCode))
				{
				%>
					<script>	
						parent.window.returnValue="N";
						window.close();	
					</script>
				<%
				}
				//Added for EMER 5320
					
					if(strbillpayableamt == null || strbillpayableamt.equals("")) strbillpayableamt="0";
			
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
						}
						catch(Exception e)
							{out.println(e.toString()); }*/
	%>						<script>
									alert(getMessage('<%=strsysmessageid%>','BL'));
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
							try {
									 call = 
									con.prepareCall(
									"{ call BL_USER_CHECK_FOR_CASH_COUNTER (?,?,?,?,?,?,?)}");			
									call.setString(1,strfacilityid);
									call.setString(2,"O");
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

	//								System.out.println("strcashcountercode main @@:"+strcashcountercode);
							}
							catch(Exception e) 
							{
								e.printStackTrace();
								//out.println(e.toString()); 
								}
							
							/* Added by Karthik for MMS-MD-SCF-0006 [IN:060039] 4/28/2016 Starts*/
							billpayableamt = 0;	
							if(strbillpayableamt == null || strbillpayableamt.equals("")) strbillpayableamt="0";
							billpayableamt = Double.parseDouble(strbillpayableamt);
							
							if(strsysmessageid.equals("")){
							try 
							{
								System.out.println("{ call Pharmacy blcommon.get_receipt_refund_check (?,?,?,?,?,?,?,?,?,?)}");
								call = con.prepareCall("{  call blcommon.get_receipt_refund_check (?,?,?,?,?,?,?,?,?,?)}");			
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
							{   e.printStackTrace();
								//out.println(e.toString()); 
							}finally{
								call.close();
							}
							}
							
							if(strsysmessageid.equals("")){
								if(billpayableamt<0){
										try 
										{ 
											System.out.println("{ call Pharmacy blcommon.check_for_refund (?,?,?,?,?,?)}");
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
										{   e.printStackTrace();
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
											System.out.println("{ call Pharmacy blcommon.check_for_receipt (?,?,?,?,?,?)}");
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
										{   e.printStackTrace();
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
									{   e.printStackTrace();
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
							   //commented by ram 25/07/2007
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
								}
								catch(Exception e)
									{out.println(e.toString()); }*/
	%>							<script>
										alert(getMessage('<%=strsysmessageid%>','BL'));
										parent.window.returnValue="N";
										window.close();
								</script>
	<%
						}
						else{
							if (strerrortext.equals("") && !(strcashcountercode.equals("")))
							{    
								/*try
								{		
									pstmt = con.prepareStatement( " select nvl(bill_tot_outst_amt,0), nvl(bill_tot_outst_amt,0), patient_id,episode_type,episode_id,visit_id  from bl_bill_hdr where operating_facility_id = '" + strfacilityid + "' and doc_type_code= '" + strbilldoctypecode + "' and doc_num = '" + strbilldocnum + "'");
					
									rs = pstmt.executeQuery();	
									if ( rs.next() && rs != null ) 
									{
										strbillpayableamt =  rs.getString(1);			
										strpatientid =  rs.getString(3);			
										strepisodetype =  rs.getString(4);			
										strepisodeid =  rs.getString(5);			
										strvisitid =  rs.getString(6);			
									}								
								}
								catch(Exception e) 
										{System.out.println("smitha1="+e.toString());	
										}

								finally 
								{
									if (rs != null)   rs.close();
									if (pstmt != null) pstmt.close();		 	
								}	*/

								try{
									
									//pstmt = con.prepareStatement( " select nvl(bill_tot_outst_amt,0)   from bl_bill_hdr where operating_facility_id = '" + strfacilityid + "' and mpi_id= '" + strMpiId + "' and mpi_ind = 'I'"); //V210211 COMMENTED
									pstmt = con.prepareStatement( " select nvl(bill_tot_outst_amt,0)   from bl_bill_hdr where operating_facility_id = ? and mpi_id= ? and mpi_ind = 'I'"); //V210211 
									
									pstmt.setString(1,str_ordering_facility_id);
									pstmt.setString(2,strMpiId);
									rs = pstmt.executeQuery();	
									if ( rs.next() && rs != null ) 
									{
										strtotInsamt = Double.parseDouble(rs.getString(1));
									}
									
								
									
									
	//								If((p_slmt_yn = 'Y') and (NVL (l_tot_bill_amt, 0) <> 0  or NVL(l_tot_bill_insu_amt,0) <>0)
		//							or((p_print_zero_bill_yn,'N')  = 'Y'   And (NVL (l_tot_bill_amt, 0) = 0  or NVL(l_tot_bill_insu_amt,0) =0)

							//		||(strprintzerobillcouponyn.equals("Y") && (strtotInsamt == 0 || billpayableamt == 0 ))	
																									
			


							
								/*if ((strslmtyn.equals("Y") && (strtotInsamt != 0 || billpayableamt != 0 ))
							||(strprintzerobillcouponyn.equals("Y") && (strtotInsamt == 0 || billpayableamt == 0 )))*/
							
							billpayableamt = Double.parseDouble(strbillpayableamt);
							if ( !(strslmtyn.equals("Y") && (billpayableamt != 0)) && strprintzerobillcouponyn.equals("Y")) 
									{
					
								if(!strbilldoctypecode.equals("") && !strbilldocnum.equals("")&& strzerobillgenyn.equals("Y"))
											{
							
										ResultSet  rstMt =  null;
										PreparedStatement pstmtRpt = null;
										strBlrblprt  ="BLRBLPRT";
							
											try
												{
											
												String qryStmt="select NVL(report_id,'BLRBLPRT'),BILL_PRINT_FORMAT_ENABLED_YN  from  bl_bill_reports a , bl_parameters b where  b.OPERATING_FACILITY_ID = '"+strfacilityid+"'   AND a.operating_facility_id (+) = b.operating_facility_id  AND bill_type (+) = 'PH-BILL'";
												
												
													pstmtRpt = con.prepareStatement(qryStmt);							
													rstMt = pstmtRpt.executeQuery();
													 while (rstMt!=null && rstMt.next())
													{	
													strBlrblprt  =  rstMt.getString(1);
													bill_print_format_enabled_yn=  rstMt.getString(2);
													}					

											//		System.err.println("eBL  BLAdhocDiscSubmit   strBlrblprt "+strBlrblprt);
												}catch(Exception ee)
										{
													ee.printStackTrace();
											strBlrblprt  ="BLRBLPRT";			
										}
											finally
										{
													try
											{
												  if(rstMt != null)  rstMt.close();	
												  if (pstmtRpt !=null) pstmtRpt.close();
											}catch(Exception ee1) {}							 

										}
										
							//Added By Vijay For MMS-CRF-0208
										
								try{
									strBlrblprt=BLReportIdMapper.getReportId(con, locale,strBlrblprt, strfacilityid); //Added strfacilityid by subha for MMS-DM-CRF-131.1
									System.out.println(" BLStoreBillSlmtMain for Report ID "+strBlrblprt);
									
								}catch(Exception e)
								{
									e.printStackTrace();
									System.err.println("Exception in BLStoreBillSlmtMain for reportID "+e);
								}									
										
										
						//Added below code for GST-GHL-CRF-0477
						String gstApplicableYN = "N";
						String printOrientation = "P";
						try{
							pstmtRpt = con.prepareStatement("Select bladdlchg.is_gst_applicable_yn('BL', 'BL_BILL_PRINT_ORIENTATION') gst_applicable from dual");
							rstMt = pstmtRpt.executeQuery();
							if(rstMt != null && rstMt.next()){
								gstApplicableYN = rstMt.getString("gst_applicable");
							}
							
						if("Y".equals(gstApplicableYN)){
							//ADDED FOR KDAH-CRF-0546
							try{ 				
									cstmt = con.prepareCall("{ call BLCOMMON.get_report_id_for_3t(?,?,?,?) }");
									cstmt.setString(1,strfacilityid);
									cstmt.setString(2,strepisodetype);				
									cstmt.registerOutParameter(3,java.sql.Types.VARCHAR);
									cstmt.registerOutParameter(4,java.sql.Types.VARCHAR);
										cstmt.execute();
										printOrientation = cstmt.getString(3);
										strBlrblprt = cstmt.getString(4);
										System.out.println("661-->printOrientation==>"+printOrientation);
										System.out.println("662-->strBlrblprt==>"+strBlrblprt);		
								}
								catch(Exception e){
									printOrientation = "P";
									System.err.println("Exception in getting BLStoreBillSlmtMain.jsp, 1"+e);
									e.printStackTrace();
								}
								finally{
									try
									{
										if (cstmt !=null) cstmt.close();
									}
									catch(Exception ee1) 
									{
										System.err.println("Exception in getting BLStoreBillSlmtMain.jsp, 2"+ee1);
										ee1.printStackTrace();
									}
								}
							//ADDED FOR KDAH-CRF-0546
							/*String printOrientationSql = "Select NVL (default_bill_print_orientation, 'P') default_bill_print_orientation "+
														"FROM bl_parameters "+
														"WHERE operating_facility_id = ?";
							
							pstmtRpt = con.prepareStatement(printOrientationSql);
							pstmtRpt.setString(1, strfacilityid);
							rstMt = pstmtRpt.executeQuery();
							
							if(rstMt != null && rstMt.next()){
								printOrientation = rstMt.getString("default_bill_print_orientation");
							}*/
													
							}
						}
						catch(Exception e){
							printOrientation = "P";
							System.err.println("Exception in getting printOrientation, 1"+e);
							e.printStackTrace();
						}
						finally{
							try
							{
								if(rstMt != null)  rstMt.close();	
								if (pstmtRpt !=null) pstmtRpt.close();
							}
							catch(Exception ee1) 
							{
								System.err.println("Exception in getting printOrientation, 2"+ee1);
								ee1.printStackTrace();
							}
						}
						if(("L".equals(printOrientation)) 
								&& ("BLRBLPRT".equals(strBlrblprt) || "BLRBLPRT_PH".equals(strBlrblprt))){
							strBlrblprt = "BLRBLPRL";
						}
						//Added below code for GST-GHL-CRF-0477

						}

					try{
							call = con.prepareCall("{ call blopin.CALL_BILL_PRINT_FRM_SLMT_NEW(?,?,?,?,?,?)}");			
							call.setString(1,strfacilityid);
							call.setString(2,strbilldoctypecode);
							call.setString(3,strbilldocnum);
							call.setString(4,locale);
							call.registerOutParameter(5,java.sql.Types.VARCHAR);	
							call.registerOutParameter(6,java.sql.Types.VARCHAR);	
							call.execute();	
							str_bill_prt_format_vals = call.getString(5);								
							strerrortext     	 = call.getString(6);				
									
							}
							catch (Exception e)
							{
								e.printStackTrace();
								System.err.println("Error while wexecuting CALL_BILL_PRINT_FRM_SLMT_NEW:"+e);
							}
							
							if(str_bill_prt_format_vals==null || str_bill_prt_format_vals.equals("")) str_bill_prt_format_vals="";
							
							if ( strerrortext == null ) strerrortext ="";
							
						
						if(bill_print_format_enabled_yn.equals("Y") && !str_bill_prt_format_vals.equals("") && strerrortext.equals(""))
						{
							
							/* Code commented by Karthik to move the Online Print module to asyncronous mode by Providing ajax Call*/
							int docNum = 0;
							if("Y".equals(Slysite_spec)){
							
								try{
								pstmt = con.prepareStatement("Select blopin.op_visit_bill_print_reqd(?,?,?)  from dual ");
								docNum = Integer.parseInt(strbilldocnum);
								pstmt.setString(1,strfacilityid);							
								pstmt.setString (2,strbilldoctypecode);
								pstmt.setInt(3,docNum);
								  rs = pstmt.executeQuery();
								 if(rs != null && rs.next()){
									 bill_print_reqd = rs.getString(1);
								   }
								 if("Y".equals(bill_print_reqd) && !"Y".equals(billAlreadyPrinted)) {
									System.err.println("asyncPrinterAttrib 1st Place->");
									asyncPrinterAttrib = new HashMap<String,String>();
									asyncPrinterAttrib.put(str_bill_prt_format_vals+"/"+(blprintVal++), strBlrblprt);
									System.err.println("asyncPrinterAttrib 1st Place->"+asyncPrinterAttrib);
									session.setAttribute("ASYNC_PRINTER_ATTRIB", asyncPrinterAttrib);
									out.println("<script>callAsyncOnlinePrint();</script>");
								}
								}
								 catch (SQLException e) {
										e.printStackTrace();
									}
							}
							else{
							asyncPrinterAttrib = new HashMap<String,String>();
							asyncPrinterAttrib.put(str_bill_prt_format_vals+"/"+(blprintVal++), strBlrblprt);
							session.setAttribute("ASYNC_PRINTER_ATTRIB", asyncPrinterAttrib);
							out.println("<script>callAsyncOnlinePrint();</script>");
							}						
						}	
						}								
						if ( billpayableamt == 0)
						{	
	%>						
						<script>
							parent.window.returnValue="N";
							window.close();
						</script>
	<%
						return;
							}
						}
						catch(Exception e) {
							e.printStackTrace();
							System.out.println("2="+e.toString());}

						finally 
						{
							 if (rs != null)   rs.close();
							 if (pstmt != null) pstmt.close();		 	
						}	
								
							
			/**************added by ram 17311 28-dec-2009********************/	
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
//						System.err.println("rfnd_alwd_frm_ext_sys_only_yn:"+rfnd_alwd_frm_ext_sys_only_yn);
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
			 
		/**************ram End ********************/	

				try
				{		
//								pstmt = con.prepareStatement( " select national_id_num, SUBSTR(SHORT_NAME,1,40) from  mp_patient_mast where patient_id ='" + strpatientid + "'");							
					//pstmt = con.prepareStatement( " SELECT NATIONAL_ID_NO, SUBSTR(PATIENT_NAME,1,40) FROM MP_PATIENT WHERE PATIENT_ID ='" + strpatientid + "'");							
					pstmt = con.prepareStatement( " SELECT NATIONAL_ID_NO, PATIENT_NAME FROM MP_PATIENT WHERE PATIENT_ID ='" + strpatientid + "'");
					rs = pstmt.executeQuery();	
					if ( rs.next() && rs != null ) 
					{
						strslmtidno  =   rs.getString(1);			
						strslmtpayername =  rs.getString(2);			
					}
					else
					{
						strslmtidno  =  "";
						strslmtpayername = "";
					}
						if ( strslmtidno == null ) strslmtidno = "";
						if ( strslmtpayername == null ) strslmtpayername = "";
					
				}
				catch(Exception e) {
					e.printStackTrace();
					System.out.println("3="+e.toString());}

				finally 
				{
					if (rs != null)   rs.close();
					if (pstmt != null) pstmt.close();		 		
				}	

				try
				{		
					pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
					
					rs = pstmt.executeQuery();	
					if ( rs.next() && rs != null ) 
						noofdecimal  =  rs.getInt(1);			
				}
				catch(Exception e) {
					e.printStackTrace();
					System.out.println("4="+e.toString());}

				finally 
				{
					if (rs != null)   rs.close();
					if (pstmt != null) pstmt.close();		 		
				}	


				CurrencyFormat cf = new CurrencyFormat();
				strbillpayableamt =(String) cf.formatCurrency(strbillpayableamt, noofdecimal);	
%>	

		
		</HEAD>
	 
		<FRAMESET framespacing="0" frameborder="0" ROWS="6%,9%,10%,3%,0%"  align = "center">
			<FRAME SRC= "../../eBL/jsp/BLBillSlmtDet.jsp?billdoctypecode=<%=strbilldoctypecode%>&billdocnum=<%=strbilldocnum%>&billpayableamt=<%=strbillpayableamt%>&facilityid=<%=strfacilityid%>&loggeduser=<%=strloggeduser%>&patientid=<%=strpatientid%>&episodetype=<%=strepisodetype%>&episodeid=<%=strepisodeid%>&visitid=<%=strvisitid%>&slmtidno=<%=strslmtidno%>&slmtpayername=<%=strslmtpayername%>&cashcounter=<%=strcashcountercode%>&strmoduleid=<%=strmoduleid%>&strfunctionid=<%=strfunctionid%>&strroundingamt=<%=strroundingamt%>&dfltcashbillslmtamt=<%=strdfltcashbillslmtamt%>&ext_acc_interface_yn=<%=ext_acc_interface_yn%>&unavail_service_code=<%=unavail_service_code%>&billAlreadyPrinted=<%=billAlreadyPrinted %>&encounterFacilityId="<%=str_ordering_facility_id %>" NAME="BillSlmtEntryFrame" frameborder=0 noresize scrolling='no'> <!-- V210211-->
			
			<FRAME SRC="../../eCommon/html/blank.html"	  name="BillSlmtServiceFrame" id="BillSlmtServiceFrame" frameborder=0 noresize scrolling='no'>	
			
			<FRAME SRC="../../eBL/jsp/BLBillSlmtType.jsp?billdoctypecode=<%=strbilldoctypecode%>&billdocnum=<%=strbilldocnum%>&billpayableamt=<%=strbillpayableamt%>&facilityid=<%=strfacilityid%>&loggeduser=<%=strloggeduser%>&patientid=<%=strpatientid%>&episodetype=<%=strepisodetype%>&episodeid=<%=strepisodeid%>&visitid=<%=strvisitid%>&slmtidno=<%=strslmtidno%>&slmtpayername=<%=strslmtpayername%>&cashcounter=<%=strcashcountercode%>&strblnggrpid=<%=strblnggrpid%>&strmoduleid=<%=strmoduleid%>&strfunctionid=<%=strfunctionid%>&strroundingamt=<%=strroundingamt%>&dfltcashbillslmtamt=<%=strdfltcashbillslmtamt%>&ext_acc_interface_yn=<%=ext_acc_interface_yn%>&unavail_service_code=<%=unavail_service_code%>&encounterFacilityId=<%=str_ordering_facility_id %>"	  NAME="BillSlmtTypeFrame" frameborder=0 noresize scrolling='no'> <!-- V210211-->
			
			<FRAME SRC="../../eCommon/html/blank.html"	  name="BillSlmtTypeBtnFrame" id="BillSlmtTypeBtnFrame" frameborder=0 noresize scrolling='no'>		
				<FRAME SRC="../../eCommon/html/blank.html"	  name="BillSlmtSubmitFrame" id="BillSlmtSubmitFrame" frameborder=0 noresize scrolling='no'>		
			<FRAME SRC="../../eCommon/html/blank.html"	  name="BillSlmtConfirmFrame" id="BillSlmtConfirmFrame" frameborder=0 noresize scrolling='no'>		
			<!--<FRAME SRC='../../eCommon/jsp/error.jsp' name="BillSlmtValidationFrame" id="BillSlmtValidationFrame" frameborder=0 noresize scrolling='no'>
			
			<FRAME SRC='../../eBL/jsp/BLBillSlmtConfirm.jsp?billdoctypecode=<%=strbilldoctypecode%>&billdocnum=<%=strbilldocnum%>&billpayableamt=<%=strbillpayableamt%>&facilityid=<%=strfacilityid%>&loggeduser=<%=strloggeduser%>&patientid=<%=strpatientid%>&episodetype=<%=strepisodetype%>&episodeid=<%=strepisodeid%>&visitid=<%=strvisitid%>&slmtidno=<%=strslmtidno%>&slmtpayername=<%=strslmtpayername%>&cashcounter=<%=strcashcountercode%>' NAME="BillSlmtToolBarFrame" frameborder=0 noresize scrolling='no'>-->

		</FRAMESET>	

				
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

				}
				ConnectionManager.returnConnection(con, request);		
			}	 
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("main exception in blmain-"+e);
		}
		finally
		{
			ConnectionManager.returnConnection(con, request);
		}
		%>
	</HTML>


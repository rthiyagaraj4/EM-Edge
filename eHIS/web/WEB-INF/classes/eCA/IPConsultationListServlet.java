/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-----------------------------------------------------------------------------------------------
Date			Edit History		Name                 	Rev.Date 		Rev.by 					Description
-----------------------------------------------------------------------------------------------
?             100         ?           created
21/08/2011    IN034688	Dinesh T		Handling the billing related issue, while trying to charge consultation for more patients, charges were not posting to the billing tables
14/10/2019    IN071315	    Nijitha S  14/10/2019  Ramesh G		GHL-CRF-0607

  21/03/2023     42761   krishna Pranay      21/03/2023     Ramesh Goli        COMMON-ICN-0125

-----------------------------------------------------------------------------------------------

*/ 
package eCA;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import webbeans.eCommon.MessageManager;
import webbeans.eCommon.*;
import eOR.FutureOrder;
import eOR.OrderEntryBillingQueryBean;


public class IPConsultationListServlet extends javax.servlet.http.HttpServlet	
{

	public void init(ServletConfig config) throws ServletException	{
		super.init(config);
	}

	public  void doPost(HttpServletRequest request, HttpServletResponse response)throws javax.servlet.ServletException,IOException
	{ 

		//HttpSession session = request.getSession(false);
		PrintWriter out = null;
		Connection con = null;
		//PreparedStatement pstmt = null;
		//ResultSet rs = null;
		//Hashtable tabdata = new Hashtable();
		//Properties p;
		request.setCharacterEncoding("UTF-8");			
		response.setContentType("text/html; charset=UTF-8");
		con = ConnectionManager.getConnection(request);
		try
		{
			con.setAutoCommit( false ) ;
		}
		catch (Exception e)
		{
			
			e.printStackTrace() ;
		}
		

		String servMode = request.getParameter("servMode")==null?"":request.getParameter("servMode");



		if(servMode.equals("insert"))
		{
			insertIPConsList(request,response,con);
		}
		else if(servMode.equals("update"))
		{
			updateIPConsList(request,response,con);	
		}
		else if(servMode.equals("cancel"))
		{
			cancelIPConsList(request,response,con);	
		}

	}

	public void insertIPConsList(HttpServletRequest request,HttpServletResponse response,Connection con)
	{

		HttpSession session = request.getSession(false);
		PrintWriter out = null;
		
		PreparedStatement pstmt = null;
		//PreparedStatement pstmt1 = null;//checkstyle
		//ResultSet rs = null;//Checkstyle
		Properties p;
		String errorMsg = "";
		String error_value ="";
		String loginuserid = "";
		String client_ip_address = "";
		String facilityid = "";

		//String cons_ref_id = "";//Checkstyle
		String cons_list_desc = "";
		String practitioner_id = "";
		String cons_date = "";
		String cons_time = "";
		String create_type = "";
		//String cons_status = "";//checkstyle
		String bean_key = "";
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

		try
		{
			out= response.getWriter();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}


		bean_key = request.getParameter("bean_key")==null?"":request.getParameter("bean_key");

		String strVal ="";
		StringTokenizer Tokens = null ;
		String specialty_code ="";
		String patient_id ="";
		String encounter_id ="";
		String speciality_code="";
		int [] nInsStat1			= null;

		Boolean insFlag = false;

		ArrayList selectedList = new ArrayList();
		ArrayList practList = new ArrayList();

		String pract_id ="";
		Boolean flag= false;

		int nInsStat=0;

		eCA.IPConsultationListBean ipConsultListBean = null;

		ipConsultListBean = (eCA.IPConsultationListBean)com.ehis.persist.PersistenceHelper.getObjectFromBean("ipConsultListBean"+bean_key,"eCA.IPConsultationListBean",session);

		//manageEmailBean = (eCA.PatientBannerGroupLine)com.ehis.persist.PersistenceHelper.getObjectFromBean("manageEmailBean"+patient_id+encounter_id,"eCA.PatientBannerGroupLine",session);

		selectedList =	ipConsultListBean.returnConsList();
		int listSize = selectedList.size();
		Collections.sort(selectedList);

			
		
		p = (java.util.Properties) session.getValue( "jdbc" ) ;

		loginuserid		=(String) session.getValue("login_user");
		facilityid		=(String) session.getValue("facility_id");
		client_ip_address	= p.getProperty("client_ip_address");
		String locale = (String) p.getProperty("LOCALE");

		practitioner_id = request.getParameter("practitionerId")==null?"":request.getParameter("practitionerId");
		cons_date = request.getParameter("cons_date")==null?"":request.getParameter("cons_date");
		cons_time = request.getParameter("cons_time")==null?"":request.getParameter("cons_time");
		create_type = request.getParameter("create_type")==null?"":request.getParameter("create_type");
		cons_list_desc = request.getParameter("cons_list_desc")==null?"":request.getParameter("cons_list_desc");
			
		/*
		The below Query was changed by
		Name   : DINESH T
		Date   : 2010-05-10
		INCNO  : 21240
		Changes: The below one line was commented because while inserting into the table it is converting the sysdate again and inserting into the table

		*/
		//cons_date = com.ehis.util.DateUtils.convertDate(cons_date,"DMY",locale,"en");

		//start_date		= com.ehis.util.DateUtils.convertDate(start_date,"DMY",locale,"en");
		
		if(create_type.equals("S"))
		{

			for(int k=0; k<listSize; k++)
				{
										
					strVal = (String)selectedList.get(k);
					
					Tokens = new StringTokenizer(strVal,"~");

					while(Tokens.hasMoreTokens())
					{
						pract_id =(String)Tokens.nextToken();
						
						if(!(practList.contains(pract_id)))
						{
							practList.add(pract_id);
						}
						Tokens.nextToken();
						Tokens.nextToken();
						Tokens.nextToken();
						Tokens.nextToken();
						Tokens.nextToken();
						Tokens.nextToken();
						speciality_code = (String)Tokens.nextToken();
					}
				}
				pract_id="";

		}
		else
		{
			if(!(practList.contains(practitioner_id)))
			{
				practList.add(practitioner_id);
			}

		}

		try
		{
		
		for(int m=0; m<practList.size(); m++)
		{


		String insConsHdrQry ="insert into CA_CONS_LIST_HDR (CONS_REF_ID,CONS_LIST_DESC,PRACTITIONER_ID,CONS_DATE,CONS_TIME,FACILITY_ID,CREATE_TYPE,CREATED_USER_ID,CREATED_DATE,CONS_STATUS,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,SPECIALTY_CODE)values (CA_CONS_LIST_HDR_SEQ.NEXTVAL,?,?,to_date(?,'DD/MM/YYYY'),?,?,?,?,sysdate,?,?,sysdate,?,?,?,sysdate,?,?,?)";


		
		
		pstmt=con.prepareStatement(insConsHdrQry);

		pstmt.clearParameters();
		//pstmt.setString(1,cons_ref_id);
		pstmt.setString(1,cons_list_desc+(m+1));
		//pstmt.setString(2,practitioner_id);
		pstmt.setString(2,(String)practList.get(m));
		pstmt.setString(3,cons_date);
		pstmt.setString(4,cons_time);
		pstmt.setString(5,facilityid);
		pstmt.setString(6,create_type);
		pstmt.setString(7,loginuserid);
		pstmt.setString(8,"P");
		pstmt.setString(9,loginuserid);
		pstmt.setString(10,client_ip_address);
		pstmt.setString(11,facilityid);
		pstmt.setString(12,loginuserid);
		pstmt.setString(13,client_ip_address);
		pstmt.setString(14,facilityid);
		pstmt.setString(15,speciality_code);

		nInsStat = pstmt.executeUpdate();
		if(pstmt != null) pstmt.close();


		if(nInsStat>0)
			{
				String insConsDtlQry ="insert into CA_CONS_LIST_DTL (CONS_REF_ID,FACILITY_ID,ENCOUNTER_ID,PATIENT_ID,SPECIALITY_CODE,CONS_STATUS,ORDER_ID,LINE_NO,COMPLETED_DATE,COMPLETED_USER_ID,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) values(CA_CONS_LIST_HDR_SEQ.CURRVAL,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)";

				pstmt=con.prepareStatement(insConsDtlQry); 

				for(int k=0; k<listSize; k++)
				{
										
					strVal = (String)selectedList.get(k);
					Tokens = new StringTokenizer(strVal,"~");

						while(Tokens.hasMoreTokens())
						{

							if(create_type.equals("S"))
							{
								pract_id= (String)Tokens.nextToken();
																
								if(practList.get(m).equals(pract_id))//If condition is modified by Archana Dhal on 5/3/2010 related to IN021175.
								{

									Tokens.nextToken();
									Tokens.nextToken();
									Tokens.nextToken();
							
									specialty_code = (String) Tokens.nextToken();
									patient_id = (String) Tokens.nextToken();
									
									encounter_id = (String) Tokens.nextToken();
									if(Tokens.hasMoreTokens())//If condition is added by Archana Dhal on 5/3/2010 related to IN021175.
									{
									  Tokens.nextToken();
									}
									//Tokens.nextToken();

									flag=true;
								}
								else
								{
									flag=false;
									//Added by Archana Dhal on 5/3/2010 related to IN021175.
									Tokens.nextToken();
									Tokens.nextToken();
									Tokens.nextToken();
									Tokens.nextToken();
									Tokens.nextToken();
									Tokens.nextToken();
									Tokens.nextToken();
								}
							}
							else
							{
									Tokens.nextToken();
									Tokens.nextToken();
									Tokens.nextToken();
									Tokens.nextToken();
									//rsLocation_code = (String) Tokens.nextToken();
									//pline = (String) Tokens.nextToken();
									//rsAdmission_date_time = (String) Tokens.nextToken();
									specialty_code = (String) Tokens.nextToken();
									patient_id = (String) Tokens.nextToken();
									encounter_id = (String) Tokens.nextToken();
									//Tokens.nextToken();
									if(Tokens.hasMoreTokens())//Added by Archana Dhal on 5/3/2010 related to IN021175.
									{
									  Tokens.nextToken();
									}
									flag =true;
							}
							

						if(flag)
						{
							pstmt.clearParameters();
							//pstmt.setString(1,cons_ref_id);
							pstmt.setString(1,facilityid);
							pstmt.setString(2,encounter_id);
							pstmt.setString(3,patient_id);
							pstmt.setString(4,specialty_code);
							pstmt.setString(5,"P");
							pstmt.setString(6,"");
							pstmt.setString(7,"");
							pstmt.setString(8,"");
							pstmt.setString(9,"");
							pstmt.setString(10,loginuserid);
							pstmt.setString(11,client_ip_address);
							pstmt.setString(12,facilityid);
							pstmt.setString(13,loginuserid);
							pstmt.setString(14,client_ip_address);
							pstmt.setString(15,facilityid);
													
							pstmt.addBatch();
						}

						} // while loop

				
				}// k loop

				nInsStat1 = pstmt.executeBatch();
			

				for(int n=0; n< nInsStat1.length;++n )
				{
					if(nInsStat1[n]<0  && nInsStat1[n] != -2)
					{
						insFlag = false;
						break;
						
					}
					else
					{ 
						insFlag = true;
						

					}
				}
			} //if(nInsStat>0)

			if(!insFlag)
			{
				break;
			}

			if(pstmt != null) pstmt.close();

		}  // m loop
		

				if(insFlag)
				{ 		
					con.commit();
					errorMsg= getMessage(locale,"RECORD_INSERTED","CA");
					error_value = "1" ;

				}
				else
				{
					con.rollback();
					errorMsg= getMessage(locale,"FAILED_TRANSACTION","CA");
					error_value = "0" ;

				}
				
			

			if(pstmt != null) pstmt.close();

			out.println("<html><link rel='stylesheet' type='text/css' href='../eCommon/html/"+sStyle+"'></link>");
			out.println("<BODY CLASS='MESSAGE'>");
			out.println(errorMsg);
			if(insFlag)
			out.println("<script>top.content.workAreaFrame.IPConsultationListResultFrame.onSuccess1();</script>");
			out.println("</BODY></html>");


			//response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( errorMsg,"UTF-8" ) +"&err_value="+error_value);

		}
		catch(Exception e )
		{
			//out.println("Exception in insertIPConsList method of  IPConsultationListServlet ...So Record Not inserted  : "+e.toString());//common-icn-0181
			
			e.printStackTrace();
			
			try
			{
				con.rollback();
				
			}
			catch(Exception eee)
			{
				
				eee.printStackTrace();
			}


		}
		finally
		{
			ipConsultListBean.clearBean();		
			if(con != null) ConnectionManager.returnConnection(con);
				
		}



	}
	public void updateIPConsList(HttpServletRequest request,HttpServletResponse response,Connection con) 
	{
		FutureOrder FutureBeanObj = (FutureOrder) com.ehis.persist.PersistenceHelper.getBeanObject("Or_FutureOrder","eOR.FutureOrder",request);
		OrderEntryBillingQueryBean orderEntryBillBean=(eOR.OrderEntryBillingQueryBean) FutureBeanObj.getOrderEntryBillBean();

		HttpSession session = request.getSession(false);
		PrintWriter out = null;
		
		PreparedStatement pstmt = null;
		PreparedStatement stmt = null;
		CallableStatement cstmt = null;
		CallableStatement cstmt_bl_ext_charge_stage = null;
		CallableStatement cstmt_billing_ext = null;
		ResultSet resultSet 				= null;

		HashMap bill_dtls				= null;

		Properties p;

		String loginuserid = "";
		String facilityid = "";
		String client_ip_address = "";
		String bean_key = "";
		ArrayList selectedList = new ArrayList();

		String cons_ref_id ="";
		String patient_id ="";
		String encounter_id ="";

		String errorMsg = "";
		String error_value ="";
		String consult_date_time="";
		String order_catalog_code="";
		String p_patient_class="";
		String p_episode_id="";
		String episode_visit_num="";
		String practitioner_id="";
		String source_code="";
		String source_type="";
		String p_out_order_id="";
		String p_out_order_line_num="";
		String p_err_message="";
		String p_facility_id="";
		String catalog_desc="";

		String p_total_amt="";
		String incl_excl_action="";
		String incl_excl_action_orginal="";
        String	incl_excl_action_reason="";
		String bl_panel_str="";
	//	String p_error_message="";//42761
		String error_message="";
		String Future_order_yn="";
		String charge_type_code="";
		String err_code="";
		String sys_message_id="";
		String err_message="";

		int errcount=0;
		int errorcount=0;
						
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

		p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");

		loginuserid		=(String) session.getValue("login_user");
		facilityid		=(String) session.getValue("facility_id");
		client_ip_address	= p.getProperty("client_ip_address");
		
		int [] nInsStat1			= null;

		String strVal ="";
		StringTokenizer Tokens = null ;
		Boolean insFlag = false;

		try
		{
			out= response.getWriter();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
		bean_key = request.getParameter("bean_key")==null?"":request.getParameter("bean_key");

		eCA.IPConsultationListBean ipConsultListBean = null;

		ipConsultListBean = (eCA.IPConsultationListBean)com.ehis.persist.PersistenceHelper.getObjectFromBean("ipConsultListBeanUpd"+bean_key,"eCA.IPConsultationListBean",session);

		selectedList =	ipConsultListBean.returnConsList();
		int listSize = selectedList.size();


		String upd_qry="update CA_CONS_LIST_DTL set CONS_STATUS ='C',COMPLETED_DATE =sysdate, COMPLETED_USER_ID=?,order_id=?,line_no=? where CONS_REF_ID =? and FACILITY_ID = ? and ENCOUNTER_ID =?";
		
		try
		{
		
		pstmt=con.prepareStatement(upd_qry);

		for(int k=0; k<listSize; k++)
		{
		
			errcount = 0;//IN034688
			strVal = (String)selectedList.get(k);

			Tokens = new StringTokenizer(strVal,"~");

			while(Tokens.hasMoreTokens())
			{
				cons_ref_id = (String) Tokens.nextToken();
				patient_id = (String) Tokens.nextToken();
				encounter_id = (String) Tokens.nextToken();
				consult_date_time = (String) Tokens.nextToken();
				order_catalog_code = (String) Tokens.nextToken();
				p_patient_class = (String) Tokens.nextToken();
				p_episode_id = (String) Tokens.nextToken();
				episode_visit_num = (String) Tokens.nextToken();
				practitioner_id = (String) Tokens.nextToken();
				source_code = (String) Tokens.nextToken();
				source_type = (String) Tokens.nextToken();
			}


			

				cstmt=con.prepareCall("{call OR_INSERT_ORDER_OTH_MODULE ( ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,NULL)}");

				cstmt.setString( 1, consult_date_time);
				cstmt.setString( 2, order_catalog_code);
				cstmt.setString( 3, "OR");
				cstmt.setString( 4, facilityid);
				cstmt.setString( 5, patient_id);
				cstmt.setString( 6, p_patient_class);
				cstmt.setString( 7, encounter_id);
				cstmt.setString( 8, p_episode_id);
				cstmt.setString( 9, (episode_visit_num==null)?"":episode_visit_num);
				cstmt.setString( 10, source_type);
				cstmt.setString( 11, source_code);
				cstmt.setString( 12, practitioner_id);
				cstmt.setString( 13, loginuserid);
				cstmt.setString( 14, client_ip_address);

				cstmt.registerOutParameter(15,java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(16,java.sql.Types.NUMERIC);
				cstmt.registerOutParameter(17,java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(18,java.sql.Types.VARCHAR);
				cstmt.execute() ;
				

				p_out_order_id=cstmt.getString( 15 ); 
				if(p_out_order_id ==null) p_out_order_id="";
				p_out_order_line_num=cstmt.getString( 16 ); 
				if(p_out_order_line_num ==null) p_out_order_line_num="";
						
				p_err_message=cstmt.getString( 18 ); 
				p_facility_id=cstmt.getString( 17 ); 
				if(p_err_message==null) p_err_message="";
				if(cstmt != null) cstmt.close();
				if(!p_out_order_id.equals(""))
				{
					pstmt.clearParameters();		
					
					pstmt.setString(1,loginuserid);
					pstmt.setString(2,p_out_order_id);
					pstmt.setString(3,p_out_order_line_num);
					pstmt.setString(4,cons_ref_id);
					pstmt.setString(5,facilityid);
					pstmt.setString(6,encounter_id);

					pstmt.addBatch();
					nInsStat1 = pstmt.executeBatch();

					for(int n=0; n< nInsStat1.length;++n )
					{
						if(nInsStat1[n]<0  && nInsStat1[n] != -2)
						{
							insFlag = false;
							break;
						}
						else
						{ 
							insFlag = true;
						}
		//}

		if(insFlag)
		{ 		
					stmt=con.prepareStatement("select short_desc description from or_order_catalog where order_catalog_code=?");
					stmt.clearParameters();		
					
					stmt.setString(1,order_catalog_code);
					resultSet=stmt.executeQuery();
					while(resultSet!=null && resultSet.next())
					{
						catalog_desc=resultSet.getString("description");
					}
					
					if(resultSet!=null) resultSet.close();
					if(stmt !=null) stmt.close();
					
					try
					{
						
						cstmt_bl_ext_charge_stage=con.prepareCall("{CALL OR_BL_ORDER_CATALOG_LINE( ? ,? ,?, ?, ?, ? ,? ,?, ?, ?, ? ,? ,?, ?, ?, ? ,? , ?, ?, ?, ?, ?, ?, ?, ?,?,?,?)}");
						
						cstmt_bl_ext_charge_stage.setString(1,((String)facilityid));	
						cstmt_bl_ext_charge_stage.setString(2,((String)patient_id));							cstmt_bl_ext_charge_stage.setString(3,((String)encounter_id));
						cstmt_bl_ext_charge_stage.setString( 4,((String)p_patient_class)) ; 	
						cstmt_bl_ext_charge_stage.setString( 5,(String)p_out_order_id) ;
						cstmt_bl_ext_charge_stage.setString( 6,(String)p_out_order_line_num) ;	
						cstmt_bl_ext_charge_stage.setString( 7,(String)order_catalog_code) ;	
						cstmt_bl_ext_charge_stage.setString( 8,(String)catalog_desc ) ;	
						cstmt_bl_ext_charge_stage.setString(9, consult_date_time ) ;
						cstmt_bl_ext_charge_stage.setString(10,"1") ;
						bill_dtls=(HashMap)orderEntryBillBean.getOrderBillDtls(((String)patient_id)+((String)encounter_id)+order_catalog_code);

						if(bill_dtls != null)
						{
							p_total_amt		 = (String)bill_dtls.get("total_payable");
							incl_excl_action		 = (String)bill_dtls.get("incl_excl_action");
							incl_excl_action_orginal	 = (String)bill_dtls.get("incl_excl_action_orginal");
							Future_order_yn	 = (String)bill_dtls.get("Future_order_yn");
							if(incl_excl_action.equals(incl_excl_action_orginal))
							{
								incl_excl_action="";
							}
							else
							{
								incl_excl_action		 = (String)bill_dtls.get("incl_excl_action");
							}
							incl_excl_action_reason	 = (String)bill_dtls.get("incl_excl_action_reason");
							bl_panel_str			 = (String)bill_dtls.get("bl_panel_str");
					}
					cstmt_bl_ext_charge_stage.setString(11,(String)p_total_amt);																		
					cstmt_bl_ext_charge_stage.setString(12,(String)practitioner_id);							// PRACTITIONER_ID
					cstmt_bl_ext_charge_stage.setString(13,(String)incl_excl_action);	
					// P_OVERRIDDEN_EXCL_INCL_IND 
					cstmt_bl_ext_charge_stage.setString(14,((String)incl_excl_action_reason==null?"":(String)incl_excl_action_reason));
					cstmt_bl_ext_charge_stage.setString(15,bl_panel_str.trim());															// P_STR 
					cstmt_bl_ext_charge_stage.setString(16,"N");															// P_FUTURE_ORDER_YN
				   cstmt_bl_ext_charge_stage.setString(17,"N");								// P_FUTURE_ORDER_CHARGE_LATER_YN
				 cstmt_bl_ext_charge_stage.setString(18,"N");													// AUTH_CONSENT_APPROV_YN
			
				cstmt_bl_ext_charge_stage.setString(19,"N");
		
				cstmt_bl_ext_charge_stage.setString(20,"Y");
				
				cstmt_bl_ext_charge_stage.setString(21, "N");																		// CANCEL_ON_ORDER_YN
				cstmt_bl_ext_charge_stage.setString(22, "N");																		// RESULT_ON_ORDER_YN
				cstmt_bl_ext_charge_stage.setString(23, "N");																	// AMEND_ON_ORDER_YN
			
				cstmt_bl_ext_charge_stage.setString(24, "N");																		// REGISTER_ON_ORDER_YN
				cstmt_bl_ext_charge_stage.setString(25, ((String)loginuserid));										// USER
				cstmt_bl_ext_charge_stage.setString(26, ((String)client_ip_address));									// WS_NO
				cstmt_bl_ext_charge_stage.registerOutParameter( 27,  Types.VARCHAR ) ;
				cstmt_bl_ext_charge_stage.registerOutParameter( 28,  Types.VARCHAR ) ;
				cstmt_bl_ext_charge_stage.execute();
				error_message 		= (cstmt_bl_ext_charge_stage.getString(27)==null?"":cstmt_bl_ext_charge_stage.getString(27));										// P_ERROR_MESSAGE
				charge_type_code 	= (cstmt_bl_ext_charge_stage.getString(28)==null?"":cstmt_bl_ext_charge_stage.getString(28));	
				if(cstmt_bl_ext_charge_stage !=null) cstmt_bl_ext_charge_stage.close();
				// P_charge_type_code
				if(! error_message.equals(""))
				{
					errcount++;
				}
				if(errcount==0)
				{
						cstmt_billing_ext			= con.prepareCall("{ CALL BL_PROC_FOR_EXT_SERVICE_MP.PROCESS_INTERFACED_REC( ? ,? ,?, ?, ?, ? ,? ,?, ?, ?, ? ,? ,?)}");
						cstmt_billing_ext.clearParameters();
						cstmt_billing_ext.setString(1,((String)facilityid)); 	// FACILITY_ID
						cstmt_billing_ext.setString(2,((String)patient_id));			// PATIENT_ID
						if((((String)p_patient_class).equalsIgnoreCase("IP")) || (((String)p_patient_class).equalsIgnoreCase("EA")))
							cstmt_billing_ext.setString(3, "I");										// EPISODE_TYPE
						else if(((String)p_patient_class).equalsIgnoreCase("DC")) 
							cstmt_billing_ext.setString(3, "D");										// EPISODE_TYPE
						else if(((String)p_patient_class).equalsIgnoreCase("EM")) 
							cstmt_billing_ext.setString(3, "E");										// EPISODE_TYPE
						else if(((String)p_patient_class).equalsIgnoreCase("OP")) 
							cstmt_billing_ext.setString(3, "O");										// EPISODE_TYPE
						else 
							cstmt_billing_ext.setString(3, "R");										// EPISODE_TYPE
						cstmt_billing_ext.setString(4,((String)p_episode_id)==null?"0":(String)p_episode_id);	// EPISODE_ID
						cstmt_billing_ext.setString(5,((String)episode_visit_num)==null?"0":(String)episode_visit_num); // VISIT_NUM
						cstmt_billing_ext.setString(6,p_out_order_id);  
						cstmt_billing_ext.setString(7,"OR"); 		// SUBS_MODULE_ID
						cstmt_billing_ext.setString(8,null); 	// SUBS_REGN_NUM
						cstmt_billing_ext.setString(9,((String)loginuserid)); 		// USER
						cstmt_billing_ext.setString(10,((String)client_ip_address)); 	// WS_NO
						cstmt_billing_ext.registerOutParameter( 11,Types.VARCHAR ) ;
						cstmt_billing_ext.registerOutParameter( 12,Types.VARCHAR ) ;
						cstmt_billing_ext.registerOutParameter( 13,Types.VARCHAR ) ;

						cstmt_billing_ext.execute();
						err_code 		= (cstmt_billing_ext.getString(11)==null?"":cstmt_billing_ext.getString(11));  // ERR_CODE
						sys_message_id 		=(cstmt_billing_ext.getString(12)==null?"":cstmt_billing_ext.getString(12));  // SYS_MESSAGE_ID
						err_message		=(cstmt_billing_ext.getString(13)==null?"":cstmt_billing_ext.getString(13));  // ERROR_TEXT
						if(cstmt_billing_ext!=null)cstmt_billing_ext.close();
						if(!err_code.equals("") || !err_message.equals(""))
						{
							errorcount++;
						} // End of if !err_message
						else if(!sys_message_id.equals("") )  //Query from the sm_message and display the message
						{
							errorcount++;
						}
			}
			if ( errorcount >0 ) 
			{
				con.rollback();
				errorMsg = getMessage(locale,"FAILED_TRANSACTION","CA");
				if(!err_message.equals(""))
					errorMsg = errorMsg+"<BR>"+err_message;
				error_value = "0" ;
			}
			else
			{
				con.commit();
				errorMsg= getMessage(locale,"RECORD_INSERTED","CA");
				error_value = "1" ;
			}

		}
		catch(Exception be)
		{
			
			be.printStackTrace() ;
		}
	}
	else
	{
		con.rollback();
		errorMsg= getMessage(locale,"FAILED_TRANSACTION","CA");
		error_value = "0" ;
	}
}

		//updtval=pstmt.executeUpdate();
		/*nInsStat1 = pstmt.executeBatch();

			for(int n=0; n< nInsStat1.length;++n )
			{
				if(nInsStat1[n]<0  && nInsStat1[n] != -2)
				{
					insFlag = false;
					break;
					
				}
				else
				{ 
					insFlag = true;
					

				}
			}
*/

		/*if(insFlag)
		{ 		
			
			con.commit();
			errorMsg= getMessage(locale,"RECORD_INSERTED","CA");
			error_value = "1" ;

		}
		else
		{
			con.rollback();
			errorMsg= getMessage(locale,"FAILED_TRANSACTION","CA");
			error_value = "0" ;

		}*/
		}
		else
		{
			con.rollback();
			errorMsg= getMessage(locale,"FAILED_TRANSACTION","CA");
			error_value = "0" ;
		}
		}
		if(listSize==0)
		{
			con.rollback();
			errorMsg= getMessage(locale,"FAILED_TRANSACTION","CA");
			error_value = "0" ;
		}

			out.println("<html><link rel='stylesheet' type='text/css' href='../eCommon/html/"+sStyle+"'></link>");
			out.println("<BODY CLASS='MESSAGE'>");
			out.println(errorMsg);
			if(insFlag)
			out.println("<script>top.content.workAreaFrame.IPConsultationListResultFrame.onSuccess();</script>");
			out.println("</BODY></html>");



		//response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( errorMsg,"UTF-8" ) +"&err_value="+error_value);
		
		if(pstmt!=null)
			pstmt.close();
		}
		catch(Exception e )
		{
			//out.println("Exception in insertIPConsList method of  IPConsultationListServlet ...So Record Not inserted  : "+e.toString());//common-icn-0181
			
			e.printStackTrace();
			
			try
			{
				con.rollback();
				
			}
			catch(Exception eee)
			{
				
				eee.printStackTrace();
			}


		}
		finally
		{
					
			ipConsultListBean.clearBean();
			if(con != null) ConnectionManager.returnConnection(con);
				
		}



	}

public void cancelIPConsList(HttpServletRequest request,HttpServletResponse response,Connection con)
{
		HttpSession session = request.getSession(false);
		PrintWriter out = null;
		CallableStatement cstmt_billing_ext = null;
		PreparedStatement pstmt=null;
		PreparedStatement ord_pstmt=null;
		PreparedStatement ord_line_pstmt=null;
		Properties p;

		String loginuserid = "";
		String facilityid = "";
		String client_ip_address = "";
		String bean_key = "";
		ArrayList selectedList = new ArrayList();

		String cons_ref_id ="";
		String patient_id ="";
		String encounter_id ="";

		String errorMsg = "";
		String error_value ="";
		String consult_date_time="";
		String order_catalog_code="";
		String p_patient_class="";
		String p_episode_id="";
		String episode_visit_num="";
		String practitioner_id="";
		String source_code="";
		String source_type="";
		String p_error_message="";
		/*//commented for Checkstyle
		String p_out_order_id="";
		String p_out_order_line_num="";
	
		String p_facility_id="";
		String catalog_desc="";
		String p_err_message="";
		String p_total_amt="";
		String incl_excl_action="";
		String incl_excl_action_orginal="";
        String	incl_excl_action_reason="";
		String bl_panel_str="";
		
		String error_message="";
		String Future_order_yn="";
		String charge_type_code="";
		String err_code="";
		String sys_message_id="";
		String err_message="";
		*///commented for Checkstyle
		String order_id="";
		String order_line_num="";

		//int errcount=0;//Checkstyle
		int errorcount=0;
		int upd=0;
		int ord_upd=0;
		int ord_line_upd=0;
						
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

		p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");

		loginuserid		=(String) session.getValue("login_user");
		facilityid		=(String) session.getValue("facility_id");
		client_ip_address	= p.getProperty("client_ip_address");
		
		//int [] nInsStat1			= null;//checkstyle

		String strVal ="";
		StringTokenizer Tokens = null ;
		//Boolean insFlag = false;//checkstyle

		try
		{
			out= response.getWriter();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
		bean_key = request.getParameter("bean_key")==null?"":request.getParameter("bean_key");

		eCA.IPConsultationListBean ipConsultListBean = null;

		ipConsultListBean = (eCA.IPConsultationListBean)com.ehis.persist.PersistenceHelper.getObjectFromBean("ipConsultListBeanUpd"+bean_key,"eCA.IPConsultationListBean",session);

		selectedList =	ipConsultListBean.returnConsList();
		int listSize = selectedList.size();
		
		try
		{
		
			for(int k=0; k<listSize; k++)
			{
		
				errorcount=0;//IN034688
				strVal = (String)selectedList.get(k);

				Tokens = new StringTokenizer(strVal,"~");

				while(Tokens.hasMoreTokens())
				{
					cons_ref_id = (String) Tokens.nextToken();
					patient_id = (String) Tokens.nextToken();
					encounter_id = (String) Tokens.nextToken();
					consult_date_time = (String) Tokens.nextToken();
					order_catalog_code = (String) Tokens.nextToken();
					p_patient_class = (String) Tokens.nextToken();
					p_episode_id = (String) Tokens.nextToken();
					episode_visit_num = (String) Tokens.nextToken();
					practitioner_id = (String) Tokens.nextToken();
					source_code = (String) Tokens.nextToken();
					source_type = (String) Tokens.nextToken();
					order_id = (String) Tokens.nextToken();
					order_line_num = (String) Tokens.nextToken();
				}
				
				cstmt_billing_ext = con.prepareCall("{CALL OR_BL_WITHOUT_ORDER_CATALOG( ? ,? ,?, ?, ?, ?, ?, ?,'N','N',?)}");//IN071315
					
				cstmt_billing_ext.setString(1,facilityid); 					// P_FACILITY_ID
				cstmt_billing_ext.setString(2,order_id);						// P_ORDER_ID
				cstmt_billing_ext.setString(3,order_line_num);				// P_ORDER_LINE_NUM
				cstmt_billing_ext.setString(4,"CAN"); 						// P_MODE
				cstmt_billing_ext.setString(5,loginuserid);							// P_USER
				cstmt_billing_ext.setString(6,client_ip_address);						// P_WS_NO
				cstmt_billing_ext.registerOutParameter( 7,  Types.VARCHAR ) ; 	// P_BILL_YN
				cstmt_billing_ext.registerOutParameter( 8,  Types.VARCHAR ) ; 	// P_ERROR_MESSAGE
				cstmt_billing_ext.setString(9,"OR");//IN071315
				cstmt_billing_ext.execute();
				p_error_message	= cstmt_billing_ext.getString(8);  // message
				if(cstmt_billing_ext!=null) cstmt_billing_ext.close();
				if(p_error_message!=null && !p_error_message.equals(""))
					errorcount++;
				if(errorcount==0)
				{
					//pstmt=con.prepareStatement("update CA_CONS_LIST_DTL set CANCELLED_BY_USER_ID=?,CANCELLED_DATE =sysdate,cons_status='P' where CONS_REF_ID=? and FACILITY_ID=? and ENCOUNTER_ID=?");
					pstmt=con.prepareStatement("update CA_CONS_LIST_DTL set COMPLETED_DATE=NULL,COMPLETED_USER_ID =NULL,cons_status='P' where CONS_REF_ID=? and FACILITY_ID=? and ENCOUNTER_ID=?");
					//pstmt.setString(1,loginuserid);
					pstmt.setString(1,cons_ref_id);
					pstmt.setString(2,facilityid);
					pstmt.setString(3,encounter_id);
					upd=pstmt.executeUpdate();
					
					if(pstmt!=null) pstmt.close();
					
					ord_pstmt=con.prepareStatement("update or_order set order_status=(select order_status_code from or_order_status_code where order_status_type='99') where order_id=?");
					ord_pstmt.setString(1,order_id);
					ord_upd=ord_pstmt.executeUpdate();

					if(ord_pstmt!=null) ord_pstmt.close();
					
					ord_line_pstmt=con.prepareStatement("update or_order_line set order_line_status=(select order_status_code from or_order_status_code where order_status_type='99') where order_id=? and order_line_num=?");
					ord_line_pstmt.setString(1,order_id);
					ord_line_pstmt.setString(2,order_line_num);
					ord_line_upd=ord_line_pstmt.executeUpdate();
					
					if(ord_line_pstmt!=null) ord_line_pstmt.close();
				}
				
						
			if((errorcount >0) || upd==0 || ord_upd==0)
			{
				con.rollback();
				errorMsg = getMessage(locale,"FAILED_TRANSACTION","CA");
				if(p_error_message!=null && !p_error_message.equals(""))//IN034688
					errorMsg = errorMsg + "<BR>" + p_error_message;
				error_value = "0" ;
			}
			else if((upd>0)&&(errorcount==0))
			{
				con.commit();
				errorMsg= getMessage(locale,"RECORD_INSERTED","CA");
				error_value = "1" ;
			}
			else
			{
				con.rollback();
				errorMsg= getMessage(locale,"FAILED_TRANSACTION","CA");
				error_value = "0" ;
			}
		
		}
		out.println("<html><link rel='stylesheet' type='text/css' href='../eCommon/html/"+sStyle+"'></link>");
		out.println("<BODY CLASS='MESSAGE'>");
		out.println(errorMsg);
		if((upd>0)&&(errorcount==0))
		out.println("<script>top.content.workAreaFrame.IPConsultationListResultFrame.onSuccess();</script>");
		out.println("</BODY></html>");
		if(cstmt_billing_ext!=null)
		cstmt_billing_ext.close();
		if(pstmt!=null)
		pstmt.close();
		if(ord_pstmt!=null)
		ord_pstmt.close();
		if(ord_line_pstmt!=null)
		ord_line_pstmt.close();
	}
	catch(Exception e )
	{
			//out.println("Exception in cancelIPConsList method of  IPConsultationListServlet ...So Record Not inserted  : "+e.toString());//common-icn-0181
			
			e.printStackTrace();
			
			try
			{
				con.rollback();
				
			}
			catch(Exception eee)
			{
				
				eee.printStackTrace();
			}


		}
		finally
		{
					
			ipConsultListBean.clearBean();
			if(con != null) ConnectionManager.returnConnection(con);
				
		}



	}




	private String getMessage(String locale, String messageId, String moduleId)
	{
		java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
		String mesg = (String) message.get("message");
		message.clear();
		return(mesg) ;
	 }


}

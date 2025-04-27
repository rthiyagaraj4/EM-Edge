/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
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


public class MultiTransRequestServlet extends javax.servlet.http.HttpServlet	
{
	/** MultiTransRequestServlet.java
*	init	-	will initialise the servlet
*	@param	config - this is ServletConfig
*/
	public void init(ServletConfig config) throws ServletException	
	{
		super.init(config);
	}
/**
*	doPost	-	will be called when the method is of post
*	@param	request - this is HttpServletRequest
*	@param	response - this is HttpServletResponse
*	throws javax.servlet.ServletException,IOException
*/

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

		insertTransRequest(request,response,con);


	}



	public void insertTransRequest(HttpServletRequest request,HttpServletResponse response,Connection con)
	{
		
		HttpSession session = request.getSession(false);
		PrintWriter out = null;
		
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		ResultSet rset = null;
		Properties p;
		String errorMsg = "";
		String error_value ="";
		String loginuserid = "";
		String client_ip_address = "";
		String facilityid = "";
		String bean_key = "";
		String modal_yn ="";
		String remarks ="";
		String practitionerId ="";
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		p = (java.util.Properties) session.getAttribute( "jdbc" ) ;
		loginuserid		=(String) session.getAttribute("login_user");
		facilityid		=(String) session.getAttribute("facility_id");
		client_ip_address	= p.getProperty("client_ip_address");
		String locale = (String) p.getProperty("LOCALE");
		

		bean_key = request.getParameter("bean_key")==null?"":request.getParameter("bean_key");
		modal_yn = request.getParameter("modal_yn")==null?"N":request.getParameter("modal_yn");
		remarks = request.getParameter("remarks")==null?"":request.getParameter("remarks");
		practitionerId = request.getParameter("practitionerId")==null?"":request.getParameter("practitionerId");
		
		//eCA.IPConsultationListBean ipConsultListBean = null;
		eCA.PatientBannerGroupLine multiTransBean = null;
		//ipConsultListBean = (eCA.IPConsultationListBean)com.ehis.persist.PersistenceHelper.getObjectFromBean("ipConsultListBean"+bean_key,"eCA.IPConsultationListBean",session);
		multiTransBean = (eCA.PatientBannerGroupLine)com.ehis.persist.PersistenceHelper.getObjectFromBean("multiTransBean"+bean_key,"eCA.PatientBannerGroupLine",session);
		//multiTransBean = (eCA.PatientBannerGroupLine)getObjectFromBean("multiTransBean"+bean_key,"eCA.PatientBannerGroupLine",session);
		
		try
		{
			out= response.getWriter();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		String strVal ="";
		StringTokenizer Tokens = null ;
		String patient_id ="";
		String encounter_id ="";
		String transcriber ="";
		String notes ="";
				
		int [] nInsStat			= null;
		int [] nInsStat1		= null;
		String	seqNum			= "0";

		Boolean insFlag = false;

		//ArrayList selectedList = new ArrayList();
		HashMap selectedMap = new HashMap();
		ArrayList selectedKeyList = new ArrayList();

		//selectedList =	ipConsultListBean.returnConsList();
		selectedMap = multiTransBean.returnHashMap();
		
		selectedKeyList = multiTransBean.getKeys();
		int listSize = selectedKeyList.size();
		
		
		//String insTransReqQuery="insert into CA_PAT_TASK_LIST (PATIENT_ID,TASK_CODE,TASK_SRL_NO,PERFORMED_BY_ID,PERFORMED_DATE,CONTR_SYS_ID,FACILITY_ID,ENCOUNTER_ID,PRIORITY,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,REMARKS ) values(?,?,CA_PAT_TASK_SEQ.NEXTVAL,?,sysdate,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?)";
		
		String transSequen = " SELECT CA_TRANS_REQUEST.NEXTVAL FROM DUAL" ;
		
		//String insCaPatTaskListQuery="insert into CA_PAT_TASK_LIST (PATIENT_ID,TASK_CODE,TASK_SRL_NO,TASK_TYPE,STATUS,STATUS_DATE,PERFORMED_BY_ID,PERFORMED_DATE,REMARKS,FACILITY_ID,ENCOUNTER_ID,PRIORITY,EVENT_TYPE, REQ_REFERENCE,REQ_ACCESSION_NUM,ADDED_BY_ID,ADDED_DATE, ADDED_AT_WS_NO,ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,schedule_datetime) values(?,?,CA_PAT_TASK_SEQ.NEXTVAL,?,?,SYSDATE,?,Sysdate,?,?,?,?,?,CA_TRANS_REQUEST.NEXTVAL,CA_TRANS_REQUEST.CURRVAL,?,Sysdate,?,?,?,Sysdate,?,?,sysdate)";
		String insCaPatTaskListQuery="insert into CA_PAT_TASK_LIST (PATIENT_ID,TASK_CODE,TASK_SRL_NO,TASK_TYPE,STATUS,STATUS_DATE,PERFORMED_BY_ID,PERFORMED_DATE,REMARKS,FACILITY_ID,ENCOUNTER_ID,PRIORITY,EVENT_TYPE, REQ_REFERENCE,REQ_ACCESSION_NUM,ADDED_BY_ID,ADDED_DATE, ADDED_AT_WS_NO,ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,schedule_datetime) values(?,?,CA_PAT_TASK_SEQ.NEXTVAL,?,?,SYSDATE,?,Sysdate,?,?,?,?,?,?,?,?,Sysdate,?,?,?,Sysdate,?,?,sysdate)"; //11 12
		//  CA_REQ_REFERENCE_SEQ CA_REQ_ACCESSION_NUM
		
		
		String insTransReqQuery = "INSERT INTO CA_TRANSRIPTION_REQ(REQ_PRACT_ID,REQ_DATE,TRANS_PRACT_ID,REQ_REFERENCE,REQ_ACCESSION_NUM,NOTE_TYPE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES (?,SYSDATE,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";// 3 4 
	
	try
	{
		
		pstmt2=con.prepareStatement(transSequen);

		pstmt1=con.prepareStatement(insCaPatTaskListQuery);
				
		pstmt=con.prepareStatement(insTransReqQuery);
		
		for(int k=0; k<listSize; k++)
		{
		
			rset = pstmt2.executeQuery();
			
			while(rset.next())
			{
				seqNum = rset.getString(1);
			}
			
			if(rset != null) rset.close();
			//if(pstmt2 != null) pstmt2.close();
			
			//strVal = (String)selectedList.get(k);

			strVal = (String)selectedMap.get((String)selectedKeyList.get(k));

					
			Tokens = new StringTokenizer(strVal,"~");

			while(Tokens.hasMoreTokens())
			{

				patient_id =(String)Tokens.nextToken();
				encounter_id =(String)Tokens.nextToken();
				transcriber =(String)Tokens.nextToken();
				notes =(String)Tokens.nextToken();
				
				
			//		1.pat id,2.task_code='' 3.task_type=''  4. status 5.practioner id 6.remarks 7.facilityid 
			//	8.encounter_id 9.priority 10.event type='NT' 11 req ref 12 loginuser 13.workstation 
			//	14. facilityid 15 loginuser 16 workstation 17.facility

				pstmt1.clearParameters();
								
				pstmt1.setString(1,patient_id);
				pstmt1.setString(2,"$NTS");
				pstmt1.setString(3,"$TCP");
				pstmt1.setString(4,"O"); //status
				pstmt1.setString(5,transcriber); //practitionerId
				pstmt1.setString(6,remarks); 
				pstmt1.setString(7,facilityid); 
				pstmt1.setString(8,encounter_id); 
				pstmt1.setString(9,""); //priority
				pstmt1.setString(10,"NT"); //priority
				pstmt1.setString(11,seqNum); //priority
				pstmt1.setString(12,seqNum); //priority
				pstmt1.setString(13,loginuserid);
				pstmt1.setString(14,client_ip_address);
				pstmt1.setString(15,facilityid);
				pstmt1.setString(16,loginuserid);
				pstmt1.setString(17,client_ip_address);
				pstmt1.setString(18,facilityid);

				pstmt1.addBatch();
				
				pstmt.clearParameters();
				
				pstmt.setString(1,practitionerId);
				pstmt.setString(2,transcriber);
				pstmt.setString(3,seqNum);
				pstmt.setString(4,seqNum);
				pstmt.setString(5,notes);
				pstmt.setString(6,loginuserid);
				pstmt.setString(7,client_ip_address);
				pstmt.setString(8,facilityid);
				pstmt.setString(9,loginuserid);
				pstmt.setString(10,client_ip_address);
				pstmt.setString(11,facilityid);
				

				// 1.pract_id 2.transcriber 3.REQ_REFERENCE 4.REQ_ACCESSION_NUM,5.notetype
				// 6.loginuser 7.wokstation 8.facilityid 9.loginuser,10.workstation 11.facilityid
				
			
				pstmt.addBatch();
				
			}

		}
		
		nInsStat = pstmt1.executeBatch();

		for(int q=0; q< nInsStat.length;++q )
			{
				if(nInsStat[q]<0  && nInsStat[q] != -2)
				{
					insFlag = false;
					break;
					
				}
				else
				{ 
					insFlag = true;
					

				}
			}
		
		if(insFlag)
		{
					
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
		}
		if(pstmt2 != null) pstmt2.close();
		if(pstmt1 != null) pstmt1.close();	
		if(pstmt != null) pstmt.close();

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

		out.println("<html><link rel='stylesheet' type='text/css' href='../eCommon/html/"+sStyle+"'></link>");
		out.println("<BODY CLASS='MESSAGE'>");
		//out.println(errorMsg);
		if(insFlag)
		{
			if(modal_yn.equals("Y"))
			{
				//out.println("<script>top.content.workAreaFrame.MultiTransRequestResultFrame.onSuccess();</script>");
				out.println("<script src='../eCommon/js/showModalDialog.js' language='JavaScript'></script>");
				out.println("<script>alert('"+errorMsg+"')</script>");
				out.println("<script>window.close();</script>");
			}
			else
			{
				out.println(errorMsg);
				out.println("<script>top.content.workAreaFrame.MultiTransRequestResultFrame.onSuccess();</script>");
			}
		}
		out.println("</BODY></html>");


	}
	catch(Exception e )
		{
			//out.println("Exception in insertTransRequest method of  MultiTransRequestServlet ...So Record Not inserted  : "+e.toString());//common-icn-0181
			
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
			//ipConsultListBean.clearBean();		
			multiTransBean.clearBean();		
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

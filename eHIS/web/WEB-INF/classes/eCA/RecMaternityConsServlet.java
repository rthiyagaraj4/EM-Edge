/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
--------------------------------------------------------------------------------------------------------------------
Date       Edit History      		Name        Description
--------------------------------------------------------------------------------------------------------------------
?             	100            		?           created
18/01/2013		IN037372		Ramesh G		Oracle 11g Weblogic compilation.
23/10/2020		IN074222		Ramesh G		SKR-SCF-1450
--------------------------------------------------------------------------------------------------------------------
*/ 
package eCA ;

import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*;
import eCA.RecMaternityCons.*;

import webbeans.eCommon.*;
import webbeans.eCommon.MessageManager;

public class RecMaternityConsServlet extends HttpServlet
{
	public void init(ServletConfig cfg) throws ServletException
	{
		super.init(cfg);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException
    {
		response.setContentType("text/html; charset=UTF-8");
		java.io.PrintWriter out = response.getWriter();
		String closeFlag = request.getParameter("closeFlag") == null ? "N" : request.getParameter("closeFlag");
		String delivery_record = request.getParameter("delivery_record") == null ? "N" : request.getParameter("delivery_record");
		
		try
        {
			if (closeFlag.equals("Y"))
			{
			  closeMaternityEvents(request,response,out);
			}
			else
			{				
				if (delivery_record.equals("DeliverRecord"))
				{
					recordMaternityDeliveryReport(request,response,out);
				}else{
					 recordMaternityCons(request,response,out);					
				}
				
			 
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();			
		}

	}//end of doPost()

	private void recordMaternityCons(HttpServletRequest request, HttpServletResponse response, java.io.PrintWriter out) throws ServletException, java.io.IOException
	{

		HttpSession session = request.getSession(false);
		java.util.Properties p = (Properties) session.getValue("jdbc");
		String locale = (String) p.getProperty("LOCALE");
		//String insertCAEncntrNote = "";//checkstyle
		String accessionNum = "";
		String facilityId = (String) session.getAttribute("facility_id") == null ? "" : (String) session.getAttribute("facility_id");
		String addedByUser = (String) session.getAttribute("login_user") == null ? "" : (String) session.getAttribute("login_user");
		String clinician_id = (String) session.getAttribute("ca_practitioner_id") == null ? "" : (String) session.getAttribute("ca_practitioner_id");
		String patientId = "";
		String encounterId = "";
		String securityLevel = "";
		String patientClass = "";
		String secHdgCode = "";
		String sectionType = "";
		String subSecHdgCode = "";
		String modeValue="";
		String loginAtWsNo = p.getProperty("client_ip_address") == null ? "" : p.getProperty("client_ip_address");
		Hashtable htParameter = new Hashtable();
		HashMap sectData = new HashMap();
		StringBuffer sectionContentUpdatedXML = new StringBuffer();

		webbeans.eCA.RecClinicalNotesSectionBean matSectionBean = null;
		matSectionBean = (webbeans.eCA.RecClinicalNotesSectionBean)com.ehis.persist.PersistenceHelper.getObjectFromBean( "matBean","webbeans.eCA.RecClinicalNotesSectionBean",session);

		try
		{

			Enumeration enumParameter = request.getParameterNames();
			String parameterName = "";
			String parameterValue = "";

			while(enumParameter.hasMoreElements())
			{
				parameterName = (String) enumParameter.nextElement();
				parameterValue = request.getParameter(parameterName) == null ? "" : request.getParameter(parameterName);
				htParameter.put(parameterName, parameterValue);
				sectData.put(parameterName, parameterValue);
				if(parameterName.equals("patientId")) patientId = parameterValue;
				else if(parameterName.equals("encounterId")) encounterId = parameterValue;
				else if(parameterName.equals("securityLevel")) securityLevel = parameterValue;
				else if(parameterName.equals("patientClass")) patientClass = parameterValue;
				else if(parameterName.equals("secHdgCode")) secHdgCode = parameterValue;
				else if(parameterName.equals("subSecHdgCode")) subSecHdgCode = parameterValue;
				else if(parameterName.equals("sectionType")) sectionType = parameterValue;
				else if(parameterName.equals("modeValue"))	 modeValue= parameterValue;
			}//end of enumParameter		
						
			sectData.put("facilityId",facilityId);
			sectData.put("addedByUser",addedByUser);
			sectData.put("loginAtWsNo",loginAtWsNo);
			sectData.put("clinician_id",clinician_id);

			sectData.put("sectionContentUpdatedXML",sectionContentUpdatedXML.toString());

			webbeans.eCA.XMLtoHTML converter=new webbeans.eCA.XMLtoHTML();
			//IN074222 Start.
			//String contextUrl = HttpUtils.getRequestURL(request).toString();
			//contextUrl = contextUrl.substring(0,contextUrl.indexOf("servlet/"));
			ServletContext context = request.getSession().getServletContext();
			String contextUrl = context.getRealPath("/");
			//IN074222 End.
			converter.setXSLFileContextReference(contextUrl);

			try
			{
				java.util.HashMap results = null;
				boolean inserted = false;
				String error_msg = "";
				boolean local_ejbs = false;

				if((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") != null) && (getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE")))
					local_ejbs = true;

				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/RecMaternityCons",RecMaternityConsHome.class,local_ejbs);

				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[] = new Object[5];
				argArray[0] = p;
				argArray[1] = sectData;
				argArray[2] = locale;
				argArray[3] = converter;
				argArray[4] = matSectionBean;

				Class [] paramArray = new Class[5];
				paramArray[0] = p.getClass();
				paramArray[1] = sectData.getClass();
				paramArray[2] = locale.getClass();
				paramArray[3] = converter.getClass();
				paramArray[4] = matSectionBean.getClass();

				results = (java.util.HashMap)(busObj.getClass().getMethod("insertMaternityConsRecs",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

				inserted = (((Boolean) results.get("status")).booleanValue());
				error_msg = (String)	results.get("error");
				accessionNum = (String)	results.get("accessionNum") == null ? "" : (String)	results.get("accessionNum");
				results.clear();

				out.println("<script>top.content.workAreaFrame.recMatConsTabsFrame.document.matConsTabsForm.prevSecHdgCode.value = top.content.workAreaFrame.recMatConsTabsFrame.document.matConsTabsForm.sec_hdg_code.value;</script>");
				out.println("<script>top.content.workAreaFrame.recMatConsTabsFrame.document.matConsTabsForm.prevSubSecHdgCode.value = top.content.workAreaFrame.recMatConsTabsFrame.document.matConsTabsForm.sub_sec_hdg_code.value;</script>");



				//out.println("<script>top.content.workAreaFrame.recMatConsTabsFrame.location.href='../eCA/jsp/RecMaternityConsTabs.jsp?accessionNum="+accessionNum+"&sectionType="+sectionType+"&sec_hdg_code="+secHdgCode+"';</script>");
				out.println("<script>top.content.workAreaFrame.location.href='../eCommon/html/blank.html';</script>");
				//out.println("<script>top.content.workAreaFrame.recMatConsDetailsFrame.location.href='../eCommon/html/blank.html';</script>");
				//out.println("<script>top.content.workAreaFrame.recMatConsTabsFrame.location.href='../eCommon/html/blank.html';</script>");
				//out.println("<script>top.content.workAreaFrame.recMatConsBtnsFrame.location.href='../eCommon/html/blank.html';</script>");

				out.println("<script>top.content.matFrame.location.reload();</script>");

				out.println("<script>top.content.messageFrame.location.href='../eCommon/jsp/error.jsp?err_num="+error_msg+"'</script>");

				//commented by deepa and hari on 13/09/2007 3:43 pm
				 //out.println("<script>top.content.workAreaFrame.recMatConsBlankFrame.location.href='../eCA/jsp/RecMaternityConsControl.jsp?modeValue"+modeValue+"&sec_hdg_code="+secHdgCode+"&sub_sec_hdg_code="+subSecHdgCode+"'</script>");

				//response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode(error_msg,"UTF-8"));

			}//end of try - ejb part
			catch(Exception eee)
			{				
				eee.printStackTrace();
			}
		}//end of try - main
		catch(Exception e)
		{
			e.printStackTrace();			
		}
	}//end of recordMaternityCons()

	private void closeMaternityEvents(HttpServletRequest request, HttpServletResponse response, java.io.PrintWriter out) throws ServletException, java.io.IOException
	{
		HttpSession session = request.getSession(false);
		java.util.Properties p = (Properties) session.getValue("jdbc");
		String locale = (String) p.getProperty("LOCALE");
		String facilityId = (String) session.getAttribute("facility_id") == null ? "" : (String) session.getAttribute("facility_id");
		String addedByUser = (String) session.getAttribute("login_user") == null ? "" : (String) session.getAttribute("login_user");
		String clinician_id = (String) session.getAttribute("ca_practitioner_id") == null ? "" : (String) session.getAttribute("ca_practitioner_id");
		//String patientId = "";
		String loginAtWsNo = p.getProperty("client_ip_address") == null ? "" : p.getProperty("client_ip_address");
		Hashtable htParameter = new Hashtable();
		HashMap sectData = new HashMap();

		try
		{

			Enumeration enumParameter = request.getParameterNames();
			String parameterName = "";
			String parameterValue = "";

			while(enumParameter.hasMoreElements())
			{
				parameterName = (String) enumParameter.nextElement();
				parameterValue = request.getParameter(parameterName) == null ? "" : request.getParameter(parameterName);
				htParameter.put(parameterName, parameterValue);
				sectData.put(parameterName, parameterValue);
				//if(parameterName.equals("patientId")) patientId = parameterValue;
				//else if(parameterName.equals("encounterId")) encounterId = parameterValue;
				//else if(parameterName.equals("securityLevel")) securityLevel = parameterValue;
				//else if(parameterName.equals("patientClass")) patientClass = parameterValue;
				//else if(parameterName.equals("secHdgCode")) secHdgCode = parameterValue;
				//else if(parameterName.equals("subSecHdgCode")) subSecHdgCode = parameterValue;
				//else if(parameterName.equals("sectionType")) sectionType = parameterValue;
				//else if(parameterName.equals("modeValue"))	 modeValue= parameterValue;
			}//end of enumParameter		
			
			sectData.put("facilityId",facilityId);
			sectData.put("addedByUser",addedByUser);
			sectData.put("loginAtWsNo",loginAtWsNo);
			sectData.put("clinician_id",clinician_id);
						
			try
			{
				java.util.HashMap results = null;
				boolean inserted = false;
				String error_msg = "";
				boolean local_ejbs = false;

				if((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") != null) && (getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE")))
					local_ejbs = true;

				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/RecMaternityCons",RecMaternityConsHome.class,local_ejbs);

				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[] = new Object[3];
				argArray[0] = p;
				argArray[1] = sectData;
				argArray[2] = locale;
				

				Class [] paramArray = new Class[3];
				paramArray[0] = p.getClass();
				paramArray[1] = sectData.getClass();
				paramArray[2] = locale.getClass();
				
				results = (java.util.HashMap)(busObj.getClass().getMethod("closeMaternityEvent",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

				inserted = (((Boolean) results.get("status")).booleanValue());
				error_msg = (String)	results.get("error");
				
				results.clear();

				//out.println("<script>top.content.workAreaFrame.recMatConsTabsFrame.location.href='../eCA/jsp/RecMaternityConsTabs.jsp?accessionNum="+accessionNum+"&sectionType="+sectionType+"&sec_hdg_code="+secHdgCode+"';</script>");
				out.println("<script>top.content.workAreaFrame.recMatConsDetailsFrame.location.href='../eCommon/html/blank.html';</script>");
				out.println("<script>top.content.workAreaFrame.recMatConsTabsFrame.location.href='../eCommon/html/blank.html';</script>");
				out.println("<script>top.content.workAreaFrame.recMatConsBtnsFrame.location.href='../eCommon/html/blank.html';</script>");

				out.println("<script>top.content.matFrame.location.reload();</script>");

				out.println("<script>top.content.messageFrame.location.href='../eCommon/jsp/error.jsp?err_num="+error_msg+"'</script>");

				
			}//end of try - ejb part
			catch(Exception eee)
			{				
				eee.printStackTrace();
			}
		}//end of try - main
		catch(Exception e)
		{
			e.printStackTrace();						
		}


	}


	// Added by Sridhar Reddy on 22/09/2009 for PMG20089-CRF-0690 changes
	private void recordMaternityDeliveryReport(HttpServletRequest request, HttpServletResponse response, java.io.PrintWriter out) throws ServletException, java.io.IOException
	{

		HttpSession session = request.getSession(false);
		java.util.Properties p = (Properties) session.getValue("jdbc");		
		String locale = (String) p.getProperty("LOCALE");
		String sqlQuery = "";		
		//String sqlQuery1 = "";		//checkstyle
		String error_msg = "";				
		int count = 0 ;
		String facility_id = (String) session.getAttribute("facility_id") == null ? "" : (String) session.getAttribute("facility_id");
		String added_by_id = (String) session.getAttribute("login_user") == null ? "" : (String) session.getAttribute("login_user");
		String clinician_id = (String) session.getAttribute("ca_practitioner_id") == null ? "" : (String) session.getAttribute("ca_practitioner_id");		
		String added_at_ws_no = p.getProperty("client_ip_address") == null ? "" : p.getProperty("client_ip_address");
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmtDup = null;
		ResultSet			rs1	=	null;
		ResultSet			rsDup	=	null;
		Hashtable tabdata = null;
		StringBuffer delRecDataHtml = new StringBuffer();
	//Web logic Conversion -- [IN037372] Start.	
		//oracle.sql.CLOB	clob_html_content	=	null ;
		java.sql.Clob clob_html_content	=	null ;
	//Web logic Conversion -- [IN037372] End.
		//java.io.Writer			html_content_writer		=	null;//Checkstyle
		java.io.BufferedWriter	bf_html_content_writer	=	null;
		String accession_num = "";
		String delivery_type_desc = "";

		try
		{	
			String mother_patient_id = request.getParameter("mother_patient_id") == null ? "" : request.getParameter("mother_patient_id");
			String encounter_id = request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
			String delivery_type = request.getParameter("delivery_type") == null ? "" : request.getParameter("delivery_type");
			String attend_pract_id = request.getParameter("attend_pract_id") == null ? "" : request.getParameter("attend_pract_id");
			String attend_nurse_id = request.getParameter("attend_nurse_id") == null ? "" : request.getParameter("attend_nurse_id");
			String proc_classification = request.getParameter("proc_classification") == null ? "" : request.getParameter("proc_classification");
			String del_surg_classification = request.getParameter("del_surg_classification") == null ? "" : request.getParameter("del_surg_classification");
			String vaginal_delivery_type = request.getParameter("vaginal_delivery_type") == null ? "" : request.getParameter("vaginal_delivery_type");
			String no_of_birth = request.getParameter("no_of_birth") == null ? "" : request.getParameter("no_of_birth");
			String comp_in_del_stage1 = request.getParameter("comp_in_del_stage1") == null ? "" : request.getParameter("comp_in_del_stage1");
			String comp_in_del_stage2 = request.getParameter("comp_in_del_stage2") == null ? "" : request.getParameter("comp_in_del_stage2");
			String comp_in_del_stage3 = request.getParameter("comp_in_del_stage3") == null ? "" : request.getParameter("comp_in_del_stage3");
			String comp_of_delivery = request.getParameter("comp_of_delivery") == null ? "" : request.getParameter("comp_of_delivery");
			String foetus_comp_of_delivery = request.getParameter("foetus_comp_of_delivery") == null ? "" : request.getParameter("foetus_comp_of_delivery");				
			String module_id = request.getParameter("module_id") == null ? "" : request.getParameter("module_id");				
			String cycle_no = request.getParameter("cycle_no") == null ? "0" : request.getParameter("cycle_no");		
			String finalize_yn = request.getParameter("finalize_yn") == null ? "N" : request.getParameter("finalize_yn");				
			String modeValue = request.getParameter("modeValue") == null ? "" : request.getParameter("modeValue");								
			String lmp_date = request.getParameter("lmp_date") == null ? "" : request.getParameter("lmp_date");	
			
			String splty_event_code = request.getParameter("splty_event_code") == null ? "" : request.getParameter("splty_event_code");
			String splty_task_code = request.getParameter("splty_task_code") == null ? "" : request.getParameter("splty_task_code");
			String patient_class = request.getParameter("patient_class") == null ? "" : request.getParameter("patient_class");

			String chkDuplicate = " select FINALIZE_YN from CA_SPL_DELIVERY_RECORD WHERE FACILITY_ID = ? AND  MOTHER_PATIENT_ID=? AND CYCLE_NO = ? " ;

			String finalized = "";
			
			con = ConnectionManager.getConnection();

			pstmtDup = con.prepareStatement(chkDuplicate);
			
			pstmtDup.setString(1,facility_id);
			pstmtDup.setString(2,mother_patient_id);
			pstmtDup.setInt(3,Integer.parseInt(cycle_no));

			rsDup = pstmtDup.executeQuery();

			while(rsDup.next())
			{

				finalized = rsDup.getString("FINALIZE_YN")==null?"N":rsDup.getString("FINALIZE_YN");

			}

			if (rsDup != null) rsDup.close();
			if (pstmtDup != null) pstmtDup.close();
			
			
			if (modeValue.equals("Update"))
			{
				sqlQuery = "UPDATE CA_SPL_DELIVERY_RECORD SET ATTEND_PRACT_ID = ?, ATTEND_NURSE_ID = ?, PROC_CLASSIFICATION = ?, DEL_SURG_CLASSIFICATION =? , VAGINAL_DELIVERY_TYPE = ?, NO_OF_BIRTH = ?, COMP_IN_DEL_STAGE1 = ?, COMP_IN_DEL_STAGE2 = ?, COMP_IN_DEL_STAGE3 = ?, COMP_OF_DELIVERY = ?, FOETUS_COMP_OF_DELIVERY = ?,FINALIZE_YN = ?, MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ?,LMP=to_date(?,'dd/mm/yyyy') WHERE FACILITY_ID = ? AND  MOTHER_PATIENT_ID=? AND CYCLE_NO = ?";
			}else{
				sqlQuery = "INSERT INTO CA_SPL_DELIVERY_RECORD (FACILITY_ID, ENCOUNTER_ID, MOTHER_PATIENT_ID, DELIVERY_TYPE, ATTEND_PRACT_ID, ATTEND_NURSE_ID, PROC_CLASSIFICATION, DEL_SURG_CLASSIFICATION, VAGINAL_DELIVERY_TYPE, NO_OF_BIRTH, COMP_IN_DEL_STAGE1, COMP_IN_DEL_STAGE2, COMP_IN_DEL_STAGE3, COMP_OF_DELIVERY, FOETUS_COMP_OF_DELIVERY, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,CYCLE_NO,FINALIZE_YN,LMP) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?,?,to_date(?,'dd/mm/yyyy'))";
			}		

			if (delivery_type.indexOf("$") > 0)			
				delivery_type = delivery_type.substring(0,delivery_type.indexOf("$"));							
		if(!finalized.equals("Y"))
		{

			
			pstmt = con.prepareStatement(sqlQuery);
			if (modeValue.equals("Update"))
			{
				pstmt.setString(1,attend_pract_id);
				pstmt.setString(2,attend_nurse_id);
				pstmt.setString(3,proc_classification);
				pstmt.setString(4,del_surg_classification);
				pstmt.setString(5,vaginal_delivery_type);
				pstmt.setString(6,no_of_birth);
				pstmt.setString(7,comp_in_del_stage1);
				pstmt.setString(8,comp_in_del_stage2);
				pstmt.setString(9,comp_in_del_stage3);
				pstmt.setString(10,comp_of_delivery);
				pstmt.setString(11,foetus_comp_of_delivery);
				pstmt.setString(12,finalize_yn);
				pstmt.setString(13,added_by_id);
				pstmt.setString(14,added_at_ws_no);
				pstmt.setString(15,facility_id);			
				pstmt.setString(16,lmp_date);							
				pstmt.setString(17,facility_id);
				//pstmt.setString(18,encounter_id);
				pstmt.setString(18,mother_patient_id);
				pstmt.setInt(19,Integer.parseInt(cycle_no));
				

			}else{
				pstmt.setString(1,facility_id);
				pstmt.setString(2,encounter_id);
				pstmt.setString(3,mother_patient_id);
				pstmt.setString(4,delivery_type);
				pstmt.setString(5,attend_pract_id);
				pstmt.setString(6,attend_nurse_id);
				pstmt.setString(7,proc_classification);
				pstmt.setString(8,del_surg_classification);
				pstmt.setString(9,vaginal_delivery_type);
				pstmt.setString(10,no_of_birth);
				pstmt.setString(11,comp_in_del_stage1);
				pstmt.setString(12,comp_in_del_stage2);
				pstmt.setString(13,comp_in_del_stage3);
				pstmt.setString(14,comp_of_delivery);
				pstmt.setString(15,foetus_comp_of_delivery);
				pstmt.setString(16,added_by_id);
				pstmt.setString(17,added_at_ws_no);
				pstmt.setString(18,facility_id);
				pstmt.setString(19,added_by_id);
				pstmt.setString(20,added_at_ws_no);
				pstmt.setString(21,facility_id);
				pstmt.setInt(22,Integer.parseInt(cycle_no));
				pstmt.setString(23,finalize_yn);	
				pstmt.setString(24,lmp_date);	
			}
				
			count = pstmt.executeUpdate();
			if (pstmt != null) pstmt.close();
		}
			if(finalize_yn.equals("Y")&&count>0)
			{

				
				pstmt = con.prepareStatement("select CA_SPLTY_EVENT_TRN.nextval accession_num from dual ");
				rs1 = pstmt.executeQuery();
			
				if(rs1.next())
				{
				  accession_num = rs1.getString("accession_num");
				}

				if (rs1 != null) rs1.close();
				if (pstmt != null) pstmt.close();

				String del_desc_dtl = "SELECT mp_get_desc.MP_NOD_TYPE(?,?,2)  DELIVERY_TYPE,am_get_desc.AM_PRACTITIONER(?,?,1) ATTEND_PRACT_ID, am_get_desc.AM_PRACTITIONER(?,?,1) ATTEND_NURSE_ID,mp_get_desc.MP_PROC_CLASSIFICATION(?,?,2)  PROC_CLASSIFICATION, mp_get_desc.MP_DELY_SURG_CLFN(?,?,2) DEL_SURG_CLASSIFICATION, mp_get_desc.MP_VAGINAL_DELY_TYPE(?,?,2) VAGINAL_DELIVERY_TYPE, (SELECT SHORT_DESC FROM MP_COMPLN_DELIVERY_LANG_VW WHERE LANGUAGE_ID = ? AND COMPLNS_IN_1ST_STAGE_LABOUR_YN = 'Y' AND COMPLN_DELY_TYPE='M' AND COMPLN_DELY_CODE = ? ) COMP_IN_DEL_STAGE1_DESC, (SELECT SHORT_DESC FROM MP_COMPLN_DELIVERY_LANG_VW WHERE LANGUAGE_ID = ? AND COMPLNS_IN_2ND_STAGE_LABOUR_YN = 'Y' AND COMPLN_DELY_TYPE='M' AND COMPLN_DELY_CODE = ?) COMP_IN_DEL_STAGE2_DESC, (SELECT SHORT_DESC FROM MP_COMPLN_DELIVERY_LANG_VW WHERE LANGUAGE_ID = ? AND COMPLNS_IN_3RD_STAGE_LABOUR_YN = 'Y' AND COMPLN_DELY_TYPE='M' AND COMPLN_DELY_CODE = ?) COMP_IN_DEL_STAGE3_DESC, mp_get_desc.MP_COMPLN_DELIVERY(?,?,2) COMP_OF_DELIVERY, mp_get_desc.MP_COMPLN_DELIVERY(?,?,2) FOETUS_COMP_OF_DELIVERY FROM DUAL ";

				pstmt = con.prepareStatement(del_desc_dtl);
				
				pstmt.setString(1,delivery_type);
				//pstmt.setString(1,del_surg_classification);
				pstmt.setString(2,locale);
				pstmt.setString(3,attend_pract_id);
				pstmt.setString(4,locale);
				pstmt.setString(5,attend_nurse_id);
				pstmt.setString(6,locale);
				pstmt.setString(7,proc_classification);
				pstmt.setString(8,locale);
				pstmt.setString(9,del_surg_classification);
				pstmt.setString(10,locale);
				pstmt.setString(11,vaginal_delivery_type);
				pstmt.setString(12,locale);
				pstmt.setString(13,locale);
				pstmt.setString(14,comp_in_del_stage1);
				pstmt.setString(15,locale);
				pstmt.setString(16,comp_in_del_stage2);
				pstmt.setString(17,locale);
				pstmt.setString(18,comp_in_del_stage3);
				pstmt.setString(19,comp_of_delivery);
				pstmt.setString(20,locale);
				pstmt.setString(21,foetus_comp_of_delivery);
				pstmt.setString(22,locale);

				rs1 = pstmt.executeQuery();

				while(rs1.next())
				{

				delivery_type_desc = rs1.getString("DELIVERY_TYPE")==null?"":rs1.getString("DELIVERY_TYPE");
				attend_pract_id = rs1.getString("ATTEND_PRACT_ID")==null?"":rs1.getString("ATTEND_PRACT_ID");
				attend_nurse_id  = rs1.getString("ATTEND_NURSE_ID")==null?"":rs1.getString("ATTEND_NURSE_ID");
				proc_classification  = rs1.getString("PROC_CLASSIFICATION")==null?"":rs1.getString("PROC_CLASSIFICATION");
				del_surg_classification  = rs1.getString("DEL_SURG_CLASSIFICATION")==null?"":rs1.getString("DEL_SURG_CLASSIFICATION");
				vaginal_delivery_type  = rs1.getString("VAGINAL_DELIVERY_TYPE")==null?"":rs1.getString("VAGINAL_DELIVERY_TYPE");
				comp_in_del_stage1  = rs1.getString("COMP_IN_DEL_STAGE1_DESC")==null?"":rs1.getString("COMP_IN_DEL_STAGE1_DESC");
				comp_in_del_stage2  = rs1.getString("COMP_IN_DEL_STAGE2_DESC")==null?"":rs1.getString("COMP_IN_DEL_STAGE2_DESC");
				comp_in_del_stage3  = rs1.getString("COMP_IN_DEL_STAGE3_DESC")==null?"":rs1.getString("COMP_IN_DEL_STAGE3_DESC");
				comp_of_delivery  = rs1.getString("COMP_OF_DELIVERY")==null?"":rs1.getString("COMP_OF_DELIVERY");
				foetus_comp_of_delivery  = rs1.getString("FOETUS_COMP_OF_DELIVERY")==null?"":rs1.getString("FOETUS_COMP_OF_DELIVERY");


				}

				if (rs1 != null) rs1.close();
				if (pstmt != null) pstmt.close();




				//String insCr_EncQry = "insert into CR_ENCOUNTER_DETAIL (HIST_REC_TYPE, CONTR_SYS_ID, ACCESSION_NUM, CONTR_SYS_EVENT_CODE, PATIENT_ID, FACILITY_ID, PATIENT_CLASS, ENCOUNTER_ID, EVENT_CLASS, EVENT_CODE, EVENT_GROUP, EVENT_DATE, HIST_DATA_TYPE, NUM_DATA_YN,HIST_STORAGE_IND, PERFORMED_BY_ID,AUTHORIZED_BY_ID, ADDED_BY_ID, ADDED_DATE, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_FACILITY_ID, EVENT_CODE_TYPE, EVENT_GROUP_TYPE )values(?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,?,?,?,sysdate,?,?,sysdate,?,?,? )" ;
				String insCr_EncQry = "INSERT INTO CA_PAT_SPLTY_EPISODE_TASK (ACCESSION_NUM, PATIENT_ID, FACILITY_ID, MODULE_ID, CYCLE_NO,  SPLTY_EVENT_CODE, SPLTY_TASK_CODE, ENCOUNTER_ID, PATIENT_CLASS, PRACITIONER_ID,  TRANS_DATE, DTL_REC_PRESENT_YN, SPLTY_EVENT_RESULT_TYPE, SPLTY_EVENT_RESULT_CODE,  ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID,  MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, BIRTH_ORDER,FINALIZE_YN) values(?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,?)" ;

				//String insCrEncTxtQry = "INSERT INTO CR_ENCOUNTER_DETAIL_TXT(HIST_REC_TYPE, CONTR_SYS_ID, ACCESSION_NUM, CONTR_SYS_EVENT_CODE, HIST_DATA) values (?,?,?,?,empty_clob()) ";
				String insCrEncTxtQry = "insert into CA_PAT_SPLTY_TASK_DTL (ACCESSION_NUM, HDR_CODE, SUBHDR_CODE, XML_CONTENT, HTM_CONTENT,ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) values (?,?,?,empty_clob(),empty_clob(),?,sysdate,?,?,?,sysdate,?,?) ";

				//String updCrEncTxtQry =" select HIST_DATA from CR_ENCOUNTER_DETAIL_TXT where HIST_REC_TYPE=? and CONTR_SYS_ID=?  and ACCESSION_NUM=? and CONTR_SYS_EVENT_CODE = ? for update " ;
				String updCrEncTxtQry =" select HTM_CONTENT from  CA_PAT_SPLTY_TASK_DTL where ACCESSION_NUM =? and HDR_CODE= ? and SUBHDR_CODE =? for update " ;
				
				
				delRecDataHtml.append(" <br><center><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"font-family:Verdana\"><tr><td align=\"left\" width=\"20%\" class=\"MCLABEL\" nowrap>Delivery Type&nbsp;&nbsp;&nbsp;</td><td align=\"left\" class=\"MCDATA\"><b>:</b>&nbsp;&nbsp;&nbsp;");

				delRecDataHtml.append(delivery_type_desc);
														
				delRecDataHtml.append("</td></tr><tr><td align=\"left\" width=\"20%\" class=\"MCLABEL\" nowrap>							LMP&nbsp;&nbsp;&nbsp;</td><td align=\"left\" class=\"MCDATA\">							<b>:</b>&nbsp;&nbsp;&nbsp;"); 
				delRecDataHtml.append(lmp_date);
				
				delRecDataHtml.append("	</td></tr><tr><td align=\"left\" width=\"20%\" class=\"MCLABEL\" nowrap>Attending Practitioner&nbsp;&nbsp;&nbsp;			</td><td align=\"left\" class=\"MCDATA\">						<b>:</b>&nbsp;&nbsp;&nbsp;");
				delRecDataHtml.append(attend_pract_id); // pract name
				delRecDataHtml.append("	</td></tr><tr><td align=\"left\" width=\"20%\" class=\"MCLABEL\" nowrap> Attending Nurse&nbsp;&nbsp;&nbsp;</td>			<td align=\"left\" class=\"MCDATA\">							<b>:</b>&nbsp;&nbsp;&nbsp;");
				delRecDataHtml.append(attend_nurse_id); // nurse name
				delRecDataHtml.append("	</td></tr><tr>	<td align=\"left\" width=\"20%\" class=\"MCLABEL\" nowrap>Procedure Classification&nbsp;&nbsp;&nbsp;			</td><td align=\"left\" class=\"MCDATA\">						<b>:</b>&nbsp;&nbsp;&nbsp;");
				delRecDataHtml.append(proc_classification); // nurse name
				delRecDataHtml.append("</td>	</tr><tr><td align=\"left\" width=\"20%\" class=\"MCLABEL\" nowrap>Delivery Surgical Classification&nbsp;&nbsp;&nbsp;	</td><td align=\"left\" class=\"MCDATA\">							<b>:</b>&nbsp;&nbsp;&nbsp;");
				delRecDataHtml.append(del_surg_classification); // nurse name

				delRecDataHtml.append("</td></tr><tr><td align=\"left\" width=\"20%\" class=\"MCLABEL\" nowrap>Vaginal Delivery Type</td>&nbsp;&nbsp;&nbsp;		<td align=\"left\" class=\"MCDATA\"><b>:</b>&nbsp;&nbsp;&nbsp;");
				delRecDataHtml.append(vaginal_delivery_type); // nurse name
				delRecDataHtml.append("</td></tr><tr><td align=\"left\" width=\"20%\" class=\"MCLABEL\" nowrap>No of Birth&nbsp;&nbsp;&nbsp;");
				delRecDataHtml.append("	</td><td align=\"left\" class=\"MCDATA\">							<b>:</b>&nbsp;&nbsp;&nbsp;");

				delRecDataHtml.append(no_of_birth); // nurse name
				delRecDataHtml.append("	</td></tr><tr><td align=\"left\" width=\"20%\" class=\"MCLABEL\" nowrap>Complication in Stage 1 of Delivery&nbsp;&nbsp;&nbsp;</td><td align=\"left\" class=\"MCDATA\">							<b>:</b>&nbsp;&nbsp;&nbsp;");
				delRecDataHtml.append(comp_in_del_stage1); // nurse name
				delRecDataHtml.append("	</td></tr><tr><td align=\"left\" width=\"20%\" class=\"MCLABEL\" nowrap>Complication in Stage 2 of Delivery&nbsp;&nbsp;&nbsp;	</td><td align=\"left\" class=\"MCDATA\">							<b>:</b>&nbsp;&nbsp;&nbsp;");
				delRecDataHtml.append(comp_in_del_stage2); // nurse name
				delRecDataHtml.append("	</td></tr><tr><td align=\"left\" width=\"20%\" class=\"MCLABEL\" nowrap>Complication in Stage 3 of Delivery&nbsp;&nbsp;&nbsp;	</td><td align=\"left\" class=\"MCDATA\">							<b>:</b>&nbsp;&nbsp;&nbsp;");
				delRecDataHtml.append(comp_in_del_stage3); // nurse name
				delRecDataHtml.append("	</td></tr><tr><td align=\"left\" width=\"20%\" class=\"MCLABEL\" nowrap>Complication of Delivery&nbsp;&nbsp;&nbsp;	</td><td align=\"left\" class=\"MCDATA\">							<b>:</b>&nbsp;&nbsp;&nbsp;");
				delRecDataHtml.append(comp_of_delivery); // nurse name
				delRecDataHtml.append("</td></tr><tr><td align=\"left\" width=\"20%\" class=\"MCLABEL\" nowrap>Foetus Complication of Delivery&nbsp;&nbsp;&nbsp;	</td><td align=\"left\" class=\"MCDATA\"><b>:</b>&nbsp;&nbsp;&nbsp;");
				delRecDataHtml.append(foetus_comp_of_delivery); // nurse name
				delRecDataHtml.append("</td></tr></table></center><br> ");

				//ACCESSION_NUM, PATIENT_ID, FACILITY_ID, MODULE_ID, CYCLE_NO,  SPLTY_EVENT_CODE, SPLTY_TASK_CODE, ENCOUNTER_ID, PATIENT_CLASS, PRACITIONER_ID,  TRANS_DATE, DTL_REC_PRESENT_YN, SPLTY_EVENT_RESULT_TYPE, SPLTY_EVENT_RESULT_CODE,  ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID,  MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, BIRTH_ORDER,FINALIZE_YN
				
				pstmt = con.prepareStatement(insCr_EncQry);
				pstmt.setString(1,module_id+accession_num);
				pstmt.setString(2,mother_patient_id);
				pstmt.setString(3,facility_id);
				pstmt.setString(4,module_id);
				pstmt.setInt(5,Integer.parseInt(cycle_no));
				pstmt.setString(6,splty_event_code);
				pstmt.setString(7,splty_task_code);
				pstmt.setString(8,encounter_id);
				pstmt.setString(9,patient_class);
				pstmt.setString(10,clinician_id);
				pstmt.setString(11,"N");
				pstmt.setString(12,"TG");
				pstmt.setString(13,"MC25");
				pstmt.setString(14,added_by_id);
				pstmt.setString(15,added_at_ws_no);
				pstmt.setString(16,facility_id);
				pstmt.setString(17,added_by_id);
				pstmt.setString(18,added_at_ws_no);
				pstmt.setString(19,facility_id);
				pstmt.setInt(20,Integer.parseInt("1"));
				pstmt.setString(21,"Y");

			

				count = pstmt.executeUpdate();
				if (pstmt != null) pstmt.close();
				if(count>0)
				{
					//ACCESSION_NUM, HDR_CODE, SUBHDR_CODE, XML_CONTENT, HTM_CONTENT,ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID
					pstmt = con.prepareStatement(insCrEncTxtQry);
					pstmt.setString(1,module_id+accession_num);
					pstmt.setString(2,"MC25");
					pstmt.setString(3,"MC51");
					pstmt.setString(4,added_by_id);
					pstmt.setString(5,added_at_ws_no);
					pstmt.setString(6,facility_id);
					pstmt.setString(7,added_by_id);
					pstmt.setString(8,added_at_ws_no);
					pstmt.setString(9,facility_id);
										

					count = pstmt.executeUpdate();
					if (pstmt != null) pstmt.close();

					pstmt = con.prepareStatement(updCrEncTxtQry);
					
					pstmt.setString(1,module_id+accession_num);
					pstmt.setString(2,"MC25");
					pstmt.setString(3,"MC51");

					rs1 = pstmt.executeQuery();

					if(rs1.next())
					{
					//Web logic Conversion -- [IN037372] Start.	
						//clob_html_content	=	(oracle.sql.CLOB) rs1.getObject("HTM_CONTENT");
						//html_content_writer		=	((oracle.sql.CLOB)clob_html_content).getCharacterOutputStream();						
						//bf_html_content_writer = new java.io.BufferedWriter(html_content_writer);
						
						clob_html_content 	= rs1.getClob("HTM_CONTENT");
						bf_html_content_writer = new java.io.BufferedWriter(clob_html_content.setCharacterStream(0));
					//Web logic Conversion -- [IN037372] End.
						bf_html_content_writer.write(delRecDataHtml.toString(),0,delRecDataHtml.length());

						bf_html_content_writer.flush();
						bf_html_content_writer.close();
					}
					if (rs1 != null) rs1.close();
					if (pstmt != null) pstmt.close();

				}
			}
					
			con.commit();					
			if(!finalized.equals("Y"))
			{
				if (count > 0)
				{
					tabdata = MessageManager.getMessage(locale,"RECORD_INSERTED","CA");
					error_msg= (String) tabdata.get("message");				 
				}else{
					tabdata = MessageManager.getMessage(locale,"FAILED_TRANSACTION","CA");
					error_msg = (String) tabdata.get("message"); 
				}
			}
			else
			{
				tabdata = MessageManager.getMessage(locale,"DELV_EXIST","CA");
				error_msg= (String) tabdata.get("message");

			}
			
			out.println("<script>top.content.workAreaFrame.recMatDeliveryDetails.location.href='../eCommon/html/blank.html';</script>");		
			out.println("<script>top.content.workAreaFrame.recMatConsBtnsFrame.location.href='../eCommon/html/blank.html';</script>");
			out.println("<script>top.content.matFrame.location.reload();</script>");
			out.println("<script>top.content.messageFrame.location.href='../eCommon/jsp/error.jsp?err_num="+error_msg+"'</script>");
		}//end of try - main
		catch(Exception e)
		{
			try
			{				
				e.printStackTrace();
				con.rollback();
				tabdata = MessageManager.getMessage(locale,"FAILED_TRANSACTION","CA");
				error_msg = (String) tabdata.get("message"); 
				out.println("<script>top.content.messageFrame.location.href='../eCommon/jsp/error.jsp?err_num="+error_msg+"'</script>");
			}
			catch (Exception ee)
			{
				ee.printStackTrace();				
			}
			
			e.printStackTrace();			
		}finally{
			if(con!=null) ConnectionManager.returnConnection(con);
		}
	}//end of recordMaternityDeliveryReport()

}//end of class]

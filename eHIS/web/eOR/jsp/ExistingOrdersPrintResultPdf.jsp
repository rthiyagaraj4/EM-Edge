<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------
15/01/2021	7632		Sivabagyam M		15/01/2021		Ramesh G	ML-MMOH-CRF-1261.1
---------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="java.sql.*,java.util.*,java.text.*,webbeans.eCommon.*,java.math.*,java.net.*,eOR.*,webbeans.eCommon.ConnectionManager"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<% request.setCharacterEncoding("UTF-8"); 

		Properties p;
		session = request.getSession(false);
		p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");
		String modeId 		=  request.getParameter("Mode")==null ? "" : request.getParameter("Mode"); 
		String patient_id		=  request.getParameter("patient_id")==null ? "" : request.getParameter("patient_id");
		String clinician_id			= (String) session.getValue("ca_practitioner_id");
		String resp_id = (String)session.getValue("responsibility_id");
		String login_user = (String)session.getValue("login_user");
		String facilityid = (String)session.getValue("facility_id");
		String login_at_ws_no=p.getProperty("client_ip_address");
		String accession_num=request.getParameter("accession_num")==null?"":request.getParameter("accession_num");
		String req_date=request.getParameter("reqdate")==null?"":request.getParameter("reqdate");
		String operating_facility_id=request.getParameter("operating_facility_id")==null?"":request.getParameter("operating_facility_id");
		String report_id=request.getParameter("report_id")==null?"":request.getParameter("report_id");
		String session_id=request.getParameter("session_id")==null?"":request.getParameter("session_id");
		String p_module_id=request.getParameter("p_module_id")==null?"":request.getParameter("p_module_id");
		String eventCode=request.getParameter("eventCode")==null?"":request.getParameter("eventCode");
		String machine_name=request.getParameter("machine_name")==null?"":request.getParameter("machine_name");
		String facilty=request.getParameter("facilty")==null?"":request.getParameter("facilty");
		//IN070032 ends
		Connection con = null;
	try 
	{
		if("ViewResult".equals(modeId)){
			String bean_id					= "Or_ViewOrder" ;
			String bean_name				= "eOR.ViewOrder";

			ViewOrder bean	= (ViewOrder)getBeanObject( bean_id, bean_name , request) ; 
				bean.viewInsert(locale,login_user,facilty,login_at_ws_no,accession_num,req_date,resp_id,operating_facility_id,report_id,session_id,p_module_id,eventCode,patient_id,machine_name);
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		if(con!=null)ConnectionManager.returnConnection(con,request);
	}
%>

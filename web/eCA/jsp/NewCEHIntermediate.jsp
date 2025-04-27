<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------
07/01/2019	IN069243	sivabagyam M 	07/01/2019		Ramesh G		MO-CRF-20101.2
07/04/2019	IN070032	sivabagyam M 	07/04/2019		Ramesh G		MO-CRF-20101.6
---------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="java.sql.*,java.util.*,java.text.*,webbeans.eCommon.*,java.math.*,java.net.*,eCA.*,webbeans.eCommon.ConnectionManager"  contentType="text/html;charset=UTF-8"%>
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
		String encounterId		=  request.getParameter("encounter_id")==null ? "" : request.getParameter("encounter_id");
		String fac_id = request.getParameter("facility_id")==null?"":request.getParameter("facility_id");
		//IN070032 STARTS
		String fromDate		=  "";
		String toDate		=  "";
		String fdate= request.getParameter("fdate")==null?"":request.getParameter("fdate");
		if(fdate.equals("")){
			fromDate=request.getParameter("from_date")==null ? "" : request.getParameter("from_date");
			toDate		=  request.getParameter("to_date")==null ? "" : request.getParameter("to_date");
		}else{
			fromDate=fdate;
			toDate=  fdate;
		}
		//IN070032 ENDS
		String eventCls		=  request.getParameter("eventCls")==null ? "" : request.getParameter("eventCls");
		String history_type			= request.getParameter("grphistory_type")==null	?"LBIN":request.getParameter("grphistory_type");
		String catalog_nature 		=  request.getParameter("orderCatalogNature")==null ? "" : request.getParameter("orderCatalogNature");
		String selTab				=  request.getParameter("selTab")==null?"":request.getParameter("selTab");
		String clinician_id			= (String) session.getValue("ca_practitioner_id");
		String resp_id = (String)session.getValue("responsibility_id");
		String login_user = (String)session.getValue("login_user");
		String eventGrp				=  request.getParameter("group")==null?"":request.getParameter("group");
		String abnormal				=  request.getParameter("abnormal")==null?"":request.getParameter("abnormal");
		String eventItem				=  request.getParameter("eventItem")==null?"":request.getParameter("eventItem");
		String reln_id		=	request.getParameter("relationship_id")==null?"":request.getParameter("relationship_id");
		String event_cls		=  request.getParameter("event_cls")==null ? "" : request.getParameter("event_cls");
		//IN070032 starts
		String facilityid = (String)session.getValue("facility_id");
		String login_at_ws_no=p.getProperty("client_ip_address");
		String accession_num=request.getParameter("accession_num")==null?"":request.getParameter("accession_num");
		String req_date=request.getParameter("req_date")==null?"":request.getParameter("req_date");
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
		if("printResult".equals(modeId)){
			String bean_id					= "NewClinicalEventHistBean" ;
			String bean_name				= "eCA.NewClinicalEventHistBean";

				NewClinicalEventHistBean bean	= (NewClinicalEventHistBean)getBeanObject( bean_id, bean_name , request) ; 
				bean.callOnlinePrint(locale,history_type,patient_id,encounterId,clinician_id,resp_id,fromDate,toDate,catalog_nature,selTab,fac_id,abnormal,eventCls,eventGrp,eventItem,login_user,reln_id,facilityid);
		}else if("printEvent".equals(modeId)){
			String bean_id					= "NewClinicalEventHistBean" ;
			String bean_name				= "eCA.NewClinicalEventHistBean";

				NewClinicalEventHistBean bean	= (NewClinicalEventHistBean)getBeanObject( bean_id, bean_name , request) ; 
				bean.onLinePrintingEvent(locale,history_type,patient_id,encounterId,clinician_id,resp_id,fromDate,toDate,catalog_nature,selTab,fac_id,abnormal,event_cls,eventGrp,eventItem,login_user,reln_id,facilityid); 
		}else if("ViewResult".equals(modeId)){
			String bean_id					= "NewClinicalEventHistBean" ;
			String bean_name				= "eCA.NewClinicalEventHistBean";

				NewClinicalEventHistBean bean	= (NewClinicalEventHistBean)getBeanObject( bean_id, bean_name , request) ; 
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

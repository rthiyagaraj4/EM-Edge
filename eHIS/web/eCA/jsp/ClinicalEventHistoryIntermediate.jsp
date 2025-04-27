<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History	Name				Rev.Date	Rev.Name			Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
21/06/2020  	IN071596	sivabagyam M 	21/06/2020		Ramesh G		MO-CRF-20101.7
21/07/2020  	IN072759	sivabagyam M 	21/06/2020		Ramesh G		MO-CRF-20101.8
26/11/2020	6450		SIVABAGYAM M	26/11/2020		RAMESH G	MO-CRF-20101.10

------------------------------------------------------------------------------------------------------------------------------------------------
*/ 
%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, eCA.*, eCA.Common.*, eCommon.Common.*,java.text.DecimalFormat,java.sql.*,webbeans.eCommon.*" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
request.setCharacterEncoding("UTF-8");
session = request.getSession(false);
String bean_id			= "@NewClinicalEventHistBean";
String bean_id_new		= "NewClinicalEventHistBean";
String bean_name		= "eCA.NewClinicalEventHistBean";
NewClinicalEventHistBean bean	= (NewClinicalEventHistBean)getBeanObject( bean_id_new, bean_name , request); 
Properties p = (Properties)session.getValue("jdbc");
String locale	= (String) p.getProperty("LOCALE");
String index 			= request.getParameter("index")==null ?"":request.getParameter("index");
String patient_id		= request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
String login_user_id			=  request.getParameter("login_user_id")==null?"":request.getParameter("login_user_id");
String hist_data_type		= request.getParameter("hist_data_type")==null?"":request.getParameter("hist_data_type");
String clinician_id  	= request.getParameter("clinician_id")==null?"":request.getParameter("clinician_id");
String contr_sys_event_code		= request.getParameter("contr_sys_event_code")==null?"":request.getParameter("contr_sys_event_code");
String accessionNum		= request.getParameter("accessionNum")==null?"":request.getParameter("accessionNum");
String facility_id  	= request.getParameter("facility_id")==null?"":request.getParameter("facility_id");
String url		= request.getParameter("url")==null?"":request.getParameter("url");
String encounterId 		= request.getParameter("encounterId")==null?"":request.getParameter("encounterId");
String event_date_time 		= request.getParameter("event_date_time")==null?"":request.getParameter("event_date_time");
String strNormalcyInd 	= request.getParameter("strNormalcyInd")==null?"I":request.getParameter("strNormalcyInd");
String selHistType = request.getParameter("selHistType")==null	?"":request.getParameter("selHistType");
if(!selHistType.equals("MERP")){//6450 starts
		if(hist_data_type.equals("HTM"))//IN072759
			bean.getNoteContent(facility_id,event_date_time, contr_sys_event_code, accessionNum ,hist_data_type, locale, encounterId, patient_id, url, clinician_id, login_user_id,strNormalcyInd,selHistType);
		else
			bean.getRadiologyContent(facility_id,event_date_time, contr_sys_event_code, accessionNum ,hist_data_type, locale, encounterId, patient_id, url, clinician_id, login_user_id,strNormalcyInd);//IN072759
	}
	else{
		bean.getMedicalReportContent( facility_id, event_date_time, accessionNum, encounterId, patient_id, clinician_id);
	}//6450 ends
HashMap<String,String> searchData = bean.getRecords();
    out.print(((String)searchData.get(accessionNum)).replaceAll("<IMAGE[^>]*SRC\\s*=\\s*\"[^\"]*\"[^>]*></IMAGE>", ""));//ML-MMOH-SCF-2966
	//out.print((String)searchData.get(accessionNum));	
putObjectInBean(bean_id,bean,session);

%>

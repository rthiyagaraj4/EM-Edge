<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History     Name      			Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
05/02/2018		IN063837		Ramesh Goli											ML-MMOH-CRF-0812
10/09/2018		IN067564		Ramya Maddena		10/09/2018		Ramesh Goli		ML-MMOH-CRF-1186
---------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes start --%>

<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*, eCA.*, org.json.simple.*" contentType="text/html;charset=UTF-8"%>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
	request.setCharacterEncoding("UTF-8");
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
	hash = (Hashtable)hash.get( "SEARCH" ) ;
	String action			=	(String) hash.get("action")==null?"":(String) hash.get("action");//IN067564
	String patientId = (String)hash.get("patient_id") ;
	//IN067564 starts
	String isAuditYN = (String)hash.get("isAuditYN") ;
	String encounter_id = (String)hash.get("encounter_id") ;
	String Recorded_date = (String)hash.get("Recorded_date") ;
	String date_from = (String)hash.get("date_from") ;
	String date_to = (String)hash.get("date_to") ;
	String bean_id="@caballardscore"+patientId+encounter_id;
	//IN067564 ends
	String bean_name="eCA.CABallardScoreBean";
	eCA.CABallardScoreBean beanObj = (eCA.CABallardScoreBean)getObjectFromBean(bean_id,bean_name,session);
	//JSONArray jsonArray = beanObj.getBallardScoreDetails(request, patientId);out.println(jsonArray);
	// commented for IN067564
		
	//IN067564 starts
	if(action.equals("getCount")){
		
		String RecordedScoreYN = beanObj.getBallardScoreNotRecordedYN(request,patientId,encounter_id,date_from,date_to);
		out.println(RecordedScoreYN);
	}else{
		JSONArray jsonArray = beanObj.getBallardScoreDetails(request, patientId,isAuditYN,encounter_id,Recorded_date);
		out.println(jsonArray);	
	}
	//IN067564 ends
%>

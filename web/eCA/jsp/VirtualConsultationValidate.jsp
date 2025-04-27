<%/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History      Name			Description
--------------------------------------------------------------------------------------------------------------
?				100					?           created
15/04/2023		37866			Ramesh G		 MMS-DM-CRF-0226	
---------------------------------------------------------------------------------------------------------------

*/ %>
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*,eCA.*,eCommon.Common.*" contentType="text/html; charset=UTF-8"%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>


<%
request.setCharacterEncoding("UTF-8"); 
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079 
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085 
Connection con=null;
PreparedStatement pstmt=null;
ResultSet rs=null;
try
{
	con =	ConnectionManager.getConnection(request);
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
	hash = (Hashtable)hash.get( "SEARCH" ) ;
	eCA.CAVirtualConsultationBean caVirtualConsultationBean = (eCA.CAVirtualConsultationBean)getObjectFromBean("CA_CAVirtualConsultationBean","eCA.CAVirtualConsultationBean",session);
	String facility_id	= (String)hash.get("facility_id");
	String patient_id	= (String)hash.get("patient_id");
	String episode_type	= (String)hash.get("episode_type");
	String episode_id	= (String)hash.get("episode_id");
	String clinician_id	= (String)hash.get("clinician_id");
	System.out.println("--VirtualConsultationValidate.jsp---------facility_id---->"+facility_id);
	System.out.println("--VirtualConsultationValidate.jsp---------patient_id---->"+patient_id);
	System.out.println("--VirtualConsultationValidate.jsp---------episode_type---->"+episode_type);
	System.out.println("--VirtualConsultationValidate.jsp---------episode_id---->"+episode_id);
	System.out.println("--VirtualConsultationValidate.jsp---------clinician_id---->"+clinician_id);
	String outputString = caVirtualConsultationBean.validateVitrualConsultation(facility_id,patient_id,episode_type,episode_id,clinician_id);
	System.out.println("--VirtualConsultationValidate.jsp---------outputString---->"+outputString);
	out.println(outputString);

	putObjectInBean("CA_SecTempOutputFormBean",caVirtualConsultationBean,session);	
}
catch(Exception e)
{
	e.printStackTrace() ;
}
finally
{
	if (con!= null)
	ConnectionManager.returnConnection(con,request);
} 

%>


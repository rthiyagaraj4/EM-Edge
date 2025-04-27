<!DOCTYPE html>
<%@ page contentType="text/html;charset=windows-1256"  import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"%>
<html>
<title>Clinical Events from Central Server</title>
<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String resp_id					=	checkForNull((String)request.getParameter("responsibility_id"));
		String login_user_id			=	checkForNull((String)request.getParameter("login_user"));  
		String facilityId				=	checkForNull((String)request.getParameter("facility_id"));
		String loggedin_clinician_id	=	checkForNull((String)request.getParameter("ca_practitioner_id"));
		String practitioner_type		=	checkForNull((String)request.getParameter("practitioner_type"));
		String patientid				=	checkForNull((String)request.getParameter("patient_id"));
		String strClientIPAdd			=	checkForNull((String) request.getParameter("ClientIP"));
		String strConnectionPool		=	checkForNull((String) request.getParameter("conpool"));
		String sStyle					=	checkForNull((String) request.getParameter("csssty"));

		String params					=	"",				jdbc_props			=	"";

		try
		{
			session			=	request.getSession(true);
			
			java.util.Properties p	=	new java.util.Properties();

			session.putValue("responsibility_id",resp_id);
			session.putValue("login_user",login_user_id);
			session.putValue("facility_id",facilityId);
			session.putValue("ca_practitioner_id",loggedin_clinician_id);
			session.putValue("practitioner_type",practitioner_type);
			session.putValue("connection_pooling_yn",strConnectionPool);
			p.setProperty( "login_user",login_user_id ) ;
			p.setProperty("connection_pooling_yn",strConnectionPool) ;
			p.setProperty("client_ip_address",strClientIPAdd) ;
			p.setProperty("jdbc_props",jdbc_props) ;
			session.putValue( "jdbc",p ) ;
			session.putValue("PREFERRED_STYLE",sStyle);
			params = "patient_id="+patientid+"&facilityId="+facilityId+"&EHR_YN=Y";
			
		}
		catch (Exception e2)
		{
			e2.printStackTrace();
			
		}
%>
<iframe src="../../eCommon/html/blank.html" name="" id=""  scrolling="no" frameborder="0" noresize style="height:0%;width:100vw"></iframe>
	<iframe src="../../eCommon/html/blank.html" name="" id=""  scrolling="no" frameborder="0" noresize style="height:0%;width:100vw"></iframe>
	<iframe src="../../eCommon/html/blank.html" name="" id=""  scrolling="no" frameborder="0" noresize style="height:0%;width:100vw"></iframe>
	<iframe src="../../eCommon/html/blank.html" name="" id=""  scrolling="no" frameborder="0" noresize style="height:0%;width:100vw"></iframe>
	<iframe src="../../eCA/jsp/FlowSheet.jsp?<%=params%>" name="criteria_f0"   scrolling="no" frameborder="0" noresize style="height:0%;width:100vw"></iframe>
	<iframe src="../../eCommon/jsp/error.jsp"			 name="messageFrame" id="messageFrame"  scrolling="no" frameborder="0" noresize style="height:0%;width:100vw"></iframe>

</html>
<%!
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
%>


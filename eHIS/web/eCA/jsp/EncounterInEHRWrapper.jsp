<!DOCTYPE html>
<%@ page contentType="text/html;charset=windows-1256"  import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	String patientid				=	checkForNull(request.getParameter("patient_id"));
	%>
<html>
<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<title>Clinical Events from Central Repository for <%=patientid%></title>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<body onKeyDown="lockKey()">
<form>
<%
		java.util.Properties	p1					=	(java.util.Properties) session.getValue("jdbc");
		StringBuffer sbConURL			=	 new StringBuffer();
		String resp_id					=	checkForNull((String) session.getValue("responsibility_id"));
		String login_user_id			=	checkForNull((String) session.getValue("login_user"));  
		String facilityId				=	checkForNull((String) session.getValue("facility_id"));
		String loggedin_clinician_id	=	checkForNull((String) session.getValue("ca_practitioner_id"));
		String practitioner_type		=	checkForNull((String) session.getValue("practitioner_type"));

		String strClientIPAdd			=	(String) p1.getProperty("client_ip_address");
		String strConnectionPool		=	(String) p1.getProperty("connection_pooling_yn");

		String params		=	"?patient_id="+patientid+"&facilityId="+facilityId+"&EHR_YN=Y&login_user_id="+login_user_id+"&loggedin_clinician_id="+loggedin_clinician_id+"&practitioner_type="+practitioner_type+"&resp_id="+resp_id+"&ClientIP="+strClientIPAdd+"&conpool="+strConnectionPool+"&csssty="+sStyle;

		sbConURL.append("../../eCA/jsp/EncounterInEHRCentralWrapper.jsp");
		sbConURL.append(params);
		


	/*	Connection con			= null;
		PreparedStatement pstmt = null;
		ResultSet rs			= null;

		try
		{
			con = ConnectionManager.getConnection(request);

			strQuery	=	"select BASE_URL ,DEFAULT_USER_ID,app_password.DECRYPT(DEFAULT_USER_PASSWORD) DEFAULT_USER_PASSWORD,EXT_IMAGE_APPL_NAME from CA_EXT_IMAGE_APPL where EXT_IMAGE_APPL_ID = ?";

			pstmt = con.prepareStatement(strQuery);
			pstmt.setString(1,"EHRVW");
				
			rs = pstmt.executeQuery();

			if(rs != null && rs.next())
				//strBaseURL	=  checkForNull(rs.getString(1));
				strBaseURL	=  "http://indbgl-app25:8899/eHIS";

			sbConURL.delete(0,sbConURL.length());
			if(!strBaseURL.equals("") )
			{
				sbConURL.append(strBaseURL);
				sbConURL.append("/eCA/jsp/EncounterInEHRCentralWrapper.jsp");
				sbConURL.append(params);
			}

			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
		}
		catch (Exception e2)
		{
			e2.printStackTrace();
			
		}
		finally
		{
			if(con != null) ConnectionManager.returnConnection(con,request);
		} */

%>
</form>
</body>
</html>
<%!
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
%>

<SCRIPT>
var arguments; 
var getUrl ='<%=sbConURL.toString()%>';
var features='height=600,width=1000,top=50,left=0,resizable=no';
var retVal=window.open(getUrl,arguments,features)
</script>


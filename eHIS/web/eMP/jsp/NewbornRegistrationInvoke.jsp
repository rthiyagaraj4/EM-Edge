<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<%
	request.setCharacterEncoding("UTF-8");
	String accessRights = request.getParameter("accessRights");
	if( accessRights == null) accessRights="";
	String parent_details = request.getParameter("parent_details");
	if( parent_details == null) parent_details="";
	parent_details = java.net.URLEncoder.encode(parent_details);
	String function_invoked = request.getParameter("function_invoked");
	if( function_invoked == null) function_invoked="";
	String mother_nursing_unit = request.getParameter("mother_nursing_unit")==null?"":request.getParameter("mother_nursing_unit");
	String calling_module_id = request.getParameter("calling_module_id")==null?"":request.getParameter("calling_module_id");
	String function_name 	= request.getParameter( "function_name" ) ;
	if ( function_name	== null ) function_name	= "" ;
	String mother_bed_no = request.getParameter("mother_bed_no")==null?"":request.getParameter("mother_bed_no");
	
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script  src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eMP/js/NewbornRegistration.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script language="JavaScript">
		async function create() {	

			
		 var patientid=await PatientSearchWithDefaultGender('F','N');
		 
		 if(patientid!=null){
			
			 self.location.href = '../../eMP/jsp/NewbornRegistrationFirst.jsp?patient_id='+patientid+'&accessRights=<%=accessRights%>&parent_details=<%=parent_details%>&function_invoked=<%=function_invoked%>&mother_nursing_unit=<%=mother_nursing_unit%>&mother_bed_no=<%=mother_bed_no%>&function_name=<%=function_name%>&calling_module_id=<%=calling_module_id%>';
		 }			 
		}
		function call_ip() {			
			self.location.href='../../eCommon/html/blank.html';
			parent.parent.frames[1].location.href='../../eMP/jsp/NewbornCurrentInpatients.jsp?accessRights=<%=accessRights%>&parent_details=<%=parent_details%>&function_invoked=<%=function_invoked%>&mother_nursing_unit=<%=mother_nursing_unit%>&mother_bed_no=<%=mother_bed_no%>&function_name=<%=function_name%>';			
		}

</script>
</head>

<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<script language="JavaScript">
				create(); 
	</script>




</body>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>


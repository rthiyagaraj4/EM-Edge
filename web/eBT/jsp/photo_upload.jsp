<!DOCTYPE html>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
	request.setCharacterEncoding("UTF-8");
	%>
<% 
String patient_id = request.getParameter("patient_id"); 
String photoCount = request.getParameter("photoCount");
String facility_id = request.getParameter("facility_id");
String user_id = request.getParameter("user_id");
String ws_no = request.getParameter("ws_no");

System.out.println(" ::: patient_id ::: "+patient_id+" ::: photoCount ::: "+photoCount+" ::: facility_id ::: "+facility_id+" ::: user_id ::: "+user_id+" ::: ws_no ::: "+ws_no);

String locale = request.getParameter("locale") == null ? "" : request.getParameter("locale");
String visit_id = "";
String jdbc_props = "";

System.out.println(" ::: Before Session Put Value ::: ");

session.putValue("LOCALE",locale);
session.putValue("facility_id",facility_id);
session.putValue("login_user",user_id);
session.putValue("connection_pooling_yn","Y");

System.out.println(" ::: After Session Put Value 1 ::: ");

Properties p = new Properties() ;
p.setProperty( "login_user",user_id) ;
p.setProperty("connection_pooling_yn","Y") ;
p.setProperty("client_ip_address",ws_no) ;
p.setProperty("jdbc_props",jdbc_props) ;
p.setProperty("LOCALE",locale) ;
session.putValue( "jdbc",p ) ;

System.out.println(" ::: After Session Put Value 2 ::: ");

%>
<HTML>
<HEAD>	
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<Script language='javascript' src='../../eMP/js/PatientRegistration.js'></Script>
	<Script language='javascript' src='../../eMP/js/PatientRegistration1.js'></Script>
	<Script language='javascript' src='../../eMP/js/PatientRegistration2.js'></Script>
	<script language="JavaScript" src="../../eBT/js/ViewPatDetails.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</HEAD>

<BODY onUnLoad='window.returnValue="close"' onKeyDown='lockKey()'>
<form name='photoUpload' id='photoUpload' action='../../servlet/eBT.PhotoUploadServlet' method='post' enctype='multipart/form-data'>
<table border=0 cellspacing=0 cellpadding=0 width='80%' align='center'>
<tr ><td class='label' width='50%%' colspan=2>&nbsp;</td></tr>
<tr ><td class='label' width='50%%' colspan=2>&nbsp;</td></tr>
<tr ><td class='label' width='50%%' colspan=2>&nbsp;</td></tr>
<tr ><td class='label' width='50%'>Blood Donor Photo</td><td class='fields'><input type="file" name="patFile" id="patFile" value=""  size=40 maxlength=40 onchange="" onkeypress="return onkeyPressEvent(event);"></td></tr>
<tr ><td class='label' width='50%' colspan=2>&nbsp;</td></tr>
<tr	><td class='label' width='50%%'></td><td width='25%'  class='button'><input type='button' name='uploadfile' id='uploadfile' value='Upload File' onclick='parent.uploadfile()' ></td></tr>
<tr ><td class='label' width='50%' colspan=2>&nbsp;</td></tr>
</table>
<input type="hidden" name="patient_id" id="patient_id" value='<%=patient_id%>'>
<input type="hidden" name="photoCount" id="photoCount" value='<%=photoCount%>'>
<input type="hidden" name="facility_id" id="facility_id" value='<%=facility_id%>'>
<input type="hidden" name="user_id" id="user_id" value='<%=user_id%>'>
<input type="hidden" name="ws_no" id="ws_no" value='<%=ws_no%>'>
</form>
</BODY>
</HTML>
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


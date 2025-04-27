<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,webbeans.eCommon.*,java.util.StringTokenizer,java.util.*,com.ehis.util.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
%>

<html>
<head>
	
<title>CapturePatientPhoto </title>
   	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<Script language='javascript' src='../../eMP/js/PatientRegistration.js'></Script>
	<Script language='javascript' src='../../eMP/js/PatientRegistration1.js'></Script>
	<Script language='javascript' src='../../eMP/js/PatientRegistration2.js'></Script>
	<script language="JavaScript" src="../../eBT/js/ViewPatDetails.js"></script>
</head>
<% 
String patient_id = request.getParameter("patient_id") == null ? "" :request.getParameter("patient_id");
String photoCount="0";
String facility_id = request.getParameter("facility_id") == null ? "" :request.getParameter("facility_id") ;
String user_id = request.getParameter("user_id")== null ? "" :request.getParameter("user_id");
String ws_no = request.getParameter("ws_no")== null ? "" :request.getParameter("ws_no");


//String direct_resp_id = request.getParameter("responsibility_id") == null ? "" : request.getParameter("responsibility_id");

//out.println("mode = "+mode);
String locale = request.getParameter("locale") == null ? "" : request.getParameter("locale");
String visit_id = "";
String jdbc_props = "";
session.putValue("LOCALE",locale);
//session.putValue("responsibility_id",direct_resp_id);
session.putValue("facility_id",facility_id);
session.putValue("login_user",user_id);
session.putValue("connection_pooling_yn","Y");

//System.out.println("entere here Photo_capture look up main 6");
Properties p = new Properties() ;
p.setProperty( "login_user",user_id) ;
p.setProperty("connection_pooling_yn","Y") ;
p.setProperty("client_ip_address",ws_no) ;
p.setProperty("jdbc_props",jdbc_props) ;
p.setProperty("LOCALE",locale) ;
session.putValue( "jdbc",p ) ;


System.out.println("entere here Photo_capture look up main 2");
Connection con = null;

PreparedStatement pstmt = null;
ResultSet rs=null;
try{

	System.out.println("entere here Photo_capture look up main 3");
	con = ConnectionManager.getConnection(request);
	pstmt = con.prepareStatement("select count(*) count from mp_ext_person_photo where PERSON_ID=?");
		System.out.println("entere here Photo_capture look up main 4");
	pstmt.setString(1, patient_id);
	rs = pstmt.executeQuery();
	if(rs!=null && rs.next())
		photoCount=rs.getString("count");
	if(rs!=null)rs.close();
	if(pstmt!=null)pstmt.close();
	
System.out.println("eBT Photo_capture_main.jsp "+photoCount);
}catch(Exception e){
	e.printStackTrace();
} finally {
	if (con != null)
	 ConnectionManager.returnConnection(con, request);
}
%>
<HEAD>
<title> <fmt:message key="eMP.CapturePatientPhoto.label" bundle="${mp_labels}"/></title>
</HEAD>
<body onKeyDown='lockKey()'>
<form name='patPhotoMain' id='patPhotoMain'>
<%if(photoCount!=null && photoCount.equals("0")){%>
<br>
<table cellspacing=0 cellpadding=4 width='70%' align='center' border=0 height='20%'>
    <tr>
        <td class='label' width='25%'>&nbsp;</td><td class='label' width='25%'>&nbsp;</td><td class='label' width='25%'>&nbsp;</td><td class='label' width='25%'>&nbsp;</td>
    </tr>
	<tr>		
		<td width='25%'  class='label' nowrap><fmt:message key="eMP.WebCam.label" bundle="${mp_labels}"/></td><td width='25%'  class='label'><input type='radio' name='cam' id='cam' value='C' onClick="select_cam(this)" checked></td>
		
		<td width='25%'  class='label' nowrap><fmt:message key="Common.UploadFile.label" bundle="${common_labels}"/></td><td width='25%'  class='label'><input type='radio' name='uplfile' id='uplfile' value='U' onClick="select_upload(this)"></td>
	</tr>
	<tr>		
		<td class='label' width='25%'>&nbsp;</td><td class='label' width='25%'>&nbsp;</td><td class='label' width='25%'>&nbsp;</td><td width='25%'  class='button' align='left'><input type='button' name='OK' id='OK' value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onclick='callsubmit()'><input type='button' name='CANCEL' id='CANCEL' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onclick='callcancle()'></td>
	</tr>
	<tr><td colspan='4'>&nbsp;</td></tr>
</table>
<%}else{%>
<table cellspacing=0 cellpadding=4 width='70%' align='center' border=0 height='20%'>
<tr rowspan='4'><td class='label' width='25%'>&nbsp;</td><td class='label' width='25%'>&nbsp;</td><td class='label' width='25%'>&nbsp;</td><td class='label' width='25%'>&nbsp;</td></tr>
<tr><td width='25%'  class='label' nowrap><fmt:message key="eMP.ChangePatientPhoto.label" bundle="${mp_labels}"/></td><td class='fields' nowrap><input type='checkbox' name='changephoto' id='changephoto' value='N' onclick='changephotofun(this)'></td><td class='label' width='25%'>&nbsp;</td><td class='label' width='25%'>&nbsp;</td></tr>
    <tr>
        <td class='label' width='25%'>&nbsp;</td><td class='label' width='25%'>&nbsp;</td><td class='label' width='25%'>&nbsp;</td><td class='label' width='25%'>&nbsp;</td>
    </tr>
	<tr>		
		<td width='25%' class='label' nowrap><fmt:message key="eMP.WebCam.label" bundle="${mp_labels}"/></td><td width='25%' class='label'><input type='radio' name='cam' id='cam' value='C' onClick="select_cam(this)" disabled checked></td>
		
		<td width='25%'  class='label' nowrap><fmt:message key="Common.UploadFile.label" bundle="${common_labels}"/></td><td width='25%'  class='label'><input type='radio' name='uplfile' id='uplfile' value='U' onClick="select_upload(this)" disabled></td>
	</tr>
	<tr>		
		<td class='label' width='25%'>&nbsp;</td><td class='label' width='25%'>&nbsp;</td><td class='label' width='25%'>&nbsp;</td><td width='25%'  class='button' align='left'><input type='button' name='OK' id='OK' value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onclick='callsubmit()' disabled><input type='button' name='CANCEL' id='CANCEL' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onclick='callcancle()'></td>
	</tr>
</table>
<%}%>
<input type="hidden" name="patient_id" id="patient_id" value='<%=patient_id%>'>
<input type="hidden" name="photoCount" id="photoCount" value='<%=photoCount%>'>
<input type="hidden" name="facility_id" id="facility_id" value='<%=facility_id%>'>
<input type="hidden" name="user_id" id="user_id" value='<%=user_id%>'>
<input type="hidden" name="ws_no" id="ws_no" value='<%=ws_no%>'>
</form>
</body>

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


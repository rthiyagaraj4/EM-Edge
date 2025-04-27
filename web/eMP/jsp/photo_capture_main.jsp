<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,webbeans.eCommon.*,java.util.StringTokenizer,java.util.*,com.ehis.util.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	//String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
	//System.out.println(" sStyle : "+sStyle);
%>

<html>
<head>
   	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<Script language='javascript' src='../../eMP/js/PatientRegistration.js'></Script>
	<Script language='javascript' src='../../eMP/js/PatientRegistration1.js'></Script>
	<Script language='javascript' src='../../eMP/js/PatientRegistration2.js'></Script>
	<script language="JavaScript" src="../../eMP/js/ViewPatDetails.js"></script>
</head>
<% 
String patient_id = request.getParameter("patient_id"); 
// Code added by Sethu for 64523	PMG2017-COMN-CRF-0005	Patient Photo capture in EM 
String patient_name = request.getParameter("patient_name");
String module_id = request.getParameter("module_id");

String facility_id = request.getParameter("facility_id") == null ? "" : request.getParameter("facility_id");
String user_id = request.getParameter("user_id") == null ? "" : request.getParameter("user_id");
String ws_no = request.getParameter("ws_no") == null ? "" : request.getParameter("ws_no");
String locale = request.getParameter("locale") == null ? "" : request.getParameter("locale");


System.out.println(" Patient ID : "+patient_id+" Patient Name : "+patient_name+" Module ID : "+module_id);
System.out.println(" facility_id : "+facility_id+" user_id : "+user_id+" ws_no : "+ws_no+" locale : "+locale);


String photoCount="0";
Connection con = null;
PreparedStatement pstmt = null;
ResultSet rs=null;
String pStatement = "";
try{

	con = ConnectionManager.getConnection();

	if (module_id.equals("BD")){
		pStatement = "select count(*) count from MP_EXT_PERSON_PHOTO where PERSON_ID=?";
	}
	else if (module_id.equals("MP")){
		pStatement = "select count(*) count from mp_patient_photo where PATIENT_ID=?";
	}

	pstmt = con.prepareStatement(pStatement);
	pstmt.setString(1, patient_id);
	rs = pstmt.executeQuery();
	if(rs!=null && rs.next())
		photoCount=rs.getString("count");
	if(rs!=null)rs.close();
	if(pstmt!=null)pstmt.close();
}catch(Exception e){
	e.printStackTrace();
} finally {
	if (con != null)
		ConnectionManager.returnConnection(con);
		
}		
%>
<HEAD>
<title> Capture Patient Photo	</title>
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
		<td width='25%'  class='label' nowrap>
		WebCam
		<td width='25%'  class='label'><input type='radio' name='cam' id='cam' value='C' onClick="select_cam(this)" checked></td>
		
		<td width='25%'  class='label' nowrap>
			Upload File
			<td width='25%'  class='label'><input type='radio' name='uplfile' id='uplfile' value='U' onClick="select_upload(this)"></td>
	</tr>
	<tr>		
		<td class='label' width='25%'>&nbsp;</td><td class='label' width='25%'>&nbsp;</td><td class='label' width='25%'>&nbsp;</td><td width='25%'  class='button' align='left' nowrap>
			<input type='button' name='OK' id='OK' value='OK' onclick='callsubmit()'> 
			<input type='button' name='CANCEL' id='CANCEL' value='Cancel' onclick='callcancle()'></td>
	</tr>
	<tr><td colspan='4'>&nbsp;</td></tr>
</table>
<%}else{%>
<table cellspacing=0 cellpadding=4 width='70%' align='center' border=0 height='20%'>
<tr rowspan='4'><td class='label' width='25%'>&nbsp;</td><td class='label' width='25%'>&nbsp;</td><td class='label' width='25%'>&nbsp;</td><td class='label' width='25%'>&nbsp;</td></tr>
<tr><td width='25%'  class='label' nowrap> Capture Patient Photo			
			<td class='fields' nowrap><input type='checkbox' name='changephoto' id='changephoto' value='N' onclick='changephotofun(this)'></td><td class='label' width='25%'>&nbsp;</td><td class='label' width='25%'>&nbsp;</td></tr>
    <tr>
        <td class='label' width='25%'>&nbsp;</td><td class='label' width='25%'>&nbsp;</td><td class='label' width='25%'>&nbsp;</td><td class='label' width='25%'>&nbsp;</td>
    </tr>
	<tr>		
		<td width='25%' class='label' nowrap>
				WebCam
				<td width='25%' class='label'><input type='radio' name='cam' id='cam' value='C' onClick="select_cam(this)" disabled checked></td>
		
		<td width='25%'  class='label' nowrap>
			Upload File
			<td width='25%'  class='label'><input type='radio' name='uplfile' id='uplfile' value='U' onClick="select_upload(this)" disabled></td>
	</tr>
	<tr>		
		<td class='label' width='25%'>&nbsp;</td><td class='label' width='25%'>&nbsp;</td><td class='label' width='25%'>&nbsp;</td><td width='25%'  class='button' align='left' nowrap>
			<input type='button' name='OK' id='OK' 	value='OK' onclick='callsubmit()' disabled>
			<input type='button' name='CANCEL' id='CANCEL' value='Cancel' onclick='callcancle()'></td>
	</tr>
</table>
<%}%>
<input type="hidden" name="patient_id" id="patient_id" value='<%=patient_id%>'>
<input type="hidden" name="photoCount" id="photoCount" value='<%=photoCount%>'>
<!-- Code added by Sethu for 64523	PMG2017-COMN-CRF-0005	Patient Photo capture in EM -->
<input type="hidden" name="patient_name" id="patient_name" value='<%=patient_name%>'>
<input type="hidden" name="module_id" id="module_id" value='<%=module_id%>'>
<input type="hidden" name="facility_id" id="facility_id" value='<%=facility_id%>'>
<input type="hidden" name="user_id" id="user_id" value='<%=user_id%>'>
<input type="hidden" name="ws_no" id="ws_no" value='<%=ws_no%>'>
<input type="hidden" name="locale" id="locale" value='<%=locale%>'>


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


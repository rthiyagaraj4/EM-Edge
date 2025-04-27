<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"%>
<html>
<head>
<title><fmt:message key="Common.Modify.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.deceaseddetails.label" bundle="${common_labels}"/></title>
<%String sStyle	=
    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eMR/js/CreatePatientFile.js'></script>	
	<script language='javascript' src='../../eMR/js/MRPractitionerComponent.js'></script>	
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>	
	<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String encounterid		=	checkForNull(request.getParameter("encounter_id"));
	//String call_from		=	checkForNull(request.getParameter("call_from"));
	//String patient_id		=	checkForNull(request.getParameter("patient_id"));
	String deceased_date	=	checkForNull(request.getParameter("deceased_date"));
	String discharge_date	=	checkForNull(request.getParameter("dischargeDate"));
	String adm_date			=	checkForNull(request.getParameter("admissionDate"));
	String admission_type	=	checkForNull(request.getParameter("admission_type"));
	String pract_id			=	checkForNull(request.getParameter("pract_id"));
	//String pract_name		=	checkForNull(request.getParameter("pract_name"));
	String remarks			=	checkForNull(request.getParameter("remarks"));
	String FacilityId		= (String) session.getValue( "facility_id" ) ;
	String locale			= (String) session.getAttribute("LOCALE");
	String pract_name		= "";
	PreparedStatement pstmt		= null;
	ResultSet rs				= null;
	Connection conn				= null;

	

	
	
	/*out.println("<script>alert(\"admission_type:"+admission_type+"\");</script>");
	out.println("<script>alert(\"auth_practitioner_name:"+pract_name+"\");</script>");
	out.println("<script>alert(\"remarks:"+remarks+"\");</script>");*/

	try
	{
		StringBuffer sqlBuffer = new StringBuffer();
		sqlBuffer.append("select AM_GET_DESC.AM_PRACTITIONER(auth_practitioner_id,'"+locale+"','2') auth_practitioner_name from mr_death_register_hdr  where facility_id=?   and  encounter_id=?   and auth_practitioner_id =? ");
		conn = ConnectionManager.getConnection(request);	
		pstmt=conn.prepareStatement(sqlBuffer.toString());
		pstmt.setString(1,FacilityId);
		pstmt.setString(2,encounterid);
		pstmt.setString(3,pract_id);

		rs = pstmt.executeQuery();

		if(rs!=null && rs.next())
		{
			pract_name	=	rs.getString("auth_practitioner_name");	
		}
	}
	catch(Exception e)
	{
		//out.println("Exception while getting practitioner in AddModifyDeceasedDetails.jsp :"+e.toString());
		e.printStackTrace();
	}
	finally
	{
		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();
		ConnectionManager.returnConnection(conn,request);
	}	

%>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name='ModifyDeceasedDateForm' id='ModifyDeceasedDateForm' >
	<table border='0' cellpadding='2' cellspacing='0' width='100%'>
	<tr>
		<td class='label' colspan='4'></td>
	</tr>
	<tr>
		<td class="COLUMNHEADER" colspan='4' ><fmt:message key="eMR.DeathRegistrationDetails.label" bundle="${mr_labels}"/></td>
	</tr>
	<tr>
		<td class='label' colspan='4' ></td>
	</tr>
	<tr>
		<td class='label' width='25%'><fmt:message key="Common.AdmissionDateTime.label" bundle="${common_labels}"/> </td>
		<td class='querydata' width='25%'><%=adm_date%></td>
		<td class='label' width='25%'><fmt:message key="Common.admissiontype.label" bundle="${common_labels}"/> </td>
		<td class='querydata' width='25%'><%=admission_type%></td>
	</tr>
	<tr>
		<td class='label' colspan='4'  ></td>
	</tr>
	<tr>
		<td class='label' width='25%'><fmt:message key="Common.deathdatetime.label" bundle="${common_labels}"/> </td>
		<td class='fields' width='25%'><input type='text' name='deceased_date_time' id='deceased_date_time' id='deceased_date_time_id' size='16' value='<%=deceased_date%>' onblur="checkDeceasedDate(this);"></input><img src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].deceased_date_time.focus(); return showCalendar('deceased_date_time_id' ,null,'hh:mm');"><input type='hidden' name='adm_date' id='adm_date' value='<%=adm_date%>'></input><input type='hidden' name='discharge_date' id='discharge_date' value='<%=discharge_date%>'></input><img   src='../../eCommon/images/mandatory.gif'  ></img></td>
		<td class='label' width='25%'><fmt:message key="eMR.AuthorisedPractitioner.label" bundle="${common_labels}"/> </td>
		<td class='fields' width='25%'><input type='text' name='auth_pract' id='auth_pract'  size='15' maxlength='30' value="<%=pract_name%>" onblur="if(this.value==''){document.forms[0].auth_pract_id.value='';};BeforeGetPractID1(document.forms[0].auth_pract_lookup,this);"><input type='hidden' name='auth_pract_id' id='auth_pract_id'  value='<%=pract_id%>'></input><input type='button' value='?' name='auth_pract_lookup' id='auth_pract_lookup' class='button' onClick="if(document.forms[0].auth_pract.value == '') getPractitioner(this,auth_pract,'','Q6');"></input><img   src='../../eCommon/images/mandatory.gif' ></img></td>
	</tr>
	<tr>
		<td class='label' colspan='4'  ></td>
	</tr>
	<tr>
		<td class='label' width='25%'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/> </td>
		<td class='fields' colspan='3'><textarea name="remarks"  rows="2" cols="50" maxlength='200'  onBlur="makeValidString(this);checkMaxLimitOfRemark(this);" ><%=remarks%></textarea></td>


	</tr>
	<tr>
		<td class='label' colspan='4'  ></td>
	</tr>
	<input type='hidden' name='encounter_id' id='encounter_id' value='<%=encounterid%>'>
	</table>	
</form>
</body>
</html>

<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>


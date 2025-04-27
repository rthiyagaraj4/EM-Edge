<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,java.net.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
 <%
    request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../js/EMail.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<%

String module_id="";
String report_id="";
String to_emailId="";
String cc_emailId="";
String p_file_name="";
String p_report_type="";
String AuthReqdYN="N";
Connection con=null;
PreparedStatement pstmt=null;
ResultSet rs=null;
module_id		=(request.getParameter("module_id")==null)?"":request.getParameter("module_id");
report_id		=(request.getParameter("report_id")==null)?"":request.getParameter("report_id");
p_file_name		=(request.getParameter("p_file_name")==null)?"":request.getParameter("p_file_name");
p_report_type		=(request.getParameter("p_report_type")==null)?"":request.getParameter("p_report_type");
AuthReqdYN		=(request.getParameter("AuthReqdYN")==null)?"N":request.getParameter("AuthReqdYN");
String beanKey = request.getParameter("beanKey") == null ? "" : request.getParameter("beanKey");
//out.println("<script>alert('"+beanKey+"');</script>");

String encounter_id = request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
String veryReqdYn = "";
String veryReqdRegdYn = "";
String veryReqdAdhocYn = "";
String password = "";
String email_to_pat_id_yn = "";
String email_to_regd_id_yn = "";
String email_to_any_id_yn = "";
String very_reqd_conf_result_yn = "N";
String patEMailId = "";
String disclaimerId = "";
String subjTxt = "";

String sqlStr = "SELECT  A.QRY_SOURCE_ID	qry_src_id,A.SUBJECT_TEXT			subj_txt,A.DISCLIMER_ID			discl_id,A.EMAIL_TO_PAT_ID_YN		email_to_pat_id ,A.EMAIL_TO_REGD_ID_YN		email_to_regd_id,A.EMAIL_TO_ANY_ID_YN		email_to_any_id,A.VERY_REQD_PAT_YN		very_reqd_pat_yn,A.VERY_REQD_REGD_ID_YN		very_reqd_regd_id_yn,A.VERY_REQD_ANY_ID_YN		very_reqd_any_id_yn,A.VERY_REQD_CONF_RESULT_YN	very_reqd_conf_result_yn,A.PAT_BODY_TEXT_REF		pat_body_text_ref,A.REGD_ID_BODY_TEXT_REF		regd_id_body_text_ref,A.ANY_ID_BODY_TEXT_REF	any_id_body_text_ref,B.REPORT_DESC rep_desc,C.MODULE_NAME FROM SM_REPORT_MAIL_INFO A, SM_REPORT B, SM_MODULE C WHERE A.MODULE_ID=? AND A.REPORT_ID=? AND B.MODULE_ID=A.MODULE_ID AND B.REPORT_ID=A.REPORT_ID AND C.MODULE_ID=A.MODULE_ID";

String sqlStrPatId = "select EMAIL_ID from mp_patient where patient_id=?";
%>
<body class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="EMailHdrForm" id="EMailHdrForm" action="../../servlet/eCA.EMailServlet" method="post" target="dummyEmailFrame">
<table border=0 cellspacing=0 cellpadding='3' width='100%' align=center>
<tr>
	<td colspan='2'>&nbsp;</td>
</tr>
<tr>
	<td class='label'><!-- <a href='#' onclick="getRegRecpts(this);" id="to"> --><fmt:message key="Common.to.label" bundle="${common_labels}"/><!-- </a> --></td>
	<td class='fields'>&nbsp;<input type="text" name="to_emailId" id="to_emailId" value="<%=to_emailId%>" size=30 maxlength=100 onBlur="return makeValidString(this)"  readonly
	><input type='button' class='button' value='?' onclick='getRegRecpts(this)' id='toLookup' style='display:none'><img src='../../eCommon/images/mandatory.gif'><input type="hidden" name="to_id" id="to_id" value=""><input type="hidden" name="to_name" id="to_name" value="">&nbsp;</td>
</tr>

<tr id = 'ccLabelId'>
	<td class=label ><!-- <a href="#" onclick="getRegRecpts(this)" id="cc"> --><fmt:message key="eCA.CC.label" bundle="${ca_labels}"/></td>
	<td class='fields' >&nbsp;<input type="text" name="cc_emailId" id="cc_emailId" value="<%=cc_emailId%>" size=30 maxlength=100  onBlur="return makeValidString(this)" readonly><input type='button' class='button' value='?' onclick='getRegRecpts(this)' id='ccLookup' style='display:none'><input type="hidden" name="cc_id" id="cc_id" value=""><input type="hidden" name="cc_name" id="cc_name" value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='javascript:clearDetails(document.forms[0].cc_emailId)'><fmt:message key="eCA.ClearMailId.label" bundle="${ca_labels}"/></a></td>
</tr>
<%
try
{
	con=ConnectionManager.getConnection(request);
	pstmt=con.prepareStatement(sqlStr);
	pstmt.setString(1,module_id);
	pstmt.setString(2,report_id);
	rs=pstmt.executeQuery();
	while(rs.next())
	{
		email_to_pat_id_yn = rs.getString("email_to_pat_id") == null ? "N" : rs.getString("email_to_pat_id");
		email_to_regd_id_yn = rs.getString("email_to_regd_id") == null ? "N" : rs.getString("email_to_regd_id");
		email_to_any_id_yn = rs.getString("email_to_any_id") == null ? "N" : rs.getString("email_to_any_id");
		veryReqdYn = rs.getString("very_reqd_pat_yn") == null ? "N" : rs.getString("very_reqd_pat_yn");
		veryReqdRegdYn = rs.getString("very_reqd_regd_id_yn") == null ? "N" : rs.getString("very_reqd_regd_id_yn");
		veryReqdAdhocYn = rs.getString("very_reqd_any_id_yn") == null ? "N" : rs.getString("very_reqd_any_id_yn");
		very_reqd_conf_result_yn = rs.getString("very_reqd_conf_result_yn") == null ? "N" : rs.getString("very_reqd_conf_result_yn");
		disclaimerId = rs.getString("discl_id") == null ? "" : rs.getString("discl_id");
		subjTxt = rs.getString("subj_txt") == null ? "" : rs.getString("subj_txt");
	}//end of while

	if(rs != null) rs.close();
	if(pstmt != null) pstmt.close();
	if (AuthReqdYN.equals("Y")&& very_reqd_conf_result_yn.equals("Y") )
	{
		veryReqdYn = "V";
		veryReqdRegdYn = "V";
		veryReqdAdhocYn = "V";
	}
	else
	{
		if(veryReqdYn.equals("Y")) veryReqdYn = "V";
		else veryReqdYn = "A";

		if(veryReqdRegdYn.equals("Y")) veryReqdRegdYn = "V";
		else veryReqdRegdYn = "A";

		if(veryReqdAdhocYn.equals("Y")) veryReqdAdhocYn = "V";
		else veryReqdAdhocYn = "A";
	}
	if(email_to_pat_id_yn.equals("N") && email_to_regd_id_yn.equals("N") && email_to_any_id_yn.equals("N"))
	{
		out.println("<script>alert(getMessage('MAILING_NOT_ALLOWED','CA'));parent.window.close();</script>");
	}
	else if(!email_to_pat_id_yn.equals("N") && email_to_regd_id_yn.equals("N") && email_to_any_id_yn.equals("N"))
	{
		pstmt=con.prepareStatement(sqlStrPatId);
		pstmt.setString(1,patient_id);
		rs=pstmt.executeQuery();
		while(rs.next())
		{
			patEMailId = rs.getString(1) == null ? "" : rs.getString(1);
		}		

		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();

		if(patEMailId.equals("") || patEMailId == null)
		{
			out.println("<script>alert(getMessage('PAT_EMAIL_ID_NOT_NULL','CA'));parent.window.close();</script>");
		}
		else
		{
			out.println("<script>");
			out.println("document.forms[0].to_emailId.value='"+patEMailId+"' ");
			out.println("document.forms[0].to_emailId.readOnly='readOnly' ");
			out.println("document.getElementById('ccLabelId').style.display = 'none';");
			out.println("document.getElementById('toLookup').style.display = 'none';");
			out.println("</script>");
			password = patient_id;
		}
	}
	else
	{
		out.println("<script>");
		out.println("document.getElementById('toLookup').style.display = 'inline';");
		out.println("document.getElementById('ccLookup').style.display = 'inline';");
		out.println("</script>");
	}
	%>

	<tr>
		<td class=label ><fmt:message key="eCA.Subject.label" bundle="${ca_labels}"/></td>
		<td class='fields' >&nbsp;<input type="text" name="subject" id="subject" value="<%=subjTxt%>" size=100 maxlength=100 onBlur="return makeValidString(this)" ></td>
	</tr>
	<tr>
		<td class=label colspan='2'><fmt:message key="eCA.BodyText.label" bundle="${ca_labels}"/></td>
	</tr>
	<input type="hidden" name="module_id" id="module_id" value="<%=module_id%>">
	<input type="hidden" name="report_id" id="report_id" value="<%=report_id%>">
	<input type="hidden" name="disclaimer" id="disclaimer" value="">
	<input type="hidden" name="p_report_type" id="p_report_type" value="<%=p_report_type%>">
	<input type="hidden" name="p_file_name" id="p_file_name" value="<%=p_file_name%>">
	<input type="hidden" name="beanKey" id="beanKey" value="<%=beanKey%>">
	<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
	<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
	<input type="hidden" name="email_to_pat_id_yn" id="email_to_pat_id_yn" value="<%=email_to_pat_id_yn%>">
	<input type="hidden" name="email_to_regd_id_yn" id="email_to_regd_id_yn" value="<%=email_to_regd_id_yn%>">
	<input type="hidden" name="email_to_any_id_yn" id="email_to_any_id_yn" value="<%=email_to_any_id_yn%>">
	<input type="hidden" name="disclaimerId" id="disclaimerId" value="<%=disclaimerId%>">
	<input type="hidden" name="mailToType" id="mailToType" value="P">
	<input type="hidden" name="veryReqdYn" id="veryReqdYn" value="<%=veryReqdYn%>">
	<input type="hidden" name="veryReqdRegdYn" id="veryReqdRegdYn" value="<%=veryReqdRegdYn%>">
	<input type="hidden" name="veryReqdAdhocYn" id="veryReqdAdhocYn" value="<%=veryReqdAdhocYn%>">
	<input type="hidden" name="password" id="password" value="<%=password%>">

	</table>
	</form>
	<script>
		if('<%=email_to_pat_id_yn%>' != 'N' && '<%=email_to_regd_id_yn%>' == 'N' && '<%=email_to_any_id_yn%>' == 'N' && '<%=patEMailId%>' != '')
			openEditor(document.EMailHdrForm)
	</script>
	</body>
<%}catch(Exception e){
	
	//out.println("@@@ Exception in EMailHdr.jsp="+e.toString());//COMMON-ICN-0181
	e.printStackTrace();
}finally{
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
	if(con!=null) ConnectionManager.returnConnection(con,request);
}%>
</html>


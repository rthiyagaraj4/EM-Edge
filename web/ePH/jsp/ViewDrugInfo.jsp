<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*,webbeans.eCommon.*,java.sql.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<HTML>
<HEAD>
<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String drug_information="",patient_education="",drug_desc="";
String DrugCode=request.getParameter("DrugCode");
       Connection conn = ConnectionManager.getConnection(request);
	   PreparedStatement pstmt =	null ;
	   ResultSet rset=null;
try
	{
	String sql = "select drug_desc,drug_information, patient_education from ph_drug_lang_vw where drug_code = ? and language_id = ?";
	pstmt				= conn.prepareStatement(sql) ;
	pstmt.setString(1,DrugCode);
	pstmt.setString(2,locale);
	rset	= pstmt.executeQuery();
	rset.next();
	drug_desc=(rset.getString("drug_desc")==null)?"":rset.getString("drug_desc");
	drug_information=(rset.getString("drug_information")==null)?"":rset.getString("drug_information");
	patient_education=(rset.getString("patient_education")==null)?"":rset.getString("patient_education");
	if(rset!=null) 	rset.close();
	if(pstmt!=null) 	pstmt.close();
	}catch(Exception e){
	e.toString();
	}
	finally{
		ConnectionManager.returnConnection(conn,request);
	}
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	 <script language="javascript" src="../../eCommon/js/ValidateControl.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	 <title><%=drug_desc%></title>
</HEAD>

<style>
textarea {
  resize: none;
}
</style>
<!-- <BODY > -->
<body onMouseDown="" onKeyDown="lockKey()">
<FORM name="ViewDrugInfoForm" id="ViewDrugInfoForm">
<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0">
 <tr>
			<td class="label"><fmt:message key="ePH.DrugInformation.label" bundle="${ph_labels}"/></td>
			<td>&nbsp;&nbsp;<textarea name="long_desc" id="long_desc"  rows='10' cols='80' readonly ><%=drug_information%></textarea>&nbsp;</td>
  </tr>
  <tr>
   <td class="label"><fmt:message key="ePH.PatientEducation.label" bundle="${ph_labels}"/></td>
   <td>&nbsp;&nbsp;<textarea name="long_desc" id="long_desc" rows='10' cols='80'readonly><%=patient_education%></textarea>&nbsp;</td>
   </tr>
   <tr>
   <td class="label"></td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td class="label"></td>
			<td>&nbsp;</td>
		</tr>
</TABLE>
</FORM>
</BODY>
</HTML>


<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- TerminologyCodeForCaseTypeHeader.jsp -->
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:	
*	Created By		:	Suchilagna panigrahi
*	Created On		:	22 Jan 2005

--%>
<%-- JSP Page specific attributes start --%>
<%@page  import=" eCP.*, eCommon.Common.*,com.ehis.eslp.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*, java.lang.*,webbeans.eCommon.*,eOR.Common.*" %>
<jsp:useBean id="TermCodeForCaseType" class="webbeans.eCommon.RecordSet" scope="session"/>

<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<html>
<head>
<%
//This file is saved on 18/10/2005.
	  request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	  String locale=(String)session.getAttribute("LOCALE");
	String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
      	<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
      	<script language='javascript' src='../../eCommon/js/common.js' ></script>
	    <script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
		<script language="JavaScript" src="../../eCP/js/TerminologyCodeForCaseType.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
TermCodeForCaseType.clearAll();
String case_type_code=request.getParameter("case_type_code")== null ? "":request.getParameter("case_type_code");
String diag_spec_yn="";
String proc_spec_yn="";
String TerminologySet_sql="";
Vector TerminologySet_list=new Vector();

Connection conn=null;
Statement TerminologySet_stmt=null;
ResultSet TerminologySet_rs=null;

try
{
conn=ConnectionManager.getConnection();

TerminologySet_sql="SELECT term_Set_id,term_set_desc,diag_spec_yn,proc_spec_yn FROM mr_term_set WHERE eff_status = 'E' ORDER BY term_set_desc ";

TerminologySet_stmt=conn.createStatement();
TerminologySet_rs=TerminologySet_stmt.executeQuery(TerminologySet_sql);
while(TerminologySet_rs.next())
	{
		TerminologySet_list.add(TerminologySet_rs.getString("term_Set_id"));
		TerminologySet_list.add(TerminologySet_rs.getString("term_set_desc"));
		diag_spec_yn=TerminologySet_rs.getString("diag_spec_yn");
		proc_spec_yn=TerminologySet_rs.getString("proc_spec_yn");
	}
}catch(Exception e)
{
	e.printStackTrace();
	throw e;
}
finally
{
	if(TerminologySet_rs!=null) TerminologySet_rs.close();
	if(TerminologySet_stmt!=null) TerminologySet_stmt.close();
	if(conn!=null) ConnectionManager.returnConnection(conn,request);
}%>
<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
		<form name=form_TerminologyCodeForCaseType>
		<table border='0' cellspacing='5' cellpadding='0' align='center' width='100%'>
			<tr>
				<td align='center' width="25%" class='label'><fmt:message key="eCP.CaseType.label" bundle="${cp_labels}"/></td>
				<td><input type=text name="short_desc" id="short_desc" value=""  readonly><input class='button' type=button name="case_type_button" id="case_type_button" value="?"  onClick='selectNature(short_desc);displayNature(req_nature);'>&nbsp;<img src='../../eCommon/images/mandatory.gif'align='center'></img>
					<input type="hidden" name="case_type_nature" id="case_type_nature" value="" >	
					<input type="hidden" name="case_type_code" id="case_type_code" value="<%=case_type_code%>">
				    
				</td>
				<td></td>
			  </tr>
			 <tr>
			 <td width="25%"  align='center' class='label'><fmt:message key="eCP.CaseTypeNature.label" bundle="${cp_labels}"/></td>
			 <td id='req_nature' class='label' style='font-weight: bolder;'></td>
			 <td></td>
			 </tr>
			 <tr><td></td><td></td><td></td></tr>
			 <tr><td></td><td></td><td></td></tr>
			 <tr>
			 <td width="25%"  align='center' class='label'><fmt:message key="Common.TerminologySet.label" bundle="${common_labels}"/></td>
			 <td><select name='term_set_id' id='term_set_id' onchange='clearDetail();'>
						<option value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
						<%for(int i=0;i<TerminologySet_list.size();i+=2){%>
							<option value=<%=TerminologySet_list.get(i)%>><%=TerminologySet_list.get(i+1)%></option>
							<%}%>
					</select>&nbsp;<img src='../../eCommon/images/mandatory.gif'align='center'></img>
				</td>
				<td></td>
				</tr>
			<tr>
			<td width="25%"  align='center' class='label'><fmt:message key="Common.TerminologyCodeDescription.label" bundle="${common_labels}"/></td>
			<td><input type='text' name='term_code_desc' id='term_code_desc' value='' size='50' maxlength='100' onchange='clearDetail();'></td>
			<td>&nbsp;<select name='search_criteria' id='search_criteria' onchange='clearDetail();'>
								<option value='S'><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></option>
								<option value='C'><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option>
								<option value='E'><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></option>
							</select>
			</td>
			
			</tr>
			<tr>&nbsp;
				 <td width="25%"  align='center' class='label'><fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
				<td>
				<select name='wellness_yn' id='wellness_yn' onchange='clearDetail();'>
				<%if(diag_spec_yn.equals("Y") && proc_spec_yn.equals("Y")){%>
						<option value='DX' selected><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/></option>
						<option value='PR'><fmt:message key="Common.Procedure.label" bundle="${common_labels}"/></option>
						
				<%}
				else if(diag_spec_yn.equals("Y") && proc_spec_yn.equals("N")){%>
						<option value='DX'><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/></option>
				<%}
				else if(diag_spec_yn.equals("N") && proc_spec_yn.equals("Y")){%>
						<option value='PR'><fmt:message key="Common.Procedure.label" bundle="${common_labels}"/></option>
					<%}
				else{%>
						<option value=''>-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
					<%}%>
					</select>
				<td></td>	
					</tr>
					<tr>
						<td></td>
					<td></td>
				<td><input class='button' type=button name="search_button" id="search_button" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>'  onClick='searchDetails()'></td>
			 </tr>
		 </table>
	 <input type="hidden" name="AchkAll" id="AchkAll" value="">
	 <input type="hidden" name="BchkAll" id="BchkAll" value="">
	 <input type="hidden" name="CchkAll" id="CchkAll" value="">
	 <input type="hidden" name="DchkAll" id="DchkAll" value="">
	 <input type="hidden" name="EchkAll" id="EchkAll" value="">
	 <input type="hidden" name="FchkAll" id="FchkAll" value="">
	 <input type="hidden" name="GchkAll" id="GchkAll" value="">
	 <input type="hidden" name="HchkAll" id="HchkAll" value="">
	 <input type="hidden" name="IchkAll" id="IchkAll" value="">
	 <input type="hidden" name="JchkAll" id="JchkAll" value="">
	 <input type="hidden" name="KchkAll" id="KchkAll" value="">
	 <input type="hidden" name="LchkAll" id="LchkAll" value="">
	 <input type="hidden" name="MchkAll" id="MchkAll" value="">
	 <input type="hidden" name="NchkAll" id="NchkAll" value="">
	 <input type="hidden" name="OchkAll" id="OchkAll" value="">
	 <input type="hidden" name="PchkAll" id="PchkAll" value="">
	 <input type="hidden" name="QchkAll" id="QchkAll" value="">
	 <input type="hidden" name="RchkAll" id="RchkAll" value="">
	 <input type="hidden" name="SchkAll" id="SchkAll" value="">
	 <input type="hidden" name="TchkAll" id="TchkAll" value="">
	 <input type="hidden" name="UchkAll" id="UchkAll" value="">
	 <input type="hidden" name="VchkAll" id="VchkAll" value="">
	 <input type="hidden" name="WchkAll" id="WchkAll" value="">
	 <input type="hidden" name="XchkAll" id="XchkAll" value="">
	 <input type="hidden" name="YchkAll" id="YchkAll" value="">
	 <input type="hidden" name="ZchkAll" id="ZchkAll" value="">
	 <input type="hidden" name="_chkAll" id="_chkAll" value="">
	 <input type="hidden" name="AssociatedchkAll" id="AssociatedchkAll" value="Y">
	 <input type="hidden" name="locale" id="locale" value="<%=locale%>">
  </form>
 </body>
</html>


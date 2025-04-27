<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*,eCommon.Common.*,ePH.Common.*,eCommon.XSSRequestWrapper" %>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- Mandatory declarations end --%>
<html>
<head>
<%
	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
     <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	 <script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	 <script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	 <script language="JavaScript" src="../../ePH/js/TPNConsLimits.js"></script>
	 <script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
<%  request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends

    String	bean_id				= "TPNConsLimitsBean" ;
	String	bean_name			= "ePH.TPNConsLimitsBean";
	TPNConsLimitsBean bean		= (TPNConsLimitsBean)getBeanObject( bean_id, bean_name, request);
	
	String row_no		= request.getParameter("row_no");
	String name         =request.getParameter("name");
	String agegroup		= request.getParameter("agegroup");
	String regimen_code         =request.getParameter("regimen_code");
	String remarks   ="";
	String remarks1=request.getParameter("remarks");
	//remarks1 = java.net.URLDecoder.decode(remarks1,"UTF-8");
	   
	//remarks1=(String)bean.getRemarks(row_no); 
 if(remarks1==null)
	remarks1="";
%>
     
</head>
<title><%=name%>  <fmt:message key="Common.remarks.label" bundle="${common_labels}"/></title>


<body style="background-color:#E2E3F0;" OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">

<form name="TpnConsLimitsRemarks" id="TpnConsLimitsRemarks" >
<table width='100%' border='0' cellspacing='0' cellpadding='0' align='center'>
	<tr>
		<td align='left' class='label' width='10%'></td>
	</tr>
	<tr>
		<td align='left' width='90%' class='label'>&nbsp;&nbsp;<textarea name="tpncons_remarks" id="tpncons_remarks" rows="5" cols="60" onBlur="makeValidString(this)"><%=remarks1%></textarea></td>
		
	</tr>
	<TR>
		<td class='label'>
			<center><input type='Button' class='Button' name='Ok' id='Ok' value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onclick="saveRemarksForDrug('<%=row_no%>');doAmendClose();"></center>
		</TD>
	</TR>
</table>
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<INPUT TYPE="hidden" name="agegroup" id="agegroup" VALUE="<%= agegroup %>">
<INPUT TYPE="hidden" name="regimen_code" id="regimen_code" VALUE="<%= regimen_code %>">

</body>

</html>
	
<% 
 //remarks1="";
//putObjectInBean(bean_id,bean,request);
%>


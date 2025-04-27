<!DOCTYPE html>
  <%-- saved on 27/10/2005 --%>
<!--
Developed by	: P.Sudhakaran.
Module/Function : Generic Name for Service View Details (Master)
-->
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import="ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- Mandatory declarations end --%>
<html>
<head>
<%
    request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../js/PhCommon.js"></script>
	<script language="JavaScript" src="../js/GenericNameForService.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<!-- <body > -->
<body onMouseDown="" onKeyDown="lockKey()">
<%
	ArrayList lookUpResult=new ArrayList();
	String generic_id = request.getParameter("generic_id") ;
	String bean_id		= "genericnameforservice" ;
	String bean_name	= "ePH.GenericNameforServiceBean";
	GenericNameforServiceBean bean = (GenericNameforServiceBean)getBeanObject( bean_id,  bean_name , request) ;
	    bean.setLanguageId(locale);

	lookUpResult=bean.lookUpResult(generic_id,locale);
	int count=0;

	if(lookUpResult.size()>0){
	%>
		<table border="0" cellpadding="0" cellspacing="0" width="100%" align="center">
	<%
		for(int i=0;i<lookUpResult.size();i++){
			HashMap records=new HashMap();
			records=(HashMap) lookUpResult.get(i);
			if(count==0){
	%>
		<table border="0" cellpadding="0" cellspacing="0" width="100%" align="center">
		<th width="20%"><%=(String) records.get("GENERIC_NAME")%></th><th><%=(String) records.get("DRUG_CLASS")%></th>
		</table>
		<%
			}
		%>
		<table border="0" cellpadding="0" cellspacing="0" width="100%" align="center">
		<%
		if((String) records.get("ATC_CLASS_LEV1_DESC") !=null ){
		%>
			<tr>
				<td width="20%"><font size="1" ><b><fmt:message key="ePH.AnatomicalClass.label" bundle="${ph_labels}"/></b></font></td>
				<td wrap><font size="1"><%=(String) records.get("ATC_CLASS_LEV1_DESC")%></font></td>
			</tr>
		<%}
		if((String) records.get("ATC_CLASS_LEV2_DESC") !=null ){
		%>
			<tr>
				<td><font size="1" ><b><fmt:message key="ePH.TherapeuticClass.label" bundle="${ph_labels}"/>(<fmt:message key="ePH.MainClass.label" bundle="${ph_labels}"/>)</b></font></td>
				<td wrap><font size="1"><%=(String) records.get("ATC_CLASS_LEV2_DESC")%></font></td>
			</tr>
		<%
		}
		if((String) records.get("ATC_CLASS_LEV3_DESC") !=null ){
		%>
			<tr>
				<td><font size="1"><b><fmt:message key="ePH.TherapeuticClass.label" bundle="${ph_labels}"/>(<fmt:message key="Common.SubClass.label" bundle="${common_labels}"/>)</b></font></td>
				<td wrap><font size="1"><%=(String) records.get("ATC_CLASS_LEV3_DESC")%></font></td>
			</tr>
		<%
		}
		if((String) records.get("ATC_CLASS_LEV4_DESC") !=null ){
		%>
			<tr>
				<td><font size="1"><b><fmt:message key="ePH.ChemicalClass.label" bundle="${ph_labels}"/>(<fmt:message key="ePH.MainClass.label" bundle="${ph_labels}"/>)</b></font></td>
				<td wrap><font size="1"><%=(String) records.get("ATC_CLASS_LEV4_DESC")%></font></td>
			</tr>
		<%
		}
		if((String) records.get("ATC_CLASS_LEV5_DESC") !=null ){
		%>
			<tr>
				<td><font size="1"><b><fmt:message key="ePH.ChemicalClass.label" bundle="${ph_labels}"/>(<fmt:message key="Common.SubClass.label" bundle="${common_labels}"/>)</b></font></td>
				<td wrap><font size="1"><%=(String) records.get("ATC_CLASS_LEV5_DESC")%></font></td>
			</tr>
		<%
		}
		%>
			<tr><td colspan='2' class='white'></td></tr><tr><td colspan='2' class='white'></td></tr><tr><td colspan='2' class='white'></td></tr><tr><td colspan='2' class='white'></td></tr>
		</table>
		<%
		count++;
	}
	%>
	</table>
	<%
	}else{
	%>
		<script>
			alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
			parent.window.close();
		</script>
	<%
	}
%>

</body>
</html>

<%
putObjectInBean(bean_id,bean,request);
%>


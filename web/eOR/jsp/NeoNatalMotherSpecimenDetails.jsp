<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------

07/09/2023	  31792	   Ranjith P R		08/09/2023		RAMESH G		ML-MMOH-CRF-1913
--------------------------------------------------------------------------------------------------------------------
*/ 
%>


<!-- 31792 starts -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eOR.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<% request.setCharacterEncoding("UTF-8");
String sStyle =    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../js/ExistingOrder.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>NeoNatal-Mother's Specimen Details</title>
</head>
<body>
<%
request.setCharacterEncoding("UTF-8");    
Properties p;
session = request.getSession(false);
p = (java.util.Properties) session.getValue( "jdbc" ) ;
String locale = (String) p.getProperty("LOCALE");
System.out.println("-------locale------>"+locale);
String mode       = request.getParameter( "mode" ) ;
String bean_id = "Or_NeoNatalMotherSpecimenBean" ;
String bean_name = "eOR.NeoNatalMotherSpecimenBean";
NeoNatalMotherSpecimenBean bean = (NeoNatalMotherSpecimenBean)getBeanObject( bean_id, bean_name , request) ; 
String p_order_id	= request.getParameter("p_order_id");
String p_order_line_num	= request.getParameter("p_order_line_num");
String order_category	= request.getParameter("order_category")==null?"":(String)request.getParameter("order_category");
String p_performing_facility_id	= request.getParameter("p_performing_facility_id");
String accession_num	= request.getParameter("accession_num");
String history_type	= request.getParameter("history_type");
String specimen_num	= request.getParameter("specimen_num");
String patient_id	= request.getParameter("patient_id");
String patient_name	= request.getParameter("patient_name");
String lv_mother_spec_no	= request.getParameter("lv_mother_spec_no");
String p_blood_group	= request.getParameter("p_blood_group");


if(accession_num.indexOf("#")!=-1){
	//history_type	="LBIN";
	specimen_num = accession_num.substring(accession_num.indexOf("#")+1,accession_num.lastIndexOf("@"));
	p_performing_facility_id = accession_num.substring(accession_num.indexOf("F")+1,3);
}
System.out.println("------p_performing_facility_id--------->"+p_performing_facility_id);
ArrayList searchData = new ArrayList();		
searchData = bean.NeoNatalMotherSpecimenDetails(p,p_order_id,p_order_line_num,order_category,p_performing_facility_id,accession_num,history_type,specimen_num);//IN071596
%>
<table width='100%'>
<tr>
<td class=label width='15%'><fmt:message key="Common.SpecimenNo.label" bundle="${common_labels}"/></td>
<td class='fields' width='85%' colspan="3"><input type="text" name="SpecimenNo" id="SpecimenNo" value="<%=searchData.get(3)%>" size='20' maxLength='20' readonly></td>
</tr>
<tr>
<td class=label width='15%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
<td class='fields' width='25%'><input type="text" name="patientId" id="patientId" value="<%=searchData.get(4)%>" size='20' maxLength='20' disabled></td>

<td class=label width='20%'><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
<td class='fields'width='40%'><input type="text" name="patientName" id="patientName" value="<%=searchData.get(2)%>" size='40' maxLength='40' disabled></td>
</tr>
<tr>
<td colspan=4>
<b>Blood Type Details</b>
</td>
</tr>
<tr>
<td class=label ><fmt:message key="Common.bloodgroup.label" bundle="${common_labels}"/></td>
<td class='fields' ><input type="text" name="Bloodgroup" id="Bloodgroup" value="<%=searchData.get(0)%>" size='20' maxLength='20' readonly ></td>

<td class=label ><fmt:message key="Common.RhesusCode.label" bundle="${common_labels}"/></td>
<td class='fields'><input type="text" name="RhesusCode" id="RhesusCode" value="<%=searchData.get(1)%>" size='20' maxLength='20' readonly></td>
</tr>

<tr>
<td colspan="4" align="right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="button" value="Mother's Antibodies" onclick="MotherAntibodiesDetails('<%=searchData.get(4) %>','<%=locale%>','<%=p_order_id %>')">
<%System.out.println("p_order_id======83==button===>"+p_order_id);%>
<input type="button" name="btnClose" id="btnClose" value="Close" class="button" onClick="window.close()">            
</td>
</tr>

</table>
<input type="hidden" name="order_id" id="order_id" value="<%=p_order_id%>">


</body>
</html>
<%
putObjectInBean(bean_id,bean,request); 
%>
<!-- 31792 ends -->


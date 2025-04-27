<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------

07/09/2023	  24094	   Ranjith P R		08/09/2023		RAMESH G		ML-MMOH-CRF-1913
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
String locale    = (String)session.getAttribute("LOCALE");
String sStyle =    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../js/ExistingOrder.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%
Properties p;
session = request.getSession(false);
p = (java.util.Properties) session.getValue( "jdbc" ) ;
String mode       = request.getParameter( "mode" ) ;
String bean_id = "Or_NeoNatalMotherSpecimenBean" ;
String bean_name = "eOR.NeoNatalMotherSpecimenBean";
NeoNatalMotherSpecimenBean bean = (NeoNatalMotherSpecimenBean)getBeanObject( bean_id, bean_name , request) ; 

String patient_id	= request.getParameter("patient_id");
System.out.println("patient_id-----29---->"+patient_id);//rpr
String language_id	= request.getParameter("language_id");
System.out.println("language_id-----31---->"+language_id);//rpr
String p_order_id	= request.getParameter("order_id");
System.out.println("p_order_id-----33---->"+p_order_id);//rpr
String slClassValue = "gridData";

ArrayList searchData = new ArrayList();		
searchData = bean.GetMotherAntibodyDetails(p,patient_id,language_id,p_order_id);



%>
<title>Mother Antibody Details</title>
</head>
<body>	
	<table cellpadding=3 cellspacing=0 width="100%" height='' id="tableresult" class="grid">
		<tr>
			<td colspan=2>
				<table class='grid' width='100%'>
					<tr>
					<td class='columnheader' width=''><fmt:message key="Common.AntibodyCode.label" bundle="${common_labels}"/></td>
					<td class='columnheader' width=''><fmt:message key="Common.AntibodyDescription.label" bundle="${common_labels}"/></td>
					<td class='columnheader' width=''><fmt:message key="Common.ResultDateandTime.label" bundle="${common_labels}" /></td>
					</tr>
					<%
					for(int i=0; i<searchData.size(); i++){
						HashMap<String, String> RecordDetails = (HashMap<String, String>)searchData.get(i);
					%>
						 
							<td style="text-align: left" class='<%=slClassValue %>'><%=RecordDetails.get("ANTIBODY_CODE")%></td>
							<td style="text-align: left" class='<%=slClassValue %>'><%=RecordDetails.get("SHORT_DESC")%></td>
							<td style="text-align: left" class='<%=slClassValue %>'><%=RecordDetails.get("RESULT_DATE")%></td>
						 <%} %>
				</table>
			</td>
		</tr>
		<tr>
			<td align="right">
				<input type="button" name="btnClose" id="btnClose" value="Close" class="button" onClick="window.close()"> 
			</td>
		</tr>
	</table>	
</body>
</html>
<%
putObjectInBean(bean_id,bean,request); 
%>
<!-- 31792 ends -->


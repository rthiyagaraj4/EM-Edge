<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
20/08/2013	  IN038797	   Karthi L		To include the field (Filter) of "Speciality" in the function of "Pending Consent" in Practitioner's homepage
21/10/2015	IN057196		Ramesh G		Recording Of Consent Form
---------------------------------------------------------------------------------------------------------------
-->

<%@page contentType="text/html; charset=UTF-8"%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<jsp:useBean id="bean" scope="page" class="eOR.ConsentOrders"/>
<%-- Mandatory declarations end --%>

<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../js/ConsentOrder.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body   onload='FocusFirstElement()'  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	
	//String readOnly = "" ;
	//String checked = "checked" ;
	/* Mandatory checks start */
	//String mode	   = request.getParameter( "mode" ) ;
	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_ConsentOrders" ;
	String bean_name = "eOR.ConsentOrders";
	//String disabled = "" ;
	/* Mandatory checks end */


//	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	String practitioner_id = (String)session.getValue("ca_practitioner_id");
	String facility_id = (String)session.getValue("facility_id");
	String resp_id = (String)session.getValue("responsibility_id");
	if(resp_id== null)resp_id = "";
	String source_type		= request.getParameter( "source_type" ) ;
	String source_code		= request.getParameter( "source_code" ) ;
	String patientId		= request.getParameter("patientId");
	String period_from		= request.getParameter("period_from");
	String period_to		= request.getParameter("period_to");
	String consentRec_order_id		= request.getParameter("consentRec_order_id")== null?"":request.getParameter("consentRec_order_id");; //IN057196
	String speciality_code  = request.getParameter( "speciality_code" )== null?"":request.getParameter( "speciality_code" ); //added for BRU-HIMS-CRF-359 [IN038797]
	if(source_type == null || source_type.equals("null")) source_type =" "; else source_type = source_type.trim();
	if(source_code == null || source_code.equals("null")) source_code =" "; else source_code = source_code.trim();
	if(patientId == null || patientId.equals("null")) patientId =" "; else patientId = patientId.trim();
	if(period_from == null || period_from.equals("null")) period_from =" "; else period_from = period_from.trim();
	if(period_to == null || period_to.equals("null")) period_to =" "; else period_to = period_to.trim();

	Properties properties			= (Properties) session.getValue( "jdbc" );
	/*out.println("<script>alert('source_type="+source_type+"')</script>");
	out.println("<script>alert('source_code="+source_code+"')</script>");
	out.println("<script>alert('patientId="+patientId+"')</script>");
	out.println("<script>alert('period_from="+period_from+"')</script>");
	out.println("<script>alert('period_to="+period_to+"')</script>");*/


//	ConsentOrders bean = (ConsentOrders)getBeanObject( bean_id,  bean_name, request ) ;

	String slClassValue = "";
	int total = 0;

	bean.setLanguageId(localeName);
	//ArrayList PriorityData = bean.getStatusByPriority(properties, facility_id,source_type,source_code,practitioner_id,patientId,period_from,period_to) ; //commented for BRU-HIMS-CRF-359 [IN038797]
	//ArrayList CategoryData =  bean.getStatusByCategory(properties, facility_id,source_type,source_code,practitioner_id,patientId,period_from,period_to) ; //commented for BRU-HIMS-CRF-359 [IN038797]
	//IN057196 Start.
	//ArrayList PriorityData = bean.getStatusByPriority(properties, facility_id,source_type,source_code,practitioner_id,patientId,period_from,period_to, speciality_code) ; //modified for BRU-HIMS-CRF-359 [IN038797]
	//ArrayList CategoryData =  bean.getStatusByCategory(properties, facility_id,source_type,source_code,practitioner_id,patientId,period_from,period_to, speciality_code) ; //modified for BRU-HIMS-CRF-359 [IN038797]
	
	ArrayList PriorityData = bean.getStatusByPriority(properties, facility_id,source_type,source_code,practitioner_id,patientId,period_from,period_to, speciality_code,consentRec_order_id) ; //modified for BRU-HIMS-CRF-359 [IN038797]
	ArrayList CategoryData =  bean.getStatusByCategory(properties, facility_id,source_type,source_code,practitioner_id,patientId,period_from,period_to, speciality_code,consentRec_order_id) ; //modified for BRU-HIMS-CRF-359 [IN038797]		
	//IN057196 End.		
	//out.println(bean.chk);
	//out.println(PriorityData.size());

%>
<form name='consent_order_priority' id='consent_order_priority' target='messageFrame' >
<table cellpadding=3 cellspacing=0 border=1 width="100%" align=center class="grid">
	<tr>
		<td class=COLUMNHEADER><fmt:message key="eOR.StatusByPriority.label" bundle="${or_labels}"/></td>
	</tr>

		<%
		//out.println("<script>alert('PriorityData.size="+PriorityData.size()+"')</script>");
			for( int i=0 ; i< PriorityData.size() ; i++ ) {
				String[] record = (String[])PriorityData.get(i);
				int len=record[0].length();
				String subrec=record[0].substring(1,len);
				String temp=record[0];
				//String retval=new String();
				
				//System.out.println("====="+subrec);
				if(record[0].charAt(0)=='R'){
					record[0]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels").concat(subrec);
					//record[2]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
					
				}
					else if(record[0].charAt(0)=='U')
				{
					
					record[0]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels").concat(subrec);
					//record[2]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels");
					

				}
					else if(record[0].charAt(0)=='S')
				{
					
					record[0]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stat.label","common_labels").concat(subrec);
					//record[2]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Stat.label","or_labels");
				}
				/*if(i % 2 == 0){
					slClassValue = "QRYEVEN";
				}else{
					slClassValue = "QRYODD";
				}*/
				slClassValue="gridData";
				total =total+ Integer.parseInt(record[1]);
			//	record[0]=record[0]+" <b>("+ Integer.parseInt(record[1])+")</b>";
				/*System.out.println("####PriorityData#####");
				System.out.println("PriorityData.size="+ PriorityData.size());
				System.out.println("record[0]="+record[0]);
				System.out.println("record[1]="+record[1]);
				System.out.println("record[2]="+record[2]);
				System.out.println("record[3]="+record[3]);*/
		
		//String temp1="";
		%>
		
				<!--<script>alert("in record[0] =="+"<%=record[0]%>");</script>-->
				<!--  additional parameter "speciality_code" added in the below url for BRU-HIMS-CRF-359 [IN038797] -->
				<tr><td class='<%=slClassValue%>'><font size=1><a class='gridLink' href='ConsentOrdersBottomRight.jsp?priority=<%=temp%>&priority_desc=<%=record[0]%>&total_recs=<%=record[1]%>&source_code=<%=source_code%>&source_type=<%=source_type%>&patientId=<%=patientId%>&period_from=<%=period_from%>&period_to=<%=period_to%>&speciality_code=<%=speciality_code%>&consentRec_order_id=<%=consentRec_order_id %>' target='ConsentOrdersBottomRight'><%=record[0]%></a> <b>(<%=Integer.parseInt(record[1])%>)</b></font></td></tr>

		<%
			}	
		%>
		<%if(total !=0){%>
			<tr><td class='cagroup' bgcolor="#D5E2E5">
			<!--  additional parameter "speciality_code" added in the below url for BRU-HIMS-CRF-359 [IN038797] -->
			<a class='gridLink'  href='ConsentOrdersBottomRight.jsp?order_by=P&total_recs=<%=total%>&patientId=<%=patientId%>&source_code=<%=source_code%>&source_type=<%=source_type%>&period_from=<%=period_from%>&period_to=<%=period_to%>&speciality_code=<%=speciality_code%>&consentRec_order_id=<%=consentRec_order_id %>' target='ConsentOrdersBottomRight'><fmt:message key="Common.all.label" bundle="${common_labels}"/></a> <B>(<%=total%>)</B>

			</td></tr>
		<%}%>

	<tr>
		<td class=COLUMNHEADER><fmt:message key="eOR.StatusByCategory.label" bundle="${or_labels}"/></td>
	</tr>
		<%
		//String temp1="";
		total = 0;
		//out.println("<script>alert('CategoryData.size()="+CategoryData.size()+"')</script>");
		for( int i=0 ; i< CategoryData.size() ; i++ ) {
				/*if(i % 2 == 0){
					slClassValue = "QRYEVEN";
				}else{
					slClassValue = "QRYODD";
				} */
				slClassValue="gridData";
				String[] record = (String[])CategoryData.get(i);
				//record[0]=record[0]+"<b>("+Integer.parseInt(record[1])+")</b>";
				total = total+Integer.parseInt(record[1]);
				/*System.out.println("####CategoryData#####");
				System.out.println("PriorityData.size="+ PriorityData.size());
				System.out.println("record[0]="+record[0]);
				System.out.println("record[1]="+record[1]);
				System.out.println("record[2]="+record[2]);
				System.out.println("record[3]="+record[3]);*/
		%>
				<!--  additional parameter "speciality_code" added in the below url for BRU-HIMS-CRF-359 [IN038797] -->
				<tr><td class='<%=slClassValue%>'><font size=1><a class='gridLink' href='ConsentOrdersBottomRight.jsp?ord_cat=<%=record[2]%>&ord_cat_desc=<%=record[0]%>&total_recs=<%=record[1]%>&patientId=<%=patientId%>&source_code=<%=source_code%>&source_type=<%=source_type%>&period_from=<%=period_from%>&period_to=<%=period_to%>&speciality_code=<%=speciality_code%>&consentRec_order_id=<%=consentRec_order_id %>' target='ConsentOrdersBottomRight'><%=record[0]%></a> <b>(<%=Integer.parseInt(record[1])%>)</b></font></td></tr>

		<%
			}
		%>
			<!--  additional parameter "speciality_code" added in the below url for BRU-HIMS-CRF-359 [IN038797] -->
			<tr><td class='cagroup' bgcolor="#D5E2E5"><%if(total !=0){%><a class='gridLink' href='ConsentOrdersBottomRight.jsp?order_by=O&total_recs=<%=total%>&patientId=<%=patientId%>&source_code=<%=source_code%>&source_type=<%=source_type%>&period_from=<%=period_from%>&period_to=<%=period_to%>&speciality_code=<%=speciality_code%>&consentRec_order_id=<%=consentRec_order_id %>' target='ConsentOrdersBottomRight'><%}%><fmt:message key="Common.all.label" bundle="${common_labels}"/></a> <B>(<%=total%>)</B></font></td></tr>
</table>

<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
<!-- <input type="hidden" name="function_id" id="function_id" value="<%//=bean.getFunctionId()%>"> -->
</form>
</body>
</html>
<%
	//putObjectInBean(bean_id,bean,request);
%>


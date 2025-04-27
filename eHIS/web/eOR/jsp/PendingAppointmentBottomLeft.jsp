<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper"  contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<jsp:useBean id="bean" scope="page" class="eOR.PendingAppointmentbean"/>  
<%-- Mandatory declarations end --%>

<html>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>	
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../js/PendingAppointment.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  onload='FocusFirstElement()'  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	bean.setLanguageId(localeName);	
	String bean_id = "Or_ConsignOrders" ;
	String bean_name = "eOR.ConsignOrders";	
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String practitioner_id = (String)session.getValue("ca_practitioner_id")==null?"":(String)session.getValue("ca_practitioner_id");
	String facility_id = (String)session.getValue("facility_id")==null?"":(String)session.getValue("facility_id");
	String resp_id = (String)session.getValue("responsibility_id")==null?"":(String)session.getValue("responsibility_id");	
	String source_type = request.getParameter( "source_type" )==null?"":request.getParameter("source_type");	
	String source_code	= request.getParameter( "source_code" )==null?"":request.getParameter("source_code");
	String patientId  	    = request.getParameter("patientId")==null?"":request.getParameter("patientId");
	String period_from		= request.getParameter("period_from")==null?"":request.getParameter("period_from");
	String period_to		= request.getParameter("period_to")==null?"":request.getParameter("period_to");

	/* Added By : Arvind
							  Date : 09/01/2010
							  CRF  : PMG20089-CRF-829
							  Discription : Below code added to take filter value from request ". 
						 */
	String filter		= request.getParameter("filter")==null?"":request.getParameter("filter");
	
	Properties properties	= (Properties) session.getValue( "jdbc" );	
	String slClassValue = "";
	int total = 0;
	ArrayList PriorityData = bean.getStatusByPriority(properties, source_type,source_code,practitioner_id,resp_id,facility_id,patientId, period_from, period_to,filter) ;
	ArrayList CategoryData = bean.getStatusByCategory(properties, facility_id,source_type,source_code,practitioner_id,resp_id,patientId, period_from, period_to,filter) ;

%>
<form name='authorise_order_priority' id='authorise_order_priority' action="../../eOR/jsp/PendingAppointmentBottomLeft.jsp" method="post">
<table cellpadding=3 cellspacing=0 border=1 width="100%" class="grid">
	<tr>
		<td class=' COLUMNHEADER'><fmt:message key="eOR.StatusByPriority.label" bundle="${or_labels}"/></td>
	</tr>

		<%
			for( int i=0 ; i< PriorityData.size() ; i++ ) {
				String[] record = (String[])PriorityData.get(i);

               int len=record[0].length();
				String subrec=record[0].substring(1,len);				
				
				if(record[0].charAt(0)=='R'){
					record[0]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels").concat(subrec);
					record[2]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
					
				}
					else if(record[0].charAt(0)=='U')
				{
					
					record[0]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels").concat(subrec);
					record[2]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels");
					

				}
					else if(record[0].charAt(0)=='S')
				{
					
					record[0]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stat.label","common_labels").concat(subrec);
					record[2]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stat.label","common_labels");
				}
				
				slClassValue="gridData";
				total += Integer.parseInt(record[1]);				
		%>

			<tr><td class='<%=slClassValue%>'><font size=1><a class='gridLink' href='PendingAppointmentBottomRight.jsp?priority=<%=record[3]%>&priority_desc=<%=record[2]%>&total_recs=<%=record[1]%>&source_type=<%=source_type%>&source_code=<%=source_code%>&patientId=<%=patientId%>&period_from=<%=period_from%>&period_to=<%=period_to%>&filter=<%=filter%>'' target='CosignOrdersBottomRight'><%=record[0]%></a></font></td></tr>
					

		<%
			}
		%>
		<%if(total !=0){%>
			<tr><td class='cagroup' >
			<a class='gridLink' href='PendingAppointmentBottomRight.jsp?order_by=P&total_recs=<%=total%>&source_type=<%=source_type%>&source_code=<%=source_code%>&patientId=<%=patientId%>&period_from=<%=period_from%>&period_to=<%=period_to%>&filter=<%=filter%>'' target='CosignOrdersBottomRight'><fmt:message key="Common.all.label" bundle="${common_labels}"/><B>(<%=total%>)</B></a>

			</td></tr>
		<%}%>

	<tr>
		<td class='COLUMNHEADER'><fmt:message key="eOR.StatusByCategory.label" bundle="${or_labels}"/></td>
	</tr>
		<%
		
		total = 0;
		for( int i=0 ; i< CategoryData.size() ; i++ ) {
				
				slClassValue="gridData";
				String[] record = (String[])CategoryData.get(i);
				total += Integer.parseInt(record[2]);				

		%>		
				
				<tr><td class='<%=slClassValue%>'><font size=1><a class='gridLink'  href='PendingAppointmentBottomRight.jsp?ord_cat=<%=record[1]%>&ord_cat_desc=<%=record[3]%>&total_recs=<%=record[2]%>&source_type=<%=source_type%>&source_code=<%=source_code%>&patientId=<%=patientId%>&period_from=<%=period_from%>&period_to=<%=period_to%>&filter=<%=filter%>'' target='CosignOrdersBottomRight'><%=record[0]%></a></font></td></tr>

		<%
			}
		%>
						<tr><td class='cagroup' ><%if(total !=0){%><a class='gridLink' href='PendingAppointmentBottomRight.jsp?order_by=O&total_recs=<%=total%>&source_type=<%=source_type%>&source_code=<%=source_code%>&patientId=<%=patientId%>&period_from=<%=period_from%>&period_to=<%=period_to%>&filter=<%=filter%>'' target='CosignOrdersBottomRight'><%}%><fmt:message key="Common.all.label" bundle="${common_labels}"/><B>(<%=total%>)</B></a></font></td></tr>
</table>

<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
</form>
</body>
</html>


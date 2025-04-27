<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- Mandatory declarations end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<HEAD>
	<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
 	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>	
<BODY>
	<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String patient_id	= request.getParameter("patient_id");
	
	String encounter_id	= request.getParameter("encounter_id");
	
	String facility_id	= request.getParameter("facility_id");
	
	String discharge_ind	= request.getParameter("discharge_ind");
	
	String bean_id   = "pend_order_status" ;
	String bean_name = "eOR.PendingOrderStatusBean";
	PendingOrderStatusBean bean = (PendingOrderStatusBean)getBeanObject( bean_id,  bean_name, request ) ;
	bean.clear() ;
	bean.setLanguageId(localeName);
	ArrayList allValues = new ArrayList();
	String from	 = bean.checkForNull(request.getParameter( "from" ),"1") ;
	String to	 = bean.checkForNull(request.getParameter( "to" ),"14") ;
	int start	 = Integer.parseInt(from);
	int end		= Integer.parseInt(to);
	allValues		= bean.getPendingOrderDetails(patient_id,encounter_id,facility_id,discharge_ind,start,end);

	String[] existing_details = null;
	String total_query_records = "0";
	int j=0;
	%>
	<FORM name="view_pend_ord_list" id="view_pend_ord_list" action="../../eOR/jsp/ViewPendingOrdersList.jsp" method="post" >
	<%

	for(int k=0; k<allValues.size(); k++)
	{
				existing_details = (String[])allValues.get(k);
				
				if(existing_details[0] == null) existing_details[0] = "";
				if(existing_details[1] == null) existing_details[1] = "";
				if(existing_details[2] == null) existing_details[2] = "";
				if(existing_details[3] == null) existing_details[3] = "";
				if(existing_details[4] == null) existing_details[4] = "";
				if(existing_details[5] == null) existing_details[5] = "";
				if(existing_details[6] == null) existing_details[6] = "";
				if(existing_details[7] == null) existing_details[7] = "";
				if(existing_details[8] == null) existing_details[8] = "";
				if(existing_details[9] != null)
					total_query_records		= existing_details[9];
	}				
	if(allValues.size() == 0)
	{
		%>
		<script>
			alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));
		</script>
		<%	
	}
	%>
	
	<%
	if((Integer.parseInt(total_query_records)>0) || (start>1))
		{
			%>
			<table width="100%">
				<tr align="right" bgcolor='WHITE'>
					<td>
						<jsp:include page="ResultScrollingPendingOrders.jsp" ><jsp:param name="flush" value="true" />
						<jsp:param name ="from" value= "<%=start%>" /> 
						<jsp:param name ="to" value= "<%=end%>" />	
						<jsp:param name ="total_size" value= "<%=total_query_records%>" />   
						<jsp:param name ="check_box_name" value= "chk" />	
											
						<jsp:param name ="form_name" value= "view_pend_ord_list" /> 								 
					
						</jsp:include>
					</td>
				</tr>
			</table>
			<%
		}
	%>
		<TABLE cellpadding=3 cellspacing=0 border=1 width="100%" height='' id="tableresult" class="grid">
			<TR height='30px'><TD COLSPAN='7'></TD></TR>
			<TR id="heading" height='30px'>
				<TD class='COLUMNHEADER' width='' nowrap><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></TD>
				<TD class='COLUMNHEADER' width='' nowrap><fmt:message key="Common.enddate.label" bundle="${common_labels}"/></TD>
				<TD class='COLUMNHEADER' width='' nowrap><fmt:message key="Common.priority.label" bundle="${common_labels}"/></TD>
				<TD class='COLUMNHEADER' width='' nowrap><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></TD>
				<TD class='COLUMNHEADER' width='' nowrap><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></TD>
				<TD class='COLUMNHEADER' width='' nowrap><fmt:message key="Common.OrderedBy.label" bundle="${common_labels}"/></TD>
				<TD class='COLUMNHEADER' width='' nowrap><fmt:message key="Common.status.label" bundle="${common_labels}"/></TD>
			</TR>
			<%
			for(int k=0; k<allValues.size(); k++)
			{
				existing_details = (String[])allValues.get(k);
				
				/*if(existing_details[0] == null) existing_details[0] = "";
				if(existing_details[1] == null) existing_details[1] = "";
				if(existing_details[2] == null) existing_details[2] = "";
				if(existing_details[3] == null) existing_details[3] = "";
				if(existing_details[4] == null) existing_details[4] = "";
				if(existing_details[5] == null) existing_details[5] = "";
				if(existing_details[6] == null) existing_details[6] = "";
				if(existing_details[7] == null) existing_details[7] = "";
				if(existing_details[8] == null) existing_details[8] = "";
				if(existing_details[9] != null)
					total_query_records		= existing_details[9];*/
								
			%>
			<TR height='25px'>
				<TD  class='gridData' width='' nowrap><%=existing_details[3]%></TD>
				<TD  class='gridData' width='' nowrap><%=existing_details[4]%></TD>
				<TD  class='gridData' width='' nowrap><font size=1 color=black><b><%=existing_details[5]%></b></font></TD>
				<TD  class='gridData' width='' nowrap><%=existing_details[7]%></TD>
				<TD  class='gridData' width='' nowrap><%=existing_details[0]%></TD>
				<TD  class='gridData' width='' nowrap><%=existing_details[8]%></TD>
				<TD  class='gridData' width='' nowrap><%=existing_details[6]%></TD>
			</TR>
			<%
			j++;
			}
			%>
		</TABLE>
		<input type=hidden name='total_recs' id='total_recs' value='<%=j%>'>
		<input type='hidden' name='patient_id' id='patient_id' value='<%=patient_id%>'>
		<input type='hidden' name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
		<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
		<input type='hidden' name="discharge_ind" id="discharge_ind" value="<%=discharge_ind%>">
		<input type='hidden' name='from' id='from' value='<%=from%>'>
		<input type='hidden' name='to' id='to' value='<%=to%>'>
	</FORM>
</BODY>
</HTML>


<!DOCTYPE html>
<%
/*
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
*/
/* 
------------------------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History      		Name        		Rev.Date				Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------------------------------
04/07/2017		IN066377			Kamalakannan G	  		 04/07/2017				Ramesh G.		AMS-CRF-0139
06/02/2019		IN069673			Kamalakannan G			06/02/2019				Ramesh G.		AMS-CRF-0139/02
------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>

<%-- JSP Page specific attributes start --%>
<%@page import="eOR.*, java.sql.*, java.util.*,java.text.*,eOR.Common.*,eCommon.Common.*" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
<Html>
<Head>
	<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<Script language="javascript" src="../js/PerformingLocationMandatory.js"></Script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</Head>
<%
	String bean_id   = "PerformingLocation";
	String bean_name = "eOR.PerformingLocation";
	PerformingLocation PerformBean = (PerformingLocation)getBeanObject(bean_id,bean_name,request);
	ArrayList<String[]> tab_val = PerformBean.generateMandatoryRows();
	int length = tab_val.size();
%>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<form name="perf_locn_mand" id="perf_locn_mand">
		<Table class='grid' width='90%' align="center">
			<tr>		
				<td class='COLUMNHEADER' width='25%'><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.DC.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='10%'>EM</td>
				<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.OP.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.IP.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='10%'>XT</td>
			</tr>
			<%for(int start=0;start<length;start++){
				String[] row_val= new String[8];
				row_val = tab_val.get(start);
			%>
			<tr>
				<td class='gridData'><%=row_val[1]%><input type=hidden name=order_cat<%=start%> value=<%=row_val[0]%>></td>	
				<td class='gridData'><INPUT TYPE="checkbox" name="chk1_<%=start%>" id="chk1_<%=start%>" <%if(row_val[7].equals("D")){%>disabled<%}%> value=<%=row_val[2]%> <%if(row_val[2].equals("Y")){out.println(" checked ");}%> onClick='changeValue(this)'></td>
				<td class='gridData'><INPUT TYPE="checkbox" name="chk2_<%=start%>" id="chk2_<%=start%>" <%if(row_val[7].equals("D")){%>disabled<%}%> value=<%=row_val[3]%> <%if(row_val[3].equals("Y")){out.println(" checked ");}%> onClick='changeValue(this)'></td>
				<td class='gridData'><INPUT TYPE="checkbox" name="chk3_<%=start%>" id="chk3_<%=start%>" <%if(row_val[7].equals("D")){%>disabled<%}%> value=<%=row_val[4]%> <%if(row_val[4].equals("Y")){out.println(" checked ");}%> onClick='changeValue(this)'></td>
				<td class='gridData'><INPUT TYPE="checkbox" name="chk4_<%=start%>" id="chk4_<%=start%>" <%if(row_val[7].equals("D")){%>disabled<%}%> value=<%=row_val[5]%> <%if(row_val[5].equals("Y")){out.println(" checked ");}%> onClick='changeValue(this)'></td>
				<td class='gridData'><INPUT TYPE="checkbox" name="chk5_<%=start%>" id="chk5_<%=start%>" <%if(row_val[7].equals("D")){%>disabled<%}%> value=<%=row_val[6]%> <%if(row_val[6].equals("Y")){out.println(" checked ");}%> onClick='changeValue(this)'></td>
			</tr>
			<%}%>
		</Table>	
		<input type="hidden" name="totalRecords" id="totalRecords" value="<%=length%>">
		<input type="hidden" name="mode" id="mode" value="2">
		<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
		<input type="hidden" name="function_id" id="function_id" value="Perf_locn_mand">
	</form>	
</body>
</html>


<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/*
------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------
09/08/2017		IN058006	Prakash C		09/08/2017		Ramesh G		ML-MMOH-CRF-0461
------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eCA.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script src="../../eCA/js/SplChartGroups.js" language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>
<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%	
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String mode	     = request.getParameter( "mode" ) ;
	Connection connection 		= null;
	PreparedStatement pstmt 	= null;
	ResultSet resultSet 			= null;
%>
<form name="spl_chart_groups" id="spl_chart_groups" method="post" target="messageFrame">
<table  class='grid' width="100%">
	<tr>
	<td class="COLUMNHEADER" width="10%" style="text-align:center">
			<fmt:message key="eCA.splchtgrpid.label" bundle="${ca_labels}"/>
		</td>
		<td class="COLUMNHEADER" width="15%" style="text-align:center">
			<fmt:message key="eCA.splchtgrpdesc.label" bundle="${ca_labels}"/>
		</td>
		<!--<th>Clinical Comments Mandatory </th>-->
		<td class="COLUMNHEADER" width="15%" style="text-align:center">
			<fmt:message key="eCA.Effectivestat.label" bundle="${ca_labels}"/>
		</td>
		
	</tr>
	<%
		int ilRow=0;
		String slClassValue = "gridData";
		String checked1 = "";
		
		String[] record =null;
		String chart_grp_id ="";
		String chart_grp_desc ="";
		String chart_status ="";
		connection = ConnectionManager.getConnection(request);	
		pstmt = connection.prepareStatement("SELECT SPL_CHART_TYPE_GRP_ID,SPL_CHART_TYPE_GRP_DESC,EFF_STATUS FROM CA_SPL_CHART_TYPE_GRP");
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) 
			{
				record = new String[3];
				chart_grp_id = resultSet.getString( "SPL_CHART_TYPE_GRP_ID" )== null ? "" : resultSet.getString( "SPL_CHART_TYPE_GRP_ID" )  ;
				chart_grp_desc = resultSet.getString( "SPL_CHART_TYPE_GRP_DESC" ) == null ? "" : resultSet.getString( "SPL_CHART_TYPE_GRP_DESC" ) ;
				chart_status = resultSet.getString( "EFF_STATUS" ) == null ? "D" : resultSet.getString( "EFF_STATUS" ) ;

				if(chart_status.equals("E"))
				checked1 = " checked ";
				ilRow++;
		%>
		<tr>
			<td style="text-align:center" class='<%=slClassValue %>'><%=chart_grp_id%> 			
				<input type=hidden  name="spl_chart_id<%=ilRow%>" id="spl_chart_id<%=ilRow%>" value="<%=chart_grp_id%>">				
			</td>				
			<td class='<%= slClassValue %>'style="text-align:center"><%=chart_grp_desc%>
				<input type=hidden name="spl_chart_desc<%=ilRow%>" id="spl_chart_desc<%=ilRow%>" value="<%=chart_grp_desc%>" maxlength=30 size=30 onBlur="makeValidString(this);">
			</td>
			<td  class="<%= slClassValue %>"  style="text-align:center">
				<input type="checkbox" name="chec<%=ilRow%>" id="chec<%=ilRow%>" value="<%=chart_status%>" onClick="changeValue(this)" <%=checked1%>>
			</td>
		</tr>
		<%	
			
			checked1 = "";
			/*Added by Uma on 2/1/2010 for 804*/
		}
		%>
</table>
<input name ='category_size' type='hidden' value='<%=ilRow%>'>
<input type="hidden" name="totalRecords" id="totalRecords" value="<%=ilRow%>">
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="function_id" id="function_id" value="spl_chart_groups">
</form>
</body>
</html>




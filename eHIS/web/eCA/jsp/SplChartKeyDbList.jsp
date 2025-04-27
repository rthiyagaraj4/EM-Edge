<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
?             100            ?           	    ?				?			created
30/07/2018	IN061886		Ramesh G				    					To be able to plot Growth Charts for Pre Term babies and abnormal babies.
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="java.sql.*,webbeans.eCommon.*,java.util.* "  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<title>SplChartKeyDbList</title>
	<script src='../../eCA/js/SplChartKey.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	

	<script>
			parent.parent.frameSplChartKeyHdr.document.forms[0].r1.disabled = true;
			parent.parent.frameSplChartKeyHdr.document.forms[0].r2.disabled = true;
			alert(getMessage('RECORD_ALREADY_EXISTS','Common'));

	</script>

<%
request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<style>
	td,th,tr
	{border-bottom: 1px solid #d5e2e5;
	}
	</style>
</head>
<body OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<div style="display: flex; justify-content: center;">
<table id="splchart_details" width='50%' class='grid' align=center>
<tr>
	<td class='COLUMNHEADERCENTER'  width='20%'><fmt:message key="Common.SerialNo.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADERCENTER' width='20%'><fmt:message key="Common.Key.label" bundle="${common_labels}"/> <fmt:message key="Common.Value.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADERCENTER'  width='60%'><fmt:message key="Common.Range.label" bundle="${common_labels}"/></td>
</tr>
<%	
	String sql = "";
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rset = null;
	String splChartType  =  request.getParameter("spl_chart_type");
	String splChartGroup =  request.getParameter("spl_chart_group");
	String  xAxis_element = request.getParameter("xAxis_element");
	splChartType = splChartType==null?"":splChartType;
	splChartGroup = splChartGroup==null?"":splChartGroup;
	xAxis_element = xAxis_element==null?"*K":xAxis_element;
	try{
		con = ConnectionManager.getConnection(request);
		sql = "SELECT * FROM CA_SPL_CHART_KEY_VALUE WHERE SPL_CHART_TYPE=? AND SPL_CHART_TYPE_GRP_ID = ? AND X_ELEMENT_TYPE=? ORDER BY START_VALUE";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,splChartType);
		pstmt.setString(2,splChartGroup);
		pstmt.setString(3,xAxis_element);
		rset  = pstmt.executeQuery();
		int i = 1;
		//String classValue = null;
		String classValue ="gridData";
		String unit = "";
		String unitValue = null;
		String startValue = "";
		String endValue = "";
		String keyValue = "";
		String range = "";

		while(rset.next())
		{
			unit = rset.getString("VALUE_UNIT");
			if(unit.equals("M"))
				unitValue = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.months.label","common_labels");
			else if(unit.equals("Y"))
				unitValue = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Years.label","common_labels");
			else if(unit.equals("D"))
				unitValue = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.days.label","common_labels");
			else if("KG".equals(unit))
				unitValue = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Kgs.label","common_labels");
			else if("KM".equals(unit))
				unitValue = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.kgm2.label","ca_labels");
			else if("CM".equals(unit))
				unitValue = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.centimeters.label","ca_labels");
			else if("W".equals(unit))
				unitValue = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.weeks.label","common_labels");  //IN061886
	
			keyValue = rset.getString("KEY_VALUE");
			startValue = rset.getString("START_VALUE");
			endValue = rset.getString("END_VALUE");
			range = startValue+"~"+endValue;
			/*if(i % 2 == 0 )
				classValue	=	"gridData";
			else	
				classValue	=	"gridData";*/
		%>
		<tr>
			<td width='20%'  class = 'gridNumericData' nowrap>&nbsp;<%=(i)%>&nbsp;</td>
			<td width='20%'  class = 'gridNumericData' nowrap>&nbsp;<%=keyValue%>&nbsp;</td>
			<td width='60%'  class = '<%=classValue%>' nowrap>&nbsp;<%=range%>&nbsp;<%=unitValue%></td>
		</tr>
		
		<%
		i++;
		}	
		if(rset!=null) rset.close();
		if(pstmt!=null) pstmt.close();
	} 
	catch(Exception e){
		//out.println("Exception in try of SplChartKeyHdr.jsp"+e.toString());//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
	}
	finally{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
%>
</body>
</html>


<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="eXH.XHDBAdapter, eXI.MonitorItemsBean, eXH.XHQueryRender, webbeans.eCommon.ConnectionManager,eXH.XHUtil" %>
<%@ page import="java.sql.Connection" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8"); 
String locale = ((String)session.getAttribute("LOCALE"));
%>	

<head>
<%
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel='stylesheet' href='../../eXH/html/menu.css' type='text/css'></link>
<link rel='stylesheet' href='../../eXH/html/style.css' type='text/css'></link>
<link rel='stylesheet' href='../../eXH/html/ViewEvents.css' type='text/css'></link>

<!-- these style setting are used for table scroll -->
<style>
	div {float: left}
	.testSty
	{
		width:expression(document.getElementById("indicatorTable").clientWidth-document.getElementById("left_child").clientWidth);
		overflow: scroll;
	}
</style>
 
<% 
String action_type = null;
String maxRecords = "24";
%>

<script language='javascript' src="../../eCommon/js/common.js"></script>
<script Language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script Language="javascript" src="../../eXH/js/InterfaceUtil.js"></script>
<script Language="javascript" src="../../eXH/js/menu.js"></script>
<script Language="javascript" src="../../eXI/js/MonitorItems.js"></script>
<script Language="javascript" src="../../eXH/js/jquery-1.7.min.js"></script>
<Script Language='javascript'>

function funAction(typ)
{
	parent.schemaBrowserResultFrame.inv_monitoring_scr.action_type.value = typ;
	funSubmit();
}

function funSubmit()
{
	parent.schemaBrowserResultFrame.inv_monitoring_scr.action = '../../eXI/jsp/MonitorItemsPopulateRecords.jsp';
	parent.schemaBrowserResultFrame.inv_monitoring_scr.target = "schemaBrowserResultFrame";
	parent.schemaBrowserResultFrame.inv_monitoring_scr.submit();
}

</Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body onKeyDown ='lockKey()' onMouseDown='CodeArrest()' onLoad='initFunc()'>
<form name = "inv_monitoring_scr" method="POST" action='../../eXI/jsp/MonitorItemsPopulateRecords.jsp'>
<%
int recordCount = 0;
boolean boolToggle =  true;
String strTDClass = "";
String tableName = "";
String functionID = "";
String dateFrom = "";
String dateTo = "";
String queueType = "";
String operation = request.getParameter("operation");
String siteID = (String)session.getAttribute("intSiteID");
ArrayList<String> tableIndColList = null;
ArrayList<String> tabColumnList = null;
Map<String,String> tabDatatypeColList = null;
ArrayList<HashMap> arrRow = null;
Connection conn = null;
boolean boolNext = false; 
boolean boolPrevious = false;
boolean isEditable = true;
boolean isReloadAuthorised = false;
String strPrevious = null;
String strNext = null;
HashMap<String, String> currentRecord = null;
HashMap resultsQry = null;

try
{
	System.out.println(" ********************** Inside MonitorItemsPopulateRecords 89 **********************");
	String resultMessage = XHDBAdapter.checkNull(request.getParameter("message"));
	Properties prop = (Properties)session.getValue("jdbc");
	String loginID = prop.getProperty("login_user");
	System.out.println(" ********************** Inside MonitorItemsPopulateRecords 93 **********************");
	MonitorItemsBean monitorItemsBean = new MonitorItemsBean();
	conn = ConnectionManager.getConnection(request);
	functionID = XHDBAdapter.checkNull(request.getParameter("functionID"));
	dateFrom = XHDBAdapter.checkNull(request.getParameter("dateFrom"));
	dateTo = XHDBAdapter.checkNull(request.getParameter("dateTo"));
	action_type = XHDBAdapter.checkNull(request.getParameter("action_type"));
	queueType = XHDBAdapter.checkNull(request.getParameter("queueType"));

	System.out.println(" ********************** Parameters functionID : "+functionID+" : dateFrom : "+dateFrom+ " : dateFrom : "+dateTo+ " : dateTo : "+dateFrom+" : action_type : "+action_type+" : action_type : "+action_type+" : queueType : "+queueType);
	
	tableName = monitorItemsBean.getFuncTableName(functionID, queueType);

	System.out.println(" ********************** Parameters tableName : "+tableName);

	String whrClause = "";
	String temp = "";
	StringBuilder whrClauseBuilder = new StringBuilder();
	boolean isCriteriaAdded = false;
	String reloadYN = new XHUtil().singleParamExeQry("SELECT reload_yn FROM xh_authorized_user WHERE login_name = '"+ loginID +"'");	

	System.out.println(" ********************** Parameters reloadYN : "+reloadYN+" : siteID : "+siteID);
	
	if("SI".equals(siteID) && "Y".equals(reloadYN)) isReloadAuthorised = true;

	System.out.println(" ********************** Parameters isReloadAuthorised : "+isReloadAuthorised);
	
	tableIndColList = (ArrayList)MonitorItemsBean.getIndexColList(functionID, prop);
	System.out.println(" ********************** Parameters tableIndColList Size : "+tableIndColList.size());

	tabColumnList = (ArrayList)MonitorItemsBean.getTabColList(tableName, prop);
	System.out.println(" ********************** Parameters tabColumnList Size : "+tabColumnList.size());

	tabDatatypeColList = MonitorItemsBean.getTabDataTypeList(tableName, prop);
	System.out.println(" ********************** Parameters tableIndColList Size : "+tableIndColList.size());

	request.setAttribute(XHQueryRender.strQueryId, "INVENTORY_MONITORING_SCR");
	request.setAttribute("tableName", tableName);
	request.setAttribute(XHQueryRender.col, tabColumnList.size());
	request.setAttribute(XHQueryRender.maxRec, maxRecords);
	request.setAttribute(XHQueryRender.whereClause, whrClause);

	if(tableIndColList != null && (tableIndColList.size() > 0))
	{

	for(String colName: tableIndColList)
	{
		temp = XHDBAdapter.checkNull(request.getParameter(colName));

		System.out.println(" ********************** Parameters request.getParameter(colName) : "+request.getParameter(colName)+" : siteID : "+siteID);
%>
<input type='hidden' name='<%=colName%>' id='<%=colName%>' value='<%=temp%>'>
<%
		if(temp != null && !temp.equals(""))
		{
			if(isCriteriaAdded) whrClauseBuilder.append(" AND ");
			else whrClauseBuilder.append(" WHERE ");
			if("TRXDATETIME".equals(colName)) whrClauseBuilder.append("TRXDATETIME = TO_DATE('"+temp+"','dd/mm/yyyy')");
			else	whrClauseBuilder.append(colName + " = '" + temp + "'");
			isCriteriaAdded = true;
		}
	}

	System.out.println(" ********************** Parameters whrClauseBuilder : "+whrClauseBuilder.toString());

	if(dateFrom != null & !dateFrom.equals(""))
	{
		if(isCriteriaAdded) whrClauseBuilder.append(" AND ");
		else whrClauseBuilder.append(" WHERE ");
		if(dateTo != null & !dateTo.equals(""))
		{
			whrClauseBuilder.append("TO_DATE(TO_CHAR(trx_date,'dd/mm/yyyy'),'dd/mm/yyyy') BETWEEN TO_DATE('"+dateFrom+"','dd/mm/yyyy') AND TO_DATE('"+dateTo+"','dd/mm/yyyy')");
		}
		else
		{
			whrClauseBuilder.append("TO_DATE(TO_CHAR(trx_date,'dd/mm/yyyy'),'dd/mm/yyyy') >= TO_DATE('"+dateFrom+"','dd/mm/yyyy')");
		}
	}
	else if(dateTo != null & !dateTo.equals(""))
	{
		if(isCriteriaAdded) whrClauseBuilder.append(" AND ");
		else whrClauseBuilder.append(" WHERE ");
		whrClauseBuilder.append("TO_DATE(TO_CHAR(trx_date,'dd/mm/yyyy'),'dd/mm/yyyy') <= TO_DATE('"+dateTo+"','dd/mm/yyyy')");
	}

	System.out.println(" ********************** Parameters whrClauseBuilder : "+whrClauseBuilder.toString());
	
	if("XF_DF_HEALTHCAREDELIVERY".equalsIgnoreCase(tableName)) 
	{		
		whrClauseBuilder.append(" ORDER BY ORDERDOCTOR, HEALTHCAREOFFERINGID, TRXDATETIME");
	}
	whrClause = whrClauseBuilder.toString();	

	System.out.println(" ********************** Parameters whrClause : "+whrClause);
	
	request.setAttribute(XHQueryRender.whereClause, whrClause);

	System.out.println(" ********************** Parameters 190 : ");

	boolean tempIsIndCol = false;
	for(Iterator<String> it = tabColumnList.iterator(); it.hasNext(); )
	{
		String currentColName = it.next();
		for(String colName: tableIndColList)
		{
			if(currentColName.equals(colName))
			{
				it.remove();
				tempIsIndCol = true;
				break;
			}
		}
		if(tempIsIndCol)
		{
			tempIsIndCol = false;
			continue;
		}
	}	
	System.out.println(" ********************** Parameters 211 : ");
	}

	resultsQry = XHQueryRender.getResults(request, session, conn);
	arrRow = (ArrayList)resultsQry.get("qry_result");	
	recordCount = arrRow.size();
	
	System.out.println(" ********************** Parameters 218 : ");

	boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 
	boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 
	strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
	strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");

	System.out.println(" ********************** Parameters 225 : ");

	if (boolPrevious == true)
	{
		strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
	}
	else
	{
		strPrevious = " ";
	}
	if (boolNext== true)
	{
		strNext = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");
	}
	else
	{
		strNext = " ";
	}

	System.out.println(" ********************** Parameters 244 : ");

 	%>
 
<input type='hidden' name='action_type' id='action_type' value='<%=action_type%>'>
<input type='hidden' name='tableName' id='tableName' value='<%=tableName%>'>
<input type='hidden' name='dateTo' id='dateTo' value='<%=dateTo%>'>
<input type='hidden' name='dateFrom' id='dateFrom' value='<%=dateFrom%>'>
<input type='hidden' name='functionID' id='functionID' id='functionID' value='<%=functionID%>'>
<input type='hidden' name='queueType' id='queueType' id='queueType' value='<%=queueType%>'>
<input type="hidden" name="resultMessage" id="resultMessage" id="resultMessage" value="<%= resultMessage %>">

<%
	System.out.println(" ********************** Parameters arrRow.size() : "+arrRow.size());
if(arrRow == null || (arrRow.size() == 0)){
	System.out.println(" ********************** Parameters 259 : ");
%>	

<script>	
	alert(getMessage('XH1021','XH'));
</script>

<%
}
else{
%>

<table id="indicatorTable" cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
	<td align="right" class="CAGROUP"> 
		<A class='label' style='cursor:pointer' onClick="funAction('P')"><%= strPrevious %></A>
		<A class='label' onClick="funAction('N')" style='cursor:pointer'><%= strNext %></A>
	</td>
</tr>
</table>

<div id="left_child" style="display:none;">
<% if(tableIndColList != null) {%>
<table id="table1" cellspacing=0 cellpadding=3 border=1>	
	<tr>
	<%
		for(String colName: tableIndColList)
		{
	%>
		<td class='COLUMNHEADER'>
			<font color=white><%= colName %></font>
		</td>
	<%
		}
	%>
	</tr>

	<%
		for (int j = 0; j < recordCount; j++)
		{
			currentRecord = arrRow.get(j);
			if (boolToggle == true)
			{
				if("IeStyle.css".equalsIgnoreCase(sStyle)) strTDClass = "class='XHQRYEVEN'";
				else strTDClass = "class='QRYEVEN'";
				boolToggle =  false;
			}
			else
			{
				if("IeStyle.css".equalsIgnoreCase(sStyle)) strTDClass = "class='XHQRYODD'";
				else strTDClass = "class='QRYODD'";
				boolToggle =  true;
			}
	%>
	
	<tr id="testID">
	<%
		for(String colName: tableIndColList)
		{
			if(tabDatatypeColList.get(colName).equals("NUMBER"))
			{
	%>
			<td nowrap <%=strTDClass%> align='right'>
				<font size=1>&nbsp;<%= MonitorItemsBean.checkNumber((String)currentRecord.get(colName)) %>
			</td>
	<%
			}
			else if(tabDatatypeColList.get(colName).equals("DATE"))
			{
				String val = (String)currentRecord.get(colName);
				int valLen = val.length();
	%>
			<td nowrap <%=strTDClass%> align='right'>
				<font size=1>&nbsp;<%= (valLen == 21)?val.substring(0,19):val %>
			</td>
	<%
			}
			else if("RECORD_STATUS".equalsIgnoreCase(colName) && currentRecord.get(colName).equals("E"))
			{
	%>
			<td nowrap <%=strTDClass%> onMouseOver=this.style.cursor='hand' 
										onMouseDown="buildMenu('<%= currentRecord.get("TRX_NO") %>')">
				<font size=1>&nbsp;<%= XHDBAdapter.checkNull(currentRecord.get(colName)) %>
			</td>
	<%
			}
			else
			{
	%>
			<td nowrap <%=strTDClass%>>
				<font size=1>&nbsp;<%= XHDBAdapter.checkNull(currentRecord.get(colName)) %>
			</td>
	<%
			}
		}
	%>
	</tr>

	<%
		}
	%>

</table>
<%}%>
</div>
<div id="right_child" class="testSty" style="overflow-y:scroll;overflow:-moz-scrollbars-vertical;display:none;">
<table id="table2" cellspacing=0 cellpadding=3 border=1>
	<tr>
	<%
		for(String colName: tabColumnList)
		{
	%>
		<td nowrap class='COLUMNHEADER'>
			<font color=white><%= colName %></font>
		</td>
	<%
		}
	%>			
	</tr>

	<%
		boolToggle = true;
		for (int j = 0; j < recordCount; j++)
		{
			currentRecord = arrRow.get(j);
			if (boolToggle == true)
			{
				if("IeStyle.css".equalsIgnoreCase(sStyle)) strTDClass = "class='XHQRYEVEN'";
				else strTDClass = "class='QRYEVEN'";
				boolToggle =  false;
			}
			else
			{
				if("IeStyle.css".equalsIgnoreCase(sStyle)) strTDClass = "class='XHQRYODD'";
				else strTDClass = "class='QRYODD'";
				boolToggle =  true;
			}
	%>
	<tr>
	<%
		for(String colName: tabColumnList)
		{
			if(tabDatatypeColList.get(colName).equals("NUMBER"))
			{
	%>
			<td nowrap <%=strTDClass%> align='right'>
				<font size=1>&nbsp;<%= MonitorItemsBean.checkNumber((String)currentRecord.get(colName)) %>
			</td>
	<%
			}
			else if(tabDatatypeColList.get(colName).equals("DATE"))
			{
				String val = (String)currentRecord.get(colName);
				int valLen = val.length();
	%>
			<td nowrap <%=strTDClass%> align='right'>
				<font size=1>&nbsp;<%= (valLen == 21)?val.substring(0,19):val %>
			</td>
	<%
			}
			else
			{
	%>
			<td nowrap <%=strTDClass%> >
				<font size=1>&nbsp;<%= XHDBAdapter.checkNull(currentRecord.get(colName)) %>
			</td>
	<%
			}
		}
	%>

	</tr>

	<% } 
	%>
	</tr>
</table>
</div>
	
<SCRIPT>
	document.getElementById("left_child").style.display = "block";
	document.getElementById("right_child").style.display = "block";
</SCRIPT>
	
	<%
	}	
	if(arrRow != null) arrRow.clear();
	if(currentRecord != null) currentRecord.clear();
	if(resultsQry != null) resultsQry.clear();
}
catch(Exception e1)
{
	out.println("<SCRIPT>alert(getMessage('XH1021','XH'));</SCRIPT>");
	e1.printStackTrace(System.err);
	System.out.println(e1);
	System.out.println("functionID "+functionID);
	System.out.println("queueType "+queueType);
	System.out.println("tableName "+tableName);
	System.out.println("isReloadAuthorised "+isReloadAuthorised);
	System.out.println("tableIndColList "+tableIndColList);
	System.out.println("tabColumnList "+tabColumnList);
	System.out.println("tabDatatypeColList "+tabDatatypeColList);
}
finally
{
	ConnectionManager.returnConnection(conn);
}
%>
<input type="hidden" name="isReloadAuthorised" id="isReloadAuthorised" id="isReloadAuthorised" value="<%= isReloadAuthorised %>"/>
</form>
</html>


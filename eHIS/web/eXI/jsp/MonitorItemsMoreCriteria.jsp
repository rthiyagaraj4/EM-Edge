<!DOCTYPE html>
<%@ page import ="webbeans.eCommon.*,java.util.*,eXH.XHDBAdapter,eXH.XHUtil,eXI.MonitorItemsBean" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>						  
<% 
	request.setCharacterEncoding("UTF-8");	
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";	
	String locale = ((String)session.getAttribute("LOCALE"));
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'></link> 
<script language='javascript' src='../../eCommon/js/common.js'></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>	
<script language="javascript" src="../../eXI/js/MonitorItems.js" ></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eXH/js/InterfaceUtil.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
 
<%
try
{
	Properties prop = (Properties)session.getValue("jdbc");
	MonitorItemsBean monitorItemsBean = new MonitorItemsBean();
	String functionID = XHDBAdapter.checkNull(request.getParameter("funcID"));
	String queueType = XHDBAdapter.checkNull(request.getParameter("queueType"));
	String dispColName = "";

	String tableName = monitorItemsBean.getFuncTableName(functionID, queueType);	
	List<String> tabIndexColList = MonitorItemsBean.getIndexColList(functionID, prop);
	String strDate = XHUtil.getFormattedStringDate("dd/MM/yyyy", new Date());
%>

<body onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>
	<form name="searchCriteria" id="searchCriteria" method="GET">

	<fieldset style=" border-color:black;">
	
	<table  border='0' id='staticFieldTab' width='100%'>
	<TR>
	<% if("XF_DF_HEALTHCAREDELIVERY".equals(tableName)) { %>
		<th colspan="4">
			Processed Records Search Criteria
		</th>
	<% } %>
	</TR>
		<%		
			if(tabIndexColList != null && tabIndexColList.contains("TRX_DATE"))
			{
		%>
		<tr ID="transDateTR">
			<td class='LABEL' align='center'>
				Transaction Date
			</td>
			<td class='LABEL' align='center' colspan='2'>
				From 
				<input type='text' name='dateFrom' id='dateFrom' value='<%= strDate %>' size='11' onBlur='isAfterCurrDate(this);'> 
				<input type='image' src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('dateFrom','dd/mm/y');">
				To:
				<input type='text' name='dateTo' id='dateTo' value='<%= strDate %>' size='11' onBlur='isAfterCurrDate(this);'> 
				<input type='image' src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('dateTo','dd/mm/y');">
			</td>

		<%
			}
			if(tabIndexColList != null && tabIndexColList.size() > 0)
			{
				int trCounter = 2; // Variable used to create new <TR> for every two <TD>s
				for(String colName: tabIndexColList)
				{
					dispColName = MonitorItemsBean.getDispName(colName);
					
					if(trCounter == 2)
					{
						trCounter = 0;
		%>
			</tr><tr>
		<%			}
					if("RECORD_STATUS".equals(colName))
					{
		%>
			<td class='LABEL'><%= dispColName %></td>
			<td class='FIELDS'>
				<SELECT name='<%= colName %>' id='<%= colName %>' ID='<%= colName %>' style="width: 150px">
					<OPTION value="">All</OPTION>
					<OPTION value="N">New</OPTION>
					<OPTION value="S">Success</OPTION>
					<OPTION value="M">Master Error</OPTION>
			<%
				if(!"XI_MANUFACTURER_IB".equals(functionID) && !"XI_TRADECODE_IB".equals(functionID)
						&& !"XI_ITEM_IB".equals(functionID) && !"XI_ITEM_STORE_BIN_LOCN_IB".equals(functionID)
						&& !"XI_ITEM_UOM_DEFN_IB".equals(functionID) && !"XI_SUPPLIER_IB".equals(functionID))
				{
			%>
					<OPTION value="E">Error</OPTION>
					<OPTION value="U">Update</OPTION>
			<%
				}
			%>
				</SELECT>
			</td>
		<%
				}
				else if("WS_STATUS".equals(colName))
				{
		%>
			<td class='LABEL'><%= dispColName %></td>
			<td class='FIELDS'>
				<SELECT name='<%= colName %>' id='<%= colName %>' ID='<%= colName %>' style="width: 150px">
					<OPTION value="">All</OPTION>
					<OPTION value="N">Pending</OPTION>
					<OPTION value="S">Success</OPTION>
					<OPTION value="E">Error</OPTION>			
				</SELECT>
			</td>
		<%
				}
				else if("TRXDATETIME".equals(colName))
				{
		%>
			<td class='LABEL'><%= dispColName %></td>
			<td class='FIELDS'>
				<input type='text' name='<%= colName %>' id='<%= colName %>' value='' size='11' onBlur="xhBeforeNow(this,'DMY');"> 
				<input type='image' src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('<%= colName %>','dd/mm/y');">
			</td>
		<%
				}
				else if(!"TRX_DATE".equals(colName))
				{
		%>
			<td class='LABEL'><%= dispColName %></td>
			<td class='FIELDS'>
				<INPUT TYPE='text' name='<%= colName %>' id='<%= colName %>' ID='<%= colName %>' style="width: 150px">
			</td>
		<%
				}
			if(!"TRX_DATE".equals(colName))	trCounter++;
			}
			}
		%>
		</tr>
	</table>
	<table border='0' align='right'>
		 <tr>
			<td>
				<input type='button' value='Export' ID="export2Excel" name ='export2Excel' onclick='exportData()'>&nbsp;
				<input type='button' value='Search' name ='btnSearch' onclick='displayData()'>&nbsp;
			</td>
		</tr> 
	</table>
	</fieldset>
	 <INPUT TYPE="hidden" id="operation" name="operation" id="operation" value="">
	 <INPUT TYPE="hidden" id="tableName" name="tableName" id="tableName" value="<%= tableName %>">
	 <INPUT TYPE="hidden" id="queueType" name="queueType" id="queueType" value="<%= queueType %>">
	 <INPUT TYPE="hidden" id="functionID" name="functionID" id="functionID" value="<%= functionID %>">
	 <INPUT TYPE="hidden" id="locale" name="locale" id="locale" value="<%= locale %>">
	</form>										    
</body>
<%
}
catch(Exception exp)
{
	exp.printStackTrace(System.err);
}
%>
</html>


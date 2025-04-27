<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOH.* " %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<html>

<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel='StyleSheet' href='../../eCommon/html/grid.css' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
 	<script language="JavaScript" src="../js/ResultEntry.js"></script>
<script language="JavaScript">
<!--
function operatelayer(id)
{
	obj = eval('document.getElementById("layer_")'+id);
	sign = eval('document.getElementById("sign_")'+id);
	if(obj.style.position=='absolute')
	{
		sign.innerHTML = '<font size="1"><a class="gridLink" href="javascript:operatelayer('+id+')">[-]</a></font>';
		obj.style.position = 'relative';
		setTimeout('func()',1);
	}
	else
	{
		sign.innerHTML = '<font size="1"><a class="gridLink" href="javascript:operatelayer('+id+')">[+]</a></font>';
		obj.style.position = 'absolute';
		obj.style.visibility = 'hidden';
	}
}

function func()
{
	obj.style.visibility = 'visible';
}
//-->
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<style type='text/css'> </style>
</head>
<body style='background-color:#E2E3F0;'  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<%
	
	 String task_type = request.getParameter("colval1");
	 String orderId = request.getParameter("orderId");
	// String colval = request.getParameter("colval");
	 String patient_id = request.getParameter("patient_id");
	 String encounter_id = request.getParameter("encounter_id");
	 String requestFrom = request.getParameter("requestFrom");
	 String report_srl_no = request.getParameter("report_srl_no");
	 String order_category = request.getParameter("order_category");
//	 String resultReportingURL = request.getQueryString();
	 if(requestFrom==null)	requestFrom="";
	 if(report_srl_no==null)	report_srl_no="";
	 if (order_category==null)	order_category="";
	 StringBuffer qryStr = new StringBuffer();
	 qryStr.append("&"+request.getQueryString());
	 
	 if(requestFrom.trim().equalsIgnoreCase("RA"))
		qryStr.append( "&task_type=ResultEntry"+"&report_srl_no="+report_srl_no+"&requestFrom="+requestFrom+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&order_category="+order_category+"&parent_order_id="+orderId);
	 else	qryStr.append( "&task_type="+task_type+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&order_category="+order_category+"&parent_order_id="+orderId);
	 String option_id = request.getParameter("option_id");
	 if (option_id==null) option_id="";
	/* Mandatory checks start */
	String mode	= "1";//request.getParameter( "mode" ) ;
//	String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Oh_ResultEntry" ;
	String bean_name = "eOH.ResultEntryBean";

/* Mandatory checks end */

	/* Initialize Function specific start */
	ResultEntryBean bean = (ResultEntryBean)getBeanObject( bean_id, bean_name , request) ;
	bean.setLanguageId(localeName);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.clear() ;
	bean.setMode( mode ) ;
	/* Initialize Function specific end */

	ArrayList orders = new ArrayList();
	orders = bean.getFreqExplOrders(orderId);
	int totalrecs = orders.size();
%>
<form name='result_entry_frequency' id='result_entry_frequency'>
<input type='hidden' name='totalrecs' id='totalrecs' value='<%=totalrecs%>'>
<input type='hidden' name='option_id' id='option_id' value='<%=option_id%>'>
</form>
<table cellpadding=3 cellspacing=0 border=0 width="100%">
	<tr>
		<td class=columnheadercenter colspan='2'><fmt:message key="Common.Orders.label" bundle="${common_labels}"/></td>
	</tr>
	<%
	String prevRecDate = "";

	for (int i=1; i<=totalrecs; i++)
	{
		String record[] = {"","","","",""};
		record = (String[])orders.get(i-1);
		String date = "";
		String time = "";
		
		try{
			date = record[1].trim().substring(0,10);
			time = record[1].trim().substring(11,16);
		}catch(Exception ex){}
		String qryStr1 = "orderId="+record[0]+qryStr;
		String colorCode = "";
		if(record[3].equalsIgnoreCase("yellow"))
			colorCode = "#FFFF00";
		else if(record[3].equalsIgnoreCase("red"))
			colorCode = "#FF0000";
		else if(record[3].equalsIgnoreCase("brown"))
			colorCode = "#A52A2A";
		else if(record[3].equalsIgnoreCase("purple"))
			colorCode = "#9370DB";
		else if(record[3].equalsIgnoreCase("green"))
			colorCode = "#90EE90";
		else if(record[3].equalsIgnoreCase("gray"))
			colorCode = "#808080";
		else if(record[3].equalsIgnoreCase("silver"))
			colorCode = "#C0C0C0";
		else if(record[3].equalsIgnoreCase("N"))	// No Color
			colorCode = "#E2E3F0";
		else	// No Color
			colorCode = "#E2E3F0";

		if(!prevRecDate.equals(date) && !date.equals(""))
		{
			prevRecDate = date;
			if(i > 1){//Don't Close for First time
	%>		 	</table><!--Close Prev Tablr  -->
				</div>
				</td></tr> <!--Close  Parent Td and Tr  -->
			<%}%>

		<tr>  <!-- Start new Tr for parent -->
		  <td id='sign_<%=i%>'><font size='1'><a class='gridLink' href="javascript:operatelayer('<%=i%>')">[+]</a></font></td>

		  <!-- Show Order date -->
		  <td><font size='1'><%=com.ehis.util.DateUtils.convertDate(date,"DMY","en",localeName)%></font></td>
		</tr><!-- tr Closed -->

		<!-- Show all the timings of the Order -->
		<tr><td colspan='2'>

		<div id="layer_<%=i%>" style="visibility:hidden;position:absolute">
		<!-- Table to show all the timings -->
			<table cellpadding=3 cellspacing=0 border=0 width="100%">
		<%}%>

		 <!--child tr to show all the timings -->
		<tr>
			<td width='20'>

			<!-- Show the Color Bar against the timings -->
			<table cellpadding=3 cellspacing=0 border=0 width="100%">
					<tr></tr>
					<tr>
						<td>&nbsp;</td><td style='background-color:<%=colorCode%>'>&nbsp;</td>
					</tr>
					<tr></tr>
			</table>
			</td>

			<!-- Show time -->
			<td id='row_<%=i%>'><font size='1'>
			<%if(record[2].equalsIgnoreCase("Y")){%>
				<a class='gridLink' href="javascript:showChildOrder('<%=qryStr1%>','<%=i%>','<%=record[4]%>','<%=record[1]%>','<%=record[5]%>')" onmouseover="showMouseOverEffect('<%=i%>')" onmouseout="showMouseOutEffect('<%=i%>')"><%=time%></a>
			<%}else{%>
				<%=time%>
			<%}%>
			</font>
			</td>
		</tr>
	<%	if(i==totalrecs)
			{
	%>
		</table>
		</div>
		</td></tr>
			<%}%>
	<%}//iterate all records%>
</table>
</body>
</html>
<%
putObjectInBean(bean_id,bean,request);
%>


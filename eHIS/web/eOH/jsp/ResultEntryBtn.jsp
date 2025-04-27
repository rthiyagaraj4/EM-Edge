<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8"%>
<%-- JSP Page specific attributes start --%>
<%@page  import="eOH.* " %>
<%-- JSP Page specific attributes end --%>


<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
	 String resultReportingURL = request.getQueryString();
	
	 String requestFrom = request.getParameter("requestFrom");
	 if(requestFrom==null) requestFrom="";
	 String freqExplApplies = request.getParameter("freqExplApplies");
	 if(freqExplApplies==null) freqExplApplies="";
	 String showRecordButtonStr = request.getParameter("showRecordButton");
	 if(showRecordButtonStr==null) showRecordButtonStr="";
	 String orderId = request.getParameter("orderId");
	  if(orderId==null) orderId="";
	 String option_id = request.getParameter("option_id");
	  if(option_id==null) option_id="";
	 String parent_order_id = request.getParameter("parent_order_id")==null?"":request.getParameter("parent_order_id");
	String header_values = request.getParameter("header_values");
//out.println("<script>alert('mode:button:"+request.getParameter("mode")+"===')</script>");
//out.println("<script>alert('showRecordButton:button:"+showRecordButtonStr+"===')</script>");
//out.println("<script>alert('resultReportingURL:top:"+resultReportingURL+"===')</script>");
//out.println("<script>alert('parent_order_id:button:"+request.getParameter("parent_order_id");+"===')</script>");


	 if(option_id == null)
	 {
		option_id = "";		 //i:e Not through CA0.
	 }

	 if(requestFrom==null)	requestFrom="";
	 if(freqExplApplies==null)	freqExplApplies="";
	 boolean showRecordButton = true;	// the record button is not to be shown when there is no order.
	 if(showRecordButtonStr!=null && showRecordButtonStr.equalsIgnoreCase("N"))
		showRecordButton = false;
	//out.println("<script>alert('showRecordButton:1111button:"+showRecordButton+"===')</script>");

	/* Mandatory checks start */
	String mode	= "1";//request.getParameter( "mode" ) ;
	//String function_id = request.getParameter( "function_id" ) ;
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

	String[] resportsrlno = bean.getReportSrlNo(orderId);

	if(resportsrlno[0].equals("1") && resportsrlno[1].equals("3") && !requestFrom.equals("RA"))
		showRecordButton = false;

//out.println("<script>alert('showRecordButton:button:"+showRecordButton+"===')</script>");
	int format_count= bean.getFormatCount(parent_order_id, "LINE") ; //Pass the order_id and the line no is null
%>


<html>
<head>

<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel='StyleSheet' href='../../eCommon/html/grid.css' type='text/css'/>
 	<script language="JavaScript" src="../js/ResultEntry.js"></script>

	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<!--style='background-color:#E2E3F0;'  -->
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<form name='result_entry_btn' id='result_entry_btn' target='messageFrame' >
<table cellpadding=3 cellspacing=0 border=0 width="100%" height="100%" align='center'>
<%--<Script>alert('showRecordButtonStr=<%=showRecordButtonStr%>,resportsrlno[0]=<%=resportsrlno[0]%>,resportsrlno[1]=<%=resportsrlno[1]%>,requestFrom=<%=requestFrom%>')</Script>--%>
	<tr>
		<%if(freqExplApplies.equalsIgnoreCase("Y")){%>
			<td width='2'>
				<table cellpadding=3 cellspacing=0 border=0 width="100%"> 
					<tr></tr>
					<tr>
					<td style='background-color:#FFFF00'>&nbsp;</td>
					</tr>
					<tr></tr>
				</table>
			</td>
			<td width='71' class='label' align=left>
			<font size=1><fmt:message key="eOR.FutureOrder.label" bundle="${or_labels}"/></font>
			</td>
			<td width='2'>
				<table cellpadding=3 cellspacing=0 border=0 width="100%">
					<tr></tr>
					<tr>
						<td style='background-color:#FF0000'>&nbsp;</td>
					</tr>
					<tr></tr>
				</table>
			</td>
			<td width='78' class='label'>
			<font size=1><fmt:message key="eOR.ElapsedOrder.label" bundle="${or_labels}"/></font>
			</td>
			<td width='2'>
				<table cellpadding=3 cellspacing=0 border=0 width="100%">
					<tr></tr>
					<tr>
						<td style='background-color:#A52A2A'>&nbsp;</td>
					</tr>
					<tr></tr>
				</table>
			</td>
			<td width='52' class='label'>
			<font size=1><fmt:message key="Common.Abnormal.label" bundle="${common_labels}"/></font>
			</td>
			<td width='2'>
				<table cellpadding=3 cellspacing=0 border=0 width="100%">
					<tr></tr>
					<tr>
						<td style='background-color:#C0C0C0'>&nbsp;</td>
					</tr>
					<tr></tr>
				</table>
			</td>
			<td width='66' class='label'>
			<font size=1><fmt:message key="eOR.ResultedP.label" bundle="${or_labels}"/></font>
			</td>
			<td width='2'>
				<table cellpadding=3 cellspacing=0 border=0 width="100%">
					<tr></tr>
					<tr>
						<td style='background-color:#90EE90'>&nbsp;</td>
					</tr>
					<tr></tr>
				</table>
			</td>
			<td width='50' class='label'>
			<font size=1><fmt:message key="eOR.Resulted.label" bundle="${or_labels}"/></font>
			</td>
			<td width='2'>
				<table cellpadding=3 cellspacing=0 border=0 width="100%">
					<tr></tr>
					<tr>
						<td style='background-color:#9370DB'>&nbsp;</td>
					</tr>
					<tr></tr>
					</table>
			</td>
			<td width='70' class='label'>
			<font size=1><fmt:message key="eOR.AbnormalP.label" bundle="${or_labels}"/></font>
			</td>
			<td width='2'>
				<table cellpadding=3 cellspacing=0 border=0 width="100%">
					<tr></tr>
					<tr>
						<td style='background-color:#808080'>&nbsp;</td>
					</tr>
					<tr></tr>
					</table>
			</td>
			<td width='100' class='label' align=left>
			<font size=1><fmt:message key="eOR.PartiallyResulted.label" bundle="${or_labels}"/></font>
			</td>
		<%
		}
		else 
		{
		%>
			<td width='69%' class='label'></td>
		<% 
		} 
		%>
		<%		
		if(format_count!=0)
		{
		%>
		<td  class='label'>
			<a class='gridLink' href='javascript:viewOrderFormatLineDtl("<%=parent_order_id%>")' title='Order Format'>
				<img src='../../eOR/images/Flex_blue.gif' align='center'></img>
			</a>
		</td>
		<%
		}	
		%>
		

		<td  class='' id='proc_link_buttons' width="10%"><!-- proc_link -->
		<input id="proc_link" style="visibility:hidden" name='ProcLink' id='ProcLink' type="button" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ProcedureLink.label","or_labels")%>' class='button' onClick='callProcLink()' ></td>
		<td  class='button' id='id_buttons' width="10%"><%if(showRecordButton){%><INPUT name='record' id='record' TYPE="button" value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>' class='button' onClick='recordResultEntry("<%=resultReportingURL%>","<%=freqExplApplies%>")'><%}%><INPUT name='cancel' id='cancel' TYPE="button" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' class='button' onClick='returnToResultReporting("<%=resultReportingURL%>","<%=freqExplApplies%>");'></td>
	</tr>
	<input type="hidden" name="option_id" id="option_id" value="<%=option_id%>">
	<input type="hidden" name="resultReportingURL" id="resultReportingURL" value="<%=resultReportingURL%>">
	<input type="hidden" name="freqExplApplies" id="freqExplApplies" value="<%=freqExplApplies%>">
	<input type="hidden" name="header_values" id="header_values" value="<%=header_values%>">
	<input type="hidden" name="from" id="from" value='<%=request.getParameter("from")%>'>

</table>
	
</form>
</body>
</html>
<%
putObjectInBean(bean_id,bean,request);
%>


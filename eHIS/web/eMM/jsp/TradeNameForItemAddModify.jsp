<!DOCTYPE html>
<%@page import=" eMM.*,eMM.Common.*,java.util.*,java.sql.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %> 
<jsp:useBean id="obj"   scope="page" class="webbeans.eCommon.XMLStringParser"/>
<jsp:useBean id="alTradeNameForItemList" scope="session" class="java.util.ArrayList" />
<jsp:useBean id="TradeNameForItemBean" scope="page" class="eMM.TradeNameForItemBean" />
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title> </title>
<!-- 		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link>
 -->	<% 
		 request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		//locale ="en";
//		String primary_lang		= (String)session.getAttribute("PRIMARY_LANG");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
<script language="JavaScript" src="../../eMM/js/TradeNameForItem.js"></script>	
		<script language="JavaScript" src="../../eMM/js/MmCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
	</head>
<%
	TradeNameForItemBean bean = (TradeNameForItemBean)getBeanObject( "TradeNameForItemBean", "eMM.TradeNameForItemBean",request ) ;  	
	bean.setLanguageId(locale);
	HashMap hmRecord			=	new HashMap();
	String className			=	"";
	String bean_id				=	"";
	String bean_name			=	"";
	String mode					=	"";
	int	i						=	0;	
	//int noOfRecords				=	alTradeNameForItemList.size();
//	int start					=	0;
//	int end						=	noOfRecords;
	bean_id = "TradeNameForItemBean" ;
	bean_name = "eMM.TradeNameForItemBean";

	/* Mandatory checks start */

	mode	= request.getParameter( "mode" )==null?"":  request.getParameter( "mode" );	
	if ( mode == null || mode.equals("") ) {
		return ;
	}
	if ( !(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )) ) {
		return ;
	}
%>
	<body >
	<form name="formTradeNameForItemAddModify" id="formTradeNameForItemAddModify">	
	<table border='1' cellpadding='0' cellspacing='0' width='100%'  align=center>
<%	
	if(alTradeNameForItemList != null && alTradeNameForItemList.size() >0) {		
%>
	<tr>
		<th width='6%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
		<th width='44%'><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/></th>
		<th width='50%'><fmt:message key="Common.Manufacturer.label" bundle="${common_labels}"/></th>
	</tr>
<%	
	bean.setTradeNameForItemList(alTradeNameForItemList);
	for	(i	=0;	i<alTradeNameForItemList.size();i++) {
		hmRecord	=(HashMap)	alTradeNameForItemList.get(i);
		className	=	((i%2)==0)?"QRYODD":"QRYEVEN";
%>
	<tr>
<%
	if((hmRecord.get("MODE").toString()).equals("1")) {
%>
		<td class="<%=className%>">
			<input type='checkbox' name="checkbox<%=i%>" id="checkbox<%=i%>" value="Y" checked onClick="assignFlag(<%=i%>);"> 
		</td>

		<td class="<%=className%>">
			<%=hmRecord.get("TRADE_NAME")%>
		</td>
<%
		if(hmRecord.get("MANUFACTURER_NAME") == null) {
			
%>
		<td class="<%=className%>"> 
			&nbsp;&nbsp;
		</td>
<%
		}
		else {
%>

		<td class="<%=className%>"> 
			<%=hmRecord.get("MANUFACTURER_NAME")%> 
		</td>
<%
		}
	}
	else {
%>
		<td class="<%=className%>">
			<input type='checkbox' name="checkbox<%=i%>" id="checkbox<%=i%>" disabled> 
		</td>
		<td class="<%=className%>">
			<font color=#FF5400 style="font-weight:500"><%=hmRecord.get("TRADE_NAME")%></font>	
		</td>
<%
		if (hmRecord.get("MANUFACTURER_NAME") == null) {
%>
			<td class="<%=className%>"> 
				&nbsp;&nbsp;
			</td>
<%
		}
		else {	
%>
			<td class="<%=className%>"> 
				<font color=#FF5400 style="font-weight:500"><%=hmRecord.get("MANUFACTURER_NAME")%> </font>	
			</td>
<%
		}
	}
%>
	</tr>
<%
	}
}

%>
	</table>
	<input type="hidden" name="total_checkboxes" id="total_checkboxes" value="<%=i%>">
	<input type="hidden" name="mode" id="mode" value="<%=request.getParameter("mode")%>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
	<input type="hidden" name="item_code" id="item_code" value="">
	<input type="hidden" name="trade_id" id="trade_id" value="">
	<%
putObjectInBean("TradeNameForItemBean",bean,request);
%>
	</form>
</body>
</html>


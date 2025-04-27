<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page import=" eMM.*,eMM.Common.* , eCommon.Common.*, java.text.*, java.util.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="obj"   scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>  
<jsp:useBean id="alTradeNameForItemList" scope="session" class="java.util.ArrayList"/>
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
<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eOR/js/OrCommonLookup.js"></script>
		<!-- <script language="javascript" src="../../eCommon/js/messages.js"></script> -->
		<script language="javascript" src="../../eMM/js/TradeNameForItem.js"></script>
		<script language="javascript" src="../../eMM/js/MmCommon.js"></script>
		<!-- <script language="javascript" src="../../eMM/js/MmMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
	</head>
<%
	TradeNameForItemBean bean = (TradeNameForItemBean)getBeanObject( "tradeNameForItemBean","eMM.TradeNameForItemBean",request);  
		bean.setLanguageId(locale);
	String index			= bean.checkForNull(request.getParameter("index"),"-1");
	//String strButtonLegend	=	"  Add  ";
	String strButtonLegend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels");
	String mode				=	index.equals("-1")? eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") :eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY");
	String disabled			=	"";
	String codeDisabled		=	"";
	if(mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
		bean.initialize((HashMap)alTradeNameForItemList.get(Integer.parseInt(index)));
		//strButtonLegend	="Modify";
		 strButtonLegend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels");
		codeDisabled="disabled";
	}
%>

	<body>
		<form name="formTradeNameForItemDetail" id="formTradeNameForItemDetail">
			<table border="0" cellpadding="0" cellspacing="0" width='100%'  height='100%' align=center>
			<tr>
			<td width='100%' height='100%'  >
			<table border="0" cellpadding="1" cellspacing="0" width='100%' align=center>
				<tr>
					<td  class="label" width = '30%'>
						<fmt:message key="Common.TradeName.label" bundle="${common_labels}"/>&nbsp;&nbsp;
					</td>
					<td class=fields width='70%' >
						&nbsp;
						<input type='text' name="trade_name" id="trade_name" value="<%=bean.getTrade_name()%>" maxLength='60' size='40' <%=disabled%> <%=codeDisabled%> ><input type='button' class='BUTTON' value='?' onClick="searchTradeItem(trade_id, trade_name);" <%=disabled%> <%=codeDisabled%>>	

						<img src="../../eCommon/images/mandatory.gif" align='center'>
						</img>

						<input type="hidden" name="trade_id" id="trade_id" value="<%=bean.getTrade_id()%>">
						&nbsp;&nbsp;&nbsp;<input type='button' class='BUTTON' name="apply" id="apply" onClick="addToList();" value="<%=strButtonLegend%>" <%=disabled%>>
						<input type='button' class='BUTTON' name="cancel" id="cancel" onClick="document.location.href='../../eMM/jsp/TradeNameForItemDetail.jsp';" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' <%=disabled%>>	
					</td>						

					<!--	<span id ="span_manufacturer" class="label">
						</span> -->

						<input type='hidden' name="manufacturer_name" id="manufacturer_name" value="<%=bean.getManufacturer_name()%>" maxLength='40' size='40'>		
						<input type='hidden' name="manufacturer_id" id="manufacturer_id" value="<%=bean.getManufacturer_id() %>" maxLength='40' size='20'>		

				</tr>				

				<tr>
					<td > 
					</td>

					<td  class="fields" colspan='2'>
						<!-- <input type='button' class='BUTTON' name="apply" id="apply" onClick="addToList();" value="<%=strButtonLegend%>" <%=disabled%>>
						<input type='button' class='BUTTON' name="cancel" id="cancel" onClick="document.location.href='../../eMM/jsp/TradeNameForItemDetail.jsp';" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' <%=disabled%>>	 -->				
					</td>
				</tr>
				
			</table>
			</td>
			</tr>
			</table>
			<input type='hidden' name="index" id="index" value="<%=index%>">
			<input type='hidden' name="p_language_id" id="p_language_id" value="<%=locale%>">

			<input type="hidden" name="SQL_AM_TRADE_NAME_LOOKUP" id="SQL_AM_TRADE_NAME_LOOKUP" value="<%= bean.getMmRepositoryValue("SQL_AM_TRADE_NAME_LOOKUP")%>">
			<%
putObjectInBean("tradeNameForItemBean",bean,request);
%>
		</form>
	</body>
</html>


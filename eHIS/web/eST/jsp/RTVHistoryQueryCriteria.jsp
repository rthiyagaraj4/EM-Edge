<!DOCTYPE html>
<%@ page import ="eST.*, eST.Common.* , eCommon.Common.*,webbeans.eCommon.*,java.sql.*,java.util.*,java.lang.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");

String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' 
type='text/css' ></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<!-- 	<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
<!-- 	<script language="javascript" src="../../eST/js/STMessages.js"></script> -->
	<script language="javascript" src="../../eST/js/StTransaction.js"></script>
	<script language="javascript" src="../../eST/js/RTVHistory.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<% 
	
	String bean_id = "RTVHistoryBean";
	String bean_name = "eST.RTVHistoryBean";
	String rdonly="";
	RTVHistoryBean bean = (RTVHistoryBean) getBeanObject( bean_id,bean_name,request );
	bean.setLanguageId(locale);
%>
<body onload='FocusFirstElement();' topmargin = 0 >
	<form name="formRTVHistoryQueryCriteria" id="formRTVHistoryQueryCriteria" >
		<table border="0" cellpadding="0" cellspacing="0" width='100%'  align="center" >
		<tr>
			<table border="0" cellpadding="0" cellspacing="0" width='100%' align="center">	
			<td class=label align=rigth colspan = 5>&nbsp;&nbsp;&nbsp;&nbsp;
			<fmt:message key="Common.item.label" bundle="${common_labels}"/>&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;<input type=text name=item_desc size=40 maxlength=40 value="" <%=rdonly%> >
				<input type=hidden name="item_code" id="item_code" value="">
				<input type='button' class='BUTTON' value='?' onClick='callItemSearchScreen(item_code,item_desc);' name="item_search" id="item_search">
				<label  id= 'id_Highlight' ></label></td>
			</td>
		<tr>
			<td class="label">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.Supplier.label" bundle="${common_labels}"/>
			<select name="supplier" id="supplier"><%=bean.getSupplierList()%></select>	</td>
			<td class="label" align="right"><fmt:message key="Common.Finalized.label" bundle="${common_labels}"/> &nbsp; </td>
			<td class="label" ><select name="finalized_yn" id="finalized_yn">	<option value="A" ><fmt:message key="Common.all.label" bundle="${common_labels}"/></option><option value="Y" ><fmt:message key="Common.Finalized.label" bundle="${common_labels}"/></option><option value="N" ><fmt:message key="Common.UnFinalized.label" bundle="${common_labels}"/></option></select></td>
			<td class=label align=right>
			<fmt:message key="Common.DateFrom.label" bundle="${common_labels}"/>&nbsp;<input type='text' name='FM_DATE' id='FM_DATE' size=10 maxlength=10 class="DATE" value="" onBlur="CheckDate(this);" ><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('FM_DATE');" ></img>&nbsp;&nbsp;<fmt:message key="Common.todate.label" bundle="${common_labels}"/>&nbsp;<input type=text name='TO_DATE' id='TO_DATE' size=10 maxlength=10 class="DATE" value="" onBlur="CheckDate(this);" >
			<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('TO_DATE');" ></img>
			&nbsp;&nbsp;&nbsp;&nbsp;</td>
			<td class="label"></td>
		</tr>			
		<tr>
			<td class="label">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.Store.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name="store" id="store"><%=bean.getStore_code_List()%>	</select></td>
			<td class="label" align = right > <fmt:message key="eST.RTVforReplacement.label" bundle="${st_labels}"/>&nbsp;&nbsp; </td>
			<td class="label" ><select name="repl_rtv" id="repl_rtv">	
			<option value="A" >	<fmt:message key="Common.all.label" bundle="${common_labels}"/></option>	
			<option value="Y" ><fmt:message key="Common.yes.label" bundle="${common_labels}"/></option>	
			<option value="N" ><fmt:message key="Common.no.label" bundle="${common_labels}"/></option>
			</select></td>
			<td></td><td class=label></td>
			<table border="0" cellpadding="0" cellspacing="0" width='100%'  >
				<tr>
					<td  align='right' colspan='4'>
						<input type='button'  class='BUTTON' name='previous' id='previous' value='<fmt:message key="Common.previous.label" bundle="${common_labels}"/>' disabled onClick='goPrev();'><input type='button' class='BUTTON' name='next' id='next' value='<fmt:message key="Common.next.label" bundle="${common_labels}"/>' onClick='goNext();' disabled><input type='button' class='BUTTON' name='search' id='search' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick='searchVals();'>
					</td>
				</tr>
			</table>
		</tr>
		</table>	
	 
</form>
<%
putObjectInBean(bean_id,bean,request);
%>
</body>
</html>


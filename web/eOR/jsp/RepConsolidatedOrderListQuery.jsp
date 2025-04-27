<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<html>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>

	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../js/OrCommonFunction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
 <body  onload='FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	//String readOnly = "" ;
	//String checked = "checked" ;
	/* Mandatory checks start */
	String mode	   = request.getParameter( "mode" ) ;
	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_AccessionNumberRules" ;
	String bean_name = "eOR.AccessionNumberRules";
	//String disabled = "" ;
	ArrayList Category_Data = new ArrayList();
	//ArrayList OrderType_Data = new ArrayList();



/* Mandatory checks end */
	
	/* Initialize Function specific start */
	AccessionNumberRules bean = (AccessionNumberRules)getBeanObject( bean_id,  bean_name, request ) ; 

	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
 
	bean.clear() ;
	bean.setMode( mode ) ;
%>
<BR><BR><BR><BR><BR><BR>
<form name='RepConsolidatedOrderList' id='RepConsolidatedOrderList' target='messageFrame' >
<table cellpadding=0 cellspacing=0 border=0 width="98%" align=center>
	<tr>
		<td colspan="4">&nbsp;</td>
	</tr>
	<tr>
		<td colspan="4" class="label"><B>not written any java files...yet to write</B></td>
	</tr>
	<tr>
		<td width="35%"  align=right class="label">Order Category&nbsp;</td>
		<td colspan="3" >&nbsp;
			<SELECT name="order_category" id="order_category">
			<option value=''>&nbsp;&nbsp;&nbsp;--- Select ---&nbsp;&nbsp;&nbsp;
		<%
			try{
				Category_Data = bean.getAllOrderCategory();

				for(int i=0; i<Category_Data.size(); i++){
					String[] record = (String [])Category_Data.get(i);
			
		%>
				<option value=<%=record[0]%>><%=record[1]%>
		<%	
				}
			}catch(Exception e){
			//	out.println(e);//COMMON-ICN-0181
                              e.printStackTrace();//COMMON-ICN-0181
			}
		%>
			</SELECT>&nbsp;<img src="../../eCommon/images/mandatory.gif">&nbsp;</td>

		</td>
	</tr>
	<tr>
		<td class=label align='right'>Order Date From</td>
		<td>&nbsp;
		<input type="text" name="date_from" id="date_from" value="" size="10" maxlength="10" onBlur="CheckDate(this)" onKeyPress='return OrAllowDateFormat()'>&nbsp;<img src="../../eCommon/images/mandatory.gif">&nbsp;</td>
		<td class=label align='right'>To</td>
		<td>&nbsp;
		<input type=text name='date_to' id='date_to' value='' size=10 maxlength=10 onBlur='checkDateRange(this)' onKeyPress='return OrAllowDateFormat()'>&nbsp;<img src="../../eCommon/images/mandatory.gif">&nbsp;</td>
	</tr>
	<tr>
		<td class=label align='right'>Order Status From</td>
		<td>&nbsp;
			<SELECT name="order_status_from" id="order_status_from">
			<option value=''>&nbsp;&nbsp;&nbsp;--- Select ---&nbsp;&nbsp;&nbsp;
			<option value=''>outstanding
			<option value=''>Registered
			</SELECT></td>

		</td>
		<td class=label align='right'>To</td>
		<td>&nbsp;
			<SELECT name="order_status_to" id="order_status_to">
			<option value=''>&nbsp;&nbsp;&nbsp;--- Select ---&nbsp;&nbsp;&nbsp;
			<option value=''>outstanding
			<option value=''>Registered
			</SELECT></td>

		</td>
	</tr>
	<tr>
		<td colspan="4">&nbsp;</td>
	</tr>
</table>
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">

</form>

</body>
</html>

<%
		putObjectInBean(bean_id,bean,request);
 
%>


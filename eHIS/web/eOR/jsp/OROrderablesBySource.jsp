<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.*, eOR.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<HTML>   
<HEAD>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>

	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>

	<SCRIPT LANGUAGE="javascript" SRC="../js/OrderablesBySource.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<!--<iframe name="orderCategoryFrame" id="orderCategoryFrame" SCROLLING="YES" FRAMEBORDER="0" NORESIZE SRC="OROrderablesBySourceCategory.jsp" style="height:13vh;width:100vw"></iframe><iframe name="orderTypeFrame" id="orderTypeFrame" SCROLLING="YES" FRAMEBORDER="0" NORESIZE SRC="OROrderablesBySourceType.jsp" style="height:18vh;width:100vw"></iframe><iframe name="orderCodeFrame" id="orderCodeFrame" SCROLLING="YES" FRAMEBORDER="0" NORESIZE SRC="OROrderablesBySourceCode.jsp" style="height:18vh;width:100vw"></iframe><iframe name="blankFrame" id="blankFrame" SCROLLING="NO" FRAMEBORDER="0" NORESIZE SRC="../../eCommon/html/blank.html" style="height:86vh;width:100vw"></iframe> -->
</HEAD>
<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<%
	Calendar calendar = new GregorianCalendar();
	String month = String.valueOf(calendar.get(Calendar.MONTH) + 1);
	int mon = Integer.parseInt(month);
	if(mon<10)
		month = "0"+month;
	String year = String.valueOf(calendar.get(Calendar.YEAR));
	String date = month + "/" + year;


	/* Mandatory checks start */
	String bean_id = "OROrderablesBySourceBean" ;
	String bean_name = "eOR.OROrderablesBySourceBean";

	/* Initialize Function specific start */
	OROrderablesBySourceBean bean = (OROrderablesBySourceBean)getBeanObject( bean_id, bean_name, request ) ;
	
	ArrayList masterList = bean.getCategoryList();

	Vector order_category = (Vector )masterList.get(0);
	Vector short_desc_category = (Vector )masterList.get(1);
%>
	<form name="frmOrderablesBySource" id="frmOrderablesBySource" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame">
	
	<br><br><br><br><br><br><br>

		<TABLE WIDTH="70%" ALIGN="center" CELLPADDING="0" CELLSPACING="0" BORDER="0">
			<TR>
			<TD COLSPAN="3">&nbsp</TD>
		</TR>
		<TR>
			<TD ALIGN="right" WIDTH="30%" CLASS="label">Order Category &nbsp</TD>
			<TD ALIGN="left" WIDTH="25%">
				<select name="p_order_category" id="p_order_category" onchange="javascript:OrderCategoryDesc()">
				<option value=""> All </option>
				<%
				for(int i=0;i<short_desc_category.size();i++)
				{
				%>
				<option value='<%= (String )order_category.get(i) %>'><%= (String )short_desc_category.get(i) %></option>
				<%
				}
				%>
				</select>
			</TD>
			<TD ALIGN="left" WIDTH="45%">
			</TD>
		</TR>
		<TR>
			<TD COLSPAN="3">&nbsp</TD>
		</TR>
		<TR>
			<TD WIDTH="30%">&nbsp</TD>
			<TD CLASS="label" ALIGN="left" WIDTH="25%">From</TD>
			<TD CLASS="label" ALIGN="left" WIDTH="45%">&nbsp To</TD>
		</TR>
<%
	String str_order_category = "";
	ArrayList orderList = bean.getOrderTypeList(str_order_category);	
	Vector order_type_code = (Vector)orderList.get(0);
	Vector short_desc_type = (Vector)orderList.get(1);
%>
		<TR>
			<TD ALIGN="right" WIDTH="30%" CLASS="label">Order Type &nbsp</TD>
			<TD ALIGN="left" WIDTH="25%">
				<select name="p_fr_order_type_code" id="p_fr_order_type_code" onchange="">
				<option value=""> All </option>
				<%
				for(int i=0;i<short_desc_type.size();i++)
				{
					%>
					<option value='<%= (String)order_type_code.get(i) %>'><%= (String )short_desc_type.get(i) %></option>
					<%
				}
				%>
				</select>
			</TD>
			<TD ALIGN="left" WIDTH="45%">&nbsp
				<select name="p_to_order_type_code" id="p_to_order_type_code" onchange="">
				<option value=""> All </option>
				<%
				for(int i=0;i<short_desc_type.size();i++)
				{
					%>
					<option value='<%= (String )order_type_code.get(i) %>'><%= (String )short_desc_type.get(i) %></option>
					<%
				}
				%>
				</select>
			</TD>
		</TR>
		<TR>
			<TD COLSPAN="3">&nbsp</TD>
		</TR>
		<TR>
			<TD ALIGN="right" WIDTH="30%" CLASS="label">Source Type &nbsp</TD>
			<TD ALIGN="left" WIDTH="25%">
				<select name="p_source_type" id="p_source_type" onchange="javascript:OrderCode()">
						<option value=""> ---Select---</option>
						<option value="C"> Clinic</option>
						<option value="N"> Nursing Unit</option>
				</select>&nbsp;<img src="../../eCommon/images/mandatory.gif" ></img>
			</TD>
			<TD ALIGN="left" WIDTH="45%">
				
			</TD>
		</TR>
		<TR>
			<TD COLSPAN="3">&nbsp</TD>
		</TR>
		<TR>
			<TD ALIGN="right" WIDTH="30%" CLASS="label">Source Code &nbsp</TD>
			<TD ALIGN="left" WIDTH="25%">
				<select size="1" name="p_fr_source_code" id="p_fr_source_code" onchange="">
					<option value=""> All</option>
				</select>
			</TD>
			<TD ALIGN="left" WIDTH="45%">&nbsp
				<select size="1" name="p_to_source_code" id="p_to_source_code" onchange="">
					<option value=""> All</option>
				</select>
			</TD>
		</TR>
		<TR>
			<TD COLSPAN="3">&nbsp;</TD>
		</TR>
		<TR>
			<TD ALIGN="right" WIDTH="30%" CLASS="label">Period &nbsp</TD>
			<TD ALIGN="left" WIDTH="25%">
				<input type=text name="p_fr_date" id="p_fr_date" size=6 maxlength=7 onKeyPress='return CheckForSpecChars(event)' onblur="javascript:checkDate(this)"
				value="<%= date %>" > 
				<img src="../../eCommon/images/mandatory.gif"></img>
			</TD>
			<TD ALIGN="left" WIDTH="45%">&nbsp
				<input type=text name="p_to_date" id="p_to_date" size=6 maxlength=7 onKeyPress='return CheckForSpecChars(event)' onblur="javascript:checkDate(this)"
				value="<%= date %>" >
				<img src="../../eCommon/images/mandatory.gif"></img>
			</TD>
		</TR>
		<TR>
			<TD COLSPAN="3">&nbsp</TD>
		</TR>
		</TABLE>
		<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
		<input type="hidden" name="p_module_id" id="p_module_id" value="OR">
		<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%= (String)session.getValue("facility_id")%>">
		<input type="hidden" name="p_report_id" id="p_report_id" value="ORRORSOU">
		<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=localeName%>">

	</form>
</body>
</html>

<%
		putObjectInBean(bean_id,bean,request);
 
%>


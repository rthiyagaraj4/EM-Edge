<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*"   contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
 <jsp:useBean id="bean" scope="page" class="eOR.ExistingOrder"/>
<%-- Mandatory declarations end --%>

<html>
<head>
	<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/PendingOrderStatusForDischarge.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
</HEAD> 
<BODY>
	<%
	String bean_id 		= "@existingorderbean";
	String bean_name	= "eOR.ExistingOrder";
	bean.setLanguageId(localeName);
	Properties properties	= (Properties) session.getValue( "jdbc" );
	ArrayList Category_Data = new ArrayList();
	Category_Data = bean.getAllOrderCategory(properties);
	String[] record = null;
	for(int i=0; i<Category_Data.size(); i++)
	{
		record = (String [])Category_Data.get(i);
	}
	%>
	<FORM name='pend_ord_status_cat' id='pend_ord_status_cat' target='messageFrame'>
		<TABLE>
			<TR>
				<td class=label  ><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></td>
				<td class="fields">
					<SELECT name="order_category" id="order_category" onChange="populateValues();">
						<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---
						<%
						try
						{

							for(int i=0; i<Category_Data.size(); i++)
							{
								record = (String [])Category_Data.get(i);
								%>
								<option value=<%=record[0]%>><%=record[1]%>
								<%
							}
						}
						catch(Exception e)
						{
							//out.println(e);//COMMON-ICN-0181
							e.printStackTrace();//COMMON-ICN-0181
						}
						%>
					</SELECT><img src="../../eCommon/images/mandatory.gif" ></img>
				</td>
			</TR>
		</TABLE>
		<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
		<input type='hidden' name='localeName' id='localeName' value='<%=localeName%>'>
		<!--<input type='hidden' name='order_category' id='order_category' value='<%=record[0]%>'>-->
	</FORM>
	
</BODY>
</HTML>


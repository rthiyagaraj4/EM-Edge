<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--ORPlaceOrdersForOthPractAddModifyMiddle.jsp -->
<%@page contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes start --%>
<%@page  import="eOR.*,eOR.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
<%
 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String function_id = request.getParameter( "function_id" ) ;

%>
<html>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eOR/js/ORPlaceOrdersForOthPract.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrCommon.js"></script>
 	<script language="JavaScript"> function_id = "<%=function_id%>"</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<STYLE TYPE="text/css">

	A:active { 
		COLOR: black; 
	}

	A:visited { 
		COLOR: black; 
	}
	A:link { 
		COLOR: black; 
	}
 	</STYLE>

</head><body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >

<%
	/* Mandatory checks start */
	String mode				=	request.getParameter( "mode" ) ;
	String type				=	request.getParameter( "type" ) ;
	String disp_label		= "";
	if(type == null)type = "";
	type = type.trim();
	
	if(type.equals("P"))
	{
		disp_label = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
	}
	else if(type.equals("R"))
	{
		disp_label = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.responsibility.label","common_labels");
	}
	else if(type.equals("T"))
	{
		disp_label = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionertype.label","common_labels");
	}
	

	String bean_id = "Or_PlaceOrdersForOthPractBean" ;
	String bean_name = "eOR.PlaceOrdersForOthPractBean";

/* Mandatory checks end */
	
	/* Initialize Function specific start */
	PlaceOrdersForOthPractBean bean = (PlaceOrdersForOthPractBean)getBeanObject( bean_id, bean_name , request ) ;  
	bean.clear() ;
	bean.setMode( mode ) ;
	bean.setAllowedType(type);
%>
<form name='place_order_pract_middle' id='place_order_pract_middle' target='messageFrame' >

	<%
	if(type.equals("P") || type.equals("R"))
	{
	%>
	<table cellpadding=0 cellspacing=0 border=0 width="100%">
	<tr><td colspan='2' class='label'><%=disp_label%></td></tr>
	<tr>
		<td colspan='2' align='left'>
		<tr>
			<td colspan='2' align='left'>
				<table align='left' cellspacing='0' cellpadding='0' width="30%" border='1'>
					<tr>
						<td align="center" id="SelectTab" class="clicked" width="15%" height="20"><a href='javascript:dispLink("S")'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></a></td>
						<td align="center" id="AssociateTab" class="normal" width="15%" height="20"><a href='javascript:dispLink("A")'><fmt:message key="Common.Associate.label" bundle="${common_labels}"/></a></td>
					</tr>
				</table>
			</td>
		</tr> 
		</td>
	</tr>
	<tr>
		<td colspan='2' align='left' id='linkId' >
		<jsp:include page="OrCommonAlphaLink.jsp" flush="true"/>
		</td>
	</tr>
	<%
	}
	else
	{
	%>
	<table class='grid' width="100%">
	<tr>
	<th class="columnheader" style="text-align:left;"><fmt:message key="Common.practitionertype.label" bundle="${common_labels}"/></th>
		<th class="columnheader" style="text-align:left;"><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
	</tr>
	<%
		ArrayList practTypes = (ArrayList) bean.getPractTypes();
		ArrayList selectedPractTypes = (ArrayList) bean.getSelectedPractTypes(type);
		String[] practRecords = null;
		String classValue = "";
		String checked = "";
		for(int i=0; i<practTypes.size(); i++)
		{
			practRecords = (String [])practTypes.get(i);
			if(i%2==0)
			{
				classValue = "gridData";
			}
			else
			{
				classValue = "gridData";
			}
			%>
			<tr>
				<td class='<%= classValue %>' align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=practRecords[1]%>
				</td>
				<td class='<%= classValue %>' align="center">
				<%
					if(selectedPractTypes.contains(practRecords[0]))
					{
						checked = "CHECKED";
					}
					else
					{
						checked = "";
					}
				%>
					<input type=checkbox name="pract_type<%=i%>" id="pract_type<%=i%>" value="<%=practRecords[0]%>" <%=checked%>>
				</td>
			</tr>
	<%
		}
		%>
		<input type="hidden" name="tot_count" id="tot_count" value="<%=practTypes.size()%>">
	<%
	}
	%>
</table>
   <input type="hidden" name="allowed_type" id="allowed_type" value="<%=type%>">
   <input type="hidden" name="tabVal" id="tabVal" value="">
   <input type="hidden" name="mode" id="mode" value="<%=mode%>">
   <input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
</form>

</body>
</html>		
<%
putObjectInBean( bean_id, bean , request) ;  
%>


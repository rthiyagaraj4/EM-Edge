<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page import="eOR.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%@page import="java.util.ArrayList" %>
<%@page contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>
<head><title>MultiPatientOrdersResultingHdr</title>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/dchk.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script><!-- used for date validation-->
	
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>	
	<script language="JavaScript" src="../../eOR/js/ORMultiPatientOrdersResultingReport.js"></script>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	<STYLE TYPE="text/css">
	
	A:active { 
		COLOR: white; 
	}

	A:visited { 
		COLOR: white; 
	}
	A:link { 
		COLOR: white; 
	}
 	</STYLE>
</head>



<%
	/* Mandatory checks start */
	String mode	   = request.getParameter( "mode" ) ;
	String bean_id = "Or_MultiPatientOrdersResulting" ;
	String bean_name = "eOR.MultiPatientOrdersResultingBean";
	String facility_id = (String)session.getValue("facility_id");

	/* Initialize Function specific start */
	MultiPatientOrdersResultingBean bean = (MultiPatientOrdersResultingBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);
	bean.clear() ;
	bean.setMode( mode ) ;
	
	String location_type = request.getParameter("location_type");
	String locn = request.getParameter("locn");
	String period_from = request.getParameter("period_from");
	String period_to = request.getParameter("period_to");
	String order_category = request.getParameter("order_category");
	String order_type = request.getParameter("order_type");
	String result_format = request.getParameter("result_format");
	String order_catalog = request.getParameter("order_catalog");
	String group_by = request.getParameter("group_by");
	
	if(order_type==null || order_type.equals("") || order_type.equals("null"))
	{
		order_type = "";
	}

	ArrayList resultFormatRecords = (ArrayList)bean.getResultFormatting(period_from,period_to,order_category,order_type,order_catalog,facility_id,location_type,locn.trim());
	int result_format_count = resultFormatRecords.size();
	if(result_format_count==0)
	{
	%>
		<script>
		parent.multiPatientOrdersResultingHdrDtl.location.href="../../eCommon/html/blank.html";
		</script>
	<%
	}
%>
<body onload='FocusFirstElement()'  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="multiPatientOrdersResultingHdrDtl" id="multiPatientOrdersResultingHdrDtl">
<table cellpadding=3 cellspacing=0 border='0' width='100%'>
<TR>
<%
if(resultFormatRecords.size() > 0)
{
	int count = 0;
	for(int i=0; i<resultFormatRecords.size(); i++)
	{
		if(!(i > 2))
		{
			String records[] = (String[])resultFormatRecords.get(i);
			
			if((result_format!=null && !result_format.equals("") && result_format.equals(records[0])) ||(result_format.equals("") && count==0))
			{
				count++;
				result_format = records[0];

			%>
			<TD width="20%" class="CASECONDSELECTHORZ" align="left" id="tab<%=i%>" onClick="loadResultFrame('<%=records[0]%>','<%=i%>','<%=records[2]%>')">
				<a href="#" ><%=records[1]%></a>
			</TD>
			<%
			}
			else
			{
			%>
			<TD width="20%" class="CAFIRSTSELECTHORZ" align="left" id="tab<%=i%>" onClick="loadResultFrame('<%=records[0]%>','<%=i%>','<%=records[2]%>')">
				<a href="#"><%=records[1]%></a>
			</TD>
		<%	
			}
		}
	}

	if(resultFormatRecords.size() > 3)
	{
	%>
		<TD width="14%" class="label">
			&nbsp;&nbsp;<fmt:message key="eOR.OtherResultFormats.label" bundle="${or_labels}"/>
		</TD>
		<TD class='label'> 
			<SELECT name="result_format" id="result_format" onChange="callLoadResultFrame(this);">
				<option value="">&nbsp;&nbsp;--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--&nbsp;&nbsp;</option>
			<%
			for(int i=3;i<resultFormatRecords.size(); i++)
			{
				String records[] = (String[])resultFormatRecords.get(i);
				if(!result_format.equals("") && result_format.equals(records[0]))
				{
			%>
					<option value="<%=records[0]%>::<%=i%>::<%=records[2]%>" selected><%=records[1]%></option>
			<%
				}
				else
				{
				%>
					<option value="<%=records[0]%>::<%=i%>::<%=records[2]%>"><%=records[1]%></option>
				<%
				}
			}
			%>
			</SELECT>
		</TD>
	<%
	}
	else if(resultFormatRecords.size()<3)
	{
	%>
		<TD class="label">&nbsp;</TD>
	<%
	}
}
%>
</TR>
<input type="hidden" name="location_type" id="location_type" value="<%=location_type%>">
<input type="hidden" name="locn" id="locn" value="<%=locn%>">
<input type="hidden" name="period_from" id="period_from" value="<%=period_from%>">
<input type="hidden" name="period_to" id="period_to" value="<%=period_to%>">
<input type="hidden" name="order_category" id="order_category" value="<%=order_category%>">
<input type="hidden" name="order_type" id="order_type" value="<%=order_type%>">
<input type="hidden" name="order_catalog" id="order_catalog" value="<%=order_catalog%>">
<input type="hidden" name="group_by" id="group_by" value="<%=group_by%>">
<input type="hidden" name="result_format_count" id="result_format_count" value="<%=result_format_count%>">
<input type='hidden' name='localeName' id='localeName' value='<%=localeName%>'>
</form>
</body>
</html>

<%
	// set it back persistence
	//putObjectInBean(bean_id,bean,request);
%>


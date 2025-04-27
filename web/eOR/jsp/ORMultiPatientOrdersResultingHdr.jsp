<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page import="eOR.*,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
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
	String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/dchk.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script><!-- used for date validation-->
	
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
	<script language="JavaScript" src="../../eOR/js/ORMultiPatientOrdersResultingReport.js"></script>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrCommonFunction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	<SCRIPT>
		function validateDateWithTime(obj)
		{
			if(!doDateTimeChk(obj))
			{
				if(obj.value!='')
				{
					alert(getMessage("INVALID_DATE_TIME","SM"));
					obj.focus();
					return false;
				}
			}
		}
	</SCRIPT>
</head>

<body onload='FocusFirstElement()'  onMouseDown="CodeArrest()" onKeyDown="lockKey()">

<%
	String bean_id = "Or_MultiPatientOrdersResulting" ;
	String bean_name = "eOR.MultiPatientOrdersResultingBean";
	
	
	/* Initialize Function specific start */
	MultiPatientOrdersResultingBean bean = (MultiPatientOrdersResultingBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);
	bean.clear() ;

	

	String header_values = request.getParameter("header_values");
	String result_format_value = request.getParameter("result_format");
	String result_type = request.getParameter("result_type");
	

	String header_location_type			= "";
	String header_locn					= "";
	String header_locn_index			= "";
	String header_period_from			= "";
	String header_period_to				= "";
	String header_order_category		= "";
	String header_order_type			= "";
	String header_order_catalog			= "";
	String header_order_catalog_code	= "";
	String header_result_format_code	= "";
	String header_result_format_desc	= ""; 
	String header_temp_order_catalog	= "";
	String group_by						= "";
	String ivalues						= "";
	int inital_value=1;

	
	if(header_values!=null && !header_values.equals("") && !header_values.equals("null"))
	{
		StringTokenizer st = new StringTokenizer(header_values,"~~~");
		while(st.hasMoreElements())
		{
			header_location_type			= st.nextToken();
			header_locn						= st.nextToken();
			header_period_from				= st.nextToken();
			header_period_to				= st.nextToken();
			header_order_category			= st.nextToken();
			header_order_type				= st.nextToken();
			header_order_catalog			= st.nextToken();
			header_order_catalog_code		= st.nextToken();
			header_temp_order_catalog		= st.nextToken();
			header_result_format_code		= st.nextToken();
			group_by						= st.nextToken();
			header_result_format_desc		= st.nextToken();
			ivalues							= st.nextToken();
			header_locn_index				= st.nextToken();
			header_location_type			= header_location_type.trim();
			header_locn						= header_locn.trim();
			header_period_from				= header_period_from.trim();
			header_period_to				= header_period_to.trim();
			header_order_category			= header_order_category.trim();
			header_order_catalog			= header_order_catalog.trim();
			header_order_catalog_code		= header_order_catalog_code.trim();
			header_result_format_code		= header_result_format_code.trim();
			header_temp_order_catalog		= header_temp_order_catalog.trim();
			ivalues							= ivalues.trim();
			header_locn_index				= header_locn_index.trim();
			header_result_format_desc		= header_result_format_desc.trim();
		}
	}
	

	if(header_period_from.equals("") && header_period_to.equals(""))
	{
		inital_value=0;
		ArrayList sysDate = (ArrayList)bean.getSysDateTime();
		for(int i=0;i<sysDate.size();i++)
		{
			header_period_from =  (String)sysDate.get(0);
			header_period_to =  (String)sysDate.get(1);
		}
	}
	if(!localeName.equals("en")&&(inital_value==0))
	{
		header_period_from = com.ehis.util.DateUtils.convertDate(header_period_from,"DMYHM","en",localeName);
		header_period_to = com.ehis.util.DateUtils.convertDate(header_period_to,"DMYHM","en",localeName);
	}

	ArrayList order_category = (ArrayList)bean.getAllOrderCategory();
%>

<form name="multiPatientOrdersResultingHdr" id="multiPatientOrdersResultingHdr" target='' action=''>
<input type="hidden" name="catalog_lookup_sql" id="catalog_lookup_sql" value="<%=OrRepositoryExt.getOrKeyValue("SQL_OR_MULTI_PATIENT_RESULTING_CATALOG_LOOKUP")%>">
<input type="hidden" name="result_format_lookup_sql" id="result_format_lookup_sql" value="<%=OrRepositoryExt.getOrKeyValue("SQL_OR_MULTI_PATIENT_RESULTING_FORMAT_ITEM_LOOKUP")%>">
<input type="hidden"  name="result_format_value" id="result_format_value" value="<%=result_format_value%>">
<input type="hidden"  name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden"  name="bean_name" id="bean_name" value="<%= bean_name %>">
<input type="hidden"  name="header_location_type" id="header_location_type" value="<%= header_location_type %>">
<input type="hidden"  name="header_locn" id="header_locn" value="<%= header_locn %>">
<input type="hidden"  name="header_locn_index" id="header_locn_index" value="<%= header_locn_index %>">
<input type="hidden"  name="header_result_format_desc" id="header_result_format_desc" value="<%= header_result_format_desc %>">
<input type="hidden"  name="header_period_from" id="header_period_from" value="<%= header_period_from %>">
<input type="hidden"  name="header_period_to" id="header_period_to" value="<%= header_period_to %>">
<input type="hidden"  name="header_order_category" id="header_order_category" value="<%= header_order_category %>">
<input type="hidden"  name="header_order_type" id="header_order_type" value="<%= header_order_type %>">
<input type="hidden"  name="header_order_catalog" id="header_order_catalog" value="<%= header_order_catalog %>">
<input type="hidden"  name="header_order_catalog_code" id="header_order_catalog_code" value="<%= header_order_catalog_code %>">
<input type="hidden"  name="header_result_format_code" id="header_result_format_code" value="<%= header_result_format_code %>">
<input type="hidden"  name="header_temp_order_catalog" id="header_temp_order_catalog" value="<%= header_temp_order_catalog %>">
<input type="hidden"  name="ivalues" id="ivalues" value="<%= ivalues %>">
<input type="hidden"  name="header_group_by" id="header_group_by" value="<%=group_by%>">
<input type="hidden"  name="result_type" id="result_type" value="<%=result_type%>">
<table cellpadding=0 cellspacing=0 border='0' width='100%' align=center >
	<tr>
		<td class='label'  align ='right' width="13%"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
		<td width="1%"></td>
		<td align='left' width="36%"><SELECT name="location_type" id="location_type" onChange="populateLocation(this)">
				<option value="">&nbsp;&nbsp;---<fmt:message key="Common.all.label" bundle="${common_labels}"/>---&nbsp;&nbsp;</option>
				<option value="N"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
				<option value="D"> <fmt:message key="Common.daycare.label" bundle="${common_labels}"/>
				</option>				
			</SELECT>
			
			&nbsp;
			<SELECT name="locn" id="locn" onChange="removeFrames();selectIndex(this);" >
				<option value=""> &nbsp;&nbsp;---<fmt:message key="Common.all.label" bundle="${common_labels}"/>---&nbsp;&nbsp; </option>
			</SELECT>
			<%
			if(header_values==null || header_values.equals("") || header_values.equals("null"))
			{
			%>
				<script>
					defaultLocationType();
				</script>
			<%
			}
			%>

		</td>
		<td class='label' align='right' id='period_td' width="13%"><fmt:message key="eOR.OrderStartPeriod.label" bundle="${or_labels}"/></td>
		<td width="1%"></td>
		<td class=label align=left nowrap colspan="3">
			<input type="text" id ="period_from" name="period_from" id="period_from" value="<%=header_period_from%>" size="16" maxlength="16" onBlur="Validate_DateTimeOfPeriod(this,'DMYHM','<%=localeName%>',period_from,period_to)" onKeyPress='return OrAllowDateHourFormat()' onChange="removeFrames()">
			<img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('period_from',null,'hh:mm');" style='cursor:pointer'>
			<font size="5">-</font> 
			<input type=text id ="period_to" name='period_to' id='period_to' value="<%=header_period_to%>" size="16" maxlength="16" onBlur="Validate_DateTimeOfPeriod(this,'DMYHM','<%=localeName%>',period_from,period_to)" onKeyPress='return OrAllowDateHourFormat()' onChange="removeFrames()">
			<img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('period_to',null,'hh:mm');" style='cursor:pointer'>
			<img src="../../eCommon/images/mandatory.gif">
		</td>
	</tr>
	<TR>
		<td class='label'  align ='right' width="13%"><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></td>
		<td width="1%"></td>
		<td align='left' width="36%" >
			<select name="order_category" id="order_category" onChange="fillOrderTypes(this);" onclick="chkSetup('<%=order_category.size()%>')">
				<option value="">&nbsp;&nbsp;--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--&nbsp;&nbsp;</option>
				<%
				if(order_category.size()>0)
				{
					for(int i=0;i<order_category.size();i++)
					{
						String[] orderCategory = (String[])order_category.get(i);
					%>
					<option value="<%=orderCategory[0]%>" ><%=orderCategory[1]%></option>
				<%  }
				}				
				%>
			</select>
			<img src="../../eCommon/images/mandatory.gif">
		</TD>
		<td class='label'  align ='right' width='13%'><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></TD>
		<td width="1%"></td>
		<td align='left' class=label nowrap colspan="3">
			<SELECT name="order_type" id="order_type" onChange="clearFields();removeFrames();">
				<option value=""> &nbsp;&nbsp;---<fmt:message key="Common.all.label" bundle="${common_labels}"/>---&nbsp;&nbsp; </option>
		</td>
	</TR>
	<TR>
		<td class='label'  align ='right' width="13%"><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></td>
		<td width="1%"></td>
		<td align='left' width="36%" id="ordcat">
			<input type="text" name="order_catalog" id="order_catalog" value="" size="15" maxlength="25"
			onBlur="before_show_catalog_lookup(this,order_catalog_code,temp_order_catalog);" onChange="removeFrames()"><input type='button' class="button" name="catalog_button" id="catalog_button" value="?" onClick="show_catalog_lookup(order_catalog,order_catalog_code,temp_order_catalog)">
				<input type="hidden" name='order_catalog_code' id='order_catalog_code' value="">
				<input type="hidden" name="temp_order_catalog" id="temp_order_catalog" value="">
		</td>
		<td class='label'  align ='right' width='13%'><fmt:message key="eOR.ResultFormat.label" bundle="${or_labels}"/>
		</td>
		<td width="1%"></td>
		<td class=label align='left' nowrap colspan="3">
			<input type="text" name="result_format" id="result_format" value="" size="15" maxlength="25"
			onBlur="before_show_resultFormat_lookup(this,order_resultFormat_code,temp_resultFormat);" onChange="removeFrames()"><input type='button' class="button" name="resultFormat_button" id="resultFormat_button" value="?" onClick="show_resultFormat_lookup(result_format,order_resultFormat_code,temp_resultFormat)">
			<input type=hidden name='order_resultFormat_code' id='order_resultFormat_code' value="">
				<input type="hidden" name="temp_resultFormat" id="temp_resultFormat" value="">
		</td>
	</TR>
	<tr>
		<td class='label'  align ='right'><fmt:message key="Common.groupby.label" bundle="${common_labels}"/>
		</td>
		<td width="1%"></td>
		<td align='left'>
			<SELECT name="group_by" id="group_by" onChange="removeFrames()">
				<option value="O"><fmt:message key="eOR.OrderStartDate.label" bundle="${or_labels}"/></option>
				<option value="P"><fmt:message key="Common.patient.label" bundle="${common_labels}"/></option>
				<option value="C"><fmt:message key="Common.catalog.label" bundle="${common_labels}"/></option>
				<option value="L"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></option>
			</SELECT>
		</td>
		<td id="result_check_boxes"></td>
		<td width="1%"></td>
		<td class='button'  align ='right'>
			<input type="button" class="button" name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="searchValues()">
			<input type="button" class="button" name="cancel" id="cancel" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick="clearValues()">
		</td>
	</tr>
</table>
<%
if(header_values!=null && !header_values.equals("") && !header_values.equals("null"))
{
%>
	<script>
		loadMainScreenData();
	</script>
<%
}if(!imgUrl.equals("")){
%>
<img src='<%=imgUrl%>' width='100%' height='15'/> 
<%}%>
<input type='hidden' name='localeName' id='localeName' value='<%=localeName%>'>
<input type="hidden"  name="header_period_from_valid" id="header_period_from_valid" value="<%= header_period_from %>">
<input type="hidden"  name="header_period_to_valid" id="header_period_to_valid" value="<%= header_period_to %>">
</form>
</body>
</html>

<%
	// set it back persistence
	putObjectInBean(bean_id,bean,request);
%>


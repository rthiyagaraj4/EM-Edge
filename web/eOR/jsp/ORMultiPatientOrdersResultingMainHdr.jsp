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
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>	
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
	<script language="JavaScript" src="../../eOR/js/OrCommonFunction.js"></script>
	<script language="JavaScript" src="../../eOR/js/ORMultiPatientOrdersResultingReport.js"></script>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	<script>
	function checkValid(obj,event,val1,val2) 
	{
		if (event.keyCode == 13) 
		{
			event.keyCode = "";
			return;
		} 
		else 
		{
			return allowValidNumber(obj,event,val1,val2);
		}
	} 
	</script>
</head>

<body onload='FocusFirstElement()'  onMouseDown="CodeArrest()" onKeyDown="lockKey()">

<%
	/* Mandatory checks start */
	String mode	   = "2";

	String bean_id = "Or_MultiPatientOrdersResulting" ;
	String bean_name = "eOR.MultiPatientOrdersResultingBean";

	/* Initialize Function specific start */
	MultiPatientOrdersResultingBean bean = (MultiPatientOrdersResultingBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);
	bean.clear() ;
	bean.setMode( mode ) ;
	
	String clinician_id  = (String)session.getValue("ca_practitioner_id");


	String queryString = request.getQueryString();

	String result_format = request.getParameter("result_format");
	String total_records_count = request.getParameter("count");
	String main_result_type = request.getParameter("result_type");
	String header_values = request.getParameter("header_values");	
	ArrayList discrete_measures_list = (ArrayList)bean.getDiscreteMeasures(result_format,main_result_type);
	int records_size = discrete_measures_list.size();
	String discrete_measure_id = "";
	String description = "";
	String unit_of_measure = "";
	String result_type = "";
	String max_digits = "0";
	String min_digits = "0";
	String dec_digits = "0";
	String mandatory = "";
	int max_length = 0;
	String num_crit_low_points = "0";
	String num_crit_high_points = "0";
	String num_crit_low = "0";
	String num_crit_high = "0";
	String default_value = "0";

	String[] record = null;


ArrayList listResults = null;
String[] records = null;
String text_area_exists = "false"; 
%>

<form name="multiPatientOrdersResultingMainHdr" id="multiPatientOrdersResultingMainHdr" target='' action='' method='POST'>
<input type="hidden" name="result_format" id="result_format" value="<%=result_format%>">
<input type="hidden" name="main_result_type" id="main_result_type" value="<%=main_result_type%>">
<table style="display:none">
<tr>
	<td id="hidden_params">
		&nbsp;
	</td>
</tr>
</table>
<table cellpadding=0 cellspacing=0 border='0' width='100%' align=center >
	<TD colspan="4" align="left">&nbsp;&nbsp;
	<fmt:message key="eOR.DefaultResultValues.label" bundle="${or_labels}"/>
	</TD>
	<%
	for(int i=0;i<discrete_measures_list.size();i++)
	{
		record = (String[])discrete_measures_list.get(i);
		discrete_measure_id = bean.checkForNull(record[0]);
		description = bean.checkForNull(record[1]);
		unit_of_measure = bean.checkForNull(record[6]);
		if(unit_of_measure==null || unit_of_measure.equals(""))
			unit_of_measure = "";
		result_type = bean.checkForNull(record[2]);
		max_digits = bean.checkForNull(record[3]);
		min_digits = bean.checkForNull(record[4]);
		dec_digits = bean.checkForNull(record[5]);
		/*if(max_digits==null || max_digits.equals(""))
			max_digits = "1";

		if(min_digits==null || min_digits.equals(""))
			min_digits = "0";
		
		if(dec_digits==null || dec_digits.equals(""))
			dec_digits = "0";*/


		/*if(dec_digits.equals("0"))
		{
			max_length = Integer.parseInt(max_digits) + Integer.parseInt(dec_digits);
			out.println("max_length:1::::"+max_length);
		}
		else
		{
			max_length = Integer.parseInt(max_digits) + Integer.parseInt(dec_digits) + 1;
			out.println("max_length:2:::"+max_length);
		}*/

		if(result_type.trim().equalsIgnoreCase("N") ||result_type.trim().equalsIgnoreCase("I"))
		{
			max_length = 1;
			if(max_digits==null || max_digits.trim().equals(""))
				max_digits = "20";
			if(dec_digits.equals("") || dec_digits.equals("0")) 
			{
				max_length = Integer.parseInt(max_digits);
				dec_digits = "0";
			} 
			else 
			{
				max_length = Integer.parseInt(max_digits) + 1;										
			}
		}
		
		mandatory = bean.checkForNull(record[7]);
		
		if(result_type.equals("N") || result_type.equals("I"))
		{
			num_crit_low_points		= bean.checkForNull(record[8]);
			num_crit_high_points		= bean.checkForNull(record[9]);
			num_crit_low						= bean.checkForNull(record[10]);
			num_crit_high					= bean.checkForNull(record[11]);
			default_value						= bean.checkForNull(record[12]);			
		}

	%>
	<input type="hidden" name="discrete_measure_id<%=i%>" id="discrete_measure_id<%=i%>" value="<%=discrete_measure_id%>">
	
	<input type="hidden" name="unit_of_measure<%=i%>" id="unit_of_measure<%=i%>" value="<%=unit_of_measure%>">
	<input type="hidden" name="result_type<%=i%>" id="result_type<%=i%>" value="<%=result_type%>">
	<input type="hidden" name="max_digits<%=i%>" id="max_digits<%=i%>" value="<%=max_digits%>">
	<input type="hidden" name="min_digits<%=i%>" id="min_digits<%=i%>" value="<%=min_digits%>">
	<input type="hidden" name="dec_digits<%=i%>" id="dec_digits<%=i%>" value="<%=dec_digits%>">
	<input type="hidden" name="default_value<%=i%>" id="default_value<%=i%>" value="<%=default_value%>">
	<input type="hidden" name="max_length<%=i%>" id="max_length<%=i%>" value="<%=max_length%>">
	<input type="hidden" name="mandatory<%=i%>" id="mandatory<%=i%>" value="<%=mandatory%>">
	<input type="hidden" name="num_crit_low_points<%=i%>" id="num_crit_low_points<%=i%>" value="<%=num_crit_low_points%>">
	<input type="hidden" name="num_crit_high_points<%=i%>" id="num_crit_high_points<%=i%>" value="<%=num_crit_high_points%>">
	<input type="hidden" name="num_crit_low<%=i%>" id="num_crit_low<%=i%>" value="<%=num_crit_low%>">
	<input type="hidden" name="num_crit_high<%=i%>" id="num_crit_high<%=i%>" value="<%=num_crit_high%>">

	<input type="hidden" name="srv_stat<%=i%>" id="srv_stat<%=i%>" value="N">

	<%
	if( i%2 ==0 || i==0)
	{
	%>
	<TR>
	<%
	}
	%>
		<TD width="15%" class="label" align="right">
			&nbsp;<%=description%>
			<%

			if(result_type.equals("N") || result_type.equals("I"))
			{
				if(unit_of_measure!=null && !unit_of_measure.equals(""))
					out.println("("+unit_of_measure+")");
			}
			if(mandatory.equals("Y"))
			{
			%><img src="../../eCommon/images/mandatory.gif">
			<%
			}
			%>
			&nbsp;
		
		</TD>
		<%
		//description = description.replaceAll("#","hash");
		//description = description.replaceAll("&","ampersand");
		%>
		<input type="hidden" name="discrete_measure_desc<%=i%>" id="discrete_measure_desc<%=i%>" value="<%=description%>">
		<TD width="20%" class="label" align="left">
			<%
			
			if(result_type.equals("L"))
			{
				listResults = (ArrayList)bean.getListTypeValues(discrete_measure_id);
			%>
			<input type=hidden name="list_type<%=discrete_measure_id%>" id="list_type<%=discrete_measure_id%>" value="<%=listResults.size()%>">
			<SELECT name="list_type<%=i%>" id="list_type<%=i%>">
				<option value="">--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</OPTION>
				<%
				for(int k=0;k<listResults.size();k++)
				{
					records = (String[]) listResults.get(k);
					%>
						<option value="<%=records[0]%>"><%=records[0]%></OPTION>
					<%
				}
				%>
			</SELECT>
				<%
				for(int k=0;k<listResults.size();k++)
				{
					records = (String[]) listResults.get(k);
					%>
					<input type="hidden" name="list_type<%=discrete_measure_id%><%=k%>" id="list_type<%=discrete_measure_id%><%=k%>" value="<%=records[0]%>">
					<%
				}
				%>
			<%
			}
			else if(result_type.equals("F"))
			{
				text_area_exists = "true";
			%>
			<TEXTAREA ROWS="3" COLS="25" name="long_text_type<%=i%>" id="long_text<%=i%>" onBlur="checkMaxLimit(this,2000)"></TEXTAREA>
			<%
			}
			else if(result_type.equals("N") || result_type.equals("I"))
			{
			%>	
			<input type="text" name="number_type<%=i%>" id="number_type<%=i%>" value="<%=default_value%>" onKeyPress="return checkValid(this,window.event,<%=max_digits%>,<%=dec_digits%>)" onBlur="checkNumericResult(<%=i%>);OrIsValidDecimal(this)" maxLength="<%=max_length%>">
			<%
			}
			else if(result_type.equals("C"))
			{
			%>
			<input type="checkbox" name="check_type<%=i%>" id="check_type<%=i%>" value="">
			<%
			}
			else if(result_type.equals("E"))
			{				
			%>
			<input type="text" name="date_hour_type<%=i%>" id="date_hour_type<%=i%>" value="" size="14" maxlength="16" onBlur="validDateObj1(this,'DMYHM','<%=localeName%>')" onKeyPress='return OrAllowDateHourFormat()' >
			<img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('date_hour_type<%=i%>',null,'hh:mm');" style='cursor:pointer'>
			<%
			}
			else if(result_type.equals("D"))
			{
			%>
			<input type="text" name="date_type<%=i%>" id="date_type<%=i%>" value="" size="10" maxlength="10" onBlur="CheckDate(this)" onchange="" onKeyPress='return OrAllowDateFormat()'>
			<img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('date_type<%=i%>');" style='cursor:pointer'>
			<%
			}
			else if (result_type.equals("T"))
			{
			%>
			<input type="text" name="time_type<%=i%>" id="time_type<%=i%>" value="" size="10" maxlength="5" onkeypress="return CheckForSpecChars(event)" onBlur="checkTime(this)">
			<%
			}
			else if (result_type.equals("H"))
			{
			%>
			<input type="text" name="short_text_type<%=i%>" id="short_text_type<%=i%>" value="" size="30" maxlength="200">
			<%
			}
			%>
			<input type="hidden" name="old_data_value<%=i%>" id="old_data_value<%=i%>" value="">
		</TD>
	<%
	if( i%2 == 1 || (i+1) == discrete_measures_list.size())
	{
		if((i+1) == discrete_measures_list.size() && discrete_measures_list.size() % 2 !=0)
		{
		%>
		<TD colspan="2">&nbsp;</TD>
		<%
		}
		%>
	</TR>
	<%
	}
	}
	%>
	
	<input type="hidden" name="total_values" id="total_values" value="<%=discrete_measures_list.size()%>">
	<input type="hidden" name="total_records_count" id="total_records_count" value="<%=total_records_count%>">
	<input type="hidden" name="header_values" id="header_values" value='<%=header_values%>'>
	<input type="hidden" name="bean_id" id="bean_id" value='<%=bean_id%>'>
	<input type="hidden" name="bean_name" id="bean_name" value='<%=bean_name%>'>
	<input TYPE="hidden" name="mode" id="mode" value="<%=mode%>">
	<input TYPE="hidden" name="clinician_id" id="clinician_id" value="<%=clinician_id%>">
	<input TYPE="hidden" name="srv_status" id="srv_status" value="Normal">
	<input TYPE="hidden" name="rslt_type" id="rslt_type" value="">

</table>
<SCRIPT>
	setFrameSizes('<%=records_size%>','<%=text_area_exists%>');
	loadResultingMainResult0("<%=queryString%>","<%=text_area_exists%>");
</SCRIPT>
<input type='hidden' name='localeName' id='localeName' value='<%=localeName%>'>
</form>
</body>
</html>

<%
	// set it back persistence
	putObjectInBean(bean_id,bean,request);
%>


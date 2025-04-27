<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>

<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 

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
	<link rel="StyleSheer" type="text/css" href="../../eCommon/html/CommonCalendar.css"/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/messages.js"></script>
 	<script language="JavaScript" src="../js/ViewResults.js"></script>
	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >

<%
	
	String mode					= request.getParameter( "mode" ) ;
	String bean_id				= "Or_ViewResults" ;
	String bean_name			= "eOR.ViewResults";
	Properties properties		= (Properties)session.getValue("jdbc");
	String practitioner_id		= (String)session.getValue("ca_practitioner_id");
	String resp_id				= (String)session.getValue("responsibility_id");
	String facilityid			= (String) session.getValue("facility_id"); 

	if(resp_id== null)resp_id = "";
	if(practitioner_id == null)practitioner_id = "";


	ViewResults bean			= (ViewResults)getBeanObject( bean_id,  bean_name , request) ;

	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	bean.clear() ;
	bean.setMode( mode ) ;

	String patient_id			= bean.checkForNull(request.getParameter("patient_id"),"");
//	String patient_class		= bean.checkForNull(request.getParameter("patient_class"),"");
	String encounter_id			= (String) request.getParameter("encounter_id");
	String Result_type			= (String) request.getParameter("Result_type");
	if(Result_type == null) Result_type = "";

	int patient_id_length		= 0;
	patient_id_length			= bean.getPatientIdLength();

//	ArrayList EventClass		= new ArrayList();
	ArrayList sysdate			= new ArrayList();
	String curr_week_date		= "";
	String last_week_date		= "";

	sysdate						= (ArrayList)bean.getSysDateTime(properties);

	for(int j=0;j<sysdate.size();j++)
	{
		last_week_date			= (String)sysdate.get(1);
		curr_week_date			= (String)sysdate.get(0);
	}

%>

<form name='view_results_search' id='view_results_search' target='messageFrame' >
<table cellpadding=0 cellspacing=0 border=0 width="98%" align=center>

<tr>
		<td class='label' align="right" nowrap>Period From</td>
		<td align="left">&nbsp;<input type="text" size="10" maxlength="10" value="<%=last_week_date%>" name="period_from" onKeyPress="return OrAllowDateFormat();" onBlur="CheckDate(this);checkWithSysDate(this);checkDateRange(this,period_to);">
		<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendarValidate('period_from');" style='cursor:pointer'>&nbsp;
		<img src="../../eCommon/images/mandatory.gif"></img>
		</td>

		<td class="label" align="right" nowrap>Period To</td>
		<td align="left">&nbsp;<input type="text" name="period_to" id="period_to" value="<%=curr_week_date%>" size="10" maxlength="10" onBlur="CheckDate(this);checkWithSysDate(this);checkDateRange(period_from,this);" onKeyPress="return OrAllowDateFormat();" >
		<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendarValidate('period_to');" style='cursor:pointer'>
		<img src="../../eCommon/images/mandatory.gif"></img>
		</td>
		
		<td class=label align='right' nowrap>&nbsp;Normalcy Indicator</td>
		<td colspan='3'>&nbsp;<SELECT name="normalcy_ind" id="normalcy_ind">
				<option value='*'> -------- Select --------</option>
				<option value='N' selected >Normal</option>
				<option value='A'>Abnormal</option>
				<option value='C'>Critically Abnormal </option>
			</SELECT>
		</td>
	</tr>
	<tr>
		
		<td class=label align='right' nowrap>&nbsp;Result Type</td>
		<td>&nbsp;<SELECT name="result_type" id="result_type">
			<option value="" <%=Result_type.equals("")?"selected":""%>>All</option>
			<option value="BLTF" <%=Result_type.equals("BLTF")?"selected":""%>>Blood Transfusion</option>
			<option value="LBIN" <%=Result_type.equals("LBIN")?"selected":""%>>Laboratory</option>
			<option value="RDIN" <%=Result_type.equals("RDIN")?"selected":""%>>Radiology</option>
			<option value="TRET" <%=Result_type.equals("TRET")?"selected":""%>>Treatment</option>
			<option value="PTCR" <%=Result_type.equals("PTCR")?"selected":""%>>Patient Care</option>
			</SELECT>
		</td>
		
		<TD class='label' align='right' nowrap>Order By</TD>
		<TD>&nbsp;<Select name='group_by' id='group_by'>
		<Option value='E'>Event</Option>
		<Option value='P'>Date</Option>
		</Select></TD>
		<td align="right" class='label' nowrap>Limited to Current Encounter</td>
		<td align="left" class='label'>&nbsp;<input type="checkbox" name="encounter_chk" id="encounter_chk" checked onclick="setCheck()"><td>
	</tr>
	<tr>
		<td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>
		<td colspan=2 align="right"><input type=button name='search_btn' id='search_btn' class='button' value='Search' onClick='populateValues()'>&nbsp;<input type=button name='clear' id='clear' class='button' value='Clear' onClick='clearValues()'>&nbsp;&nbsp;</td>
	</tr>
</table>

<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
<input type="hidden" name="function_id" id="function_id" value="<%//=bean.getFunctionId()%>">
<input type='hidden' name='encounter_id' id='encounter_id' value='<%=encounter_id%>'>
<input type='hidden' name='patient_id' id='patient_id' value='<%=patient_id%>'>
<input type='hidden' name='sys_date' id='sys_date' value='<%=curr_week_date%>'>
<input type='hidden' name='facilityid' id='facilityid' value='<%=facilityid%>'>
<input type='hidden' name='selectmode' id='selectmode' value=''>

<%
	if (!patient_id.equals(""))
	{
%>
		<Script>populateValues();</Script>
<%
	}
%>
</form>

<%
	putObjectInBean(bean_id,bean,request);
%>

</body>
	<script>populateValues();</script>
</html>

